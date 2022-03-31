grammar Joey;

joey
    : NEWLINE* p = program NEWLINE* EOF;

program
    : NEWLINE*
    (varDecStatement)* NEWLINE*
    (classDeclaration)* NEWLINE*
    mainClass NEWLINE*;

mainClass
    : CLASS MAIN LBRACE NEWLINE*
     (varDecStatement | method)* NEWLINE* constructor NEWLINE* (varDecStatement| method)*
     RBRACE;

constructor
    : PUBLIC INITIALIZE LPAR RPAR body;

//todo
classDeclaration
    : CLASS identifier (LESS_THAN identifier)? LBRACE NEWLINE*
    (((varDecStatement | method)* constructor (varDecStatement| method)*)
    | ((varDecStatement | method)*))
    RBRACE;


method
    : (PUBLIC | PRIVATE) (type | VOID) identifier methodArgsDec body NEWLINE*;

//todo
methodArgsDec
    : LPAR ( argDec (COMMA argDec)*)? RPAR ;

argDec
    : type identifier (ASSIGN orExpression)? ;

//todo
methodArgs
    : (expression (COMMA expression)*)?;


//todo
body :
     (blockStatement | (NEWLINE+ singleStatement (SEMICOLON)?));

//todo
blockStatement :
    LBRACE (NEWLINE+ (singleStatement SEMICOLON)* singleStatement (SEMICOLON)?)+ NEWLINE+ RBRACE;

//todo
singleStatement :
    ifStatement | printStatement | methodCallStmt | returnStatement | assignmentStatement
    | varDecStatement | loopStatement;


//todo can we have a,b=2? wb int a=1
varDecStatement :
    type ((identifier (ASSIGN orExpression )?) | (identifier (COMMA identifier)*));


//todo is () necessary?
ifStatement :
    IF LPAR expression RPAR body
    elsifStatement*
    elseStatement?;

elsifStatement :
     NEWLINE* ELSIF LPAR expression RPAR body;

//todo wb loopCondbody?
elseStatement :
     NEWLINE* ELSE body;

//todo
printStatement :
    PRINT LPAR expression RPAR;

//todo check
methodCallStmt :
    otherExpression ((LPAR methodArgs RPAR) | (DOT identifier))* (LPAR methodArgs RPAR);

//todo
returnStatement :
    RETURN (expression)?;

//todo
assignmentStatement :
    orExpression ASSIGN expression;

//todo NEGATIVE VALUES POSSIBLE?
loopStatement :
    ((identifier) | (LPAR INT_VALUE DOT DOT INT_VALUE RPAR)) DOT EACH BAR identifier BAR
    body;

//todo
expression:
    orExpression (op = ASSIGN expression )? ;

//todo
orExpression:
    andExpression (op = OR andExpression )*;

//todo
andExpression:
    equalityExpression (op = AND equalityExpression )*;

//todo
equalityExpression:
    relationalExpression (op = EQUAL relationalExpression )*;

//todo
relationalExpression:
    additiveExpression ((op = GREATER_THAN | op = LESS_THAN) additiveExpression )*;

//todo
additiveExpression:
    multiplicativeExpression ((op = PLUS | op = MINUS) multiplicativeExpression )*;

//todo
multiplicativeExpression:
    preUnaryExpression ((op = MULT | op = DIVIDE) preUnaryExpression )*;

//todo
preUnaryExpression:
    ((op = NOT | op = MINUS) preUnaryExpression ) | postUnaryExpression;

postUnaryExpression:
    accessExpression (INC | DEC)?;

//todo
accessExpression:
    otherExpression ((LPAR methodArgs RPAR) | (DOT identifier))*  ((LBRACK expression RBRACK) | (DOT identifier))*;

//todo
otherExpression:
    value | identifier | LPAR (methodArgs) RPAR;

//todo
value :
    boolValue | INT_VALUE;

//todo
boolValue:
    TRUE | FALSE;

//todo
identifier:
    IDENTIFIER;

//todo add array and Set and Class object
type:
    INT | BOOL | fptrType;

//todo
fptrType:
    FPTR LESS_THAN (VOID | (type (COMMA type)*)) ARROW (type | VOID) GREATER_THAN;


CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
SELF: 'self';
NEW: 'new';


MAIN: 'main';
RETURN: 'return';
VOID: 'void';


DELETE: 'delete';
INCLUDE: 'include'; //TODO: contain?
ADD: 'add';
MERGE: 'merge';
PRINT: 'print';


IF: 'if';
ELSE: 'else';
ELSIF: 'elsif';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';
INC: '++';
DEC: '--';

EQUAL: '==';
GREATER_THAN: '>';
LESS_THAN: '<';

ARROW: '->';
BAR: '|';

AND: '&&';
OR: '||';
NOT: '!';

TIF: '?';
TELSE: ':';

TRUE: 'true';
FALSE: 'false';
NULL: 'null';

BEGIN: '=begin';
END: '=end';

INT: 'int';
BOOL: 'bool';
FPTR: 'fptr';
SET: 'Set';
EACH: 'each';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

COMMA: ',';
DOT: '.';
SEMICOLON: ';';
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;


COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;