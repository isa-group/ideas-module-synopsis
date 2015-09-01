/**
 * 	This file is part of FaMaTS.
 *
 *     FaMaTS is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     FaMaTS is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with FaMaTS.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.us.isa.ideas.synopsis.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.AttributedFeature;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.FAMAAttributedFeatureModel;
import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.Relation;
import es.us.isa.FAMA.models.domain.Domain;
import es.us.isa.FAMA.models.domain.IntegerDomain;
import es.us.isa.FAMA.models.domain.ObjectDomain;
import es.us.isa.FAMA.models.domain.Range;
import es.us.isa.FAMA.models.domain.RangeIntegerDomain;
import es.us.isa.FAMA.models.domain.RealDomain;
import es.us.isa.FAMA.models.featureModel.Cardinality;
import es.us.isa.FAMA.models.featureModel.Constraint;
import es.us.isa.FAMA.models.featureModel.extended.GenericAttribute;
import es.us.isa.FAMA.models.variabilityModel.VariabilityModel;

public class AFMWriter {

	private FAMAAttributedFeatureModel fm = null;
	private Collection<String> relationshipsCol = new ArrayList<String>();
	private Collection<String> attributesCol = new ArrayList<String>();
	private Collection<String> constraintsCol = new ArrayList<String>();
	private Collection<AttributedFeature> usedFeats = new ArrayList<AttributedFeature>();

	public String toString(VariabilityModel vm) {
		fm = (FAMAAttributedFeatureModel) vm;
		StringBuilder sb = new StringBuilder();

		sb.append("%Relationships").append("\n\n");
		sb.append(ProcessRelations(fm.getRoot()));
		sb.append("\n");

		sb.append("%Attributes").append("\n\n");
		sb.append(ProcessAttributes(fm.getRoot()));
		sb.append("\n");

		sb.append("%Constraints").append("\n\n");
		sb.append(ProcessConstraints(fm.getRoot()));
		sb.append("\n");

		return sb.toString();
	}

	private String ProcessConstraints(AttributedFeature root) {
		StringBuilder sb = new StringBuilder();

		for (Constraint c : fm.getConstraints()) {
			sb.append(c + ";").append("\n");
		}

		return sb.toString();
	}

	public String ProcessRelations(AttributedFeature feat) {
		StringBuilder sb = new StringBuilder();
		Iterator<Relation> relIt = feat.getRelations();
		if (feat.getNumberOfRelations() > 0) {
			sb.append(feat.getName() + ":");
			while (relIt.hasNext()) {
				Relation rel = relIt.next();

				Iterator<AttributedFeature> destIt = rel.getDestination();

				// System.out.println(rel);
				// System.out.println("\t mandatory: " + rel.isMandatory());
				// System.out.println("\t optional: " + rel.isOptional());
				// System.out.println("\t or: " + rel.isOr());
				// System.out.println("\t alternative: " + rel.isAlternative());

				if (rel.isAlternative()) {
					Iterator<Cardinality> cardIt = rel.getCardinalities();
					while (cardIt.hasNext()) {
						Cardinality card = cardIt.next();
						sb.append(" [" + card.getMin() + "," + card.getMax()
								+ "] ");
					}
					sb.append("{");
					while (destIt.hasNext()) {
						AttributedFeature dest = destIt.next();
						sb.append(dest.getName());
						if (destIt.hasNext())
							sb.append(" ");
					}
					sb.append("}");
				} else if (rel.isOr()) {
					Iterator<Cardinality> cardIt = rel.getCardinalities();
					while (cardIt.hasNext()) {
						Cardinality card = cardIt.next();
						sb.append(" [" + card.getMin() + "," + card.getMax()
								+ "]");
						if (cardIt.hasNext())
							sb.append(" ");
					}
					sb.append("{");
					while (destIt.hasNext()) {
						AttributedFeature dest = destIt.next();
						sb.append(dest.getName());
						if (destIt.hasNext())
							sb.append(" ");
					}
					sb.append("}");
				} else if (rel.isMandatory()) {
					while (destIt.hasNext()) {
						AttributedFeature dest = destIt.next();
						sb.append(" " + dest.getName());
					}
				} else if (rel.isOptional()) {
					while (destIt.hasNext()) {
						AttributedFeature dest = destIt.next();
						sb.append(" [" + dest.getName() + "]");
					}
				}
			}

			sb.append(";\n");

			relIt = feat.getRelations();
			while (relIt.hasNext()) {
				Relation rel = relIt.next();

				Iterator<AttributedFeature> destIt = rel.getDestination();
				while (destIt.hasNext()) {
					AttributedFeature dest = destIt.next();
					if (!usedFeats.contains(dest)) {
						sb.append(ProcessRelations(dest));
						usedFeats.add(dest);
					}
				}
			}
		}

		return sb.toString();
	}

	private String ProcessAttributes(AttributedFeature root) {
		StringBuilder sb = new StringBuilder();
		for (GenericAttribute attr : root.getAttributes()) {
			sb.append(root.getName() + "." + attr.getName() + ": ");

			Domain domain = attr.getDomain();
			if (domain instanceof RangeIntegerDomain) {
				sb.append("Integer");
				Iterator<Range> rangesIt = ((RangeIntegerDomain) domain)
						.getRanges().iterator();
				while (rangesIt.hasNext()) {
					Range range = rangesIt.next();
					sb.append("[" + range.getMin() + " to " + range.getMax()
							+ "],0,0;");
				}
			} else if (domain instanceof IntegerDomain) {
				sb.append("Integer [");
				Iterator<Integer> domIt = domain.getAllIntegerValues()
						.iterator();
				while (domIt.hasNext()) {
					sb.append(domIt.next().toString());
					if (domIt.hasNext())
						sb.append(", ");
				}
				sb.append("],0,0;");
			} else if (domain instanceof RealDomain) {
				RealDomain rd = (RealDomain) domain;
				sb.append("Real [" + rd.getLowerBound() + " to "
						+ rd.getUpperBound() + "],0,0;");
			} else if (domain instanceof ObjectDomain) {
				ObjectDomain dom = ((ObjectDomain) domain);
				if (dom.getObjectValues().size() > 0) {
					sb.append("[");

					Iterator<Object> domIt = dom.getObjectValues().iterator();
					while (domIt.hasNext()) {
						sb.append(domIt.next().toString());
						if (domIt.hasNext())
							sb.append(", ");
					}
					sb.append("]");
				}
			}
			sb.append("\n");
		}

		Iterator<Relation> relIt = root.getRelations();
		while (relIt.hasNext()) {
			Relation rel = relIt.next();

			Iterator<AttributedFeature> destIt = rel.getDestination();
			while (destIt.hasNext()) {
				AttributedFeature dest = destIt.next();
				sb.append(ProcessAttributes(dest));
			}
		}

		return sb.toString();
	}
}
