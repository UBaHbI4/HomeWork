package softing.UBaH4ukDev.Lesson7;

public enum Operator {
    SUM {
        public int operation(int x, int y) {return x + y;}
    },
    MULTIPLY {
        public int operation(int x, int y) {return x * y;}
    };

    public abstract int operation(int x, int y);
}

