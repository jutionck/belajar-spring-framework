package com.enigmacamp.mandiri;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/spring_demo_one?useSSL=false&serverTimezone=UTC";
        String user = "userdemo";
        String pass = "userdemo";

        try {
            System.out.println("Connecting to database " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
