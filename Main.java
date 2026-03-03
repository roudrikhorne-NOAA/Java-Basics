import java.util.Scanner;
import java.util.ArrayList; // NEW: Tells Java we want to use Lists

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // NEW: This list will store a summary string for every person entered
        ArrayList<String> payrollSummary = new ArrayList<>(); 
        
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.print("\nEnter developer name: ");
            String myName = keyboard.nextLine();

            System.out.print("Enter target hourly rate: ");
            double targetRate = keyboard.nextDouble();
            
            System.out.print("Enter hours worked: ");
            int actualHours = keyboard.nextInt();
            keyboard.nextLine(); // "Flush" the buffer

            double weeklyEarnings = calculateEarnings(targetRate, actualHours);

            System.out.println("--- Profile Result ---");
            System.out.println("Name: " + myName + " | Total: $" + weeklyEarnings);
            displayStatus(weeklyEarnings);

            // NEW: Add the data to our "Digital Clipboard"
            payrollSummary.add(myName + ": $" + weeklyEarnings);

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        // --- NEW: THE FINAL REPORT ---
        System.out.println("\n========== FINAL PAYROLL SUMMARY ==========");
        for (String record : payrollSummary) {
            System.out.println(record);
        }
        System.out.println("===========================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    }

    // Your existing methods stay here...
    public static double calculateEarnings(double rate, int hours) {
        if (hours > 40) {
            return (40 * rate) + ((hours - 40) * (rate * 1.5));
        } else {
            return rate * hours;
        }
    }

    public static void displayStatus(double earnings) {
        if (earnings >= 3000) System.out.println("Status: Elite!");
        else if (earnings >= 2000) System.out.println("Status: Goal Achieved!");
        else System.out.println("Status: Keep climbing!");
    }
}