package softing.UBaH4ukDev.Lesson7.ClassWork;

@FunctionalInterface
public interface Swimming {
    interface Diving {
        interface DeepDiving {

        }
    }

    int A = 10;

    void swim(int length);

    default void doSomething(int x, int y) {
        System.out.println(x * y);
        //doSomethingElse();
    }

    static void doStatic() {
        System.out.println("From static!");
    }

//    private void doSomethingElse() {
//        System.out.println("lkjfsdljkdfng");
//    }

}