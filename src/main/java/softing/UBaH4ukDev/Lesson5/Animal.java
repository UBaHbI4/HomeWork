package softing.UBaH4ukDev.Lesson5;

public abstract class Animal {
    public static int countAnimals;
    protected String name;
    protected String color;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public abstract void run (int lengthBlockage); //{
    //System.out.println(name + " пробежал " + lengthBlockage + " м");
    //}

    public abstract void swim (int lengthBlockage);// {
    //System.out.println(name + " проплыл " + lengthBlockage + " м");
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
