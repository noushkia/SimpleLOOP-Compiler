package main.visitor.name;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.Identifier;
import main.compileError.nameError.ClassInCyclicInheritance;
import main.compileError.nameError.ClassRedefinition;
import main.compileError.nameError.GlobalVarRedefinition;
import main.compileError.nameError.LocalVarConflictWithGlobalVar;
import main.compileError.nameError.LocalVarRedefinition;
import main.compileError.nameError.FieldRedefinition;
import main.compileError.nameError.MethodNameConflictWithField;
import main.compileError.nameError.MethodRedefinition;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.items.LocalVariableSymbolTableItem;
import main.symbolTable.items.MethodSymbolTableItem;
import main.visitor.Visitor;

public class NameCollector extends Visitor<Void> {

    private int newId = 1;

    @Override
    public Void visit(Program program) {
        SymbolTable.push(new SymbolTable());
        SymbolTable.root = SymbolTable.top;
        for (VariableDeclaration variableDeclaration : program.getGlobalVariables())
            variableDeclaration.accept(this);

        for(ClassDeclaration classDeclaration : program.getClasses()) {
            classDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        ClassSymbolTableItem classSymbolTableItem = new ClassSymbolTableItem(classDeclaration);
        SymbolTable.push(new SymbolTable(SymbolTable.top));
        classSymbolTableItem.setClassSymbolTable(SymbolTable.top);
        try {
            SymbolTable.root.put(classSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            ClassRedefinition exception = new ClassRedefinition(classDeclaration.getLine(), classDeclaration.getClassName().getName());
            classDeclaration.addError(exception);
            String newName = newId + "@";
            newId += 1;
            classDeclaration.setClassName(new Identifier(newName));
            try {
                ClassSymbolTableItem newClassSym = new ClassSymbolTableItem(classDeclaration);
                newClassSym.setClassSymbolTable(SymbolTable.top);
                SymbolTable.root.put(newClassSym);
            } catch (ItemAlreadyExistsException e1) { //Unreachable
            }
//            exception.handleException();
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
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        MethodSymbolTableItem methodSymbolTableItem = new MethodSymbolTableItem(methodDeclaration);
        SymbolTable methodSymbolTable = new SymbolTable(SymbolTable.top);
        methodSymbolTableItem.setMethodSymbolTable(methodSymbolTable);
        try {
            SymbolTable.top.put(methodSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            MethodRedefinition exception = new MethodRedefinition(methodDeclaration.getLine(), methodDeclaration.getMethodName().getName());
            methodDeclaration.addError(exception);
        }
        SymbolTable.push(methodSymbolTable);
        for(VariableDeclaration varDeclaration : methodDeclaration.getArgs()) {
            try {
                SymbolTable.root.getItem(LocalVariableSymbolTableItem.START_KEY + varDeclaration.getVarName().getName(), true);
                LocalVarConflictWithGlobalVar exception = new LocalVarConflictWithGlobalVar(varDeclaration.getLine(), varDeclaration.getVarName().getName());
                varDeclaration.addError(exception);
            } catch (ItemNotFoundException ignored){
                varDeclaration.accept(this);
            }

        }
        for(VariableDeclaration varDeclaration : methodDeclaration.getLocalVars()) {
            try {
                SymbolTable.root.getItem(LocalVariableSymbolTableItem.START_KEY + varDeclaration.getVarName().getName(), true);
                LocalVarConflictWithGlobalVar exception = new LocalVarConflictWithGlobalVar(varDeclaration.getLine(), varDeclaration.getVarName().getName());
                varDeclaration.addError(exception);
            } catch (ItemNotFoundException ignored){
                varDeclaration.accept(this);
            }
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        try {
            SymbolTable.top.put(new FieldSymbolTableItem(fieldDeclaration));
        } catch (ItemAlreadyExistsException e) {
            FieldRedefinition exception = new FieldRedefinition(fieldDeclaration.getLine(), fieldDeclaration.getVarDeclaration().getVarName().getName());
            fieldDeclaration.addError(exception);
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

}
