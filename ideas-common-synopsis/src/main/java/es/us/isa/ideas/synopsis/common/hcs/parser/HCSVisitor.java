// Generated from C:\Users\ISA Group\Desktop\Parsers\Synopsis-parser\HCS.g4 by ANTLR 4.1
package es.us.isa.ideas.synopsis.common.hcs.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HCSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HCSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HCSParser#arrayAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAtom(@NotNull HCSParser.ArrayAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#integerAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerAtom(@NotNull HCSParser.IntegerAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull HCSParser.AndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull HCSParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#highly_conf_service_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHighly_conf_service_def(@NotNull HCSParser.Highly_conf_service_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#table_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_expression(@NotNull HCSParser.Table_expressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#stringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(@NotNull HCSParser.StringAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull HCSParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull HCSParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#dependency}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependency(@NotNull HCSParser.DependencyContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#assigExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigExpr(@NotNull HCSParser.AssigExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#floatAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatAtom(@NotNull HCSParser.FloatAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#global_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_terms(@NotNull HCSParser.Global_termsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#minExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinExpr(@NotNull HCSParser.MinExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(@NotNull HCSParser.IdAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#excludesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcludesExpr(@NotNull HCSParser.ExcludesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#dependencies}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependencies(@NotNull HCSParser.DependenciesContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#domain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomain(@NotNull HCSParser.DomainContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull HCSParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(@NotNull HCSParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#sumExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumExpr(@NotNull HCSParser.SumExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull HCSParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#listExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(@NotNull HCSParser.ListExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#selectable_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectable_terms(@NotNull HCSParser.Selectable_termsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#services}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServices(@NotNull HCSParser.ServicesContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#highly_conf_service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHighly_conf_service(@NotNull HCSParser.Highly_conf_serviceContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#derived_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerived_terms(@NotNull HCSParser.Derived_termsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#maxExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxExpr(@NotNull HCSParser.MaxExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#conf_service_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConf_service_definition(@NotNull HCSParser.Conf_service_definitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(@NotNull HCSParser.AtomExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull HCSParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(@NotNull HCSParser.PropertyContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(@NotNull HCSParser.TableContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(@NotNull HCSParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#iffExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpr(@NotNull HCSParser.IffExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(@NotNull HCSParser.MultiplicationExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(@NotNull HCSParser.BooleanAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull HCSParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#table_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_content(@NotNull HCSParser.Table_contentContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(@NotNull HCSParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#conf_service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConf_service(@NotNull HCSParser.Conf_serviceContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#entry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntry(@NotNull HCSParser.EntryContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(@NotNull HCSParser.ServiceContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#table_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_header(@NotNull HCSParser.Table_headerContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#impliesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(@NotNull HCSParser.ImpliesExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinality(@NotNull HCSParser.CardinalityContext ctx);

	/**
	 * Visit a parse tree produced by {@link HCSParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull HCSParser.ArrayContext ctx);
}