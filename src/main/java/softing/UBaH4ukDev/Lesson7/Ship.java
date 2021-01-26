package softing.UBaH4ukDev.Lesson7;

public class Ship implements Swimming {
    @Override
    public void swim(int length) {
        System.out.println("Ship is swimming for " + length + " miles");
    }
}
