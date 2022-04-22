package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.ListValue;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.ClassValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.SetMerge;
import main.ast.nodes.statement.set.SetDelete;

public interface IVisitor<T> {

    T visit(Program program);

    T visit(ClassDeclaration classDeclaration);
    T visit(ConstructorDeclaration constructorDeclaration);
    T visit(MethodDeclaration methodDeclaration);
    T visit(FieldDeclaration fieldDeclaration);
    T visit(VariableDeclaration varDeclaration);
    T visit(MainDeclaration mainDeclaration);

    T visit(AssignmentStmt assignmentStmt);
    T visit(BlockStmt blockStmt);
    T visit(ConditionalStmt conditionalStmt);
    T visit(MethodCallStmt methodCallStmt);
    T visit(PrintStmt print);
    T visit(ReturnStmt returnStmt);
    T visit(EachStmt EachStmt);

    T visit(BinaryExpression binaryExpression);
    T visit(UnaryExpression unaryExpression);
    T visit(ObjectOrListMemberAccess objectOrListMemberAccess);
    T visit(Identifier identifier);
    T visit(ArrayAccessByIndex listAccessByIndex);
    T visit(MethodCall methodCall);
    T visit(NewClassInstance newClassInstance);
    T visit(SelfClass selfClass);
    T visit(ListValue listValue);
    T visit(NullValue nullValue);
    T visit(IntValue intValue);
    T visit(BoolValue boolValue);

    T visit(SetInclude setAdd);

    T visit(SetValue setValue);

    T visit(ClassValue classValue);

    T visit(SetNew setMerge);

    T visit(TernaryExpression ternaryExpression);

    T visit(SetDelete setDelete);

    T visit(SetMerge setAdd);

    T visit(RangeExpression rangeExpression);
}
