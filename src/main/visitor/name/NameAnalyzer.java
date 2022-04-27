package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.statement.*;
import main.symbolTable.SymbolTable;
import main.visitor.Visitor;

public class NameAnalyzer extends Visitor<Void> {
    @Override
    public Void visit(Program program) {
        SymbolTable root = new SymbolTable();
        SymbolTable.root = root;
        SymbolTable.push(root);
        // visit classes and global variables
        // add hierarchy
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        if(classDeclaration.getParentClassName() != null) {
//            if (this.classHierarchy.isSecondNodeAncestorOf(classDeclaration.getParentClassName().getName(), classDeclaration.getClassName().getName())) {
//                ClassInCyclicInheritance exception = new ClassInCyclicInheritance(classDeclaration);
//                classDeclaration.addError(exception);
//            }
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
    public Void visit(MethodDeclaration methodDeclaration) {
        //check conflict with fields and other methods
        // use Symbol Table
        for (VariableDeclaration arg: methodDeclaration.getArgs())
            arg.accept(this);
        for (VariableDeclaration var: methodDeclaration.getLocalVars())
            var.accept(this);
        for (Statement statement: methodDeclaration.getBody())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        // check field conflicts
        return null;
    }

    @Override
    //todo: check
    public Void visit(BlockStmt blockStmt) {
        for (Statement stmt : blockStmt.getStatements()) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        SymbolTable ifScope = new SymbolTable(SymbolTable.top);
        SymbolTable.push(ifScope);
        conditionalStmt.getThenBody().accept(this);
        SymbolTable.pop();

        for (ElsifStmt elsifStmt: conditionalStmt.getElsif())
            elsifStmt.accept(this);

        if (conditionalStmt.getElseBody() != null) {
            SymbolTable elseScope = new SymbolTable(SymbolTable.top);
            SymbolTable.push(elseScope);
            conditionalStmt.getElseBody().accept(this);
            SymbolTable.pop();
        }
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        SymbolTable elsifScope = new SymbolTable(SymbolTable.top);
        SymbolTable.push(elsifScope);
        elsifStmt.getThenBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        SymbolTable loopScope = new SymbolTable(SymbolTable.top);
        SymbolTable.push(loopScope);
        eachStmt.getBody().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDeclaration) {
        //
        return null;
    }
}
