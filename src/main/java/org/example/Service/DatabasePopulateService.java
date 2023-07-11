package org.example.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabasePopulateService {

    public static void main(String[] args) {
        String populateDbFilename  = "./sql/populate_db.sql";

        String sql;
        try {
            sql = Files.readString(Path.of(populateDbFilename ));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            Statement statement = Database.getInstance().getConnection().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to initialize database.");
        }
    }
}