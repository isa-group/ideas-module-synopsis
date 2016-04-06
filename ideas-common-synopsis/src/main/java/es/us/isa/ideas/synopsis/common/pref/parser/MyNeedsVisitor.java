/**
 * 
 */
package es.us.isa.ideas.synopsis.common.pref.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.AttributedFeature;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.ComplexConstraint;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.FAMAAttributedFeatureModel;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.Relation;
import es.us.isa.FAMA.models.domain.Range;
import es.us.isa.FAMA.models.domain.RangeIntegerDomain;
import es.us.isa.FAMA.models.featureModel.Cardinality;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttribute;
import es.us.isa.aml.model.csp.CSPObjectiveFunction;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.synopsis.common.expression.ArithmeticExpression;
import es.us.isa.ideas.synopsis.common.expression.ArithmeticOperator;
import es.us.isa.ideas.synopsis.common.expression.AssignmentExpression;
import es.us.isa.ideas.synopsis.common.expression.Atomic;
import es.us.isa.ideas.synopsis.common.expression.CompoundExpression;
import es.us.isa.ideas.synopsis.common.expression.Expression;
import es.us.isa.ideas.synopsis.common.expression.ListExpression;
import es.us.isa.ideas.synopsis.common.expression.LogicalExpression;
import es.us.isa.ideas.synopsis.common.expression.LogicalOperator;
import es.us.isa.ideas.synopsis.common.expression.ParenthesisExpression;
import es.us.isa.ideas.synopsis.common.expression.RelationalExpression;
import es.us.isa.ideas.synopsis.common.expression.RelationalOperator;
import es.us.isa.ideas.synopsis.common.expression.Var;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.AdditiveExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.AndExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ArgsContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ArrayAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ArrayContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ArrayExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.AssigExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.AtomExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.BooleanAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.EntryContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.EqualityExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ExcludesExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ExpressionContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.FloatAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.IdAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.IffExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ImpliesExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.IntegerAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ItemTermAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.Item_termContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ItemsContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ListExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.MaxExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.MinExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.MultiplicationExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.Needs_definitionContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.NotExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.OrExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ParExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.ParametersContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.PreferenceContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.PreferencesContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.PropertyContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.RelationalExprContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.RequirementContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.RequirementsContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.StringAtomContext;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser.SumExprContext;

/**
 * @author jdelafuente
 *
 */
public class MyNeedsVisitor implements NeedsVisitor {

	FAMAAttributedFeatureModel model;
	FAMAAttributedFeatureModel blockServiceModel;
	private List<String> tags;
	private Boolean precompile;

	private CSPObjectiveFunction objectiveFunction;
	private List<String> errors;

	public List<String> getTags() {
		return tags;
	}

	public CSPObjectiveFunction getObjectiveFunction() {
		return objectiveFunction;
	}

	public MyNeedsVisitor() {
		model = new FAMAAttributedFeatureModel();
		errors = new ArrayList<String>();
		tags = new ArrayList<String>();
		precompile = true;
	}

	public MyNeedsVisitor(FAMAAttributedFeatureModel blockServiceModel) {
		model = new FAMAAttributedFeatureModel();
		this.blockServiceModel = blockServiceModel;
		errors = new ArrayList<String>();
		tags = new ArrayList<String>();
		precompile = false;
	}

	@Override
	public Object visitEntry(EntryContext ctx) {
		FAMAAttributedFeatureModel res;
		AttributedFeature root = new AttributedFeature(ctx.Identifier()
				.getText());
		model.setRoot(root);
		visitNeeds_definition(ctx.needs_definition());
		if (precompile)
			res = model;
		else
			res = blockServiceModel;
		return res;
	}

	@Override
	public Object visitNeeds_definition(Needs_definitionContext ctx) {
		if (precompile)
			visitItems(ctx.items());
		else {
			visitRequirements(ctx.requirements());
			visitPreferences(ctx.preferences());
		}
		return null;
	}

	@Override
	public Object visitItems(ItemsContext ctx) {
		for (PropertyContext prop_ctx : ctx.property()) {
			visitProperty(prop_ctx);
		}
		return null;
	}

	@Override
	public Object visitProperty(PropertyContext ctx) {

		String id = ctx.id.getText();

		for (ParametersContext param : ctx.parameters()) {
			tags.add(Util.withoutDoubleQuotes(param.getText()));

			AttributedFeature feature = new AttributedFeature(
					Util.withoutDoubleQuotes(param.getText()) + "_" + id);

			Relation r = new Relation(model.getRoot().getName() + "-"
					+ feature.getName());
			r.setParent(model.getRoot());
			r.addDestination(feature);
			r.addCardinality(new Cardinality(1, 1));

			model.getRoot().addRelation(r);
			model.getAttributedFeatures().add(feature);
		}
		return null;
	}

