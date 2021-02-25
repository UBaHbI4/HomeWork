package softing.UBaH4ukDev.Lesson14.HomeWork;

import java.util.Arrays;
import java.util.List;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson14.HomeWork

 Created by Ivan Sheynmaer

 2021.02.24
 v1.0
 */
public class HomeWork14 {

 //   public static void main(String[] args) {
//        int[]  arrTest11 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
//        //[ 1 1 1 4 4 1 4 4 ] -> true
//        //[ 1 1 1 1 1 1 ] -> false
//        //[ 4 4 4 4 ] -> false
//        //[ 1 4 4 1 1 4 3 ] -> false
//        int[]  arrTest21 = {1, 1, 1, 4, 4, 1, 4, 4};
//        int[]  arrTest22 = {1, 1, 1, 1, 1, 1};
//        int[]  arrTest23 = {4, 4, 4, 4 };
//        int[]  arrTest24 = {1, 4, 4, 1, 1, 4, 3};
//
//        System.out.println("Задание 1. Тест:");
//        System.out.println("Исходный массив:");
//        System.out.println(Arrays.toString(arrTest11));
//        System.out.println("Обработанный массив:");
//        System.out.println(Arrays.toString(getElemetsAfterLastFour(arrTest11)));
//        System.out.println();
//
//        System.out.println("Задание 2. Тест:");
//        System.out.println("[ 1 1 1 4 4 1 4 4 ] -> " + checkArray(arrTest21));
//        System.out.println("[ 1 1 1 1 1 1 ] -> " + checkArray(arrTest22));
//        System.out.println("[ 4 4 4 4 ] -> " + checkArray(arrTest23));
//        System.out.println("[ 1 4 4 1 1 4 3 ] -> " + checkArray(arrTest24));
//  }

    //Задание 1.
    public  int[] getAfterFourArray (int[] targetArray) {
        int findIndex = -1;
        for (int i = targetArray.length-1; i >= 0 ; i--) {
            if(targetArray[i] == 4) {
                findIndex = i;
                break;
            }
        }
        if(findIndex == -1) {
            throw new RuntimeException("Not find '4'.");
        } else {
            return Arrays.copyOfRange(targetArray, findIndex + 1, targetArray.length);
        }
    }

    //Задание 2.
    public  boolean checkArray(int[] targetArray) {
        boolean findOne = false;
        boolean findFour = false;

        for (int i = 0; i < targetArray.length; i++) {
           if(targetArray[i] == 1) {
               findOne = true;
           } else if(targetArray[i] == 4) {
               findFour = true;
           } else {
               return false;
           }
        }
        return findOne && findFour;
    }
}
