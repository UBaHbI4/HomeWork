package softing.UBaH4ukDev.Lesson4;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson4

 Created by Ivan Sheynmaer

 2021.01.25
 v1.0
 */
public class HomeWork4 {
    public static void main(String[] args) {
        //Задание 4.
        Workman[] workmanArray = new Workman[5];
        workmanArray[0] = new Workman("Иванов", "Иван","Иванович",
                "Разработчик Java","javadev@mail.ru",
                "+79111111111", 80000, 43);
        workmanArray[1] = new Workman("Петров", "Петр","Петрович",
                "Разработчик C#","csharpdev@mail.ru",
                "+79222222222", 56000, 23);
        workmanArray[2] = new Workman("Сидоров", "Сидр","Сидорович",
                "Разработчик Android","androiddev@mail.ru",
                "+79333333333", 130000, 42);
        workmanArray[3] = new Workman("Шейнмаер", "Иван","Викторович",
                "Разработчик","kinoshnik_ivan@mail.ru",
                "+79039203340", 70000, 36);
        workmanArray[4] = new Workman("Тарапунькин", "Таран","Таранович",
                "Дизайнер","tarapun@mail.ru",
                "+79444444444", 60000, 48);

        //Задание 5.
        for (Workman person: workmanArray){
            if (person.getAge() > 40) person.getInfo();
        }

        System.out.println("\r\nВсего объектов класса: " + Workman.getCountCreatedObjects() + " шт.");
    }
}
