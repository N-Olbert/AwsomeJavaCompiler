class BetterInt
{
    public int x;

    BetterInt(int x)
    {
        this.x = x;
    }

    BetterInt()
    {
        x = 0;
    }

    public BetterInt Add(BetterInt y)
    {
        return new BetterInt(x+y.x);
    }

    public BetterInt Subtract(BetterInt y)
    {
        return new BetterInt(x-y.x);
    }

    public boolean LessThan(BetterInt y)
    {
        return x < y.x;
    }
}
