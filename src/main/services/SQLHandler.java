/**
 * Copyright 2025 Jim Feser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * @see <a href="https://www.apache.org/licenses/LICENSE-2.0.txt">Apache License 2.0</a>
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Software obtained from:
 * 
 * @see <a href="https://github.com/xerial/sqlite-jdbc">slite-jdbc</a>
 */


package main.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * SQLHandler is a service that manages SQLite database operations.
 * It connects to a SQLite database, creates a table if it doesn't exist,
 * inserts a record, and retrieves records from the table.
 * This class demonstrates basic CRUD operations using JDBC.
 */
public class SQLHandler {

    /**
     * Default constructor for SQLHandler.
     * Initializes the SQLHandler instance.
     */
    public SQLHandler() {
    }

    /**
     * The main method that serves as the entry point for the SQLHandler application.
     * It connects to a SQLite database, creates a table if it doesn't exist,
     * inserts a record, and retrieves records from the table.
     *
     * @param args command line arguments (not used)
     */
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