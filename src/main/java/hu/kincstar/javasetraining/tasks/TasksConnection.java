package hu.kincstar.javasetraining.tasks;

public class TasksConnection {
    private int taskId;
    private ConnectionType taskConnectionType;

    public TasksConnection(int taskId, ConnectionType taskConnectionType) {
        this.taskId = taskId;
        this.taskConnectionType = taskConnectionType;
    }

    public int getTaskId() {
        return taskId;
    }

    public ConnectionType getTaskConnectionType() {
        return taskConnectionType;
    }

    public void setTaskConnectionType(ConnectionType taskConnectionType) {
        this.taskConnectionType = taskConnectionType;
    }

    @Override
    public String toString() {
        return "TasksConnection{" +
                "taskId=" + taskId +
                ", taskConnectionType=" + taskConnectionType +
                '}';
    }
}
