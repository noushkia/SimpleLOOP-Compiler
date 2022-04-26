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
    (v = varDecStatement NEWLINE+
    {
        for (VariableDecleration varDec: $v.varDecStmtRet)
            $programRet.addGlobalVariable(varDec);
    })*
    (c = classDeclaration NEWLINE+ {$programRet.addClass($c.classDeclarationRet);})*;

//todo
constructor returns [ConstructorDeclaration constructorRet]
    : PUBLIC init = INITIALIZE
    { $constructorRet = new ConstructorDeclaration();
        $constructorRet.setLine($init.getLine());
     }
      args = methodArgsDec
       { $constructorRet.setArgs($args.argsRet); }
       bod = methodBody
       {
        $constructorRet.setLocalVars($bod.localVars);
        $constructorRet.setBody($bod.statements);
       };


//todo
classDeclaration returns [ ClassDeclaration classDeclarationRet]
    : cl=CLASS name=class_identifier
    {
        $classDeclarationRet = new ClassDeclaration($name.idRet);
        $classDeclarationRet.setLine($cl.getline());
    }
    (
    LESS_THAN parentName=class_identifier
    { $classDeclarationRet.setParentClassName($parentName.idRet); }
    )?
    NEWLINE* ((LBRACE NEWLINE+
    (
    (( access=(PUBLIC | PRIVATE)
        (v=varDecStatement
        {
            for (VariableDecleration varDec: $v.varDecStmtRet) {
                var newField = new FieldDeclaration(varDec, $access == "public" ? true : false );
                $classDeclarationRet.addField(newField);
            }
        }
        | m=method
        {
            var newMethod = $m.methodDecRet;
            newMethod.setPrivate($access == "public" ? false : true);
            $classDeclarationRet.addMethod(newMethod);
        }))
        | c=constructor
        {
            $classDeclarationRet.setConstructor($c.constructorRet);
        })
    NEWLINE+)+ RBRACE)
     | (
       (( access=(PUBLIC | PRIVATE)
           (v=varDecStatement
           {
                for (VariableDecleration varDec: $v.varDecStmtRet) {
                    var newField = new FieldDeclaration(varDec, $access == "public" ? true : false );
                    $classDeclarationRet.addField(newField);
                }
           }
           | m=method
           {
                var newMethod = $m.methodDecRet;
                newMethod.setPrivate($access == "public" ? false : true);
                $classDeclarationRet.addMethod(newMethod);
           }))
           | c=constructor
           {
               $classDeclarationRet.setConstructor($c.constructorRet);
            })
       NEWLINE+)) NEWLINE*;

//todo
method returns [MethodDeclaration methodDecRet]
    : (t=type { $returnType = $t.typeRet; }
     | VOID { $returnType = new VoidType(); }
     ) name=identifier
      args = methodArgsDec NEWLINE*
      bod=methodBody
      {
        $methodDecRet = new MethodDeclaration($name.IdRet, $returnType, false);
        $methodDecRet.setLine($name.IdRet.getLine());
        $methodDecRet.setArgs($args.argsRet);
        $methodDecRet.setLocalVars($bod.localVars);
        $methodDecRet.setBody($bod.statements);
      };

//todo
methodBody returns [ArrayList<VariableDeclaration> localVars, ArrayList<Statement> statements]
    :
    {
        $localVars = new ArrayList<>();
        $statements = new ArrayList<>();
    }
    (LBRACE NEWLINE+
    (v=varDecStatement NEWLINE+
    { $localVars.add($v.varDeclerationRet); })*
    (s=singleStatement NEWLINE+
    { $statements.add($s.statementRet); })* RBRACE)
    |
    (
    (v=varDecStatement NEWLINE+
    { $localVars.add($v.varDeclerationRet); }
    )
    | (s=singleStatement NEWLINE+
    { $statements.add($s.statementRet); })
    );

//todo
methodArgsDec returns [ArrayList<VariableDeclaration> argsRet]
    : LPAR
    { $argsRet = new Arraylist<>(); }
    (arg=argDec
       { $argsRet.add($arg.arg); }
     ((ASSIGN orExpression)
    | (COMMA arg=argDec
       { $argsRet.add($arg.arg); }
      )*) (COMMA arg=argDec
       { $argsRet.add($arg.arg); }
        ASSIGN orExpression)*)?
      RPAR ;

