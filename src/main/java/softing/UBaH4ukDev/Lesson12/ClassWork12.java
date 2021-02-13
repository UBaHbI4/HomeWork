package softing.UBaH4ukDev.Lesson12;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson12

 Created by Ivan Sheynmaer

 2021.02.13
 v1.0
 */

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassWork12 {
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int f = 0;
    static final Object monitor = new Object(); //POJO -> Plain Old Java Object
    static final String monitor2 = new String();

    public static void main(String[] args) throws Exception {
        //threadsExample();
        //interruptExample();
        //executorsExample();
        //executorsExample2();
        //scannerExample();
        //deadLock();
        //daemonExample();
        FutureTaskExample();
    }

    private static void FutureTaskExample() throws InterruptedException, ExecutionException {
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Hello from Callable";
            }
        });

        System.out.println("Start");
        ft.run();
        System.out.println("Test1");
        System.out.println(ft.get());
        System.out.println("Test2");
        System.out.println("End");
    }

    private static void executorsExample2() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Результат из потока";
            }
        });
//
//        System.out.println("Start");
        System.out.println(future.get());
        service.shutdownNow();
//        System.out.println("Выполнение завершено");
    }

    private static void executorsExample() throws InterruptedException {
        //        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
//        scheduledExecutorService.schedule(new MyRunnable(), 10, TimeUnit.MINUTES);

        //Фиксированное число потоков, в данном примере 4. По освобождению одного из четырех потоков, в него снова закидывается новая задача.
        ExecutorService service = Executors.newFixedThreadPool(4, (r) -> {
            Thread t = new Thread(r);
            t.setName("Factory thread" + (int)(Math.random()*50) );
            return t;
        });

        for (int i = 0; i < 10; i++) {
            service.execute(new MyThread());
        }
        for (int i = 0; i < 10; i++) {
            service.execute(new MyRunnable());
        }

        Thread.sleep(1000);
        service.shutdownNow();
    }

    //Демон завершается сам, когда завершаются все неДемоны и основной поток
    private static void daemonExample() throws InterruptedException {
        Thread daemon = new Thread(() -> {
            int c = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("warn " + ++c);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();
        daemon.join(5000);
        System.out.println("Hello from main");
    }

    private static void deadLock() {
        Runnable r = ClassWork12::increment;
        Runnable r2 = ClassWork12::decrement;
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r2).start();
    }

    static void increment() {
        synchronized (monitor) {
            for (int i = 0; i < 1000_000; i++) {
                a = a + 1;
                b = b + 1;
                c = c + 1;
            }
            decrement();
            System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
        }

    }

    static void decrement() {
        synchronized (monitor2) {
            for (int i = 0; i < 1000_000; i++) {
                d = d - 1;
                e = e - 1;
                f = f - 1;
            }
            increment();
            System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
        }
    }

    private static void scannerExample() {
        final Scanner sc = new Scanner(System.in);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1500);
                    System.out.println("Bang!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                String s = sc.nextLine();
                System.out.println("Echo " + s);
            }
        }).start();
    }

    private static void interruptExample() {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("tick");
                    Thread.sleep(1500);
                    //if (Thread.currentThread().isInterrupted()) return;
                    System.out.println("tock");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Завершение потока");
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершаем поток");
        t.interrupt();
    }

    private static void threadsExample() {
        //MyThread extends Thread
        MyThread t = new MyThread("Суперпоток");
        t.start();

        //MyRunnable implements Runnable
        Thread r = new Thread(new MyRunnable());
        r.start();

        new Thread(() -> System.out.println("Hello from anonymous thread #" + Thread.currentThread().getName()), "Anonymous").start();

        System.out.println("Привет из потока thread #" + Thread.currentThread().getName());
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Привет из Runnable thread #" + Thread.currentThread().getName());
        }
    }

    static class MyThread extends Thread {
        public MyThread() {
        }

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Привет из потока thread #" + Thread.currentThread().getName());
        }
    }
}

