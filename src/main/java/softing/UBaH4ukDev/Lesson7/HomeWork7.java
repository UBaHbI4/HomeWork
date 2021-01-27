package softing.UBaH4ukDev.Lesson7;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson7.ClassWork

 Created by Ivan Sheynmaer

 2021.01.26
 v1.0
 */
public class HomeWork7 {

    public static void main(String[] args) {
        //Тестирование заданий 1-4
        System.out.println("Задания 1-4:");
        HWorkFrom1To4();
        System.out.println();


        //Тестирование заданий 5-7
        System.out.println("Задания 5-7:");

        //Массив без ошибок
        String[][] array1 = {
                {"1","0","0","0"},
                {"0","1","1","1"},
                {"0","0","0","0"},
                {"0","0","0","-3"}
        };

        //Массив с ошибкой, кол-во столбцов в первой строке меньше 4. Возникнет MyArraySizeException
        String[][] array2 = {
                {"01","02","03",},
                {"05","06","07","08"},
                {"09","10","11","12"},
                {"13","14","15","16"}
        };

        //В третьей строке 4 элемент для вызова Exception MyArrayDataException
        String[][] array3 = {
                {"01","02","03","04"},
                {"05","06","07","08"},
                {"09","10","11","1_"},
                {"13","14","15","16"}
        };

        //Тест первого массива
        try {
            System.out.println(sumArray(array1));
        } catch (MyArraySizeException Err){
            System.out.println(Err.getMessage());
        } catch (MyArrayDataException Err2){
            System.out.println(Err2.getMessage());
        }

        //Тест второго массива
        try {
            System.out.println(sumArray(array2));
        } catch (MyArraySizeException Err){
            System.out.println(Err.getMessage());
        } catch (MyArrayDataException Err2){
            System.out.println(Err2.getMessage());
        }

        //Тест третьего массива
        try {
            System.out.println(sumArray(array3));
        } catch (MyArraySizeException Err){
            System.out.println(Err.getMessage());
        } catch (MyArrayDataException Err2){
            System.out.println(Err2.getMessage());
        }


    }

    //Задание 1-4
    private static void HWorkFrom1To4() {
        //Загоняем объекты разных классов в массив
        Actionable[] objects = {
                new Human("Алексей", 1,3000),
                new Cat("Мурзик", 3, 1150),
                new Robot("Хайоми", 5, 50000),
                new Robot("C-3PO", 4, 2000)
        };

        //Загоняем препятствия разных типов в массив
        Obstructionable[] obstructions = {
                new Wall("Модель6",1),
                new Wall("Модель3",3),
                new RunningTrack("Модель1", 1500),
                new Wall("Модель9", 4),
                new RunningTrack("Модель5", 10000),
        };

        //Заставляем все объекты пройти все препятствия.
        //Если у объекта не получилось пройти какое-то препятствие, выходим из цикла и переходим к следующему объекту
        for(Actionable actionable : objects){
            for (Obstructionable obstructionable : obstructions) {
                if (obstructionable instanceof RunningTrack) {
                    if (!actionable.run((RunningTrack) obstructionable)) break;
                }
                if (obstructionable instanceof Wall) {
                    if (!actionable.jump((Wall) obstructionable)) break;
                }
            }
        }
    }

    //****************************************************//
    //Задание 5-7
    private static int sumArray(String[][] arr){
        int sum = 0;
            if (arr.length != 4) throw new MyArraySizeException("Количество строк: " + arr.length);
            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[row].length; col++) {
                    if ( arr[row].length != 4) {
                        throw new MyArraySizeException("Количество столбцов: " + arr[row].length);
                    }
                    if (!isNumber(arr[row][col])){
                        sum = 0;
                        throw new MyArrayDataException("строке " + (row + 1) + " столбце " + (col + 1));
                    } else sum += Integer.parseInt(arr[row][col]);
                }
            }
        return sum;
    }

    //Метод для проверки, что в строке задано целочисленное число, можно отрицательное. Важно, чтобы без пробелов!
    private static boolean isNumber(String checkValue){
        String numbers = "-0123456789";
        for (char element : checkValue.toCharArray()){
           if (numbers.indexOf(element) == -1) {
               return false;
           }
        }
        return true;
    }
    //****************************************************//

}
