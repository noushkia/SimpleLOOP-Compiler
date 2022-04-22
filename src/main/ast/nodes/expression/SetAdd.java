package main.ast.nodes.expression;

import main.ast.nodes.expression.values.primitive.IntValue;
import main.visitor.IVisitor;

//line -> ADD
public class SetAdd extends Expression{
    private IntValue setArg;
    private Expression elementArg;

    public SetAdd(IntValue setArg, Expression elementArg) {
        this.setArg = setArg;
        this.elementArg = elementArg;
    }

    public void setSetArg(IntValue setArg) { this.setArg = setArg; }
    public IntValue getSetArg() { return setArg; }

    public void setElementArg(Expression elementArg) { this.elementArg = elementArg; }
    public Expression getElementArg() {
        return elementArg;
    }

    @Override
    public String toString() {
        return "SetAdd";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}