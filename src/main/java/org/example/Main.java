package org.example;

import org.example.Service.Database;
import org.example.Service.DatabaseInitService;

import org.example.Service.DatabaseQueryService;
import org.example.Service.NewDatabasePopulateService;
import org.example.dto.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            NewDatabasePopulateService populateService = new NewDatabasePopulateService();
            try {
                populateService.populateClients(connection);
                populateService.populateProjects(connection);
                populateService.populateProjectWorkers(connection);
                populateService.populateWorkers(connection);

                System.out.println("Data population completed.");
            } catch (SQLException e) {
                System.out.println("Error executing SQL statements: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing database connection: " + e.getMessage());
                }
            }
        }
//        DatabaseQueryService queryService = new DatabaseQueryService();
//
//        queryService.findMaxProjectsClient();
//        queryService.findMaxSalaryWorker();
//        queryService.findLongestProject();
//        queryService.findYoungestEldestWorkers();
//        queryService.printProjectPrices();
}

