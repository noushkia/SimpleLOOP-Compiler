package main.ast.nodes.statement;

import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

//line -> IF
public class ConditionalStmt extends Statement{
    private Expression condition;
    private Statement thenBody;
    private ArrayList<Statement> elsifCondition = new ArrayList<>();
    private ArrayList<Statement> elsifBody = new ArrayList<>();
    private Statement elseBody;

    public ConditionalStmt(Expression expression, Statement thenBody) {
        this.condition = expression;
        this.thenBody = thenBody;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Statement getThenBody() {
        return thenBody;
    }

    public void setThenBody(Statement thenBody) {
        this.thenBody = thenBody;
    }

    public ArrayList<Statement> getElsifCondition() {
        return elsifCondition;
    }

    public void setElsifCondition(ArrayList<Statement> elsifCondition) {
        this.elsifCondition = elsifCondition;
    }

    public ArrayList<Statement> getElsifBody() {
        return elsifBody;
    }

    public void setElsifBody(ArrayList<Statement> elsifBody) {
        this.elsifBody = elsifBody;
    }

    public Statement getElseBody() {
        return elseBody;
    }

    public void setElseBody(Statement elseBody) {
        this.elseBody = elseBody;
    }

    @Override
    public String toString() {
        return "ConditionalStmt";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
