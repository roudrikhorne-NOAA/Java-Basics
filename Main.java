import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // POLYMORPHISM: This list can now hold BOTH Developers and Managers!
        ArrayList<Developer> payrollList = new ArrayList<>(); 
        
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.println("\n--- New Employee ---");
            System.out.print("Is this a (1) Normal Developer or (2) Manager? Enter 1 or 2: ");
            int employeeType = keyboard.nextInt();
            keyboard.nextLine(); // Buffer Flush

            System.out.print("Enter name: ");
            String name = keyboard.nextLine();

            System.out.print("Enter hourly rate: ");
            double rate = keyboard.nextDouble();
            
            System.out.print("Enter hours worked: ");
            int hours = keyboard.nextInt();

            // --- THE BRANCHING PATH ---
            if (employeeType == 2) {
                // It's a Manager! Ask for the bonus.
                System.out.print("Enter weekly bonus: ");
                double bonus = keyboard.nextDouble();
                keyboard.nextLine(); // Buffer Flush
                
                // Build a Manager object
                Manager mgr = new Manager(name, rate, hours, bonus);
                payrollList.add(mgr); // Add to the master list
                
                System.out.println("--- Manager Profile Created ---");
                System.out.printf("Gross: $%.2f | Net (with bonus): $%.2f%n", mgr.calculateGross(), mgr.calculateNet());
                
            } else {
                // It's a normal Developer!
                keyboard.nextLine(); // Buffer Flush
                
                // Build a Developer object
                Developer dev = new Developer(name, rate, hours);
                payrollList.add(dev); // Add to the master list
                
                System.out.println("--- Developer Profile Created ---");
                System.out.printf("Gross: $%.2f | Net: $%.2f%n", dev.calculateGross(), dev.calculateNet());
            }

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        // --- FINAL REPORT (Polymorphism in Action!) ---
        System.out.println("\n========== WEEK 5 POLYMORPHISM REPORT ==========");
        for (Developer d : payrollList) {
            // Java automatically knows which calculateNet() to call!
            System.out.printf("Name: %-15s | Net Pay: $%.2f%n", d.getName(), d.calculateNet());
        }
        System.out.println("====================================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    }
}