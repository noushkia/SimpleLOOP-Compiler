package main.ast.nodes.expression.values;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class SetValue extends Value{
    private ArrayList<Expression> elements = new ArrayList<>();

    public SetValue() {
    }

    public SetValue(ArrayList<Expression> elements) {
        this.elements = elements;
    }

    public ArrayList<Expression> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Expression> elements) {
        this.elements = elements;
    }

    public void addElement(Expression expression) {
        this.elements.add(expression);
    }

    @Override
    public String toString() {
        return "ListValue";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
