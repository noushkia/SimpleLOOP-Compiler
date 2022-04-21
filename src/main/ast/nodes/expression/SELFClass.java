package main.ast.nodes.expression;

import main.visitor.IVisitor;

//line -> SELF
public class SELFClass extends Expression {
    @Override
    public String toString() {
        return "SELFClass";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
