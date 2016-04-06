package es.us.isa.ideas.synopsis.common.expression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import es.us.isa.ideas.synopsis.common.expression.parser.ExpressionLexer;
import es.us.isa.ideas.synopsis.common.expression.parser.ExpressionParser;
import es.us.isa.ideas.synopsis.common.expression.parser.MExpressionVisitor;
import es.us.isa.ideas.synopsis.common.expression.parser.ExpressionParser.ParseContext;


/**
 * @author jdelafuente
 *
 */
public abstract class Expression {
	
	protected Object value;

	public abstract Object calculate();

	public static Expression parse(String content) {

		ExpressionLexer lexer = new ExpressionLexer(new ANTLRInputStream(
				content));

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		ExpressionParser parser = new ExpressionParser(tokens);

		// Specify our entry point
		ParseContext context = parser.parse();

		// Walk it and attach our listener
		MExpressionVisitor visitor = new MExpressionVisitor();
		Expression res = visitor.visitParse(context);

		return res;
	}

	public static Set<Atomic> getAtomics(Expression exp) {
		Set<Atomic> lst = new HashSet<>();
		if (!(exp instanceof Atomic)) {

			if (exp instanceof ParenthesisExpression) {
				exp = ((ParenthesisExpression) exp).getInnerExpression();
			}

			if (exp instanceof CompoundExpression) {
				CompoundExpression ce = (CompoundExpression) exp;
				for (Expression ex : ce.getExpressions()) {
					lst.addAll(Expression.getAtomics(ex));
				}
			}
		} else {
			lst.add((Atomic) exp);
		}
		return lst;
	}

	public static Set<Var> getVars(Expression exp) {
		Set<Var> lst = new HashSet<>();
		if (!(exp instanceof Var)) {

			if (exp instanceof ParenthesisExpression) {
				exp = ((ParenthesisExpression) exp).getInnerExpression();
			}

			if (exp instanceof CompoundExpression) {
				CompoundExpression ce = (CompoundExpression) exp;
				for (Expression ex : ce.getExpressions()) {
					lst.addAll(Expression.getVars(ex));
				}
			}
		} else {
			lst.add((Var) exp);
		}
		return lst;
	}

	public static void printTree(Expression exp, Integer index) {
		if (index == 0) {
			System.out
					.println("\n Abstract Syntax Tree"
							+ "\n");
		}
		String tab = new String(new char[index]).replace("\0", "\t");

		System.out.println(tab + exp.getClass().getSimpleName());
		if (!(exp instanceof Atomic) && !(exp instanceof Var)) {

			if (exp instanceof ParenthesisExpression) {
				exp = ((ParenthesisExpression) exp).getInnerExpression();
				index++;
				Expression.printTree(exp, index);
			} else {
				if (exp instanceof CompoundExpression) {
					CompoundExpression ce = (CompoundExpression) exp;
					index++;
					try {
						System.out.println(tab + ce.getOperator());
					} catch (Exception e) {
						System.out.println(tab);
					}
					for (Expression ex : ce.getExpressions()) {
						Expression.printTree(ex, index);
					}
				}
			}
		} else {
			System.out.println(tab + exp);
		}
	}

	public static List<Expression> splitExpressions(Expression expr) {
		List<Expression> res = new ArrayList<Expression>();

		if (expr instanceof ParenthesisExpression)
			expr = ((ParenthesisExpression) expr).getInnerExpression();

		if (expr instanceof CompoundExpression) {
			CompoundExpression cexpr = (CompoundExpression) expr;
			if (cexpr.getOperator() != LogicalOperator.NOT) {
				Boolean split = true;
				for (Expression exp : cexpr.getExpressions()) {
					if (exp instanceof ParenthesisExpression)
						exp = ((ParenthesisExpression) exp).getInnerExpression();

					if (!(exp instanceof CompoundExpression)) {
						split = false;
						break;
					}
				}

				if (split) {
					Expression e1 = cexpr.getExpression1();
					Expression e2 = cexpr.getExpression2();
					res.addAll(splitExpressions(e1));
					res.addAll(splitExpressions(e2));
				} else {
					res.add(cexpr);
				}
			} else {
				res.add(expr);
			}
		} else {
			res.add(expr);
		}

		return res;
	}

	public static List<Expression> splitANDExpressions(Expression expr) {
		List<Expression> res = new ArrayList<Expression>();

		if (expr instanceof ParenthesisExpression)
			expr = ((ParenthesisExpression) expr).getInnerExpression();

		if (expr instanceof LogicalExpression) {
			LogicalExpression lexpr = (LogicalExpression) expr;
			if (lexpr.getOperator() == LogicalOperator.AND) {
				Boolean split = true;
				for (Expression exp : lexpr.getExpressions()) {
					if (exp instanceof ParenthesisExpression)
						exp = ((ParenthesisExpression) exp).getInnerExpression();

					if (!(exp instanceof CompoundExpression)) {
						split = false;
						break;
					}
				}

				if (split) {
					for(Expression e : lexpr.getExpressions())
						res.addAll(splitANDExpressions(e));
				} else {
					res.add(lexpr);
				}
			} else {
				res.add(expr);
			}
		} else {
			res.add(expr);
		}

		return res;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode() * 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expression) {
			Expression expr = (Expression) obj;
			return this.toString().equals(expr.toString());
		}
		return false;
	}
}
