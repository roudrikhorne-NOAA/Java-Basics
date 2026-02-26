public class Main {
    public static void main(String[] args) {
        String myName = "Roudrik Horne";
        double yearsExp = 0.5;
        double targetRate = 50.00;
        boolean isLearning = true;

        // --- NEW CALCULATION SECTION ---
        int hoursPerWeek = 40;
        double weeklyEarnings = targetRate * hoursPerWeek;
        // -------------------------------

        System.out.println("Developer Name: " + myName);
        System.out.println("Experience: " + yearsExp + " years");
        System.out.println("Rate: $" + targetRate);
        System.out.println("Currently Learning? " + isLearning);
        
        // Print your calculation result
        System.out.println("Potential Weekly Earnings: $" + weeklyEarnings);
    }
}