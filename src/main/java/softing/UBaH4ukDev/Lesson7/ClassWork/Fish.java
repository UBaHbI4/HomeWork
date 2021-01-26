package softing.UBaH4ukDev.Lesson7.ClassWork;

public class Fish {

    private String type;
    private static int statInt;

    Heart h, h2, h3;
    Liver l;

    public Fish() {
        this.h = new Heart();
        this.l = new Liver();
    }

    class Heart {
        int size;

        public int getSize() {
            Fish.this.type = "kdjfng";
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    class Liver {
        int weight;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    static class NestedClass {
        static int a = 0;
        int b = 10;

        public NestedClass(int b) {
            Fish.statInt = 10;
            this.b = b;
        }

        public int getB() {
            return b;
        }
    }
}
