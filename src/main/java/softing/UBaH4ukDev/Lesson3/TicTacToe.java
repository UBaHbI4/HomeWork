package softing.UBaH4ukDev.Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson3

 Created by Ivan Sheynmaer

 2021.01.25
 v1.0
 */
public class TicTacToe {
    private static char[][] field;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static String logString = "";       //История ходов
    private static final int countWinDot = 4;   //Количество фишек в ряд, необходимое для победы

    //Размеры игрового поля для кристиков-ноликов
    private static final int fieldSizeX = 5;
    private static final int fieldSizeY = 5;

    //Размер массива для змейки
    private static int arraySizeX;
    private static int arraySizeY;

    public static void main(String[] args) {
        String inputString;
        do {
            //Дадим пользователю право выбора, что запустить
            System.out.println("1 - Играть в крестики-нолики.");
            System.out.println("2 - Заполнить массив змейкой.");
            System.out.println("3 - Выход.");
            System.out.println();
            System.out.println("Введите число от 1 до 3 для выбора пункта меню...");

            //Ждем, пока пользователь выберет 1 или 2. Или 3 для выхода.
            int selNumber = 0;
            do {
                selNumber = SCANNER.nextInt();
                if (selNumber ==3) {
                    SCANNER.close();
                    return;
                }
                if (selNumber <1 || selNumber > 2) System.out.println("Введите 1 или 2!");
            } while (selNumber != 1 && selNumber != 2);

            if (selNumber == 1) {
                System.out.println("Играем в крестики-нолики.");
                startGame();
                System.out.println("Игра крестики-нолики завершена.");
            } else {
                do {
                    System.out.println("Заполняем массив змейкой. Введите длину и ширину массива.");
                    arraySizeY = SCANNER.nextInt();
                    arraySizeX = SCANNER.nextInt();
                    fillArraySnake(arraySizeX, arraySizeY);
                    System.out.println("Для повтора нажмите y");
                    inputString = SCANNER.next();
                } while (inputString.equals("y"));
            }
        } while (true);
    }

    //Задание 1, 2, 3, 4
    //Старт игры в крестики-нолики
    public static void startGame() {
        while (true){
            initField();
            printField();

            while (true) {
                humanTurn();
                printField();
                if (checkGame(DOT_HUMAN, "Human wins!!!")) break;

                aiTurn();
                printField();
                if (checkGame(DOT_AI, "AI wins!!!")) break;
            }

            System.out.println("История ходов:\r\n" + logString);
            logString = "";

            System.out.println("Сыграем еще раз? Для подтверждения нажмите y");
            if (!SCANNER.next().equals("y")) {
                break;
            }
        }
    }

    //Ход человека
    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Игрок Введите координаты хода X и Y от 1 до 3 через пробел ->");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));


        field[y][x] = DOT_HUMAN;

