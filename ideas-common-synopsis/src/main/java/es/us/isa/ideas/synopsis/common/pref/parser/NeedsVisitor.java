// Generated from C:\Users\ISA Group\Desktop\Parsers\Synopsis-parser\Needs.g4 by ANTLR 4.1
package es.us.isa.ideas.synopsis.common.pref.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NeedsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NeedsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NeedsParser#arrayAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull NeedsParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#integerAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerAtom(@NotNull NeedsParser.IntegerAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull NeedsParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull NeedsParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#itemTermAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemTermAtom(@NotNull NeedsParser.ItemTermAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull NeedsParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#requirements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirements(@NotNull NeedsParser.RequirementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull NeedsParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#assigExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull NeedsParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull NeedsParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#floatAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatAtom(@NotNull NeedsParser.FloatAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#minExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinExpr(@NotNull NeedsParser.MinExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull NeedsParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#excludesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull NeedsParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull NeedsParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#sumExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpr(@NotNull NeedsParser.SumExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull NeedsParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull NeedsParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#preferences}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreferences(@NotNull NeedsParser.PreferencesContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull NeedsParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(@NotNull NeedsParser.RequirementContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#maxExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxExpr(@NotNull NeedsParser.MaxExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#item_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_term(@NotNull NeedsParser.Item_termContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull NeedsParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull NeedsParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(@NotNull NeedsParser.PropertyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull NeedsParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#iffExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull NeedsParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull NeedsParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull NeedsParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull NeedsParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#preference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreference(@NotNull NeedsParser.PreferenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItems(@NotNull NeedsParser.ItemsContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(@NotNull NeedsParser.EntryContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull NeedsParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#impliesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull NeedsParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#needs_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeeds_definition(@NotNull NeedsParser.Needs_definitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeedsParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull NeedsParser.ArrayContext ctx);
}