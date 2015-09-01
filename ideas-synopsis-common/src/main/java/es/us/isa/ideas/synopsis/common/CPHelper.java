/**
 * 
 */
package es.us.isa.ideas.synopsis.common;

import ilog.concert.IloConstraint;
import ilog.concert.IloException;
import ilog.concert.IloIntExpr;
import ilog.concert.IloIntVar;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.cp.IloCP;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import es.us.isa.FAMA.models.featureModel.extended.ConstantIntConverter;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttribute;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttributedFeature;
import es.us.isa.FAMA.models.featureModel.extended.StringDomainIntConverter;
import es.us.isa.util.Node;
import es.us.isa.util.Tree;

/**
 * @author jdelafuente
 *
 */
public class CPHelper {

	IloCP cp;
	private String featName;
	protected Map<String, IloIntVar> featureVars;
	protected Map<String, IloNumVar> attVars;
	private Map<String, GenericAttribute> atts;
	private Map<String, GenericFeature> features;
	protected ConstantIntConverter constantIntConverter;

	public CPHelper() {
		this.cp = new IloCP();
		featName = null;
		features = new HashMap<String, GenericFeature>();
		atts = new HashMap<String, GenericAttribute>();
		featureVars = new HashMap<String, IloIntVar>();
		attVars = new HashMap<String, IloNumVar>();
		constantIntConverter = new ConstantIntConverter();
		constantIntConverter.addIntConverter(new StringDomainIntConverter());
	}

	public void addRoot(GenericAttributedFeature feature) {
		IloIntVar v = featureVars.get(feature.getName());
		IloConstraint c = cp.eq(v, 1);
		try {
			cp.add(c);
		} catch (IloException e) {
			e.printStackTrace();
		}
	}

	public void createFeature(GenericAttributedFeature feature,
			Collection<Cardinality> cards) {
		try {
			IloIntVar fVar = cp.boolVar(feature.getName());
			featureVars.put(feature.getName(), fVar);
		} catch (IloException e) {
			e.printStackTrace();
		}

		this.features.put(feature.getName(), feature);
	}

	public void addAttributes(GenericAttributedFeature feature)
			throws IloException {
		IloIntVar featureVar = this.featureVars.get(feature.getName());
		Collection<? extends GenericAttribute> attCol = feature.getAttributes();
		for (GenericAttribute a : attCol) {
			Domain d = a.getDomain();
			IloNumVar var = null;
			if (d instanceof IntegerDomain) {
				if (d instanceof RangeIntegerDomain) {
					RangeIntegerDomain rangeDomain = (RangeIntegerDomain) d;
					Set<Range> ranges = rangeDomain.getRanges();
					// XXX we consider just the first range
					Range range = ranges.iterator().next();
					var = cp.intVar(range.getMin(), range.getMax(),
							a.getFullName());
					attVars.put(a.getFullName(), var);
				} else if (d instanceof SetIntegerDomain) {
					SetIntegerDomain setDomain = (SetIntegerDomain) d;
					Set<Integer> vals = setDomain.getAllIntegerValues();
					int[] arrayVals = new int[vals.size()];
					int index = 0;
					for (Integer val : vals) {
						arrayVals[index] = val;
						index++;
					}

					var = cp.intVar(arrayVals, a.getFullName());
					attVars.put(a.getFullName(), var);
				}
			} else if (d instanceof RealDomain) {
				RealDomain rd = (RealDomain) d;
				var = cp.numVar(rd.getLowerBound(), rd.getUpperBound(),
						a.getFullName());
				attVars.put(a.getFullName(), var);
			} else if (d instanceof ObjectDomain) {
				SetIntegerDomain setDomain = (SetIntegerDomain) d;
				Set<Integer> vals = setDomain.getAllIntegerValues();
				int[] arrayVals = new int[vals.size()];
				int index = 0;
				for (Integer val : vals) {
					arrayVals[index] = val;
					index++;
				}

				var = cp.intVar(arrayVals, a.getFullName());
				attVars.put(a.getFullName(), var);

			}
			atts.put(a.getFullName(), a);
			// XXX we consider 0 as the default value of every attribute
			IloConstraint aux = cp.imply(cp.eq(featureVar, 0), cp.eq(var, 0));
			cp.add(aux);
			// attConstraints.add(aux);
			// cp.add();
		}

	}

