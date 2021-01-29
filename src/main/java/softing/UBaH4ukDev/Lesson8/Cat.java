package softing.UBaH4ukDev.Lesson8;

import java.io.Serializable;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson8

 Created by Ivan Sheynmaer

 2021.01.29
 v1.0
 */
public class Cat implements Serializable {
    String name;
    int age;
    static int something;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getInfo() {
        System.out.printf("Cat %s age %d", name, age);
    }

    static void getStatic() {
        System.out.println("Static");
    }
}

