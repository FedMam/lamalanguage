package com.oracle.truffle.lama.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.error.LamaParsingException;
import com.oracle.truffle.lama.language.LamaLanguageContext;
import com.oracle.truffle.lama.language.LamaTruffleLanguage;
import com.oracle.truffle.lama.nodes.ArrayNode;
import com.oracle.truffle.lama.nodes.AssignmentNode;
import com.oracle.truffle.lama.nodes.BinOp;
import com.oracle.truffle.lama.nodes.BinOpNode;
import com.oracle.truffle.lama.nodes.BuiltinNode;
import com.oracle.truffle.lama.nodes.CallNode;
import com.oracle.truffle.lama.nodes.CaseStmtNode;
import com.oracle.truffle.lama.nodes.ClosureConstructorNode;
import com.oracle.truffle.lama.nodes.ClosureNode;
import com.oracle.truffle.lama.nodes.ClosureVarNode;
import com.oracle.truffle.lama.nodes.ConsNode;
import com.oracle.truffle.lama.nodes.EqualsNode;
import com.oracle.truffle.lama.nodes.FunctionObjectNode;
import com.oracle.truffle.lama.nodes.GlobalDeclNode;
import com.oracle.truffle.lama.nodes.GlobalVarNode;
import com.oracle.truffle.lama.nodes.IfStmtNode;
import com.oracle.truffle.lama.nodes.IndexAccessNode;
import com.oracle.truffle.lama.nodes.IntLiteralNode;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.nodes.LetExprNode;
import com.oracle.truffle.lama.nodes.ListNode;
import com.oracle.truffle.lama.nodes.LocalFunctionNode;
import com.oracle.truffle.lama.nodes.LocalVarNode;
import com.oracle.truffle.lama.nodes.ReadFunctionArgNode;
import com.oracle.truffle.lama.nodes.SeqBlockNode;
import com.oracle.truffle.lama.nodes.SeqNode;
import com.oracle.truffle.lama.nodes.SexpNode;
import com.oracle.truffle.lama.nodes.SkipNode;
import com.oracle.truffle.lama.nodes.StringLiteralNode;
import com.oracle.truffle.lama.nodes.UnOpNode;
import com.oracle.truffle.lama.nodes.WhileLoopNode;
import com.oracle.truffle.lama.types.ClosureConstructor;
import com.oracle.truffle.lama.types.FunctionObject;
import com.oracle.truffle.lama.types.pattern.Pattern;

public final class LamaScopeParser extends LamaLanguageBaseVisitor<LamaNode> {
    private static final String CLOSURE_QUASIVAR_NAME = "<closure>";

    private final LamaTruffleLanguage language;
    private final Set<String> globalNames;
    private final Set<String> closureVars;
    private final Set<String> localFunctions;
    private final Map<String, Integer> varSlots;
    private final LamaScopeParser parent;
    private final FrameDescriptor.Builder fdBuilder;

    public LamaScopeParser(LamaTruffleLanguage language, Collection<String> globalNames, Collection<String> closureVars, Collection<String> localFunctions, LamaScopeParser parent, FrameDescriptor.Builder fdBuilder) {
        this.language = language;
        this.globalNames = Set.copyOf(globalNames);
        this.closureVars = Set.copyOf(closureVars);
        this.localFunctions = Set.copyOf(localFunctions);
        this.varSlots = new HashMap<>();
        this.parent = parent;
        this.fdBuilder = fdBuilder;
    }

    public LamaScopeParser(LamaTruffleLanguage language, Collection<String> globalNames, Collection<String> closureVars, Collection<String> localFunctions, Collection<String> varNames, LamaScopeParser parent, FrameDescriptor.Builder fdBuilder) {
        this(language, globalNames, closureVars, localFunctions, parent, fdBuilder);

        for (String varName: varNames) {
            if (!varName.equals("_")) {
                int slot = this.fdBuilder.addSlot(FrameSlotKind.Object, null, null);
                this.varSlots.put(varName, slot);
            }
        }
    }