	public void addSet_(GenericRelation rel, GenericAttributedFeature parent,
			Collection<GenericAttributedFeature> children,
			Collection<Cardinality> cardinalities) {

		Cardinality c = cardinalities.iterator().next();

		try {
			IloIntVar parentVar = featureVars.get(parent.getName());
			IloIntVar cardVar = cp.intVar(0, c.getMax());
			List<IloIntExpr> featVars = new LinkedList<IloIntExpr>();
			for (GenericAttributedFeature f : children) {
				featVars.add(featureVars.get(f.getName()));
			}
			IloIntExpr[] vars = featVars.toArray(new IloIntExpr[1]);

			IloConstraint cardSum = cp.eq(cardVar, cp.sum(vars));
			IloConstraint cardDomain = cp.and(cp.ge(cardVar, c.getMin()),
					cp.le(cardVar, c.getMax()));
			IloConstraint cardConstraint = cp.ifThenElse(cp.eq(parentVar, 0),
					cp.eq(cardVar, 0), cardDomain);

			cp.add(cardSum);
			cp.add(cardConstraint);

		} catch (IloException e) {
			e.printStackTrace();
		}

	}

	public void addMandatory_(GenericRelation rel,
			GenericAttributedFeature child, GenericAttributedFeature parent) {
		IloIntVar childV = featureVars.get(child.getName());
		IloIntVar parentV = featureVars.get(parent.getName());
		IloConstraint c = cp.eq(childV, parentV);
		try {
			cp.add(c);
		} catch (IloException e) {
			e.printStackTrace();
		}
	}

	public void addOptional_(GenericRelation rel,
			GenericAttributedFeature child, GenericAttributedFeature parent) {
		IloIntVar childV = featureVars.get(child.getName());
		IloIntVar parentV = featureVars.get(parent.getName());
		try {
			IloConstraint c = cp.imply(cp.eq(parentV, 0), cp.eq(childV, 0));
			cp.add(c);
		} catch (IloException e) {
			e.printStackTrace();
		}
	}

	public void addRequires_(GenericRelation rel,
			GenericAttributedFeature origin,
			GenericAttributedFeature destination) {
		IloIntVar originV = featureVars.get(origin.getName());
		IloIntVar targetV = featureVars.get(destination.getName());
		try {
			IloConstraint c = cp.imply(cp.eq(originV, 1), cp.eq(targetV, 1));
			cp.add(c);
		} catch (IloException e) {
			e.printStackTrace();
		}
	}

	public void addConstraint(Constraint c) {
		IloConstraint constraint = translateToConstraint(c.getAST());
		try {
			cp.add(constraint);
		} catch (IloException e) {
			e.printStackTrace();
		}
	}

	public void addFeature(String key, GenericFeature value) {
		features.put(key, value);
	}

	public void addAttribute(String key, GenericAttribute value) {
		atts.put(key, value);
	}

	public void addFeatureVar(String key, IloIntVar value) {
		featureVars.put(key, value);
	}

	public void addAttributeVar(String key, IloNumVar value) {
		attVars.put(key, value);
	}

	public Map<String, IloIntVar> getFeatureVars() {
		return featureVars;
	}

	public IloConstraint translateToInvariant(Tree<String> ast,
			String featInvariant) {
		featName = featInvariant;
		IloConstraint res = null;
		Node<String> n = ast.getRootElement();
		try {
			res = translateLogical(n);
		} catch (IloException e) {
			e.printStackTrace();
		}
		return res;
	}

	public IloConstraint translateToConstraint(Tree<String> ast) {
		featName = null;
		IloConstraint res = null;
		Node<String> n = ast.getRootElement();
		try {
			res = translateLogical(n);
		} catch (IloException e) {
			e.printStackTrace();
		}
		return res;
	}

