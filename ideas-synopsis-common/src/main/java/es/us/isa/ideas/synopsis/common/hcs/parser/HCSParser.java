// Generated from C:\Users\ISA Group\Desktop\Parsers\Synopsis-parser\HCS.g4 by ANTLR 4.1
package es.us.isa.ideas.synopsis.common.hcs.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HCSParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SERVICE=1, SELECTABLE_TERMS=2, DERIVED_TERMS=3, DEPENDENCIES=4, HIGHLY_CONF=5, 
		SERVICES=6, GLOBAL_TERMS=7, TABLE=8, INTEGER=9, FLOAT=10, BOOLEAN=11, 
		SET=12, ENUM=13, TRUE=14, FALSE=15, SUM=16, MIN=17, MAX=18, CA=19, CC=20, 
		PA=21, PC=22, LLA=23, LLC=24, DP=25, PyC=26, COMA=27, AND=28, OR=29, NOT=30, 
		IMPLIES=31, REQUIRES=32, IFF=33, EXCLUDES=34, PLUS=35, HYPHEN=36, ASTERISK=37, 
		SLASH=38, LT=39, GT=40, EQ=41, NEQ=42, LTE=43, GTE=44, ASSIG=45, Identifier=46, 
		String=47, Integer=48, S_Integer=49, Float=50, S_Float=51, Boolean=52, 
		WS=53, COMMENT=54, LINE_COMMENT=55;
	public static final String[] tokenNames = {
		"<INVALID>", "'Service'", "'%SelectableTerms'", "'%DerivedTerms'", "'%Dependencies'", 
		"'Highly_configurable'", "'%Services'", "'%GlobalTerms'", "'table'", "'int'", 
		"'real'", "'boolean'", "'set'", "'enum'", "'true'", "'false'", "'sum'", 
		"'min'", "'max'", "'['", "']'", "'('", "')'", "'{'", "'}'", "':'", "';'", 
		"','", "'&&'", "'||'", "'!'", "'->'", "'REQUIRES'", "'IFF'", "'EXCLUDES'", 
		"'+'", "'-'", "'*'", "'/'", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", 
		"'='", "Identifier", "String", "Integer", "S_Integer", "Float", "S_Float", 
		"Boolean", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_entry = 0, RULE_conf_service = 1, RULE_conf_service_definition = 2, 
		RULE_selectable_terms = 3, RULE_derived_terms = 4, RULE_highly_conf_service = 5, 
		RULE_highly_conf_service_def = 6, RULE_services = 7, RULE_service = 8, 
		RULE_global_terms = 9, RULE_dependencies = 10, RULE_dependency = 11, RULE_property = 12, 
		RULE_domain = 13, RULE_parameters = 14, RULE_table = 15, RULE_table_header = 16, 
		RULE_table_content = 17, RULE_table_expression = 18, RULE_cardinality = 19, 
		RULE_expression = 20, RULE_list = 21, RULE_array = 22, RULE_args = 23, 
		RULE_atom = 24;
	public static final String[] ruleNames = {
		"entry", "conf_service", "conf_service_definition", "selectable_terms", 
		"derived_terms", "highly_conf_service", "highly_conf_service_def", "services", 
		"service", "global_terms", "dependencies", "dependency", "property", "domain", 
		"parameters", "table", "table_header", "table_content", "table_expression", 
		"cardinality", "expression", "list", "array", "args", "atom"
	};

	@Override
	public String getGrammarFileName() { return "HCS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public HCSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntryContext extends ParserRuleContext {
		public List<Highly_conf_serviceContext> highly_conf_service() {
			return getRuleContexts(Highly_conf_serviceContext.class);
		}
		public List<Conf_serviceContext> conf_service() {
			return getRuleContexts(Conf_serviceContext.class);
		}
		public Conf_serviceContext conf_service(int i) {
			return getRuleContext(Conf_serviceContext.class,i);
		}
		public Highly_conf_serviceContext highly_conf_service(int i) {
			return getRuleContext(Highly_conf_serviceContext.class,i);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SERVICE) {
				{
				{
				setState(50); conf_service();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HIGHLY_CONF) {
				{
				{
				setState(56); highly_conf_service();
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

	public static class Conf_serviceContext extends ParserRuleContext {
		public Token service_id;
		public Conf_service_definitionContext conf_service_definition() {
			return getRuleContext(Conf_service_definitionContext.class,0);
		}
		public TerminalNode LLA() { return getToken(HCSParser.LLA, 0); }
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public TerminalNode SERVICE() { return getToken(HCSParser.SERVICE, 0); }
		public TerminalNode LLC() { return getToken(HCSParser.LLC, 0); }
		public Conf_serviceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conf_service; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitConf_service(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conf_serviceContext conf_service() throws RecognitionException {
		Conf_serviceContext _localctx = new Conf_serviceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_conf_service);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(SERVICE);
			setState(63); ((Conf_serviceContext)_localctx).service_id = match(Identifier);
			setState(64); match(LLA);
			setState(65); conf_service_definition();
			setState(66); match(LLC);
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

	public static class Conf_service_definitionContext extends ParserRuleContext {
		public DependenciesContext dependencies() {
			return getRuleContext(DependenciesContext.class,0);
		}
		public Selectable_termsContext selectable_terms() {
			return getRuleContext(Selectable_termsContext.class,0);
		}
		public Derived_termsContext derived_terms() {
			return getRuleContext(Derived_termsContext.class,0);
		}
		public Conf_service_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conf_service_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitConf_service_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conf_service_definitionContext conf_service_definition() throws RecognitionException {
		Conf_service_definitionContext _localctx = new Conf_service_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_conf_service_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); selectable_terms();
			setState(69); derived_terms();
			setState(70); dependencies();
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

	public static class Selectable_termsContext extends ParserRuleContext {
		public TerminalNode SELECTABLE_TERMS() { return getToken(HCSParser.SELECTABLE_TERMS, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public Selectable_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectable_terms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitSelectable_terms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Selectable_termsContext selectable_terms() throws RecognitionException {
		Selectable_termsContext _localctx = new Selectable_termsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectable_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(SELECTABLE_TERMS);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(73); property();
				}
				}
				setState(78);
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

	public static class Derived_termsContext extends ParserRuleContext {
		public TerminalNode DERIVED_TERMS() { return getToken(HCSParser.DERIVED_TERMS, 0); }
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public Derived_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_terms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitDerived_terms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Derived_termsContext derived_terms() throws RecognitionException {
		Derived_termsContext _localctx = new Derived_termsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_derived_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(DERIVED_TERMS);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(80); property();
				}
				}
				setState(85);
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

	public static class Highly_conf_serviceContext extends ParserRuleContext {
		public Token service_id;
		public TerminalNode HIGHLY_CONF() { return getToken(HCSParser.HIGHLY_CONF, 0); }
		public Highly_conf_service_defContext highly_conf_service_def() {
			return getRuleContext(Highly_conf_service_defContext.class,0);
		}
		public TerminalNode LLA() { return getToken(HCSParser.LLA, 0); }
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public TerminalNode SERVICE() { return getToken(HCSParser.SERVICE, 0); }
		public TerminalNode LLC() { return getToken(HCSParser.LLC, 0); }
		public Highly_conf_serviceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_highly_conf_service; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitHighly_conf_service(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Highly_conf_serviceContext highly_conf_service() throws RecognitionException {
		Highly_conf_serviceContext _localctx = new Highly_conf_serviceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_highly_conf_service);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(HIGHLY_CONF);
			setState(87); match(SERVICE);
			setState(88); ((Highly_conf_serviceContext)_localctx).service_id = match(Identifier);
			setState(89); match(LLA);
			setState(90); highly_conf_service_def();
			setState(91); match(LLC);
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

	public static class Highly_conf_service_defContext extends ParserRuleContext {
		public DependenciesContext dependencies() {
			return getRuleContext(DependenciesContext.class,0);
		}
		public Global_termsContext global_terms() {
			return getRuleContext(Global_termsContext.class,0);
		}
		public ServicesContext services() {
			return getRuleContext(ServicesContext.class,0);
		}
		public Highly_conf_service_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_highly_conf_service_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitHighly_conf_service_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Highly_conf_service_defContext highly_conf_service_def() throws RecognitionException {
		Highly_conf_service_defContext _localctx = new Highly_conf_service_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_highly_conf_service_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); services();
			setState(94); global_terms();
			setState(95); dependencies();
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

	public static class ServicesContext extends ParserRuleContext {
		public ServiceContext service(int i) {
			return getRuleContext(ServiceContext.class,i);
		}
		public List<ServiceContext> service() {
			return getRuleContexts(ServiceContext.class);
		}
		public TerminalNode SERVICES() { return getToken(HCSParser.SERVICES, 0); }
		public ServicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_services; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitServices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServicesContext services() throws RecognitionException {
		ServicesContext _localctx = new ServicesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_services);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(SERVICES);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(98); service();
				}
				}
				setState(103);
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

	public static class ServiceContext extends ParserRuleContext {
		public Token service_id;
		public Token service_type;
		public TerminalNode PyC() { return getToken(HCSParser.PyC, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(HCSParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(HCSParser.Identifier); }
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public TerminalNode DP() { return getToken(HCSParser.DP, 0); }
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_service);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); ((ServiceContext)_localctx).service_id = match(Identifier);
			setState(105); match(DP);
			setState(106); ((ServiceContext)_localctx).service_type = match(Identifier);
			setState(107); cardinality();
			setState(108); match(PyC);
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

	public static class Global_termsContext extends ParserRuleContext {
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public TerminalNode GLOBAL_TERMS() { return getToken(HCSParser.GLOBAL_TERMS, 0); }
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public Global_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_terms; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitGlobal_terms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_termsContext global_terms() throws RecognitionException {
		Global_termsContext _localctx = new Global_termsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_global_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(GLOBAL_TERMS);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(111); property();
				}
				}
				setState(116);
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

	public static class DependenciesContext extends ParserRuleContext {
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public List<DependencyContext> dependency() {
			return getRuleContexts(DependencyContext.class);
		}
		public TerminalNode DEPENDENCIES() { return getToken(HCSParser.DEPENDENCIES, 0); }
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public DependencyContext dependency(int i) {
			return getRuleContext(DependencyContext.class,i);
		}
		public DependenciesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependencies; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitDependencies(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependenciesContext dependencies() throws RecognitionException {
		DependenciesContext _localctx = new DependenciesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dependencies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(DEPENDENCIES);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << SUM) | (1L << MIN) | (1L << MAX) | (1L << CA) | (1L << PA) | (1L << LLA) | (1L << NOT) | (1L << Identifier) | (1L << String) | (1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) {
				{
				{
				setState(118); dependency();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TABLE) {
				{
				{
				setState(124); table();
				}
				}
				setState(129);
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

	public static class DependencyContext extends ParserRuleContext {
		public TerminalNode PyC() { return getToken(HCSParser.PyC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependency; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitDependency(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependencyContext dependency() throws RecognitionException {
		DependencyContext _localctx = new DependencyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); expression(0);
			setState(131); match(PyC);
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
		public DomainContext dom;
		public DomainContext domain() {
			return getRuleContext(DomainContext.class,0);
		}
		public TerminalNode PyC() { return getToken(HCSParser.PyC, 0); }
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public TerminalNode DP() { return getToken(HCSParser.DP, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); ((PropertyContext)_localctx).id = match(Identifier);
			setState(134); match(DP);
			setState(135); ((PropertyContext)_localctx).dom = domain();
			setState(136); match(PyC);
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

	public static class DomainContext extends ParserRuleContext {
		public Token datatype;
		public Token min;
		public Token max;
		public ParametersContext params;
		public TerminalNode SET() { return getToken(HCSParser.SET, 0); }
		public List<TerminalNode> Integer() { return getTokens(HCSParser.Integer); }
		public TerminalNode ENUM() { return getToken(HCSParser.ENUM, 0); }
		public List<TerminalNode> S_Float() { return getTokens(HCSParser.S_Float); }
		public TerminalNode CC() { return getToken(HCSParser.CC, 0); }
		public TerminalNode FLOAT() { return getToken(HCSParser.FLOAT, 0); }
		public TerminalNode S_Float(int i) {
			return getToken(HCSParser.S_Float, i);
		}
		public TerminalNode CA() { return getToken(HCSParser.CA, 0); }
		public TerminalNode LLA() { return getToken(HCSParser.LLA, 0); }
		public List<TerminalNode> S_Integer() { return getTokens(HCSParser.S_Integer); }
		public TerminalNode S_Integer(int i) {
			return getToken(HCSParser.S_Integer, i);
		}
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public TerminalNode Float(int i) {
			return getToken(HCSParser.Float, i);
		}
		public TerminalNode COMA(int i) {
			return getToken(HCSParser.COMA, i);
		}
		public TerminalNode BOOLEAN() { return getToken(HCSParser.BOOLEAN, 0); }
		public TerminalNode Integer(int i) {
			return getToken(HCSParser.Integer, i);
		}
		public List<TerminalNode> Float() { return getTokens(HCSParser.Float); }
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(HCSParser.COMA); }
		public TerminalNode LLC() { return getToken(HCSParser.LLC, 0); }
		public TerminalNode INTEGER() { return getToken(HCSParser.INTEGER, 0); }
		public DomainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domain; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitDomain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainContext domain() throws RecognitionException {
		DomainContext _localctx = new DomainContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_domain);
		int _la;
		try {
			setState(175);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); ((DomainContext)_localctx).datatype = match(INTEGER);
				setState(139); match(CA);
				setState(140);
				((DomainContext)_localctx).min = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Integer || _la==S_Integer) ) {
					((DomainContext)_localctx).min = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(141); match(COMA);
				setState(142);
				((DomainContext)_localctx).max = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Integer || _la==S_Integer) ) {
					((DomainContext)_localctx).max = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(143); match(CC);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); ((DomainContext)_localctx).datatype = match(FLOAT);
				setState(145); match(CA);
				setState(146);
				((DomainContext)_localctx).min = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) ) {
					((DomainContext)_localctx).min = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(147); match(COMA);
				setState(148);
				((DomainContext)_localctx).max = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) ) {
					((DomainContext)_localctx).max = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(149); match(CC);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(150); ((DomainContext)_localctx).datatype = match(BOOLEAN);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 4);
				{
				setState(151); ((DomainContext)_localctx).datatype = match(SET);
				setState(152); match(CA);
				setState(153); ((DomainContext)_localctx).params = parameters();
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(154); match(COMA);
					setState(155); ((DomainContext)_localctx).params = parameters();
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161); match(CC);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(163); ((DomainContext)_localctx).datatype = match(ENUM);
				setState(164); match(LLA);
				setState(165); ((DomainContext)_localctx).params = parameters();
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(166); match(COMA);
					setState(167); ((DomainContext)_localctx).params = parameters();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173); match(LLC);
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

	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(HCSParser.String, 0); }
		public TerminalNode Integer() { return getToken(HCSParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(HCSParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(HCSParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(HCSParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
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

	public static class TableContext extends ParserRuleContext {
		public Table_contentContext table_content() {
			return getRuleContext(Table_contentContext.class,0);
		}
		public TerminalNode LLA() { return getToken(HCSParser.LLA, 0); }
		public TerminalNode PA() { return getToken(HCSParser.PA, 0); }
		public TerminalNode LLC() { return getToken(HCSParser.LLC, 0); }
		public TerminalNode TABLE() { return getToken(HCSParser.TABLE, 0); }
		public TerminalNode PC() { return getToken(HCSParser.PC, 0); }
		public Table_headerContext table_header() {
			return getRuleContext(Table_headerContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(TABLE);
			setState(180); match(PA);
			setState(181); table_header();
			setState(182); match(PC);
			setState(183); match(LLA);
			setState(184); table_content();
			setState(185); match(LLC);
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

	public static class Table_headerContext extends ParserRuleContext {
		public Token select_terms;
		public Token derived_term;
		public List<TerminalNode> COMA() { return getTokens(HCSParser.COMA); }
		public TerminalNode Identifier(int i) {
			return getToken(HCSParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(HCSParser.Identifier); }
		public TerminalNode COMA(int i) {
			return getToken(HCSParser.COMA, i);
		}
		public TerminalNode IMPLIES() { return getToken(HCSParser.IMPLIES, 0); }
		public Table_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_header; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitTable_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_headerContext table_header() throws RecognitionException {
		Table_headerContext _localctx = new Table_headerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_table_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); ((Table_headerContext)_localctx).select_terms = match(Identifier);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(188); match(COMA);
				setState(189); ((Table_headerContext)_localctx).select_terms = match(Identifier);
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195); match(IMPLIES);
			setState(196); ((Table_headerContext)_localctx).derived_term = match(Identifier);
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

	public static class Table_contentContext extends ParserRuleContext {
		public List<Table_expressionContext> table_expression() {
			return getRuleContexts(Table_expressionContext.class);
		}
		public Table_expressionContext table_expression(int i) {
			return getRuleContext(Table_expressionContext.class,i);
		}
		public Table_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitTable_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_contentContext table_content() throws RecognitionException {
		Table_contentContext _localctx = new Table_contentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_table_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << Identifier) | (1L << String) | (1L << Integer) | (1L << S_Integer) | (1L << Float) | (1L << S_Float))) != 0)) {
				{
				{
				setState(198); table_expression();
				}
				}
				setState(203);
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

	public static class Table_expressionContext extends ParserRuleContext {
		public AtomContext select_terms;
		public AtomContext derived_term;
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode PyC() { return getToken(HCSParser.PyC, 0); }
		public List<TerminalNode> COMA() { return getTokens(HCSParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(HCSParser.COMA, i);
		}
		public TerminalNode IMPLIES() { return getToken(HCSParser.IMPLIES, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public Table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitTable_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_expressionContext table_expression() throws RecognitionException {
		Table_expressionContext _localctx = new Table_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); ((Table_expressionContext)_localctx).select_terms = atom();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(205); match(COMA);
				setState(206); ((Table_expressionContext)_localctx).select_terms = atom();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212); match(IMPLIES);
			setState(213); ((Table_expressionContext)_localctx).derived_term = atom();
			setState(214); match(PyC);
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

	public static class CardinalityContext extends ParserRuleContext {
		public Token min;
		public Token max;
		public List<TerminalNode> Integer() { return getTokens(HCSParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(HCSParser.Integer, i);
		}
		public TerminalNode CC() { return getToken(HCSParser.CC, 0); }
		public TerminalNode CA() { return getToken(HCSParser.CA, 0); }
		public TerminalNode COMA() { return getToken(HCSParser.COMA, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(CA);
			setState(217);
			((CardinalityContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ASTERISK || _la==Integer) ) {
				((CardinalityContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(218); match(COMA);
			setState(219);
			((CardinalityContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ASTERISK || _la==Integer) ) {
				((CardinalityContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(220); match(CC);
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
		public TerminalNode AND() { return getToken(HCSParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitAndExpr(this);
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
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaxExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(HCSParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MAX() { return getToken(HCSParser.MAX, 0); }
		public TerminalNode PC() { return getToken(HCSParser.PC, 0); }
		public MaxExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitMaxExpr(this);
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
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode HYPHEN() { return getToken(HCSParser.HYPHEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode PLUS() { return getToken(HCSParser.PLUS, 0); }
		public AdditiveExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitAdditiveExpr(this);
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
		public TerminalNode IFF() { return getToken(HCSParser.IFF, 0); }
		public IffExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitIffExpr(this);
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
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExprContext extends ExpressionContext {
		public Token op;
		public TerminalNode ASTERISK() { return getToken(HCSParser.ASTERISK, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SLASH() { return getToken(HCSParser.SLASH, 0); }
		public MultiplicationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(HCSParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssigExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIG() { return getToken(HCSParser.ASSIG, 0); }
		public AssigExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitAssigExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(HCSParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(HCSParser.PC, 0); }
		public ParExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinExprContext extends ExpressionContext {
		public TerminalNode PA() { return getToken(HCSParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MIN() { return getToken(HCSParser.MIN, 0); }
		public TerminalNode PC() { return getToken(HCSParser.PC, 0); }
		public MinExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitMinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExcludesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EXCLUDES() { return getToken(HCSParser.EXCLUDES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExcludesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitExcludesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTE() { return getToken(HCSParser.GTE, 0); }
		public TerminalNode LT() { return getToken(HCSParser.LT, 0); }
		public TerminalNode LTE() { return getToken(HCSParser.LTE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode GT() { return getToken(HCSParser.GT, 0); }
		public RelationalExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesExprContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REQUIRES() { return getToken(HCSParser.REQUIRES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IMPLIES() { return getToken(HCSParser.IMPLIES, 0); }
		public ImpliesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitImpliesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumExprContext extends ExpressionContext {
		public TerminalNode SUM() { return getToken(HCSParser.SUM, 0); }
		public TerminalNode PA() { return getToken(HCSParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(HCSParser.PC, 0); }
		public SumExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitSumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExprContext extends ExpressionContext {
		public Token op;
		public TerminalNode NEQ() { return getToken(HCSParser.NEQ, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQ() { return getToken(HCSParser.EQ, 0); }
		public EqualityExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(HCSParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new AssigExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223); match(Identifier);
				setState(224); match(ASSIG);
				setState(225); expression(18);
				}
				break;

			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226); match(NOT);
				setState(227); expression(17);
				}
				break;

			case 3:
				{
				_localctx = new SumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228); match(SUM);
				setState(229); match(PA);
				setState(230); expression(0);
				setState(231); match(PC);
				}
				break;

			case 4:
				{
				_localctx = new MinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233); match(MIN);
				setState(234); match(PA);
				setState(235); expression(0);
				setState(236); match(PC);
				}
				break;

			case 5:
				{
				_localctx = new MaxExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238); match(MAX);
				setState(239); match(PA);
				setState(240); expression(0);
				setState(241); match(PC);
				}
				break;

			case 6:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243); match(PA);
				setState(244); expression(0);
				setState(245); match(PC);
				}
				break;

			case 7:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247); list();
				}
				break;

			case 8:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248); array();
				}
				break;

			case 9:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249); atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(279);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(253);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==SLASH) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(254); expression(17);
						}
						break;

					case 2:
						{
						_localctx = new AdditiveExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(256);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==HYPHEN) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(257); expression(16);
						}
						break;

					case 3:
						{
						_localctx = new RelationalExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(259);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LTE) | (1L << GTE))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(260); expression(15);
						}
						break;

					case 4:
						{
						_localctx = new EqualityExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(262);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(263); expression(14);
						}
						break;

					case 5:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(265); match(AND);
						setState(266); expression(13);
						}
						break;

					case 6:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(268); match(OR);
						setState(269); expression(12);
						}
						break;

					case 7:
						{
						_localctx = new ImpliesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(271);
						_la = _input.LA(1);
						if ( !(_la==IMPLIES || _la==REQUIRES) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(272); expression(11);
						}
						break;

					case 8:
						{
						_localctx = new IffExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(274); match(IFF);
						setState(275); expression(10);
						}
						break;

					case 9:
						{
						_localctx = new ExcludesExprContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(277); match(EXCLUDES);
						setState(278); expression(9);
						}
						break;
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public TerminalNode CC() { return getToken(HCSParser.CC, 0); }
		public TerminalNode CA() { return getToken(HCSParser.CA, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(CA);
			setState(285); ((ListContext)_localctx).l1 = args();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(286); match(COMA);
				setState(287); ((ListContext)_localctx).l2 = args();
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(293); match(CC);
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
		public TerminalNode LLA() { return getToken(HCSParser.LLA, 0); }
		public TerminalNode LLC() { return getToken(HCSParser.LLC, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); match(LLA);
			setState(296); ((ArrayContext)_localctx).l1 = args();
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(297); match(COMA);
				setState(298); ((ArrayContext)_localctx).l2 = args();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304); match(LLC);
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
		public TerminalNode String() { return getToken(HCSParser.String, 0); }
		public TerminalNode Integer() { return getToken(HCSParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(HCSParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(HCSParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(HCSParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
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
		public TerminalNode Integer() { return getToken(HCSParser.Integer, 0); }
		public TerminalNode S_Integer() { return getToken(HCSParser.S_Integer, 0); }
		public IntegerAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitIntegerAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAtomContext extends AtomContext {
		public Token id;
		public Token value;
		public TerminalNode String() { return getToken(HCSParser.String, 0); }
		public TerminalNode CC() { return getToken(HCSParser.CC, 0); }
		public TerminalNode CA() { return getToken(HCSParser.CA, 0); }
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public ArrayAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitArrayAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatAtomContext extends AtomContext {
		public TerminalNode S_Float() { return getToken(HCSParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(HCSParser.Float, 0); }
		public FloatAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitFloatAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode Identifier() { return getToken(HCSParser.Identifier, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode String() { return getToken(HCSParser.String, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(HCSParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(HCSParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HCSVisitor ) return ((HCSVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_atom);
		int _la;
		try {
			setState(317);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new IntegerAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
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
				setState(309);
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
				setState(310);
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
				setState(311); ((ArrayAtomContext)_localctx).id = match(Identifier);
				setState(312); match(CA);
				setState(313); ((ArrayAtomContext)_localctx).value = match(String);
				setState(314); match(CC);
				}
				break;

			case 5:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(315); match(Identifier);
				}
				break;

			case 6:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(316); match(String);
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
		case 20: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\39\u0142\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5"+
		"\3\6\3\6\7\6T\n\6\f\6\16\6W\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\7\tf\n\t\f\t\16\ti\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\7\13s\n\13\f\13\16\13v\13\13\3\f\3\f\7\fz\n\f\f\f\16\f}\13\f\3\f\7"+
		"\f\u0080\n\f\f\f\16\f\u0083\13\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u009f\n\17\f\17\16\17\u00a2\13\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00ab\n\17\f\17\16\17\u00ae\13\17\3\17"+
		"\3\17\5\17\u00b2\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\7\22\u00c1\n\22\f\22\16\22\u00c4\13\22\3\22\3\22\3\22"+
		"\3\23\7\23\u00ca\n\23\f\23\16\23\u00cd\13\23\3\24\3\24\3\24\7\24\u00d2"+
		"\n\24\f\24\16\24\u00d5\13\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u00fd\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u011a\n\26\f\26\16\26\u011d\13\26\3\27\3\27"+
		"\3\27\3\27\7\27\u0123\n\27\f\27\16\27\u0126\13\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\7\30\u012e\n\30\f\30\16\30\u0131\13\30\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0140\n\32\3\32\2\33"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\r\3\2\62\63\3"+
		"\2\62\65\3\2\60\65\4\2\'\'\62\62\3\2\'(\3\2%&\4\2)*-.\3\2+,\3\2!\"\3\2"+
		"\64\65\3\2\20\21\u0151\2\67\3\2\2\2\4@\3\2\2\2\6F\3\2\2\2\bJ\3\2\2\2\n"+
		"Q\3\2\2\2\fX\3\2\2\2\16_\3\2\2\2\20c\3\2\2\2\22j\3\2\2\2\24p\3\2\2\2\26"+
		"w\3\2\2\2\30\u0084\3\2\2\2\32\u0087\3\2\2\2\34\u00b1\3\2\2\2\36\u00b3"+
		"\3\2\2\2 \u00b5\3\2\2\2\"\u00bd\3\2\2\2$\u00cb\3\2\2\2&\u00ce\3\2\2\2"+
		"(\u00da\3\2\2\2*\u00fc\3\2\2\2,\u011e\3\2\2\2.\u0129\3\2\2\2\60\u0134"+
		"\3\2\2\2\62\u013f\3\2\2\2\64\66\5\4\3\2\65\64\3\2\2\2\669\3\2\2\2\67\65"+
		"\3\2\2\2\678\3\2\2\28=\3\2\2\29\67\3\2\2\2:<\5\f\7\2;:\3\2\2\2<?\3\2\2"+
		"\2=;\3\2\2\2=>\3\2\2\2>\3\3\2\2\2?=\3\2\2\2@A\7\3\2\2AB\7\60\2\2BC\7\31"+
		"\2\2CD\5\6\4\2DE\7\32\2\2E\5\3\2\2\2FG\5\b\5\2GH\5\n\6\2HI\5\26\f\2I\7"+
		"\3\2\2\2JN\7\4\2\2KM\5\32\16\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2"+
		"O\t\3\2\2\2PN\3\2\2\2QU\7\5\2\2RT\5\32\16\2SR\3\2\2\2TW\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2V\13\3\2\2\2WU\3\2\2\2XY\7\7\2\2YZ\7\3\2\2Z[\7\60\2\2[\\"+
		"\7\31\2\2\\]\5\16\b\2]^\7\32\2\2^\r\3\2\2\2_`\5\20\t\2`a\5\24\13\2ab\5"+
		"\26\f\2b\17\3\2\2\2cg\7\b\2\2df\5\22\n\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2h\21\3\2\2\2ig\3\2\2\2jk\7\60\2\2kl\7\33\2\2lm\7\60\2\2mn\5"+
		"(\25\2no\7\34\2\2o\23\3\2\2\2pt\7\t\2\2qs\5\32\16\2rq\3\2\2\2sv\3\2\2"+
		"\2tr\3\2\2\2tu\3\2\2\2u\25\3\2\2\2vt\3\2\2\2w{\7\6\2\2xz\5\30\r\2yx\3"+
		"\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\u0081\3\2\2\2}{\3\2\2\2~\u0080\5"+
		" \21\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\27\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\5*\26\2\u0085"+
		"\u0086\7\34\2\2\u0086\31\3\2\2\2\u0087\u0088\7\60\2\2\u0088\u0089\7\33"+
		"\2\2\u0089\u008a\5\34\17\2\u008a\u008b\7\34\2\2\u008b\33\3\2\2\2\u008c"+
		"\u008d\7\13\2\2\u008d\u008e\7\25\2\2\u008e\u008f\t\2\2\2\u008f\u0090\7"+
		"\35\2\2\u0090\u0091\t\2\2\2\u0091\u00b2\7\26\2\2\u0092\u0093\7\f\2\2\u0093"+
		"\u0094\7\25\2\2\u0094\u0095\t\3\2\2\u0095\u0096\7\35\2\2\u0096\u0097\t"+
		"\3\2\2\u0097\u00b2\7\26\2\2\u0098\u00b2\7\r\2\2\u0099\u009a\7\16\2\2\u009a"+
		"\u009b\7\25\2\2\u009b\u00a0\5\36\20\2\u009c\u009d\7\35\2\2\u009d\u009f"+
		"\5\36\20\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2"+
		"\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4"+
		"\7\26\2\2\u00a4\u00b2\3\2\2\2\u00a5\u00a6\7\17\2\2\u00a6\u00a7\7\31\2"+
		"\2\u00a7\u00ac\5\36\20\2\u00a8\u00a9\7\35\2\2\u00a9\u00ab\5\36\20\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\32\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u008c\3\2\2\2\u00b1\u0092\3\2\2\2\u00b1\u0098\3\2"+
		"\2\2\u00b1\u0099\3\2\2\2\u00b1\u00a5\3\2\2\2\u00b2\35\3\2\2\2\u00b3\u00b4"+
		"\t\4\2\2\u00b4\37\3\2\2\2\u00b5\u00b6\7\n\2\2\u00b6\u00b7\7\27\2\2\u00b7"+
		"\u00b8\5\"\22\2\u00b8\u00b9\7\30\2\2\u00b9\u00ba\7\31\2\2\u00ba\u00bb"+
		"\5$\23\2\u00bb\u00bc\7\32\2\2\u00bc!\3\2\2\2\u00bd\u00c2\7\60\2\2\u00be"+
		"\u00bf\7\35\2\2\u00bf\u00c1\7\60\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7!\2\2\u00c6\u00c7\7\60\2\2\u00c7#\3\2\2\2"+
		"\u00c8\u00ca\5&\24\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc%\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d3\5\62\32\2\u00cf\u00d0\7\35\2\2\u00d0\u00d2\5\62\32\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7!\2\2\u00d7\u00d8\5\62"+
		"\32\2\u00d8\u00d9\7\34\2\2\u00d9\'\3\2\2\2\u00da\u00db\7\25\2\2\u00db"+
		"\u00dc\t\5\2\2\u00dc\u00dd\7\35\2\2\u00dd\u00de\t\5\2\2\u00de\u00df\7"+
		"\26\2\2\u00df)\3\2\2\2\u00e0\u00e1\b\26\1\2\u00e1\u00e2\7\60\2\2\u00e2"+
		"\u00e3\7/\2\2\u00e3\u00fd\5*\26\2\u00e4\u00e5\7 \2\2\u00e5\u00fd\5*\26"+
		"\2\u00e6\u00e7\7\22\2\2\u00e7\u00e8\7\27\2\2\u00e8\u00e9\5*\26\2\u00e9"+
		"\u00ea\7\30\2\2\u00ea\u00fd\3\2\2\2\u00eb\u00ec\7\23\2\2\u00ec\u00ed\7"+
		"\27\2\2\u00ed\u00ee\5*\26\2\u00ee\u00ef\7\30\2\2\u00ef\u00fd\3\2\2\2\u00f0"+
		"\u00f1\7\24\2\2\u00f1\u00f2\7\27\2\2\u00f2\u00f3\5*\26\2\u00f3\u00f4\7"+
		"\30\2\2\u00f4\u00fd\3\2\2\2\u00f5\u00f6\7\27\2\2\u00f6\u00f7\5*\26\2\u00f7"+
		"\u00f8\7\30\2\2\u00f8\u00fd\3\2\2\2\u00f9\u00fd\5,\27\2\u00fa\u00fd\5"+
		".\30\2\u00fb\u00fd\5\62\32\2\u00fc\u00e0\3\2\2\2\u00fc\u00e4\3\2\2\2\u00fc"+
		"\u00e6\3\2\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00f5\3\2"+
		"\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u011b\3\2\2\2\u00fe\u00ff\6\26\2\3\u00ff\u0100\t\6\2\2\u0100\u011a\5"+
		"*\26\2\u0101\u0102\6\26\3\3\u0102\u0103\t\7\2\2\u0103\u011a\5*\26\2\u0104"+
		"\u0105\6\26\4\3\u0105\u0106\t\b\2\2\u0106\u011a\5*\26\2\u0107\u0108\6"+
		"\26\5\3\u0108\u0109\t\t\2\2\u0109\u011a\5*\26\2\u010a\u010b\6\26\6\3\u010b"+
		"\u010c\7\36\2\2\u010c\u011a\5*\26\2\u010d\u010e\6\26\7\3\u010e\u010f\7"+
		"\37\2\2\u010f\u011a\5*\26\2\u0110\u0111\6\26\b\3\u0111\u0112\t\n\2\2\u0112"+
		"\u011a\5*\26\2\u0113\u0114\6\26\t\3\u0114\u0115\7#\2\2\u0115\u011a\5*"+
		"\26\2\u0116\u0117\6\26\n\3\u0117\u0118\7$\2\2\u0118\u011a\5*\26\2\u0119"+
		"\u00fe\3\2\2\2\u0119\u0101\3\2\2\2\u0119\u0104\3\2\2\2\u0119\u0107\3\2"+
		"\2\2\u0119\u010a\3\2\2\2\u0119\u010d\3\2\2\2\u0119\u0110\3\2\2\2\u0119"+
		"\u0113\3\2\2\2\u0119\u0116\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c+\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f"+
		"\7\25\2\2\u011f\u0124\5\60\31\2\u0120\u0121\7\35\2\2\u0121\u0123\5\60"+
		"\31\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7\26"+
		"\2\2\u0128-\3\2\2\2\u0129\u012a\7\31\2\2\u012a\u012f\5\60\31\2\u012b\u012c"+
		"\7\35\2\2\u012c\u012e\5\60\31\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2"+
		"\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0132\u0133\7\32\2\2\u0133/\3\2\2\2\u0134\u0135\t\4\2\2\u0135"+
		"\61\3\2\2\2\u0136\u0140\t\2\2\2\u0137\u0140\t\13\2\2\u0138\u0140\t\f\2"+
		"\2\u0139\u013a\7\60\2\2\u013a\u013b\7\25\2\2\u013b\u013c\7\61\2\2\u013c"+
		"\u0140\7\26\2\2\u013d\u0140\7\60\2\2\u013e\u0140\7\61\2\2\u013f\u0136"+
		"\3\2\2\2\u013f\u0137\3\2\2\2\u013f\u0138\3\2\2\2\u013f\u0139\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140\63\3\2\2\2\26\67=NUgt{\u0081"+
		"\u00a0\u00ac\u00b1\u00c2\u00cb\u00d3\u00fc\u0119\u011b\u0124\u012f\u013f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}