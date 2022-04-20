// Generated from C:/Users/amirp/Desktop/Files/University/Term 7/Compiler-TA/SimpleLOOP-Phases/Phase 4/SimpleLOOP-Phase4/src/main/grammar\SimpleLOOP.g4 by ANTLR 4.8
package parsers;

    import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLOOPParser}.
 */
public interface SimpleLOOPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#simpleLOOP}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLOOP(SimpleLOOPParser.SimpleLOOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#simpleLOOP}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLOOP(SimpleLOOPParser.SimpleLOOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleLOOPParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleLOOPParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#simpleLOOPClass}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLOOPClass(SimpleLOOPParser.SimpleLOOPClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#simpleLOOPClass}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLOOPClass(SimpleLOOPParser.SimpleLOOPClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(SimpleLOOPParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(SimpleLOOPParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(SimpleLOOPParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(SimpleLOOPParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(SimpleLOOPParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(SimpleLOOPParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodArguments}.
	 * @param ctx the parse tree
	 */
	void enterMethodArguments(SimpleLOOPParser.MethodArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodArguments}.
	 * @param ctx the parse tree
	 */
	void exitMethodArguments(SimpleLOOPParser.MethodArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#variableWithType}.
	 * @param ctx the parse tree
	 */
	void enterVariableWithType(SimpleLOOPParser.VariableWithTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#variableWithType}.
	 * @param ctx the parse tree
	 */
	void exitVariableWithType(SimpleLOOPParser.VariableWithTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleLOOPParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleLOOPParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(SimpleLOOPParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(SimpleLOOPParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#listType}.
	 * @param ctx the parse tree
	 */
	void enterListType(SimpleLOOPParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#listType}.
	 * @param ctx the parse tree
	 */
	void exitListType(SimpleLOOPParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#listItemsTypes}.
	 * @param ctx the parse tree
	 */
	void enterListItemsTypes(SimpleLOOPParser.ListItemsTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#listItemsTypes}.
	 * @param ctx the parse tree
	 */
	void exitListItemsTypes(SimpleLOOPParser.ListItemsTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#listItemType}.
	 * @param ctx the parse tree
	 */
	void enterListItemType(SimpleLOOPParser.ListItemTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#listItemType}.
	 * @param ctx the parse tree
	 */
	void exitListItemType(SimpleLOOPParser.ListItemTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#functionPointerType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPointerType(SimpleLOOPParser.FunctionPointerTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#functionPointerType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPointerType(SimpleLOOPParser.FunctionPointerTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#typesWithComma}.
	 * @param ctx the parse tree
	 */
	void enterTypesWithComma(SimpleLOOPParser.TypesWithCommaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#typesWithComma}.
	 * @param ctx the parse tree
	 */
	void exitTypesWithComma(SimpleLOOPParser.TypesWithCommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#primitiveDataType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDataType(SimpleLOOPParser.PrimitiveDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#primitiveDataType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDataType(SimpleLOOPParser.PrimitiveDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(SimpleLOOPParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(SimpleLOOPParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleLOOPParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleLOOPParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleLOOPParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleLOOPParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(SimpleLOOPParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(SimpleLOOPParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleLOOPParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleLOOPParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(SimpleLOOPParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(SimpleLOOPParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SimpleLOOPParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SimpleLOOPParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallStatement(SimpleLOOPParser.MethodCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallStatement(SimpleLOOPParser.MethodCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(SimpleLOOPParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(SimpleLOOPParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#methodCallArguments}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallArguments(SimpleLOOPParser.MethodCallArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#methodCallArguments}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallArguments(SimpleLOOPParser.MethodCallArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#continueBreakStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueBreakStatement(SimpleLOOPParser.ContinueBreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#continueBreakStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueBreakStatement(SimpleLOOPParser.ContinueBreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(SimpleLOOPParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(SimpleLOOPParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForeachStatement(SimpleLOOPParser.ForeachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForeachStatement(SimpleLOOPParser.ForeachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleLOOPParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleLOOPParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleLOOPParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleLOOPParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(SimpleLOOPParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(SimpleLOOPParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(SimpleLOOPParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(SimpleLOOPParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(SimpleLOOPParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(SimpleLOOPParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(SimpleLOOPParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(SimpleLOOPParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(SimpleLOOPParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(SimpleLOOPParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(SimpleLOOPParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(SimpleLOOPParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreUnaryExpression(SimpleLOOPParser.PreUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreUnaryExpression(SimpleLOOPParser.PreUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#postUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostUnaryExpression(SimpleLOOPParser.PostUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#postUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostUnaryExpression(SimpleLOOPParser.PostUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void enterAccessExpression(SimpleLOOPParser.AccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void exitAccessExpression(SimpleLOOPParser.AccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void enterOtherExpression(SimpleLOOPParser.OtherExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void exitOtherExpression(SimpleLOOPParser.OtherExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(SimpleLOOPParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(SimpleLOOPParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(SimpleLOOPParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(SimpleLOOPParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(SimpleLOOPParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(SimpleLOOPParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#listValue}.
	 * @param ctx the parse tree
	 */
	void enterListValue(SimpleLOOPParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#listValue}.
	 * @param ctx the parse tree
	 */
	void exitListValue(SimpleLOOPParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLOOPParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SimpleLOOPParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLOOPParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SimpleLOOPParser.IdentifierContext ctx);
}