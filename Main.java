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

    // --- UPDATED METHOD 1: The Flexible Calculator ---
    // Now it accepts 'rate' AND 'hours'
    public static double calculateEarnings(double rate, int hours) {
        return rate * hours;
    }

    public static void displayStatus(double earnings) {
        if (earnings >= 3000) {
            System.out.println("Status: Elite Level Developer!");
        } else if (earnings >= 2000) {
            System.out.println("Status: Goal Achieved!");
        } else {
            System.out.println("Status: Keep climbing!");
        }
    }
}