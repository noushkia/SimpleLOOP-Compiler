package main.visitor.typeChecker;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.*;

public class TypeChecker extends Visitor<Void> {
    private Graph<String> classHierarchy;
    ExpressionTypeChecker expressionTypeChecker;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private boolean methodReturns = false;

    public TypeChecker(Graph<String> classHierarchy){
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }

    @Override
    public Void visit(Program program) {
        boolean mainCheck = false;
        for (VariableDeclaration variableDeclaration : program.getGlobalVariables()) {
            variableDeclaration.accept(this);
        }
        for (ClassDeclaration classDeclaration : program.getClasses()) {
            this.expressionTypeChecker.setCurrentClass(classDeclaration);
            this.currentClass = classDeclaration;
            classDeclaration.accept(this);
            if(classDeclaration.getClassName().getName().equals("Main"))
                mainCheck = true;
        }
        if(!mainCheck) {
            NoMainClass exception = new NoMainClass();
            program.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        if(classDeclaration.getParentClassName() != null) {
            this.expressionTypeChecker.checkTypeValidation(new ClassType(classDeclaration.getParentClassName()), classDeclaration);
            if(classDeclaration.getClassName().getName().equals("Main")) {
                MainClassCantInherit exception = new MainClassCantInherit(classDeclaration.getLine());
                classDeclaration.addError(exception);
            }
            if(classDeclaration.getParentClassName().getName().equals("Main")) {
                CannotExtendFromMainClass exception = new CannotExtendFromMainClass(classDeclaration.getLine());
                classDeclaration.addError(exception);
            }
        }
        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            this.expressionTypeChecker.setCurrentMethod(classDeclaration.getConstructor());
            this.currentMethod = classDeclaration.getConstructor();
            classDeclaration.getConstructor().accept(this);
        }
        else if(classDeclaration.getClassName().getName().equals("Main")) {
            NoConstructorInMainClass exception = new NoConstructorInMainClass(classDeclaration);
            classDeclaration.addError(exception);
        }
        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            this.expressionTypeChecker.setCurrentMethod(methodDeclaration);
            this.currentMethod = methodDeclaration;
            methodDeclaration.accept(this);
            // todo
//            boolean doesReturn = methodDeclaration.accept(this).doesReturn;
//            methodDeclaration.setDoesReturn(doesReturn);
//            if(!doesReturn && !(methodDeclaration.getReturnType() instanceof NullType)) {
//                MissingReturnStatement exception = new MissingReturnStatement(methodDeclaration);
//                methodDeclaration.addError(exception);
//            }
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        if(this.currentClass.getClassName().getName().equals("Main")) {
            if(constructorDeclaration.getArgs().size() != 0) {
                MainConstructorCantHaveArgs exception = new MainConstructorCantHaveArgs(constructorDeclaration.getLine());
                constructorDeclaration.addError(exception);
            }
        }
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        this.expressionTypeChecker.checkTypeValidation(methodDeclaration.getReturnType(), methodDeclaration);
        for(ArgPair argPair : methodDeclaration.getArgs()) {
            //todo
            argPair.getVariableDeclaration().accept(this);
        }
        for(VariableDeclaration varDeclaration : methodDeclaration.getLocalVars()) {
            varDeclaration.accept(this);
        }
        this.methodReturns = false;
//        boolean doesReturn = false, doesMethodReturn = false;
        for(Statement statement : methodDeclaration.getBody()) {
            statement.accept(this);
//            if(doesReturn) {
//                UnreachableStatements exception = new UnreachableStatements(statement);
//                statement.addError(exception);
//            }
//            doesReturn = statement.accept(this).doesReturn;
//            doesMethodReturn = doesReturn || doesMethodReturn;
        }

        if (!this.methodReturns && !(methodDeclaration.getReturnType() instanceof VoidType)) {
            MissingReturnStatement exception = new MissingReturnStatement(methodDeclaration);
            methodDeclaration.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        this.expressionTypeChecker.checkTypeValidation(varDeclaration.getType(), varDeclaration);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        Type firstType = assignmentStmt.getlValue().accept(expressionTypeChecker);
        Type secondType = assignmentStmt.getrValue().accept(expressionTypeChecker);
        boolean isFirstLvalue = expressionTypeChecker.isLvalue(assignmentStmt.getlValue());
        if(!isFirstLvalue) {
            LeftSideNotLvalue exception = new LeftSideNotLvalue(assignmentStmt.getLine());
            assignmentStmt.addError(exception);
        }
        if(firstType instanceof NoType || secondType instanceof NoType) {
            return null;
        }
        boolean isSubtype = expressionTypeChecker.isFirstSubTypeOfSecond(secondType, firstType);
        if(!isSubtype) {
            UnsupportedOperandType exception = new UnsupportedOperandType(assignmentStmt.getLine(), BinaryOperator.assign.name());
            assignmentStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        boolean doesReturn = false, doesBlockReturn = false;
        for(Statement statement : blockStmt.getStatements()) {
            if(doesReturn) {
                UnreachableStatements exception = new UnreachableStatements(statement);
                statement.addError(exception);
            }
//            RetConBrk stmtRetConBrk = statement.accept(this);
//            doesReturn = stmtRetConBrk.doesReturn;
//            doesBlockReturn = doesReturn || doesBlockReturn;
//            doesContinueBreak = stmtRetConBrk.doesBreakContinue;
//            doesBlockContinueBreak = doesContinueBreak || doesBlockContinueBreak;
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(exception);
        }
        boolean methodReturns = this.methodReturns;
        this.methodReturns = false;
        boolean doesReturn;
        conditionalStmt.getThenBody().accept(this);
        doesReturn = this.methodReturns;
        for (ElsifStmt elsifStmt : conditionalStmt.getElsif()) {
            elsifStmt.accept(this);
            doesReturn &= this.methodReturns;
        }
        if(conditionalStmt.getElseBody() != null) {
            conditionalStmt.getElseBody().accept(this);
            doesReturn &= this.methodReturns;
//            return new RetConBrk(thenRetConBrk.doesReturn && elseRetConBrk.doesReturn,
//                    thenRetConBrk.doesBreakContinue && elseRetConBrk.doesBreakContinue);
        }
        this.methodReturns = methodReturns & doesReturn;
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        Type condType = elsifStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(elsifStmt.getLine());
            elsifStmt.addError(exception);
        }
        this.methodReturns = false;
        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        expressionTypeChecker.setIsInMethodCallStmt(true);
        methodCallStmt.getMethodCall().accept(expressionTypeChecker);
        expressionTypeChecker.setIsInMethodCallStmt(false);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType = print.getArg().accept(expressionTypeChecker);
        if(!(argType instanceof IntType || argType instanceof ArrayType || argType instanceof SetType ||
                argType instanceof BoolType || argType instanceof NoType)) {
            UnsupportedTypeForPrint exception = new UnsupportedTypeForPrint(print.getLine());
            print.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        Type retType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        Type actualRetType = this.currentMethod.getReturnType();
        if(!expressionTypeChecker.isFirstSubTypeOfSecond(retType, actualRetType)) {
            ReturnValueNotMatchMethodReturnType exception = new ReturnValueNotMatchMethodReturnType(returnStmt);
            returnStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        Type listType = eachStmt.getList().accept(expressionTypeChecker);
        if (!(listType instanceof ArrayType)) {
            EachCantIterateNoneArray exception = new EachCantIterateNoneArray(eachStmt.getLine());
            eachStmt.addError(exception);
            return null;
        }
        Type varType = eachStmt.getVariable().accept(expressionTypeChecker);
        if (!(expressionTypeChecker.isFirstSubTypeOfSecond(varType, ((ArrayType) listType).getType()))) {
            EachVarNotMatchList exception = new EachVarNotMatchList(eachStmt);
            eachStmt.addError(exception);
            return null;
        }
        eachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        Type setAddElementType = setDelete.getElementArg().accept(expressionTypeChecker);
        if (!(setAddElementType instanceof IntType || setAddElementType instanceof NoType)) {
            AddInputNotInt exception = new AddInputNotInt(setDelete.getLine());
            setDelete.addError(exception);
            return null;
        }
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        for (Expression element : setMerge.getElementArgs()) {
            Type setMergeElementType = element.accept(expressionTypeChecker);
            if (!(setMergeElementType instanceof IntType || setMergeElementType instanceof NoType)) {
                AddInputNotInt exception = new AddInputNotInt(setMerge.getLine());
                setMerge.addError(exception);
                return null;
            }
        }
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        Type setAddElementType = setAdd.getElementArg().accept(expressionTypeChecker);
        if (!(setAddElementType instanceof IntType || setAddElementType instanceof NoType)) {
            AddInputNotInt exception = new AddInputNotInt(setAdd.getLine());
            setAdd.addError(exception);
            return null;
        }
        return null;
    }

}