        logString += "Human:[" + (x+1) + "][" + (y+1) + "], ";


    }

    //Ход компьютера
    private static void aiTurn() {
        int x;
        int y;
        boolean exitLoop = false;
        //Проверим, есть ли возможность победить компьютеру, проверив все варианты ходов на победу
        //Если есть такой шанс, используем его
        for (int y1 = 0; y1 < fieldSizeY; y1++){
            for (int x1 = 0; x1 < fieldSizeX; x1++) {
                if (field[y1][x1] == DOT_EMPTY) {
                    field[y1][x1] = DOT_AI;
                    if (checkWin(DOT_AI)){
                        field[y1][x1] = DOT_AI;
                        logString += "AI:[" + (x1+1) + "][" + (y1+1) + "], ";
                        exitLoop = true;
                        break;
                    } else {
                        field[y1][x1] = DOT_EMPTY;
                    }
                }
            }
            if (exitLoop) {
                return;
            }
        }
        //Если у компьютера нет победного хода, проверяем есть ли такая возможность у человека.
        //Ходим от его лица и проверяем каждый ход на победу. Если такой ход есть, то блокируем его,
        //чтобы не дать человеку выйграть
        for (int y1 = 0; y1 < fieldSizeY; y1++){
            for (int x1 = 0; x1 < fieldSizeX; x1++) {
                if (field[y1][x1] == DOT_EMPTY) {
                    field[y1][x1] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)){
                        field[y1][x1] = DOT_AI;
                        logString += "AI:[" + (x1+1) + "][" + (y1+1) + "], ";
                        exitLoop = true;
                        break;
                    } else {
                        field[y1][x1] = DOT_EMPTY;
                    }
                }
            }
            if (exitLoop) {
                return;
            }
        }

        // Проверка на близость к победе
        //Тот же алгоритм, что выше. Но уже проверка на возможность победы через ход
        if (((fieldSizeY+fieldSizeX) / 2) > 3){
            for (int y1 = 0; y1 < fieldSizeY; y1++){
                for (int x1 = 0; x1 < fieldSizeX; x1++) {
                    if (field[y1][x1] == DOT_EMPTY) {
                        field[y1][x1] = DOT_AI;
                        if (checkPreWin(DOT_AI)){
                            field[y1][x1] = DOT_AI;
                            logString += "AI:[" + (x1+1) + "][" + (y1+1) + "], ";
                            //System.out.println("Выйгрышная позиция для AI, ход в " + (y1 + 1) + ":" + (x1 + 1));
                            exitLoop = true;
                            break;
                        } else {
                            field[y1][x1] = DOT_EMPTY;
                        }
                    }
                }
                if (exitLoop) {
                    return;
                }
            }
            for (int y1 = 0; y1 < fieldSizeY; y1++){
                for (int x1 = 0; x1 < fieldSizeX; x1++) {
                    if (field[y1][x1] == DOT_EMPTY) {
                        field[y1][x1] = DOT_HUMAN;
                        if (checkPreWin(DOT_HUMAN)){
                            field[y1][x1] = DOT_AI;
                            logString += "AI:[" + (x1+1) + "][" + (y1+1) + "], ";
                            exitLoop = true;
                            //System.out.println("Выйгрышная позиция для HUMAN, ход в " + (y1 + 1) + ":" + (x1 + 1));
                            break;
                        } else {
                            field[y1][x1] = DOT_EMPTY;
                        }
                    }
                }
                if (exitLoop) {
                    return;
                }
            }
        }

        //Если ничего не подошло и свободна средняя позиция, то занимаем её
        int middlePosX = (int) ((fieldSizeX -1) / 2);
        int middlePosY = (int) ((fieldSizeY -1) / 2);

        if (field[middlePosY][middlePosX] == DOT_EMPTY){
            field[middlePosY][middlePosX] = DOT_AI;
            logString += "AI:[" + (middlePosX+1) + "][" + (middlePosY+1) + "], ";
            return;
        }

        //Может быть можно занять углы? Проверяем
