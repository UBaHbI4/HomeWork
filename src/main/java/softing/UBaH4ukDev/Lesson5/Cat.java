package softing.UBaH4ukDev.Lesson5;

public class Cat extends Animal {
    public static int countCats;
    protected final int runLimit = 200;

    public Cat(String name) {
        super(name);
        countCats++;
    }

    /*
    У меня получилось, что в классе Dog и Cat дублируется следующий код:
            if (lengthBlockage < 0) {
            System.out.println("Длина препятствия не может быть меньше нуля!");
            return;
        }
        Можно ли этот код реализовать в классе Animal (соответственно сделать класс не абстрактным)?
        Но тогда, нужно уметь как-то выходить из методов в классе Dog и Cat, если длина отрицательная.
        Я могу вызывать, например в классе Dog, Cat что-то типа super.run(50) чтобы запустить проверку
        у родителя и не дублировать данный кусок кода в каждом классе и каждом методе в Dog и Cat.
        Или дублирование тут можно оставить? Как правильнее?
     */


    @Override
    public void run(int lengthBlockage) {
        if (lengthBlockage < 0) {
            System.out.println("Длина препятствия не может быть меньше нуля! ");
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
        if (lengthBlockage < 0) {
            System.out.println("Длина препятствия должна быть больше 0!");
            return;
        }
        System.out.println(name + " не умеет плавать!");
    }
}
