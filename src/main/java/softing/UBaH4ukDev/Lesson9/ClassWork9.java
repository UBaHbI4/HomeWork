package softing.UBaH4ukDev.Lesson9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