	private IloConstraint translateLogical(Node<String> tree)
			throws IloException {

		// constraints logicas:
		// AND, OR, NOT, IMPLIES, IFF, REQUIRES, EXCLUDES
		// LOGICO -> LOGICO
		IloConstraint res = null;
		String data = tree.getData();
		List<Node<String>> children = tree.getChildren();
		int n = children.size();
		if (n == 2) {
			if (data.equals(KeyWords.AND)) {
				IloConstraint e1 = translateLogical(children.get(0));
				IloConstraint e2 = translateLogical(children.get(1));
				res = cp.and(e1, e2);
			} else if (data.equals(KeyWords.OR)) {
				IloConstraint e1 = translateLogical(children.get(0));
				IloConstraint e2 = translateLogical(children.get(1));
				res = cp.or(e1, e2);
			} else if (data.equals(KeyWords.IMPLIES)
					|| data.equals(KeyWords.REQUIRES)) {
				IloConstraint e1 = translateLogical(children.get(0));
				IloConstraint e2 = translateLogical(children.get(1));
				res = cp.imply(e1, e2);
			} else if (data.equals(KeyWords.IFF)) {
				IloConstraint e1 = translateLogical(children.get(0));
				IloConstraint e2 = translateLogical(children.get(1));
				res = cp.and(cp.imply(e1, e2), cp.imply(e2, e1));// ifOnlyIf(e1,
																	// e2);
			} else if (data.equals(KeyWords.EXCLUDES)) {
				// tendremos una feature > 0 a cada lado,
				// asi que hacemos un implies negando la parte dcha
				// (feat > 0) implies (not (feat > 0))
				IloConstraint e1 = translateLogical(children.get(0));
				IloConstraint aux = translateLogical(children.get(1));
				IloConstraint e2 = cp.not(aux);
				res = cp.imply(e1, e2);
			} else {
				res = translateRelational(tree);
			}
		} else if (n == 1) {
			if (data.equals(KeyWords.NOT)) {
				IloConstraint e1 = translateLogical(children.get(0));
				res = cp.not(e1);
			}

		} else {
			if (isFeature(tree)) {
				IloIntVar feat = cp.boolVar(data);
				res = cp.gt(feat, 0);
			} else if (data.equals(KeyWords.TRUE)) {
				res = cp.trueConstraint();
			} else if (data.equals(KeyWords.FALSE)) {
				res = cp.falseConstraint();
			}
		}
		return res;
	}

