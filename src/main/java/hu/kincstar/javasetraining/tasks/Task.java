package hu.kincstar.javasetraining.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int taskId;
    private String taskOwner;
    private int taskTime;
    private Status taskStatus;
    private String taskDescription;
    private List<TasksConnection> taskConnectionType = new ArrayList<>();

    public Task(int taskId, String taskOwner, int taskTime, Status taskStatus, String taskDescription) {
        ProcessTime ptime = new ProcessTime();
        if (!ptime.getProcessTime(taskTime)) {
            throw new IllegalArgumentException("Feladat azonosító: " + taskId + " => " + "A megadott végrehajtási idő(" + taskTime + ") nem megfelelő! Csak a Fibonacci sorozat elemei adhatók meg.");
        }
        this.taskId = taskId;
        this.taskOwner = taskOwner;
        this.taskTime = taskTime;
        this.taskStatus = taskStatus;
        this.taskDescription = taskDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskOwner() {
        return taskOwner;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public List<TasksConnection> getTaskConnectionType() {
        return taskConnectionType;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskConnectionType(List<TasksConnection> taskConnectionType) {
        this.taskConnectionType = taskConnectionType;
    }
}
