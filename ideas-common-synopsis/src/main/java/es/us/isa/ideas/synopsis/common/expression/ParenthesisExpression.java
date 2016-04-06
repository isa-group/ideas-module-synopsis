package es.us.isa.ideas.synopsis.common.expression;

/**
 * @author jdelafuente
 *
 */
public class ParenthesisExpression extends Expression {

	protected Expression exp;
	
    public ParenthesisExpression(Expression e) {
        this.exp = e;
    }
    
    public Expression getInnerExpression() {
		return exp;
	}

    public void setExpression(Expression exp) {
		this.exp = exp;
	}

	@Override
    public String toString() {
        return "(" + this.exp + ")";
    }

	@Override
	public Object calculate() {
		return exp.calculate();
	}

}
