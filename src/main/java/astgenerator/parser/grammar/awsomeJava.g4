grammar awsomeJava;

programm: jClass+;
jClass: AccessModifier? 'class' LocalOrFieldVar classBody; //Modifier
constructor: AccessModifier? LocalOrFieldVar'('nMethodParameters')' block;
classBody: '{'(methodDeclaration|fieldDeclaration)* constructor (methodDeclaration|fieldDeclaration)*'}';
methodDeclaration: AccessModifier? objectType LocalOrFieldVar '('nMethodParameters')' block;
fieldDeclaration: AccessModifier?  objectType LocalOrFieldVar';';
methodParameter: objectType LocalOrFieldVar;
nMethodParameters: (methodParameter)? | methodParameter (','methodParameter)+;
nArguments: expression? | expression (',' expression)* | instVar;
instVar:  This '.' LocalOrFieldVar|(LocalOrFieldVar '.')+ LocalOrFieldVar;
expression: (baseType | instVar | LocalOrFieldVar | binary | unary ); //comparison
statementExpressions: (assign | jNew | methodCall)';';
localVarDeclaration: baseType LocalOrFieldVar;
assign: (objectType|This'.')? LocalOrFieldVar AssignOperator (jNew|methodCall|expression|instVar);
jNew: 'new' LocalOrFieldVar '('nMethodParameters')';
methodCall: (This'.')? LocalOrFieldVar'('nArguments')';
statement: ifelse | localVarDeclaration | jReturn | jWhile | block;
block: '{' (statement|statementExpressions)* '}';
ifelse: 'if (' expression ')' block ('else if('expression')'block)* ('else ('expression')'block)?;
jWhile: 'while ('expression ')' block;
jReturn: 'return' expression;
unary: (OpBeforeIdentifier|OpBeforeOrAfterIdentifier) LocalOrFieldVar | LocalOrFieldVar OpBeforeOrAfterIdentifier;
binary: LocalOrFieldVar OpInBetweenIdentifier LocalOrFieldVar;
baseType: JBoolean | JNull | This | JString | JCharacter | JInteger | Super;
objectType: 'int'|'char'|'boolean'|LocalOrFieldVar;

AccessModifier: 'public' | 'protected' | 'private';
//Modifier: 'static'|'final'; //abstract extra
JBoolean: 'true'|'false';
JNull: 'null';
Super: 'super()';
This: 'this';
JString: '"'[A-Za-z]'"'+;
LocalOrFieldVar: [A-Za-z]+;
JCharacter: [A-Za-z];
JInteger: [0-9]+;
AssignOperator: '='|'+='|'-=';
Comperator: '=='|'!='|'>='|'<='|'>'|'<';
OpBeforeIdentifier: '!';
OpBeforeOrAfterIdentifier: '++'|'--';
OpInBetweenIdentifier: '+'|'-'|'&&'|'||';

WS: [ \t(\r?\n)] -> skip;
Comment: ('//'[A-Za-z]* | '/*'[A-Za-z]*'*/') -> skip;


