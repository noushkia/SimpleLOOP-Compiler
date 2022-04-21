package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class SetMerge extends Expression{
    private ArrayList<Expression> args = new ArrayList<>();
    private Expression elementArg;

    public SetMerge(ArrayList<Expression> args, Expression elementArg) {
        this.args = args;
        this.elementArg = elementArg;
    }

    public void setArgs(ArrayList<Expression> args) { this.args = args; }
    public ArrayList<Expression> getArgs() { return args; }

    public void setElementArg(Expression elementArg) { this.elementArg = elementArg; }
    public Expression getElementArg() {
        return elementArg;
    }

    @Override
    public String toString() {
        return "SetMerge";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
