package hu.kincstar.javasetraining.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Tasks {
    private List<Task> taskList = new ArrayList<>();

    public Tasks(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Tasks() {

    }

    @Override
    public String toString() {
        String retVal;
        retVal =  "Feladatok:\n";
        for (int i = 0; i < this.taskList.size(); i++) {
            Task task = this.taskList.get(i);
            retVal = retVal + "     Feladat azonosítója:      " + task.getTaskId() + '\n';
            retVal = retVal + "     Feladat tulajdonosa:      " + task.getTaskOwner() + '\n';
            retVal = retVal + "     Becsült végrehajtási idő: " + task.getTaskTime() + '\n';
            retVal = retVal + "     Feladat státusza:         " + task.getTaskStatus().getText() + '\n';
            retVal = retVal + "     Feladat leírása:          " + task.getTaskDescription() + '\n';
            retVal = retVal + "     Feladat kapcsolatai:      " + '\n';
            for (int j = 0; j < task.getTaskConnectionType().size(); j++) {
                retVal = retVal + "          Kapcsolt feladat azonosítója: " + task.getTaskConnectionType().get(j).getTaskId() + '\n';
                retVal = retVal + "          Kapcsolat minősége:           " + task.getTaskConnectionType().get(j).getTaskConnectionType().getText() + '\n';
            }
            retVal = retVal + '\n';
        }
        return retVal;
    }

    public void setTaskList(Task task) {
        this.taskList.add(task);
    }

    public String getOneStatus(Status state) {
        try {
            String retVal;
            int cnt = 0;
            if (state.equals(Status.NEW)) {
                throw new IllegalArgumentException("Új státuszú feladatok lekérdezésére nincs lehetőség!" + '\n');
            }
            retVal = state.getText() + " feladatok:\n";
            for (int i = 0; i < this.taskList.size(); i++) {
                Task task = this.taskList.get(i);
                if (task.getTaskStatus().equals(state)) {
                    retVal = retVal + "     Feladat azonosítója:      " + task.getTaskId() + '\n';
                    retVal = retVal + "     Feladat tulajdonosa:      " + task.getTaskOwner() + '\n';
                    retVal = retVal + "     Becsült végrehajtási idő: " + task.getTaskTime() + '\n';
                    retVal = retVal + "     Feladat státusza:         " + task.getTaskStatus().getText() + '\n';
                    retVal = retVal + "     Feladat leírása:          " + task.getTaskDescription() + '\n';
                    retVal = retVal + "     Feladat kapcsolatai:      " + '\n';
                    for (int j = 0; j < task.getTaskConnectionType().size(); j++) {
                        retVal = retVal + "          Kapcsolt feladat azonosítója: " + task.getTaskConnectionType().get(j).getTaskId() + '\n';
                        retVal = retVal + "          Kapcsolat minősége:           " + task.getTaskConnectionType().get(j).getTaskConnectionType().getText() + '\n';
                    }
                    retVal = retVal + '\n';
                    cnt = cnt + 1;
                }
            }
            if (cnt == 0) {
                throw new NoSuchElementException("Nincs ilyen státuszú feladat." + '\n');
            }
            return retVal;
        } catch (Exception e) {
            return "\033[31mMegadott státuszú feladatok lekérdezése: " + e.getMessage() + "\033[0m";
        }
    }

    public String getOneOwner(String owner) {
        try {
            String retVal;
            int cnt = 0;
            if (owner == "" || owner == null) {
                throw new NullPointerException("Nem megfelelő paraméter(üres vagy null)!" + '\n');
            }
            retVal = owner + " feladatai:\n";
            for (int i = 0; i < this.taskList.size(); i++) {
                Task task = this.taskList.get(i);
                if (task.getTaskOwner().equals(owner)) {
                    retVal = retVal + "     Feladat azonosítója:      " + task.getTaskId() + '\n';
                    retVal = retVal + "     Feladat tulajdonosa:      " + task.getTaskOwner() + '\n';
                    retVal = retVal + "     Becsült végrehajtási idő: " + task.getTaskTime() + '\n';
                    retVal = retVal + "     Feladat státusza:         " + task.getTaskStatus().getText() + '\n';
                    retVal = retVal + "     Feladat leírása:          " + task.getTaskDescription() + '\n';
                    retVal = retVal + "     Feladat kapcsolatai:      " + '\n';
                    for (int j = 0; j < task.getTaskConnectionType().size(); j++) {
                        retVal = retVal + "          Kapcsolt feladat azonosítója: " + task.getTaskConnectionType().get(j).getTaskId() + '\n';
                        retVal = retVal + "          Kapcsolat minősége:           " + task.getTaskConnectionType().get(j).getTaskConnectionType().getText() + '\n';
                    }
                    retVal = retVal + '\n';
                    cnt = cnt + 1;
                }
            }
            if (cnt == 0) {
                throw new NoSuchElementException("Nincs " + owner + " felhasználóhoz tartozó feladat." + '\n');
            }
            return retVal;
        } catch (Exception e) {
            return "\033[31mEgy felhasználóhoz tartozó feladatok lekérdezése: " + e.getMessage() + "\033[0m";
        }
    }

    public Boolean setStatus(int id, Status state) {
        try {
            int cnt = 0;
            for (int i = 0; i < this.taskList.size(); i++) {
                Task task = this.taskList.get(i);
                if (task.getTaskId() == id) {
                    if (state.equals(Status.NEW)) {
                        throw new IllegalArgumentException("Feladat státusza nem állítható be \'Új\'-ra!" + '\n');
                    }
                    if (task.getTaskStatus().equals(Status.NEW) && (!state.equals(Status.IN_PROGRESS) || !state.equals(Status.BLOCKED))) {
                        throw new IllegalStateException("A státusz \'Új\'-ból csak \'Folyamatban lévő\' vagy \'Blokkolt\' státuszba állítható!" + '\n');
                    }
                    if (task.getTaskStatus().equals(Status.BLOCKED) && !state.equals(Status.IN_PROGRESS)) {
                        throw new IllegalStateException("A státusz \'Blokkolt\'-ból csak \'Folyamatban lévő\' státuszba állítható!" + '\n');
                    }
                    if (state.equals(Status.DONE) && !task.getTaskStatus().equals(Status.IN_PROGRESS)) {
                        throw new IllegalStateException("A státusz \'Kész\'-re csak \'Folyamatban lévő\' státuszból állítható!" + '\n');
                    }
                    if (state.equals(Status.DONE)) {
                        List<TasksConnection> connections = task.getTaskConnectionType();
                        for (int j = 0; j < connections.size(); j++) {
                            if (connections.get(j).getTaskConnectionType().equals(ConnectionType.CHILD)) {
                                int id1 = connections.get(j).getTaskId();
                                for (int k = 0; k < this.taskList.size(); k++) {
                                    Task task2 = this.taskList.get(k);
                                    if (task2.getTaskId() == id1) {
                                        if (!task2.getTaskStatus().equals(Status.DONE)) {
                                            throw new IllegalStateException("A státusz nem állítható \'Kész\'-re, mert vannak még nem kész státuszú, gyermek kapcsolatú feladatok." + '\n');
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (state.equals(Status.IN_PROGRESS)) {
                        List<TasksConnection> connections = task.getTaskConnectionType();
                        for (int l = 0; l < connections.size(); l++) {
                            if (connections.get(l).getTaskConnectionType().equals(ConnectionType.PREDECESSOR)) {
                                int id2 = connections.get(l).getTaskId();
                                for (int m = 0; m < this.taskList.size(); m++) {
                                    Task task2 = this.taskList.get(m);
                                    if (task2.getTaskId() == id2) {
                                        if (!task2.getTaskStatus().equals(Status.DONE)) {
                                            throw new IllegalStateException("A státusz nem állítható \'Folyamatban lévő\'-re, mert vannak még nem kész státuszú, előd kapcsolatú feladatok." + '\n');
                                        }
                                    }
                                }
                            }
                        }
                    }
                    task.setTaskStatus(state);
                    System.out.println("\033[32mStátuszállítás: Sikeres státuszállítás.\033[0m" + '\n');
                    cnt = cnt + 1;
                }
            }
            if (cnt == 0) {
                throw new NoSuchElementException("Nincs ilyen azonosítójú feladat." + '\n');
            }
            return true;
        } catch (Exception e) {
            System.out.println("\033[31mStátuszállítás: " + e.getMessage() + "\033[0m");
            return false;
        }
    }

    public Boolean deleteTask(int id) {
        try {
            int cnt = 0;
            for (int i = 0; i < this.taskList.size(); i++) {
                Task task = this.taskList.get(i);
                if (task.getTaskId() == id) {
                    List<TasksConnection> connections = task.getTaskConnectionType();
                    for (int j = 0; j < connections.size(); j++) {
                        if (connections.get(j).getTaskConnectionType().equals(ConnectionType.CHILD)) {
                            throw new IllegalStateException("A feladat nem törölhető, mert vannak hozzá tartozó gyermek feladatok." + '\n');
                        }
                    }
                    if (!task.getTaskStatus().equals(Status.DONE)) {
                        throw new IllegalStateException("A feladat nem törölhető, mert nincs \'Kész\' státuszban." + '\n');
                    }
                    this.taskList.remove(i);
                    System.out.println("\033[32mFeladat törlése: Sikeres törlés.\033[0m" + '\n');
                    cnt = cnt + 1;
                }
                List<TasksConnection> connections2 = task.getTaskConnectionType();
                for (int k = 0; k < connections2.size(); k++) {
                    if (connections2.get(k).getTaskId() == id) {
                        connections2.remove(k);
                    }
                }
            }
            if (cnt == 0) {
                throw new NoSuchElementException("Nincs ilyen azonosítójú feladat." + '\n');
            }
            return true;
        } catch (Exception e) {
            System.out.println("\033[31mFeladat törlése: " + e.getMessage() + "\033[0m");
            return false;
        }
    }

    public Boolean setConnetions(int id1, int id2, ConnectionType connType) {
        try {
            int cnt = 0;
            Boolean id1Ok = false;
            Boolean id2Ok = false;
            for (int i = 0; i < this.taskList.size(); i++) {
                Task task = this.taskList.get(i);
                if (task.getTaskId() == id1) {
                    id1Ok = true;
                }
                if (task.getTaskId() == id2) {
                    id2Ok = true;
                }
            }
            if (id1Ok && id2Ok) {
                for (int j = 0; j < this.taskList.size(); j++) {
                    Task task2 = this.taskList.get(j);
                    if (task2.getTaskId() == id1) {
                        TasksConnection taskConnection = new TasksConnection(id2, connType);
                        task2.getTaskConnectionType().add(taskConnection);
                        System.out.println("\033[32mKapcsolat beállítása: Sikeres kapcsolás.\033[0m" + '\n');
                        cnt = cnt + 1;
                    }
                }
                if (connType.equals(ConnectionType.CHILD) || connType.equals(ConnectionType.PARENT)) {
                    for (int k = 0; k < this.taskList.size(); k++) {
                        Task task3 = this.taskList.get(k);
                        if (task3.getTaskId() == id2) {
                            if (connType.equals(ConnectionType.CHILD)) {
                                TasksConnection taskConnection2 = new TasksConnection(id1, ConnectionType.PARENT);
                                task3.getTaskConnectionType().add(taskConnection2);
                            } else {
                                TasksConnection taskConnection2 = new TasksConnection(id1, ConnectionType.CHILD);
                                task3.getTaskConnectionType().add(taskConnection2);
                            }
                            System.out.println("\033[32mKapcsolat beállítása: Sikeres kapcsolás.\033[0m" + '\n');
                            cnt = cnt + 1;
                        }
                    }
                }
            }
            if (cnt == 0) {
                throw new NoSuchElementException("Nincs ilyen azonosítójú feladat, a kapcsolat beállítása nem lehetséges." + '\n');
            }
            return true;
        } catch (Exception e) {
            System.out.println("\033[31mKapcsolat beállítása: " + e.getMessage() + "\033[0m");
            return false;
        }
    }
}
