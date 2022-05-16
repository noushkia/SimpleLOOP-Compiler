package main.visitor.typeChecker;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.types.NoType;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.set.SetType;
import main.compileError.typeError.CannotHaveEmptyArray;
import main.compileError.typeError.ClassNotDeclared;
import main.compileError.typeError.LeftSideNotLvalue;
import main.compileError.typeError.UnsupportedOperandType;
import main.symbolTable.utils.graph.Graph;
import main.visitor.Visitor;

import java.util.ArrayList;

public class ExpressionTypeChecker extends Visitor<Type> {
    private Graph<String> classHierarchy;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private int typeValidationNumberOfErrors;
    private boolean seenNoneLvalue = false;
    private boolean isInMethodCallStmt = false;

    public ExpressionTypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public void setCurrentClass(ClassDeclaration currentClass) {
        this.currentClass = currentClass;
    }

    public void setCurrentMethod(MethodDeclaration currentMethod) {
        this.currentMethod = currentMethod;
    }

    public void setIsInMethodCallStmt(boolean isInMethodCallStmt) {
        this.isInMethodCallStmt = isInMethodCallStmt;
    }

    public boolean isSameType(Type t1, Type t2) {
        return (t1 instanceof NoType) || (t2 instanceof NoType) || (isFirstSubTypeOfSecond(t1, t2) && isFirstSubTypeOfSecond(t2, t1));
    }

    public boolean isFirstSubTypeOfSecondMultiple(ArrayList<Type> first, ArrayList<Type> second) {
        if(first.size() != second.size())
            return false;
        for(int i = 0; i < first.size(); i++) {
            if(!isFirstSubTypeOfSecond(first.get(i), second.get(i)))
                return false;
        }
        return true;
    }

    public boolean isFirstSubTypeOfSecond(Type first, Type second) {
        if(first instanceof NoType)
            return true;
        else if(first instanceof IntType || first instanceof BoolType || first instanceof SetType)
            return first.toString().equals(second.toString());
        else if(first instanceof NullType)
            return second instanceof NullType || second instanceof FptrType || second instanceof ClassType;
        else if(first instanceof ClassType) {
            if(!(second instanceof ClassType))
                return false;
            return this.classHierarchy.isSecondNodeAncestorOf(((ClassType) first).getClassName().getName(), ((ClassType) second).getClassName().getName());
        }
        else if(first instanceof FptrType) {
            if(!(second instanceof FptrType))
                return false;
            Type firstRetType = ((FptrType) first).getReturnType();
            Type secondRetType = ((FptrType) second).getReturnType();
            if(!isFirstSubTypeOfSecond(firstRetType, secondRetType))
                return false;
            ArrayList<Type> firstArgsTypes = ((FptrType) first).getArgumentsTypes();
            ArrayList<Type> secondArgsTypes = ((FptrType) second).getArgumentsTypes();
            return isFirstSubTypeOfSecondMultiple(secondArgsTypes, firstArgsTypes);
        }
        else if(first instanceof ArrayType) {
            if(!(second instanceof ArrayType))
                return false;
            return ((ArrayType) first).getType().toString().equals(((ArrayType) second).getType().toString());
        }
        return false;
    }

    public Type refineType(Type type) {
        typeValidationNumberOfErrors = 0;
        this.checkTypeValidation(type, new NullValue());
        if(typeValidationNumberOfErrors > 0)
            return new NoType();
        return type;
    }

    public void checkTypeValidation(Type type, Node node) {
        if(!(type instanceof ClassType || type instanceof FptrType || type instanceof ArrayType))
            return;
        if(type instanceof ArrayType) {
            //todo check size??
            for (Expression dimension : ((ArrayType) type).getDimensions()) {
//                if (dimension.toString())
                CannotHaveEmptyArray exception = new CannotHaveEmptyArray(node.getLine());
                node.addError(exception);
                typeValidationNumberOfErrors += 1;
                return;
            }
        }
        else if(type instanceof FptrType) {
            Type retType = ((FptrType) type).getReturnType();
            ArrayList<Type> argsType = ((FptrType) type).getArgumentsTypes();
            this.checkTypeValidation(retType, node);
            for(Type argType : argsType)
                this.checkTypeValidation(argType, node);
        }
        else {
            String className = ((ClassType)type).getClassName().getName();
            if(!this.classHierarchy.doesGraphContainNode(className)) {
                ClassNotDeclared exception = new ClassNotDeclared(node.getLine(), className);
                node.addError(exception);
                typeValidationNumberOfErrors += 1;
            }
        }
    }

