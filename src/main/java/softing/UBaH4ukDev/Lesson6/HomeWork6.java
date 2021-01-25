package softing.UBaH4ukDev.Lesson6;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson6

 Created by Ivan Sheynmaer

 2021.01.25
 v1.0
 */

import java.util.Random;

public class HomeWork6 {
    private static final int catCount = 5;
    private static Cat[] cats;

    public static void main(String[] args) {

        //fightCatExample();                //Классная работа
        //*******************************************************//


        Bowl bowl = new Bowl();             //Создали миску
        System.out.println("Поставили пустую миску.");
        bowl.putFood(getRndNumber(25, 60));  //Положили в миску случайное число еды от .. до ..
        bowl.putFood(getRndNumber(0, 30));  //Добавили в миску случайное число еды от .. до ..

        System.out.println();
        /*
            Создаем массив котов с количеством catCount и полями
            name равным Cat + индекс массива
            appetite равным случайному числу от .. до ..
        */
        cats = new Cat[catCount];
        for (int i = 0; i < catCount; i++){
            cats[i] = new Cat("Кот" + i, getRndNumber(20, 40));
        }

        System.out.println();

        //Выводим статусы всех котов массива
        System.out.println("Созданы следующие коты:");
        printCatStatus(cats);

        System.out.println();

        //Просим котов покушать
        System.out.println("Коты по очереди пошли кушать:");
        for(Cat cat : cats){
            cat.eat(bowl);
        }

        System.out.println();

        //Выводим статусы всех котов массива после приема пищи
        System.out.println("Состояния котов после приема пищи:");
        printCatStatus(cats);

        System.out.println();

        System.out.println(bowl.getFood());//Вывели информацию об остатке еды в миске, чтобы убедиться что там нет отрицательного значения
    }

    private static void fightCatExample() {
        Cat fightCat1 = new Cat("Мурзик", 15, 5);
        Cat fightCat2 = new Cat("Васька", 12, 6);

        fightCat1.kick(fightCat2);
        fightCat2.kick(fightCat1);
        fightCat1.kick(fightCat2);
        fightCat2.kick(fightCat1);
        fightCat1.kick(fightCat2);        //На этом шаге у Васьки кончатся жизни и он проиграет
        fightCat2.kick(fightCat1);        //На этом шаге, проигравший Васька не должен бить Мурзика
    }

    //Метод для вывода состояния всех котов массива
    public static void printCatStatus(Cat[] cats){
        for(Cat cat : cats){
            System.out.println(cat.getStatus() );
        }
    }

    //Метод для получения случайного числа от min до max
    public static int getRndNumber(int min, int max){
        Random rnd = new Random();
        return min + rnd.nextInt(max+1 - min);
    }


}
