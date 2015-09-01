// Generated from C:\Users\ISA Group\Desktop\Parsers\Synopsis-parser\Needs.g4 by ANTLR 4.1
package es.us.isa.ideas.synopsis.common.pref.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NeedsParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEEDS=1, ITEMS=2, REQUIREMENTS=3, PREFERENCES=4, INTEGER=5, FLOAT=6, BOOLEAN=7, 
		SET=8, ENUM=9, TRUE=10, FALSE=11, ON=12, SUM=13, MIN=14, MAX=15, FAVORITES=16, 
		DISLIKES=17, HIGHEST=18, LOWEST=19, AROUND=20, CA=21, CC=22, PA=23, PC=24, 
		LLA=25, LLC=26, DP=27, PyC=28, COMA=29, DOT=30, AND=31, OR=32, NOT=33, 
		IMPLIES=34, REQUIRES=35, IFF=36, EXCLUDES=37, PLUS=38, HYPHEN=39, ASTERISK=40, 
		SLASH=41, LT=42, GT=43, EQ=44, NEQ=45, LTE=46, GTE=47, ASSIG=48, Identifier=49, 
		String=50, Integer=51, S_Integer=52, Float=53, S_Float=54, Boolean=55, 
		WS=56, COMMENT=57, LINE_COMMENT=58;
	public static final String[] tokenNames = {
		"<INVALID>", "'Needs'", "'%Items'", "'%Requirements'", "'%Preferences'", 
		"'int'", "'real'", "'boolean'", "'set'", "'enum'", "'true'", "'false'", 
		"'on'", "'sum'", "'min'", "'max'", "'Favorites'", "'Dislikes'", "'Highest'", 
		"'Lowest'", "'Around'", "'['", "']'", "'('", "')'", "'{'", "'}'", "':'", 
		"';'", "','", "'.'", "'&&'", "'||'", "'!'", "'->'", "'REQUIRES'", "'IFF'", 
		"'EXCLUDES'", "'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "'!='", 
		"'<='", "'>='", "'='", "Identifier", "String", "Integer", "S_Integer", 
		"Float", "S_Float", "Boolean", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_entry = 0, RULE_needs_definition = 1, RULE_items = 2, RULE_requirements = 3, 
		RULE_preferences = 4, RULE_property = 5, RULE_parameters = 6, RULE_requirement = 7, 
		RULE_preference = 8, RULE_item_term = 9, RULE_expression = 10, RULE_list = 11, 
		RULE_array = 12, RULE_args = 13, RULE_atom = 14;
	public static final String[] ruleNames = {
		"entry", "needs_definition", "items", "requirements", "preferences", "property", 
		"parameters", "requirement", "preference", "item_term", "expression", 
		"list", "array", "args", "atom"
	};

	@Override
	public String getGrammarFileName() { return "Needs.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public NeedsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntryContext extends ParserRuleContext {
		public Token service_id;
		public TerminalNode ON() { return getToken(NeedsParser.ON, 0); }
		public TerminalNode NEEDS() { return getToken(NeedsParser.NEEDS, 0); }
		public TerminalNode LLA() { return getToken(NeedsParser.LLA, 0); }
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public TerminalNode LLC() { return getToken(NeedsParser.LLC, 0); }
		public Needs_definitionContext needs_definition() {
			return getRuleContext(Needs_definitionContext.class,0);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(NEEDS);
			setState(31); match(ON);
			setState(32); ((EntryContext)_localctx).service_id = match(Identifier);
			setState(33); match(LLA);
			setState(34); needs_definition();
			setState(35); match(LLC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Needs_definitionContext extends ParserRuleContext {
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public PreferencesContext preferences() {
			return getRuleContext(PreferencesContext.class,0);
		}
		public RequirementsContext requirements() {
			return getRuleContext(RequirementsContext.class,0);
		}
		public Needs_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_needs_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitNeeds_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Needs_definitionContext needs_definition() throws RecognitionException {
		Needs_definitionContext _localctx = new Needs_definitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_needs_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); items();
			setState(38); requirements();
			setState(39); preferences();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemsContext extends ParserRuleContext {
		public TerminalNode ITEMS() { return getToken(NeedsParser.ITEMS, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public ItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitItems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemsContext items() throws RecognitionException {
		ItemsContext _localctx = new ItemsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); match(ITEMS);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(42); property();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RequirementsContext extends ParserRuleContext {
		public TerminalNode REQUIREMENTS() { return getToken(NeedsParser.REQUIREMENTS, 0); }
		public RequirementContext requirement(int i) {
			return getRuleContext(RequirementContext.class,i);
		}
		public List<RequirementContext> requirement() {
			return getRuleContexts(RequirementContext.class);
		}
		public RequirementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitRequirements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementsContext requirements() throws RecognitionException {
		RequirementsContext _localctx = new RequirementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_requirements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(REQUIREMENTS);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << SUM) | (1L << MIN) | (1L << MAX) | (1L << CA) | (1L << PA) | (1L << LLA) | (1L << NOT) | (1L << Identifier) | (1L << String) | (1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) {
				{
				{
				setState(49); requirement();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreferencesContext extends ParserRuleContext {
		public PreferenceContext preference(int i) {
			return getRuleContext(PreferenceContext.class,i);
		}
		public List<PreferenceContext> preference() {
			return getRuleContexts(PreferenceContext.class);
		}
		public TerminalNode PREFERENCES() { return getToken(NeedsParser.PREFERENCES, 0); }
		public PreferencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preferences; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitPreferences(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreferencesContext preferences() throws RecognitionException {
		PreferencesContext _localctx = new PreferencesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_preferences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(PREFERENCES);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FAVORITES) | (1L << DISLIKES) | (1L << HIGHEST) | (1L << LOWEST) | (1L << AROUND))) != 0)) {
				{
				{
				setState(56); preference();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public Token id;
		public ParametersContext params;
		public TerminalNode PyC() { return getToken(NeedsParser.PyC, 0); }
		public TerminalNode CC() { return getToken(NeedsParser.CC, 0); }
		public TerminalNode CA() { return getToken(NeedsParser.CA, 0); }
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(NeedsParser.COMA); }
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(NeedsParser.COMA, i);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); ((PropertyContext)_localctx).id = match(Identifier);
			setState(63); match(CA);
			setState(64); ((PropertyContext)_localctx).params = parameters();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(65); match(COMA);
				setState(66); ((PropertyContext)_localctx).params = parameters();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72); match(CC);
			setState(73); match(PyC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(NeedsParser.String, 0); }
		public TerminalNode Integer() { return getToken(NeedsParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(NeedsParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(NeedsParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(NeedsParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << String) | (1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RequirementContext extends ParserRuleContext {
		public TerminalNode PyC() { return getToken(NeedsParser.PyC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_requirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); expression(0);
			setState(78); match(PyC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreferenceContext extends ParserRuleContext {
		public Token method;
		public TerminalNode PyC() { return getToken(NeedsParser.PyC, 0); }
		public TerminalNode FAVORITES() { return getToken(NeedsParser.FAVORITES, 0); }
		public Item_termContext item_term() {
			return getRuleContext(Item_termContext.class,0);
		}
		public TerminalNode LOWEST() { return getToken(NeedsParser.LOWEST, 0); }
		public TerminalNode PA() { return getToken(NeedsParser.PA, 0); }
		public TerminalNode COMA() { return getToken(NeedsParser.COMA, 0); }
		public TerminalNode DISLIKES() { return getToken(NeedsParser.DISLIKES, 0); }
		public TerminalNode PC() { return getToken(NeedsParser.PC, 0); }
		public TerminalNode AROUND() { return getToken(NeedsParser.AROUND, 0); }
		public TerminalNode HIGHEST() { return getToken(NeedsParser.HIGHEST, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PreferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitPreference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreferenceContext preference() throws RecognitionException {
		PreferenceContext _localctx = new PreferenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_preference);
		int _la;
		try {
			setState(122);
			switch (_input.LA(1)) {
			case FAVORITES:
				enterOuterAlt(_localctx, 1);
				{
				setState(80); ((PreferenceContext)_localctx).method = match(FAVORITES);
				setState(81); match(PA);
				setState(82); item_term();
				setState(85);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(83); match(COMA);
					setState(84); atom();
					}
				}

				setState(87); match(PC);
				setState(88); match(PyC);
				}
				break;
			case DISLIKES:
				enterOuterAlt(_localctx, 2);
				{
				setState(90); ((PreferenceContext)_localctx).method = match(DISLIKES);
				setState(91); match(PA);
				setState(92); item_term();
				setState(95);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(93); match(COMA);
					setState(94); atom();
					}
				}

				setState(97); match(PC);
				setState(98); match(PyC);
				}
				break;
			case HIGHEST:
				enterOuterAlt(_localctx, 3);
				{
				setState(100); ((PreferenceContext)_localctx).method = match(HIGHEST);
				setState(101); match(PA);
				setState(102); item_term();
				setState(103); match(PC);
				setState(104); match(PyC);
				}
				break;
			case LOWEST:
				enterOuterAlt(_localctx, 4);
				{
				setState(106); ((PreferenceContext)_localctx).method = match(LOWEST);
				setState(107); match(PA);
				setState(108); item_term();
				setState(109); match(PC);
				setState(110); match(PyC);
				}
				break;
			case AROUND:
				enterOuterAlt(_localctx, 5);
				{
				setState(112); ((PreferenceContext)_localctx).method = match(AROUND);
				setState(113); match(PA);
				setState(114); item_term();
				setState(117);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(115); match(COMA);
					setState(116); atom();
					}
				}

				setState(119); match(PC);
				setState(120); match(PyC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Item_termContext extends ParserRuleContext {
		public Token alias;
		public Token service_id;
		public Token feature;
		public TerminalNode String() { return getToken(NeedsParser.String, 0); }
		public TerminalNode CC() { return getToken(NeedsParser.CC, 0); }
		public TerminalNode DOT() { return getToken(NeedsParser.DOT, 0); }
		public TerminalNode CA() { return getToken(NeedsParser.CA, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(NeedsParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(NeedsParser.Identifier); }
		public Item_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitItem_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_termContext item_term() throws RecognitionException {
		Item_termContext _localctx = new Item_termContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_item_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); ((Item_termContext)_localctx).alias = match(Identifier);
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(125); match(CA);
				setState(126); ((Item_termContext)_localctx).service_id = match(String);
				setState(127); match(CC);
				setState(128); match(DOT);
				setState(129); ((Item_termContext)_localctx).feature = match(Identifier);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class AndExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(NeedsParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListExprContext extends ExpressionContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaxExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(NeedsParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MAX() { return getToken(NeedsParser.MAX, 0); }
		public TerminalNode PC() { return getToken(NeedsParser.PC, 0); }
		public MaxExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitMaxExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode HYPHEN() { return getToken(NeedsParser.HYPHEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode PLUS() { return getToken(NeedsParser.PLUS, 0); }
		public AdditiveExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IffExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IFF() { return getToken(NeedsParser.IFF, 0); }
		public IffExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitIffExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExpressionContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExprContext extends ExpressionContext {
		public Token op;
		public TerminalNode ASTERISK() { return getToken(NeedsParser.ASTERISK, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SLASH() { return getToken(NeedsParser.SLASH, 0); }
		public MultiplicationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(NeedsParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIG() { return getToken(NeedsParser.ASSIG, 0); }
		public AssigExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitAssigExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(NeedsParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(NeedsParser.PC, 0); }
		public ParExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(NeedsParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MIN() { return getToken(NeedsParser.MIN, 0); }
		public TerminalNode PC() { return getToken(NeedsParser.PC, 0); }
		public MinExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitMinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExcludesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EXCLUDES() { return getToken(NeedsParser.EXCLUDES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExcludesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitExcludesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTE() { return getToken(NeedsParser.GTE, 0); }
		public TerminalNode LT() { return getToken(NeedsParser.LT, 0); }
		public TerminalNode LTE() { return getToken(NeedsParser.LTE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode GT() { return getToken(NeedsParser.GT, 0); }
		public RelationalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REQUIRES() { return getToken(NeedsParser.REQUIRES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IMPLIES() { return getToken(NeedsParser.IMPLIES, 0); }
		public ImpliesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitImpliesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumExprContext extends ExpressionContext {
		public TerminalNode SUM() { return getToken(NeedsParser.SUM, 0); }
		public TerminalNode PA() { return getToken(NeedsParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(NeedsParser.PC, 0); }
		public SumExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitSumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExprContext extends ExpressionContext {
		public Token op;
		public TerminalNode NEQ() { return getToken(NeedsParser.NEQ, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQ() { return getToken(NeedsParser.EQ, 0); }
		public EqualityExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(NeedsParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new AssigExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(133); match(Identifier);
				setState(134); match(ASSIG);
				setState(135); expression(18);
				}
				break;

			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136); match(NOT);
				setState(137); expression(17);
				}
				break;

			case 3:
				{
				_localctx = new SumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138); match(SUM);
				setState(139); match(PA);
				setState(140); expression(0);
				setState(141); match(PC);
				}
				break;

			case 4:
				{
				_localctx = new MinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143); match(MIN);
				setState(144); match(PA);
				setState(145); expression(0);
				setState(146); match(PC);
				}
				break;

			case 5:
				{
				_localctx = new MaxExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148); match(MAX);
				setState(149); match(PA);
				setState(150); expression(0);
				setState(151); match(PC);
				}
				break;

			case 6:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153); match(PA);
				setState(154); expression(0);
				setState(155); match(PC);
				}
				break;

			case 7:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157); list();
				}
				break;

			case 8:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158); array();
				}
				break;

			case 9:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(189);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(163);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==SLASH) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(164); expression(17);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(166);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==HYPHEN) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(167); expression(16);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(169);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LTE) | (1L << GTE))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(170); expression(15);
						}
						break;

					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(172);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(173); expression(14);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(175); match(AND);
						setState(176); expression(13);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(178); match(OR);
						setState(179); expression(12);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(181);
						_la = _input.LA(1);
						if ( !(_la==IMPLIES || _la==REQUIRES) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(182); expression(11);
						}
						break;

					case 8:
						{
						_localctx = new IffExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(184); match(IFF);
						setState(185); expression(10);
						}
						break;

					case 9:
						{
						_localctx = new ExcludesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(187); match(EXCLUDES);
						setState(188); expression(9);
						}
						break;
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public ArgsContext l1;
		public ArgsContext l2;
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public TerminalNode CC() { return getToken(NeedsParser.CC, 0); }
		public TerminalNode CA() { return getToken(NeedsParser.CA, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(CA);
			setState(195); ((ListContext)_localctx).l1 = args();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(196); match(COMA);
				setState(197); ((ListContext)_localctx).l2 = args();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203); match(CC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ArgsContext l1;
		public ArgsContext l2;
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public TerminalNode LLA() { return getToken(NeedsParser.LLA, 0); }
		public TerminalNode LLC() { return getToken(NeedsParser.LLC, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); match(LLA);
			setState(206); ((ArrayContext)_localctx).l1 = args();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(207); match(COMA);
				setState(208); ((ArrayContext)_localctx).l2 = args();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(214); match(LLC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public Token l1;
		public TerminalNode String() { return getToken(NeedsParser.String, 0); }
		public TerminalNode Integer() { return getToken(NeedsParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(NeedsParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(NeedsParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(NeedsParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			((ArgsContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << String) | (1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) ) {
				((ArgsContext)_localctx).l1 = (Token)_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerAtomContext extends AtomContext {
		public TerminalNode Integer() { return getToken(NeedsParser.Integer, 0); }
		public TerminalNode S_Integer() { return getToken(NeedsParser.S_Integer, 0); }
		public IntegerAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitIntegerAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAtomContext extends AtomContext {
		public Token id;
		public Token value;
		public TerminalNode String() { return getToken(NeedsParser.String, 0); }
		public TerminalNode CC() { return getToken(NeedsParser.CC, 0); }
		public TerminalNode CA() { return getToken(NeedsParser.CA, 0); }
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public ArrayAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitArrayAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatAtomContext extends AtomContext {
		public TerminalNode S_Float() { return getToken(NeedsParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(NeedsParser.Float, 0); }
		public FloatAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitFloatAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode Identifier() { return getToken(NeedsParser.Identifier, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ItemTermAtomContext extends AtomContext {
		public Item_termContext item_term() {
			return getRuleContext(Item_termContext.class,0);
		}
		public ItemTermAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitItemTermAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode String() { return getToken(NeedsParser.String, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(NeedsParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NeedsParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NeedsVisitor ) return ((NeedsVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		int _la;
		try {
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new IntegerAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==Integer || _la==S_Integer) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 2:
				_localctx = new FloatAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				_la = _input.LA(1);
				if ( !(_la==Float || _la==S_Float) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 3:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;

			case 4:
				_localctx = new ArrayAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(221); ((ArrayAtomContext)_localctx).id = match(Identifier);
				setState(222); match(CA);
				setState(223); ((ArrayAtomContext)_localctx).value = match(String);
				setState(224); match(CC);
				}
				break;

			case 5:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(225); match(Identifier);
				}
				break;

			case 6:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(226); match(String);
				}
				break;

			case 7:
				_localctx = new ItemTermAtomContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(227); item_term();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 16 >= _localctx._p;

		case 1: return 15 >= _localctx._p;

		case 2: return 14 >= _localctx._p;

		case 3: return 13 >= _localctx._p;

		case 4: return 12 >= _localctx._p;

		case 5: return 11 >= _localctx._p;

		case 6: return 10 >= _localctx._p;

		case 7: return 9 >= _localctx._p;

		case 8: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3<\u00e9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\5\3\5\7\5"+
		"\65\n\5\f\5\16\58\13\5\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\7\3\7\3\7\3\7"+
		"\3\7\7\7F\n\7\f\7\16\7I\13\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\5\nX\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nb\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nx\n\n\3\n\3\n\3\n\5\n}\n\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0085"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a3\n\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c0\n\f\f\f\16\f\u00c3\13\f\3\r\3"+
		"\r\3\r\3\r\7\r\u00c9\n\r\f\r\16\r\u00cc\13\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\7\16\u00d4\n\16\f\16\16\16\u00d7\13\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e7\n\20\3\20\2\21"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\13\3\2\638\3\2*+\3\2()\4\2,"+
		"-\60\61\3\2./\3\2$%\3\2\65\66\3\2\678\3\2\f\r\u00fe\2 \3\2\2\2\4\'\3\2"+
		"\2\2\6+\3\2\2\2\b\62\3\2\2\2\n9\3\2\2\2\f@\3\2\2\2\16M\3\2\2\2\20O\3\2"+
		"\2\2\22|\3\2\2\2\24~\3\2\2\2\26\u00a2\3\2\2\2\30\u00c4\3\2\2\2\32\u00cf"+
		"\3\2\2\2\34\u00da\3\2\2\2\36\u00e6\3\2\2\2 !\7\3\2\2!\"\7\16\2\2\"#\7"+
		"\63\2\2#$\7\33\2\2$%\5\4\3\2%&\7\34\2\2&\3\3\2\2\2\'(\5\6\4\2()\5\b\5"+
		"\2)*\5\n\6\2*\5\3\2\2\2+/\7\4\2\2,.\5\f\7\2-,\3\2\2\2.\61\3\2\2\2/-\3"+
		"\2\2\2/\60\3\2\2\2\60\7\3\2\2\2\61/\3\2\2\2\62\66\7\5\2\2\63\65\5\20\t"+
		"\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\t\3\2\2\2"+
		"8\66\3\2\2\29=\7\6\2\2:<\5\22\n\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>\13\3\2\2\2?=\3\2\2\2@A\7\63\2\2AB\7\27\2\2BG\5\16\b\2CD\7\37\2\2"+
		"DF\5\16\b\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2"+
		"\2JK\7\30\2\2KL\7\36\2\2L\r\3\2\2\2MN\t\2\2\2N\17\3\2\2\2OP\5\26\f\2P"+
		"Q\7\36\2\2Q\21\3\2\2\2RS\7\22\2\2ST\7\31\2\2TW\5\24\13\2UV\7\37\2\2VX"+
		"\5\36\20\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\32\2\2Z[\7\36\2\2[}\3\2\2"+
		"\2\\]\7\23\2\2]^\7\31\2\2^a\5\24\13\2_`\7\37\2\2`b\5\36\20\2a_\3\2\2\2"+
		"ab\3\2\2\2bc\3\2\2\2cd\7\32\2\2de\7\36\2\2e}\3\2\2\2fg\7\24\2\2gh\7\31"+
		"\2\2hi\5\24\13\2ij\7\32\2\2jk\7\36\2\2k}\3\2\2\2lm\7\25\2\2mn\7\31\2\2"+
		"no\5\24\13\2op\7\32\2\2pq\7\36\2\2q}\3\2\2\2rs\7\26\2\2st\7\31\2\2tw\5"+
		"\24\13\2uv\7\37\2\2vx\5\36\20\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\32\2"+
		"\2z{\7\36\2\2{}\3\2\2\2|R\3\2\2\2|\\\3\2\2\2|f\3\2\2\2|l\3\2\2\2|r\3\2"+
		"\2\2}\23\3\2\2\2~\u0084\7\63\2\2\177\u0080\7\27\2\2\u0080\u0081\7\64\2"+
		"\2\u0081\u0082\7\30\2\2\u0082\u0083\7 \2\2\u0083\u0085\7\63\2\2\u0084"+
		"\177\3\2\2\2\u0084\u0085\3\2\2\2\u0085\25\3\2\2\2\u0086\u0087\b\f\1\2"+
		"\u0087\u0088\7\63\2\2\u0088\u0089\7\62\2\2\u0089\u00a3\5\26\f\2\u008a"+
		"\u008b\7#\2\2\u008b\u00a3\5\26\f\2\u008c\u008d\7\17\2\2\u008d\u008e\7"+
		"\31\2\2\u008e\u008f\5\26\f\2\u008f\u0090\7\32\2\2\u0090\u00a3\3\2\2\2"+
		"\u0091\u0092\7\20\2\2\u0092\u0093\7\31\2\2\u0093\u0094\5\26\f\2\u0094"+
		"\u0095\7\32\2\2\u0095\u00a3\3\2\2\2\u0096\u0097\7\21\2\2\u0097\u0098\7"+
		"\31\2\2\u0098\u0099\5\26\f\2\u0099\u009a\7\32\2\2\u009a\u00a3\3\2\2\2"+
		"\u009b\u009c\7\31\2\2\u009c\u009d\5\26\f\2\u009d\u009e\7\32\2\2\u009e"+
		"\u00a3\3\2\2\2\u009f\u00a3\5\30\r\2\u00a0\u00a3\5\32\16\2\u00a1\u00a3"+
		"\5\36\20\2\u00a2\u0086\3\2\2\2\u00a2\u008a\3\2\2\2\u00a2\u008c\3\2\2\2"+
		"\u00a2\u0091\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u009b\3\2\2\2\u00a2\u009f"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00c1\3\2\2\2\u00a4"+
		"\u00a5\6\f\2\3\u00a5\u00a6\t\3\2\2\u00a6\u00c0\5\26\f\2\u00a7\u00a8\6"+
		"\f\3\3\u00a8\u00a9\t\4\2\2\u00a9\u00c0\5\26\f\2\u00aa\u00ab\6\f\4\3\u00ab"+
		"\u00ac\t\5\2\2\u00ac\u00c0\5\26\f\2\u00ad\u00ae\6\f\5\3\u00ae\u00af\t"+
		"\6\2\2\u00af\u00c0\5\26\f\2\u00b0\u00b1\6\f\6\3\u00b1\u00b2\7!\2\2\u00b2"+
		"\u00c0\5\26\f\2\u00b3\u00b4\6\f\7\3\u00b4\u00b5\7\"\2\2\u00b5\u00c0\5"+
		"\26\f\2\u00b6\u00b7\6\f\b\3\u00b7\u00b8\t\7\2\2\u00b8\u00c0\5\26\f\2\u00b9"+
		"\u00ba\6\f\t\3\u00ba\u00bb\7&\2\2\u00bb\u00c0\5\26\f\2\u00bc\u00bd\6\f"+
		"\n\3\u00bd\u00be\7\'\2\2\u00be\u00c0\5\26\f\2\u00bf\u00a4\3\2\2\2\u00bf"+
		"\u00a7\3\2\2\2\u00bf\u00aa\3\2\2\2\u00bf\u00ad\3\2\2\2\u00bf\u00b0\3\2"+
		"\2\2\u00bf\u00b3\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00b9\3\2\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\27\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7\27\2\2\u00c5\u00ca"+
		"\5\34\17\2\u00c6\u00c7\7\37\2\2\u00c7\u00c9\5\34\17\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\30\2\2\u00ce\31\3\2\2"+
		"\2\u00cf\u00d0\7\33\2\2\u00d0\u00d5\5\34\17\2\u00d1\u00d2\7\37\2\2\u00d2"+
		"\u00d4\5\34\17\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3"+
		"\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00d9\7\34\2\2\u00d9\33\3\2\2\2\u00da\u00db\t\2\2\2\u00db\35\3\2\2\2"+
		"\u00dc\u00e7\t\b\2\2\u00dd\u00e7\t\t\2\2\u00de\u00e7\t\n\2\2\u00df\u00e0"+
		"\7\63\2\2\u00e0\u00e1\7\27\2\2\u00e1\u00e2\7\64\2\2\u00e2\u00e7\7\30\2"+
		"\2\u00e3\u00e7\7\63\2\2\u00e4\u00e7\7\64\2\2\u00e5\u00e7\5\24\13\2\u00e6"+
		"\u00dc\3\2\2\2\u00e6\u00dd\3\2\2\2\u00e6\u00de\3\2\2\2\u00e6\u00df\3\2"+
		"\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"\37\3\2\2\2\21/\66=GWaw|\u0084\u00a2\u00bf\u00c1\u00ca\u00d5\u00e6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}