    public boolean isLvalue(Expression expression) {
        boolean prevIsCatchErrorsActive = Node.isCatchErrorsActive;
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        Node.isCatchErrorsActive = false;
        this.seenNoneLvalue = false;
        expression.accept(this);
        boolean isLvalue = !this.seenNoneLvalue;
        this.seenNoneLvalue = prevSeenNoneLvalue;
        Node.isCatchErrorsActive = prevIsCatchErrorsActive;
        return isLvalue;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        this.seenNoneLvalue = true;
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        Type firstType = binaryExpression.getFirstOperand().accept(this);
        Type secondType = binaryExpression.getSecondOperand().accept(this);
        if(operator == BinaryOperator.eq) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && secondType instanceof ArrayType) ||
                    (secondType instanceof NoType && firstType instanceof ArrayType)) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if(firstType instanceof IntType || firstType instanceof BoolType || firstType instanceof SetType)
                if(firstType.toString().equals(secondType.toString()))
                    return new BoolType();
            if((firstType instanceof ClassType && secondType instanceof NullType) ||
                    (firstType instanceof NullType && secondType instanceof ClassType) ||
                    (firstType instanceof ClassType && secondType instanceof ClassType &&
                            ((ClassType)firstType).getClassName().getName().equals(((ClassType)secondType).getClassName().getName()))) {
                return new BoolType();
            }
            if((firstType instanceof FptrType && secondType instanceof NullType) ||
                    (firstType instanceof NullType && secondType instanceof FptrType) ||
                    (firstType instanceof FptrType && secondType instanceof FptrType)) {
                return new BoolType();
            }
            if(firstType instanceof NullType && secondType instanceof NullType)
                return new BoolType();
        }
        if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof IntType)) ||
                    (secondType instanceof NoType && !(firstType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof IntType) && (secondType instanceof IntType))
                return new BoolType();
        }
        if((operator == BinaryOperator.add) || (operator == BinaryOperator.sub) ||
                (operator == BinaryOperator.mult) || (operator == BinaryOperator.div)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof IntType)) ||
                    (secondType instanceof NoType && !(firstType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof IntType) && (secondType instanceof IntType))
                return new IntType();
        }

        if((operator == BinaryOperator.or) || (operator == BinaryOperator.and)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof BoolType)) ||
                    (secondType instanceof NoType && !(firstType instanceof BoolType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof BoolType) && (secondType instanceof BoolType))
                return new BoolType();
        }
        if(operator == BinaryOperator.assign) {
            boolean isFirstLvalue = this.isLvalue(binaryExpression.getFirstOperand());
            if(!isFirstLvalue) {
                LeftSideNotLvalue exception = new LeftSideNotLvalue(binaryExpression.getLine());
                binaryExpression.addError(exception);
            }
            if(firstType instanceof NoType || secondType instanceof NoType) {
                return new NoType();
            }
            boolean isSubtype = this.isFirstSubTypeOfSecond(secondType, firstType);
            if(isSubtype) {
                if(isFirstLvalue)
                    return secondType;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
            binaryExpression.addError(exception);
            return new NoType();
        }
        UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
        binaryExpression.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(NewClassInstance newClassInstance) {

        return null;
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        //Todo
        return null;
    }

    @Override
    public Type visit(MethodCall methodCall) {
        //Todo
        return null;
    }

    @Override
    public Type visit(Identifier identifier) {
        //Todo
        return null;
    }

    @Override
    public Type visit(ArrayAccessByIndex arrayAccessByIndex) {
        //Todo
        return null;
    }

    @Override
    public Type visit(ObjectMemberAccess objectMemberAccess) {
        //Todo
        return null;
    }

    @Override
    public Type visit(SetNew setNew) {
        //Todo
        return null;
    }

    @Override
    public Type visit(SetInclude setInclude) {
        //Todo
        return null;
    }

    @Override
    public Type visit(RangeExpression rangeExpression) {
        //Todo
        return null;
    }

    @Override
    public Type visit(TernaryExpression ternaryExpression) {
        //Todo
        return null;
    }

    @Override
    public Type visit(IntValue intValue) {
        //Todo
        return null;
    }

    @Override
    public Type visit(BoolValue boolValue) {
        //Todo
        return null;
    }

    @Override
    public Type visit(SelfClass selfClass) {
        //todo
        return null;
    }

    @Override
    public Type visit(SetValue setValue) {
        //todo
        return null;
    }

    @Override
    public Type visit(NullValue nullValue) {
        //todo
        return null;
    }
}
