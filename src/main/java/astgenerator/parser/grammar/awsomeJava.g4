grammar awsomeJava;

programm: jClass+;
jClass: 'class' Identifier classBody;
constructor: AccessModifier? Identifier LBracket nMethodParameters RBracket block;
mainMethod: AccessModifier 'static' Void 'main' LBracket 'String[]' 'args' RBracket block;
classBody: CurlyLBracket (methodDeclaration|fieldDeclaration|constructor)* mainMethod?
    (methodDeclaration|fieldDeclaration|constructor)* CurlyRBracket;
methodDeclaration: AccessModifier? (objectType|Void) Identifier LBracket nMethodParameters RBracket block;
fieldDeclaration: AccessModifier?  objectType Identifier (Comma Identifier)* (Equal expression)? Semicolon;
methodParameter: objectType Identifier;
nMethodParameters: (methodParameter)? | methodParameter (Comma methodParameter)+;

nArguments: expression? | expression (Comma expression)* | instVar;
expression:  basicexpressions | binary;
basicexpressions:  baseType | instVar | Identifier | statementExpressions | unary | LBracket expression RBracket ;
instVar:  This Dot Identifier|(This Dot)? (Identifier Dot)+ Identifier;
statementExpressions: assign | jNew | methodCall;
assign: (instVar | Identifier) (Equal|PlusEqual|MinusEqual) expression;
localVarDeclaration: objectType Identifier (Comma Identifier)* ((Equal|PlusEqual|MinusEqual) expression)?;
jNew: 'new' Identifier LBracket nArguments RBracket;
methodCall: methodCallPrefix? (Identifier LBracket nArguments RBracket Dot)*
(Identifier LBracket nArguments RBracket);
methodCallPrefix: (instVar|Identifier Dot);
statement: ifelse | localVarDeclaration Semicolon | jReturn Semicolon | jWhile | block
    | statementExpressions Semicolon;
block: CurlyLBracket (statement)* CurlyRBracket;
ifelse: jIf jElseIf* jElse?;
jIf: If LBracket expression RBracket block;
jElseIf: Else If LBracket expression RBracket block;
jElse: Else block;
jWhile: 'while' LBracket expression RBracket block;
jReturn: 'return' expression;
unary:  NotOperator expression;
binary: basicexpressions (operators basicexpressions)+;
baseType: JBoolean | JNull | This | JString | JCharacter | JInteger | Super;
objectType: 'int'|'char'|'boolean'|Identifier;
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
NotOperator: '!';
OpBeforeOrAfterIdentifier: '++'|'--';
PointOperator: '*'|'/';
AddSubOperator: '+'|'-'|'%';
LogicalOperator: '&&'|'||';
LBracket:'(';
RBracket:')';
CurlyLBracket:'{';
CurlyRBracket:'}';
Dot: '.';
Comma: ',';
Semicolon: ';';
Identifier: [A-Za-z][A-Za-z0-9]*;
JCharacter: '\'' [A-Za-z]'\'';
JInteger: [0-9]+;

WS: ([ \t\r\n]+) -> skip;
Comment: '/*' .*? '*/' -> skip;
LineComment: '//' ~[\r\n]* -> skip;