class TestASTBinary{
    int a,b,c;
    public void punktVorStrich()
    {
        int result = a + b * c;
    }

    public void StrichVorPunktMitKlammer()
    {
        int result = (a + b) * c;
    }

    public void punktVorStrichMitGeteilt()
    {
        int result = a + b / c;
    }

    public void andVorOr()
    {
        boolean result = a || b && c;
    }

    public void binaryTest() { boolean result = a == b && !c; }

    public void fancyShit()
    {
        int result = (a % b) + b * c && a;
    }
}