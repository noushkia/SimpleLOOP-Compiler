package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.compileError.CompileError;
import main.compileError.nameError.*;
import main.symbolTable.utils.graph.Graph;
import main.visitor.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class NameAnalyzer  extends Visitor<Void> {
    public boolean hasError() { return !errors.isEmpty(); }
    private ArrayList<CompileError> errors;
    private int newStructID = 1;
    private int newFuncID = 1;
    private String currentClassName;
    private Graph<String> classHierarchy;
    Program root;

    private boolean inStruct = false;
//    private StructDeclaration curr_struct = null;
//    private HashMap<StructDeclaration, ArrayList<String> > structDependency =
//            new HashMap<>();
//    private HashMap<String, StructDeclaration > nameStruct = new HashMap<>();
//    private HashMap<StructDeclaration, Boolean> isBeingVisited = new HashMap<>();
//    private HashMap<StructDeclaration, Boolean> isVisited = new HashMap<>();
//    private HashSet<StructDeclaration> inCycle = new HashSet<>();

    private SymbolTable getCurrentClassSymbolTable() {
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem)
                    SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + this.currentClassName, true);
            return classSymbolTableItem.getClassSymbolTable();
        } catch (ItemNotFoundException ignored) {
            return null;
        }
    }

//    private boolean hasCycle(StructDeclaration struct) {
//        isBeingVisited.put(struct, true);
//        Boolean isInCycle = false;
//        for (String neighbor : structDependency.get(struct)) {
//            try {
//                StructDeclaration neighborStruct = nameStruct.get(neighbor);
//                if (isBeingVisited.containsKey(neighborStruct) && isBeingVisited.get(neighborStruct)) {
//                    inCycle.add(neighborStruct);
//                    isInCycle = true;
//                }
//                else if (hasCycle(neighborStruct) && isVisited.containsKey(neighborStruct) && isVisited.get(neighborStruct)) {
//                    inCycle.add(neighborStruct);
//                }
//            } catch (Exception ignored) {}
//        }
//
//        isBeingVisited.put(struct, false);
//        isVisited.put(struct, true);
//        return isInCycle;
//    }
//
//    private void checkCyclicDependencies(ArrayList<StructDeclaration> structs){
//        for (StructDeclaration structDeclaration : structs) {
//            isVisited.clear();
//            hasCycle(structDeclaration);
//        }
//        for(StructDeclaration struct : inCycle){
//            errors.add(new CyclicDependency(struct.getLine(), struct.getStructName().getName()));
//        }
//    }

    private void printErrors() {
        for (CompileError exception: errors)
            System.out.println(exception.getMessage());
    }

    @Override
    public Void visit(Program program) {
        this.root = program;
        for(ClassDeclaration classDeclaration : program.getClasses()) {
            this.currentClassName = classDeclaration.getClassName().getName();
            classDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        if(classDeclaration.getParentClassName() != null) {
            if (this.classHierarchy.isSecondNodeAncestorOf(classDeclaration.getParentClassName().getName(), classDeclaration.getClassName().getName())) {
                ClassInCyclicInheritance exception = new ClassInCyclicInheritance(classDeclaration.getLine(), classDeclaration.getClassName().getName());
                classDeclaration.addError(exception);
            }
        }
        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            classDeclaration.getConstructor().accept(this);
        }
        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            methodDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }


    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        if(!methodDeclaration.hasError()) {
            try {
                SymbolTable classSymbolTable = this.getCurrentClassSymbolTable();
                classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + methodDeclaration.getMethodName().getName(), false);
                MethodRedefinition exception = new MethodRedefinition(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
                methodDeclaration.addError(exception);
            } catch (ItemNotFoundException ignored) {
            }
        }
        boolean errored = false;
        try {
            SymbolTable classSymbolTable = this.getCurrentClassSymbolTable();
            classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + methodDeclaration.getMethodName().getName(), true);
            MethodNameConflictWithField exception = new MethodNameConflictWithField(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
            methodDeclaration.addError(exception);
            errored = true;
        } catch (ItemNotFoundException ignored) {
        }
        if(!errored)
            for(ClassDeclaration classDeclaration : root.getClasses()) {
                String childName = classDeclaration.getClassName().getName();
                if(classHierarchy.isSecondNodeAncestorOf(childName, currentClassName)) {
                    try {
                        ClassSymbolTableItem childSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + childName, true);
                        SymbolTable childSymbolTable = childSymbolTableItem.getClassSymbolTable();
                        childSymbolTable.getItem(FieldSymbolTableItem.START_KEY + methodDeclaration.getMethodName().getName(), true);
                        MethodNameConflictWithField exception = new MethodNameConflictWithField(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
                        methodDeclaration.addError(exception);
                        break;
                    } catch (ItemNotFoundException ignored) {
                    }
                }
            }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        if(!fieldDeclaration.hasError()) {
            try {
                SymbolTable classSymbolTable = this.getCurrentClassSymbolTable();
                classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + fieldDeclaration.getVarDeclaration().getVarName().getName(), false);
                FieldRedefinition exception = new FieldRedefinition(fieldDeclaration.getLine(), fieldDeclaration.getVarDeclaration().getVarName().getName());
                fieldDeclaration.addError(exception);
            } catch (ItemNotFoundException ignored) {
            }
        }
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        try {
            SymbolTable.top.put(new LocalVariableSymbolTableItem(varDeclaration));
        } catch (ItemAlreadyExistsException e) {
            LocalVarRedefinition exception = new LocalVarRedefinition(varDeclaration.getLine(), varDeclaration.getVarName().getName());
            varDeclaration.addError(exception);
        }
        return null;
    }

