import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.print("\nEnter developer name: ");
            String myName = keyboard.nextLine(); // Grabs the whole line including spaces

            System.out.print("Enter target hourly rate: ");
            double targetRate = keyboard.nextDouble();
            keyboard.nextLine(); // "Flushes" the buffer to prevent skipping the next name

            // --- CALLING THE METHOD ---
            // Instead of doing the math here, we ask our "tool" for the answer
            double weeklyEarnings = calculateEarnings(targetRate);

            System.out.println("--- Profile Result ---");
            System.out.println("Name: " + myName);
            System.out.println("Weekly: $" + weeklyEarnings);

            displayStatus(weeklyEarnings); // Another method call!

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        System.out.println("Thanks for using the Guru Career Tracker. Goodbye!");
        keyboard.close();
    }

    // --- NEW METHOD 1: The Calculator ---
    // This method takes a 'rate' and returns the final math result
    public static double calculateEarnings(double rate) {
        return rate * 40;
    }

    // --- NEW METHOD 2: The Logic Gate ---
    // This handles the "Status" printing to keep our 'main' section clean
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