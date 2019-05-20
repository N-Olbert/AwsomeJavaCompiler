public class BetterInt
{
    public int x;

    public BetterInt(int x)
    {
        this.x = x;
    }

    public BetterInt()
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

    public BetterInt Multiply(BetterInt y)
    {
        return new BetterInt(x*y.x);
    }

    public BetterInt Divide(BetterInt y)
    {
        return new BetterInt(x/y.x);
    }

    public boolean GreaterThan(BetterInt y)
    {
        return x > y.x;
    }

    public boolean LessThan(BetterInt y)
    {
        return x < y.x;
    }

}