//todo
argDec returns [VariableDeclaration arg]
    : typ=type
     name=identifier
     { $arg = new VariableDeclaration($name.IdRet, $typ.typeRet); };

//todo
methodArgs returns [ArrayList<Expression> methodCallArgsRet]
    : { $methodCallArgsRet = new ArrayList<>(); }
      (e1=expression
      { $methodCallArgsRet.add($e1.exprRet); }
      (COMMA e2=expression
      { $methodCallArgsRet.add($e2.exprRet); }
      )*
      )?;

//todo
body returns [Statement statementRet]:
     (bs=blockStatement
      { $statementRet = $bs.blockRet}
      | (NEWLINE+ ss=singleStatement { $statementRet = $ss.singleRet }));

//todo
blockStatement returns [BlockStmt blockRet]:
    lb=LBRACE
     { $blockRet = new BlockStmt();
        $blockRet.setLine($lb.getline());}
    NEWLINE+ (ss=singleStatement
                { $blockRet.addStatement($ss.singleRet);}
                 NEWLINE+)* RBRACE;

//todo
singleStatement returns [Statement singleRet]:
    i=ifStatement |
    { $singleRet = $i.ifRet; }
    p=printStatement |
    { $singleRet = $p.printRet;}
    m=methodCallStmt |
    { $singleRet = $m.methRet;}
    r=returnStatement |
    { $singleRet = $r.returnRet;}
    as=assignmentStatement |
    { $singleRet = $as.assignRet;}
    l=loopStatement |
    { $singleRet = $l.loopRet;}
    ad=addStatement |
    { $singleRet = $ad.addRet;}
    me=mergeStatement |
    { $singleRet = $me.mergeRet;}
    d=deleteStatement
    { $singleRet = $d.deleteRet;};

//todo
addStatement returns [SetAdd addRet]:
    exp=expression DOT add=ADD LPAR orexp=orExpression RPAR
    {
        $addRet = new SetAdd($exp.expRet, $orexp.orExprRet);
        $addRet.setLine($add.getline());
    };

//todo
mergeStatement returns [SetMerge mergeRet]:
    exp=expression DOT merge=MERGE LPAR orexp=orExpression
    {
        $expArgs = new ArrayList<>();
        $expArgs.add($orexp.orexpRet);
    }
    (COMMA orexp=orExpression { $expArgs.add($orexp.orExprRet); })*
    {
        $mergeRet = new SetMerge($exp.expRet, $expArgs);
        $mergeRet.setLine($merge.getline());
    } RPAR;

//todo
deleteStatement returns [SetDelete deleteRet]:
    exp=expression DOT delete=DELETE LPAR orexp=orExpression RPAR
    {
        $deleteRet = new SetDelete($exp.expRet, $orexp.orExprRet);
        $deleteRet.setLine($delete.getline());
    };

//todo
varDecStatement returns [ArrayList<VarDecleration> varDeclerationRet]:
    t=type name=identifier
    {
     $varDeclerationRet = new ArrayList<>();
     $varDeclerationRet.add(new VariableDeclaration($name.idRet, $t.typeRet));
    }
    (COMMA n=identifier { $varDeclerationRet.add(new VariableDeclaration($n.idRet, $t.typeRet));})*;

//todo
ifStatement returns [ConditionalStmt ifRet]:
    i=IF c=condition b=body
    {
        $ifRet = new ConditionalStmt($c.conditionRet, $b.statementRet);
        $ifRet.setLine($i.getline());
    }
    (ei=elsifStatement { $ifRet.addElsif($ei.elsifRet); })*
    (e=elseStatement { $ifRet.setElseBody($e.elseRet); })?;

//todo
elsifStatement returns [ElsifStmt elsifRet]:
     NEWLINE* el=ELSIF c=condition b=body
     {
        $elsifRet = new ElsifStmt($c.conditionRet, $b.statementRet);
        $elsifRet.setLine($el.getline());
      };

//todo
condition returns [Expression conditionRet] :
    (LPAR ex=expression {$conditionRet = $ex.expRet;} RPAR) | (ex=expression {$conditionRet = $ex.expRet;});

