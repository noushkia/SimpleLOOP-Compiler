package main.ast.types;

public class ArrayType extends Type {
    private Type elementType;

    public ArrayType(Type elementType) {
        this.elementType = elementType;
    }

    public Type getType() {
        return elementType;
    }
    public void setType(Type elementType) {
        this.elementType = elementType;
    }

    @Override
    public String toString() {
        return "ArrayType";
    }
}

