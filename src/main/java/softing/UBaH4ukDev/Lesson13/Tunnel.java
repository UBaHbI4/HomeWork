package softing.UBaH4ukDev.Lesson13;

import java.util.concurrent.Semaphore;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */
public class Tunnel extends Stage {
    private final static Semaphore SEMAPHORE = new Semaphore(HomeWork13.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                SEMAPHORE.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                SEMAPHORE.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