    public LamaScopeParser(LamaTruffleLanguage language, Collection<String> globalNames, Collection<String> closureVars, Collection<String> localFunctions, Map<String, Integer> varSlots, LamaScopeParser parent, FrameDescriptor.Builder fdBuilder) {
        this(language, globalNames, closureVars, localFunctions, parent, fdBuilder);

        this.varSlots.putAll(varSlots);
    }

    private Optional<Integer> getVar(String varName) {
        if (varSlots.containsKey(varName))
            return Optional.of(varSlots.get(varName));
        return Optional.empty();
    }

    private Optional<Integer> lookupVar(String varName) {
        var get = getVar(varName);
        if (get.isPresent())
            return get;
        if (parent == null)
            return Optional.empty();
        return parent.lookupVar(varName);
    }

    private LamaNode getAppropVarNode(String varName, ParserRuleContext ctx) {
        Optional<Integer> slot = lookupVar(varName);
        if (slot.isPresent()) {
            if (localFunctions.contains(varName))
                return new LocalFunctionNode(slot.get());
            return new LocalVarNode(slot.get());
        } else if (closureVars.contains(varName)) {
            return new ClosureVarNode(varName, lookupVar(CLOSURE_QUASIVAR_NAME).get());
        } else if (globalNames.contains(varName)) {
            return new GlobalVarNode(varName);
        } else if (LamaLanguageContext.hasBuiltin(varName)) {
            return new BuiltinNode(varName);
        }
        throw new LamaParsingException("variable '" + varName + "' is not defined", ctx);
    }

    public static LamaNode parseGlobalScope(LamaLanguageParser.ScopeExpContext context, LamaTruffleLanguage language, FrameDescriptor.Builder builder) {
        List<String> vars = new ArrayList<>();
        
        for (var defCtx: context.definition()) {
            if (defCtx instanceof LamaLanguageParser.VarDefinitionContext varDefCtx) {
                for (var oneDefCtx: varDefCtx.oneVarDef()) {
                    String varName = oneDefCtx.name.getText();

                    if (varName.equals("_"))
                        throw new LamaParsingException("_ is reserved and cannot be the name of a variable", oneDefCtx);

                    vars.add(varName);
                }
            } else if (defCtx instanceof LamaLanguageParser.FunDefinitionContext funDefCtx) {
                String funName = funDefCtx.name.getText();
                vars.add(funName);
            }
        }

        LamaScopeParser parser = new LamaScopeParser(language, vars, Set.of(), Set.of(), null, builder);
        List<LamaNode> assnNodes = new ArrayList<>();

        for (var defCtx: context.definition()) {
            if (defCtx instanceof LamaLanguageParser.VarDefinitionContext varDefCtx) {
                for (var oneDefCtx: varDefCtx.oneVarDef()) {
                    var assnExpr = oneDefCtx.assignedValue;
                    if (assnExpr == null)
                        assnNodes.add(null);
                    else assnNodes.add(parser.visitBasic(assnExpr));
                }
            } else if (defCtx instanceof LamaLanguageParser.FunDefinitionContext funDefCtx) {
                assnNodes.add(parser.parseFunDefinition(funDefCtx));
            }
        }

        LamaNode mainNode = context.body != null ? parser.visitExp(context.body) : new SkipNode();
        List<LamaNode> assignmentBlock = new ArrayList<>();
        for (int i = 0; i < assnNodes.size(); i++) {
            if (assnNodes.get(i) != null) {
                assignmentBlock.add(
                    new AssignmentNode(
                        new GlobalVarNode(vars.get(i)),
                        assnNodes.get(i)
                    )
                );
            }
        }
        if (assignmentBlock.size() == 1) {
            mainNode = new SeqBlockNode(List.of(
                new GlobalDeclNode(vars),
                assignmentBlock.get(0),
                mainNode
            ));
        } else if (assignmentBlock.isEmpty()) {
            mainNode = new SeqNode(
                new GlobalDeclNode(vars),
                mainNode
            );
        } else {
            mainNode = new SeqBlockNode(List.of(
                new GlobalDeclNode(vars),
                new SeqBlockNode(assignmentBlock),
                mainNode
            ));
        }

        return mainNode;
    }

