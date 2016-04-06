grammar HCS;

/*=====================================
            SYNTACTICAL RULES
 ======================================*/

entry : conf_service* highly_conf_service*
      ;

conf_service: SERVICE service_id=Identifier LLA conf_service_definition LLC;
conf_service_definition: selectable_terms derived_terms dependencies;
selectable_terms: SELECTABLE_TERMS property*;
derived_terms: DERIVED_TERMS property*;

highly_conf_service: HIGHLY_CONF SERVICE service_id=Identifier LLA highly_conf_service_def LLC;
highly_conf_service_def: services global_terms dependencies;
services: SERVICES service*;
service: service_id=Identifier DP service_type=Identifier cardinality PyC;
global_terms: GLOBAL_TERMS property*;


dependencies: DEPENDENCIES dependency* table*;
dependency: expression PyC;

property: id=Identifier DP dom=domain PyC ;
domain: datatype=INTEGER CA min=(Integer | S_Integer) COMA max=(Integer | S_Integer) CC
      | datatype=FLOAT CA min=(Float | S_Float | Integer | S_Integer) COMA max=(Float | S_Float | Integer | S_Integer) CC
      | datatype=BOOLEAN
      | datatype=SET CA params=parameters (COMA params=parameters)* CC
      | datatype=ENUM LLA params=parameters (COMA params=parameters)* LLC
      ;   
parameters : Identifier | String | Integer | S_Integer | Float | S_Float;

table: TABLE PA table_header PC LLA table_content LLC;
table_header:  select_terms=Identifier (COMA select_terms=Identifier)* IMPLIES derived_term=Identifier;
table_content: table_expression*;
table_expression: select_terms=atom (COMA select_terms=atom)* IMPLIES derived_term=atom PyC;

cardinality: CA min=(Integer | '*') COMA max=(Integer | '*') CC;


//---------------------------------------
// Expressions
//---------------------------------------

expression: Identifier ASSIG expression                     #assigExpr
          | NOT expression                                  #notExpr
          | expression op=(ASTERISK | SLASH) expression     #multiplicationExpr
          | expression op=(PLUS | HYPHEN) expression        #additiveExpr
          | expression op=(LTE | GTE | LT | GT) expression  #relationalExpr
          | expression op=(EQ | NEQ) expression             #equalityExpr
          | expression AND expression                       #andExpr
          | expression OR expression                        #orExpr
          | expression (IMPLIES | REQUIRES) expression      #impliesExpr
          | expression IFF expression                       #iffExpr
          | expression EXCLUDES expression                  #excludesExpr
          | SUM PA expression PC                            #sumExpr
          | MIN PA expression PC                            #minExpr
          | MAX PA expression PC                            #maxExpr
          | PA expression PC                                #parExpr
          | list                                            #listExpr
          | array                                           #arrayExpr
          | atom                                            #atomExpr
          ;

list : CA l1=args (',' l2=args)* CC ;
array : LLA l1=args (',' l2=args)* LLC ;
args : l1=(Identifier | String | Integer | S_Integer | Float | S_Float);

atom : (Integer | S_Integer)                        #integerAtom
       | (Float | S_Float)                          #floatAtom
       | (TRUE | FALSE)                             #booleanAtom
       | id=Identifier CA value=String CC           #arrayAtom
       | Identifier                                 #idAtom
       | String                                     #stringAtom
     ;



/*=====================================
            LEXICAL RULES
 ======================================*/


//---------------------------------------
// Language Keywords
//---------------------------------------

SERVICE: 'Service';
SELECTABLE_TERMS: '%SelectableTerms';
DERIVED_TERMS: '%DerivedTerms';
DEPENDENCIES: '%Dependencies';

HIGHLY_CONF: 'Highly_configurable';
SERVICES: '%Services';
GLOBAL_TERMS: '%GlobalTerms';

TABLE: 'table';

INTEGER : 'int';
FLOAT : 'real';
BOOLEAN : 'boolean';
SET : 'set';
ENUM : 'enum';

TRUE : 'true';
FALSE : 'false';

//---------------------------------------
// Functions
//---------------------------------------

SUM: 'sum';
MIN: 'min';
MAX: 'max';


//---------------------------------------
// Commons tokens
//---------------------------------------

CA : '[';
CC : ']';
PA : '(';
PC : ')';
LLA : '{';
LLC : '}';
DP: ':';
PyC: ';';
COMA: ',';

//---------------------------------------
// Logical operators
//---------------------------------------

AND : '&&';
OR : '||';
NOT : '!';
IMPLIES : '->';
REQUIRES : 'REQUIRES';
IFF: 'IFF';
EXCLUDES : 'EXCLUDES';

//---------------------------------------
// Arithmetical operators
//---------------------------------------

PLUS: '+';
HYPHEN: '-';
ASTERISK: '*';
SLASH: '/';

//---------------------------------------
// Relational tokens
//---------------------------------------

LT : '<';
GT : '>';
EQ : '==';
NEQ : '!=';
LTE : '<=';
GTE : '>=';
ASSIG: '=';

//---------------------------------------
// Basic Lexical Elements
//---------------------------------------

Identifier: Letter ('-'|'_'|'.'|LetterOrDigit)*;

fragment Letter : [a-zA-Z$_];

fragment LetterOrDigit : [a-zA-Z0-9$_];

fragment Digit : '0' | NonZeroDigit;
fragment NonZeroDigit : [1-9];
String : '\'' ~[']* '\'' 
       | '"' ~["]* '"'
       ;

Integer : Digit+;
S_Integer : [+-] Integer;

Float: Integer '.' Integer;
S_Float : [+-] Float;

Boolean : TRUE | FALSE;

//---------------------------------------
// Padding & Comments
//---------------------------------------

WS : [ \t\r\n]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;