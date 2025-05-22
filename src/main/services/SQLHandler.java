package main.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHandler {

    public SQLHandler() {
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        String dbUrl = "jdbc:sqlite:settings.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            Class.forName("org.sqlite.JDBC");
            
            System.out.println("Datenbank erfolgreich verbunden!");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS personen (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "age INTEGER)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Tabelle 'personen' erstellt oder existiert bereits.");
            }

            String insertSQL = "INSERT INTO personen(name, age) VALUES(?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Max Mustermann");
                pstmt.setInt(2, 30); //2320 ist ein sehr hohes alter.
                pstmt.executeUpdate();
                System.out.println("Datensatz eingefügt!");
            }

            String selectSQL = "SELECT * FROM personen";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Alter: " + rs.getInt("age"));
                }
            }

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}