    // the last argument is for the sneaky do-while loop condition case
    // and will almost always be null
    // if it's not null, this method will return a WhileLoopNode
    public static LamaNode parseScopeExp(LamaLanguageParser.ScopeExpContext context, LamaScopeParser parent, LamaLanguageParser.ExpContext doWhileLoopCond) {
        List<String> vars = new ArrayList<>();
        Set<String> localFunctions = new HashSet<>();
        localFunctions.addAll(parent.localFunctions);

        for (var defCtx: context.definition()) {
            if (defCtx instanceof LamaLanguageParser.VarDefinitionContext varDefCtx) {
                for (var oneDefCtx: varDefCtx.oneVarDef()) {
                    String varName = oneDefCtx.name.getText();

                    if (varName.equals("_"))
                        throw new LamaParsingException("_ is reserved and cannot be the name of a variable", oneDefCtx);

                    vars.add(varName);
                }
            } else if (defCtx instanceof LamaLanguageParser.FunDefinitionContext funDefCtx) {
                String funName = funDefCtx.name.getText();
                vars.add(funName);
                localFunctions.add(funName);
            }
        }

        LamaScopeParser parser = new LamaScopeParser(parent.language, parent.globalNames, parent.closureVars, localFunctions, vars, parent, parent.fdBuilder);
        List<LamaNode> assnNodes = new ArrayList<>();
        
        for (var defCtx: context.definition()) {
            if (defCtx instanceof LamaLanguageParser.VarDefinitionContext varDefCtx) {
                for (var oneDefCtx: varDefCtx.oneVarDef()) {
                    var assnExpr = oneDefCtx.assignedValue;
                    if (assnExpr == null)
                        assnNodes.add(null);
                    else assnNodes.add(parser.visitBasic(assnExpr));
                }
            } else if (defCtx instanceof LamaLanguageParser.FunDefinitionContext funDefCtx) {
                assnNodes.add(parser.parseFunDefinition(funDefCtx));
            }
        }

        LamaNode mainNode = context.body != null ? parser.visitExp(context.body) : new SkipNode();
        List<LamaNode> assignmentBlock = new ArrayList<>();
        for (int i = 0; i < assnNodes.size(); i++) {
            if (assnNodes.get(i) != null) {
                assignmentBlock.add(
                    new AssignmentNode(
                        new LocalVarNode(parser.getVar(vars.get(i)).get()),
                        assnNodes.get(i)
                    )
                );
            }
        }
        if (assignmentBlock.size() == 1)
            mainNode = new SeqNode(assignmentBlock.get(0), mainNode);
        else if (!assignmentBlock.isEmpty())
            mainNode = new SeqNode(new SeqBlockNode(assignmentBlock), mainNode);

        if (doWhileLoopCond != null)
            return new WhileLoopNode(parser.visitExp(doWhileLoopCond), mainNode, true);

        return mainNode;
    }

