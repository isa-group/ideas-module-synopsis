package es.us.isa.ideas.synopsis.common;

import ilog.concert.IloException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.AttributedFeature;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.FAMAAttributedFeatureModel;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.Relation;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.fileformats.AttributedReader;
import es.us.isa.FAMA.models.config.ConfigParser;
import es.us.isa.FAMA.models.config.ConfigParserResult;
import es.us.isa.FAMA.models.config.ExtendedConfigParser;
import es.us.isa.FAMA.models.domain.Domain;
import es.us.isa.FAMA.models.domain.IntegerDomain;
import es.us.isa.FAMA.models.domain.ObjectDomain;
import es.us.isa.FAMA.models.domain.Range;
import es.us.isa.FAMA.models.domain.RangeIntegerDomain;
import es.us.isa.FAMA.models.domain.RealDomain;
import es.us.isa.FAMA.models.domain.SetIntegerDomain;
import es.us.isa.FAMA.models.featureModel.Cardinality;
import es.us.isa.FAMA.models.featureModel.Constraint;
import es.us.isa.FAMA.models.featureModel.GenericFeature;
import es.us.isa.FAMA.models.featureModel.GenericRelation;
import es.us.isa.FAMA.models.featureModel.KeyWords;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttribute;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttributedFeature;
import es.us.isa.FAMA.models.variabilityModel.VariabilityElement;
import es.us.isa.FAMA.models.variabilityModel.VariabilityModel;
import es.us.isa.FAMA.stagedConfigManager.ExtendedConfiguration;
import es.us.isa.aml.model.csp.CSPConstraint;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.model.csp.CSPObjectiveFunction;
import es.us.isa.aml.model.csp.CSPRange;
import es.us.isa.aml.model.csp.CSPVar;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.CompoundExpression;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.ParenthesisExpression;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.util.Node;
import es.us.isa.util.Tree;

/**
 * @author jdelafuente
 *
 */
public class CSPGenerator {

	public static String COST_ATTRIBUTE = ".cost";

	protected CSPModel model;

	protected Map<String, CSPVar> featureVars;
	protected Map<String, CSPVar> attVars;
	protected Map<String, GenericFeature> features;
	protected Map<String, GenericAttribute> atts;

	public CSPGenerator() {
		model = new CSPModel();
		featureVars = new HashMap<String, CSPVar>();
		attVars = new HashMap<String, CSPVar>();
		features = new HashMap<String, GenericFeature>();
		atts = new HashMap<String, GenericAttribute>();
	}
	
