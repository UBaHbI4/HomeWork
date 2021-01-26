package softing.UBaH4ukDev.Lesson7.ClassWork;

public class Duck implements Swimming, Swimming.Diving, Swimming.Diving.DeepDiving {

    @Override
    public void swim(int length) {
        System.out.println("Duck swimming for " + length + " meters");
        System.out.println(Swimming.A);
    }

    @Override
    public void doSomething(int x, int y) {
        System.out.println("Something");
    }


}
