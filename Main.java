public class Main {
    public static void main(String[] args) {
        String myName = "Roudrik Horne";
        double yearsExp = 0.5;
        double targetRate = 50.00;
        boolean isLearning = true;

        // --- CALCULATION SECTION ---
        int hoursPerWeek = 40;
        double weeklyEarnings = targetRate * hoursPerWeek;

        // --- LOGIC SECTION ---
        System.out.println("Developer Name: " + myName);
        System.out.println("Experience: " + yearsExp + " years");
        System.out.println("Rate: $" + targetRate);
        System.out.println("Currently Learning? " + isLearning);
        System.out.println("Potential Weekly Earnings: $" + weeklyEarnings);

        if (weeklyEarnings >= 2000) {
            System.out.println("Status: Income Goal Achieved!");
        } else {
            System.out.println("Status: Keep grinding, Guru!");
        }
    } 
}