	private IloConstraint translateRelational(Node<String> tree)
			throws IloException {
		// constraints relaciones:
		// >, >=, <, <=, ==, !=
		// ENTERO -> LOGICO
		IloConstraint res = null;
		String data = tree.getData();
		List<Node<String>> children = tree.getChildren();
		IloNumExpr e1 = translateExpression(children.get(0));
		IloNumExpr e2 = translateExpression(children.get(1));
		if (data.equals(KeyWords.GREATER)) {
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.gt((IloIntExpr) e1, (IloIntExpr) e2);
			} else {
				res = cp.not(cp.le(e1, e2));
			}
		} else if (data.equals(KeyWords.GREATER_EQUAL)) {
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.ge((IloIntExpr) e1, (IloIntExpr) e2);
			} else {
				res = cp.ge(e1, e2);
			}
		} else if (data.equals(KeyWords.LESS)) {
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.lt((IloIntExpr) e1, (IloIntExpr) e2);
			} else {
				res = cp.not(cp.ge(e1, e2));
			}
		} else if (data.equals(KeyWords.LESS_EQUAL)) {
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.le((IloIntExpr) e1, (IloIntExpr) e2);
			} else {
				res = cp.le(e1, e2);
			}
		} else if (data.equals(KeyWords.EQUAL)) {
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.eq((IloIntExpr) e1, (IloIntExpr) e2);
			} else {
				res = cp.eq(e1, e2);
			}
		} else if (data.equals(KeyWords.NON_EQUAL)) {
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.neq((IloIntExpr) e1, (IloIntExpr) e2);
			} else {
				res = cp.not(cp.eq(e1, e2));
			}
		}

		return res;
	}

	private IloNumExpr translateExpression(Node<String> tree)
			throws IloException {
		// constraints enteras:
		// ENTERO -> ENTERO
		IloNumExpr res = null;
		String data = tree.getData();
		List<Node<String>> children = tree.getChildren();
		if (data.equals(KeyWords.PLUS)) {
			IloNumExpr e1 = translateExpression(children.get(0));
			IloNumExpr e2 = translateExpression(children.get(1));
			res = cp.sum(e1, e2);
		} else if (data.equals(KeyWords.MINUS)) {
			IloNumExpr e1 = translateExpression(children.get(0));
			IloNumExpr e2 = translateExpression(children.get(1));
			res = cp.diff(e1, e2);
		} else if (data.equals(KeyWords.MULT)) {
			IloNumExpr e1 = translateExpression(children.get(0));
			IloNumExpr e2 = translateExpression(children.get(1));
			res = cp.prod(e1, e2);
		} else if (data.equals(KeyWords.DIV)) {
			IloNumExpr e1 = translateExpression(children.get(0));
			IloNumExpr e2 = translateExpression(children.get(1));
			if (e1 instanceof IloIntExpr && e2 instanceof IloIntExpr) {
				res = cp.div((IloIntExpr) e1, (IloIntExpr) e2);
			}

			// } else if (data.equals(KeyWords.MOD)) {
			// IntegerExpressionVariable e1 =
			// translateInteger(children.get(0));
			// IntegerExpressionVariable e2 =
			// translateInteger(children.get(1));
			// res = mod(e1, e2);
		} else if (data.equals(KeyWords.POW)) {
			IloNumExpr e1 = translateExpression(children.get(0));
			IloNumExpr e2 = translateExpression(children.get(1));
			res = cp.power(e1, e2);
		} else if (data.equals(KeyWords.UNARY_MINUS)) {
			IloNumExpr e1 = translateExpression(children.get(0));
			res = cp.negative(e1);
		} else if (isIntegerConstant(tree)) {
			int value = Integer.parseInt(data);
			// IntegerVariable aux1 = makeIntVar("@aux" + count, value,
			// value);
			// IntegerVariable aux1 = Choco.makeConstantVar("@aux" + count,
			// value);
			IloIntExpr aux1 = cp.constant(value);
			// hara falta una constraint para el valor?
			res = aux1;
			// count++;
		} else if (isRealConstant(tree)) {
			double value = Double.parseDouble(data);
			IloNumExpr aux1 = cp.constant(value);
			res = aux1;
		} else if (isAttribute(tree)) {
			String attName = getAttributeName(tree);
			res = attVars.get(attName);
		} else {
			// es una constante, usamos el intConverter
			Integer i = constantIntConverter.translate2Integer(tree.getData());
			if (i != null) {
				res = cp.constant(i);
			}
		}
		return res;
	}

	private String getAttributeName(Node<String> n) {
		String res = null;
		if (featName == null) {
			String s = n.getData();
			boolean b = s.equals(KeyWords.ATTRIBUTE);
			if (b && (n.getNumberOfChildren() == 2)) {
				List<Node<String>> list = n.getChildren();
				res = list.get(0).getData() + "." + list.get(1).getData();
			}
		} else {
			res = featName + "." + n.getData();
		}

		return res;
	}

	private boolean isAttribute(Node<String> n) {
		if (featName == null) {
			return n.getData().equals(KeyWords.ATTRIBUTE);
		} else {
			String aux = featName + "." + n.getData();
			Object res = atts.get(aux);
			return (res != null);
		}

	}

	private boolean isFeature(Node<String> n) {
		String s = n.getData();
		return (features.get(s) != null);
	}

	private boolean isIntegerConstant(Node<String> n) {
		String s = n.getData();
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isRealConstant(Node<String> n) {
		String s = n.getData();
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
