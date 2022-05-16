package main.visitor.typeChecker;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.compileError.typeError.NoMainClass;
import main.symbolTable.utils.graph.Graph;
import main.visitor.*;

public class TypeChecker extends Visitor<Void> {
    private Graph<String> classHierarchy;
    ExpressionTypeChecker expressionTypeChecker;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private boolean isInFor = false;

    public TypeChecker(Graph<String> classHierarchy){
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }

    @Override
    public Void visit(Program program) {
        boolean mainCheck = false;
        for(ClassDeclaration classDeclaration : program.getClasses()) {
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
        //todo
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        //todo
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        //todo
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        //todo
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        //todo
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        //todo
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        //todo
        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        //todo
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        //todo
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        //todo
        return null;
    }

}
