grammar awsomeJava;

programm: jClass+;
jClass: AccessModifier? 'class' Identifier classBody; //Modifier
constructor: AccessModifier? Identifier'('nMethodParameters')' block;
classBody: '{'(methodDeclaration|fieldDeclaration)* constructor (methodDeclaration|fieldDeclaration)*'}';
methodDeclaration: AccessModifier? objectType Identifier '('nMethodParameters')' block;
fieldDeclaration: AccessModifier?  objectType Identifier;
methodParameter: objectType Identifier;
nMethodParameters: (methodParameter)? | methodParameter (','methodParameter)+;
nArguments: expression? | expression (',' expression)* | instVar;
localOrFieldVar: objectType Identifier;
instVar: (Identifier '.')+ Identifier | jThis;
expression: (baseType | instVar | localOrFieldVar | binary | unary ); //comparison
statementExpressions: (assign | jNew | methodCall)';';
assign: (objectType)? Identifier '=' (jNew|methodCall) | Identifier AssignOperator expression
| Identifier AssignOperator instVar;
jNew: 'new' Identifier '('nMethodParameters')';
methodCall: Identifier'('nArguments');';
statement: block | ifelse | localOrFieldVarDeclaration | jReturn | jWhile;
block: '{' (statement|statementExpressions)* '}';
ifelse: 'if (' expression ')' block ('else if('expression')'block)* ('else ('expression')'block)?;
jWhile: 'while ('expression ')' block;
jReturn: 'return' expression ';';
localOrFieldVarDeclaration: localOrFieldVar '=' expression | Identifier '=' expression;
unary: (OpBeforeIdentifier|OpBeforeOrAfterIdentifier) Identifier | Identifier OpBeforeOrAfterIdentifier;
binary: Identifier OpInBetweenIdentifier Identifier;
baseType: JBoolean | JNull | This | JString | JCharacter | JInteger | Super | This;
objectType: 'int'|'char'|'boolean'|Identifier;
jThis: 'this''.'expression;

AccessModifier: 'public' | 'protected' | 'private';
//Modifier: 'static'|'final'; //abstract extra
JBoolean: 'true'|'false';
JNull: 'null';
Super: 'super()';
Semicolon: ';';
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
Comment: ('\\'[A-Za-z]* | '/*'[A-Za-z]*'*/') -> skip;


