package softing.UBaH4ukDev.Lesson13;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static softing.UBaH4ukDev.Lesson13.HomeWork13.cyclicBarrier;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */
public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static int numberFinished = 1;
    private static final Lock LOCK = new ReentrantLock();

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            try{
                LOCK.lock();
                if (numberFinished == 1) {
                    System.out.println(this.name + " WIN!!!");
                } else {
                    System.out.println(this.name + " финишировал " + numberFinished + "-м");
                }
                numberFinished++;
            }
            finally {
                LOCK.unlock();
            }
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

