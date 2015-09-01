/**
 * 
 */
package es.us.isa.ideas.synopsis.common.hcs.parser;

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
import es.us.isa.FAMA.models.domain.Domain;
import es.us.isa.FAMA.models.domain.ObjectDomain;
import es.us.isa.FAMA.models.domain.Range;
import es.us.isa.FAMA.models.domain.RangeIntegerDomain;
import es.us.isa.FAMA.models.domain.RealDomain;
import es.us.isa.FAMA.models.featureModel.Cardinality;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttribute;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.synopsis.common.Utils;
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
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.AdditiveExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.AndExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ArgsContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ArrayAtomContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ArrayContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ArrayExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.AssigExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.AtomExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.BooleanAtomContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.CardinalityContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Conf_serviceContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Conf_service_definitionContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.DependenciesContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.DependencyContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Derived_termsContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.DomainContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.EntryContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.EqualityExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ExcludesExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ExpressionContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.FloatAtomContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Global_termsContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Highly_conf_serviceContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Highly_conf_service_defContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.IdAtomContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.IffExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ImpliesExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.IntegerAtomContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ListExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.MaxExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.MinExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.MultiplicationExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.NotExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.OrExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ParExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ParametersContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.PropertyContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.RelationalExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Selectable_termsContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ServiceContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.ServicesContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.StringAtomContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.SumExprContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.TableContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Table_contentContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Table_expressionContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.Table_headerContext;

/**
 * @author jdelafuente
 *
 */
public class MyHCSVisitor implements HCSVisitor {

	FAMAAttributedFeatureModel model;
	List<AttributedFeature> subroots;
	private int nblocks;
	private List<String> tags;

	public MyHCSVisitor(FAMAAttributedFeatureModel needsModel, List<String> tags) {
		this.model = needsModel;
		subroots = new ArrayList<AttributedFeature>();
		nblocks = tags.size();
		this.tags = tags;
	}

	@Override
	public Object visitEntry(EntryContext ctx) {

		for (Conf_serviceContext conf_service_ctx : ctx.conf_service())
			visitConf_service(conf_service_ctx);

		for (Highly_conf_serviceContext highly_conf_service_ctx : ctx
				.highly_conf_service())
			visitHighly_conf_service(highly_conf_service_ctx);

		return model;
	}

	@Override
	public Object visitConf_service(Conf_serviceContext ctx) {
		for (int i = 0; i < nblocks; i++) {
			AttributedFeature feature = new AttributedFeature(tags.get(i) + "_"
					+ ctx.service_id.getText());
			subroots.add(feature);
			model.getAttributedFeatures().add(feature);
		}

		visitConf_service_definition(ctx.conf_service_definition());
		return null;
	}

	@Override
	public Object visitHighly_conf_service(Highly_conf_serviceContext ctx) {
		visitHighly_conf_service_def(ctx.highly_conf_service_def());
		return null;
	}

	@Override
	public Object visitHighly_conf_service_def(
			Highly_conf_service_defContext ctx) {

		visitGlobal_terms(ctx.global_terms());
		visitDependencies(ctx.dependencies());

		return null;
	}

	@Override
	public Object visitGlobal_terms(Global_termsContext ctx) {
		for (PropertyContext derived_term : ctx.property()) {
			Domain d = visitDomain(derived_term.dom);
			GenericAttribute ga = new GenericAttribute(
					derived_term.id.getText(), d, 0, 0);
			model.getRoot().addAttribute(ga);
		}
		return null;
	}

	@Override
	public Object visitConf_service_definition(
			Conf_service_definitionContext ctx) {
		visitSelectable_terms(ctx.selectable_terms());
		visitDerived_terms(ctx.derived_terms());
		visitDependencies(ctx.dependencies());
		return null;
	}

