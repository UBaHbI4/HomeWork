package softing.UBaH4ukDev.Lesson9;

import java.sql.*;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson9

 Created by Ivan Sheynmaer

 2021.02.02
 v1.0
 */
public class ClassWork9 {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        //Вызываем метод для соединения с БД
        connect();

        try {
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS Students " +
                            "(" +
                            "StudID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "Name TEXT NOT NULL," +
                            "GroupName TEXT NOT NULL," +
                            "Score INTEGER NOT NULL" +
                            ");");


            //Очистим таблицу и занесем 5 записей
            System.out.println("Удалено: " + statement.executeUpdate("DELETE FROM Students;") + " записей");
            statement.executeUpdate("INSERT INTO Students (Name, GroupName, Score) VALUES ('Иван', '1', 150);");
            statement.executeUpdate("INSERT INTO Students (Name, GroupName, Score) VALUES ('Сергей', '2', 250);");
            statement.executeUpdate("INSERT INTO Students (Name, GroupName, Score) VALUES ('Николай', '2', 350);");
            statement.executeUpdate("INSERT INTO Students (Name, GroupName, Score) VALUES ('Александр', '3', 400);");
            statement.executeUpdate("INSERT INTO Students (Name, GroupName, Score) VALUES ('Дмитрий', '4', 100);");

            //Выведем внесенные записи
            System.out.println("В таблице Students есть следующие записи:");
            ResultSet rs = statement.executeQuery("SELECT Name, Score FROM Students;");
            while (rs.next()) {
                System.out.println("Student " + rs.getString("Name") + " score: " + rs.getInt(2));
            }
            System.out.println();

            //Удалим одну запись
            System.out.println("Удалим запись с именем Николай");
            System.out.println("Удалено: " + statement.executeUpdate("DELETE FROM Students WHERE Name = 'Николай';") + " записей.");

            System.out.println();

            //Выведем внесенные записи
            System.out.println("В таблице Students есть следующие записи:");
            rs = statement.executeQuery("SELECT Name, Score FROM Students;");
            while (rs.next()) {
                System.out.println("Student " + rs.getString("Name") + " score: " + rs.getInt(2));
            }

            System.out.println();

            //Обновим одну запись, изменим Score у Ивана
            System.out.println("Обновим одну запись, изменим Score у Ивана");
            System.out.println("Обновлено: " + statement.executeUpdate("UPDATE Students SET Score = 500 WHERE Name = 'Иван';") + " записей.");

            System.out.println();

            //Выведем внесенные записи
            System.out.println("В таблице Students есть следующие записи:");
            rs = statement.executeQuery("SELECT Name, Score FROM Students;");
            while (rs.next()) {
                System.out.println("Student " + rs.getString("Name") + " score: " + rs.getInt(2));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Метод сработал");
    }

    //Метод создания(если отсутствует) и соединения с БД lesson.db
    private static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson.db");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
