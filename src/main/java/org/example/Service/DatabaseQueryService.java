package org.example.Service;

import org.example.dto.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {


    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFilename = "./sql/find_max_projects_client.sql";
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Highest number of orders from client:");

            while (resultSet.next()) {
                String name = resultSet.getString("nameCl");
                int projectCount = resultSet.getInt("cl.cnt");

                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                result.add(client);
                System.out.println("Name: " + name + ", Project count: " + projectCount);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilename = "./sql/find_max_salary_worker.sql";
        List<MaxSalaryWorker> result = new ArrayList<>();

        System.out.println("\n" + "Employee with the maximum salary:");

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");

                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(name, salary);
                result.add(maxSalaryWorker);
                System.out.println("Name: " + name + ", salary: " + salary);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        String sqlFilename = "./sql/find_longest_project.sql";
        List<LongestProject> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n" + "The longest project in terms of time:");

            while (resultSet.next()) {
                int projectId = resultSet.getInt("ID");
                int duration = resultSet.getInt("MONTH_COUNT");

                LongestProject longestProject = new LongestProject(projectId, duration);
            result.add(new LongestProject(projectId, duration));
                System.out.println("Id_Project: " + projectId + ", duration: " + duration);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        String sqlFilename = "./sql/find_youngest_eldest_workers.sql";
        List<YoungestEldestWorkers> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n" + "The oldest and youngest employees:");

            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");

                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(name,type, birthday);
                result.add(youngestEldestWorkers);
                System.out.println("Name: " + name + ", type of age: " + type +  ", day of birth: " + birthday);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProjectPrices> printProjectPrices() {
        String sqlFilename = "./sql/print_project_prices.sql";
        List<ProjectPrices> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n" + "Price of projects:");

            while (resultSet.next()) {
                int projectId = resultSet.getInt("PROJECT_ID");
                int projectCost = resultSet.getInt("PROJECT_COST");

                ProjectPrices projectPrices = new ProjectPrices(projectId,projectCost);
                result.add(projectPrices);
                System.out.println("Project id: " + projectId + ", total cost : " + projectCost);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}