    private LamaNode parseFunDefinition(LamaLanguageParser.FunDefinitionContext ctx) {
        List<String> args = ctx.args.LIDENT()
            .stream()
            .map(tNode -> tNode.getText())
            .collect(Collectors.toList());
        
        ScopeLocalsFinder finder = new ScopeLocalsFinder(args);
        finder.visitScopeExp(ctx.body);

        List<String> closureArgsUnfiltered = List.copyOf(finder.getNotDefinedNames());
        List<LamaNode> closureArgNodesUnfiltered = closureArgsUnfiltered
            .stream()
            .map(arg -> getAppropVarNode(arg, ctx))
            .collect(Collectors.toList());
        
        List<String> closureArgs = new ArrayList<>();
        List<LamaNode> closureArgNodes = new ArrayList<>();

        for (int i = 0; i < closureArgsUnfiltered.size(); i++) {
            if (closureArgNodesUnfiltered.get(i) instanceof LocalVarNode || 
                closureArgNodesUnfiltered.get(i) instanceof LocalFunctionNode || 
                closureArgNodesUnfiltered.get(i) instanceof ClosureVarNode) {
                // only then it can be considered as a closure argument
                closureArgs.add(closureArgsUnfiltered.get(i));
                closureArgNodes.add(closureArgNodesUnfiltered.get(i));
            }
        }

        FrameDescriptor.Builder funFdBuilder = FrameDescriptor.newBuilder();
        LamaScopeParser parserWArgs = new LamaScopeParser(this.language, this.globalNames, closureArgs, Set.of(), args, null, funFdBuilder);

        if (!closureArgs.isEmpty()) {
            int keeperSlot = funFdBuilder.addSlot(FrameSlotKind.Object, null, null);
            parserWArgs.varSlots.put(CLOSURE_QUASIVAR_NAME, keeperSlot);
        }

        LamaNode funBody = parserWArgs.visitScopeExp(ctx.body);

        List<LamaNode> assignmentBlock = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            if (!args.get(i).equals("_"))
                assignmentBlock.add(
                    new AssignmentNode(
                        new LocalVarNode(parserWArgs.getVar(args.get(i)).get()),
                        new ReadFunctionArgNode(i)
                    )
                );
        }
        if (assignmentBlock.size() == 1)
            funBody = new SeqNode(assignmentBlock.get(0), funBody);
        else if (!assignmentBlock.isEmpty())
            funBody = new SeqNode(new SeqBlockNode(assignmentBlock), funBody);

        // DEBUG
        /* if (LamaTruffleParser.ENABLE_DEBUG) {
            System.out.println("======================");
            LamaTruffleParser.debugNode(funBody, 0);
        } */