	@Override
	public Object visitSelectable_terms(Selectable_termsContext ctx) {
		for (int i = 0; i < nblocks; i++) {
			AttributedFeature subroot = subroots.get(i);
			for (PropertyContext select_term_ctx : ctx.property()) {
				String feature_name = tags.get(i) + "_"
						+ select_term_ctx.id.getText();
				AttributedFeature feature = new AttributedFeature(feature_name);

				Relation r = new Relation(subroot.getName() + "-"
						+ feature.getName());
				r.setParent(subroot);
				r.addDestination(feature);
				r.addCardinality(new Cardinality(1, 1));

				addRelationsByDomain(feature, select_term_ctx.dom,
						select_term_ctx.id.getText());

				model.searchFeatureByName(subroot.getName()).addRelation(r);
				model.getAttributedFeatures().add(feature);
			}
		}
		return null;
	}

	@Override
	public Object visitDerived_terms(Derived_termsContext ctx) {
		for (int i = 0; i < nblocks; i++) {
			AttributedFeature subroot = subroots.get(i);
			for (PropertyContext derived_term : ctx.property()) {
				Domain d = visitDomain(derived_term.dom);
				GenericAttribute ga = new GenericAttribute(
						derived_term.id.getText(), d, 0, 0);
				model.searchFeatureByName(subroot.getName()).addAttribute(ga);
			}
		}

		return null;
	}

	@Override
	public Object visitDependencies(DependenciesContext ctx) {
		for (DependencyContext depend_ctx : ctx.dependency())
			visitDependency(depend_ctx);

		for (TableContext table_ctx : ctx.table())
			visitTable(table_ctx);

		return null;
	}

	@Override
	public Object visitDependency(DependencyContext ctx) {

		Expression expr = visitExpression(ctx.expression());
		List<Expression> new_exprs = checkExpression(expr, expr);

		for (Expression exp : new_exprs) {
			ComplexConstraint c = new ComplexConstraint(exp.toString() + ";");
			model.addConstraint(c);
		}

		return null;
	}

