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
   ;

block
   : (labelDeclarationPart | constantDefinitionPart | typeDefinitionPart | variableDeclarationPart | procedureAndFunctionDeclarationPart | usesUnitsPart | IMPLEMENTATION)* compoundStatement
   ;

usesUnitsPart
   : USES identifierList SEMICOLON
   ;

labelDeclarationPart
   : LABEL label (COMMA label)* SEMICOLON
   ;

label
   : unsignedInteger
   ;

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
   | identifier
   | sign identifier
   | string
   | constantChr
   ;

varType
    : arrayType
    | stringR_
    | charR_
    | integerR_
    ;

arrayType
 : ARRAY L_BRACK indexRanges R_BRACK OF varType
   ;

arrayValue
   : identifier L_BRACK (integer | identifier) R_BRACK
   ;

indexRanges
   : indexRange (COMMA indexRange)*
   ;

indexRange
   : unsignedInteger DOUBLE_DOT unsignedInteger
   ;

stringR_: STRING_;
charR_: CHAR_;
integerR_: INTEGER_;

unsignedNumber
   : unsignedInteger
   ;

unsignedInteger
   : INTEGER
   ;

sign
   : PLUS
   | MINUS
   ;

bool_
   : TRUE
   | FALSE
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

type_
   : simpleType
   | arrayType
   ;

simpleType
   : scalarType
   | subrangeType
   | typeIdentifier
   | stringtype
   | constant
   ;

scalarType
   : L_PAREN identifierList R_PAREN
   ;

subrangeType
   : constant DOUBLE_DOT constant
   ;

typeIdentifier
   : identifier
   | (CHAR_ | BOOLEAN_ | INTEGER_ | STRING_)
   ;

stringtype
   : STRING L_BRACK (identifier | unsignedNumber) R_BRACK
   ;

typeList
   : indexType (COMMA indexType)*
   ;

indexType
   : simpleType
   ;

componentType
   : type_
   ;

fixedPart
   : recordSection (SEMICOLON recordSection)*
   ;

recordSection
   : identifierList COLON type_
   ;

tag
   : identifier COLON typeIdentifier
   | typeIdentifier
   ;

baseType
   : simpleType
   ;

variableDeclarationPart
   : VAR variableDeclaration (SEMICOLON variableDeclaration)* SEMICOLON
   ;

variableDeclaration
   : identifierList COLON type_
   ;

procedureAndFunctionDeclarationPart
   : procedureOrFunctionDeclaration SEMICOLON
   ;

procedureOrFunctionDeclaration
   : functionDeclaration
   ;

formalParameterList
   : L_PAREN formalParameterSection (SEMICOLON formalParameterSection)* R_PAREN
   ;

formalParameterSection
   : parameterGroup
   | VAR parameterGroup
   | FUNCTION parameterGroup
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

resultType
   : typeIdentifier
   ;

statement
   : label COLON unlabelledStatement
   | writeStatement
   | readStatement
   | unlabelledStatement
   ;

writeStatement
    : write L_PAREN (writeParam (COMMA writeParam)*)? R_PAREN
    ;


write: WRITE | WRITELN;

writeParam2
    : string
    ;

writeParam
    : varValue
    | identifier
    | arrayValue
    ;

varValue
    : string
    | boolean
    | char
    | integer
    ;

readStatement
    : read L_PAREN readParam R_PAREN;

read: READ | READLN;

readParam
    : varValue
    | identifier
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
   : expression parameterwidth*
   ;

parameterwidth
   : COLON expression
   ;

emptyStatement_
   :
   ;

structuredStatement
   : compoundStatement
   | conditionalStatement
   | repetitiveStatement
   ;

compoundStatement
   : BEGIN statements END
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
   : expression
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


NIL: 'NIL';
INTERFACE: 'INTERFACE';
UNIT: 'UNIT';
IMPLEMENTATION: 'IMPLEMENTATION';
LABEL: 'LABEL';
CONST: 'CONST';

ID: [a-zA-Z][a-zA-Z0-9_]*;

CHR: 'CHR';
TYPE: 'TYPE';
USES: 'USES';
AT: 'AT';