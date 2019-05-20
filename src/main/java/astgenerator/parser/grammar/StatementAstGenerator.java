package astgenerator.parser.grammar;

import astgenerator.expressions.*;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.*;
import common.Operators;

public class StatementAstGenerator {
    public Statement generate(awsomeJavaParser.StatementContext statementContext){
        if(statementContext.ifelse() != null){
            //TODO
        }else if(statementContext.localVarDeclaration() != null){
//            statement = new LocalVarDeclaration();
        }else if(statementContext.jReturn() != null){
            awsomeJavaParser.JReturnContext jReturnContext = statementContext.jReturn();

        }else if(statementContext.jWhile() != null){
            awsomeJavaParser.JWhileContext jWhileContext = statementContext.jWhile();
            if (jWhileContext.expression() != null){
                awsomeJavaParser.ExpressionContext expressionContext = jWhileContext.expression();
                expressionCon(expressionContext);
            }
            if(jWhileContext.block() != null){
                awsomeJavaParser.BlockContext blockContext = jWhileContext.block();
                blockCon(blockContext);
            }
        }else if(statementContext.block() != null){
            awsomeJavaParser.BlockContext blockContext = statementContext.block();
            blockCon(blockContext);
        }
        return null;
    }

    public Expression expressionCon(awsomeJavaParser.ExpressionContext expressionContext){
        if(expressionContext.basicexpressions() != null){
            return basicExpressionCon(expressionContext.basicexpressions());
        }else if(expressionContext.binary() != null){
            return binaryCon(expressionContext.binary());
        }
        return null;

        /*if(expressionContext.baseType() != null){
            awsomeJavaParser.BaseTypeContext baseTypeContext = expressionContext.baseType();
            return baseTypeCon(baseTypeContext);
        }else if(expressionContext.instVar() != null){
            awsomeJavaParser.InstVarContext instVarContext = expressionContext.instVar();
            instVarCon(instVarContext);
        }else if(expressionContext.Identifier() != null){
            return new JInteger(expressionContext.Identifier().getText());
        }else if(expressionContext.binary() != null){
            awsomeJavaParser.BinaryContext binaryContext = expressionContext.binary();
            binaryCon(binaryContext);
        }else if(expressionContext.unary() != null){
            awsomeJavaParser.UnaryContext unaryContext = expressionContext.unary();
            unaryCon(unaryContext);
        }
        return null;*/
    }

    public Expression basicExpressionCon(awsomeJavaParser.BasicexpressionsContext basicexpressionsContext){
        if(basicexpressionsContext.expression() != null){
            return expressionCon(basicexpressionsContext.expression());
        }else if(basicexpressionsContext.baseType() != null){
            baseTypeCon(basicexpressionsContext.baseType());
        }else if(basicexpressionsContext.instVar() != null){
            instVarCon(basicexpressionsContext.instVar());
        }else if(basicexpressionsContext.Identifier() != null){
            //TODO
            return new JInteger(basicexpressionsContext.Identifier().getText());
        }else if(basicexpressionsContext.unary() != null){
            unaryCon(basicexpressionsContext.unary());
        }
        return null;
    }

    public Block blockCon(awsomeJavaParser.BlockContext blockContext){
        //TODO
        blockContext.statementOrStatementExpression();
        return null;
    }

    public Expression baseTypeCon(awsomeJavaParser.BaseTypeContext baseTypeContext){
        if(baseTypeContext.JBoolean() != null){
            return new JBoolean(baseTypeContext.JBoolean().getText());
        }else if(baseTypeContext.JNull() != null){
            return new JNull();
        }else if(baseTypeContext.This() != null){
            return new This();
        }else if(baseTypeContext.JString() != null){
            return new JString(baseTypeContext.JString().getText());
        }else if(baseTypeContext.JCharacter() != null){
            return new JCharacter(baseTypeContext.JCharacter().getText());
        }else if(baseTypeContext.JInteger() != null){
            return new JInteger(baseTypeContext.JInteger().getText());
        }else if(baseTypeContext.Super() != null){
            return new Super();
        }
        return null;
    }

    public Statement instVarCon(awsomeJavaParser.InstVarContext instVarContext){
        if(instVarContext.This() != null && instVarContext.Identifier(0) != null
                && instVarContext.Identifier().size() >= 0
                && instVarContext.Identifier(1) != null){
            //return new InstVar();
        }
        return null;
    }