//todo
elseStatement returns [Statement elseRet]:
     NEWLINE* ELSE b=body {$elseRet = $b.statementRet;};

//todo
printStatement returns [PrintStmt printRet] :
    p=PRINT LPAR e=expression
    {
        $printRet = new PrintStmt($e.expRet);
        $printRet.setLine($p.getline());
    }
    RPAR;

//todo????
methodCallStmt returns [MethodCallStmt methRet]:
    ax=accessExpression  (DOT (INITIALIZE | identifier))*
    ((l=LPAR methodArgs RPAR) | ((op = INC | op = DEC)));

//todo
returnStatement returns [ReturnStmt returnRet]:
    RETURN (e=expression { $returnRet = $e.expRet; })?;

//todo
assignmentStatement returns [AssignmentStmt assignRet]:
    e=orExpression a=ASSIGN ex=expression
    {
        $assignRet = new AssignmentStmt($e.orExprRet, $ex.expRet);
        $assignRet.setLine($a.getline());
    };

//todo
loopStatement returns [EachStmt loopRet]:
    (
    { var list = new Expression(); }
    (ax=accessExpression { list = $ax.accessExprRet })
    | (
        l=LPAR el=expression DOT DOT er=expression RPAR
        { var rangeExpr = new RangeExpression($el.expRet, $er.expRet);
          rangeExpr.setLine($l.getline());
          list = rangeExpr;
        }
      )
    ) DOT each=EACH DO BAR name=identifier BAR
    b=body
    {
        $loopRet = new EachStmt($name.idRet, list);
        $loopRet.setBody($b.statementRet);
        $loopRet.setLine($each.getline());
     };

//todo
expression returns[Expression expRet]:
    tex=ternaryExpression {$expRet = $tex.ternaryExprRet;}
    (op=ASSIGN ex=expression{
        BinaryOperator opr = BinaryOperator.assign;
        $expRet = new BinaryExpression($expRet, $ex.expRet, opr);
        $expRet.setLine($op.getLine());
    })?;

//todo??
ternaryExpression returns [TernaryExpression ternaryExprRet]:
    oex=orExpression { $ternaryExprRet = $oex.orExpRet; }
    (q=TIF ttex=ternaryExpression TELSE ftex=ternaryExpression{
          TernaryOperator opr = TernaryOperator.ternary;
          $ternaryExprRet = new TernaryExpression($ternaryExprRet, $ttex.ternaryExprRet, $ftex.ternaryExprRet);
          $ternaryExprRet.setLine($q.getLine());
      }
    )?;

//todo
orExpression returns[Expression orExprRet]:
    expl = andExpression {$orExprRet = $expl.andExprRet;}
    (op = OR expr = andExpression{
        BinaryOperator opr = BinaryOperator.or;
        $orExprRet = new BinaryExpression($orExprRet, $expr.andExprRet, opr);
        $orExprRet.setLine($op.getLine());
    })*
    ;

//todo
andExpression returns[Expression andExprRet]:
    expl = equalityExpression {$andExprRet = $expl.equalityExprRet;}
    (op = AND expr = equalityExpression{
        BinaryOperator opr = BinaryOperator.and;
        $andExprRet = new BinaryExpression($andExprRet, $expr.equalityExprRet, opr);
        $andExprRet.setLine($op.getLine());
    })*;

//todo
equalityExpression returns[Expression equalityExprRet]:
    expl = relationalExpression {$equalityExprRet = $expl.relationalExprRet;}
    (op = EQUAL expr = relationalExpression{
        BinaryOperator opr = BinaryOperator.eq;
        $equalityExprRet = new BinaryExpression($equalityExprRet, $expr.relationalExprRet, opr);
        $equalityExprRet.setLine($op.getLine());
    })*;

//todo
relationalExpression returns [Expression relationalExprRet]
    locals [BinaryOperator op, int line]:
    l = additiveExpression
    {$relationalExprRet = $l.expr;}
    ((op1 = GREATER_THAN
    {$op = BinaryOperator.gt;
    $line = $op1.getLine();}
    | op2 = LESS_THAN
    {$op = BinaryOperator.lt;
     $line = $op2.getLine();}
    ) r = additiveExpression
    {$relationalExprRet = new BinaryExpression($relationalExprRet,$r.expr,$op);
     $relationalExprRet.setLine($line);}
    )*;

