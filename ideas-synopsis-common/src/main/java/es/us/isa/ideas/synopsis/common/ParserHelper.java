/**
 * 
 */
package es.us.isa.ideas.synopsis.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import es.us.isa.FAMA.models.FAMAAttributedfeatureModel.FAMAAttributedFeatureModel;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSLexer;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser;
import es.us.isa.ideas.synopsis.common.hcs.parser.HCSParser.EntryContext;
import es.us.isa.ideas.synopsis.common.hcs.parser.MyHCSVisitor;
import es.us.isa.ideas.synopsis.common.pref.parser.MyNeedsVisitor;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsLexer;
import es.us.isa.ideas.synopsis.common.pref.parser.NeedsParser;

/**
 * @author jdelafuente
 *
 */
public class ParserHelper {

	public static Map<String, Object> parseHCS(String hcs, String pref) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder errors = new StringBuilder();
		StringBuilder warnings = new StringBuilder();

		NeedsLexer needs_lexer = new NeedsLexer(new ANTLRInputStream(pref));
		// Get a list of matched tokens
		CommonTokenStream needs_tokens = new CommonTokenStream(needs_lexer);

		// Pass the tokens to the parser
		NeedsParser needs_parser = new NeedsParser(needs_tokens);

		// Specify our entry point
		NeedsParser.EntryContext needs_context = needs_parser.entry();

		// Walk it and attach our listener
		MyNeedsVisitor needs_visitor = new MyNeedsVisitor();
		FAMAAttributedFeatureModel needsModel = (FAMAAttributedFeatureModel) needs_visitor
				.visitEntry(needs_context);
		
		List<String> tags = needs_visitor.getTags();

		HCSLexer hcs_lexer = new HCSLexer(new ANTLRInputStream(hcs));

		// Get a list of matched tokens
		CommonTokenStream hcs_tokens = new CommonTokenStream(hcs_lexer);

		// Pass the tokens to the parser
		HCSParser hcs_parser = new HCSParser(hcs_tokens);

		// Specify our entry point
		EntryContext hcs_context = hcs_parser.entry();

		// Walk it and attach our listener
		MyHCSVisitor hcs_visitor = new MyHCSVisitor(needsModel, tags);
		FAMAAttributedFeatureModel model = null;
		
		try {
			FAMAAttributedFeatureModel blockServiceModel = (FAMAAttributedFeatureModel) hcs_visitor
					.visitEntry(hcs_context);
			needs_visitor = new MyNeedsVisitor(blockServiceModel);
			model = (FAMAAttributedFeatureModel) needs_visitor
					.visitEntry(needs_context);
			if (needs_visitor.getErrors().size() > 0) {
				for (String err : needs_visitor.getErrors()){
					warnings.append("   - " + err + "\n");
				}
			}
		} catch (Exception e) {
			errors.append(e.getMessage()).append("\n");
		}

		if (errors.length() > 0)
			map.put("Errors", errors.toString());
		if (warnings.length() > 0)
			map.put("Warnings", warnings.toString());
		map.put("VariabilityModel", model);
		map.put("CSPObjectiveFunction", needs_visitor.getObjectiveFunction());

		return map;
	}
}