//    @Override
//    public Void visit(MainDeclaration mainDec) {
//        mainDec.getBody().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(VariableDeclaration variableDec) {
//        if (inStruct && !curr_struct.getStructName().getName().contains("@")) {
//            if (variableDec.getVarType().toString().contains("StructType_")) {
//                String neighbourStruct = variableDec.getVarType().toString().replace("StructType", "StructDeclaration");
//                structDependency.computeIfAbsent(curr_struct, k -> new ArrayList<>()).add(neighbourStruct);
//            }
//        }
//        VariableSymbolTableItem varSymbol = new VariableSymbolTableItem(variableDec.getVarName());
//        try {
//            SymbolTable.top.getItem(VariableSymbolTableItem.START_KEY + variableDec.getVarName().getName());
//            DuplicateVar exception = new DuplicateVar(variableDec.getLine(), variableDec.getVarName().getName());
//            variableDec.addError(exception);
//        } catch (ItemNotFoundException e) {
//            try {
//                SymbolTable.top.put(varSymbol);
//            } catch (ItemAlreadyExistsException ignored) {}
//        }
//        try{
//            SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + variableDec.getVarName().getName());
//            VarFunctionConflict exception = new VarFunctionConflict(variableDec.getLine(), variableDec.getVarName().getName());
//            variableDec.addError(exception);
//        } catch (ItemNotFoundException ignored) {}
//        try{
//            SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + variableDec.getVarName().getName());
//            VarStructConflict exception = new VarStructConflict(variableDec.getLine(), variableDec.getVarName().getName());
//            variableDec.addError(exception);
//        } catch (ItemNotFoundException ignored) {}
//
//        if (variableDec.getDefaultValue() != null)
//            variableDec.getDefaultValue().accept(this);
//        errors.addAll(variableDec.flushErrors());
//        return null;
//    }
//
//    @Override
//    public Void visit(StructDeclaration structDec) {
//        structDec.getStructName().accept(this);
//        inStruct = true;
//        curr_struct = structDec;
//        structDec.getBody().accept(this);
//        inStruct = false;
//        return null;
//    }
//
//    @Override
//    public Void visit(SetGetVarDeclaration setGetVarDec) {
//        VariableSymbolTableItem varSymbol = new VariableSymbolTableItem(setGetVarDec.getVarName());
//        try {
//            SymbolTable.top.put(varSymbol);
//        } catch (ItemAlreadyExistsException e) {
//            DuplicateVar exception = new DuplicateVar(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
//            setGetVarDec.addError(exception);
//        }
//        try{
//            SymbolTable.root.getItem(FunctionSymbolTableItem.START_KEY + setGetVarDec.getVarName().getName());
//            VarFunctionConflict exception = new VarFunctionConflict(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
//            setGetVarDec.addError(exception);
//        } catch (ItemNotFoundException ignored) {}
//        try{
//            SymbolTable.root.getItem(StructSymbolTableItem.START_KEY + setGetVarDec.getVarName().getName());
//            VarStructConflict exception = new VarStructConflict(setGetVarDec.getLine(), setGetVarDec.getVarName().getName());
//            setGetVarDec.addError(exception);
//        } catch (ItemNotFoundException ignored) {}
//
//        for (VariableDeclaration var: setGetVarDec.getArgs())
//            var.accept(this);
//
//        errors.addAll(setGetVarDec.flushErrors());
//
////        setGetVarDec.getSetterBody().accept(this);
////        setGetVarDec.getGetterBody().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(AssignmentStmt assignmentStmt) {
//        assignmentStmt.getLValue().accept(this);
//        assignmentStmt.getRValue().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(BlockStmt blockStmt) {
//        for (Statement stmt: blockStmt.getStatements())
//            stmt.accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(ConditionalStmt conditionalStmt) {
//        SymbolTable then = new SymbolTable(SymbolTable.top);
//        SymbolTable.push(then);
//        conditionalStmt.getCondition().accept(this);
//        conditionalStmt.getThenBody().accept(this);
//        SymbolTable.pop();
//        SymbolTable _else = new SymbolTable(SymbolTable.top);
//        if (conditionalStmt.getElseBody() != null) {
//            SymbolTable.push(_else);
//            conditionalStmt.getElseBody().accept(this);
//            SymbolTable.pop();
//        }
//        return null;
//    }
//
//    @Override
//    public Void visit(FunctionCallStmt functionCallStmt) {
//        functionCallStmt.getFunctionCall().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(DisplayStmt displayStmt) {
//        displayStmt.getArg().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(ReturnStmt returnStmt) {
//        if (returnStmt.getReturnedExpr() != null)
//            returnStmt.getReturnedExpr().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(LoopStmt loopStmt) {
//        SymbolTable loop = new SymbolTable(SymbolTable.top);
//        SymbolTable.push(loop);
//        loopStmt.getCondition().accept(this);
//        loopStmt.getBody().accept(this);
//        SymbolTable.pop();
//        return null;
//    }
//
//    @Override
//    public Void visit(VarDecStmt varDecStmt) {
//        for (VariableDeclaration var: varDecStmt.getVars())
//            var.accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(ListAppendStmt listAppendStmt) {
//        listAppendStmt.getListAppendExpr().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(ListSizeStmt listSizeStmt) {
//        listSizeStmt.getListSizeExpr().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(BinaryExpression binaryExpression) {
//        binaryExpression.getFirstOperand().accept(this);
//        binaryExpression.getSecondOperand().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(UnaryExpression unaryExpression) {
//        unaryExpression.getOperand().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(FunctionCall funcCall) {
//        funcCall.getInstance().accept(this);
//        for (Expression expr: funcCall.getArgs())
//            expr.accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(Identifier identifier) {
//        return null;
//    }
//
//    @Override
//    public Void visit(ListAccessByIndex listAccessByIndex) {
//        listAccessByIndex.getInstance().accept(this);
//        listAccessByIndex.getIndex().accept(this);
//        return null;
//    }
//

//
//    @Override
//    public Void visit(ListSize listSize) {
//        listSize.getArg().accept(this);
//        return null;
//    }
//
//    @Override
//    public Void visit(ListAppend listAppend) {
//        listAppend.getListArg().accept(this);
//        listAppend.getElementArg().accept(this);
//        return null;
//    }

//    @Override
//    public Void visit(ExprInPar exprInPar) {
//        for (Expression expr: exprInPar.getInputs())
//            expr.accept(this);
//        return null;
//    }

    @Override
    public Void visit(IntValue intValue) {
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        return null;
    }
}