	@Override
	public Object visitTable(TableContext ctx) {

		List<String> headers = visitTable_header(ctx.table_header());
		for (String tag : tags) {
			for (Table_expressionContext table_expr_ctx : ctx.table_content()
					.table_expression()) {

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < table_expr_ctx.atom().size(); i++) {
					Var var = new Var(tag + "_" + headers.get(i));
					if (getFeature(var) != null) {
						sb.append(var.getId().toString()
								+ "_"
								+ Util.withoutDoubleQuotes(table_expr_ctx.atom(
										i).getText()) + " == " + 1);
					} else {
						AttributedFeature root = subroots
								.get(tags.indexOf(tag));
						Var var2 = new Var(root.getName() + "."
								+ headers.get(i));

						if (getAttribute(var2) != null) {
							GenericAttribute att = getAttribute(var2);
							String data = table_expr_ctx.atom(i).getText();
							if (att.getDomain() instanceof RealDomain) {
								if (data.contains(".")) {
									try {
										Float f = Float.valueOf(data);
										sb.append(att.getFullName() + " == "
												+ f);
									} catch (NumberFormatException e) {
										throw new IllegalArgumentException(
												("Line "
														+ (ctx.start.getLine() + 1) + ": Number should be a float with format 00.00"));
									}
								} else {
									throw new IllegalArgumentException(
											("Line "
													+ (ctx.start.getLine() + 1) + ": Number should be a float with format 00.00"));
								}
							} else {
								sb.append(att.getFullName() + " == "
										+ Util.withoutDoubleQuotes(data));
							}
						}
					}

					if (i == table_expr_ctx.atom().size() - 2)
						sb.append(" " + LogicalOperator.IMPLIES + " ");
					else if (i < table_expr_ctx.atom().size() - 2)
						sb.append(" " + LogicalOperator.AND + " ");
				}

				ComplexConstraint c = new ComplexConstraint(sb.toString() + ";");
				model.addConstraint(c);
			}

		}
		return null;
	}

	@Override
	public List<String> visitTable_header(Table_headerContext ctx) {
		List<String> list = new ArrayList<String>();
		for (TerminalNode id_ctx : ctx.Identifier()) {
			list.add(id_ctx.getText());
		}
		return list;
	}

	@Override
	public Object visitTable_content(Table_contentContext ctx) {
		return null;
	}

	@Override
	public Object visitTable_expression(Table_expressionContext ctx) {
		return null;
	}

	public List<Expression> checkExpression(Expression expr,
			Expression parentExpr) {
		List<Expression> res = new ArrayList<Expression>();

		if (expr instanceof CompoundExpression) {
			CompoundExpression cexpr = (CompoundExpression) expr;

			Expression expr1 = cexpr.getExpression1();
			Expression expr2 = cexpr.getExpression2();

			if (expr1 instanceof Var) {
				Var var1 = (Var) expr1;

				if (model.getRoot().searchAttributeByName(
						var1.getId().toString()) != null) {
					if (cexpr instanceof RelationalExpression)
						res.add(getExpressionType2(var1, expr2, cexpr, expr));

				} else if (getAttribute(var1) != null) {
					for (int i = 0; i < nblocks; i++) {
						String tag = tags.get(i);
						res.addAll(getExpressionType1(var1, expr2, cexpr, expr,
								tag));
					}

				}

				if (expr2 instanceof Var) {

				}
			} else if (expr1 instanceof CompoundExpression) {
				res.add(getExpressionType3(expr1, expr2, cexpr));
			}
		}

		return res;
	}

	/**
	 * @return
	 */
	private List<Expression> getExpressionType1(Var var1, Expression expr2,
			Expression cexpr, Expression expr, String tag) {

		List<Expression> res = new ArrayList<Expression>();

		AttributedFeature aux = subroots.get(tags.indexOf(tag));
		AttributedFeature root = model.searchFeatureByName(aux.getName());
		GenericAttribute attr1 = root.searchAttributeByName(var1.getId()
				.toString());

		String op = "", op2 = "";

		if (expr2 instanceof Var) {
			Var var2 = (Var) expr2;
			GenericAttribute attr2 = getAttribute(var2);
		} else if (expr2 instanceof CompoundExpression) {
			CompoundExpression cexpr2 = (CompoundExpression) expr2;

			Var var2 = (Var) cexpr2.getExpression1();

			GenericAttribute attr2 = root.searchAttributeByName(var2.getId()
					.toString());

			if (attr2 == null)
				attr2 = getAttribute(var2);

			if (cexpr2.getExpression2() instanceof Atomic) {
				Atomic atom = (Atomic) cexpr2.getExpression2();

				if (cexpr2 instanceof ArithmeticExpression) {
					ArithmeticExpression arexpr = (ArithmeticExpression) cexpr2;
					switch ((ArithmeticOperator) arexpr.getOperator()) {
					case ADD:
						op2 = " + ";
						break;
					case SUBTRACT:
						op2 = " - ";
						break;
					case MULTIPLY:
						op2 = " * ";
						break;
					case DIVIDE:
						op2 = " / ";
						break;
					}
				}

				if (expr instanceof RelationalExpression) {
					RelationalExpression rexpr = (RelationalExpression) expr;
					switch ((RelationalOperator) rexpr.getOperator()) {
					case EQ:
						String exp = attr1.getFullName() + " == "
								+ attr2.getFullName() + op2 + atom;
						res.add(Expression.parse(exp));
						break;
					}
				}

			} else if (cexpr2.getExpression2() instanceof Var) {
				Var var3 = (Var) cexpr2.getExpression2();

				Var featvar3 = new Var(tag + "_" + var3.getId().toString());

				if (getFeature(featvar3) != null) {

					AttributedFeature feature = getFeature(featvar3);

					if (cexpr2 instanceof ArithmeticExpression) {
						ArithmeticExpression arexpr = (ArithmeticExpression) cexpr2;
						switch ((ArithmeticOperator) arexpr.getOperator()) {
						case ADD:
							op2 = " + ";
							break;
						case SUBTRACT:
							op2 = " - ";
							break;
						case MULTIPLY:
							op2 = " * ";
							break;
						case DIVIDE:
							op2 = " / ";
							break;
						}
					}

					if (expr instanceof RelationalExpression) {
						RelationalExpression rexpr = (RelationalExpression) expr;

						RangeIntegerDomain d = (RangeIntegerDomain) feature
								.getDomain();
						Range r = d.getRanges().iterator().next();

						switch ((RelationalOperator) rexpr.getOperator()) {
						case EQ:
							for (int i = r.getMin(); i <= r.getMax(); i++) {
								String subfeature = feature.getName() + "_" + i;
								String exp = subfeature + " == 1 IMPLIES "
										+ attr1.getFullName() + " == "
										+ attr2.getFullName() + op2 + i;

								res.add(Expression.parse(exp));
							}
							break;
						}
					}
				} else if (getAttribute(var3) != null) {
					GenericAttribute attr3 = root.searchAttributeByName(var3
							.getId().toString());

					if (cexpr2 instanceof ArithmeticExpression) {
						ArithmeticExpression arexpr = (ArithmeticExpression) cexpr2;
						switch ((ArithmeticOperator) arexpr.getOperator()) {
						case ADD:
							op2 = " + ";
							break;
						case SUBTRACT:
							op2 = " - ";
							break;
						case MULTIPLY:
							op2 = " * ";
							break;
						case DIVIDE:
							op2 = " / ";
							break;
						}
					}

					if (expr instanceof RelationalExpression) {
						RelationalExpression rexpr = (RelationalExpression) expr;
						switch ((RelationalOperator) rexpr.getOperator()) {
						case EQ:
							String exp = attr1.getFullName() + " == "
									+ attr2.getFullName() + op2
									+ attr3.getFullName();
							res.add(Expression.parse(exp));
							break;
						}
					}
				}
			}
		}

		return res;
	}

	private Expression getExpressionType2(Var var1, Expression expr2,
			Expression cexpr, Expression expr) {
		Expression res = null;
		GenericAttribute attr1 = getAttribute(var1);

		AttributedFeature root = model.getRoot();
		String op = "", op2 = "";

		if (expr2 instanceof Var) {
			Var var2 = (Var) expr2;
			GenericAttribute attr2 = getAttribute(var2);
		} else if (expr2 instanceof CompoundExpression) {
			
			CompoundExpression cexpr2 = (CompoundExpression) expr2;

			Var var2 = (Var) cexpr2.getExpression1();

			if (getAttribute(var2) != null) {

				GenericAttribute attr2 = root.searchAttributeByName(var2
						.getId().toString());

				if (attr2 == null)
					attr2 = getAttribute(var2);

				if (cexpr2.getExpression2() instanceof Atomic) {
					Atomic atom = (Atomic) cexpr2.getExpression2();

					if (cexpr2 instanceof ArithmeticExpression) {
						ArithmeticExpression arexpr = (ArithmeticExpression) cexpr2;
						switch ((ArithmeticOperator) arexpr.getOperator()) {
						case ADD:
							op2 = " + ";
							break;
						case SUBTRACT:
							op2 = " - ";
							break;
						case MULTIPLY:
							op2 = " * ";
							break;
						case DIVIDE:
							op2 = " / ";
							break;
						}
					}

					if (expr instanceof RelationalExpression) {
						RelationalExpression rexpr = (RelationalExpression) expr;
						switch ((RelationalOperator) rexpr.getOperator()) {
						case EQ:
							String exp = attr1.getFullName() + " == "
									+ attr2.getFullName() + op2 + atom;
							res = Expression.parse(exp);
							break;
						}
					}

				} else if (cexpr2.getExpression2() instanceof Var) {
					Var var3 = (Var) cexpr2.getExpression2();

					if (getAttribute(var3) != null) {
						GenericAttribute attr3 = root
								.searchAttributeByName(var3.getId().toString());
						
						if(attr3 == null)
							attr3 = getAttribute(var3);

						if (cexpr2 instanceof ArithmeticExpression) {
							ArithmeticExpression arexpr = (ArithmeticExpression) cexpr2;
							switch ((ArithmeticOperator) arexpr.getOperator()) {
							case ADD:
								op2 = " + ";
								break;
							case SUBTRACT:
								op2 = " - ";
								break;
							case MULTIPLY:
								op2 = " * ";
								break;
							case DIVIDE:
								op2 = " / ";
								break;
							}
						}

						if (expr instanceof RelationalExpression) {
							RelationalExpression rexpr = (RelationalExpression) expr;
							switch ((RelationalOperator) rexpr.getOperator()) {
							case EQ:
								String exp = attr1.getFullName() + " == "
										+ attr2.getFullName() + op2
										+ attr3.getFullName();
								res = Expression.parse(exp);
								break;
							}
						}
					}
				}
			} else {
				if (cexpr instanceof RelationalExpression) {
					RelationalExpression rexpr = (RelationalExpression) cexpr;
					switch ((RelationalOperator) rexpr.getOperator()) {
					case EQ:
						res = Expression.parse(attr1.getFullName() + " == "
								+ expr2.toString());

					}
				}
			}
		}

		return res;
	}

	private Expression getExpressionType3(Expression expr1, Expression expr2,
			Expression cexpr) {

		CompoundExpression cexpr1 = (CompoundExpression) expr1;
		CompoundExpression cexpr2 = (CompoundExpression) expr2;

		if (cexpr1.getExpression1() instanceof Var) {
			Var var1 = (Var) cexpr1.getExpression1();
			GenericAttribute attr1 = getAttribute(var1);
			var1.setId(attr1.getFullName());
		}

		if (cexpr2.getExpression1() instanceof Var) {
			Var var2 = (Var) cexpr2.getExpression1();
			GenericAttribute attr2 = getAttribute(var2);
			var2.setId(attr2.getFullName());
		}

		if (cexpr2.getExpression2() instanceof CompoundExpression) {
			CompoundExpression comp_expr = (CompoundExpression) cexpr2
					.getExpression2();
			if (comp_expr.getExpression1() instanceof Var) {
				Var var1 = (Var) comp_expr.getExpression1();
				GenericAttribute attr1 = getAttribute(var1);
				var1.setId(attr1.getFullName());
			}
			if (comp_expr.getExpression2() instanceof Var) {
				Var var2 = (Var) comp_expr.getExpression2();
				GenericAttribute attr2 = getAttribute(var2);
				var2.setId(attr2.getFullName());
			}
		}

		return cexpr;
	}

	public AttributedFeature getFeature(Var var) {
		for (AttributedFeature feat : model.getAttributedFeatures()) {
			if (feat.getName().equals(var.getId().toString()))
				return feat;
		}
		return null;
	}

	public GenericAttribute getAttribute(Var var) {
		for (AttributedFeature feat : model.getAttributedFeatures()) {
			for (GenericAttribute att : feat.getAttributes()) {
				if (att.getFullName().equals(var.getId().toString()))
					return att;
				if (att.getName().equals(var.getId().toString()))
					return att;
			}
		}

		return null;
	}

	@Override
	public Object visitProperty(PropertyContext ctx) {
		return null;
	}

	public void addRelationsByDomain(AttributedFeature feature,
			DomainContext ctx, String originalFeatName)
			throws IllegalArgumentException {

		Relation rel = new Relation("rel-" + feature.getName());
		feature.setDomain(visitDomain(ctx));
		rel.setParent(feature);

		switch (ctx.datatype.getType()) {
		case HCSParser.INTEGER:
		case HCSParser.FLOAT:
			Integer min = Integer.valueOf(ctx.min.getText());
			Integer max = Integer.valueOf(ctx.max.getText());
			if ((max - min) + 1 > 20) {
				throw new IllegalArgumentException("Range of selectable term '"
						+ originalFeatName + "' is too large ("
						+ ((max - min) + 1) + "); Maximum range allowed is 20");
			} else {
				rel.addCardinality(new Cardinality(1, 1));
				for (int i = min; i <= max; i++) {
					AttributedFeature sub_feature = new AttributedFeature(
							feature.getName() + "_" + i);
					rel.addDestination(sub_feature);
				}
			}
			break;
		case HCSParser.BOOLEAN:
			rel.addCardinality(new Cardinality(1, 1));
			AttributedFeature sub_feature_true = new AttributedFeature(
					feature.getName() + "_true");
			rel.addDestination(sub_feature_true);
			AttributedFeature sub_feature_false = new AttributedFeature(
					feature.getName() + "_false");
			rel.addDestination(sub_feature_false);
			break;
		case HCSParser.SET:
		case HCSParser.ENUM:
			if (ctx.parameters().size() > 20) {
				throw new IllegalArgumentException("Range of selectable term '"
						+ originalFeatName + "' is too large ("
						+ ctx.parameters().size()
						+ "); Maximum range allowed is 20");
			} else {
				rel.addCardinality(new Cardinality(1, 1));
				for (ParametersContext param : ctx.parameters()) {
					AttributedFeature sub_feature = new AttributedFeature(
							feature.getName()
									+ "_"
									+ Utils.withoutDoubleQuotes(param.getText()));
					rel.addDestination(sub_feature);
				}
			}
			break;
		}

		feature.addRelation(rel);
	}

	@Override
	public Domain visitDomain(DomainContext ctx) {
		Domain d = null;
		switch (ctx.datatype.getType()) {
		case HCSParser.INTEGER:
			RangeIntegerDomain rid = new RangeIntegerDomain();
			Integer min = Integer.valueOf(ctx.min.getText());
			Integer max = Integer.valueOf(ctx.max.getText());
			rid.addRange(new Range(min, max));
			d = rid;
			break;
		case HCSParser.FLOAT:
			d = new RealDomain(Double.valueOf(ctx.min.getText()),
					Double.valueOf(ctx.max.getText()));
			break;
		case HCSParser.BOOLEAN:
			RangeIntegerDomain boold = new RangeIntegerDomain();
			boold.addRange(new Range(0, 1));
			d = boold;
			break;
		case HCSParser.SET:
		case HCSParser.ENUM:
			ObjectDomain objd = new ObjectDomain();
			for (ParametersContext param : ctx.parameters()) {
				objd.addValue(param.getText());
			}
			d = objd;
		}
		return d;
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
		case "SumExprContext":
			res = this.visitSumExpr((SumExprContext) ctx);
			break;
		case "MinExprContext":
			res = this.visitMinExpr((MinExprContext) ctx);
			break;
		case "MaxExprContext":
			res = this.visitMaxExpr((MaxExprContext) ctx);
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
	public Expression visitSumExpr(SumExprContext ctx) {

		Expression expr = visitExpression(ctx.expression());
		String varId = "";
		if (expr instanceof Var) {
			Var var = (Var) expr;
			String id = var.getId().toString();
			varId = id.substring(id.indexOf("."));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < subroots.size(); i++) {
			AttributedFeature subroot = subroots.get(i);
			sb.append(subroot.getName() + varId);
			if (i < subroots.size())
				sb.append(" + ");
		}
		Expression res = Expression.parse(sb.toString());
		return res;
	}

	@Override
	public Expression visitMinExpr(MinExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitMaxExpr(MaxExprContext ctx) {
		// TODO Auto-generated method stub
		return null;
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
		case HCSParser.ASTERISK:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.MULTIPLY);
		case HCSParser.SLASH:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.DIVIDE);
		default:
			throw new RuntimeException("unknown operator: "
					+ HCSParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitAdditiveExpr(@NotNull AdditiveExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case HCSParser.PLUS:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.ADD);
		case HCSParser.HYPHEN:
			return new ArithmeticExpression(e1, e2, ArithmeticOperator.SUBTRACT);
		default:
			throw new RuntimeException("unknown operator: "
					+ HCSParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitRelationalExpr(@NotNull RelationalExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case HCSParser.LTE:
			return new RelationalExpression(e1, e2, RelationalOperator.LTE);
		case HCSParser.GTE:
			return new RelationalExpression(e1, e2, RelationalOperator.GTE);
		case HCSParser.LT:
			return new RelationalExpression(e1, e2, RelationalOperator.LT);
		case HCSParser.GT:
			return new RelationalExpression(e1, e2, RelationalOperator.GT);
		default:
			throw new RuntimeException("unknown operator: "
					+ HCSParser.tokenNames[ctx.op.getType()]);
		}
	}

	@Override
	public Expression visitEqualityExpr(@NotNull EqualityExprContext ctx) {

		Expression e1 = this.visitExpression(ctx.expression(0));
		Expression e2 = this.visitExpression(ctx.expression(1));

		switch (ctx.op.getType()) {
		case HCSParser.EQ:
			return new RelationalExpression(e1, e2, RelationalOperator.EQ);
		case HCSParser.NEQ:
			return new RelationalExpression(e1, e2, RelationalOperator.NEQ);
		default:
			throw new IllegalArgumentException("unknown operator: "
					+ HCSParser.tokenNames[ctx.op.getType()]);
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
	public Expression visitList(HCSParser.ListContext ctx) {
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
		}

		return res;
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
	public Object visitServices(ServicesContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitService(ServiceContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCardinality(CardinalityContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitArgs(ArgsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitParameters(ParametersContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
