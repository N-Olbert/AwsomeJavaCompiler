package astgenerator.parser.astgen;

import astgenerator.expressions.Expression;
import astgenerator.parser.generated.awsomeJavaParser;
import astgenerator.statements.Block;
import astgenerator.statements.IfElse;

import java.util.List;

public class IfElseGenerator {

    static IfElse generate(awsomeJavaParser.IfelseContext ifelseContext){
        Expression condition = ExpressionGenerator.generate(ifelseContext.jIf().expression());
        Block block = BlockGenerator.generate(ifelseContext.jIf().block());

        if (ifelseContext.jElseIf() == null && ifelseContext.jElse() == null){
            return new IfElse(condition,block);
        } else if (ifelseContext.jElseIf() == null && ifelseContext.jElse() != null){
            return new IfElse(condition,block,BlockGenerator.generate(ifelseContext.jElse().block()));
        } else {
            Block elseIfElse;

            if (ifelseContext.jElse() != null) {
                elseIfElse = handleElseIf(ifelseContext.jElseIf(),
                        BlockGenerator.generate(ifelseContext.jElse().block()), 0);
            } else {
                elseIfElse = handleElseIf(ifelseContext.jElseIf(), null, 0);
            }

            return new IfElse(condition,block,elseIfElse);
        }
    }

    private static Block handleElseIf(List<awsomeJavaParser.JElseIfContext> elseIfs, Block elseBlock, int position){
        if (position == elseIfs.size()-1){
            if (elseBlock == null)
                return new Block(new IfElse(ExpressionGenerator.generate(elseIfs.get(position).expression()),
                        BlockGenerator.generate(elseIfs.get(position).block())));

            return new Block(new IfElse(ExpressionGenerator.generate(elseIfs.get(position).expression()),
                    BlockGenerator.generate(elseIfs.get(position).block())),
                    elseBlock);
        } else {
            return new Block(new IfElse(ExpressionGenerator.generate(elseIfs.get(position).expression()),
                    BlockGenerator.generate(elseIfs.get(position).block()),
                    handleElseIf(elseIfs,elseBlock,position+1)));
        }
    }

}
