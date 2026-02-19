package com.oracle.truffle.lama.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.error.LamaParsingException;
import com.oracle.truffle.lama.types.pattern.AliasPattern;
import com.oracle.truffle.lama.types.pattern.ArrayPattern;
import com.oracle.truffle.lama.types.pattern.BooleanTruePattern;
import com.oracle.truffle.lama.types.pattern.ConsPattern;
import com.oracle.truffle.lama.types.pattern.FunTagPattern;
import com.oracle.truffle.lama.types.pattern.IntLiteralPattern;
import com.oracle.truffle.lama.types.pattern.ListPattern;
import com.oracle.truffle.lama.types.pattern.Pattern;
import com.oracle.truffle.lama.types.pattern.SexpPattern;
import com.oracle.truffle.lama.types.pattern.StrTagPattern;
import com.oracle.truffle.lama.types.pattern.StringLiteralPattern;
import com.oracle.truffle.lama.types.pattern.UnderscorePattern;
import com.oracle.truffle.lama.types.pattern.ValTagPattern;
import com.oracle.truffle.lama.types.pattern.VarPattern;

public final class PatternVisitor extends LamaLanguageBaseVisitor<Pattern> {
    private final Map<String, Integer> varSlots;
    private final FrameDescriptor.Builder fdBuilder;

    public PatternVisitor(FrameDescriptor.Builder fdBuilder) {
        this.varSlots = new HashMap<>();
        this.fdBuilder = fdBuilder;
    }

    public Map<String, Integer> getVarSlots() {
        return varSlots;
    }

    @Override
    public Pattern visitConsPattern(LamaLanguageParser.ConsPatternContext ctx) {
        List<LamaLanguageParser.NonConsPatternContext> elements = ctx.nonConsPattern();
        return new ConsPattern(
            elements.subList(0, elements.size() - 1)
                .stream()
                .map(pattCtx -> visitNonConsPattern(pattCtx))
                .toArray(Pattern[]::new),
            visitNonConsPattern(elements.get(elements.size() - 1))
        );
    }

    @Override
    public Pattern visitParenthesesPattern(LamaLanguageParser.ParenthesesPatternContext ctx) {
        return visitPattern(ctx.pattern());
    }

    @Override
    public Pattern visitLiteralPattern(LamaLanguageParser.LiteralPatternContext ctx) {
        var litCtx = ctx.literal();
        if (litCtx.strlit() != null) {
            String stringWithQuotes = litCtx.strlit().value.getText();
            String stringValue = stringWithQuotes
                .substring(1, stringWithQuotes.length() - 1)
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");
            return new StringLiteralPattern(stringValue);
        } else if (litCtx.chrlit() != null) {
            String raw = litCtx.chrlit().value.getText();
            char ch;
            if ("\'\\\'\'".equals(raw))
                ch = '\'';
            else if (raw.length() != 3)
                throw new LamaParsingException("incorrect character literal value: " + raw, ctx);
            else ch = raw.charAt(1);

            return new IntLiteralPattern((int)ch);
        } else if (litCtx.intlit() != null) {
            return new IntLiteralPattern(Integer.parseInt(litCtx.intlit().value.getText()));
        } else if (litCtx.blit() != null) {
            if (litCtx.blit().TRUE() != null)
                return new BooleanTruePattern();
            return new IntLiteralPattern(0);
        } else {
            // should not reach here
            throw new LamaParsingException("incorrect literal pattern", ctx);
        }
    }

    @Override
    public Pattern visitLidentPattern(LamaLanguageParser.LidentPatternContext ctx) {
        String varName = ctx.LIDENT().getText();

        if (varName.equals("_"))
            return new UnderscorePattern();

        if (varSlots.containsKey(varName))
            throw new LamaParsingException("duplicate alias name in pattern matching: " + varName, ctx);

        int slot = this.fdBuilder.addSlot(FrameSlotKind.Object, null, null);
        varSlots.put(varName, slot);
        return new VarPattern(slot);
    }

    @Override
    public Pattern visitAliasPattern(LamaLanguageParser.AliasPatternContext ctx) {
        String varName = ctx.LIDENT().getText();

        if (varSlots.containsKey(varName))
            throw new LamaParsingException("duplicate alias name in pattern matching: " + varName, ctx);

        int slot = this.fdBuilder.addSlot(FrameSlotKind.Object, null, null);
        varSlots.put(varName, slot);
        return new AliasPattern(slot, visitNonConsPattern(ctx.nonConsPattern()));
    }

    @Override
    public Pattern visitSexpPattern(LamaLanguageParser.SexpPatternContext ctx) {
        if (ctx.args == null)
            return new SexpPattern(ctx.name.getText(), new Pattern[0]);
        else return new SexpPattern(
            ctx.name.getText(),
            ctx.args.pattern()
                .stream()
                .map(pattCtx -> visitPattern(pattCtx))
                .toArray(Pattern[]::new)
        );
    }

    @Override
    public Pattern visitArrayPattern(LamaLanguageParser.ArrayPatternContext ctx) {
        return new ArrayPattern(
            ctx.members.pattern()
                .stream()
                .map(pattCtx -> visitPattern(pattCtx))
                .toArray(Pattern[]::new)
        );
    }

    @Override
    public Pattern visitListPattern(LamaLanguageParser.ListPatternContext ctx) {
        return new ListPattern(
            ctx.members.pattern()
                .stream()
                .map(pattCtx -> visitPattern(pattCtx))
                .toArray(Pattern[]::new)
        );
    }

    @Override
    public Pattern visitAssertValPattern(LamaLanguageParser.AssertValPatternContext ctx) {
        return new ValTagPattern();
    }

    @Override
    public Pattern visitAssertFunPattern(LamaLanguageParser.AssertFunPatternContext ctx) {
        return new FunTagPattern();
    }

    @Override
    public Pattern visitAssertStrPattern(LamaLanguageParser.AssertStrPatternContext ctx) {
        return new StrTagPattern();
    }
}