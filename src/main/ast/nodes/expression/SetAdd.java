package main.ast.nodes.expression;

import main.visitor.IVisitor;

//line -> ADD
public class SetAdd extends Expression{
    private Expression setArg;
    private Expression elementArg;

    public SetAdd(Expression setArg, Expression elementArg) {
        this.setArg = setArg;
        this.elementArg = elementArg;
    }

    public void setSetArg(Expression setArg) { this.setArg = setArg; }
    public Expression getSetArg() { return setArg; }

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
