import java.util.*;

public class Scheduler {

    public static List<String> schedule(List<Process> processes) {
        List<String> timeline = new ArrayList<>();
        int time = 0;
        int completed = 0;
        int n = processes.size();

        while (completed < n) {
            Process current = null;

            for (Process p : processes) {
                if (p.arrivalTime <= time && !p.isCompleted) {
                    if (current == null ||
                            p.priority < current.priority ||
                            (p.priority == current.priority && p.remainingTime < current.remainingTime)) {
                        current = p;
                    }
                }
            }

            if (current != null) {
                if (current.startTime == -1) {
                    current.startTime = time;
                }

                timeline.add("Time " + time + ": P" + current.pid);
                current.remainingTime--;

                if (current.remainingTime == 0) {
                    current.completionTime = time + 1;
                    current.isCompleted = true;
                    completed++;
                }
            } else {
                timeline.add("Time " + time + ": Idle");
            }

            time++;
        }

        return timeline;
    }
}
