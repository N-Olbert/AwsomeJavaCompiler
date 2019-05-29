Class Cl1 {
    char m1() {
        int b;
        Cl2 x = new Cl2();
        return x.m2(x.v, b);
    }
}

Class Cl2 {
    Cl3 v;
    char m2(Cl3 v, int w) {
        return v.y;
    }
}

Class Cl3 {
    char y;
}