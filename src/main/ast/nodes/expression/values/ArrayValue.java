package main.ast.nodes.expression.values;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

//line -> first LBRACK
public class ArrayValue extends Value{
    private Expression element;
    private ArrayList<Expression> dimensions = new ArrayList<>();

    public ArrayValue() {
    }

    public ArrayValue(Expression element, ArrayList<Expression> dimensions) {
        this.element = element;
        this.dimensions = dimensions;
    }

    public Expression getElements() {
        return element;
    }

    public void setElement(Expression element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "ArrayValue";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Expression> getDimensions() {
        return dimensions;
    }

    public void setDimensions(ArrayList<Expression> dimensions) {
        this.dimensions = dimensions;
    }
}
