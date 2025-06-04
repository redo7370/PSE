/*
 * PSE - Periodic System of Elements (Learn and Information Application)
 * Copyright (C) 2025 Jim Feser
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact:
 *  Github: https://github.com/jimfeserHTW
 *
 * If this program interacts with users remotely through a computer network,
 * it must provide a way for users to get its source code, for example by
 * offering a “Source” link in the user interface (see section 13 of the AGPL).
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