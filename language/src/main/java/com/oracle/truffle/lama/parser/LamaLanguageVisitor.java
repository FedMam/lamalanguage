// Generated from parser/LamaLanguage.g4 by ANTLR 4.13.2
package com.oracle.truffle.lama.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LamaLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LamaLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#lamaLanguage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLamaLanguage(LamaLanguageParser.LamaLanguageContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#scopeExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeExp(LamaLanguageParser.ScopeExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#oneVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneVarDef(LamaLanguageParser.OneVarDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDefinition}
	 * labeled alternative in {@link LamaLanguageParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefinition(LamaLanguageParser.VarDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunDefinition}
	 * labeled alternative in {@link LamaLanguageParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDefinition(LamaLanguageParser.FunDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#lidentList0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLidentList0(LamaLanguageParser.LidentList0Context ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#expList0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpList0(LamaLanguageParser.ExpList0Context ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#expList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpList(LamaLanguageParser.ExpListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleExp}
	 * labeled alternative in {@link LamaLanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExp(LamaLanguageParser.SingleExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SeqExp}
	 * labeled alternative in {@link LamaLanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqExp(LamaLanguageParser.SeqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetExp}
	 * labeled alternative in {@link LamaLanguageParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExp(LamaLanguageParser.LetExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BasicExp}
	 * labeled alternative in {@link LamaLanguageParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExp(LamaLanguageParser.BasicExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConsExp}
	 * labeled alternative in {@link LamaLanguageParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsExp(LamaLanguageParser.ConsExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExp}
	 * labeled alternative in {@link LamaLanguageParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExp(LamaLanguageParser.AssignmentExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#basicCons}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicCons(LamaLanguageParser.BasicConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpOr}
	 * labeled alternative in {@link LamaLanguageParser#basicOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpOr(LamaLanguageParser.OpOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuasiOr}
	 * labeled alternative in {@link LamaLanguageParser#basicOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuasiOr(LamaLanguageParser.QuasiOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuasiAnd}
	 * labeled alternative in {@link LamaLanguageParser#basicAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuasiAnd(LamaLanguageParser.QuasiAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpAnd}
	 * labeled alternative in {@link LamaLanguageParser#basicAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpAnd(LamaLanguageParser.OpAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuasiCmp}
	 * labeled alternative in {@link LamaLanguageParser#basicCmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuasiCmp(LamaLanguageParser.QuasiCmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpCmp}
	 * labeled alternative in {@link LamaLanguageParser#basicCmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpCmp(LamaLanguageParser.OpCmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuasiAdd}
	 * labeled alternative in {@link LamaLanguageParser#basicAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuasiAdd(LamaLanguageParser.QuasiAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpAdd}
	 * labeled alternative in {@link LamaLanguageParser#basicAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpAdd(LamaLanguageParser.OpAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuasiMul}
	 * labeled alternative in {@link LamaLanguageParser#basicMul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuasiMul(LamaLanguageParser.QuasiMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpMul}
	 * labeled alternative in {@link LamaLanguageParser#basicMul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpMul(LamaLanguageParser.OpMulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QuasiUnary}
	 * labeled alternative in {@link LamaLanguageParser#basicUnary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuasiUnary(LamaLanguageParser.QuasiUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OpUnary}
	 * labeled alternative in {@link LamaLanguageParser#basicUnary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpUnary(LamaLanguageParser.OpUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LamaLanguageParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(LamaLanguageParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotNotationCall}
	 * labeled alternative in {@link LamaLanguageParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotNotationCall(LamaLanguageParser.DotNotationCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExp}
	 * labeled alternative in {@link LamaLanguageParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(LamaLanguageParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexRef}
	 * labeled alternative in {@link LamaLanguageParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexRef(LamaLanguageParser.IndexRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(LamaLanguageParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSexp(LamaLanguageParser.SexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(LamaLanguageParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LamaLanguageParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LamaLanguageParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#strlit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrlit(LamaLanguageParser.StrlitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#chrlit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChrlit(LamaLanguageParser.ChrlitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#intlit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntlit(LamaLanguageParser.IntlitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#blit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlit(LamaLanguageParser.BlitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#parentheses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(LamaLanguageParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#nop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNop(LamaLanguageParser.NopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(LamaLanguageParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#doWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileLoop(LamaLanguageParser.DoWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(LamaLanguageParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(LamaLanguageParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#caseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStmt(LamaLanguageParser.CaseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#caseOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseOption(LamaLanguageParser.CaseOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(LamaLanguageParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimplePattern}
	 * labeled alternative in {@link LamaLanguageParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplePattern(LamaLanguageParser.SimplePatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConsPattern}
	 * labeled alternative in {@link LamaLanguageParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsPattern(LamaLanguageParser.ConsPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#nonConsPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonConsPattern(LamaLanguageParser.NonConsPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#patternList0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternList0(LamaLanguageParser.PatternList0Context ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#patternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternList(LamaLanguageParser.PatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#parenthesesPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesPattern(LamaLanguageParser.ParenthesesPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#literalPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralPattern(LamaLanguageParser.LiteralPatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LidentPattern}
	 * labeled alternative in {@link LamaLanguageParser#varPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLidentPattern(LamaLanguageParser.LidentPatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AliasPattern}
	 * labeled alternative in {@link LamaLanguageParser#varPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasPattern(LamaLanguageParser.AliasPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#sexpPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSexpPattern(LamaLanguageParser.SexpPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#arrayPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayPattern(LamaLanguageParser.ArrayPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#listPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListPattern(LamaLanguageParser.ListPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#assertFunPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertFunPattern(LamaLanguageParser.AssertFunPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#assertValPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertValPattern(LamaLanguageParser.AssertValPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link LamaLanguageParser#assertStrPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStrPattern(LamaLanguageParser.AssertStrPatternContext ctx);
}