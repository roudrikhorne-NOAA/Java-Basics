import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Developer> payrollList = new ArrayList<>(); 
        
        String continueRunning = "y";

        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.println("\n--- New Employee ---");
            
            // 🛡️ --- INDESTRUCTIBLE EMPLOYEE TYPE TRAP ---
            int employeeType = 0;
            boolean validEmployeeType = false;
            while (!validEmployeeType) {
                try {
                    System.out.print("Is this a (1) Developer, (2) Manager, or (3) Contractor? Enter 1, 2, or 3: ");
                    employeeType = keyboard.nextInt();
                    validEmployeeType = true; // Success! Break the loop.
                } catch (Exception e) {
                    System.out.println("❌ ERROR: Please enter a valid number (1, 2, or 3).");
                    keyboard.nextLine(); // Flush the scanner toilet!
                }
            }
            keyboard.nextLine(); // Buffer Flush after a successful number

            System.out.print("Enter name: ");
            String name = keyboard.nextLine();

            // 🛡️ --- INDESTRUCTIBLE RATE TRAP ---
            double rate = 0;
            boolean validRate = false;
            while (!validRate) {
                try {
                    System.out.print("Enter hourly rate: ");
                    rate = keyboard.nextDouble();
                    validRate = true; 
                } catch (Exception e) {
                    System.out.println("❌ ERROR: Please enter a valid number (e.g., 65 or 65.50).");
                    keyboard.nextLine(); 
                }
            }

            // 🛡️ --- INDESTRUCTIBLE HOURS TRAP ---
            int hours = 0;
            boolean validHours = false;
            while (!validHours) {
                try {
                    System.out.print("Enter hours worked: ");
                    hours = keyboard.nextInt();
                    validHours = true; 
                } catch (Exception e) {
                    System.out.println("❌ ERROR: Please enter a whole number for hours (e.g., 40).");
                    keyboard.nextLine(); 
                }
            }

            // --- THE 3-WAY BRANCHING PATH ---
            if (employeeType == 2) {
                // 🛡️ --- INDESTRUCTIBLE BONUS TRAP (For Managers Only) ---
                double bonus = 0;
                boolean validBonus = false;
                while (!validBonus) {
                    try {
                        System.out.print("Enter weekly bonus: ");
                        bonus = keyboard.nextDouble();
                        validBonus = true;
                    } catch (Exception e) {
                        System.out.println("❌ ERROR: Please enter a valid number for the bonus.");
                        keyboard.nextLine();
                    }
                }
                keyboard.nextLine(); // Buffer Flush
                
                Manager mgr = new Manager(name, rate, hours, bonus);
                payrollList.add(mgr); 
                System.out.println("--- Manager Profile Created ---");
                System.out.printf("Gross: $%.2f | Net (with bonus): $%.2f%n", mgr.calculateGross(), mgr.calculateNet());
                
            } else if (employeeType == 3) {
                keyboard.nextLine(); // Buffer Flush
                Contractor cont = new Contractor(name, rate, hours);
                payrollList.add(cont); 
                System.out.println("--- Contractor Profile Created ---");
                System.out.printf("Gross: $%.2f | Net (NO overtime): $%.2f%n", cont.calculateGross(), cont.calculateNet());
                
            } else {
                keyboard.nextLine(); // Buffer Flush
                Developer dev = new Developer(name, rate, hours);
                payrollList.add(dev); 
                System.out.println("--- Developer Profile Created ---");
                System.out.printf("Gross: $%.2f | Net: $%.2f%n", dev.calculateGross(), dev.calculateNet());
            }

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        // --- FINAL REPORT ---
        System.out.println("\n========== WEEK 6 INDESTRUCTIBLE REPORT ==========");
        for (Developer d : payrollList) {
            System.out.printf("Name: %-15s | Net Pay: $%.2f%n", d.getName(), d.calculateNet());
        }
        System.out.println("====================================================");
        
        System.out.println("Goodbye!");
        keyboard.close();
    }
}