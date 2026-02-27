import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            
            System.out.print("\nEnter developer name: ");
            // FIX 1: Use nextLine() to allow spaces in names
            String myName = keyboard.nextLine(); 

            System.out.print("Enter target hourly rate: ");
            double targetRate = keyboard.nextDouble();
            
            // FIX 2: This "flushes" the buffer so the next loop works
            keyboard.nextLine(); 

            double weeklyEarnings = targetRate * 40;

            System.out.println("--- Profile Result ---");
            System.out.println("Name: " + myName);
            System.out.println("Weekly: $" + weeklyEarnings);

            if (weeklyEarnings >= 3000) {
                System.out.println("Status: Elite Level Developer!");
            } else if (weeklyEarnings >= 2000) {
                System.out.println("Status: Goal Achieved!");
            } else {
                System.out.println("Status: Keep climbing!");
            }

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine(); // Use nextLine here too
        }

        System.out.println("Thanks for using the Guru Career Tracker. Goodbye!");
        keyboard.close();
    }
}