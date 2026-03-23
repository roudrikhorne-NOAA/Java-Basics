import java.io.File; // NEW: Needed to check if the file exists
import java.util.Scanner;
import java.util.ArrayList;
// NEW IMPORTS FOR WEEK 7:
import java.io.FileWriter;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Developer> payrollList = new ArrayList<>(); 
        // --- STARTUP: LOAD PREVIOUS SQUAD DATA ---
        File database = new File("Payroll_Report.txt");

        if (database.exists()) {
            System.out.println("📂 Accessing Vice Dossiers... Found existing Payroll Report.");
            System.out.println("========== PREVIOUS SESSION DATA ==========");
            try {
                Scanner fileReader = new Scanner(database);
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    System.out.println(data);
                }
                fileReader.close();
                System.out.println("===========================================\n");
            } catch (Exception e) {
                System.out.println("❌ Could not read the existing dossier.");
            }
        } else {
            System.out.println("🆕 No existing dossier found. Starting a fresh report.");
        }
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

        // --- WEEK 7: SAVING TO A FILE ---
        System.out.println("\nGenerating and saving report to Payroll_Report.txt...");

        try {
            // 1. Create the File and the Writer
           FileWriter fileWriter = new FileWriter("Payroll_Report.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // 2. Write the exact same report directly to the file!
            printWriter.println("========== WEEK 7 FILE I/O REPORT ==========");
            for (Developer d : payrollList) {
                // Notice we use printWriter.printf instead of System.out.printf!
                printWriter.printf("Name: %-15s | Net Pay: $%.2f%n", d.getName(), d.calculateNet());
            }
            printWriter.println("====================================================");

            // 3. CLOSE THE VAULT DOOR (Absolutely Crucial!)
            printWriter.close();
            
            System.out.println("✅ Report successfully saved to your hard drive!");

        } catch (Exception e) {
            System.out.println("❌ ERROR: Could not save the file to the hard drive.");
        }
        
        System.out.println("Goodbye!");
        keyboard.close();
    }
}
