package hu.kincstar.javasetraining.tasks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task(1, "Monty Python", 8, Status.NEW, "Első feladat");
        Task task2 = new Task(2, "Black Adder", 21, Status.NEW, "Második feladat");
        Task task3 = new Task(3, "Monty Python", 34, Status.IN_PROGRESS, "Harmadik feladat");
        Task task4 = new Task(4, "Black Adder", 5, Status.IN_PROGRESS, "Negyedik feladat");
        Task task5 = new Task(5, "Benny Hill", 13, Status.BLOCKED, "Ötödik feladat");
        Task task6 = new Task(6, "Mr. Bean", 2, Status.DONE, "Hatodik feladat");
        Task task7 = new Task(7, "Mr. Bean", 1, Status.DONE, "Hetedik feladat");
        Task task8 = new Task(8, "Benny Hill", 55, Status.IN_PROGRESS, "Nyolcadik feladat");
        Tasks tasks = new Tasks();
        tasks.setTaskList(task1);
        tasks.setTaskList(task2);
        tasks.setTaskList(task3);
        tasks.setTaskList(task4);
        tasks.setTaskList(task5);
        tasks.setTaskList(task6);
        tasks.setTaskList(task7);
        tasks.setTaskList(task8);

        System.out.println(tasks.getOneStatus(Status.IN_PROGRESS));

        System.out.println(tasks.getOneOwner("Benny Hill"));

        tasks.setConnetions(1, 3, ConnectionType.CHILD);
        tasks.setConnetions(1, 5, ConnectionType.CHILD);
        tasks.setConnetions(1, 7, ConnectionType.CHILD);
        tasks.setConnetions(4, 6, ConnectionType.CHILD);
        tasks.setConnetions(4, 8, ConnectionType.PARENT);
        tasks.setConnetions(3, 4, ConnectionType.PREDECESSOR);

        System.out.println(tasks.toString());

        tasks.setStatus(8, Status.DONE);
        tasks.setStatus(3, Status.IN_PROGRESS);

        tasks.deleteTask(4);
        tasks.deleteTask(3);

        System.out.println(tasks.toString());
    }
}
