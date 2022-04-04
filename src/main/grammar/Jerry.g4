grammar Jerry;

jerry
    : NEWLINE* p = program NEWLINE* EOF;

program //todo fix NEWLINE
    : (varDecStatement (SEMICOLON)? NEWLINE+)*
      (classDeclaration NEWLINE+)*;

constructor
    : PUBLIC INITIALIZE methodArgsDec body;

//todo
classDeclaration
    : CLASS class_identifier (LESS_THAN identifier)? NEWLINE* LBRACE NEWLINE+
    ((field_decleration* constructor field_decleration*) | (field_decleration*))
    RBRACE NEWLINE*;

field_decleration
    : (PUBLIC | PRIVATE) (varDecStatement | method) (SEMICOLON)? NEWLINE+;

method
    : (type | VOID) identifier methodArgsDec NEWLINE* body;

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

//todo fix a++
singleStatement :
    ifStatement | printStatement | methodCallStmt | returnStatement | assignmentStatement
    | varDecStatement | loopStatement;


//todo
varDecStatement :
    type identifier (COMMA identifier)*;


//todo
ifStatement :
    IF (LPAR | ) expression (RPAR | ) body
    elsifStatement*
    elseStatement?;

elsifStatement :
     NEWLINE* ELSIF (LPAR | ) expression (RPAR | ) body;

//todo
elseStatement :
     NEWLINE* ELSE body;

//todo
printStatement :
    PRINT LPAR expression RPAR;

//todo check if meth is possible instead of S.meth
//if not remove (LPAR methodArgs RPAR)
methodCallStmt :
    otherExpression ((LPAR methodArgs RPAR) | (DOT identifier))* (LPAR methodArgs RPAR);

//todo
returnStatement :
    RETURN (expression)?;

//todo
assignmentStatement :
    orExpression ASSIGN expression;

//todo
loopStatement :
    ((identifier) | (LPAR expression DOT DOT expression RPAR)) DOT EACH LBRACK identifier RBRACK
    body;

//todo
expression:
    ternaryExpression (op = ASSIGN expression )? ;

//todo
ternaryExpression:
    orExpression (op = TIF ternaryExpression TELSE ternaryExpression)* ;

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

class_identifier:
    CLASS_IDENTIFIER;

//todo
identifier:
    IDENTIFIER;

//todo
type:
    INT | BOOL | array_type | fptr_type | set_type | class_identifier;

array_type:
    (INT | BOOL | class_identifier) (LBRACK expression RBRACK)+;

//todo
fptr_type:
    FPTR LESS_THAN (VOID | (type (COMMA type)*)) ARROW (type | VOID) GREATER_THAN;

set_type:
    SET LESS_THAN (INT) GREATER_THAN;



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
INCLUDE: 'include';
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
IDENTIFIER: [a-z_][A-Za-z0-9_]*;
CLASS_IDENTIFIER: [A-Z][A-Za-z0-9_]*;

COMMENT: '#' .*? '\n' -> skip;
MLCOMMENT: ('=begin' .*? '=end') -> skip;
WS: ([ \t\r]) -> skip;
LINE_BREAK: ('//\n') -> skip;
