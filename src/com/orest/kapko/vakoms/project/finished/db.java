package com.orest.kapko.vakoms.project.finished;

import java.sql.SQLException;

public class db {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conn.conToDB();
        conn.createDB();
        conn.updateUser();
        conn.deleteUser();
        conn.addNewUser();
        conn.getAllUsers();
        conn.closeDB();
    }
}