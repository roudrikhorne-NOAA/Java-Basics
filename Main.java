import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
                    System.out.println(fileReader.nextLine());
                }
                fileReader.close();
                System.out.println("===========================================\n");
            } catch (Exception e) {
                System.out.println("❌ Could not read the existing dossier.");
            }
        } else {
            System.out.println("🆕 No existing dossier found. Starting a fresh report.");
        }

        // --- WEEK 8: SQUAD SECTOR INTEL (NETWORKING) ---
        System.out.print("📡 Target City? (Miami, Portland, or NYC - Press Enter for Miami): ");
        String cityInput = keyboard.nextLine().trim().toLowerCase();
        
        String lat, lon, cityName;
        
        // The Geocoding Translator (Switch Statement)
        switch (cityInput) {
            case "portland":
                lat = "45.52"; lon = "-122.67"; cityName = "PORTLAND";
                break;
            case "nyc":
            case "new york":
                lat = "40.71"; lon = "-74.00"; cityName = "NEW YORK CITY";
                break;
            default:
                lat = "25.77"; lon = "-80.19"; cityName = "MIAMI";
                break;
        }

        System.out.println("🛰️ Connecting to Satellite for " + cityName + "...");
        
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&current_weather=true"))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String rawJson = response.body();

            // --- UPDATED INTEL PARSING (Hunting the LAST occurrence) ---
            int tempStart = rawJson.lastIndexOf("\"temperature\":") + 14;
            int tempEnd = rawJson.indexOf(",", tempStart);
            double tempC = Double.parseDouble(rawJson.substring(tempStart, tempEnd));
            
            double tempF = (tempC * 1.8) + 32; 

            int windStart = rawJson.lastIndexOf("\"windspeed\":") + 12;
            int windEnd = rawJson.indexOf(",", windStart);
            String wind = rawJson.substring(windStart, windEnd);

            int timeStart = rawJson.lastIndexOf("\"time\":\"") + 8;
            int timeEnd = rawJson.indexOf("\"", timeStart);
            String time = rawJson.substring(timeStart, timeEnd);

            System.out.println("✅ CONNECTION SECURE - SECTOR " + cityName + ":");
            System.out.printf("🌡️  Temperature: %.1f°C - %.1f°F%n", tempC, tempF);
            System.out.println("💨 Windspeed: " + wind + " km/h");
            System.out.println("🕒 Time: " + time);
            System.out.println("🏁 Intel: " + (tempF > 75 ? "Perfect weather for a ride in the Ferrari." : "Stay in the squad car."));
            System.out.println("-------------------------------------------\n");

        } catch (Exception e) {
            System.out.println("❌ SATELLITE OFFLINE: " + e.getMessage());
            e.printStackTrace(); // This gives us the full technical breakdown
        }

        // --- MAIN APPLICATION LOOP ---
        String continueRunning = "y";
        while (continueRunning.equalsIgnoreCase("y")) {
            System.out.println("\n--- New Employee ---");
            
            // Employee Type Trap
            int employeeType = 0;
            boolean validEmployeeType = false;
            while (!validEmployeeType) {
                try {
                    System.out.print("Is this a (1) Developer, (2) Manager, or (3) Contractor? Enter 1, 2, or 3: ");
                    employeeType = keyboard.nextInt();
                    validEmployeeType = (employeeType >= 1 && employeeType <= 3);
                    if (!validEmployeeType) System.out.println("❌ Choice must be 1, 2, or 3.");
                } catch (Exception e) {
                    System.out.println("❌ ERROR: Please enter a valid number.");
                    keyboard.nextLine(); 
                }
            }
            keyboard.nextLine(); // Buffer Flush

            System.out.print("Enter name: ");
            String name = keyboard.nextLine();

            System.out.print("Enter hourly rate: ");
            double rate = keyboard.nextDouble();

            System.out.print("Enter hours worked: ");
            int hours = keyboard.nextInt();

            if (employeeType == 2) {
                System.out.print("Enter weekly bonus: ");
                double bonus = keyboard.nextDouble();
                keyboard.nextLine();
                Manager mgr = new Manager(name, rate, hours, bonus);
                payrollList.add(mgr);
                System.out.println("--- Manager Profile Created ---");
            } else if (employeeType == 3) {
                keyboard.nextLine();
                Contractor cont = new Contractor(name, rate, hours);
                payrollList.add(cont);
                System.out.println("--- Contractor Profile Created ---");
            } else {
                keyboard.nextLine();
                Developer dev = new Developer(name, rate, hours);
                payrollList.add(dev);
                System.out.println("--- Developer Profile Created ---");
            }

            System.out.print("\nWould you like to enter another profile? (y/n): ");
            continueRunning = keyboard.nextLine();
        }

        // --- FINAL SAVE SEQUENCE ---
        System.out.println("\nGenerating and saving report to Payroll_Report.txt...");
        try {
            FileWriter fileWriter = new FileWriter("Payroll_Report.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("========== SQUAD PAYROLL REPORT ==========");
            for (Developer d : payrollList) {
                printWriter.printf("Name: %-15s | Net Pay: $%.2f%n", d.getName(), d.calculateNet());
            }
            printWriter.println("==========================================\n");
            printWriter.close();
            System.out.println("✅ Report successfully saved to your hard drive!");
        } catch (Exception e) {
            System.out.println("❌ ERROR: Could not save the file.");
        }
        
        System.out.println("Goodbye, Detective!");
        keyboard.close();
    }
}

