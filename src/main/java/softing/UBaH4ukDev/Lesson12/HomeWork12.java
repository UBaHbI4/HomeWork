package softing.UBaH4ukDev.Lesson12;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.*;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson12

 Created by Ivan Sheynmaer

 2021.02.13
 v1.0
 */
public class HomeWork12 {
    static final int SIZE = 10;//10_000_000;
    /*
        При размере массива до 20, выводится содержимое массивов, для того чтобы убедиться, что содержимое массивов одинаково
    после выполнения методов.
    **Второй метод быстрее работает, если размер массива более 70_000. При значениях меньше, первый метод отрабатывает быстрее.

    При больших размерах массива очень заметно увеличение скорости обработки через потоки
    При тесте массива с размером в 100_000_000 получилист такие результаты:
        method1 время выполнения: 138953 ms
        method2 время выполнения: 72071 ms
    почти в 2 раза быстрее

    Но при тесте массива в 10 элементов, результаты в пользу первого метода
        method1 время выполнения: 0 ms
        method2 время выполнения: 15 ms

    */
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        method1();

        try {
            method2();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    //Метод для преобразования элементов массива путем пересчета поочередно каждого элемента согласно формуле
    private static void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr,1f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("method1 время выполнения: " + (System.currentTimeMillis() - a) + " ms");

        if(arr.length < 21)  System.out.println(Arrays.toString(arr));

    }

    //Метод для преобразования элементов массива путем разбиения на два массива, паралельного пересчета
    //одновременно элементов двух массивов
    //и склейки результатов в один массив обратно
    private static void method2() throws ExecutionException, InterruptedException {
        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        Arrays.fill(arr,1f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Boolean> future1 = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                try {
                    for (int i = 0; i < HALF; i++) {
                        a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    return true;
                } catch (Exception err) {
                    System.out.println(err.getMessage());
                    return false;
                }
            }
        });

        Future<Boolean> future2 = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                try {
                    for (int i = 0; i < HALF; i++) {
                        a2[i] = (float)(a2[i] * Math.sin(0.2f + (HALF + i) / 5) * Math.cos(0.2f + (HALF + i) / 5) * Math.cos(0.4f + (HALF + i) / 2));
                    }
                    return true;
                } catch (Exception err) {
                    System.out.println(err.getMessage());
                    return false;
                }

            }
        });

        if (! (future1.get() && future2.get())) {
            System.out.println("Не удалось выполнить один из методов");
        }
        service.shutdownNow();

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("method2 время выполнения: " + (System.currentTimeMillis() - a) + " ms");

        if(arr.length < 21)  System.out.println(Arrays.toString(arr));
    }
}