grammar SimpleLOOP;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.classDec.*;
     import main.ast.nodes.declaration.variableDec.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.nodes.statement.set.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import main.ast.types.set.*;
     import main.ast.types.functionPointer.*;
     import main.ast.types.array.*;
     import java.util.*;
 }

simpleLOOP returns [Program simpleLOOPProgram]:
    NEWLINE* p = program {$simpleLOOPProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (v = varDecStatement (SEMICOLON)? NEWLINE+ {$programRet.addGlobalVariable($v.variableDeclarationRet);})*
    (c = classDeclaration NEWLINE+ {$programRet.addClass($c.classDeclarationRet);})*;

//todo
constructor
    : INITIALIZE methodArgsDec body;

//todo
classDeclaration
    : CLASS name=(CLASS_IDENTIFIER | MAIN) (LESS_THAN PR=CLASS_IDENTIFIER)?
    NEWLINE* ((LBRACE NEWLINE+ field_decleration+ RBRACE) | (field_decleration)) NEWLINE*;

//todo
field_decleration
    : (PUBLIC | PRIVATE) (varDecStatement | method | constructor) (SEMICOLON)? NEWLINE+;

//todo
method
    : (type | VOID) IDENTIFIER methodArgsDec NEWLINE* body;

//todo
methodArgsDec
    : LPAR (argDec ((ASSIGN orExpression) | (COMMA argDec)*) (COMMA argDec ASSIGN orExpression)*)?  RPAR ;

//todo
argDec
    : type IDENTIFIER ;

//todo
methodArgs
    : (expression (COMMA expression)*)?;

//todo
body :
     (blockStatement | (NEWLINE+ singleStatement (SEMICOLON)?));

//todo
blockStatement :
    LBRACE (NEWLINE+ singleStatement (SEMICOLON)?)+ NEWLINE+ RBRACE;

//todo
singleStatement :
    ifStatement | printStatement | methodCallStmt | returnStatement | assignmentStatement
    | varDecStatement | loopStatement | addStatement | mergeStatement | deleteStatement;

//todo
addStatement :
    identifier DOT ADD LPAR orExpression RPAR;

//todo
mergeStatement :
    identifier DOT MERGE LPAR orExpression (COMMA orExpression)* RPAR;

//todo
deleteStatement :
    identifier DOT DELETE LPAR orExpression RPAR;

//todo
varDecStatement :
    type IDENTIFIER (COMMA ID2=IDENTIFIER)*;

//todo
ifStatement :
    IF condition body
    elsifStatement*
    elseStatement?;

//todo
elsifStatement :
     NEWLINE* ELSIF condition body;

//todo
condition :
    (LPAR expression RPAR) | expression;

//todo
elseStatement :
     NEWLINE* ELSE body;

//todo
printStatement :
    PRINT LPAR expression RPAR;

//todo
methodCallStmt :
    accessExpression  (DOT (INITIALIZE | identifier))*
    ((LPAR methodArgs RPAR) | ((op = INC | op = DEC)));

//todo
returnStatement :
    RETURN expression?;

//todo
assignmentStatement :
    orExpression ASSIGN expression;

//todo
loopStatement :
    ((identifier) | (LPAR expression DOT DOT expression RPAR)) DOT EACH DO BAR identifier BAR
    body;

//todo
expression:
    ternaryExpression (ASSIGN expression)?;

//todo
ternaryExpression:
    orExpression (TIF ternaryExpression TELSE ternaryExpression)*;

//todo
orExpression:
    andExpression (OR andExpression)*;

//todo
andExpression:
    equalityExpression (AND equalityExpression)*;

//todo
equalityExpression:
    relationalExpression (EQUAL relationalExpression)*;

//todo
relationalExpression:
    additiveExpression ((GREATER_THAN | LESS_THAN) additiveExpression)*;

//todo
additiveExpression:
    multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*;

//todo
multiplicativeExpression:
    preUnaryExpression ((MULT | DIVIDE) preUnaryExpression)*;

//todo
preUnaryExpression:
    ((NOT | MINUS) preUnaryExpression)
    | postUnaryExpression;

//todo
postUnaryExpression:
    accessExpression ((INC | DEC))?;

//todo
accessExpression:
    otherExpression ((LPAR methodArgs RPAR) | (DOT identifier))* ((DOT identifier) | (LBRACK expression RBRACK))*;

//todo
otherExpression:
    value | identifier | LPAR methodArgs RPAR | setNew | setInclude| accessByIndex;

//todo
accessByIndex:
    identifier LBRACK expression RBRACK;

//todo
setNew:
    SET DOT NEW LPAR (LPAR orExpression (COMMA orExpression)* RPAR)? RPAR;

//todo
setInclude:
    identifier DOT INCLUDE LPAR orExpression RPAR;

//todo
value :
    boolValue | INT_VALUE;

//todo
boolValue:
    TRUE | FALSE;

//todo
class_identifier:
    CLASS_IDENTIFIER;

//todo
identifier:
    IDENTIFIER;

//todo
type:
    INT | BOOL | array_type | fptr_type | set_type | class_identifier;

//todo
array_type:
    (INT | BOOL | class_identifier) (LBRACK expression RBRACK)+;

//todo
fptr_type:
    FPTR LESS_THAN (VOID | (type (COMMA type)*)) ARROW (type | VOID) GREATER_THAN;

//todo
set_type:
    SET LESS_THAN (INT) GREATER_THAN;


LINE_BREAK: ('//\n') -> skip;

CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
NEW: 'new';


MAIN: 'Main';
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
