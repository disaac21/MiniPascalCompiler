grammar MiniPascalGrammar;

options { caseInsensitive = true; }

program
   : programHeading (INTERFACE)? block DOT EOF
   ;

programHeading
   : PROGRAM identifier (L_PAREN identifierList R_PAREN)? SEMICOLON
   | UNIT identifier SEMICOLON
   ;

identifier
   : ID
//   | '"' ID '"' {notifyErrorListeners("Error léxico: Para asignar cadenas se deben usar comillas simples ' cadena ' ");}
   ;

block
   : ( constantDefinitionPart | typeDefinitionPart | variableDeclarationPart | procedureAndFunctionDeclarationPart | IMPLEMENTATION )* compoundStatement
   ;

//usesUnitsPart
//   : USES identifierList SEMICOLON
//   ;

//labelDeclarationPart
//   : LABEL label (COMMA label)* SEMICOLON
//   ;
//
//label
//   : unsignedInteger
//   ;

constantDefinitionPart
   : CONST (constantDefinition SEMICOLON)+
   ;

constantDefinition
   : identifier EQUAL constant
   ;

constantChr
   : CHR L_PAREN unsignedInteger R_PAREN
   ;

constant
   : unsignedNumber
   | sign unsignedNumber
//   | identifier
   | sign identifier
   | string
   | constantChr
   | varType
   | char
   | boolean
   ;

varType
    : arrayType
    | arrayOfType
    | stringR_
    | charR_
    | integerR_
    | booleanR_
    ;

arrayType
   : ARRAY L_BRACK indexRanges R_BRACK OF (integerR_ | booleanR_ | charR_ )
   ;

arrayOfType
   : ARRAY OF varType
   ;


arrayValue
   : identifier L_BRACK expressionList R_BRACK
   ;

indexRanges
   : indexRange (COMMA indexRange)?
   ;

indexRange
   : unsignedInteger DOUBLE_DOT unsignedInteger
   ;

stringR_: STRING_;
charR_: CHAR_;
integerR_: INTEGER_;
booleanR_: BOOLEAN_;

unsignedNumber: unsignedInteger;

unsignedInteger: INTEGER;

sign
   : PLUS
   | MINUS
   ;

bool_
   : BOOLEAN_
   ;

string
   : STRING
   ;

boolean
    : BOOLEAN
    ;

char
    : CHAR
    ;

integer
    : INTEGER
    ;

typeDefinitionPart
   : TYPE (typeDefinition SEMICOLON)+
   ;

typeDefinition
   : identifier EQUAL (type_ | functionType)
   ;

functionType
   : FUNCTION (formalParameterList)? COLON varType
   ;

//procedureType
//   : PROCEDURE (formalParameterList)? COLON varType
//   ;

type_
   : simpleType
   | arrayType
   ;

simpleType
//   : scalarType
   : subrangeType
   | typeIdentifier
   | stringtype
   | constant
   ;

//scalarType
//   : L_PAREN identifierList R_PAREN
//   ;

subrangeType
   : constant DOUBLE_DOT constant
   ;

typeIdentifier
//   : identifier
   : (CHAR_ | BOOLEAN_ | INTEGER_ | STRING_)
   ;

stringtype
   : STRING L_BRACK (identifier | unsignedNumber) R_BRACK
   ;

//typeList
//   : indexType (COMMA indexType)*
//   ;

//indexType
//   : simpleType
//   ;

//componentType
//   : type_
//   ;
//
//fixedPart
//   : recordSection (SEMICOLON recordSection)*
//   ;
//
//recordSection
//   : identifierList COLON type_
//   ;

//tag
//   : identifier COLON typeIdentifier
//   | typeIdentifier
//   ;
//
//baseType
//   : simpleType
//   ;

variableDeclarationPart
   : VAR variableDeclaration (SEMICOLON variableDeclaration)* SEMICOLON
   ;

variableDeclaration
   : identifierList COLON (typeIdentifier | arrayType) (EQUAL initialValue)?
   ;

procedureAndFunctionDeclarationPart
   : procedureOrFunctionDeclaration SEMICOLON
   ;

procedureOrFunctionDeclaration
   : functionDeclaration
   | procedureDeclaration
   ;

formalParameterList
   : L_PAREN formalParameterSection (SEMICOLON formalParameterSection)* R_PAREN
   ;

formalParameterSection
   : parameterGroup
   | VAR parameterGroup
   | FUNCTION parameterGroup
//    | PROCEDURE parameterGroup
   ;

parameterGroup
   : identifierList COLON varType
   | emptyStatement_
   ;

identifierList
   : identifier (COMMA identifier)*
   ;

constList
   : constant (COMMA constant)*
   ;

functionDeclaration
   : FUNCTION identifier formalParameterList COLON varType SEMICOLON block
   ;

procedureDeclaration
   : PROCEDURE identifier formalParameterList SEMICOLON block
   ;

//resultType
//   : typeIdentifier
//   ;

statement
   : unsignedInteger COLON unlabelledStatement
   | writeStatement
   | readStatement
   | unlabelledStatement
   | functionDesignator
   | procedureOrFunctionDeclaration
   ;

writeStatement
    : write L_PAREN (emptyStatement_ | (string (COMMA identifier)?)?)? R_PAREN
    ;

write: WRITE | WRITELN;

//writeParam
//    : readWriteVarValue
//    | identifier
//    | arrayValue
//    | functionDesignator
//    ;
//
//varValue
//    : string
//    | boolean
//    | char
//    | integer
//    ;

