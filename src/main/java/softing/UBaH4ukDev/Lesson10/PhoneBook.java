package softing.UBaH4ukDev.Lesson10;

import java.util.TreeMap;
import java.util.TreeSet;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson10

 Created by Ivan Sheynmaer

 2021.02.07
 v1.0
 */
public class PhoneBook {
    private TreeMap<String, TreeSet<String>> phoneBookStorage = new TreeMap<>();

    //Метод для добавления в справочник Фамилии и номера телефона
    public void add (String surName, String phoneNumber) {
        if (!phoneBookStorage.containsKey(surName)) {
            phoneBookStorage.put(surName, new TreeSet<>());
        }
        phoneBookStorage.get(surName).add(phoneNumber);
    }

    //Метод для получения по фамилии списка всех телефонов
    public void get (String surName) {
        if(phoneBookStorage.containsKey(surName)) {
            //System.out.println(phoneBookStorage.get(surName));
            System.out.println("Для фамилии " + surName + " найдены телефоны:");
            phoneBookStorage.get(surName).forEach((v) -> System.out.println(v));
        } else {
            System.out.println("Для фамилии " + surName + " отсутствуют телефоны");
        }
    }
}
