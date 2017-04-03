package com.orest.kapko.vakoms.project.finished;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПІДКЛЮЧЕННЯ ДО БАЗИ ДАНИХ--------
    public static void conToDB() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Test.s3db");

        System.out.println("База Подключена!");
    }

    // --------Створення таблиці--------
    public static void createDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Оновлення інфи в таблиці--------
    public static void updateUser() throws SQLException
    {
        statmt.execute("UPDATE 'users' SET name = 'Orest', phone = '0000000' WHERE id = 3");

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
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Oleg', 125453); ");

        System.out.println("Таблица заполнена");
    }

    // -------- Вивід таблиці--------
    public static void getAllUsers() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            String phone = resSet.getString("phone");
            System.out.println("ID = " + id );
            System.out.println("name = " + name );
            System.out.println("phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // --------Закриття--------
    public static void closeDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();
        System.out.println("Соединения закрыты");
    }

}
