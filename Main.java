import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // NEW: We are now storing actual Developer OBJECTS, not just Strings!
        ArrayList<Developer> payrollList = new ArrayList<>(); 
        
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.print("\nEnter developer name: ");
            String name = keyboard.nextLine();

            System.out.print("Enter hourly rate: ");
            double rate = keyboard.nextDouble();
            
            System.out.print("Enter hours worked: ");
            int hours = keyboard.nextInt();
            keyboard.nextLine(); // Buffer Flush

            // --- THE OOP WAY ---
            // 1. Create a new Developer object using your "Blueprint"
            Developer dev = new Developer(name, rate, hours);
            
            // 2. Add the whole "Person" to our list
            payrollList.add(dev);

            System.out.println("--- Profile Created ---");
            System.out.printf("Gross: $%.2f | Net: $%.2f%n", dev.calculateGross(), dev.calculateNet());

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        // --- FINAL REPORT ---
        System.out.println("\n========== WEEK 4 OBJECT-ORIENTED REPORT ==========");
        for (Developer d : payrollList) {
            System.out.printf("Name: %-15s | Net Pay: $%.2f%n", d.getName(), d.calculateNet());
        }
        System.out.println("====================================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    }
}// Final Week 4 Check