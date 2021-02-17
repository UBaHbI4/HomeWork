package softing.UBaH4ukDev.Lesson13.ClassWork;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13.ClassWork

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */

import softing.UBaH4ukDev.Lesson6.Cat;

import java.util.concurrent.locks.ReentrantReadWriteLock;
public class CatExample {
    Cat cat;
    ReentrantReadWriteLock lock;

    public static void main(String[] args) {

        CatExample ce = new CatExample();
        ce.cat = new Cat("Murzik", 10);
        ce.lock = new ReentrantReadWriteLock();

        for (int i = 1; i <= 20; i++) {
            final int count = i;
            if (i % 4 == 0) new Thread(() -> ce.writeCat("Cat " + count)).start();
            else new Thread(ce::readCat).start();
        }
    }

    private void readCat() {
        try {
            lock.readLock().lock();
            System.out.println(cat.getName());
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    private void writeCat(String name) {
        try {
            lock.writeLock().lock();
            System.out.println("Changing cat");
            cat.setName(name);
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