	@Override
	public Object visitRequirements(RequirementsContext ctx) {
		for (RequirementContext r : ctx.requirement()) {
			visitRequirement(r);
		}
		return null;
	}

	@Override
	public Object visitRequirement(RequirementContext ctx) {
		Expression res = null;
		Expression expr = visitExpression(ctx.expression());

		CompoundExpression cexpr = (CompoundExpression) expr;

		Expression expr1 = cexpr.getExpression1();
		Expression expr2 = cexpr.getExpression2();
		if (expr1 instanceof Var) {
			Var var1 = (Var) expr1;

			if (getFeature(var1) != null) {

				AttributedFeature feature = getFeature(var1);

				if (expr2 instanceof Atomic) {
					Atomic atom = (Atomic) expr2;

					if (expr instanceof RelationalExpression) {

						RelationalExpression rexpr = (RelationalExpression) expr;

						RangeIntegerDomain d;
						Range r;

						StringBuilder sb = new StringBuilder();

						switch ((RelationalOperator) rexpr.getOperator()) {
						case EQ:
							var1.setId(feature.getName() + "_"
									+ Util.withoutDoubleQuotes(atom.toString()));
							((Atomic) expr2).setValue(1);
							res = expr;
							break;
						case GTE:
							d = (RangeIntegerDomain) feature.getDomain();
							r = d.getRanges().iterator().next();
							sb = new StringBuilder();
							for (int i = (int) atom.calculate(); i <= r
									.getMax(); i++) {
								sb.append(feature.getName() + "_" + i + " == 1");
								if (i < r.getMax())
									sb.append(" OR ");
							}

							res = Expression.parse(sb.toString());

							break;
						case GT:
							d = (RangeIntegerDomain) feature.getDomain();
							r = d.getRanges().iterator().next();
							sb = new StringBuilder();
							for (int i = (int) atom.calculate() + 1; i <= r
									.getMax(); i++) {
								sb.append(feature.getName() + "_" + i + " == 1");
								if (i < r.getMax())
									sb.append(" OR ");
							}

							res = Expression.parse(sb.toString());

							break;
						case LTE:
							d = (RangeIntegerDomain) feature.getDomain();
							r = d.getRanges().iterator().next();

							for (int i = r.getMin(); i <= (int) atom
									.calculate(); i++) {
								sb.append(feature.getName() + "_" + i + " == 1");
								if (i < (int) atom.calculate())
									sb.append(" OR ");
							}

							res = Expression.parse(sb.toString());

							break;
						case LT:
							d = (RangeIntegerDomain) feature.getDomain();
							r = d.getRanges().iterator().next();

							for (int i = r.getMin(); i < (int) atom.calculate(); i++) {
								sb.append(feature.getName() + "_" + i + " == 1");
								if (i < (int) atom.calculate() - 1)
									sb.append(" OR ");
							}

							res = Expression.parse(sb.toString());

							break;
						case NEQ:
							d = (RangeIntegerDomain) feature.getDomain();
							r = d.getRanges().iterator().next();

							for (int i = r.getMin(); i <= r.getMax(); i++) {
								if (i != (int) atom.calculate()) {

									sb.append(feature.getName() + "_" + i
											+ " == 1");

									if (i < r.getMax())
										sb.append(" " + LogicalOperator.OR
												+ " ");
								}
							}

							for (int i = r.getMin(); i <= (int) atom
									.calculate(); i++) {
								sb.append(feature.getName() + "_" + i + " == 1");
								if (i < r.getMax())
									sb.append(" OR ");
							}

							res = Expression.parse(sb.toString());

							break;
						}
					}

				}

			}
		}

		ComplexConstraint c = new ComplexConstraint(res.toString() + ";");
		blockServiceModel.addConstraint(c);

		return null;
	}

	@Override
	public Object visitPreferences(PreferencesContext ctx) {
		for (PreferenceContext pref_ctx : ctx.preference())
			visitPreference(pref_ctx);
		return null;
	}

	@Override
	public Object visitPreference(PreferenceContext ctx) {
		if (ctx.LOWEST() != null) {
			Var var = new Var(ctx.item_term().getText());
			if (getAttribute(var) != null) {
				GenericAttribute attr = getAttribute(var);
				String csp_feature_name = attr.getFullName().replaceAll("\\.",
						"_");
				this.objectiveFunction = new CSPObjectiveFunction(true,
						es.us.isa.aml.model.expression.Expression
								.parse(csp_feature_name));

			}
		} else if (ctx.HIGHEST() != null) {
			Var var = new Var(ctx.item_term().getText());
			if (getFeature(var) != null) {
				AttributedFeature feature = getFeature(var);
				String csp_feature_name = feature.getName().replaceAll("\\.",
						"_");
				this.objectiveFunction = new CSPObjectiveFunction(false,
						es.us.isa.aml.model.expression.Expression
								.parse(csp_feature_name));
			}
		} else {
			errors.add("Operator '" + ctx.method.getText() + "' ignored: This feature is not supported by language yet.");
		}

		return null;
	}

