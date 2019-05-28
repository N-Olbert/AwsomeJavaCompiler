public class Fibonacci
{
    public BetterInt fibonacci(BetterInt n)
    {
        if (n.LessThan(new BetterInt(2)))
        {
            return n;
        }
        else
        {
            return fibonacci(n.Subtract(new BetterInt(1))).Add(fibonacci(n.Subtract(new BetterInt(2))));
        }
    }
}