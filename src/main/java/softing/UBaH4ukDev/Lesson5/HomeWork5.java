package softing.UBaH4ukDev.Lesson5;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson5

 Created by Ivan Sheynmaer

 2021.01.25
 v1.0
 */
public class HomeWork5 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик");
        //cat1.setName("Мурзик");
        cat1.run(220);
        cat1.run(150);
        cat1.swim(150);
        System.out.println();

        Cat cat2 = new Cat("Васька");
        cat2.run(50);
        cat2.swim(5);
        System.out.println();

        Dog dog1 = new Dog("Шарик");
        dog1.run(250);
        dog1.run(510);
        dog1.swim(11);
        dog1.swim(5);
        System.out.println();

        Dog dog2 = new Dog("Ярик");
        dog2.run(100);
        dog2.run(900);
        dog2.swim(12);
        dog2.swim(5);
        System.out.println();

        Dog dog3 = new Dog("Барбос");
        dog3.run(100);
        dog3.swim(12);
        dog3.swim(5);
        dog3.swim(-5);
        dog3.run(-10);
        System.out.println("---------------------------------------------------");

        System.out.println("Животных создано: " + Animal.countAnimals + " шт.");
        System.out.println("Котов создано: " + Cat.countCats + " шт.");
        System.out.println("Собак создано: " + Dog.countDogs + " шт.");
    }
}