    public Binary binaryCon(awsomeJavaParser.BinaryContext binaryContext){
        if(binaryContext.binaryelement(0) != null){
            //linke Seite wird gesetzt



        }else if(binaryContext.pointBinary() != null){
            //rechte Seite wird gesetzt
            //pointBinaryCon(binaryContext.pointBinary());
        }

        return null;

        /*// TODO
        Operators operators = null;
        switch (binaryContext.OpInBetweenIdentifier().getText()){
            case "+":
                operators = Operators.PLUS;
                break;
            case "-":
                operators = Operators.MINUS;
                break;
            *//*case "*":
                operators = Operators.MULTIPLICATION;
                break;
            case "/":
                operators = Operators.DIVISION;
                break;
            case "%":
                operators = Operators.MODULO;
                break;
            case "!":
                operators = Operators.NEGATION;
                break;*//*
            case "&&":
                operators = Operators.AND;
                break;
            case "||":
                operators = Operators.OR;
                break;
            *//*case "^":
                operators = Operators.XOR;
                break;
            case ">":
                operators = Operators.GREATERTHAN;
                break;
            case ">=":
                operators = Operators.GREATEROREQUAL;
                break;
            case "<":
                operators = Operators.LESSTHAN;
                break;
            case "<=":
                operators = Operators.LESSOREQUAL;
                break;
            case "==":
                operators = Operators.EQUALS;
                break;
            case "!=":
                operators = Operators.NOTEQUALS;
                break;*//*
        }*/

        /*return new Binary(new LocalOrFieldVar(binaryContext.Identifier(1).getText()),
                new LocalOrFieldVar(binaryContext.Identifier(0).getText()),
                operators);*/
    }

    public Unary unaryCon(awsomeJavaParser.UnaryContext unaryContext){
        if(unaryContext.operatorBeforeExpr()!=null){
            awsomeJavaParser.OperatorBeforeExprContext operatorBeforeExprContext = unaryContext.operatorBeforeExpr();
            return operatorBeforeExprCon(operatorBeforeExprContext);
        }else if(unaryContext.operatorAfterExpr() != null){
            awsomeJavaParser.OperatorAfterExprContext operatorAfterExprContext = unaryContext.operatorAfterExpr();
            return operatorAfterExprCon(operatorAfterExprContext);
        }
        return null;
    }

    public Unary operatorBeforeExprCon(awsomeJavaParser.OperatorBeforeExprContext operatorBeforeExprContext){
        if(operatorBeforeExprContext.opBeforeIdentifier().OpBeforeIdentifier().getText().equals("!")) {
            return new Unary(new LocalOrFieldVar(operatorBeforeExprContext.opBeforeIdentifier().getText()),
                    Operators.NEGATION);
        }/*else if() {

            operatorBeforeExprContext.opBeforeIdentifier().OpBeforeOrAfterIdentifier().getParent().getText()

            return new Unary(new LocalOrFieldVar(operatorBeforeExprContext.Identifier().getText()),
                    Operators.NEGATION);
        }*/else if(operatorBeforeExprContext.opBeforeIdentifier().getText().equals("++")){

        }
        //TODO
        return new Unary(new LocalOrFieldVar(operatorBeforeExprContext.Identifier().getText()),
                opIdentifierCon(operatorBeforeExprContext.opBeforeIdentifier()));
    }

    public Operators opIdentifierCon(awsomeJavaParser.OpBeforeIdentifierContext opIdentifierContext){
        if(opIdentifierContext.OpBeforeIdentifier() != null){
            if(opIdentifierContext.OpBeforeIdentifier().getText().equals("!")){
                return Operators.NEGATION;
            }
        }else if(opIdentifierContext.OpBeforeOrAfterIdentifier() != null){
            if(opIdentifierContext.OpBeforeOrAfterIdentifier().getText().equals("++")){
                return null;//TODO
            }else if(opIdentifierContext.OpBeforeIdentifier().getText().equals("--")){
                return null;//TODO
            }
        }
        return null;
    }

    public Unary operatorAfterExprCon(awsomeJavaParser.OperatorAfterExprContext operatorAfterExprContext){
        return null;//new Unary(new LocalOrFieldVar(operatorAfterExprContext.Identifier().getText()),OpBeforeOrAfterIdentifierCon(operatorAfterExprContext.OpBeforeOrAfterIdentifier().getText()));
    }

   /* private  OpBeforeOrAfterIdentifierCon(String opBeforeOrAfterIdentifierContext) {
        Operators operators = null;
        switch (opBeforeOrAfterIdentifierContext){
            case "++":

                break;
            case "-":
                break;
        return new Operators(OpBeforeOrAfterIdentifierContext);
    }*/
}
