grammar LamaLanguage;

@parser::header
{

}

@lexer::header
{

}

// parser

lamaLanguage
	: scopeExp EOF
	;

scopeExp
	: definition* body=exp?
	;

oneVarDef
	: name=LIDENT (OP_ASSN1 assignedValue=basic)?
	;

definition
	: VAR firstdef=oneVarDef (COMMA oneVarDef)* SCLN			# VarDefinition
	| FUN name=LIDENT LPAR args=lidentList0 RPAR LCB body=scopeExp RCB	# FunDefinition
	;

lidentList0
	:
	| hd=LIDENT (COMMA LIDENT)*
	;

expList0
	:
	| hd=exp (COMMA exp)*
	;

expList
	: hd=exp (COMMA exp)*
	;

exp
	: basic									# SingleExp
	| l=basic SCLN r=exp					# SeqExp
	| LET pattern OP_ASSN1 basic IN r=exp	# LetExp
	;

basic
	: basicOr				# BasicExp
	| basicCons				# ConsExp
	| l=postfix OP_ASSN2 r=basic		# AssignmentExp
	;

basicCons
	: (l=basicOr CLN)+ postfix
	;

basicOr
	: basicAnd			# QuasiOr
	| l=basicOr OP_OR r=basicAnd	# OpOr
	;

basicAnd
	: basicCmp			# QuasiAnd
	| l=basicAnd OP_AND r=basicCmp	# OpAnd
	;

basicCmp
	: basicAdd			# QuasiCmp
	| l=basicAdd OP_CMP r=basicAdd	# OpCmp
	;

basicAdd
	: basicMul			# QuasiAdd
	| l=basicAdd OP_ADD r=basicMul	# OpAdd
	;

basicMul
	: basicUnary			# QuasiMul
	| l=basicMul OP_MUL r=basicUnary	# OpMul
	;

basicUnary
	: postfix				# QuasiUnary
	| OP_ADD basicUnary					# OpUnary
	;

postfix
	: primary							# PrimaryExp
	| ref=postfix LBRKT index=exp RBRKT				# IndexRef
	| funcref=postfix LPAR args=expList0 RPAR		# Call
	| firstarg=postfix DOT name=LIDENT (LPAR args=expList RPAR)?	# DotNotationCall
	;

primary
	: LIDENT
	| sexp
	| array
	| list
	| literal
	| parentheses
	| nop
	| whileLoop
	| doWhileLoop
	| forLoop
	| ifStmt
	| caseStmt
	| lambda
	;

sexp
	: name=UIDENT (LPAR args=expList RPAR)?
	;

array
	: LBRKT members=expList0 RBRKT
	;

list
	: LCB members=expList0 RCB
	;

literal
	: strlit
	| chrlit
	| intlit
	| blit
	;

strlit
	: value=STRING
	;

chrlit
	: value=CHARACTER
	;

intlit
	: value=INTEGER
	;

blit
	: TRUE
	| FALSE
	;

parentheses
	: LPAR body=scopeExp RPAR
	;

nop
	: NOP
	;

whileLoop
	: WHILE cond=exp DO body=scopeExp OD
	;

doWhileLoop
	: DO body=scopeExp WHILE cond=exp OD
	;

forLoop
	: FOR def=definition? init=exp COMMA cond=exp COMMA inc=exp DO body=scopeExp OD
	;

ifStmt
	: IF cond=exp THEN body=scopeExp (ELIF condAlt=exp THEN bodyAlt=scopeExp)* (ELSE bodyElse=scopeExp)? FI
	;

caseStmt
	: CASE exp OF caseOption (VBAR caseOption)* ESAC
	;

caseOption
	: pattern RARROW exp
	;

lambda
	: FUN LPAR args=lidentList0 RPAR LCB body=scopeExp RCB
	;

pattern
	: nonConsPattern			# SimplePattern
	| nonConsPattern (CLN nonConsPattern)*	# ConsPattern
	;

nonConsPattern
	: parenthesesPattern
	| literalPattern
	| varPattern
	| sexpPattern
	| arrayPattern
	| listPattern
	| assertFunPattern
	| assertStrPattern
	| assertValPattern
	;

patternList0
	:
	| hd=pattern (COMMA pattern)*
	;

patternList
	: hd=pattern (COMMA pattern)*
	;

parenthesesPattern
	: LPAR pattern RPAR
	;

literalPattern
	: literal
	;

varPattern
	: LIDENT			# LidentPattern
	| LIDENT ALIAS nonConsPattern	# AliasPattern
	;

sexpPattern
	: name=UIDENT (LPAR args=patternList RPAR)?
	;

arrayPattern
	: LBRKT members=patternList0 RBRKT
	;

listPattern
	: LCB members=patternList0 RCB
	;

assertFunPattern
	: ASSERT_FUN
	;

assertValPattern
	: ASSERT_VAL
	;

assertStrPattern
	: ASSERT_STR
	;

// lexer

WHITESPACE : ( ('--' ~[\r\n]*)? [ \t\r\n\u000C]+ )+ -> skip;

NOP:	'skip';
IF:	'if';
THEN:	'then';
ELSE:	'else';
ELIF:	'elif';
FI:	'fi';
CASE:	'case';
OF:	'of';
ESAC:	'esac';
WHILE:	'while';
DO:	'do';
OD:	'od';
FOR:	'for';
LET:	'let';
IN:	'in';
VAR:	'var';
FUN:	'fun';
TRUE:	'true';
FALSE:	'false';

STRING:	'"' (~('"') | '\\"')* '"';
CHARACTER:	'\'' (~('\'') | '\\\'') '\'';
INTEGER:	[0-9]+;
LIDENT:	[a-z_][a-z_A-Z0-9]*;
UIDENT:	[A-Z][a-z_A-Z0-9]*;

OP_ASSN1:	'=';
OP_ASSN2:	':=';
OP_OR:	'!!';
OP_AND:	'&&';
OP_CMP:	'<' | '<=' | '>' | '>=' | '==' | '!=';
OP_ADD:	'+' | '-';
OP_MUL:	'*' | '/' | '%';

LPAR:	'(';
RPAR:	')';
LBRKT:	'[';
RBRKT:	']';
LCB:	'{';
RCB:	'}';
COMMA:	',';
CLN:	':';
SCLN:	';';
SQUOTE:	'\'';
DQUOTE:	'"';
DOT:	'.';
ALIAS:	'@';
RARROW:	'->';
VBAR:	'|';

ASSERT_VAL:	'#val';
ASSERT_FUN:	'#fun';
ASSERT_STR:	'#str';
