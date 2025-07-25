import java.util.*;

// Class to represent a process with its relevant attributes
class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int priority;
    int remainingTime;
    int completionTime;
    int waitingTime;
    int turnaroundTime;
    int responseTime;
    boolean isFirstResponse;

    // Constructor initializes basic process values
    public Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.isFirstResponse = true;
    }
}

public class PrioritySRTFScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();

        System.out.println("Enter process ID, Arrival Time, Burst Time, and Priority (Terminate with 0 0 0 0):");

        while (true) {
            try {
                String input = scanner.nextLine().trim();

                // Validate that input contains exactly 4 integers
                if (!input.matches("^\\d+ \\d+ \\d+ \\d+$")) {
                    System.out.println("Invalid input. Please enter exactly 4 integers separated by spaces.");
                    continue;
                }

                // Split and parse input values
                String[] parts = input.split(" ");
                int id = Integer.parseInt(parts[0]);
                int arrivalTime = Integer.parseInt(parts[1]);
                int burstTime = Integer.parseInt(parts[2]);
                int priority = Integer.parseInt(parts[3]);

                // Stop reading input if user enters 0 0 0 0
                if (id == 0 && arrivalTime == 0 && burstTime == 0 && priority == 0) {
                    break;
                }

                // Create a new process and add it to the list
                processes.add(new Process(id, arrivalTime, burstTime, priority));
            } catch (Exception e) {
                // Catch parsing errors and prompt user to retry
                System.out.println("Invalid input. Please ensure you enter 4 integers.");
            }
        }

        // At this point, all valid process data is collected and stored
        
        scanner.close();
    }
}
