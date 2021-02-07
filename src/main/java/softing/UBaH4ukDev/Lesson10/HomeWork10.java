package softing.UBaH4ukDev.Lesson10;

import java.util.*;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson10

 Created by Ivan Sheynmaer

 2021.02.07
 v1.0
 */
public class HomeWork10 {
    public static void main(String[] args) {

        //Задание 1.
        //Массив слов с повторениями
        String[] noteList = { "до", "до", "ре", "ми", "фа",
                                "соль", "ре", "ля", "ля", "си",
                                "ре", "ре", "ми", "ми", "си",
                                "до", "фа", "до", "ре", "ми"};

        //Arrays.sort(arrayWords);
        //HashMap<String, Integer> hashMap = new HashMap<>();

        //Сделаем Tree, для отсортированного вывода
        TreeMap<String, Integer> notes = new TreeMap<>();
        for(String note : noteList) {
            if(notes.containsKey(note)) {
                notes.put(note, (notes.get(note) + 1));
            } else {
                notes.put(note, 1);
            }
        }

        System.out.println("Список уникальных слов:");
        System.out.println(notes.keySet());
        System.out.println();

        //System.out.println(hashMap.entrySet());
        notes.forEach((k, v) -> System.out.println("Слово '" + k + "' " + v + " шт."));
        System.out.println();
        /////////////////*******/////////////////

        //Задание 2.
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79039039900");
        phoneBook.add("Петров", "+79039039977");
        phoneBook.add("Иванов", "+79039039901");
        phoneBook.add("Сидоров", "+79039039922");
        phoneBook.add("Иванов", "+79039039902");

        phoneBook.get("Иванов");
        phoneBook.get("Иванова");
        phoneBook.get("Петров");

    }
}