	public Expression checkExpression(Expression expr, Expression parentExpr) {
		Expression res = null;

		return res;
	}

	public AttributedFeature getFeature(Var var) {
		for (AttributedFeature feat : blockServiceModel.getAttributedFeatures()) {
			if (feat.getName().equals(var.getId().toString()))
				return feat;
		}
		return null;
	}

	public GenericAttribute getAttribute(Var var) {
		for (AttributedFeature feat : blockServiceModel.getAttributedFeatures()) {
			for (GenericAttribute att : feat.getAttributes()) {
				if (att.getFullName().equals(var.getId().toString()))
					return att;
				if (att.getName().equals(var.getId().toString()))
					return att;
			}
		}

		return null;
	}

	public Expression visitExpression(ExpressionContext ctx) {
		Expression res = null;

		switch (ctx.getClass().getSimpleName()) {
		case "AssigExprContext":
			res = this.visitAssigExpr((AssigExprContext) ctx);
			break;
		case "NotExprContext":
			res = this.visitNotExpr((NotExprContext) ctx);
			break;
		case "MultiplicationExprContext":
			res = this.visitMultiplicationExpr((MultiplicationExprContext) ctx);
			break;
		case "AdditiveExprContext":
			res = this.visitAdditiveExpr((AdditiveExprContext) ctx);
			break;
		case "RelationalExprContext":
			res = this.visitRelationalExpr((RelationalExprContext) ctx);
			break;
		case "EqualityExprContext":
			res = this.visitEqualityExpr((EqualityExprContext) ctx);
			break;
		case "AndExprContext":
			res = this.visitAndExpr((AndExprContext) ctx);
			break;
		case "OrExprContext":
			res = this.visitOrExpr((OrExprContext) ctx);
			break;
		case "ImpliesExprContext":
			res = this.visitImpliesExpr((ImpliesExprContext) ctx);
			break;
		case "ExcludesExprContext":
			res = this.visitExcludesExpr((ExcludesExprContext) ctx);
			break;
		case "IffExprContext":
			res = this.visitIffExpr((IffExprContext) ctx);
			break;
		case "ParExprContext":
			res = this.visitParExpr((ParExprContext) ctx);
			break;
		case "ListExprContext":
			res = this.visitListExpr((ListExprContext) ctx);
			break;
		case "ArrayExprContext":
			res = this.visitArrayExpr((ArrayExprContext) ctx);
			break;
		case "AtomExprContext":
			res = this.visitAtomExpr((AtomExprContext) ctx);
			break;
		}

		return res;
	}

	@Override
	public Expression visitAssigExpr(AssigExprContext ctx) {
		Var v = new Var(ctx.Identifier().getText());
		Expression e2 = this.visitExpression(ctx.expression());
		Expression res = new AssignmentExpression(v, e2);
		return res;
	}

