package softing.UBaH4ukDev.Lesson13;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */
public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
