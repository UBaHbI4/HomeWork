package softing.UBaH4ukDev.Lesson13.ClassWork;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13.ClassWork

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */
public class Volatile {
    volatile Integer a = 0;

    public static void main(String[] args) {

        Volatile v = new Volatile();
        new Thread(() -> {
            for (int i = 0; i < 100_000_000; i++) {
                System.out.println(v.a);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100_000_000; i++) {
                v.a = v.a + 1;
            }
        }).start();
    }
}

