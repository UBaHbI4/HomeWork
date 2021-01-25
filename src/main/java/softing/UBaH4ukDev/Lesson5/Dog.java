package softing.UBaH4ukDev.Lesson5;

public class Dog  extends Animal  {
    public static int countDogs;
    protected final int runLimit = 500;
    protected final int swimLimit = 10;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int lengthBlockage) {
        if (lengthBlockage < 0) {
            System.out.println("Длина препятствия не может быть меньше нуля!");
            return;
        }
        if (lengthBlockage <= runLimit) {
            System.out.println(name + " пробежал " + lengthBlockage + " м.");
        } else {
            System.out.println(name + " не может бежать больше " + runLimit + " м.");
        }
    }

    @Override
    public void swim(int lengthBlockage) {
        if (lengthBlockage < 0) {
            System.out.println("Длина препятствия не может быть меньше нуля!");
            return;
        }
        if (lengthBlockage <= swimLimit) {
            System.out.println(name + " проплыл " + lengthBlockage + " м.");
        } else {
            System.out.println(name + " не может плыть больше " + swimLimit + " м.");
        }
    }
}
