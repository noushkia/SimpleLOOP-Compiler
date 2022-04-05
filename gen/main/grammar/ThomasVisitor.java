// Generated from E:/UT/S6/TA/Compiler/Joey-Compiler/src/main/grammar\Thomas.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ThomasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ThomasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ThomasParser#thomas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThomas(ThomasParser.ThomasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ThomasParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(ThomasParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ThomasParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#field_decleration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decleration(ThomasParser.Field_declerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(ThomasParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#methodArgsDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodArgsDec(ThomasParser.MethodArgsDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#argDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgDec(ThomasParser.ArgDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#methodArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodArgs(ThomasParser.MethodArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ThomasParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(ThomasParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#singleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatement(ThomasParser.SingleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#addStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddStatement(ThomasParser.AddStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#mergeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMergeStatement(ThomasParser.MergeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(ThomasParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#varDecStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecStatement(ThomasParser.VarDecStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ThomasParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#elsifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsifStatement(ThomasParser.ElsifStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(ThomasParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(ThomasParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#methodCallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallStmt(ThomasParser.MethodCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ThomasParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(ThomasParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(ThomasParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ThomasParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#ternaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(ThomasParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(ThomasParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(ThomasParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(ThomasParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(ThomasParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ThomasParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(ThomasParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreUnaryExpression(ThomasParser.PreUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#postUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostUnaryExpression(ThomasParser.PostUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#accessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessExpression(ThomasParser.AccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#otherExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherExpression(ThomasParser.OtherExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#accessByIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessByIndex(ThomasParser.AccessByIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#setNew}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetNew(ThomasParser.SetNewContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#setInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetInclude(ThomasParser.SetIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ThomasParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#boolValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(ThomasParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#class_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_identifier(ThomasParser.Class_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ThomasParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ThomasParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type(ThomasParser.Array_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#fptr_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFptr_type(ThomasParser.Fptr_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThomasParser#set_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_type(ThomasParser.Set_typeContext ctx);
}