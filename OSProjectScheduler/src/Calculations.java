import java.util.List;
public class Calculations {

    public static void ProcessStatistics(List<Process> processes) {
        int totalTurnaround= 0;
        int totalWaiting= 0;
        int totalResponse= 0;
        int n= processes.size();

        System.out.println("\nPID  Arrival  Burst  Priority  Start  Completion  Turnaround  Wait  Response");
        
        for (Process proc : processes) {
            int turnaround= proc.completionTime - proc.arrivalTime;
            int waiting= turnaround - proc.burstTime;
            int response= proc.startTime - proc.arrivalTime;

            totalTurnaround += turnaround;
            totalWaiting += waiting;
            totalResponse += response;

            System.out.printf(
                "%-4d %-8d %-6d %-9d %-6d %-12d %-11d %-5d %-8d%n",
                proc.pid, 
                proc.arrivalTime, 
                proc.burstTime, 
                proc.priority,
                proc.startTime,
                proc.completionTime,
                turnaround,
                waiting,
                response
            );
        }

        //calculating average for all of them
        double avgTurnaround= (double) totalTurnaround / n;
        double avgWaiting= (double) totalWaiting / n;
        double avgResponse= (double) totalResponse / n;

        System.out.println("\nAverages:");
        System.out.printf("Average Turnaround Time: %.2f%n", avgTurnaround);
        System.out.printf("Average Waiting Time   : %.2f%n", avgWaiting);
        System.out.printf("Average Response Time  : %.2f%n", avgResponse);
    }
}