readWriteVarValue
    : string
    | char
    | integer
    ;

readStatement
    : read L_PAREN readParam R_PAREN;

read: READ | READLN;

readParam
//    : readWriteVarValue
    : identifier
//    | arrayValue
    ;

unlabelledStatement
   : simpleStatement
   | structuredStatement
   ;

simpleStatement
   : assignmentStatement
   | emptyStatement_
   ;

assignmentStatement
   : variable ASSIGN expression
   ;

variable
   : (AT identifier | identifier) (L_BRACK expressionList R_BRACK | DOT identifier)*
   ;

expressionList
   : expression (COMMA expression)*
   ;

expression
   : simpleExpression (relationaloperator expression)?
   ;

relationaloperator
   : EQUAL
   | NOT_EQUAL
   | LT
   | LE
   | GE
   | GT
   ;

simpleExpression
   : term (additiveoperator simpleExpression)?
   ;

additiveoperator
   : PLUS
   | MINUS
   | OR
   | AND
   ;

term
   : signedFactor (multiplicativeoperator term)?
   ;

multiplicativeoperator
   : MULT
   | DIV
   | MOD
   ;

signedFactor
   : (PLUS | MINUS)? factor
   ;

factor
   : variable
   | L_PAREN expression R_PAREN
   | functionDesignator
   | unsignedConstant
   | set_
   | NOT factor
   | bool_
   | char
   | boolean
   ;

unsignedConstant
   : unsignedNumber
   | constantChr
   | string
   | NIL
   ;

functionDesignator
   : identifier L_PAREN parameterList R_PAREN
   ;

parameterList
   : actualParameter (COMMA actualParameter)*
   ;

set_
   : L_BRACK elementList R_BRACK
   ;

elementList
   : element (COMMA element)*
   ;

element
   : expression (DOUBLE_DOT expression)?
   ;

actualParameter
//   : expression parameterwidth*
   : expression
   ;

// a:10 que nos dice el length de la variable
//parameterwidth
//   : COLON expression
//   ;

emptyStatement_
   :
   ;

structuredStatement
   : compoundStatement
   | conditionalStatement
   | repetitiveStatement
   ;

compoundStatement
   : BEGIN statements SEMICOLON END
//   | BEGIN (statement | compoundStatement) END
//   | procedureOrFunctionDeclaration
   ;

statements
   : statement (SEMICOLON statement)*
   ;

conditionalStatement
   : ifStatement
   ;

ifStatement
   : IF expression THEN statement (ELSE statement)?
   ;

repetitiveStatement
   : whileStatement
   | repeatStatement
   | forStatement
   ;

whileStatement
   : WHILE expression DO statement
   ;

repeatStatement
   : REPEAT statements UNTIL expression
   ;

forStatement
   : FOR identifier ASSIGN forList DO statement
   ;

forList
   : initialValue (TO | DOWNTO) finalValue
   ;

initialValue
   : arrayInitialization
   | constant
   | identifier
//   | expression // puede ser cualquiera de los dos
   ;

arrayInitialization
   : L_PAREN constList R_PAREN
   ;


finalValue
   : expression
   ;

// Tokens and Lexer Rules

BEGIN: 'begin';
END: 'end';

WS: [ \t\n\r] -> skip;
COMMENT: '{' .*? '}' -> skip;

INTEGER: [0-9]+;
BOOLEAN: 'true' | 'false';
CHAR: '\'' ('\'\'' | ~('\''))? '\'';
STRING: '\'' ('\'\'' | ~('\''))* '\'';

ASSIGN: ':=';
PLUS: '+';
MINUS: '-';
DIV: 'div' | '/';
MULT: '*';
MOD: 'mod';
AND: 'and';
NOT: 'not';
OR: 'or';

GT: '>';
LT: '<';
LE: '<=';
GE: '>=';
EQUAL: '=';
NOT_EQUAL: '<>';

L_PAREN: '(';
R_PAREN: ')';
L_BRACK: '[';
R_BRACK: ']';
COMMA: ',';
SEMICOLON: ';';
COLON: ':';
DOT: '.';
DOUBLE_DOT: '..';

PROGRAM: 'program';
FUNCTION: 'function';
PROCEDURE: 'procedure';

IF: 'if';
THEN: 'then';
ELSE: 'else';
UNTIL: 'until';
WHILE: 'while';
FOR: 'for';
REPEAT: 'repeat';
TO: 'to';
DO: 'do';
DOWNTO: 'downto';
VAR: 'var';
//OVERLOAD: 'overload';

ARRAY: 'Array';
OF: 'of';

INTEGER_: 'INTEGER';
BOOLEAN_: 'BOOLEAN';
CHAR_: 'CHAR';
STRING_: 'STRING';

READLN: 'READLN';
READ: 'READ';
WRITELN: 'WRITELN';
WRITE: 'WRITE';


//NIL: 'NIL';
//INTERFACE: 'INTERFACE';
//UNIT: 'UNIT';
IMPLEMENTATION: 'IMPLEMENTATION';
//LABEL: 'LABEL';
CONST: 'CONST';

ID: [a-zA-Z_] [a-zA-Z0-9_]*; //warning porque es case insensitive, para quitar solo hay que quitar el range de mayusculas

CHR: 'CHR';
TYPE: 'TYPE';
//USES: 'USES';
AT: 'AT';