package org.example.dto;

public class ProjectPrices {
    int projectId;
    int projectCost;

    public ProjectPrices(int projectId, int projectCost) {
        this.projectId = projectId;
        this.projectCost = projectCost;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getProjectCost() {
        return projectCost;
    }
}
