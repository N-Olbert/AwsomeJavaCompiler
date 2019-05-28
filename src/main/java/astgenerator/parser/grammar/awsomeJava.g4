grammar awsomeJava;

programm: jClass+;
jClass: AccessModifier? 'class' Identifier classBody;
constructor: AccessModifier? Identifier LBracket nMethodParameters RBracket block;
mainMethod: AccessModifier 'static' Void 'main' LBracket 'String[]' 'args' RBracket block;
classBody: CurlyLBracket (methodDeclaration|fieldDeclaration)* constructor? mainMethod?
    (methodDeclaration|fieldDeclaration)* CurlyRBracket;
methodDeclaration: AccessModifier? (objectType|Void) Identifier LBracket nMethodParameters RBracket block;
fieldDeclaration: AccessModifier?  objectType Identifier (Equal expression)? Semincolor;
methodParameter: objectType Identifier;
nMethodParameters: (methodParameter)? | methodParameter (Comma methodParameter)+;

nArguments: expression? | expression (Comma expression)* | instVar;
expression:  basicexpressions | binary | LBracket expression RBracket;
basicexpressions:  baseType | instVar | Identifier | statementExpressions ;
instVar:  This Dot Identifier|(This Dot)? (Identifier Dot)+ Identifier | Super Dot Identifier
    | (Super Dot)? (Identifier Dot)+ Identifier;
statementExpressions: assign | jNew | methodCall; //| unary;
assign: (instVar | Identifier) (Equal|PlusEqual|MinusEqual) expression;
localVarDeclaration: objectType Identifier ((Equal|PlusEqual|MinusEqual) expression)?;
jNew: 'new' Identifier LBracket nArguments RBracket;
methodCall: (instVar|Identifier) LBracket nArguments RBracket;
statement: ifelse | localVarDeclaration Semincolor | jReturn Semincolor | jWhile | block | assign Semincolor
    | statementExpressions Semincolor;
block: CurlyLBracket (statement)* CurlyRBracket;
ifelse: jIf jElseIf* jElse?;
jIf: If LBracket expression RBracket block;
jElseIf: Else If LBracket expression RBracket block;
jElse: Else block;
jWhile: 'while' LBracket expression RBracket block;
jReturn: 'return' expression;
unary:  operatorBeforeExpr | operatorAfterExpr;
binary: basicexpressions (operators basicexpressions)+;
operatorBeforeExpr: (OpBeforeIdentifier|OpBeforeOrAfterIdentifier) (Identifier|instVar);
operatorAfterExpr: (Identifier|instVar) OpBeforeOrAfterIdentifier;
baseType: JBoolean | JNull | This | JString | JCharacter | JInteger | Super;
objectType: 'int'|'char'|'boolean'|'String'|Identifier;
operators: LogicalOperator|Comperator|AddSubOperator|PointOperator;

AccessModifier: 'public' | 'protected' | 'private';
JBoolean: 'true'|'false';
JNull: 'null';
Void: 'void';
Super: 'super';
This: 'this';
If: 'if';
Else: 'else';
Equal: '=';
PlusEqual: '+=';
MinusEqual: '-=';
Comperator: '=='|'!='|'>='|'<='|'>'|'<';
OpBeforeIdentifier: '!';
OpBeforeOrAfterIdentifier: '++'|'--';
PointOperator: '*'|'/';
AddSubOperator: '+'|'-';
LogicalOperator: '&&'|'||';
LBracket:'(';
RBracket:')';
CurlyLBracket:'{';
CurlyRBracket:'}';
Dot: '.';
Comma: ',';
Semincolor: ';';
JString: '"'[A-Za-z]*'"'+;
Identifier: [A-Za-z][A-Za-z0-9]*;
JCharacter: '\'' [A-Za-z]'\'';
JInteger: [0-9]+;

WS: ([ \t\r\n]+) -> skip;
Comment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;