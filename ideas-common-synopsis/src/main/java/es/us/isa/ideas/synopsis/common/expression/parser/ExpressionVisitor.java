// Generated from C:\Users\ISA Group\Desktop\Parsers\Expression-parser\Expression.g4 by ANTLR 4.1
package es.us.isa.ideas.synopsis.common.expression.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull ExpressionParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull ExpressionParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull ExpressionParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull ExpressionParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull ExpressionParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull ExpressionParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull ExpressionParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull ExpressionParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#numberAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(@NotNull ExpressionParser.NumberAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#iffExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull ExpressionParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull ExpressionParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull ExpressionParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull ExpressionParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull ExpressionParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#assigExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull ExpressionParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull ExpressionParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull ExpressionParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#excludesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull ExpressionParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull ExpressionParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#impliesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull ExpressionParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull ExpressionParser.ParseContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull ExpressionParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull ExpressionParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link ExpressionParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull ExpressionParser.NotExprContext ctx);
}