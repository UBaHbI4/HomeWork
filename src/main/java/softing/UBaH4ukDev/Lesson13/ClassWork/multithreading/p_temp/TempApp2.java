package softing.UBaH4ukDev.Lesson13.ClassWork.multithreading.p_temp;

import java.util.concurrent.*;

public class TempApp2 {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(4);

//        Future<String> f = service.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(3000);
//                if (10 < 20) {
//                    throw new RuntimeException("AAAAA!!!");
//                }
//                return "Java";
//            }
//        });
//
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return "A";
            }
        });
        new Thread(ft).start();
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        service.shutdown();
//
//        try {
//            System.out.println("main> " + f.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
}
