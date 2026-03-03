import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.print("\nEnter developer name: ");
            String myName = keyboard.nextLine();

            System.out.print("Enter target hourly rate: ");
            double targetRate = keyboard.nextDouble();
            
            // NEW: Ask for hours instead of assuming 40
            System.out.print("Enter hours worked this week: ");
            int actualHours = keyboard.nextInt();
            
            keyboard.nextLine(); // Still need to flush that buffer!

            // --- THE SMART METHOD CALL ---
            // We are now sending TWO values to the method
            double weeklyEarnings = calculateEarnings(targetRate, actualHours);

            System.out.println("--- Profile Result ---");
            System.out.println("Name: " + myName);
            System.out.println("Weekly: $" + weeklyEarnings);

            displayStatus(weeklyEarnings);

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        System.out.println("Thanks for using the Guru Career Tracker. Goodbye!");
        keyboard.close();
    }

// --- UPDATED METHOD: The Overtime-Aware Calculator ---
    public static double calculateEarnings(double rate, int hours) {
        if (hours > 40) {
            int overtimeHours = hours - 40;
            double regularPay = 40 * rate;
            double overtimePay = overtimeHours * (rate * 1.5);
            return regularPay + overtimePay;
        } else {
            return rate * hours;
        }
    } // This brace closes the method

    // --- NEW METHOD 2: The Logic Gate ---
    public static void displayStatus(double earnings) {
        if (earnings >= 3000) {
            System.out.println("Status: Elite Level Developer!");
        } else if (earnings >= 2000) {
            System.out.println("Status: Goal Achieved!");
        } else {
            System.out.println("Status: Keep climbing!");
        }
    } // This brace closes displayStatus
} // <--- THIS IS THE MISSING BRACE that closes the whole Class!