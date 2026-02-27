import java.util.Scanner; // This tells Java we need the "Listening" tool

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Scanner
        Scanner keyboard = new Scanner(System.in);

        // 2. Ask for the User's Name
        System.out.print("Enter your name: ");
        String myName = keyboard.nextLine(); // Waits for you to type and hit Enter

        // 3. Ask for the Hourly Rate
        System.out.print("Enter your target hourly rate: ");
        double targetRate = keyboard.nextDouble();

        // 4. Calculations (Same as Week 1)
        int hoursPerWeek = 40;
        double weeklyEarnings = targetRate * hoursPerWeek;

        // 5. Output
        System.out.println("\n--- Developer Profile ---");
        System.out.println("Name: " + myName);
        System.out.println("Weekly Earnings: $" + weeklyEarnings);

        if (weeklyEarnings >= 2000) {
            System.out.println("Status: Goal Achieved!");
        } else {
            System.out.println("Status: Keep climbing!");
        }

        // 6. Close the scanner (Good "Guru" habit!)
        keyboard.close();
    }
}