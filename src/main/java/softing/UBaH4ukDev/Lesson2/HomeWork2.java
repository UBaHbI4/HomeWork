package softing.UBaH4ukDev.Lesson2;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson2

 Created by Ivan Sheynmaer

 2021.01.25
 v1.0
 */
public class HomeWork2 {
    public static void main(String[] args) {
        //Задание 1.
        System.out.println("Задание 1.");
        int array1[] = {0, 1, 0, 1, 0, 1, 1, 1, 0, 0};
        System.out.println("Исходный массив:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            }
        }
        //Результат:
        System.out.println("\nОбработанный массив:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }


        //Задание 2.
        System.out.println("\n\nЗадание 2.");
        int array2[] = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i * 3;
        }
        //Результат:
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + "\t");
        }

        //Задание 3.
        System.out.println("\n\nЗадание 3.");
        int array3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + "\t");
        }
        for (int i = 0; i < array3.length; i++) {
            if(array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println();
        //Результат:
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + "\t");
        }

        //Задание 4.
        System.out.println("\n\nЗадание 4.");
        int array4[][] = new int[5][5];
        for (int i = 0; i < array4.length; i++) {
            array4[i][array4.length - 1 - i] = 1;
            array4[i][i] = 1;
        }
        //Результат:
        for (int i = 0; i  < array4.length; i++) {
            for (int j = 0; j  < array4.length; j++) {
                System.out.print(array4[i][j] + "\t");
            }
            System.out.println();
        }

        //Задание 5
        System.out.println("\nЗадание 5.");
        int array5[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив:");
        for (int i = 0; i < array5.length; i++) {
            System.out.print(array5[i] + "\t");
        }
        int minValue = array5[0];
        int maxValue = array5[0];
        for (int i = 0; i < array5.length; i++) {
            if (array5[i] > maxValue) maxValue = array5[i];
            if (array5[i] < minValue) minValue = array5[i];
        }
        //Результат:
        System.out.println("\nMin=" + minValue + "\nMax=" + maxValue);

        //Тест задания 6.
        System.out.println("\nЗадание 6.");
        int array6[] = {1, 1, 2, 4};
        checkBalance(array6);
        array6 = new int[] {1, 5, 3, 2};
        checkBalance(array6);
        array6 = new int[] {1, 5, 3, 3};
        checkBalance(array6);


        //Тест задания 7.
        System.out.println("\nЗадание 7.");
        int array7[] = {1, 2, 3, 4};
        System.out.println("Исходный массив:");
        for (int i = 0; i < array7.length; i++) {
            System.out.print(array7[i] + " ");
        }
        int n = -2;
        int resArray[] =  arrayDisplace(array7, n);
        //Результат :
        System.out.println("\nМассив после сдвига на " + n + ":");
        for (int i = 0; i < resArray.length; i++) {
            System.out.print(resArray[i] + " ");
        }
        array7 = new int[] {1, 2, 3, 4};
        n = 2;
        resArray =  arrayDisplace(array7, n);
        //Результат:
        System.out.println("\nМассив после сдвига на " + n + ":");
        for (int i = 0; i < resArray.length; i++) {
            System.out.print(resArray[i] + " ");
        }


    }
    //Задание 6.
    public static boolean checkBalance(int[] array){
        int sumLeft = 0;
        int sumRigth = 0;
        String strLeft = "checkBalance([";
        String strRigth = "";

        for (int i = 0; i < array.length; i++) {
            sumLeft += array[i];
            strLeft += array[i] + ",";
            sumRigth = 0;
            strRigth = "";
            for (int j = i + 1; j < array.length; j++) {
                sumRigth += array[j];
                strRigth += array[j];
                if (j < array.length-1){
                    strRigth += ",";
                } else {
                    strRigth += "]) --> true";
                }
            }
            if (sumLeft == sumRigth) {
                System.out.println(strLeft + " || " + strRigth);
                return true;
            }
        }

        strLeft = "checkBalance([";
        for (int i = 0; i < array.length; i++) {
            strLeft += array[i];
            if (i < array.length-1){
                strLeft += ",";
            } else {
                strLeft += "]) --> false";
            }
        }
        System.out.println(strLeft);
        return false;
    }

    //Задание 7.
    //Если n>0, то сдвиг вправо, иначе влево
    public static int[] arrayDisplace(int[] targetArray, int n){
        int n_ = n;
        if (Math.abs(n) > targetArray.length) n_ = n % targetArray.length;
        int tempValue = 0;

        if (n > 0) {
            for (int count = 0; count < Math.abs(n); count++){
                tempValue = targetArray[targetArray.length-1];
                for (int i = targetArray.length - 1; i > 0; i--) {
                    targetArray[i] = targetArray[i-1];
                }
                targetArray[0] = tempValue;
            }
        } else {
            for (int count = 0; count < Math.abs(n); count++){
                tempValue = targetArray[0];
                for (int i = 0; i < targetArray.length - 1; i++) {
                    targetArray[i] = targetArray[i+1];
                }
                targetArray[targetArray.length - 1] = tempValue;
            }
        }
        return targetArray;
    }
}
