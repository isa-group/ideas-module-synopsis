grammar Needs;

/*=====================================
            SYNTACTICAL RULES
 ======================================*/

entry : NEEDS ON service_id=Identifier LLA needs_definition LLC;

needs_definition: items requirements preferences;

items: ITEMS property*;

requirements: REQUIREMENTS requirement*;

preferences: PREFERENCES preference*;

property: id=Identifier CA params=parameters (COMA params=parameters)* CC PyC ;
parameters : Identifier | String | Integer | S_Integer | Float | S_Float;

requirement: expression PyC;

preference: method=FAVORITES PA item_term (COMA atom)? PC PyC
          | method=DISLIKES PA item_term (COMA atom)? PC PyC
          | method=HIGHEST PA item_term PC PyC
          | method=LOWEST PA item_term PC PyC
          | method=AROUND PA item_term (COMA atom)? PC PyC
          ;

item_term: alias=Identifier (CA service_id=String CC DOT feature=Identifier)?;

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
       | item_term                                  #itemTermAtom
     ;



/*=====================================
            LEXICAL RULES
 ======================================*/


//---------------------------------------
// Language Keywords
//---------------------------------------

NEEDS: 'Needs';

ITEMS: '%Items';
REQUIREMENTS: '%Requirements';
PREFERENCES: '%Preferences';

INTEGER : 'int';
FLOAT : 'real';
BOOLEAN : 'boolean';
SET : 'set';
ENUM : 'enum';

TRUE : 'true';
FALSE : 'false';

ON: 'on';

//---------------------------------------
// Functions
//---------------------------------------

SUM: 'sum';
MIN: 'min';
MAX: 'max';
FAVORITES: 'Favorites';
DISLIKES: 'Dislikes';
HIGHEST: 'Highest';
LOWEST: 'Lowest';
AROUND: 'Around';


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
DOT: '.';

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