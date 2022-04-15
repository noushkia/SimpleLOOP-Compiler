package main.ast.types;

import main.ast.nodes.expression.Identifier;

public class SetType extends Type {
    private Identifier setName;

    public SetType(Identifier setName) {
        this.setName = setName;
    }

    public Identifier getSetName() { return setName; }
    public void setSetName(Identifier setName) {
        this.setName = setName;
    }

    @Override
    public String toString() {
        return "ClassType_" + this.setName.getName();
    }
}
