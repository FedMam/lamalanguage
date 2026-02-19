// Generated from parser/LamaLanguage.g4 by ANTLR 4.13.2
package com.oracle.truffle.lama.parser;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import com.oracle.truffle.lama.error.LamaParsingException;

/**
 * This class provides an empty implementation of {@link LamaLanguageVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class LamaLanguageBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements LamaLanguageVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLamaLanguage(LamaLanguageParser.LamaLanguageContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitScopeExp(LamaLanguageParser.ScopeExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOneVarDef(LamaLanguageParser.OneVarDefContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVarDefinition(LamaLanguageParser.VarDefinitionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFunDefinition(LamaLanguageParser.FunDefinitionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLidentList0(LamaLanguageParser.LidentList0Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpList0(LamaLanguageParser.ExpList0Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpList(LamaLanguageParser.ExpListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSingleExp(LamaLanguageParser.SingleExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSeqExp(LamaLanguageParser.SeqExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLetExp(LamaLanguageParser.LetExpContext ctx) { return visitChildren(ctx); }
	
	// Added for convenience
	public T visitExp(LamaLanguageParser.ExpContext ctx) {
		if (ctx instanceof LamaLanguageParser.SingleExpContext sctx)
			return visitSingleExp(sctx);
		else if (ctx instanceof LamaLanguageParser.SeqExpContext sctx)
			return visitSeqExp(sctx);
		else if (ctx instanceof LamaLanguageParser.LetExpContext sctx)
			return visitLetExp(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBasicExp(LamaLanguageParser.BasicExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitConsExp(LamaLanguageParser.ConsExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAssignmentExp(LamaLanguageParser.AssignmentExpContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasic(LamaLanguageParser.BasicContext ctx) {
		if (ctx instanceof LamaLanguageParser.BasicExpContext sctx)
			return visitBasicExp(sctx);
		else if (ctx instanceof LamaLanguageParser.ConsExpContext sctx)
			return visitConsExp(sctx);
		else if (ctx instanceof LamaLanguageParser.AssignmentExpContext sctx)
			return visitAssignmentExp(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBasicCons(LamaLanguageParser.BasicConsContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpOr(LamaLanguageParser.OpOrContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuasiOr(LamaLanguageParser.QuasiOrContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasicOr(LamaLanguageParser.BasicOrContext ctx) {
		if (ctx instanceof LamaLanguageParser.QuasiOrContext sctx)
			return visitQuasiOr(sctx);
		else if (ctx instanceof LamaLanguageParser.OpOrContext sctx)
			return visitOpOr(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuasiAnd(LamaLanguageParser.QuasiAndContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpAnd(LamaLanguageParser.OpAndContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasicAnd(LamaLanguageParser.BasicAndContext ctx) {
		if (ctx instanceof LamaLanguageParser.QuasiAndContext sctx)
			return visitQuasiAnd(sctx);
		else if (ctx instanceof LamaLanguageParser.OpAndContext sctx)
			return visitOpAnd(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuasiCmp(LamaLanguageParser.QuasiCmpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpCmp(LamaLanguageParser.OpCmpContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasicCmp(LamaLanguageParser.BasicCmpContext ctx) {
		if (ctx instanceof LamaLanguageParser.QuasiCmpContext sctx)
			return visitQuasiCmp(sctx);
		else if (ctx instanceof LamaLanguageParser.OpCmpContext sctx)
			return visitOpCmp(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuasiAdd(LamaLanguageParser.QuasiAddContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpAdd(LamaLanguageParser.OpAddContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasicAdd(LamaLanguageParser.BasicAddContext ctx) {
		if (ctx instanceof LamaLanguageParser.QuasiAddContext sctx)
			return visitQuasiAdd(sctx);
		else if (ctx instanceof LamaLanguageParser.OpAddContext sctx)
			return visitOpAdd(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuasiMul(LamaLanguageParser.QuasiMulContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpMul(LamaLanguageParser.OpMulContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasicMul(LamaLanguageParser.BasicMulContext ctx) {
		if (ctx instanceof LamaLanguageParser.QuasiMulContext sctx)
			return visitQuasiMul(sctx);
		else if (ctx instanceof LamaLanguageParser.OpMulContext sctx)
			return visitOpMul(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQuasiUnary(LamaLanguageParser.QuasiUnaryContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpUnary(LamaLanguageParser.OpUnaryContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitBasicUnary(LamaLanguageParser.BasicUnaryContext ctx) {
		if (ctx instanceof LamaLanguageParser.QuasiUnaryContext sctx)
			return visitQuasiUnary(sctx);
		else if (ctx instanceof LamaLanguageParser.OpUnaryContext sctx)
			return visitOpUnary(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCall(LamaLanguageParser.CallContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDotNotationCall(LamaLanguageParser.DotNotationCallContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrimaryExp(LamaLanguageParser.PrimaryExpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIndexRef(LamaLanguageParser.IndexRefContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitPostfix(LamaLanguageParser.PostfixContext ctx) {
		if (ctx instanceof LamaLanguageParser.PrimaryExpContext sctx)
			return visitPrimaryExp(sctx);
		else if (ctx instanceof LamaLanguageParser.IndexRefContext sctx)
			return visitIndexRef(sctx);
		else if (ctx instanceof LamaLanguageParser.CallContext sctx)
			return visitCall(sctx);
		else if (ctx instanceof LamaLanguageParser.DotNotationCallContext sctx)
			return visitDotNotationCall(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrimary(LamaLanguageParser.PrimaryContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSexp(LamaLanguageParser.SexpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitArray(LamaLanguageParser.ArrayContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitList(LamaLanguageParser.ListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLiteral(LamaLanguageParser.LiteralContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStrlit(LamaLanguageParser.StrlitContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChrlit(LamaLanguageParser.ChrlitContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIntlit(LamaLanguageParser.IntlitContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBlit(LamaLanguageParser.BlitContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParentheses(LamaLanguageParser.ParenthesesContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNop(LamaLanguageParser.NopContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWhileLoop(LamaLanguageParser.WhileLoopContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDoWhileLoop(LamaLanguageParser.DoWhileLoopContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitForLoop(LamaLanguageParser.ForLoopContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIfStmt(LamaLanguageParser.IfStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCaseStmt(LamaLanguageParser.CaseStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCaseOption(LamaLanguageParser.CaseOptionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLambda(LamaLanguageParser.LambdaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSimplePattern(LamaLanguageParser.SimplePatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitConsPattern(LamaLanguageParser.ConsPatternContext ctx) { return visitChildren(ctx); }
	
	// added for convenience
	public T visitPattern(LamaLanguageParser.PatternContext ctx) {
		if (ctx instanceof LamaLanguageParser.SimplePatternContext sctx)
			return visitSimplePattern(sctx);
		else if (ctx instanceof LamaLanguageParser.ConsPatternContext sctx)
			return visitConsPattern(sctx);
		throw new LamaParsingException((ctx != null ? ctx.getClass().getSimpleName() : "null") + " is of an invalid type", ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNonConsPattern(LamaLanguageParser.NonConsPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPatternList0(LamaLanguageParser.PatternList0Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPatternList(LamaLanguageParser.PatternListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParenthesesPattern(LamaLanguageParser.ParenthesesPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLiteralPattern(LamaLanguageParser.LiteralPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLidentPattern(LamaLanguageParser.LidentPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAliasPattern(LamaLanguageParser.AliasPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSexpPattern(LamaLanguageParser.SexpPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitArrayPattern(LamaLanguageParser.ArrayPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitListPattern(LamaLanguageParser.ListPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAssertFunPattern(LamaLanguageParser.AssertFunPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAssertValPattern(LamaLanguageParser.AssertValPatternContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAssertStrPattern(LamaLanguageParser.AssertStrPatternContext ctx) { return visitChildren(ctx); }
}