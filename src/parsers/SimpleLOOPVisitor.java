// Generated from C:/Users/amirp/Desktop/Files/University/Term 7/Compiler-TA/SimpleLOOP-Phases/Phase 4/SimpleLOOP-Phase4/src/main/grammar\SimpleLOOP.g4 by ANTLR 4.8
package parsers;

    import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLOOPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLOOPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#simpleLOOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLOOP(SimpleLOOPParser.SimpleLOOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleLOOPParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#simpleLOOPClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLOOPClass(SimpleLOOPParser.SimpleLOOPClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(SimpleLOOPParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(SimpleLOOPParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(SimpleLOOPParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodArguments(SimpleLOOPParser.MethodArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#variableWithType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableWithType(SimpleLOOPParser.VariableWithTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpleLOOPParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(SimpleLOOPParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(SimpleLOOPParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#listItemsTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemsTypes(SimpleLOOPParser.ListItemsTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#listItemType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItemType(SimpleLOOPParser.ListItemTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#functionPointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPointerType(SimpleLOOPParser.FunctionPointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#typesWithComma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypesWithComma(SimpleLOOPParser.TypesWithCommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#primitiveDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveDataType(SimpleLOOPParser.PrimitiveDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(SimpleLOOPParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleLOOPParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleLOOPParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(SimpleLOOPParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SimpleLOOPParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(SimpleLOOPParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SimpleLOOPParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallStatement(SimpleLOOPParser.MethodCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(SimpleLOOPParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#methodCallArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallArguments(SimpleLOOPParser.MethodCallArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#continueBreakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueBreakStatement(SimpleLOOPParser.ContinueBreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(SimpleLOOPParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#foreachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachStatement(SimpleLOOPParser.ForeachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SimpleLOOPParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleLOOPParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(SimpleLOOPParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(SimpleLOOPParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(SimpleLOOPParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(SimpleLOOPParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(SimpleLOOPParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(SimpleLOOPParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreUnaryExpression(SimpleLOOPParser.PreUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#postUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostUnaryExpression(SimpleLOOPParser.PostUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#accessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessExpression(SimpleLOOPParser.AccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#otherExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherExpression(SimpleLOOPParser.OtherExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(SimpleLOOPParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(SimpleLOOPParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#boolValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(SimpleLOOPParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#listValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(SimpleLOOPParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLOOPParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SimpleLOOPParser.IdentifierContext ctx);
}