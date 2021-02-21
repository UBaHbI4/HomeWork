package softing.UBaH4ukDev.Lesson13;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */
public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}