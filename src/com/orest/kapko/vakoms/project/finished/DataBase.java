package com.orest.kapko.vakoms.project.finished;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПІДКЛЮЧЕННЯ ДО БАЗИ ДАНИХ--------
    public static void conToDB() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Test.s3db");

        System.out.println("База Підключена!");
    }

    // --------Створення таблиці--------
    public static void createDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Name' text, 'Email' text);");

        System.out.println("Таблицю створено або така уже існує.");
    }

    // --------Оновлення інфи в таблиці--------
    public static void updateUser() throws SQLException
    {
        statmt.executeUpdate("UPDATE 'users' SET name = 'Andriy', Email = 'andy_fox@gmail.com' WHERE id = 3");

        System.out.println("Інформацію про користувача оновлено");
    }

    // --------Видалення користувача з таблиці--------
    public static void deleteUser() throws SQLException
    {
        statmt.execute("DELETE FROM 'users' WHERE id = 9");

        System.out.println("Користувача видалено");
    }

    // --------Додавання нового користувача в таблицю--------
    public static void addNewUser() throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('name', 'Email') VALUES ('Oleg', 'oleg19992@mail.ru'); ");
        statmt.execute("INSERT INTO 'users' ('name', 'Email') VALUES ('Misha', 'misha_2017@ukr.net'); ");

        System.out.println("Таблицю заповнено");
    }

    // -------- Вивід таблиці--------
    public static void getAllUsers() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            String phone = resSet.getString("Email");
            System.out.println("ID = " + id );
            System.out.println("name = " + name );
            System.out.println("Email = " + phone );
            System.out.println();
        }

        System.out.println("Таблицю виведено");
    }

    // --------Закриття--------
    public static void closeDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();
        System.out.println("Всі з'єднання успішно закрито");
    }
}