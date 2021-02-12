package softing.UBaH4ukDev.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11.ClassWork

 Created by Ivan Sheynmaer

 2021.02.12
 v1.0
 */
public class HomeWork11 {

    public static void main(String[] args) {

        //Тест Задание1
        System.out.println("Задание 1:");
        Integer[] test1Array = {1, 2, 3, 4, 5};
        String[] test2Array = {"Один", "Два", "Три", "Четыре", "Пять"};

        System.out.println("\tИсходные массивы:");
        System.out.println("\t" + Arrays.toString(test1Array));
        System.out.println("\t" + Arrays.toString(test2Array));
        System.out.println();

        swapArrayElements(test1Array, 0, 1);
        swapArrayElements(test2Array, 3, 4);

        System.out.println("\tМассивы после обработки методом swapArrayElements:");
        System.out.println("\t" + Arrays.toString(test1Array));
        System.out.println("\t" + Arrays.toString(test2Array));
        /////////////**********/////////////

        //Тест Задание 2.
        System.out.println();
        System.out.println("Задание 2:");
        List<Integer> integerList = arrayToArrayList(test1Array);
        List<String> stringList = arrayToArrayList(test2Array);
        System.out.println("\t" + integerList);
        System.out.println("\t" + stringList);
        /////////////**********/////////////

        //Тест Задание 3.
        System.out.println();
        System.out.println("Задание 3:");
        /////////////**********/////////////

        //Box<Apple> box1 = new Box<>();
        Box<Fruit> box1 = new Box<>("Ящик Фрукты");
        /*
        Сделаем box1 ящик Fruit-ов, чтобы проверить, что в апельсины мы можем положить только апельсины,
        а в яблоки, только яблоки. Но без проверки, мы туда можем добавить как яблоки, так и апельсины.
        */
        Box<Apple> box2 = new Box<>("Ящик Яблоки");
        Box<Orange> box3 = new Box<>("Ящик Апельсины 1");
        Box<Orange> box4 = new Box<>("Ящик Апельсины 2");

        box1.add(new Apple());
        box1.add(new Apple());
        System.out.println("После добавления яблок в Ящик Фрукты, пытаемся добавить Апельсин");
        box1.add(new Orange());
        /*
        Тут не даст добавить апельсин, т.к. в коробке есть яблоки. Но если добавить сначала апельсин, то тогда не даст
        добавить яблоки.
        */

        box2.add(new Apple());
        box2.add(new Apple());
        box2.add(new Apple());
        box2.add(new Apple());
        box2.add(new Apple());
        box2.add(new Apple());

        box3.add(new Orange());
        box3.add(new Orange());
        box3.add(new Orange());
        box3.add(new Orange());

        box4.add(new Orange());
        box4.add(new Orange());
        box4.add(new Orange());


        System.out.println();
        printAllBoxInfo(box1, box2, box3, box4);


        System.out.println();
        System.out.println("Сравниваем коробки");
        System.out.println(box2.getName() + " = " + box3.getName() +"?    " + box2.compare(box3));
        System.out.println(box3.getName() + " = " + box4.getName() +"?    " + box3.compare(box4));



        //Высыпаем с Box1 в Box2
        System.out.println();
        System.out.println("Высыпаем Ящик Апельсины 1 в Ящик Апельсины 2");
        box3.pourOut(box4);

        System.out.println();
        printAllBoxInfo(box1, box2, box3, box4);


        System.out.println();
        System.out.println("После высыпания снова сравним");
        System.out.println(box2.getName() + " = " + box3.getName() +"?    " + box2.compare(box3));


    }

    //Метод для вывода информации о содержимом всех ящиков и их вес
    private static void printAllBoxInfo(Box<? extends Fruit>... boxes) {
        System.out.println("Содержимое ящиков:");
        for (Box<?> box : boxes){
            System.out.println(box);
        }
        System.out.println("Вес ящиков:");
        for (Box<?> box : boxes){
            System.out.println("Вес " + box.getName() + ": " + box.getWeight() + "кг.");
        }
    }

    //Задание 1.
    //Метод, меняющий местами элементы массива
    private static <T> void swapArrayElements(T[] targetArray, int firstPosition, int secondPosition) {
        try {
            T temp = targetArray[firstPosition];
            targetArray[firstPosition] = targetArray[secondPosition];
            targetArray[secondPosition] = temp;
        }catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    //Задание 2.
    //Метод, преобраующий массив в ArrayList
    private static <T> ArrayList<T> arrayToArrayList (T[] array) {
        try {
            ArrayList<T> arrayList = new ArrayList<>();
            for (T arrayElement : array) {
                arrayList.add(arrayElement);
            }
            return arrayList;
        }catch (Exception err) {
            System.out.println("Error: " + err.getMessage());
            return null;
        }

    }
}
