public class Fibonacci
{
    int fibonacci(int n)
    {
        if(n <2)
        {
            return 1;
        }
        else
        {
            int a=0;
            int b=1;
            int i=3;
            int temp;
            while(i<= n)
            {
                temp=b;
                b=a+b;
                a=temp;
                i = i + 1;
            }

            return a + b;
        }
    }
}