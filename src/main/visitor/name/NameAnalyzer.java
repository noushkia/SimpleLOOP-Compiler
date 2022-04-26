package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
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
        //..............
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        for (VariableDeclaration arg: methodDeclaration.getArgs())
            arg.accept(this);
        for (VariableDeclaration var: methodDeclaration.getLocalVars())
            var.accept(this);
        for (Statement statement: methodDeclaration.getBody())
            statement.accept(this);
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDeclaration) {
        return null;
    }
}