        if (closureArgs.isEmpty()) {
            LamaRootNode rootNode = new LamaRootNode(this.language, funFdBuilder.build(), funBody);
            FunctionObject functionObject = new FunctionObject(rootNode.getCallTarget());
            return new FunctionObjectNode(functionObject);
        } else {
            int keeperSlot = parserWArgs.getVar(CLOSURE_QUASIVAR_NAME).get();

            ClosureConstructor constructor = new ClosureConstructor(
                closureArgNodes.toArray(LamaNode[]::new),
                closureArgs.toArray(String[]::new),
                this.language,
                funFdBuilder,
                funBody,
                keeperSlot
            );
            return new ClosureConstructorNode(constructor);
        }
    }

    @Override
    public LamaNode visitScopeExp(LamaLanguageParser.ScopeExpContext ctx) {
        return LamaScopeParser.parseScopeExp(ctx, this, null);
    }

    @Override
    public LamaNode visitSeqExp(LamaLanguageParser.SeqExpContext ctx) {
        if (!(ctx.r instanceof LamaLanguageParser.SeqExpContext))
            return new SeqNode(visitBasic(ctx.l), visitExp(ctx.r));

        LamaLanguageParser.SeqExpContext next = ctx;
        List<LamaNode> instructions = new ArrayList<>();
        while (next.r instanceof LamaLanguageParser.SeqExpContext next1) {
            instructions.add(visitBasic(next.l));
            next = next1;
        }
        instructions.add(visitBasic(next.l));
        instructions.add(visitExp(next.r));
        
        return new SeqBlockNode(instructions);
    }

    @Override
    public LamaNode visitLetExp(LamaLanguageParser.LetExpContext ctx) {
        LamaNode tested = visitBasic(ctx.basic());

        PatternVisitor pv = new PatternVisitor(fdBuilder);
        Pattern patt = pv.visitPattern(ctx.pattern());
        
        LamaScopeParser parser = new LamaScopeParser(language, globalNames, closureVars, localFunctions, this, fdBuilder);
        Map<String, Integer> patternVarSlots = pv.getVarSlots();

        for (String pattVar: patternVarSlots.keySet()) {
            parser.varSlots.put(pattVar, patternVarSlots.get(pattVar));
        }

        LamaNode outcome = parser.visitExp(ctx.r);
        return new LetExprNode(patt, tested, outcome, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public LamaNode visitAssignmentExp(LamaLanguageParser.AssignmentExpContext ctx) {
        return new AssignmentNode(visitPostfix(ctx.l), visitBasic(ctx.r));
    }

    @Override
    public LamaNode visitBasicCons(LamaLanguageParser.BasicConsContext ctx) {
        return new ConsNode(
            ctx.basicOr()
                .stream()
                .map(orCtx -> visitBasicOr(orCtx))
                .toArray(LamaNode[]::new),
            visitPostfix(ctx.postfix())
        );
    }

    @Override
    public LamaNode visitOpOr(LamaLanguageParser.OpOrContext ctx) {
        return new BinOpNode(
            visitBasicOr(ctx.l),
            BinOp.OR,
            visitBasicAnd(ctx.r)
        );
    }

    @Override
    public LamaNode visitOpAnd(LamaLanguageParser.OpAndContext ctx) {
        return new BinOpNode(
            visitBasicAnd(ctx.l),
            BinOp.AND,
            visitBasicCmp(ctx.r)
        );
    }

    @Override
    public LamaNode visitOpCmp(LamaLanguageParser.OpCmpContext ctx) {
        BinOp op = BinOp.LT;
        switch (ctx.OP_CMP().getText()) {
            case "<"  -> op = BinOp.LT;
            case "<=" -> op = BinOp.LE;
            case ">"  -> op = BinOp.GT;
            case ">=" -> op = BinOp.GE;
            case "==" -> op = BinOp.EQ;
            case "!=" -> op = BinOp.NE;
        }

        LamaNode lArg = visitBasicAdd(ctx.l), rArg = visitBasicAdd(ctx.r);
        return switch (op) {
            case EQ -> new EqualsNode(lArg, rArg, false);
            case NE -> new EqualsNode(lArg, rArg, true);
            default -> new BinOpNode(lArg, op, rArg);
        };
    }

    @Override
    public LamaNode visitOpAdd(LamaLanguageParser.OpAddContext ctx) {
        BinOp op = BinOp.ADD;
        switch (ctx.OP_ADD().getText()) {
            case "+" -> op = BinOp.ADD;
            case "-" -> op = BinOp.SUB;
        }
        return new BinOpNode(visitBasicAdd(ctx.l), op, visitBasicMul(ctx.r));
    }

    @Override
    public LamaNode visitOpMul(LamaLanguageParser.OpMulContext ctx) {
        BinOp op = BinOp.MUL;
        switch (ctx.OP_MUL().getText()) {
            case "*" -> op = BinOp.MUL;
            case "/" -> op = BinOp.DIV;
            case "%" -> op = BinOp.REM;
        }
        return new BinOpNode(visitBasicMul(ctx.l), op, visitBasicUnary(ctx.r));
    }

    @Override
    public LamaNode visitOpUnary(LamaLanguageParser.OpUnaryContext ctx) {
        return new UnOpNode(visitBasicUnary(ctx.basicUnary()), ctx.OP_ADD().getText().equals("-"));
    }

    @Override
    public LamaNode visitIndexRef(LamaLanguageParser.IndexRefContext ctx) {
        return new IndexAccessNode(visitPostfix(ctx.ref), visitExp(ctx.index));
    }

    @Override
    public LamaNode visitCall(LamaLanguageParser.CallContext ctx) {
        List<LamaNode> callArguments = new ArrayList<>();
        for (var actx : ctx.args.exp()) {
            callArguments.add(visitExp(actx));
        }

        return new CallNode(visitPostfix(ctx.funcref), callArguments);
    }

    @Override
    public LamaNode visitDotNotationCall(LamaLanguageParser.DotNotationCallContext ctx) {
        List<LamaNode> callArguments = new ArrayList<>();
        callArguments.add(visitPostfix(ctx.firstarg));
        if (ctx.args != null) {
            for (var actx : ctx.args.exp()) {
                callArguments.add(visitExp(actx));
            }
        }

        return new CallNode(getAppropVarNode(ctx.name.getText(), ctx), callArguments);
    }

    @Override
    public LamaNode visitPrimary(LamaLanguageParser.PrimaryContext ctx) {
        if (ctx.LIDENT() != null) {
            String varName = ctx.LIDENT().getText();
            return getAppropVarNode(varName, ctx);
        }
        else return visitChildren(ctx);
    }

    @Override
    public LamaNode visitSexp(LamaLanguageParser.SexpContext ctx) {
        if (ctx.args == null)
            return new SexpNode(ctx.name.getText(), new LamaNode[0]);
        else {
            return new SexpNode(
                ctx.name.getText(),
                ctx.args.exp()
                    .stream()
                    .map(expCtx -> visitExp(expCtx))
                    .toArray(LamaNode[]::new)
            );
        }
    }

    @Override
    public LamaNode visitArray(LamaLanguageParser.ArrayContext ctx) {
        return new ArrayNode(ctx.members.exp()
            .stream()
            .map(expCtx -> visitExp(expCtx))
            .toArray(LamaNode[]::new));
    }

    @Override
    public LamaNode visitList(LamaLanguageParser.ListContext ctx) {
        return new ListNode(ctx.members.exp()
            .stream()
            .map(expCtx -> visitExp(expCtx))
            .toArray(LamaNode[]::new));
    }

    @Override
    public LamaNode visitStrlit(LamaLanguageParser.StrlitContext ctx) {
        String stringWithQuotes = ctx.value.getText();
        String stringValue = stringWithQuotes
            .substring(1, stringWithQuotes.length() - 1)
            .replace("\\n", "\n")
            .replace("\\r", "\r")
            .replace("\\t", "\t")
            .replace("\\\"", "\"")
            .replace("\\\\", "\\");
        return new StringLiteralNode(stringValue);
    }

    @Override
    public LamaNode visitChrlit(LamaLanguageParser.ChrlitContext ctx) {
        String raw = ctx.value.getText();
        char ch;
        if ("\'\\\'\'".equals(raw))
            ch = '\'';
        else if (raw.length() != 3)
            throw new LamaParsingException("incorrect character literal value: " + raw, ctx);
        else ch = raw.charAt(1);

        return new IntLiteralNode((int)ch);
    }

    @Override
    public LamaNode visitIntlit(LamaLanguageParser.IntlitContext ctx) {
        return new IntLiteralNode(Integer.parseInt(ctx.value.getText()));
    }

    @Override
    public LamaNode visitBlit(LamaLanguageParser.BlitContext ctx) {
        if (ctx.TRUE() != null)
            return new IntLiteralNode(1);
        else return new IntLiteralNode(0);
    }

    @Override
    public LamaNode visitParentheses(LamaLanguageParser.ParenthesesContext ctx) {
        return visitScopeExp(ctx.scopeExp());
    }

    @Override
    public LamaNode visitNop(LamaLanguageParser.NopContext ctx) {
        return new SkipNode();
    }

    @Override
    public LamaNode visitWhileLoop(LamaLanguageParser.WhileLoopContext ctx) {
        return new WhileLoopNode(visitExp(ctx.cond), visitScopeExp(ctx.body), false);
    }

    @Override
    public LamaNode visitDoWhileLoop(LamaLanguageParser.DoWhileLoopContext ctx) {
        return parseScopeExp(ctx.body, this, ctx.cond);
    }

    @Override
    public LamaNode visitForLoop(LamaLanguageParser.ForLoopContext ctx) {
        if (ctx.def == null) {
            return new SeqNode(
                visitExp(ctx.init),
                new WhileLoopNode(
                    visitExp(ctx.cond),
                    new SeqNode(
                        visitScopeExp(ctx.body),
                        visitExp(ctx.inc)
                    ),
                    false
                )
            );
        }

        if (ctx.def instanceof LamaLanguageParser.VarDefinitionContext defCtx) {
            List<String> vars = new ArrayList<>();
            List<LamaLanguageParser.BasicContext> assnExprs = new ArrayList<>();

            for (var oneDefCtx: defCtx.oneVarDef()) {
                String varName = oneDefCtx.name.getText();
                var assnExpr = oneDefCtx.assignedValue;

                if (varName.equals("_"))
                    throw new LamaParsingException("_ is reserved and cannot be the name of a variable", oneDefCtx);

                vars.add(varName);
                assnExprs.add(assnExpr);
            }

            LamaScopeParser parser = new LamaScopeParser(this.language, this.globalNames, this.closureVars, this.localFunctions, vars, this, this.fdBuilder);
            List<LamaNode> assnNodes = new ArrayList<>();
            for (var assnExpr: assnExprs) {
                if (assnExpr == null)
                    assnNodes.add(null);
                else {
                    assnNodes.add(parser.visitBasic(assnExpr));
                }
            }

            LamaNode mainNode = new SeqNode(
                parser.visitExp(ctx.init),
                new WhileLoopNode(
                    parser.visitExp(ctx.cond),
                    new SeqNode(
                        parser.visitScopeExp(ctx.body),
                        parser.visitExp(ctx.inc)
                    ),
                    false
                )
            );

            List<LamaNode> assignmentBlock = new ArrayList<>();
            for (int i = 0; i < assnNodes.size(); i++) {
                if (assnNodes.get(i) != null) {
                    assignmentBlock.add(
                        new AssignmentNode(
                            new LocalVarNode(parser.getVar(vars.get(i)).get()),
                            assnNodes.get(i)
                        )
                    );
                }
            }
            if (assignmentBlock.size() == 1)
                mainNode = new SeqNode(assignmentBlock.get(0), mainNode);
            else if (!assignmentBlock.isEmpty())
                mainNode = new SeqNode(new SeqBlockNode(assignmentBlock), mainNode);

            return mainNode;
        } else {
            throw new LamaParsingException("we don\'t support function definitions in for loop headers", ctx.def);
        }
    }

    @Override
    public LamaNode visitIfStmt(LamaLanguageParser.IfStmtContext ctx) {
        var conds = ctx.exp();
        var bodies = ctx.scopeExp();

        LamaNode ifNode;
        if (bodies.size() > conds.size()) {
            // there is bodyElse
            assert ctx.bodyElse != null;
            ifNode = visitScopeExp(ctx.bodyElse);
        } else {
            ifNode = new SkipNode();
        }

        for (int i = conds.size() - 1; i >= 0; i--) {
            ifNode = new IfStmtNode(visitExp(conds.get(i)), visitScopeExp(bodies.get(i)), ifNode);
        }

        return ifNode;
    }

    @Override
    public LamaNode visitCaseStmt(LamaLanguageParser.CaseStmtContext ctx) {
        LamaNode tested = visitExp(ctx.exp());

        List<Pattern> patterns = new ArrayList<>();
        List<LamaNode> outcomes = new ArrayList<>();

        for (var optCtx: ctx.caseOption()) {
            var caseOption = parseCaseOption(optCtx);
            patterns.add(caseOption.a);
            outcomes.add(caseOption.b);
        }

        return new CaseStmtNode(
            tested,
            patterns.toArray(Pattern[]::new),
            outcomes.toArray(LamaNode[]::new),
            ctx.ESAC().getSymbol().getLine(),
            ctx.ESAC().getSymbol().getCharPositionInLine()
        );
    }

    private Pair<Pattern, LamaNode> parseCaseOption(LamaLanguageParser.CaseOptionContext ctx) {
        PatternVisitor pv = new PatternVisitor(fdBuilder);
        Pattern patt = pv.visitPattern(ctx.pattern());
        
        LamaScopeParser parser = new LamaScopeParser(language, globalNames, closureVars, localFunctions, this, fdBuilder);
        Map<String, Integer> patternVarSlots = pv.getVarSlots();

        for (String pattVar: patternVarSlots.keySet()) {
            parser.varSlots.put(pattVar, patternVarSlots.get(pattVar));
        }

        LamaNode outcome = parser.visitExp(ctx.exp());
        return new Pair<>(patt, outcome);
    }

    @Override
    public LamaNode visitLambda(LamaLanguageParser.LambdaContext ctx) {
        List<String> args = ctx.args.LIDENT()
            .stream()
            .map(tNode -> tNode.getText())
            .collect(Collectors.toList());
        
        ScopeLocalsFinder finder = new ScopeLocalsFinder(args);
        finder.visitScopeExp(ctx.body);

        List<String> closureArgsUnfiltered = List.copyOf(finder.getNotDefinedNames());
        List<LamaNode> closureArgNodesUnfiltered = closureArgsUnfiltered
            .stream()
            .map(arg -> getAppropVarNode(arg, ctx))
            .collect(Collectors.toList());
        
        List<String> closureArgs = new ArrayList<>();
        List<LamaNode> closureArgNodes = new ArrayList<>();

        for (int i = 0; i < closureArgsUnfiltered.size(); i++) {
            if (closureArgNodesUnfiltered.get(i) instanceof LocalVarNode ||
                closureArgNodesUnfiltered.get(i) instanceof LocalFunctionNode ||
                closureArgNodesUnfiltered.get(i) instanceof ClosureVarNode) {
                // only then it can be considered as a closure argument
                closureArgs.add(closureArgsUnfiltered.get(i));
                closureArgNodes.add(closureArgNodesUnfiltered.get(i));
            }
        }

        FrameDescriptor.Builder funFdBuilder = FrameDescriptor.newBuilder();
        LamaScopeParser parserWArgs = new LamaScopeParser(this.language, this.globalNames, closureArgs, Set.of(), args, null, funFdBuilder);

        if (!closureArgs.isEmpty()) {
            int keeperSlot = funFdBuilder.addSlot(FrameSlotKind.Object, null, null);
            parserWArgs.varSlots.put(CLOSURE_QUASIVAR_NAME, keeperSlot);
        }

        LamaNode funBody = parserWArgs.visitScopeExp(ctx.body);

        List<LamaNode> assignmentBlock = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            if (!args.get(i).equals("_"))
                assignmentBlock.add(
                    new AssignmentNode(
                        new LocalVarNode(parserWArgs.getVar(args.get(i)).get()),
                        new ReadFunctionArgNode(i)
                    )
                );
        }
        if (assignmentBlock.size() == 1)
            funBody = new SeqNode(assignmentBlock.get(0), funBody);
        else if (!assignmentBlock.isEmpty())
            funBody = new SeqNode(new SeqBlockNode(assignmentBlock), funBody);

        // DEBUG
        /* if (LamaTruffleParser.ENABLE_DEBUG) {
            System.out.println("======================");
            LamaTruffleParser.debugNode(funBody, 0);
        } */

        if (closureArgs.isEmpty()) {
            LamaRootNode rootNode = new LamaRootNode(this.language, funFdBuilder.build(), funBody);
            FunctionObject functionObject = new FunctionObject(rootNode.getCallTarget());
            return new FunctionObjectNode(functionObject);
        } else {
            int keeperSlot = parserWArgs.getVar(CLOSURE_QUASIVAR_NAME).get();

            // Instead of creating ClosureConstructor here, we use ClosureNode to build the
            // closure right there. Because, once again, of the strange logic of Lama
            return new ClosureNode(
                closureArgNodes.toArray(LamaNode[]::new),
                closureArgs.toArray(String[]::new),
                this.language,
                funFdBuilder,
                funBody,
                keeperSlot
            );
        }
    }
}
