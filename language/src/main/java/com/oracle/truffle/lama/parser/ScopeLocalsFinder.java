package com.oracle.truffle.lama.parser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.oracle.truffle.lama.error.LamaParsingException;

// This visitor finds all local variable names that were NOT defined in that scope
// Used for closures
public class ScopeLocalsFinder extends LamaLanguageBaseVisitor<Void> {
    private final Set<String> definedNames = new HashSet<>();
    private final Set<String> notDefinedNames = new HashSet<>();

    public ScopeLocalsFinder() { }

    public ScopeLocalsFinder(Collection<String> globalAndArgNames) {
        definedNames.addAll(globalAndArgNames);
    }

    @Override
    public Void visitTerminal(TerminalNode node) {
        return null;
    }

    private ScopeLocalsFinder createInnerScopeVisitor(Collection<String> extraDefinitions) {
        Set<String> allDefinitions = new HashSet<>();
        allDefinitions.addAll(extraDefinitions);
        allDefinitions.addAll(definedNames);
        ScopeLocalsFinder finder = new ScopeLocalsFinder(allDefinitions);
        return finder;
    }

    private void merge(ScopeLocalsFinder finder) {
        notDefinedNames.addAll(finder.getNotDefinedNames());
    }

    @Override
    public Void visitScopeExp(LamaLanguageParser.ScopeExpContext ctx) {
        if (ctx.definition().isEmpty())
            return visitExp(ctx.body);

        Set<String> allDefinitions = new HashSet<>();
        for (var defCtx: ctx.definition()) {
            if (defCtx instanceof LamaLanguageParser.VarDefinitionContext varDefCtx) {
                allDefinitions.addAll(varDefCtx.oneVarDef()
                    .stream()
                    .map(oneVarDefCtx -> oneVarDefCtx.name.getText())
                    .collect(Collectors.toSet()));
            } else if (defCtx instanceof LamaLanguageParser.FunDefinitionContext funDefCtx) {
                allDefinitions.add(funDefCtx.name.getText());
                visitFunDefinition(funDefCtx);
            }
        }

        var finder = createInnerScopeVisitor(allDefinitions);
        finder.visitExp(ctx.body);
        merge(finder);

        return null;
    }

    @Override
    public Void visitOneVarDef(LamaLanguageParser.OneVarDefContext ctx) {
        definedNames.add(ctx.name.getText());
        return null;
    }

    @Override
    public Void visitFunDefinition(LamaLanguageParser.FunDefinitionContext ctx) {
        definedNames.add(ctx.name.getText());

        ScopeLocalsFinder finder = createInnerScopeVisitor(ctx.args.LIDENT()
            .stream()
            .map(tk -> tk.getText())
            .collect(Collectors.toList()));
        finder.visitScopeExp(ctx.body);
        merge(finder);
        return null;
    }

    @Override
    public Void visitDotNotationCall(LamaLanguageParser.DotNotationCallContext ctx) {
        notDefinedNames.add(ctx.name.getText());
        return null;
    }

    @Override
    public Void visitPrimary(LamaLanguageParser.PrimaryContext ctx) {
        if (ctx.LIDENT() != null) {
            notDefinedNames.add(ctx.LIDENT().getText());
            return null;
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitForLoop(LamaLanguageParser.ForLoopContext ctx) {
        if (ctx.def != null) {
            if (ctx.def instanceof LamaLanguageParser.VarDefinitionContext varDefCtx) {
                var finder = createInnerScopeVisitor(varDefCtx.oneVarDef()
                    .stream()
                    .map(oneVarDefCtx -> oneVarDefCtx.name.getText())
                    .collect(Collectors.toSet()));
                finder.visitScopeExp(ctx.body);
                merge(finder);
                return null;
            } else throw new LamaParsingException("we don\'t support function definitions in for loop headers", ctx.def);
        } else return visitScopeExp(ctx.body);
    }

    @Override
    public Void visitCaseOption(LamaLanguageParser.CaseOptionContext ctx) {
        var pattFinder = new ScopeLocalsFinder();
        pattFinder.visitPattern(ctx.pattern());
        Set<String> definedInPattern = new HashSet<>();
        definedInPattern.addAll(pattFinder.getDefinedNames());
        definedInPattern.removeAll(definedNames);

        if (definedInPattern.isEmpty())
            return visitExp(ctx.exp());

        var finder = createInnerScopeVisitor(pattFinder.getDefinedNames());
        finder.visitExp(ctx.exp());
        merge(finder);
        return null;
    }

    @Override
    public Void visitLambda(LamaLanguageParser.LambdaContext ctx) {
        if (ctx.args.LIDENT().isEmpty())
            return visitScopeExp(ctx.body);
        
        ScopeLocalsFinder finder = createInnerScopeVisitor(ctx.args.LIDENT()
            .stream()
            .map(tk -> tk.getText())
            .collect(Collectors.toList()));
        finder.visitScopeExp(ctx.body);
        merge(finder);
        return null;
    }

    @Override
    public Void visitLidentPattern(LamaLanguageParser.LidentPatternContext ctx) {
        definedNames.add(ctx.LIDENT().getText());
        return null;
    }

    @Override
    public Void visitAliasPattern(LamaLanguageParser.AliasPatternContext ctx) {
        definedNames.add(ctx.LIDENT().getText());
        return visitNonConsPattern(ctx.nonConsPattern());
    }

    public Collection<String> getDefinedNames() {
        return definedNames;
    }

    public Collection<String> getNotDefinedNames() {
        notDefinedNames.removeAll(definedNames);
        return notDefinedNames;
    }
}
