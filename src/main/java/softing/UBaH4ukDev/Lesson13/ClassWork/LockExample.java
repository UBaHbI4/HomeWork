package softing.UBaH4ukDev.Lesson13.ClassWork;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13.ClassWork

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class LockExample {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        new Thread(() -> {
            System.out.println("Before lock - 1");

            try {
                lock.lock();
                System.out.println("Got lock 1");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End 1");
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.println("Before lock - 2");

            try {
                if (lock.tryLock(6, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Got lock 2");
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("End 2");
                        lock.unlock();
                    }
                } else {
                    System.out.println("Else");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        }).start();
    }
}