	public CSPModel generateOPL(String vm_data) {

		AttributedReader parser = new AttributedReader();

		try {
			VariabilityModel vm = parser.parseString(vm_data);
			FAMAAttributedFeatureModel afm = (FAMAAttributedFeatureModel) vm;

			generateVariables(afm);
			AttributedFeature root = afm.getRoot();
			addRoot(root);
			generateConstraints(root);
			Iterator<Constraint> it = afm.getConstraints().iterator();
			while (it.hasNext()) {
				Constraint c = it.next();
				addConstraint(c);
			}

//			ConvertFloats();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return model;
	}

	public CSPModel generateOPL(String vm_data, String config_data) {

		AttributedReader parser = new AttributedReader();

		try {
			VariabilityModel vm = parser.parseString(vm_data);
			FAMAAttributedFeatureModel afm = (FAMAAttributedFeatureModel) vm;
			ConfigParser cfp = new ExtendedConfigParser(afm);
			ConfigParserResult config = cfp
					.parseConfigurationString(config_data);
			ExtendedConfiguration extended_config = (ExtendedConfiguration) config
					.getConfig();

			generateVariables(afm);
			AttributedFeature root = afm.getRoot();
			addRoot(root);
			generateConstraints(root);
			Iterator<Constraint> it = afm.getConstraints().iterator();
			while (it.hasNext()) {
				Constraint c = it.next();
				addConstraint(c);
			}

			if (config.getErrors().size() == 0) {
				processConfig(extended_config);
			}

			ConvertFloats();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return model;
	}

	protected void addRoot(GenericAttributedFeature feature) {
		CSPVar cspVar = featureVars.get(feature.getName());
		Expression expr = new RelationalExpression(new Var(cspVar.getId()),
				new Atomic(true), RelationalOperator.EQ);
		CSPConstraint constraint = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr);
		model.addConstraint(constraint);
		setObjectiveFunction(feature);
	}

	private void setObjectiveFunction(GenericAttributedFeature root) {
		CSPVar var = attVars.get(root.getName() + COST_ATTRIBUTE);
		if (var != null) {
			CSPObjectiveFunction obj = new CSPObjectiveFunction(true,
					new Atomic(var.getId()));
			model.setObjectiveFunction(obj);
		}
	}

	private void generateVariables(FAMAAttributedFeatureModel afm) {
		Iterator<AttributedFeature> it = afm.getAttributedFeatures().iterator();
		while (it.hasNext()) {
			AttributedFeature f = (AttributedFeature) it.next();
			Relation parentRelation = f.getParent();
			if (parentRelation != null
					&& parentRelation.getNumberOfDestination() == 1
					&& parentRelation.getCardinalities().hasNext()) {
				Iterator<Cardinality> itc = parentRelation.getCardinalities();
				Collection<Cardinality> cards = new ArrayList<Cardinality>();
				while (itc.hasNext())
					cards.add(itc.next());
				addFeature(f, cards);
			} else {
				ArrayList<Cardinality> cards = new ArrayList<Cardinality>();
				cards.add(new Cardinality(0, 1));
				addFeature(f, cards);
			}
		}
	}

	private void addFeature(AttributedFeature feature,
			Collection<Cardinality> cards) {
		GenericAttributedFeature f = (GenericAttributedFeature) feature;
		createFeature(f, cards);
		try {
			addAttributes(f);
		} catch (IloException e) {
			e.printStackTrace();
		}
	}

	private void createFeature(GenericAttributedFeature feature,
			Collection<Cardinality> cards) {
		CSPVar cspFVar = new CSPVar(replaceDot(feature.getName()), "boolean",
				true);
		model.addVar(cspFVar);
		this.featureVars.put(feature.getName(), cspFVar);
		this.features.put(feature.getName(), feature);
	}

	private void addAttributes(GenericAttributedFeature feature)
			throws IloException {
		CSPVar cspFeatureVar = this.featureVars.get(feature.getName());
		Collection<? extends GenericAttribute> attCol = feature.getAttributes();
		for (GenericAttribute a : attCol) {
			Domain d = a.getDomain();
			CSPVar cspVar = null;
			if (d instanceof IntegerDomain) {
				if (d instanceof RangeIntegerDomain) {
					RangeIntegerDomain rangeDomain = (RangeIntegerDomain) d;
					Set<Range> ranges = rangeDomain.getRanges();
					// XXX we consider just the first range
					Range range = ranges.iterator().next();

					CSPRange csp_range = new CSPRange("range_" + a.getName(),
							new es.us.isa.aml.model.Range(range.getMin(),
									range.getMax()));

					model.addRange(csp_range);

					cspVar = new CSPVar(replaceDot(a.getFullName()), "integer",
							csp_range, true);
					model.addVar(cspVar);
					attVars.put(a.getFullName(), cspVar);
				} else if (d instanceof SetIntegerDomain) {
					// TODO
				}
			} else if (d instanceof RealDomain) {
				RealDomain rd = (RealDomain) d;
				es.us.isa.aml.model.Range range_domain = new es.us.isa.aml.model.Range(
						(rd.getLowerBound()),
						(rd.getUpperBound()));
				CSPRange csp_range = new CSPRange("range_" + a.getName(), "float",
						range_domain);
				model.addRange(csp_range);

				cspVar = new CSPVar(replaceDot(a.getFullName()), "real",
						csp_range, true);
				model.addVar(cspVar);
				attVars.put(a.getFullName(), cspVar);
			} else if (d instanceof ObjectDomain) {
				// TODO
			}

			atts.put(a.getFullName(), a);

			// XXX we consider 0 as the default value of every attribute
			Expression e1 = new RelationalExpression(new Var(
					cspFeatureVar.getId()), new Atomic(false),
					RelationalOperator.EQ);
			Expression e2 = null;
			if (isFeature(cspVar.getId())) {
				e2 = new RelationalExpression(new Var(cspVar.getId()),
						new Atomic(false), RelationalOperator.EQ);
			} else {
				e2 = new RelationalExpression(new Var(cspVar.getId()),
						new Atomic(0), RelationalOperator.EQ);
			}
			Expression expr = new LogicalExpression(e1, e2,
					LogicalOperator.IMPLIES);

			CSPConstraint constraint = new CSPConstraint("C"
					+ (model.getConstraints().size() + 1), expr);
			model.addConstraint(constraint);

		}

	}

	private void generateConstraints(AttributedFeature f) {
		Iterator<Relation> relations = f.getRelations();
		while (relations.hasNext()) {
			Relation rel = relations.next();
			if (rel.getNumberOfDestination() == 1) {
				if (rel.isMandatory()) {
					addMandatory(rel,
							(GenericAttributedFeature) rel.getDestinationAt(0),
							(GenericAttributedFeature) f);
				} else if (rel.isOptional()) {
					addOptional(rel,
							(GenericAttributedFeature) rel.getDestinationAt(0),
							(GenericAttributedFeature) f);
				} else {
					addCardinality(rel,
							(GenericAttributedFeature) rel.getDestinationAt(0),
							(GenericAttributedFeature) f,
							rel.getCardinalities());
				}
				generateConstraints(rel.getDestinationAt(0));
			} else {
				Collection<GenericFeature> children = new ArrayList<GenericFeature>();
				Iterator<AttributedFeature> it = rel.getDestination();
				while (it.hasNext()) {
					AttributedFeature child = it.next();
					children.add(child);
					generateConstraints(child);
				}
				Collection<Cardinality> cards = new ArrayList<Cardinality>();
				Iterator<Cardinality> itc = rel.getCardinalities();
				while (itc.hasNext()) {
					cards.add(itc.next());
				}
				addSet(rel, f, children, cards);
			}
		}
	}

	public void addSet(GenericRelation rel, GenericFeature parent,
			Collection<GenericFeature> children,
			Collection<Cardinality> cardinalities) {

		GenericAttributedFeature p = (GenericAttributedFeature) parent;
		Collection<GenericAttributedFeature> c = new ArrayList<GenericAttributedFeature>();
		Iterator<GenericFeature> it = children.iterator();
		while (it.hasNext()) {
			GenericFeature aux = it.next();
			if (aux instanceof GenericAttributedFeature) {
				c.add((GenericAttributedFeature) aux);
			} else {
				throw new IllegalArgumentException(
						"No AttributedFeature detected");
			}
		}
		addSet_(rel, p, c, cardinalities);

	}

	protected void addSet_(GenericRelation rel,
			GenericAttributedFeature parent,
			Collection<GenericAttributedFeature> children,
			Collection<Cardinality> cardinalities) {

		Cardinality c = cardinalities.iterator().next();

		CSPVar cspCardVar = new CSPVar(parent.getName() + "_cardVar",
				"integer", new CSPRange(new es.us.isa.aml.model.Range(0,
						c.getMax())), true);
		model.addVar(cspCardVar);

		List<String> featVars = new LinkedList<String>();
		for (GenericAttributedFeature f : children) {
			featVars.add(featureVars.get(f.getName()).getId());
		}
		String str_expr = featVars.toString().replaceAll("[\\[\\]]", "")
				.replaceAll(", ", " + ");
		Expression cons1_e2 = Expression.parse(str_expr);

		// cardVar == cp.sum(vars);*

		Expression expr1 = new RelationalExpression(
				new Var(cspCardVar.getId()), cons1_e2, RelationalOperator.EQ);
		CSPConstraint cons1 = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr1);
		model.addConstraint(cons1);

		// (parentVar == 0) => (cardVar == 0);

		Expression cons2_e1 = null;

		if (isFeature(parent.getName()))
			cons2_e1 = new RelationalExpression(new Var(parent.getName()),
					new Atomic(false), RelationalOperator.EQ);
		else
			cons2_e1 = new RelationalExpression(new Var(parent.getName()),
					new Atomic(0), RelationalOperator.EQ);

		Expression cons2_e2 = new RelationalExpression(new Var(
				cspCardVar.getId()), new Atomic(0), RelationalOperator.EQ);

		Expression expr2 = new LogicalExpression(cons2_e1, cons2_e2,
				LogicalOperator.IMPLIES);
		CSPConstraint cons2 = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr2);
		model.addConstraint(cons2);

