grammar Thomas;

//todo locals only defined in the beginning of scope

thomas
    : NEWLINE* p = program NEWLINE* EOF;

program
    : (varDecStatement (SEMICOLON)? NEWLINE+)*
      (classDeclaration NEWLINE+)* (classDeclaration | );

constructor
    : INITIALIZE methodArgsDec body;

//todo
classDeclaration
    : CLASS CLASS_IDENTIFIER {System.out.println("ClassDec : " + $CLASS_IDENTIFIER.getText());}
    (LESS_THAN PR=CLASS_IDENTIFIER {System.out.println("Inheritance : " + $CLASS_IDENTIFIER.getText() + " < " + $PR.getText());})?
    NEWLINE* LBRACE NEWLINE+
    field_decleration*
    RBRACE NEWLINE*;

field_decleration
    : (PUBLIC | PRIVATE) (varDecStatement | method | constructor) (SEMICOLON)? NEWLINE+;

method
    : (type | VOID) IDENTIFIER {System.out.println("MethodDec : " + $IDENTIFIER.getText());} methodArgsDec NEWLINE* body;

//todo
methodArgsDec
    : LPAR ( argDec (COMMA argDec)*)? RPAR ;

argDec
    : type IDENTIFIER {System.out.println("ArgumentDec : " + $IDENTIFIER.getText());} (ASSIGN orExpression)? ;

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

addStatement :
    identifier DOT ADD {System.out.println("ADD");} LPAR orExpression RPAR;

mergeStatement :
    identifier DOT MERGE {System.out.println("MERGE");} LPAR orExpression (COMMA orExpression)* RPAR;

deleteStatement :
    identifier DOT DELETE {System.out.println("DELETE");} LPAR orExpression RPAR;

varDecStatement :
    type IDENTIFIER {System.out.println("VarDec : " + $IDENTIFIER.getText());}
    (COMMA ID2=IDENTIFIER {System.out.println("VarDec : " + $ID2.getText());})*;

//todo
ifStatement :
    IF {System.out.println("Conditional : if");} (LPAR | ) expression (RPAR | ) body
    elsifStatement*
    elseStatement?;

elsifStatement :
     NEWLINE* ELSIF {System.out.println("Conditional : elsif");} (LPAR | ) expression (RPAR | ) body;

//todo
elseStatement :
     NEWLINE* ELSE {System.out.println("Conditional : else");} body;

printStatement :
    PRINT {System.out.println("Built-in : print");} LPAR expression RPAR;

methodCallStmt :
    otherExpression  (DOT identifier)* (({System.out.println("MethodCall");} LPAR methodArgs RPAR)
                                        | ((op = INC | op = DEC) {System.out.println("Operator : " + $op.getText());}));

returnStatement :
    RETURN {System.out.println("Return");} (expression)?;

assignmentStatement :
    orExpression ASSIGN expression;

loopStatement :
    ((identifier) | (LPAR expression DOT DOT expression RPAR)) DOT EACH {System.out.println("Loop : each");}
    DO BAR identifier BAR
    body;

expression:
    ternaryExpression (op = ASSIGN expression )? ;

ternaryExpression:
    orExpression (op = TIF ternaryExpression TELSE ternaryExpression)* {System.out.println("Operator : ?:");};

orExpression:
    andExpression (op = OR andExpression )* {System.out.println("Operator : ||");};

andExpression:
    equalityExpression (op = AND equalityExpression )* {System.out.println("Operator : &&");};

equalityExpression:
    relationalExpression (op = EQUAL relationalExpression )* {System.out.println("Operator : ==");};

relationalExpression:
    additiveExpression ((op = GREATER_THAN | op = LESS_THAN) additiveExpression )*
        {System.out.println("Operator : "+$op.getText());};

additiveExpression:
    multiplicativeExpression ((op = PLUS | op = MINUS) multiplicativeExpression )*
            {System.out.println("Operator : "+$op.getText());};

//todo
multiplicativeExpression:
    preUnaryExpression ((op = MULT | op = DIVIDE) preUnaryExpression )*
            {System.out.println("Operator : "+$op.getText());};

//todo
preUnaryExpression:
    ((op = NOT | op = MINUS) preUnaryExpression {System.out.println("Operator : "+$op.getText());})
    | postUnaryExpression;

postUnaryExpression:
    accessExpression (op = INC | op = DEC)?
            {System.out.println("Operator : "+$op.getText());};

//todo
accessExpression:
    otherExpression ((LPAR methodArgs RPAR) | (DOT identifier))*  ((LBRACK expression RBRACK) | (DOT identifier))*;

//todo
otherExpression:
    value | identifier | LPAR (methodArgs) RPAR | setNew | setInclude| accessByIndex;

accessByIndex:
    identifier LBRACK expression RBRACK;

setNew:
    SET DOT NEW {System.out.println("NEW");} LPAR (orExpression (COMMA orExpression)*)? RPAR;

setInclude:
    identifier DOT INCLUDE {System.out.println("INCLUDE");} LPAR orExpression RPAR;

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
