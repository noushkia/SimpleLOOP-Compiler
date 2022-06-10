package main.visitor.codeGenerator;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.EachStmt;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.Visitor;
import main.visitor.typeChecker.ExpressionTypeChecker;

import java.io.*;
import java.util.ArrayList;

public class CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker;
    Graph<String> classHierarchy;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<VariableDeclaration> globalVars;
    private String outputPath;
    private FileWriter currentFile;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;

    private int dimLvl = 0;

    private boolean inMain = false;

    private int lastSlot = -1;
    private int lastLabel = 0;
    private String nextLabel;

    public CodeGenerator(Graph<String> classHierarchy) {
        this.globalVars = new ArrayList<>();
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
        this.prepareOutputFolder();
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String arrayClassPath = "utilities/codeGenerationUtilityClasses/Array.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(arrayClassPath, this.outputPath + "Array.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            this.currentFile = fileWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String makeTypeSignature(Type t) {
        if (t instanceof IntType)
            return "Ljava/lang/Integer;";
        else if (t instanceof BoolType)
            return "Ljava/lang/Boolean;";
        else if (t instanceof ArrayType)
            return "LArray;";
        else if (t instanceof FptrType)
            return "LFptr;";
        else if (t instanceof ClassType)
            return "L" + ((ClassType) t).getClassName().getName() + ";";
        else if (t instanceof NullType || t instanceof VoidType)
            return "V";

        return null;
    }

    private String checkcastType(Type t) {
        if (t instanceof IntType)
            return "java/lang/Integer";
        else if (t instanceof BoolType)
            return "java/lang/Boolean";
        else if (t instanceof ArrayType)
            return "Array";
        else if (t instanceof FptrType)
            return "Fptr";
        else if (t instanceof ClassType)
            return ((ClassType) t).getClassName().getName();
        else if (t instanceof NullType)
            return "V";

        return null;
    }

    private String makePrimitiveSignature(Type t) {
        if (t instanceof IntType)
            return  "I";
        else if (t instanceof BoolType)
            return "Z";

        return null;
    }

    private void addDefaultConstructor() {
        String className = currentClass.getClassName().getName();
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload_0");
        if (currentClass.getParentClassName() != null)
            addCommand("invokespecial " + currentClass.getParentClassName().getName() + "/<init>()V");
        else
            addCommand("invokespecial java/lang/Object/<init>()V");

        for (FieldDeclaration field : currentClass.getFields()) {
            String fieldName = field.getVarDeclaration().getVarName().getName();
            Type fieldType = field.getVarDeclaration().getType();

            addCommand("aload_0");
            addDefaultValueCommand(fieldType);
            addCommand("putfield " + className + "/" + fieldName + " " + makeTypeSignature(fieldType));
        }
        addCommand("return");
        addCommand(".end method");
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int slotOf(String identifier) {
        if (identifier.equals("")) {
            if (lastSlot == -1)
                lastSlot = currentMethod.getLocalVars().size() + currentMethod.getArgs().size();
            lastSlot++;
            return lastSlot;
        }

        int i = 1;
        for (VariableDeclaration variableDeclaration : globalVars) {
            if (variableDeclaration.getVarName().getName().equals(identifier))
                return  i;
            i++;
        }

        for (ArgPair arg : currentMethod.getArgs()) {
            if (arg.getVariableDeclaration().getVarName().getName().equals(identifier))
                return i;
            i++;
        }
        for (VariableDeclaration localVar : currentMethod.getLocalVars()) {
            if (localVar.getVarName().getName().equals(identifier))
                return i;
            i++;
        }
        return 0;
    }

    private String newLabel() {
        String label = "Label_" + lastLabel;
        lastLabel++;
        return label;
    }

    private void addDefaultValueCommand(Type type) {
        if (type instanceof IntType) {
            addCommand("ldc 0");
            addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
        }
        else if (type instanceof BoolType) {
            addCommand("ldc 0");
            addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
        }
        else if (type instanceof ArrayType) {
            while (dimLvl < ((ArrayType) type).getDimensions().size()) {
                addCommand("new Array");
                addCommand("dup");
                addCommand(((ArrayType) type).getDimensions().get(dimLvl++).accept(this));
            }
            addDefaultValueCommand(((ArrayType) type).getType());
            for (int i = 0; i < dimLvl; i++) {
                addCommand("invokespecial Array/<init>(ILjava/lang/Object;)V");
            }
        }
        else if (type instanceof FptrType) {
            addCommand("aconst_null");
        }
        else if (type instanceof ClassType) {
            addCommand("aconst_null");
        }
    }

    private String castToNonPrimitive(Type type) {
        if (type instanceof IntType) {
            return "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;";
        }
        else if (type instanceof BoolType) {
            return "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;";
        }

        return null;
    }

    private String castToPrimitive(Type type) {
        if (type instanceof IntType) {
            return "invokevirtual java/lang/Integer/intValue()I";
        }
        else if (type instanceof BoolType) {
            return "invokevirtual java/lang/Boolean/booleanValue()Z";
        }

        return null;
    }

    @Override
    public String visit(Program program) {
        globalVars.addAll(program.getGlobalVariables());
        for(ClassDeclaration classDeclaration : program.getClasses()) {
            this.expressionTypeChecker.setCurrentClass(classDeclaration);
            this.currentClass = classDeclaration;
            classDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ClassDeclaration classDeclaration) {
        String name = classDeclaration.getClassName().getName();
        createFile(name);
        addCommand(".class public " + classDeclaration.getClassName().getName());
        String parent = "java/lang/Object";
        if (classDeclaration.getParentClassName() != null)
            parent = classDeclaration.getParentClassName().getName();
        addCommand(".super " + parent);
        addCommand("");

//        for (VariableDeclaration variableDeclaration : globalVars) {
////            variableDeclaration.accept(this);
//            String varName = variableDeclaration.getVarName().getName();
//            Type type = variableDeclaration.getType();
//
//            addCommand(".field " + varName + " " + makeTypeSignature(type));
//        }

        for (FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        addCommand("");

        lastSlot = -1;
        lastLabel = 0;
        if (classDeclaration.getConstructor() != null) {
            currentMethod = classDeclaration.getConstructor();
            expressionTypeChecker.setCurrentMethod(currentMethod);
            currentMethod.accept(this);
        }
        else {
            addDefaultConstructor();
        }
        addCommand("");

        lastSlot = -1;
        lastLabel = 0;
        for (MethodDeclaration method : classDeclaration.getMethods()) {
            currentMethod = method;
            expressionTypeChecker.setCurrentMethod(currentMethod);
            currentMethod.accept(this);
        }

        lastSlot = -1;
        lastLabel = 0;

        return null;
    }

    @Override
    public String visit(ConstructorDeclaration constructorDeclaration) {
        if (currentClass.getClassName().getName().equals("Main")) {
            addStaticMainMethod();
            addCommand("");
        }

        if (!constructorDeclaration.getArgs().isEmpty()) {
            addDefaultConstructor();
            addCommand("");
        }

        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public String visit(MethodDeclaration methodDeclaration) {
        String command = ".method public ";
        if(methodDeclaration instanceof ConstructorDeclaration)
            command += "<init>";
        else
            command += methodDeclaration.getMethodName().getName();
        command += "(";
        for (ArgPair arg : methodDeclaration.getArgs()) {
            command += makeTypeSignature(arg.getVariableDeclaration().getType());
        }
//        System.out.println(command);
        command += ")";
        command += makeTypeSignature(methodDeclaration.getReturnType());
        addCommand(command);
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");


        if(methodDeclaration instanceof ConstructorDeclaration) {
            addCommand("aload_0");
            if (currentClass.getParentClassName() != null)
                addCommand("invokespecial " + currentClass.getParentClassName().getName() + "/<init>()V");
            else
                addCommand("invokespecial java/lang/Object/<init>()V");

            for (FieldDeclaration field : currentClass.getFields()) {
                String fieldName = field.getVarDeclaration().getVarName().getName();
                Type fieldType = field.getVarDeclaration().getType();

                addCommand("aload_0");
                addDefaultValueCommand(fieldType);
                addCommand("putfield " + currentClass.getClassName().getName()
                        + "/" + fieldName + " " + makeTypeSignature(fieldType));
            }
        }

        for (VariableDeclaration variableDeclaration : globalVars)
            variableDeclaration.accept(this);

        for (VariableDeclaration variableDeclaration : methodDeclaration.getLocalVars())
            variableDeclaration.accept(this);

        for (Statement statement : methodDeclaration.getBody())
            statement.accept(this);

        if (!methodDeclaration.getDoesReturn())
            addCommand("return");

        addCommand(".end method");
        return null;
    }

    @Override
    public String visit(FieldDeclaration fieldDeclaration) {
        String name = fieldDeclaration.getVarDeclaration().getVarName().getName();
        Type type = fieldDeclaration.getVarDeclaration().getType();

        addCommand(".field " + name + " " + makeTypeSignature(type));

        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration) {
        int slot = slotOf(variableDeclaration.getVarName().getName());
        Type varType = variableDeclaration.getType();
        if (varType instanceof ArrayType){
            dimLvl = 0;
        }
        addDefaultValueCommand(varType);

        addCommand("astore " + slot);

        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {
        BinaryExpression assignmentExp = new BinaryExpression(assignmentStmt.getlValue(),
                assignmentStmt.getrValue(), BinaryOperator.assign);
        addCommand(";Assign Statement");
        addCommand(assignmentExp.accept(this));
        addCommand("pop");
        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt) {
        for(Statement statement : blockStmt.getStatements())
            statement.accept(this);
        return null;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        ArrayList<String> elsifLabels = new ArrayList<>();
        for (ElsifStmt elsifStmt : conditionalStmt.getElsif()) {
            elsifLabels.add(newLabel());
        }
        String elseLabel = newLabel();
        String afterLabel = newLabel();
        addCommand("; If statement " + conditionalStmt.getLine());
        addCommand(conditionalStmt.getCondition().accept(this));
        if (conditionalStmt.getElsif().size() > 0)
            addCommand("ifeq " + elsifLabels.get(0));
        else
            addCommand("ifeq " + elseLabel);
        conditionalStmt.getThenBody().accept(this);
        addCommand("goto " + afterLabel);

        int i = 0;
        for (ElsifStmt elsifStmt : conditionalStmt.getElsif()) {
            if (i+1 < elsifLabels.size())
                nextLabel = elsifLabels.get(i+1);
            else
                nextLabel = elseLabel;
            addCommand(elsifLabels.get(i) + ":");
            elsifStmt.accept(this);
            addCommand("goto " + afterLabel);
            i += 1;
        }

        addCommand(elseLabel + ":");
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);

        addCommand(afterLabel + ":");

        return null;
    }

    @Override
    public String visit(ElsifStmt elsifStmt) {
        addCommand(elsifStmt.getCondition().accept(this));
        addCommand("ifeq " + nextLabel);
        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public String visit(MethodCallStmt methodCallStmt) {
//        expressionTypeChecker.setIsInMethodCallStmt(true);
//        Type retType = methodCallStmt.getMethodCall().accept(expressionTypeChecker);
//        expressionTypeChecker.setIsInMethodCallStmt(false);
        expressionTypeChecker.setIsInMethodCallStmt(true);
        addCommand(methodCallStmt.getMethodCall().accept(this));
//        if (!(retType instanceof NullType || retType instanceof NoType))
        addCommand("pop");
        expressionTypeChecker.setIsInMethodCallStmt(false);
        return null;
    }

    @Override
    public String visit(PrintStmt print) {
        Type type = print.getArg().accept(expressionTypeChecker);
        addCommand("; Print Statement " + print.getLine());
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        addCommand(print.getArg().accept(this));

        addCommand("invokevirtual java/io/PrintStream/println(" + makePrimitiveSignature(type) + ")V");

        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        Type type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(type instanceof NullType) {
            addCommand("return");
        }
        else {
            addCommand(returnStmt.getReturnedExpr().accept(this));
            if (type instanceof IntType) {
                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            }
            else if (type instanceof BoolType) {
                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
            }
            addCommand("areturn");
        }
        return null;
    }

    @Override
    public String visit(EachStmt eachStmt) {
        String loopStartLabel = newLabel();
        String afterLabel = newLabel();

        if (eachStmt.getList() instanceof RangeExpression) {
            //todo: build range Array
        }
        else {
            //todo: build normal Array
        }
        // int arraySize = arrayType.getDimensions().size();

        int listSlot = slotOf("");
        int iSlot = slotOf("");
        Type memberType = eachStmt.getVariable().accept(expressionTypeChecker);

        addCommand("; Each " + eachStmt.getLine());

        // load list
        addCommand(eachStmt.getList().accept(this));
        addCommand("astore " + listSlot);

        // init
        addCommand("ldc 0 ; temp index");
        addCommand("istore " + iSlot);

        addCommand(loopStartLabel + ":");
        // check cond
        addCommand("iload " + iSlot);
        //addCommand("ldc " + arraySize);
        addCommand("if_icmpge " + afterLabel);

        // assign
        addCommand("; assign each");
        addCommand("aload " + listSlot);
        addCommand("iload " + iSlot);
        addCommand("invokevirtual Array/getElement(I)Ljava/lang/Object;");
        addCommand("checkcast " + checkcastType(memberType));
        addCommand("astore " + slotOf(eachStmt.getVariable().getName()));

        // visit body
        eachStmt.getBody().accept(this);

        addCommand("iinc " + iSlot + " 1");

        addCommand("goto " + loopStartLabel);
        addCommand(afterLabel + ": ; After loop");

        return null;
    }

    @Override
    public String visit(TernaryExpression ternaryExpression) {
        String commands = "";
        String falseLabel = newLabel();
        String afterLabel = newLabel();
        commands += ternaryExpression.getCondition().accept(this);
        commands += "\nifeq " + falseLabel;
        commands += "\n" + ternaryExpression.getTrueExpression().accept(this);
        commands += "\ngoto " + afterLabel;
        commands += "\n" + falseLabel + ":";
        commands += "\n" + ternaryExpression.getFalseExpression().accept(this);
        commands += "\n" + afterLabel + ":";

        return commands;
    }

    @Override
    public String visit(RangeExpression rangeExpression) {
        // Create range array and store it on the stack, check with the size and get the elements
        String commands = "";
        return commands;
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        String commands = "";

        commands += binaryExpression.getFirstOperand().accept(this);
        commands += "\n" + binaryExpression.getSecondOperand().accept(this);
        if (operator == BinaryOperator.add) {
            commands += "\niadd";
        }
        else if (operator == BinaryOperator.sub) {
            commands += "\nisub";
        }
        else if (operator == BinaryOperator.mult) {
            commands += "\nimul";
        }
        else if (operator == BinaryOperator.div) {
            commands += "\nidiv";
        }
        else if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            String trueLabel = newLabel();
            String afterLabel = newLabel();
            if (operator == BinaryOperator.gt)
                commands += "\nif_icmpgt " + trueLabel + " ; binary gt";
            else
                commands += "\nif_icmplt " + trueLabel + " ; binary lt";
            commands += "\nldc 0"; // cond was false
            commands += "\ngoto " + afterLabel;
            commands += "\n" + trueLabel + ":";
            commands += "\nldc 1"; // cond was true
            commands += "\n" + afterLabel + ":";
        }
        else if((operator == BinaryOperator.eq)) {
            String trueLabel = newLabel();
            String afterLabel = newLabel();
            String cmpCommand = "if_a";
            Type type = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            if (type instanceof IntType || type instanceof BoolType)
                cmpCommand = "if_i";

            commands += "\n" + cmpCommand + "cmpeq "  + trueLabel + " ; binary eq";

            commands += "\nldc 0"; // cond was false
            commands += "\ngoto " + afterLabel;
            commands += "\n" + trueLabel + ":";
            commands += "\nldc 1"; // cond was true
            commands += "\n" + afterLabel + ":";

        }
        else if(operator == BinaryOperator.and) {
            String shortCircuitLabel = newLabel();
            String trueLabel = newLabel();
            String afterLabel = newLabel();

            commands = "; logical AND\n";
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "\nifeq " + shortCircuitLabel;
            commands += "\n" + binaryExpression.getSecondOperand().accept(this);
            commands += "\nifne " + trueLabel;
            commands += "\n" + shortCircuitLabel + ":";
            commands += "\nldc 0";
            commands += "\ngoto " + afterLabel;
            commands += "\n" + trueLabel + ":";
            commands += "\nldc 1";
            commands += "\n" + afterLabel + ":";

        }
        else if(operator == BinaryOperator.or) {
            String trueLabel = newLabel();
            String afterLabel = newLabel();

            commands = "; logical OR\n";
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "\nifne " + trueLabel;
            commands += "\n" + binaryExpression.getSecondOperand().accept(this);
            commands += "\nifne " + trueLabel;
            commands += "\nldc 0";
            commands += "\ngoto " + afterLabel;
            commands += "\n" + trueLabel + ":";
            commands += "\nldc 1";
            commands += "\n" + afterLabel + ":";
        }
        else if(operator == BinaryOperator.assign) {
            commands = "";
            Type firstType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            Type secondType = binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            String secondOperandCommands = binaryExpression.getSecondOperand().accept(this);
            if(binaryExpression.getFirstOperand() instanceof Identifier) {
                String name = ((Identifier) binaryExpression.getFirstOperand()).getName();
                commands += secondOperandCommands;
                commands += "\ndup ; keep value on stack"; // value must stay on stack
                String castCmd = castToNonPrimitive(secondType);
                if (castCmd != null)
                    commands += "\n" + castCmd;
                commands += "\nastore " + slotOf(name);
            }
            else if(binaryExpression.getFirstOperand() instanceof ArrayAccessByIndex arrayAccessByIndex) {
                int tempSlot = slotOf("");
                commands += arrayAccessByIndex.getInstance().accept(this);
                commands += "\ndup ; dup list for retrieving from list to put value on stack after assign";
                commands += "\n" + arrayAccessByIndex.getIndex().accept(this);
                commands += "\ndup ; keeping index so we can retrieve value from list";
                commands += "\nistore " + tempSlot;
                commands += "\n" + secondOperandCommands;
                String castCmd = castToNonPrimitive(secondType);
                if (castCmd != null)
                    commands += "\n" + castCmd;
                commands += "\n" + "invokevirtual Array/setElement(ILjava/lang/Object;)V";
                commands += "\niload " + tempSlot;
                commands += "\n" + "invokevirtual Array/getElement(I)Ljava/lang/Object;";
                commands += "\ncheckcast " + checkcastType(secondType);
                castCmd = castToPrimitive(secondType);
                if (castCmd != null)
                    commands += "\n" + castCmd;

            }
            else if(binaryExpression.getFirstOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) binaryExpression.getFirstOperand()).getInstance();
                Type memberType = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectMemberAccess) binaryExpression.getFirstOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);
                if(instanceType instanceof ArrayType) {
                    ArrayType arrayType = (ArrayType) instanceType;

                    int index = 0;
//                    for (ListNameType member : listType.getElementsTypes()) { //finding index
//                        if (memberName.equals(member.getName().getName()))
//                            break;
//                        index++;
//                    }

                    commands += instance.accept(this);
                    commands += "\ndup";
                    commands += "\nldc " + index;
                    commands += "\n" + secondOperandCommands;
                    String castCmd = castToNonPrimitive(secondType);
                    if (castCmd != null)
                        commands += "\n" + castCmd;
                    commands += "\ninvokevirtual Array/setElement(ILjava/lang/Object;)V";
                    commands += "\nldc " + index;
                    commands += "\ninvokevirtual Array/getElement(I)Ljava/lang/Object; ; putting back on stack";
                    commands += "\ncheckcast " + checkcastType(secondType);
                    castCmd = castToPrimitive(secondType);
                    if (castCmd != null)
                        commands += "\n" + castCmd;

                }
                else if(instanceType instanceof ClassType) {
                    commands += instance.accept(this);
                    commands += "\ndup ; to getfield for putting back on stack";
                    commands += "\n" + secondOperandCommands;
                    String castCmd = castToNonPrimitive(secondType);
                    if (castCmd != null)
                        commands += "\n" + castCmd;
                    commands += "\nputfield " + ((ClassType) instanceType).getClassName().getName()
                            + "/" + memberName + " " + makeTypeSignature(secondType);
                    commands += "\ngetfield " + ((ClassType) instanceType).getClassName().getName()
                            + "/" + memberName + " " + makeTypeSignature(secondType) + " ; for putting assign on stack ";
                    castCmd = castToPrimitive(secondType);
                    if (castCmd != null)
                        commands += "\n" + castCmd;
                }
            }
        }
        return commands;
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        UnaryOperator operator = unaryExpression.getOperator();
        String commands = "";

        commands += unaryExpression.getOperand().accept(this);
        if(operator == UnaryOperator.minus) {
            commands += "\nineg";
        }
        else if(operator == UnaryOperator.not) {
            String trueLabel = newLabel();
            String afterLabel = newLabel();
            commands += "\nifne " + trueLabel + " ; not command";
            commands += "\nldc 1"; // bool was false so it should become true
            commands += "\ngoto " + afterLabel;
            commands += "\n" + trueLabel + ":";
            commands += "\nldc 0"; // bool was true
            commands += "\n" + afterLabel + ":";
        }
        else if((operator == UnaryOperator.postdec) || (operator == UnaryOperator.postinc)) {
            commands += "\ndup ; keep old on stack";
            commands += "\nldc 1 ; Unary post";
            if (operator == UnaryOperator.postinc)
                commands += "\niadd";
            else
                commands += "\nisub";

            if(unaryExpression.getOperand() instanceof Identifier) {
                int slot = slotOf(((Identifier) unaryExpression.getOperand()).getName());
//                commands += "\ndup";
                commands += "\n" + castToNonPrimitive(new IntType());
                commands += "\nastore " + slot;
            }
            else if(unaryExpression.getOperand() instanceof ArrayAccessByIndex) {
                int tmpSlot = slotOf("");
//                commands += "\ndup ; listaccessindex unary";
                commands += "\n" + castToNonPrimitive(new IntType());
                commands += "\nastore " + tmpSlot;
                commands += "\n" + ((ArrayAccessByIndex) unaryExpression.getOperand()).getInstance().accept(this);
                commands += "\n" + ((ArrayAccessByIndex) unaryExpression.getOperand()).getIndex().accept(this);
                commands += "\naload " + tmpSlot;
                commands += "\n" + "invokevirtual Array/setElement(ILjava/lang/Object;)V";
            }
            else if(unaryExpression.getOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) unaryExpression.getOperand()).getInstance();
                Type memberType = unaryExpression.getOperand().accept(expressionTypeChecker);
                String memberName = ((ObjectMemberAccess) unaryExpression.getOperand()).getMemberName().getName();
                Type instanceType = instance.accept(expressionTypeChecker);
                if(instanceType instanceof ArrayType) {
                    int tmpSlot = slotOf("");
//                    commands += "\ndup ; list member access unary post";
                    commands += "\n" + castToNonPrimitive(new IntType());
                    commands += "\nastore " + tmpSlot;
                    commands += "\n" + instance.accept(this);
                    int index = 0;
//                    for (ListNameType member : ((ArrayType) instanceType).getElementsTypes()) { //finding index
//                        if (memberName.equals(member.getName().getName()))
//                            break;
//                        index++;
//                    }
                    commands += "\nldc " + index;
                    commands += "\naload " + tmpSlot;
                    commands += "\n" + "invokevirtual Array/setElement(ILjava/lang/Object;)V";
                }
                else if(instanceType instanceof ClassType) {
                    int tmpSlot = slotOf("");
//                    commands += "\ndup ; class member access unary post";
                    commands += "\n" + castToNonPrimitive(new IntType());
                    commands += "\nastore " + tmpSlot;
                    commands += "\n" + instance.accept(this);
                    commands += "\naload " + tmpSlot;
                    commands += "\nputfield " + ((ClassType) instanceType).getClassName().getName()
                            + "/" + memberName + " " + makeTypeSignature(new IntType());
                }
            }
        }
        return commands;
    }

    @Override
    public String visit(ObjectMemberAccess objectMemberAccess) {
        Type memberType = objectMemberAccess.accept(expressionTypeChecker);
        Type instanceType = objectMemberAccess.getInstance().accept(expressionTypeChecker);
        String memberName = objectMemberAccess.getMemberName().getName();
        String commands = "";

        if(instanceType instanceof ClassType) {
            String className = ((ClassType) instanceType).getClassName().getName();
            try {
                SymbolTable classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true)).getClassSymbolTable();
                try {
                    classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + memberName, true);
                    //IS FIELD
                    commands += objectMemberAccess.getInstance().accept(this) + " ; object field access";
                    commands += "\ngetfield " + className + "/" + memberName + " " + makeTypeSignature(memberType);
                    String castCmd = castToPrimitive(memberType);
                    if (castCmd != null)
                        commands += "\n" + castCmd;
                } catch (ItemNotFoundException memberIsMethod) {
                    //IS METHOD (new instance of Fptr)
                    commands += "\nnew Fptr" + " ;object method access";
                    commands += "\ndup";
                    commands += "\n" + objectMemberAccess.getInstance().accept(this);
                    commands += "\nldc \"" + memberName + "\"";
                    commands += "\ninvokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V";
                }
            } catch (ItemNotFoundException classNotFound) {
            }
        }
        else if(instanceType instanceof ArrayType) {
            ArrayType arrayType = (ArrayType) instanceType;
            int index = 0;
//            for (ArrayType member : arrayType.getElementsTypes()) { //finding index
//                if (memberName.equals(member.getName().getName()))
//                    break;
//                index++;
//            }
            commands += objectMemberAccess.getInstance().accept(this) + " ;Array member access";
            commands += "\nldc " + index;
            commands += "\ninvokevirtual Array/getElement(I)Ljava/lang/Object;";
            commands += "\ncheckcast " + checkcastType(memberType);
            String castCmd = castToPrimitive(memberType);
            if (castCmd != null)
                commands += "\n" + castCmd;
        }
        return commands;
    }

    @Override
    public String visit(Identifier identifier) {
        String commands = "";
        int slot = slotOf(identifier.getName());
        commands += "aload " + String.valueOf(slot);
        Type type = identifier.accept(expressionTypeChecker);
        String castCmd = castToPrimitive(type);
        if (castCmd != null)
            commands += "\n" + castCmd;
        return commands;
    }

    @Override
    public String visit(ArrayAccessByIndex arrayAccessByIndex) {
        String commands = "";
        Type elementType = arrayAccessByIndex.accept(expressionTypeChecker);
        int dimSize = ((ArrayType) arrayAccessByIndex.getInstance().accept(expressionTypeChecker)).getDimensions().size();
        commands += arrayAccessByIndex.getInstance().accept(this);
        commands += "\n" + arrayAccessByIndex.getIndex().accept(this);
        commands += "\ninvokevirtual Array/getElement(I)Ljava/lang/Object;";
        commands += "\ncheckcast " + checkcastType(elementType);
        String castCmd = castToPrimitive(elementType);
        if (castCmd != null)
            commands += "\n" + castCmd;

        return commands;
    }

    @Override
    public String visit(MethodCall methodCall) {
        Type retType = methodCall.accept(expressionTypeChecker);
        String commands = "";
        commands += methodCall.getInstance().accept(this) + " ;methodCall";
        commands += "\nnew java/util/ArrayList";
        commands += "\ndup";
        commands += "\ninvokespecial java/util/ArrayList/<init>()V";
        for (Expression arg : methodCall.getArgs()) {
            commands += "\ndup";
            commands += "\n" + arg.accept(this);
            String castCmd = castToNonPrimitive(arg.accept(expressionTypeChecker));
            if (castCmd != null)
                commands += "\n" + castCmd;
            commands += "\ninvokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z"; // append
            commands += "\npop"; // pop the bool from last command
        }
        commands += "\ninvokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;";

        if (!(retType instanceof VoidType))
            commands += "\ncheckcast " + checkcastType(retType);

        String castCmd = castToPrimitive(retType);
        if (castCmd != null)
            commands += "\n" + castCmd;

        return commands;
    }

    @Override
    public String visit(NewClassInstance newClassInstance) {
        String commands = "";
        String className = newClassInstance.getClassType().getClassName().getName();
        commands += "new " + className;
        commands += "\ndup";
        for (Expression arg : newClassInstance.getArgs()) {
            commands += "\n" + arg.accept(this);
            String castCmd = castToNonPrimitive(arg.accept(expressionTypeChecker));
            if (castCmd != null)
                commands += "\n" + castCmd;
        }

        commands += "\ninvokespecial " + className + "/<init>(";
        for (Expression arg : newClassInstance.getArgs()) {
            commands += makeTypeSignature(arg.accept(expressionTypeChecker));
        }
        commands += ")V";

        return commands;
    }

    @Override
    public String visit(SelfClass selfClass) {
        String commands = "";
        commands += "aload_0";
        return commands;
    }

    @Override
    public String visit(NullValue nullValue) {
        String commands = "";
        commands += "aconst_null";
        return commands;
    }

    @Override
    public String visit(IntValue intValue) {
        String commands = "";
        commands += "ldc " + String.valueOf(intValue.getConstant());
        return commands;
    }

    @Override
    public String visit(BoolValue boolValue) {
        String commands = "";
        commands += "ldc ";
        if (boolValue.getConstant())
            commands += "1";
        else
            commands += "0";
        return commands;
    }

}