		// (parentVar != 0) => (cardVar >= c.getMin() && cardVar <= c.getMax());

		Expression cons3_e1 = null;

		if (isFeature(parent.getName()))
			cons3_e1 = new RelationalExpression(new Var(parent.getName()),
					new Atomic(true), RelationalOperator.EQ);
		else
			cons3_e1 = new RelationalExpression(new Var(parent.getName()),
					new Atomic(0), RelationalOperator.NEQ);

		Expression cons3_e2 = new RelationalExpression(new Var(
				cspCardVar.getId()), new Atomic(c.getMin()),
				RelationalOperator.GTE);

		Expression cons3_e3 = new RelationalExpression(new Var(
				cspCardVar.getId()), new Atomic(c.getMax()),
				RelationalOperator.LTE);

		Expression cons3_e4 = new LogicalExpression(cons3_e2, cons3_e3,
				LogicalOperator.AND);

		Expression expr3 = new LogicalExpression(cons3_e1, cons3_e4,
				LogicalOperator.IMPLIES);
		CSPConstraint cons3 = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr3);
		model.addConstraint(cons3);

	}

	protected void addMandatory(GenericRelation rel,
			GenericAttributedFeature child, GenericAttributedFeature parent) {
		CSPVar cspChildV = featureVars.get(child.getName());
		CSPVar cspParentV = featureVars.get(parent.getName());
		Expression expr = new RelationalExpression(new Var(cspChildV.getId()),
				new Var(cspParentV.getId()), RelationalOperator.EQ);
		CSPConstraint constraint = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr);
		model.addConstraint(constraint);
	}

	protected void addOptional(GenericRelation rel,
			GenericAttributedFeature child, GenericAttributedFeature parent) {
		CSPVar cspChildV = featureVars.get(child.getName());
		CSPVar cspParentV = featureVars.get(parent.getName());

		Expression e1 = new RelationalExpression(new Var(cspChildV.getId()),
				new Atomic(false), RelationalOperator.EQ);
		Expression e2 = null;
		if (isFeature(cspParentV.getId())) {
			e2 = new RelationalExpression(new Var(cspParentV.getId()),
					new Atomic(false), RelationalOperator.EQ);
		} else {
			e2 = new RelationalExpression(new Var(cspParentV.getId()),
					new Atomic(0), RelationalOperator.EQ);
		}
		Expression expr = new LogicalExpression(e1, e2, LogicalOperator.IMPLIES);
		CSPConstraint constraint = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr);
		model.addConstraint(constraint);
	}

	private void addConstraint(Constraint c) {
		// String constring = cons.toString().substring(
		// cons.toString().lastIndexOf("constraint")
		// + "constraint".length());
		// Expression expr = Expression.parse(constring.replaceAll("(\\|\\|)",
		// "OR"));
		// System.out.println("exp: " + cons.toString());
		// System.out.println("expr: " + expr);

		Expression expr = Expression.parse(c.getAST().toString());
		expr = checkExpression(expr);

		for (Var v : Expression.getVars(expr)) {
			if (isFeature(v.getId().toString())) {
				CSPVar var = featureVars.get(v.getId().toString());
				expr = Expression.parse(expr.toString().replaceAll((String) v.getId(), var.getId()));
			} else {
				CSPVar var = attVars.get(v.getId().toString());
				expr = Expression.parse(expr.toString().replaceAll((String) v.getId(), var.getId()));
			}
		}
		CSPConstraint constraint = new CSPConstraint("C"
				+ (model.getConstraints().size() + 1), expr);
		model.addConstraint(constraint);
	}

	public Expression checkExpression(Expression currentExpr) {
		return checkExpression(currentExpr, currentExpr);
	}

	private Expression checkExpression(Expression currentExpr,
			Expression parentExpr) {

		Expression res = null;
		
		Boolean parenthesis = false;
		
		if(currentExpr instanceof ParenthesisExpression){
			currentExpr = ((ParenthesisExpression) currentExpr).getInnerExpression();
			parenthesis = true;
		}

		if (currentExpr instanceof CompoundExpression) {			
			CompoundExpression compoundExpr = (CompoundExpression) currentExpr;
			if (compoundExpr instanceof LogicalExpression) {
				CompoundExpression logexpr = (LogicalExpression) compoundExpr;
				if (logexpr.getOperator() == LogicalOperator.NOT) {
					Expression e1 = logexpr.getExpression1();
					if (e1 instanceof Var) {
						if (isFeature(e1.toString())) {
							CompoundExpression newexpr = new RelationalExpression(
									e1, new Atomic(false),
									RelationalOperator.EQ);
							res = newexpr;
						}
					} else {
						parentExpr = logexpr;
						res = checkExpression(e1, parentExpr);
					}

				} else {
					parentExpr = currentExpr;
					compoundExpr.setExpression1(checkExpression(
							compoundExpr.getExpression1(), parentExpr));
					compoundExpr.setExpression2(checkExpression(
							compoundExpr.getExpression2(), parentExpr));

					res = compoundExpr;
				}
			} else {
				res = currentExpr;
			}

		} else {
			if (currentExpr instanceof Var) {
				if (isFeature(currentExpr.toString())) {
					Expression newexpr = new RelationalExpression(
							currentExpr, new Atomic(true),
							RelationalOperator.EQ);
					res = newexpr;
				}
			}

		}

		if (parenthesis)
			res = new ParenthesisExpression(res);
		
		return res;
	}

	private void processConfig(ExtendedConfiguration extended_config) {
		Set<Entry<VariabilityElement, Integer>> elems = extended_config
				.getElements().entrySet();
		for (Entry<VariabilityElement, Integer> e : elems) {
			CSPConstraint c = null;
			if (e.getKey() instanceof GenericFeature) {
				CSPVar feature = featureVars.get(e.getKey().getName());
				Expression expr = new RelationalExpression(new Var(
						feature.getId()), new Atomic(e.getValue()),
						RelationalOperator.EQ);
				c = new CSPConstraint(
						"C" + (model.getConstraints().size() + 1), expr);
				model.addConstraint(c);
			} else if (e.getKey() instanceof GenericAttribute) {
				CSPVar feature = attVars.get(e.getKey().getName());
				Expression expr = new RelationalExpression(new Var(
						feature.getId()), new Atomic(e.getValue()),
						RelationalOperator.EQ);
				c = new CSPConstraint(
						"C" + (model.getConstraints().size() + 1), expr);
				model.addConstraint(c);
			}
		}

		Set<Entry<GenericAttribute, Double>> atts = extended_config
				.getAttValues().entrySet();
		Collection<Tree<String>> constraints = extended_config.getAttConfigs();

		for (Entry<GenericAttribute, Double> e : atts) {
			CSPVar att = attVars.get(e.getKey().getFullName());
			Expression expr = new RelationalExpression(new Var(att.getId()),
					new Atomic(e.getValue()), RelationalOperator.EQ);
			CSPConstraint c = new CSPConstraint("C"
					+ (model.getConstraints().size() + 1), expr);
			model.addConstraint(c);
		}

		for (Tree<String> tree : constraints) {
			Node<String> node = tree.getRootElement();
			List<Node<String>> children = node.getChildren();
			int size = children.size();
			String data = node.getData();

			if (size == 2) {
				Expression expr = Expression.parse(node.toString());
				for (Var v : Expression.getVars(expr)) {
					if (isFeature(v.getId().toString())) {
						CSPVar var = featureVars.get(v.getId().toString());
						expr = Expression.parse(expr.toString().replaceAll((String) v.getId(), var.getId()));
					} else {
						CSPVar var = attVars.get(v.getId().toString());
						expr = Expression.parse(expr.toString().replaceAll((String) v.getId(), var.getId()));
					}
				}
				CSPConstraint constraint = new CSPConstraint("C"
						+ (model.getConstraints().size() + 1), expr);
				model.addConstraint(constraint);
			} else if (size == 1) {
				if (data.equals(KeyWords.NOT)) {
					CSPVar var = featureVars.get(children.get(0).toString());
					Expression expr = new RelationalExpression(new Var(
							var.getId()), new Atomic(false),
							RelationalOperator.EQ);
					CSPConstraint constraint = new CSPConstraint("C"
							+ (model.getConstraints().size() + 1), expr);
					model.addConstraint(constraint);
				}
			} else {
				CSPVar var = featureVars.get(data);
				Expression expr = new RelationalExpression(
						new Var(var.getId()), new Atomic(true),
						RelationalOperator.EQ);
				CSPConstraint constraint = new CSPConstraint("C"
						+ (model.getConstraints().size() + 1), expr);
				model.addConstraint(constraint);
			}
		}
	}

	protected void addCardinality(GenericRelation rel,
			GenericAttributedFeature child, GenericAttributedFeature parent,
			Iterator<Cardinality> cardinalities) {
		// TODO Auto-generated method stub

	}

	private boolean isFeature(String id) {
		return features.containsKey(id);
	}

	private void ConvertFloats() {
		for (CSPConstraint c : model.getConstraints()) {
			Expression expr = c.getExpr();
			for (Atomic a : Expression.getAtomics(expr)) {
				if (isFloat(a.calculate())) {
					Float f = Float.valueOf((String) a.calculate());
					a.setValue(f);
				} else {
//					System.out.println("otro: " + a.calculate());
				}
			}
		}
	}

	private static boolean isFloat(Object n) {
		try {
			Double d = Double.valueOf(n.toString());
			return (d % 1) != 0 || n.toString().contains(".");
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static String replaceDot(String str) {
		return str.replaceAll("\\.", "_");
	}
}
