import java.util.*;

public class TestScheduler {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Sample hardcoded data: pid, arrival, burst, priority
        processes.add(new Process(1, 0, 5, 2));
        processes.add(new Process(2, 1, 3, 1));
        processes.add(new Process(3, 2, 1, 3));
        processes.add(new Process(4, 3, 2, 2));

        List<String> output = Scheduler.schedule(processes);

        for (String line : output) {
            System.out.println(line);
        }

        System.out.println("\nProcess Completion Times:");
        for (Process p : processes) {
            System.out.println("P" + p.pid + " -> Completed at time: " + p.completionTime);
        }
    }
}

