package softing.UBaH4ukDev.Lesson1;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson1

 Created by Ivan Sheynmaer

 2021.01.25
 v1.0
 */
public class HomeWork1 {

    //Задание 1.
    public static void main(String[] args) {

        //Задание 2.
        boolean boolVar = true;
        byte byteVar = 0;
        short shortVar = 5000;
        int intVar = 456;
        long longVar = 456456;
        char charVar = 'I';
        float floatVar = 1.08f;
        double doubleVar = 1.08;
        char[] arrayVar = {'A', 'R', 'R', 'A', 'Y'};
        String stringVar = "Строковый тип";
        HomeWork1 classVar = new HomeWork1();


        System.out.println("Тест Задание3:");
        System.out.println("   calcFormula(2,3,6,3) = " + calcFormula(2, 3, 6, 3));
        System.out.println("   calcFormula(2,3,6,0) = " + calcFormula(2, 3, 6, 0));

        System.out.println("Тест Задание4:");
        System.out.println("   checkSum(3, 2) = " + checkSum(3, 2));
        System.out.println("   checkSum(14, 1) = " + checkSum(14, 1));
        System.out.println("   checkSum(8, 2) = " + checkSum(8, 2));
        System.out.println("   checkSum(10, 10) = " + checkSum(10, 10));
        System.out.println("   checkSum(20, 5) = " + checkSum(20, 5));

        System.out.println("Тест Задание5:");
        System.out.println("   checkPositiveNum(-5)");
        checkPositiveNum(-5);
        System.out.println("   checkPositiveNum(0)");
        checkPositiveNum(0);
        System.out.println("   checkPositiveNum(5)");
        checkPositiveNum(5);

        System.out.println("Тест Задание6:");
        System.out.println("   isNegativeNumber(-5) = " + isNegativeNumber(-5));
        System.out.println("   isNegativeNumber(0) = " + isNegativeNumber(0));
        System.out.println("   isNegativeNumber(5) = " + isNegativeNumber(5));

        System.out.println("Тест Задание7:");
        System.out.println("   printGreeting(\"Иван\")");
        printGreeting("Иван");

        System.out.println("Тест Задание8:");
        System.out.println("   isLeapYear(2016)");
        isLeapYear(2016);
        System.out.println("   isLeapYear(400)");
        isLeapYear(400);
        System.out.println("   isLeapYear(1900)");
        isLeapYear(1900);
        System.out.println("   isLeapYear(2000)");
        isLeapYear(2000);
        System.out.println("   isLeapYear(800)");
        isLeapYear(800);
        System.out.println("   isLeapYear(600)");
        isLeapYear(600);


    }

    //Задание 3.
    static float calcFormula(float a, float b, float c, float d) {
        /*
        Можно добавить проверку значения d, чтобы не допустить деления на 0 или обработку исключений..
        Хотя в данном случае вернет значение Infinity и вроде как ошибки не возникает.
        */
//      if (d == 0){
//          System.out.println("Значение d не должно быть равно 0! Введите другое значение.");
//          return 0;
//      }
        return a * (b + (c / d));
    }

    //Задание 4.
    static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //Задание 5.
    static void checkPositiveNum(int checkedValue) {
        if (checkedValue >= 0) {
            System.out.println(checkedValue + " это положительное число.");
        } else {
            System.out.println(checkedValue + " это отрицательное число.");
        }
    }

    //Задание 6.
    static boolean isNegativeNumber(int checkedValue) {
        if (checkedValue >= 0) {
            return false;
        } else {
            return true;
        }
    }

    //Задание 7.
    static void printGreeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //Задание 8.
    static void isLeapYear(int checkedYear) {
        if (((checkedYear % 100 != 0) && ((checkedYear % 4 == 0))) || (checkedYear % 400 == 0)) {
            System.out.println(checkedYear + "-й год високосный ");
        } else {
            System.out.println(checkedYear + "-й год не високосный ");
        }
    }
}
