package astgenerator.generalelements;

import astgenerator.statements.Block;

public class MainMethodDeclaration {

    private Block statement;

    public MainMethodDeclaration(Block statement){
        this.statement = statement;
    }

    public Block getStatement() {
        return statement;
    }
}
