package softing.UBaH4ukDev.Lesson11;

import java.util.ArrayList;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11

 Created by Ivan Sheynmaer

 2021.02.12
 v1.0
 */
public class Box <T extends Fruit> {
    private ArrayList<T> fruits;
    private String name="";

    public Box(String name) {
        fruits = new ArrayList<>();
        this.name = name;
    }

    public Box(ArrayList<T> fruits, String name) {
        this.fruits = fruits;
        this.name = name;
    }

    /*Метод для вычисления веса коробки.
    Пробегаем по всем фруктам в коробке, предполагая что в коробке
    Box<Fruit> box1 могут попасться как яблоки так и апельсины,
    если убрать проверку с метода add, где добавлять в коробку можно только однородные фрукты, т.е. к яблокам только яблоки,
    к апельсинам, только апельсины.
     */
    public float getWeight() {
        float res = 0;
        try{
            if (fruits.size() > 0) {
                for (T fruit : fruits) {
                    res += fruit.getWeight();
                }
                return res;
            } else {
                return 0f;
            }
        }catch (Exception err) {
            System.out.println(err.getMessage());
            return 0f;
        }
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public boolean add (T fruit) {
        if (fruits.size() > 0) {
           if(fruit.getClass().equals(fruits.get(0).getClass())) {
               this.fruits.add(fruit);
            } else {
               System.out.println("В ящик с " + fruits.get(0).getClass().getSimpleName() + " нельзя добавлять " + fruit.getClass().getSimpleName());
               return false;
           }
        } else {
            this.fruits.add(fruit);
        }
        return true;
    }

    @Override
    public String toString() {
        return name  +
                 fruits +
                '}';
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001f;
    }


    public void pourOut (Box<T> intoBox) {
        intoBox.getFruits().addAll(this.getFruits());
        this.fruits.clear();
    }

    public String getName() {
        return name;
    }
}
