class TestwithIfElseIf {
    int TestIfElseIf(int x, int y) {
        int t=-1;
        if (x>y) {
            t=x;
        }
        else if (x==y) {
            return y;
        }
        return t;
    }
}