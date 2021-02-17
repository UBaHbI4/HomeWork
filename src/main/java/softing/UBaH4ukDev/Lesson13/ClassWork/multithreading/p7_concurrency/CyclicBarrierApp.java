package softing.UBaH4ukDev.Lesson13.ClassWork.multithreading.p7_concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT + 1);
        for (int i = 0; i < THREADS_COUNT; i++) {
            int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Подготавливается " + w);
                    Thread.sleep(2000 + 500 * (int) (Math.random() * 10));
                    System.out.println("Готов " + w);
                    cyclicBarrier.await();
                    System.out.println("Поехал " + w);
                    cyclicBarrier.await();
//                    System.out.println("Гонка закончилась");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            Thread.sleep(10000);
            System.out.println("НАЧАЛО ГОНКИ!");
            cyclicBarrier.await();
            cyclicBarrier.await();
            System.out.println("Гонка закончилась");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
