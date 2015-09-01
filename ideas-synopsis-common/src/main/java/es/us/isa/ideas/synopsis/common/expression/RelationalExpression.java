package es.us.isa.ideas.synopsis.common.expression;


/**
 * @author jdelafuente
 *
 */
public class RelationalExpression extends CompoundExpression {

    public RelationalExpression(Expression e1, Expression e2, RelationalOperator operator) {
        this.exp1 = e1;
        this.exp2 = e2;
        this.operator = operator;
    }

    @Override
    public Boolean calculate() {
        Boolean res = null;
        switch ((RelationalOperator) this.operator) {
            case GT:
                res = Double.valueOf(this.exp1.calculate().toString()) > Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case LT:
                res = Double.valueOf(this.exp1.calculate().toString()) < Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case GTE:
                res = Double.valueOf(this.exp1.calculate().toString()) >= Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case LTE:
                res = Double.valueOf(this.exp1.calculate().toString()) <= Double
                        .valueOf(this.exp2.calculate().toString());
                break;
            case EQ:
                res = Double.valueOf(this.exp1.calculate().toString()).equals(
                        Double.valueOf(this.exp2.calculate().toString()));
                break;
            case NEQ:
                res = !(Double.valueOf(this.exp1.calculate().toString()).equals(
                        Double.valueOf(this.exp2.calculate().toString())));
                break;
        }

        return res;
    }

    @Override
    public String toString() {
        String op = "";
        switch ((RelationalOperator) this.operator) {
            case GT:
                op = ">";
                break;
            case GTE:
                op = ">=";
                break;
            case LT:
                op = "<";
                break;
            case LTE:
                op = "<=";
                break;
            case EQ:
                op = "==";
                break;
            case NEQ:
                op = "!=";
                break;
        }

        return this.exp1 + " " + op + " " + this.exp2;
    }
    
    @Override
	public ExpressionType getType() {
		return ExpressionType.RelationalExpression;
	}
}
