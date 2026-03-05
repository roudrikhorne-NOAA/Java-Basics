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
            keyboard.nextLine(); // Buffer Flush

            // 1. Calculate the Gross (Before Taxes)
            double grossEarnings = calculateEarnings(targetRate, actualHours);
            
            // 2. NEW: Calculate the Net (After 15% Tax)
            double netEarnings = calculateNetPay(grossEarnings);

            System.out.println("--- Profile Result ---");
            System.out.println("Name: " + myName);
            System.out.printf("Gross Weekly: $%.2f%n", grossEarnings);
            System.out.printf("Net (After 15%% Tax): $%.2f%n", netEarnings);
            displayStatus(netEarnings);

            grandTotalPayroll += netEarnings; 
            payrollSummary.add(String.format("%s: $%.2f (Net)", myName, netEarnings));

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        System.out.println("\n========== FINAL PAYROLL SUMMARY (NET) ==========");
        for (String record : payrollSummary) {
            System.out.println(record);
        }
        System.out.println("-------------------------------------------");
        System.out.printf("TOTAL NET DISBURSEMENT: $%.2f%n", grandTotalPayroll);
        System.out.println("===========================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    }

    // --- TOOL 1: Gross Earnings (With Overtime) ---
    public static double calculateEarnings(double rate, int hours) {
        if (hours > 40) {
            return (40 * rate) + ((hours - 40) * (rate * 1.5));
        } else {
            return rate * hours;
        }
    }

    // --- NEW TOOL 2: The Tax Man (15% Withholding) ---
    public static double calculateNetPay(double gross) {
        double taxRate = 0.15; // 15% Total Withholding
        return gross * (1 - taxRate); // Returns 85% of the total
    }

    public static void displayStatus(double earnings) {
        if (earnings >= 3000) System.out.println("Status: Elite!");
        else if (earnings >= 2000) System.out.println("Status: Goal Achieved!");
        else System.out.println("Status: Keep climbing!");
    }
}