//todo
additiveExpression returns [Expression expr]
    locals [BinaryOperator op, int line]:
    l = multiplicativeExpression
    {$expr = $l.expr;}
    ((op1 = PLUS
    {$op = BinaryOperator.add;
     $line = $op1.getLine();}
    | op2 = MINUS
    {$op = BinaryOperator.sub;
     $line = $op2.getLine();}

    ) r = multiplicativeExpression
    {$expr = new BinaryExpression($expr,$r.expr,$op);
     $expr.setLine($line);}
    )*;

//todo
multiplicativeExpression returns [Expression expr]
    locals [BinaryOperator op, int line]:
    l = preUnaryExpression
    {$expr = $l.expr;}
    ((op1 = MULT
    {$op = BinaryOperator.mult;
     $line = $op1.getLine();}
    | op2 = DIVIDE
    {$op = BinaryOperator.div;
     $line = $op2.getLine();}
    ) r = preUnaryExpression
    {$expr = new BinaryExpression($expr,$r.expr,$op);
    $expr.setLine($line);}
    )*;

//todo
preUnaryExpression returns [Expression expr]
    locals[UnaryOperator op, int line]:
    ((op1 = NOT
    {$op = UnaryOperator.not;
     $line = $op1.getLine();}
    | op2 = MINUS
    {$op = UnaryOperator.minus;
     $line = $op2.getLine();}
    ) pre = preUnaryExpression
    {$expr = new UnaryExpression($pre.expr, $op);
     $expr.setLine($line);}
    ) | post = postUnaryExpression
    {$expr = $post.expr;}
    ;

//todo
postUnaryExpression returns[Expression postUnaryExprRet]:
    ae=accessExpression { $postUnaryExprRet = $ae.accessExprRet; }
    (
    (postinc=INC
    {
        UnaryOperator op = UnaryOperator.postinc;
        $postUnaryExprRet = new UnaryExpression($postUnaryExprRet, op);
        $postUnaryExprRet.setLine($postinc.getLine());
    }
    | postdec=DEC
    {
        UnaryOperator op = UnaryOperator.postdec;
        $postUnaryExprRet = new UnaryExpression($postUnaryExprRet, op);
        $postUnaryExprRet.setLine($postdec.getLine());
    }
    )
    )?;

//todo???
accessExpression returns[Expression accessExprRet]:
    oe=otherExpression { $accessExprRet = $oe.otherExprRet; }
    (
    (l=LPAR m=methodArgs
    {
        $accessExprRet = new MethodCall($accessExprRet, $m.methodCallArgsRet);
        $accessExprRet.setLine($l.line);
    }
    RPAR)
    | (DOT (name=identifier
            {
                $accessExprRet = new ObjectMemberAccess($accessExprRet, $name);
                $accessExprRet.setLine($name.getline());
            }
        | n=NEW
            {
                $accessExprRet = new ObjectMemberAccess($accessExprRet, new Identifier($n));
                $accessExprRet.setLine($n.line);
            }
        | i=INITIALIZE
            {
                $accessExprRet = new ObjectMemberAccess($accessExprRet, new Identifier($i));
                $accessExprRet.setLine($i.line);
            }
       ))
    )*
    (
    (DOT (name=identifier
            {
                $accessExprRet = new ObjectMemberAccess($accessExprRet, $name);
                $accessExprRet.setLine($name.getline());
            }
         ))
    | (l=LBRACK index=expression RBRACK
            {
                $accessExprRet = new ArrayAccessByIndex($accessExprRet, $index.exprRet);
                $accessExprRet.setLine($l.getLine());
            }
        )
    )*;

//todo
otherExpression returns [Expression otherExprRet]:
    cid=class_identifier
    { $otherExprRet = $cid.idRet; }
    | v=value
    { $otherExprRet = $v.valuesRet; }
    | id=identifier
    { $otherExprRet = $id.idRet; }
    | LPAR m=methodArgs RPAR //todo
    { $otherExprRet = $m.methodCallArgsRet; }
    | sn=setNew
    { $otherExprRet = $sn.setNewRet; }
    | si=setInclude
    { $otherExprRet = $si.setIncludeRet; }
    | ai=accessByIndex
    { $otherExprRet = $ai.accessByIndexRet; };

