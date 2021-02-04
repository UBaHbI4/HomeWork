package softing.UBaH4ukDev.Lesson8;

import java.io.*;
import java.util.Scanner;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson8

 Created by Ivan Sheynmaer

 2021.01.29
 v1.0
 */
public class HomeWork8 {
    public static void main(String[] args) {

        //тест задания 1-2
        System.out.println("Задание 1-2:");
        concatFiles("files/filePart1.txt","files/filePart2.txt","files/concatFiles.txt");

        //тест задания 3
        System.out.println();
        System.out.println("Задание 3:");
        System.out.println(findWordInFile("files/filePart1.txt","про"));

        //тест задания 4
        System.out.println();
        System.out.println("Задание 4:");
        System.out.println(findWordInFolder("files", "прогр"));


    }

    //Задание 1-2
    //Метод для склеивания текстов из двух файлов в третий текстовый файл
    private static boolean concatFiles(String file1, String file2, String resultFile) {
        String fullText = "";
        fullText = getTextFromFile(file1);
        fullText += getTextFromFile(file2);

        if (setTextToFile(resultFile, fullText)) {
            System.out.println(String.format("Текст из файлов (%s и %s) успешно добавлен в файл (%s).", file1, file2, resultFile));
        } else {
            System.out.println("При объединении файлов произошла ошибка.");
            return false;
        }
        return true;
    }

    //Метод для получения текста из указанного файла file
    private static String getTextFromFile(String file) {
        String result = "";
        try (DataInputStream reader = new DataInputStream(new FileInputStream(file))) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                result += scanner.nextLine() + "\r\n";
            }
            scanner.close();
            return result;
        } catch (Exception err){
            System.out.println("При чтении файла " + file + " произошла ошибка: " + err.getMessage() + "\r\n");
            return "";
        }
    }

    //Метод для записи заданного текста textToFile в файл file
    private static boolean setTextToFile(String file, String textToFile) {
        try {
            DataOutputStream writer = new DataOutputStream(new FileOutputStream(file));
            writer.write(textToFile.getBytes());
        } catch (Exception err){
            System.out.println(err.getMessage());
            return false;
        }
        return true;
    }
    //****************************************************************//

    //Задание 3.
    //Метод для поиска слова findWord в файле file.
    private static String findWordInFile(String file, String findWord) {
        String result = "Слово '" + findWord + "' не найдено в файле " + file;
        int row = 0; //Номер строки
        int col = 0; //номер столбца
        try (DataInputStream reader = new DataInputStream(new FileInputStream(file))) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                row++;
                col = scanner.nextLine().toLowerCase().indexOf(findWord.toLowerCase());
                if (col > -1) {
                   return "Слово '" + findWord + "' найдено в файле " + file +
                                        " в строке " + row  + " позиция " + (col + 1);
                }
            }
            scanner.close();
            return result;
        } catch (Exception err){
            System.out.println("При чтении файла " + file + " произошла ошибка: " + err.getMessage() + "\r\n");
            return "";
        }
    }

    //Задание 4.
    //Метод для поиска слова findWord во всех файлах указанного каталога Folder
    private static String findWordInFolder (String Folder, String findWord) {
        File file = new File(Folder);
        String[] files = file.list();
        String result = "";
        for(String filename : files){
            result += findWordInFile(Folder + "/" + filename, findWord) + "\r\n";
        }

        return result;
    }
}
