import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> payrollSummary = new ArrayList<>(); 
        double grandTotalPayroll = 0.0; 
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.print("\nEnter developer name: ");
            String myName = keyboard.nextLine(); 

            System.out.print("Enter target hourly rate: ");
            double targetRate = keyboard.nextDouble();
            
            System.out.print("Enter hours worked: ");
            int actualHours = keyboard.nextInt();
            keyboard.nextLine(); // Flush buffer

            double weeklyEarnings = calculateEarnings(targetRate, actualHours);

            System.out.println("--- Profile Result ---");
            System.out.println("Name: " + myName + " | Total: $" + weeklyEarnings);
            displayStatus(weeklyEarnings);

            grandTotalPayroll += weeklyEarnings; 
            payrollSummary.add(myName + ": $" + weeklyEarnings);

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine(); 
        }

        // --- FINAL REPORT WITH PROFESSIONAL FORMATTING ---
        System.out.println("\n========== FINAL PAYROLL SUMMARY ==========");
        for (String record : payrollSummary) {
            System.out.println(record);
        }
        System.out.println("-------------------------------------------");
        
        // This line formats the total to 2 decimal places
        System.out.printf("TOTAL PAYROLL SPEND: $%.2f%n", grandTotalPayroll);
        System.out.println("===========================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    } // Closes Main method

    // --- YOUR TOOLS (Methods) ---
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
} // Closes the Class