package main.ast.nodes.expression.values.primitive;

import main.ast.nodes.expression.values.Value;
import main.visitor.IVisitor;

public class ClassValue extends Value {
    private String constant;

    public ClassValue(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "ClassValue_" + this.constant;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
