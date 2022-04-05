// Generated from E:/UT/S6/TA/Compiler/Joey-Compiler/src/main/grammar\Thomas.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ThomasParser}.
 */
public interface ThomasListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ThomasParser#thomas}.
	 * @param ctx the parse tree
	 */
	void enterThomas(ThomasParser.ThomasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#thomas}.
	 * @param ctx the parse tree
	 */
	void exitThomas(ThomasParser.ThomasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ThomasParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ThomasParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(ThomasParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(ThomasParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ThomasParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ThomasParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#field_decleration}.
	 * @param ctx the parse tree
	 */
	void enterField_decleration(ThomasParser.Field_declerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#field_decleration}.
	 * @param ctx the parse tree
	 */
	void exitField_decleration(ThomasParser.Field_declerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(ThomasParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(ThomasParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#methodArgsDec}.
	 * @param ctx the parse tree
	 */
	void enterMethodArgsDec(ThomasParser.MethodArgsDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#methodArgsDec}.
	 * @param ctx the parse tree
	 */
	void exitMethodArgsDec(ThomasParser.MethodArgsDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#argDec}.
	 * @param ctx the parse tree
	 */
	void enterArgDec(ThomasParser.ArgDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#argDec}.
	 * @param ctx the parse tree
	 */
	void exitArgDec(ThomasParser.ArgDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#methodArgs}.
	 * @param ctx the parse tree
	 */
	void enterMethodArgs(ThomasParser.MethodArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#methodArgs}.
	 * @param ctx the parse tree
	 */
	void exitMethodArgs(ThomasParser.MethodArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ThomasParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ThomasParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(ThomasParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(ThomasParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(ThomasParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(ThomasParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#addStatement}.
	 * @param ctx the parse tree
	 */
	void enterAddStatement(ThomasParser.AddStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#addStatement}.
	 * @param ctx the parse tree
	 */
	void exitAddStatement(ThomasParser.AddStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#mergeStatement}.
	 * @param ctx the parse tree
	 */
	void enterMergeStatement(ThomasParser.MergeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#mergeStatement}.
	 * @param ctx the parse tree
	 */
	void exitMergeStatement(ThomasParser.MergeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(ThomasParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(ThomasParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#varDecStatement}.
	 * @param ctx the parse tree
	 */
	void enterVarDecStatement(ThomasParser.VarDecStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#varDecStatement}.
	 * @param ctx the parse tree
	 */
	void exitVarDecStatement(ThomasParser.VarDecStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ThomasParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ThomasParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#elsifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElsifStatement(ThomasParser.ElsifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#elsifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElsifStatement(ThomasParser.ElsifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(ThomasParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(ThomasParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(ThomasParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(ThomasParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#methodCallStmt}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallStmt(ThomasParser.MethodCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#methodCallStmt}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallStmt(ThomasParser.MethodCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ThomasParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ThomasParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(ThomasParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(ThomasParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(ThomasParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(ThomasParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ThomasParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ThomasParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#ternaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(ThomasParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#ternaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(ThomasParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(ThomasParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(ThomasParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(ThomasParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(ThomasParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ThomasParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ThomasParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(ThomasParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(ThomasParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(ThomasParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(ThomasParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(ThomasParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(ThomasParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreUnaryExpression(ThomasParser.PreUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#preUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreUnaryExpression(ThomasParser.PreUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#postUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostUnaryExpression(ThomasParser.PostUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#postUnaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostUnaryExpression(ThomasParser.PostUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void enterAccessExpression(ThomasParser.AccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#accessExpression}.
	 * @param ctx the parse tree
	 */
	void exitAccessExpression(ThomasParser.AccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void enterOtherExpression(ThomasParser.OtherExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#otherExpression}.
	 * @param ctx the parse tree
	 */
	void exitOtherExpression(ThomasParser.OtherExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#accessByIndex}.
	 * @param ctx the parse tree
	 */
	void enterAccessByIndex(ThomasParser.AccessByIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#accessByIndex}.
	 * @param ctx the parse tree
	 */
	void exitAccessByIndex(ThomasParser.AccessByIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#setNew}.
	 * @param ctx the parse tree
	 */
	void enterSetNew(ThomasParser.SetNewContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#setNew}.
	 * @param ctx the parse tree
	 */
	void exitSetNew(ThomasParser.SetNewContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#setInclude}.
	 * @param ctx the parse tree
	 */
	void enterSetInclude(ThomasParser.SetIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#setInclude}.
	 * @param ctx the parse tree
	 */
	void exitSetInclude(ThomasParser.SetIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ThomasParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ThomasParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(ThomasParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#boolValue}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(ThomasParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#class_identifier}.
	 * @param ctx the parse tree
	 */
	void enterClass_identifier(ThomasParser.Class_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#class_identifier}.
	 * @param ctx the parse tree
	 */
	void exitClass_identifier(ThomasParser.Class_identifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ThomasParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ThomasParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ThomasParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ThomasParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#array_type}.
	 * @param ctx the parse tree
	 */
	void enterArray_type(ThomasParser.Array_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#array_type}.
	 * @param ctx the parse tree
	 */
	void exitArray_type(ThomasParser.Array_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#fptr_type}.
	 * @param ctx the parse tree
	 */
	void enterFptr_type(ThomasParser.Fptr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#fptr_type}.
	 * @param ctx the parse tree
	 */
	void exitFptr_type(ThomasParser.Fptr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThomasParser#set_type}.
	 * @param ctx the parse tree
	 */
	void enterSet_type(ThomasParser.Set_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThomasParser#set_type}.
	 * @param ctx the parse tree
	 */
	void exitSet_type(ThomasParser.Set_typeContext ctx);
}