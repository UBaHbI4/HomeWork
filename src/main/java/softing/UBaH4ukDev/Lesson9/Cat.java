package softing.UBaH4ukDev.Lesson9;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson9

 Created by Ivan Sheynmaer

 2021.02.02
 v1.0
 */

//Задание 1.
public class Cat {
    private static int countCats = 0;

    private int Id;                 //Id кота, будем получать при выводе котов из базы. В конструкторе заполнять не будем.
    private String name;            //Имя
    private String color;           //Цвет
    private Float weight;           //Вес
    private String race;            //Порода

    public Cat() {
        countCats++;
        this.name = "UnknownCat" + getCountCats();
        this.color = "unknown";
        this.weight = 0.00f;
        this.race = "unknown";
    }

    public Cat(String name, String color, Float weight, String race) {
        countCats++;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.race = race;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", race='" + race + '\'' +
                '}';
    }

    public int getCountCats() {
        return countCats;
    }


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

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