//        if (field[0][0] == DOT_EMPTY) {
//            field[0][0] = DOT_AI;
//            return;
//        }
//        if (field[fieldSizeY - 1][fieldSizeX - 1] == DOT_EMPTY) {
//            field[fieldSizeY - 1][fieldSizeX - 1] = DOT_AI;
//            return;
//        }
//        if (field[0][fieldSizeX - 1] == DOT_EMPTY) {
//            field[0][fieldSizeX - 1] = DOT_AI;
//            return;
//        }
//        if (field[fieldSizeY - 1][0] == DOT_EMPTY) {
//            field[fieldSizeY - 1][0] = DOT_AI;
//            return;
//        }


        //Иначе ходим в случайную клетку
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
        logString += "AI:[" + (x+1) + "][" + (y+1) + "], ";
    }

    //Проверка на завершение игры
    private static boolean checkGame(char dot, String messageValue) {
        if (checkWin(dot)) {
            System.out.println(messageValue);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!!!");
            return true;
        }
        return false;
    }

    //Проверка на победу
    private static boolean checkWin(char c) {
        int countHorDot = 0;
        int countVertDot = 0;
        int countMainDiagDot = 0;
        int countSecondDiagDot = 0;

        //Проверка по всем горизонталям
        for (int i = 0; i < fieldSizeY; i++){
            countHorDot = 0;
            for (int j = 0; j < fieldSizeX; j++){
                if (field[i][j] == c) {
                    countHorDot++;
                    if (countHorDot == countWinDot) return true;
                } else countHorDot = 0;
            }
        }
        //Проверка по всем вертикалям
        for (int i = 0; i < fieldSizeX; i++){
            countVertDot = 0;
            for (int j = 0; j < fieldSizeY; j++){
                if (field[j][i] == c) {
                    countVertDot++;
                    if (countVertDot == countWinDot) return true;
                } else countVertDot = 0;
            }
        }
        //Проверка по всем главным диагоналям
        for (int k = fieldSizeX; k >= -fieldSizeX; k--)
        {
            countMainDiagDot = 0;
            for (int j = 0; j < fieldSizeY - k; j++)
            {
                int i = k + j;
                if (i < fieldSizeX && j < fieldSizeY && i >= 0 && j >= 0)
                {
                    if (field[j][i]==c) {
                        countMainDiagDot++;
                        if (countMainDiagDot == countWinDot) return true;
                    } else {
                        countMainDiagDot = 0;
                    }
                }
            }
        }
        //Проверка по всем побочным диагоналям
        for (int k = 0; k < fieldSizeY * 2; k++)
        {
            countSecondDiagDot = 0;
            for (int j = 0; j <= k; j++)
            {
                int i = k - j;
                if (i < fieldSizeY && j < fieldSizeX)
                {
                    if (field[i][j]==c) {
                        countSecondDiagDot++;
                        if (countSecondDiagDot == countWinDot) return true;
                    } else {
                        countSecondDiagDot = 0;
                    }
                }
            }
        }

//            //Проверка горизонталей
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//        //Проверка вертикалей
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
//        //Проверка диагоналей
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    //Проверка на возможную победу через 1 ход
    private static boolean checkPreWin(char c) {
        int countHorDot = 0;
        int countVertDot = 0;
        int countMainDiagDot = 0;
        int countSecondDiagDot = 0;
        for (int i = 0; i < fieldSizeY; i++){
            countHorDot = 0;
            for (int j = 0; j < fieldSizeX; j++){
                if (field[i][j] == c) {
                    countHorDot++;
                    if (countHorDot == countWinDot-1) return true;
                } else countHorDot = 0;

            }
        }

        for (int i = 0; i < fieldSizeX; i++){
            countVertDot = 0;
            for (int j = 0; j < fieldSizeY; j++){
                if (field[j][i] == c) {
                    countVertDot++;
                    if (countVertDot == countWinDot-1) return true;
                } else countVertDot = 0;
            }
        }

        for (int k = fieldSizeX; k >= -fieldSizeX; k--)
        {
            countMainDiagDot = 0;
            for (int j = 0; j < fieldSizeY - k; j++)
            {
                int i = k + j;
                if (i < fieldSizeX && j < fieldSizeY && i >= 0 && j >= 0)
                {
                    if (field[j][i]==c) {
                        countMainDiagDot++;
                        if (countMainDiagDot == countWinDot-1) return true;
                    } else {
                        countMainDiagDot = 0;
                    }
                }
            }
        }

        for (int k = 0; k < fieldSizeY * 2; k++)
        {
            countSecondDiagDot = 0;
            for (int j = 0; j <= k; j++)
            {
                int i = k - j;
                if (i < fieldSizeY && j < fieldSizeX)
                {
                    if (field[i][j]==c) {
                        countSecondDiagDot++;
                        if (countSecondDiagDot == countWinDot-1) return true;
                    } else {
                        countSecondDiagDot = 0;
                    }
                }
            }
        }

        return false;
    }

    //Проверка на ничью
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    //Инициализация игрового поля
    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    //Вывод на печать игрового поля
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2+1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeY * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    //Проверка ячейки на пустое значение
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    //Проверка на валидность ячейки с координатами
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    //------------------------------------------------------------

    //Задание 5.
    private static void fillArraySnake(int x, int y) {
        int direction = 0;      //направление движения 0 - право, 1 - вниз, 2 - влево, 3 - вверх
        int currentX = 0;       //Текущая координата X
        int currentY = 0;       //Текущая координата Y
        int nextVal = 0;        //Следующее значение в массиве
        int currentVal = 1;     //Значение, которое добавляем в массив, счетчик
        int shift = 0;          //Смещение
        int endNumber = x * y;  //Конечное значение, по которому мы определим, что пора выходить из цикла
        int[][] arraySnake = new int[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++) {
                arraySnake[i][j] = 0;
            }
        }
        //printArraySnake(arraySnake);
        try {
            do {
                arraySnake[currentY][currentX] = currentVal;
                //printArraySnake(arraySnake);
                if (direction == 0 ) {
                    if (currentX < y - 1 - shift) {
                        currentX++;
                        currentVal++;
                    } else {
                        direction = 1;
                        continue;
                    }
                } else if (direction == 1) {
                    if (currentY < x - 1 - shift) {
                        currentY++;
                        currentVal++;
                    } else {
                        direction = 2;
                        continue;
                    }
                } else if (direction == 2) {
                    if (currentX > 0 + shift) {
                        currentX--;
                        currentVal++;
                    } else {
                        direction = 3;
                        continue;
                    }
                }
                else if (direction == 3) {
                    if (currentY > 1 + shift) {
                        currentY--;
                        currentVal++;
                    } else {
                        direction = 0 ;
                        shift++;
                        currentX++;
                        currentVal++;
                        continue;
                    }
                }
                nextVal = arraySnake[currentY][currentX];
            } while (currentVal < endNumber+1);
        }
        catch (Exception Err) {
            printArraySnake(arraySnake);
            System.out.println("currentY:" + currentY + "  currentX:" + currentX);
        }
        printArraySnake(arraySnake);
    }
    //Метод для вывода массива со змейкой
    private static void printArraySnake(int [][] arrToPrint) {
        for (int i = 0; i < arraySizeX; i++) {
            System.out.print("|");
            for (int j = 0; j < arraySizeY; j++)
                System.out.print("\t" + arrToPrint[i][j] + "\t|");
            System.out.println();
            System.out.println();
        }
        System.out.println("****************************");
    }
    //-------------------------------------------------------------
}
