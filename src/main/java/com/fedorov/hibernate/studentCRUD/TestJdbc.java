package com.fedorov.hibernate.studentCRUD;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {


    public static void main(String[] args) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hibernatedb", "admin",
                "123456")) {
            System.out.println(c.isValid(0));

        }
    }

}
