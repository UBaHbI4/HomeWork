package softing.UBaH4ukDev.Lesson13.ClassWork.multithreading.p6_locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLocksApp {
    public static void main(String[] args) {

        //1. Читать одновременно могут много потоков
        //2. Писать только один одновременно
        //3. Во время записи чтение не происходит
        //4.
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-a");
                Thread.sleep(3000);
                System.out.println("READING-end-a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-b");
                Thread.sleep(5000);
                System.out.println("READING-end-b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-c");
                Thread.sleep(3000);
                System.out.println("READING-end-c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                rwl.readLock().lock();
                System.out.println("READING-start-d");
                Thread.sleep(3000);
                System.out.println("READING-end-d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.writeLock().lock();
                System.out.println("WRITING-start-a");
                Thread.sleep(3000);
                System.out.println("WRITING-end-a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.writeLock().lock();
                System.out.println("WRITING-start-b");
                Thread.sleep(3000);
                System.out.println("WRITING-end-b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }).start();
    }
}
