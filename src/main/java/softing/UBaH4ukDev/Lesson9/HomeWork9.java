package softing.UBaH4ukDev.Lesson9;

import java.sql.*;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson9

 Created by Ivan Sheynmaer

 2021.02.02
 v1.0
 */
public class HomeWork9 {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;


    public static void main(String[] args) {
        //Массив котов
        Cat[] cats = {
                        new Cat("Мурзик", "трехцветный", 9f, "сибирский"),
                        new Cat("Васька", "рыжий", 6f, "сиамский"),
                        new Cat("Барсик", "белый", 4.5f, "бенгальский"),
                        new Cat("Ушастик", "серый", 4.9f, "домашний"),
                        new Cat()
        };


        System.out.println("Список котов из массива, который мы будем сохранять в БД..");
        printArray(cats);
        System.out.println();

        //Создаем/подключаемся базу/к базе
        System.out.println("Создание (если отсутствует) базы catDB.db и connect..");
        connect();
        System.out.println();

        try {
            statement = connection.createStatement();

            //Тест Задание2.
            //Создаем таблицу с котами, если нету
            System.out.println("Создание таблицы Cats в БД (если ее нету) ..");
            createCatsTable();
            System.out.println();


            //Очистим таблицу и обнулим автоикрементное поле
            System.out.println("Очистка  таблицы Cats..");
            System.out.println("Удалено " + clearCatsTable() + " записей.");
            System.out.println();

            //Тест Задание4
            //Сохраним котов в базу
            System.out.println("Добавление котов с массива cats в БД в таблицу Cats..");
            System.out.println("Добавлено " + saveCatsToBase(cats) + " записей в БД.");
            System.out.println();

            //Тест Задание3.
            //Выведем котов с базы
            getCatsFromBase();
            System.out.println();

            //Тест Задание5.
            //Удалим кота по CatID
            System.out.println("Удалим кота с CatID=2..");
            System.out.println("Удалено " + deleteCats(2) + " записей.");
            System.out.println();

            //Выведем котов с базы
            getCatsFromBase();
            System.out.println();

            //Тест Задание5.
            //Удалим кота по имени
            System.out.println("Удалим кота с именем Барсик");
            System.out.println("Удалено " + deleteCats("Барсик") + " записей.");
            System.out.println();

            //Выведем котов с базы
            getCatsFromBase();
            System.out.println();

            //Тест Задание6.
            //Изменим кота с CatID=5
            System.out.println("Изменим кота с CatID=5. Сделаем name: 'Василий', color: 'черный', weigth: 10f, race: 'сиамский'");
            System.out.println("Обновлено " + updateCatByID(5,"Василий", "черный", 10f, "сиамский") + " записей.");
            //System.out.println("Обновлено " + updateCatByID(4,"", "", 10f, "") + " записей.");
            System.out.println();

            //Выведем котов с базы
            getCatsFromBase();
            System.out.println();

            //Закрываем соединение
            disconnect();

            //Закрываем statement и ps
            statement.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод печати в консоль содержимого массива котов
    private static void printArray(Cat[] arrCats) {
        for(Cat cat : arrCats) {
            System.out.println(cat.toString());
        }
    }

    //Метод создания(если отсутствует) БД и соединения с БД lesson.db
    private static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:catsDB.db");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод закрытия соединения
    private static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод для очистки таблицы Cats и обнуления автоинкрементного поля CatID.
    //Возвращает количество удаленных строк
    private static int clearCatsTable() {
        int result = 0;
        try {
            result = statement.executeUpdate("DELETE FROM Cats;");
            statement.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='Cats';");
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    //Задание2.
    //Метод создания таблицы Cats в БД
    private static void createCatsTable () {
        try {
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS Cats " +
                            "(" +
                            "CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "Name TEXT NOT NULL," +
                            "Color TEXT NOT NULL," +
                            "Weight DECIMAL NOT NULL," +
                            "Race TEXT NOT NULL" +
                            ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //Задание4.
    //Метод для сохранения массива котов в БД
    private static int saveCatsToBase(Cat[] cats) {
        int result = 0;
        try {
            ps = connection.prepareStatement("INSERT INTO Cats (Name, Color, Weight, Race) VALUES(?, ?, ?, ?);");
            for(Cat cat : cats) {
                ps.setString(1, cat.getName());
                ps.setString(2, cat.getColor());
                ps.setFloat(3, cat.getWeight());
                ps.setString(4, cat.getRace());
                if (ps.executeUpdate() > 0) result++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }

    //Задание3.
    //Метод для печати в консоль содержимого таблицы Cats
    private static void getCatsFromBase() {
        //Выведем внесенные записи
        System.out.println("Содержимое таблицы Cats:");
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Cats;");
            while (rs.next()) {
                System.out.println("CatID: " + rs.getInt("CatID") +" Кот " + rs.getString("Name") +
                        " цвет: " + rs.getString("Color") +
                        " вес: " + rs.getFloat("Weight") +
                        " порода: " + rs.getString("Race"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Метод для удаления кота по его ID
    private static int deleteCats(int catID) {
        try {
            return statement.executeUpdate("DELETE FROM Cats WHERE CatID = " + catID + ";");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    //Задание5.
    //Метод для удаления кота по его имени
    private static int deleteCats(String name) {
        try {
            return statement.executeUpdate("DELETE FROM Cats WHERE name = '" + name + "';");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    //Задание6.
    //Метод для обновления кота по его ID
    private static int updateCatByID (int CatID, String name, String color, Float weight, String race) {
        try {
            return statement.executeUpdate("UPDATE Cats SET name='" + (name != "" ? name : "unknown") +
                                                             "', color='" + (color != "" ? color : "unknown")+
                                                             "', weight=" + weight +
                                                             ", race='" + (race != "" ? race : "unknown") +
                                                             "' WHERE CatID=" + CatID + ";");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