	@Override
	public Expression visitNotExpr(NotExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression());
		Expression res = new LogicalExpression(e1, LogicalOperator.NOT);
		return res;
	}

	@Override
	public Expression visitMultiplicationExpr(
			@NotNull MultiplicationExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case NeedsParser.ASTERISK:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.MULTIPLY);
		case NeedsParser.SLASH:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.DIVIDE);
		default:
			throw new RuntimeException("unknown operator: "
					+ NeedsParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAdditiveExpr(@NotNull AdditiveExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case NeedsParser.PLUS:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.ADD);
		case NeedsParser.HYPHEN:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.SUBTRACT);
		default:
			throw new RuntimeException("unknown operator: "
					+ NeedsParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitRelationalExpr(@NotNull RelationalExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case NeedsParser.LTE:
			return new RelationalExpression(e1, e2, RelationalOperator.LTE);
		case NeedsParser.GTE:
			return new RelationalExpression(e1, e2, RelationalOperator.GTE);
		case NeedsParser.LT:
			return new RelationalExpression(e1, e2, RelationalOperator.LT);
		case NeedsParser.GT:
			return new RelationalExpression(e1, e2, RelationalOperator.GT);
		default:
			throw new RuntimeException("unknown operator: "
					+ NeedsParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitEqualityExpr(@NotNull EqualityExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case NeedsParser.EQ:
			return new RelationalExpression(e1, e2, RelationalOperator.EQ);
		case NeedsParser.NEQ:
			return new RelationalExpression(e1, e2, RelationalOperator.NEQ);
		default:
			throw new IllegalArgumentException("unknown operator: "
					+ NeedsParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAndExpr(AndExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.AND);
	}

	@Override
	public Expression visitOrExpr(OrExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.OR);
	}

	@Override
	public Expression visitImpliesExpr(ImpliesExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));
		return new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
	}

	@Override
	public Expression visitExcludesExpr(ExcludesExprContext ctx) {
		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression _e2 = this.visitExpression(ctx.expression(1));
		Expression e2 = new LogicalExpression(_e2, LogicalOperator.NOT);
		return new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
	}

	@Override
	public Expression visitIffExpr(IffExprContext ctx) {
		Expression e1_1 = this.visitExpression(ctx.expression(0));
		Expression e1_2 = this.visitExpression(ctx.expression(1));
		Expression e1 = new LogicalExpression(e1_1, e1_2,
				LogicalOperator.IMPLIES);
		Expression e2 = new LogicalExpression(e1_2, e1_1,
				LogicalOperator.IMPLIES);
		return new LogicalExpression(new ParenthesisExpression(e1),
				new ParenthesisExpression(e2), LogicalOperator.AND);
	}

	@Override
	public Expression visitListExpr(ListExprContext ctx) {
		return visitList(ctx.list());
	}

	@Override
	public Expression visitList(NeedsParser.ListContext ctx) {
		List<Object> ls = new ArrayList<Object>();
		for (ArgsContext actx : ctx.args()) {
			ls.add(actx.getText());
		}
		return new ListExpression(ls);
	}

	@Override
	public Expression visitArrayExpr(ArrayExprContext ctx) {
		return visitArray(ctx.array());
	}

	@Override
	public Expression visitArray(ArrayContext ctx) {
		Object[] ls = new Object[ctx.args().size()];
		for (int i = 0; i < ctx.args().size(); i++) {
			ls[i] = ctx.args(i);
		}
		return new ListExpression(ls);
	}

	@Override
	public Expression visitAtomExpr(AtomExprContext ctx) {
		Expression res = null;

		switch (ctx.atom().getClass().getSimpleName()) {
		case "IntegerAtomContext":
			res = this.visitIntegerAtom((IntegerAtomContext) ctx.atom());
			break;
		case "FloatAtomContext":
			res = this.visitFloatAtom((FloatAtomContext) ctx.atom());
			break;
		case "BooleanAtomContext":
			res = this.visitBooleanAtom((BooleanAtomContext) ctx.atom());
			break;
		case "ArrayAtomContext":
			res = this.visitArrayAtom((ArrayAtomContext) ctx.atom());
			break;
		case "IdAtomContext":
			res = this.visitIdAtom((IdAtomContext) ctx.atom());
			break;
		case "StringAtomContext":
			res = this.visitStringAtom((StringAtomContext) ctx.atom());
			break;
		case "ItemTermAtomContext":
			res = this.visitItemTermAtom((ItemTermAtomContext) ctx.atom());
			break;
		}

		return res;
	}

	@Override
	public Expression visitItemTermAtom(ItemTermAtomContext ctx) {
		return visitItem_term(ctx.item_term());
	}

	@Override
	public Expression visitItem_term(Item_termContext ctx) {
		return new Var(Util.withoutDoubleQuotes(ctx.service_id.getText()) + "_"
				+ ctx.feature.getText());
	}

	@Override
	public Expression visitParExpr(ParExprContext ctx) {
		return new ParenthesisExpression(this.visitExpression(ctx.expression()));
	}

	@Override
	public Expression visitIntegerAtom(IntegerAtomContext ctx) {
		return new Atomic(Integer.valueOf(ctx.getText()));
	}

	@Override
	public Expression visitFloatAtom(FloatAtomContext ctx) {
		return new Atomic(Double.valueOf(ctx.getText()));
	}

	@Override
	public Expression visitBooleanAtom(BooleanAtomContext ctx) {
		return new Atomic(Boolean.valueOf(ctx.getText()));
	}

	@Override
	public Expression visitArrayAtom(ArrayAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Expression visitIdAtom(IdAtomContext ctx) {
		return new Var(ctx.getText());
	}

	@Override
	public Expression visitStringAtom(StringAtomContext ctx) {
		return new Atomic(ctx.getText());
	}

	@Override
	public Object visit(ParseTree tree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitChildren(RuleNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitArgs(ArgsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitMinExpr(MinExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitParameters(ParametersContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSumExpr(SumExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitMaxExpr(MaxExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getErrors(){
		return errors;
	}
}
