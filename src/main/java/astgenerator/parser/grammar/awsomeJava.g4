grammar awsomeJava;

programm: jClass+;
jClass: AccessModifier? 'class' Identifier classBody; //Modifier
constructor: AccessModifier? Identifier'('nMethodParameters')' block;
classBody: '{'(methodDeclaration|fieldDeclaration)* constructor (methodDeclaration|fieldDeclaration)*'}';
methodDeclaration: AccessModifier? objectType Identifier '('nMethodParameters')' block;
fieldDeclaration: AccessModifier?  objectType Identifier';';
methodParameter: objectType Identifier;
nMethodParameters: (methodParameter)? | methodParameter (','methodParameter)+;
nArguments: expression? | expression (',' expression)* | instVar;
instVar:  This '.' Identifier|(Identifier '.')+ Identifier;
expression: (baseType | instVar | Identifier | binary | unary ); //comparison
statementExpressions: (assign | jNew | methodCall)';';
localVarDeclaration: baseType Identifier;
assign: (objectType|This'.')? Identifier AssignOperator (jNew|methodCall|expression|instVar);
jNew: 'new' Identifier '('nMethodParameters')';
methodCall: (This'.')? Identifier'('nArguments')';
statement: ifelse | localVarDeclaration | jReturn | jWhile | block;
block: '{' (statementOrStatementExpression)* '}';
statementOrStatementExpression: statement|statementExpressions;
ifelse: 'if (' expression ')' block ('else if('expression')'block)* ('else ('expression')'block)?;
jWhile: 'while ('expression ')' block;
jReturn: 'return' expression;
unary: (OpBeforeIdentifier|OpBeforeOrAfterIdentifier) Identifier | Identifier OpBeforeOrAfterIdentifier;
binary: Identifier OpInBetweenIdentifier Identifier;
baseType: JBoolean | JNull | This | JString | JCharacter | JInteger | Super;
objectType: 'int'|'char'|'boolean'|Identifier;

AccessModifier: 'public' | 'protected' | 'private';
//Modifier: 'static'|'final'; //abstract extra
JBoolean: 'true'|'false';
JNull: 'null';
Super: 'super()';
This: 'this';
JString: '"'[A-Za-z]'"'+;
Identifier: [A-Za-z]+;
JCharacter: [A-Za-z];
JInteger: [0-9]+;
AssignOperator: '='|'+='|'-=';
Comperator: '=='|'!='|'>='|'<='|'>'|'<';
OpBeforeIdentifier: '!';
OpBeforeOrAfterIdentifier: '++'|'--';
OpInBetweenIdentifier: '+'|'-'|'&&'|'||';

WS: [ \t(\r?\n)] -> skip;
Comment: ('//'[A-Za-z]* | '/*'[A-Za-z]*'*/') -> skip;


