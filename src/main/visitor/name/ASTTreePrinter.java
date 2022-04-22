package main.visitor.name;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.visitor.*;

public class ASTTreePrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        for (ClassDeclaration classDeclaration: program.getClasses())
            classDeclaration.accept(this);
//        program.getMain().accept(this); //todo
        return null;
    }

//    @Override //todo
//    public Void visit(MainDeclaration mainDec) {
//        messagePrinter(mainDec.getLine(), mainDec.toString());
//        mainDec.getBody().accept(this);
//        return null;
//    }

    @Override
    public Void visit(VariableDeclaration variableDec) {
        messagePrinter(variableDec.getLine(), variableDec.toString());
        variableDec.getVarName().accept(this);
//        if (variableDec.getDefaultValue() != null) //todo
//            variableDec.getDefaultValue().accept(this);
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDec) {
        messagePrinter(classDec.getLine(), classDec.toString());
        classDec.getClassName().accept(this);
        if(classDec.getParentClassName() != null) {
            classDec.getParentClassName().accept(this);
        }
        for(FieldDeclaration fieldDeclaration : classDec.getFields()) {
            fieldDeclaration.accept(this);
        }
        if(classDec.getConstructor() != null) {
            classDec.getConstructor().accept(this);
        }
        for(MethodDeclaration methodDeclaration : classDec.getMethods()) {
            methodDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDec) {
        messagePrinter(constructorDec.getLine(), constructorDec.toString());
        constructorDec.getMethodName().accept(this);
        for(VariableDeclaration varDeclaration : constructorDec.getArgs()) {
            varDeclaration.accept(this);
        }
        for(VariableDeclaration varDeclaration : constructorDec.getLocalVars()) {
            varDeclaration.accept(this);
        }
        for(Statement statement : constructorDec.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDec) {
        messagePrinter(methodDec.getLine(), methodDec.toString());
        methodDec.getMethodName().accept(this);
        for(VariableDeclaration varDeclaration : methodDec.getArgs()) {
            varDeclaration.accept(this);
        }
        for(VariableDeclaration varDeclaration : methodDec.getLocalVars()) {
            varDeclaration.accept(this);
        }
        for(Statement statement : methodDec.getBody()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDec) {
        messagePrinter(fieldDec.getLine(), fieldDec.toString());
        fieldDec.getVarDeclaration().accept(this);
        return null;
    }


    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        messagePrinter(assignmentStmt.getLine(), assignmentStmt.toString());
        assignmentStmt.getlValue().accept(this);
        assignmentStmt.getrValue().accept(this);
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        messagePrinter(blockStmt.getLine(), blockStmt.toString());
        for (Statement stmt: blockStmt.getStatements())
            stmt.accept(this);
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        messagePrinter(conditionalStmt.getLine(), conditionalStmt.toString());
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        messagePrinter(methodCallStmt.getLine(), methodCallStmt.toString());
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        messagePrinter(print.getLine(), print.toString());
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        if (returnStmt.getReturnedExpr() != null)
            returnStmt.getReturnedExpr().accept(this);
        return null;
    }

//    @Override //todo
//    public Void visit(LoopStmt loopStmt) {
//        messagePrinter(loopStmt.getLine(), loopStmt.toString());
//        loopStmt.getCondition().accept(this);
//        loopStmt.getBody().accept(this);
//        return null;
//    }

//    @Override //todo
//    public Void visit(VarDecStmt varDecStmt) {
//        messagePrinter(varDecStmt.getLine(), varDecStmt.toString());
//        for (VariableDeclaration var: varDecStmt.getVars())
//            var.accept(this);
//        return null;
//    }

//    @Override //todo
//    public Void visit(ListAppendStmt listAppendStmt) {
//        messagePrinter(listAppendStmt.getLine(), listAppendStmt.toString());
//        listAppendStmt.getListAppendExpr().accept(this);
//        return null;
//    }

//    @Override //todo
//    public Void visit(ListSizeStmt listSizeStmt) {
//        messagePrinter(listSizeStmt.getLine(), listSizeStmt.toString());
//        listSizeStmt.getListSizeExpr().accept(this);
//        return null;
//    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        messagePrinter(methodCall.getLine(), methodCall.toString());
        methodCall.getInstance().accept(this);
        for(Expression expression : methodCall.getArgs()) {
            expression.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ArrayAccessByIndex listAccessByIndex) {
        messagePrinter(listAccessByIndex.getLine(), listAccessByIndex.toString());
        listAccessByIndex.getInstance().accept(this);
        listAccessByIndex.getIndex().accept(this);
        return null;
    }

//    @Override //todo
//    public Void visit(ListSize listSize) {
//        messagePrinter(listSize.getLine(), listSize.toString());
//        listSize.getArg().accept(this);
//        return null;
//    }
//
//    @Override //todo
//    public Void visit(ListAppend listAppend) {
//        messagePrinter(listAppend.getLine(), listAppend.toString());
//        listAppend.getListArg().accept(this);
//        listAppend.getElementArg().accept(this);
//        return null;
//    }
//
//    @Override //todo
//    public Void visit(ExprInPar exprInPar) {
//        messagePrinter(exprInPar.getLine(), exprInPar.toString());
//        for (Expression expr: exprInPar.getInputs())
//            expr.accept(this);
//        return null;
//    }

    @Override
    public Void visit(IntValue intValue) {
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }
}