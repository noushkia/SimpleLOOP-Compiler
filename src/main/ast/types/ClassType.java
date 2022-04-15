package main.ast.types;

import main.ast.nodes.expression.Identifier;

public class ClassType extends Type {
    private Identifier className;

    public ClassType(Identifier className) {
        this.className = className;
    }

    public Identifier getClassName() { return className; }
    public void setClassName(Identifier className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ClassType_" + this.className.getName();
    }
}
