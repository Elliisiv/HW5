package org.example.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NewDatabasePopulateService {

    public NewDatabasePopulateService() {
    }
    private static final String CLIENTS_FILE = "./sql/populate_client.sql";
    private static final String PROJECTS_FILE = "./sql/populate_project.sql";
    private static final String PROJECT_WORKERS_FILE = "./sql/populate_project_worker.sql";
    private static final String WORKERS_FILE = "./sql/populate_worker.sql";

    public static void populateClients(Connection connection) throws SQLException {
        String query = "INSERT INTO client (NAME) VALUES (?)";
        File file = new File(CLIENTS_FILE);
        List<String> clients;
        try {
            clients = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + CLIENTS_FILE + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String client : clients) {
                preparedStatement.setString(1, client);
                preparedStatement.executeUpdate();
            }
        }
    }
    public static void populateProjects(Connection connection) throws SQLException {
        String query = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)";
        File file = new File(PROJECTS_FILE);
        List<String> projectsTable;
        try {
            projectsTable = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + PROJECTS_FILE + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String project : projectsTable) {
                String[] projectValues = project.split(",");
                int clientId = Integer.parseInt(projectValues[0].trim());
                Date startDate = Date.valueOf(projectValues[1].trim().replace("'", ""));
                Date finishDate = Date.valueOf(projectValues[2].trim().replace("'", ""));

                preparedStatement.setInt(1, clientId);
                preparedStatement.setDate(2, startDate);
                preparedStatement.setDate(3, finishDate);
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void populateProjectWorkers(Connection connection) throws SQLException {
        String query = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)";
        File file = new File(PROJECT_WORKERS_FILE);

        List<String> ProjectWorkersTable;
        try {
            ProjectWorkersTable = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + PROJECT_WORKERS_FILE + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String projectWorkers : ProjectWorkersTable) {
                String[] projectWorkerValues = projectWorkers.split(",");
                int projectId = Integer.parseInt(projectWorkerValues[0].trim());
                int workerId = Integer.parseInt(projectWorkerValues[1].trim().replace("'", ""));

                preparedStatement.setInt(1, projectId);
                preparedStatement.setInt(2, workerId);
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void populateWorkers(Connection connection) throws SQLException {
        String query = "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)";
        File file = new File(WORKERS_FILE);

        List<String> workersTable;
        try {
            workersTable = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + WORKERS_FILE + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String worker : workersTable) {
                String[] workerInfo = worker.split(",");
                String name = (workerInfo[0].trim());
                Date birthday = Date.valueOf(workerInfo[1].trim().replace("'", ""));
                String level = (workerInfo[2].trim().replace("'", ""));
                int salary = Integer.parseInt(workerInfo[3].trim().replace("'", ""));

                preparedStatement.setString(1, name);
                preparedStatement.setDate(2, birthday);
                preparedStatement.setString(3, level);
                preparedStatement.setInt(4, salary);
                preparedStatement.executeUpdate();
            }
        }
    }
}