//todo??
accessByIndex returns [Expression accessByIndexRet]:
    name=identifier LBRACK ex=expression RBRACK;

//todo
setNew returns [SetNew setNewRet]:
    { var args = new ArrayList<>();}
    SET DOT n=NEW LPAR (LPAR oe=orExpression { args.add($oe.orExprRet);}
                       (COMMA oex=orExpression { args.add($oex.orExprRet);})* RPAR)?
               {
                $setNewRet = new SetNew(args);
                $setNewRet.setLine($n.getline());
               }
               RPAR;

//todo??
setInclude returns [SetInclude setIncludeRet]:
    name=identifier DOT INCLUDE LPAR orExpression RPAR;

//todo
value returns[Value valuesRet]:
    b=boolValue
    {
        $valuesRet = new BoolValue($b.boolValueRet);
        $valuesRet.setLine($b.line);
    }
    | i=INT_VALUE
    {
        $valuesRet = new IntValue($i.int);
        $valuesRet.setLine($i.getLine());
    }
    ;

//todo
boolValue returns[boolean boolValueRet, int line]:
    t=TRUE
    {
        $boolValueRet = true;
        $line = $t.getLine();
    }
    | f=FALSE
    {
        $boolValueRet = false;
        $line = $f.getLine();
    }
    ;

//todo
class_identifier returns[Identifier idRet, int line]:
    cid=CLASS_IDENTIFIER
    {
        $idRet = new Identifier($id.text);
        $idRet.setLine($id.getLine());
        $line = $id.getLine();
    }
    ;

//todo
identifier returns[Identifier idRet, int line]:
    id=IDENTIFIER
    {
        $idRet = new Identifier($id.text);
        $idRet.setLine($id.getLine());
        $line = $id.getLine();
    }
    ;

//todo
type returns [Type typeRet]:
    INT
    { $typeRet = new IntType(); }
    | BOOL
    { $typeRet = new BoolType(); }
    | arr=array_type
    { $typeRet = $arr.arrTypeRet; }
    | f=fptr_type
    { $typeRet = $f.fptrTypeRet; }
    | s=set_type
    { $typeRet = $s.setTypeRet; }
    | cid=class_identifier
    { $typeRet = $cid.idRet; }
    ;

//todo CHECK VOID TYPE IN METHOD CALL
array_type returns [ArrayType arrTypeRet]
    locals[Type t, ArrayList<Expression> dims]:
    { dims = new ArrayList<>(); }
    (INT { $t = new IntType(); }
    | BOOL { $t = new BoolType(); }
    | cid=class_identifier { $t = $cid.idRet; })
    (LBRACK ex=expression RBRACK { dims.add($ex.expRet); })+;

//todo
fptr_type returns[FptrType fptrTypeRet]:
    { ArrayList<Type> args = new ArrayList<>(); }
    FPTR LESS_THAN (VOID
    | (t1 = type { args.add($t1.typeRet); } (COMMA t2 = type { args.add($t2.typeRet); })* ))

    ARROW (t3 = type {$fptrTypeRet = new FptrType(args, $t3.typeRet);}
    | VOID {$fptrTypeRet = new FptrType(args, new VoidType());}) GREATER_THAN;

//todo
set_type returns [SetType setTypeRet]:
    SET LESS_THAN (INT) GREATER_THAN { $setTypeRet = new SetType(); };


LINE_BREAK: ('//\n') -> skip;

CLASS: 'class';
PUBLIC: 'public';
PRIVATE: 'private';
INITIALIZE: 'initialize';
NEW: 'new';
SELF: 'self';


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
SEMICOLON: ';' -> skip;
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-z_][A-Za-z0-9_]*;
CLASS_IDENTIFIER: [A-Z][A-Za-z0-9_]*;

COMMENT: '#' .*? '\n' -> skip;
MLCOMMENT: ('=begin' .*? '=end') -> skip;
WS: ([ \t\r]) -> skip;
