package hu.kincstar.javasetraining.tasks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TasksTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void setTaskExecutionTimeShouldThrowException() {
        exception.expect(IllegalArgumentException.class);

        Task task = new Task(1, "Benny Hill", 9, Status.NEW, "Teszt feladat");
    }

    @Test
    public void getOneStatusNEWShouldThrowException() {
        Status status = Status.NEW;

        exception.expect(GetOneStatusException.class);

        Tasks tasks = new Tasks();
        tasks.getOneStatus(status);
    }

    @Test
    public void getOneStatusNotFoundShouldThrowException() {
        Status status = Status.IN_PROGRESS;

        exception.expect(GetOneStatusException.class);

        Tasks tasks = new Tasks();
        tasks.getOneStatus(status);
    }

    @Test
    public void getOneOwnerEmptyStringShouldThrowException() {
        String str = "";

        exception.expect(GetOneOwnerException.class);

        Tasks tasks = new Tasks();
        tasks.getOneOwner(str);
    }

    @Test
    public void getOneOwnerNullStringShouldThrowException() {
        String str = null;

        exception.expect(GetOneOwnerException.class);

        Tasks tasks = new Tasks();
        tasks.getOneOwner(str);
    }

    @Test
    public void getOneOwnerNotFoundShouldThrowException() {
        String str = "Benny Hill";

        exception.expect(GetOneOwnerException.class);

        Tasks tasks = new Tasks();
        tasks.getOneOwner(str);
    }

    @Test
    public void setStatusNEWShouldThrowException() {
        Status status = Status.NEW;

        exception.expect(SetStatusException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.IN_PROGRESS, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.setStatus(1, status);
    }

    @Test
    public void setStatusFromNEWShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(SetStatusException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.NEW, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.setStatus(1, status);
    }

    @Test
    public void setStatusFromBLOCKEDShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(SetStatusException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.BLOCKED, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.setStatus(1, status);
    }

    @Test
    public void setStatusDONEWhenCHILDNotDONEShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(SetStatusException.class);

        Task task1 = new Task(1, "Benny Hill", 8, Status.IN_PROGRESS, "Teszt feladat");
        Task task2 = new Task(2, "Rowan Atkinson", 5, Status.IN_PROGRESS, "Teszt gyerek feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setConnetions(1, 2, ConnectionType.CHILD);
        tasks.setStatus(1, status);
    }

    @Test
    public void setStatusNotFoundShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(SetStatusException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.IN_PROGRESS, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.setStatus(2, status);
    }

    @Test
    public void deleteTaskWhenGotCHILDShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(DeleteTaskException.class);

        Task task1 = new Task(1, "Benny Hill", 8, Status.DONE, "Teszt feladat");
        Task task2 = new Task(2, "Rowan Atkinson", 5, Status.IN_PROGRESS, "Teszt gyerek feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setConnetions(1, 2, ConnectionType.CHILD);
        tasks.deleteTask(1);
    }

    @Test
    public void deleteTaskWhenNotDONEShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(DeleteTaskException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.IN_PROGRESS, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.deleteTask(1);
    }

    @Test
    public void deleteTaskNotFoundShouldThrowException() {
        Status status = Status.DONE;

        exception.expect(DeleteTaskException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.IN_PROGRESS, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.deleteTask(2);
    }

    @Test
    public void setConnectionAlreadyExistsShouldThrowException() {

        exception.expect(SetConnectionException.class);

        Task task1 = new Task(1, "Benny Hill", 8, Status.DONE, "Teszt feladat");
        Task task2 = new Task(2, "Rowan Atkinson", 5, Status.IN_PROGRESS, "Teszt gyerek feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setConnetions(1, 2, ConnectionType.CHILD);
        tasks.setConnetions(1, 2, ConnectionType.CHILD);
    }

    @Test
    public void setConnectionReverseShouldThrowException() {

        exception.expect(SetConnectionException.class);

        Task task1 = new Task(1, "Benny Hill", 8, Status.DONE, "Teszt feladat");
        Task task2 = new Task(2, "Rowan Atkinson", 5, Status.IN_PROGRESS, "Teszt gyerek feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setConnetions(1, 2, ConnectionType.CHILD);
        tasks.setConnetions(2, 1, ConnectionType.PRECEDESSOR);
    }

    @Test
    public void setConnectionReconnectShouldThrowException() {

        exception.expect(SetConnectionException.class);

        Task task1 = new Task(1, "Benny Hill", 8, Status.DONE, "Teszt feladat");
        Task task2 = new Task(2, "Rowan Atkinson", 5, Status.IN_PROGRESS, "Teszt gyerek feladat");
        Task task3 = new Task(3, "Stephen Fry", 3, Status.IN_PROGRESS, "Teszt gyerek 2. feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setTaskList(task3);
        tasks.setConnetions(1, 2, ConnectionType.PARENT);
        tasks.setConnetions(1, 3, ConnectionType.PARENT);
    }

    @Test
    public void setConnectionNotFoundShouldThrowException() {

        exception.expect(SetConnectionException.class);

        Task task = new Task(1, "Benny Hill", 8, Status.DONE, "Teszt feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task);
        tasks.setConnetions(1, 2, ConnectionType.PARENT);
    }
}
