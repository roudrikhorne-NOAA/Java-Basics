import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // POLYMORPHISM: This list now holds Developers, Managers, AND Contractors!
        ArrayList<Developer> payrollList = new ArrayList<>(); 
        
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.println("\n--- New Employee ---");
            System.out.print("Is this a (1) Developer, (2) Manager, or (3) Contractor? Enter 1, 2, or 3: ");
            int employeeType = keyboard.nextInt();
            keyboard.nextLine(); // Buffer Flush

            System.out.print("Enter name: ");
            String name = keyboard.nextLine();

            System.out.print("Enter hourly rate: ");
            double rate = keyboard.nextDouble();
            
            System.out.print("Enter hours worked: ");
            int hours = keyboard.nextInt();

            // --- THE 3-WAY BRANCHING PATH ---
            if (employeeType == 2) {
                // Option 2: It's a Manager!
                System.out.print("Enter weekly bonus: ");
                double bonus = keyboard.nextDouble();
                keyboard.nextLine(); // Buffer Flush
                
                Manager mgr = new Manager(name, rate, hours, bonus);
                payrollList.add(mgr); 
                
                System.out.println("--- Manager Profile Created ---");
                System.out.printf("Gross: $%.2f | Net (with bonus): $%.2f%n", mgr.calculateGross(), mgr.calculateNet());
                
            } else if (employeeType == 3) {
                // Option 3: It's a Contractor!
                keyboard.nextLine(); // Buffer Flush
                
                Contractor cont = new Contractor(name, rate, hours);
                payrollList.add(cont); 
                
                System.out.println("--- Contractor Profile Created ---");
                System.out.printf("Gross: $%.2f | Net (NO overtime): $%.2f%n", cont.calculateGross(), cont.calculateNet());
                
            } else {
                // Option 1: It's a normal Developer!
                keyboard.nextLine(); // Buffer Flush
                
                Developer dev = new Developer(name, rate, hours);
                payrollList.add(dev); 
                
                System.out.println("--- Developer Profile Created ---");
                System.out.printf("Gross: $%.2f | Net: $%.2f%n", dev.calculateGross(), dev.calculateNet());
            }

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        // --- FINAL REPORT (Polymorphism in Action!) ---
        System.out.println("\n========== WEEK 5 POLYMORPHISM REPORT ==========");
        for (Developer d : payrollList) {
            // Java looks at the object and automatically knows which math to use!
            System.out.printf("Name: %-15s | Net Pay: $%.2f%n", d.getName(), d.calculateNet());
        }
        System.out.println("====================================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    }
}