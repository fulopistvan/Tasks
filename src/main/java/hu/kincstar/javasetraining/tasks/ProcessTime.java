package hu.kincstar.javasetraining.tasks;

import java.util.ArrayList;
import java.util.List;

public class ProcessTime {
    public List<Integer> processTimes = new ArrayList<>();

    public ProcessTime(List<Integer> processTimes) {
        this.processTimes = processTimes;
    }

    public ProcessTime() {

    }

    public List<Integer> getProcessTimes() {
        return processTimes;
    }

    public boolean getProcessTime(int time) {
        int first = 0;
        int second = 1;
        int sum = 0;

        for (int i = 0; i < 1000; i++) {
            sum = first + second;
            this.processTimes.add(sum);
            first = second;
            second = sum;
        }

        if (processTimes.contains(time)) {
            return true;
        } else {
            return false;
        }
    }
}
