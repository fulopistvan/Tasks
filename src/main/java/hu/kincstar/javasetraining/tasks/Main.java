package hu.kincstar.javasetraining.tasks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task(1, "John Cleese", 8, Status.NEW, "Első feladat");
        Task task2 = new Task(2, "John Cleese", 21, Status.NEW, "Második feladat");
        Task task3 = new Task(3, "Eric Idle", 34, Status.IN_PROGRESS, "Harmadik feladat");
        Task task4 = new Task(4, "Eric Idle", 5, Status.IN_PROGRESS, "Negyedik feladat");
        Task task5 = new Task(5, "Graham Chapman", 13, Status.BLOCKED, "Ötödik feladat");
        Task task6 = new Task(6, "Graham Chapman", 2, Status.DONE, "Hatodik feladat");
        Task task7 = new Task(7, "Michael Palin", 1, Status.DONE, "Hetedik feladat");
        Task task8 = new Task(8, "Michael Palin", 55, Status.IN_PROGRESS, "Nyolcadik feladat");
        Task task9 = new Task(9, "Terry Jones", 3, Status.NEW, "Kilencedik feladat");
        Task task10 = new Task(10, "Terry Jones", 89, Status.IN_PROGRESS, "Tizedik feladat");
        Task task11 = new Task(11, "Terry Gilliam", 144, Status.BLOCKED, "Tizenegyedik feladat");
        Task task12 = new Task(12, "Terry Gilliam", 233, Status.DONE, "tizenkettedik feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setTaskList(task3);
        tasks.setTaskList(task4);
        tasks.setTaskList(task5);
        tasks.setTaskList(task6);
        tasks.setTaskList(task7);
        tasks.setTaskList(task8);
        tasks.setTaskList(task9);
        tasks.setTaskList(task10);
        tasks.setTaskList(task11);
        tasks.setTaskList(task12);

        System.out.println(tasks.getOneStatus(Status.IN_PROGRESS));

        System.out.println(tasks.getOneOwner("Benny Hill"));

        tasks.setConnetions(1, 3, ConnectionType.CHILD);
        tasks.setConnetions(1, 5, ConnectionType.CHILD);
        tasks.setConnetions(1, 7, ConnectionType.CHILD);
        tasks.setConnetions(4, 6, ConnectionType.CHILD);
        tasks.setConnetions(4, 8, ConnectionType.PARENT);
        tasks.setConnetions(4, 3, ConnectionType.PARENT);
        tasks.setConnetions(3, 4, ConnectionType.PRECEDESSOR);
        tasks.setConnetions(4, 3, ConnectionType.CHILD);
        tasks.setConnetions(8, 4, ConnectionType.PRECEDESSOR);

        System.out.println(tasks.toString());

        tasks.setStatus(8, Status.DONE);
        tasks.setStatus(3, Status.IN_PROGRESS);
        tasks.setStatus(10, Status.IN_PROGRESS);

        tasks.deleteTask(4);
        tasks.deleteTask(3);

        System.out.println(tasks.toString());
    }
}
