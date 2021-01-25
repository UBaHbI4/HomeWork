package softing.UBaH4ukDev.Lesson4;

import java.util.Calendar;

//Задание 1.
public class Workman {
    public static int workManCount;
    /*
    Количество созданных экземпляров класса. Вот что я имел ввиду в комментах к уроку, когда вы спрашивали какое
    можно создать статическое поле :)
    */

    private String surName;     //Фамилия
    private String name;        //Имя
    private String middleName;  //Отчество
    private String fullName;    //ФИО

    private String title;       //Должность
    private String email;       //E-mail
    private String phone;       //Телефон
    private int paid;           //Зарплата
    private int birthYear;      //Год рождения
    private int age;            //Возраст

    //Задание 2.
    public Workman(String surName, String name, String middleName, String title, String email, String phone, int paid, int age) {
        this.surName = surName;
        this.name = name;
        this.middleName = middleName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.paid = paid;
        this.age = age;

        this.fullName = surName + " " + name + " " + middleName;            //Получаем ФИО.
        this.birthYear = Calendar.getInstance().get(Calendar.YEAR) - age;   //Вычисляем год рождения.

        workManCount++;//При создании экземпляра класса, увеличиваем счетчик количества созданных экземпляров класса.
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPaid() {
        return paid + " руб." ;
    }

    public int getBirthYear() {
        return birthYear;
    }

    //Задание 3.
    void getInfo(){
        System.out.printf("\r\n%s\r\nВозраст: %d лет\r\nДолжность: %s\r\nТелефон: %s\r\nПочтовый ящик: %s\r\nЗарплата: %s\r\n",fullName, age, title, phone, email, getPaid());
    }


    //Метод, возвращающий количество созданных экземпляров класса.
    public static int getCountCreatedObjects(){
        return workManCount;
    }
}
