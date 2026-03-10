public class Developer {
    // 1. THE LOCKED VAULT (Private Attributes)
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    // 2. THE CONSTRUCTOR (Still public, so we can build them)
    public Developer(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // 3. THE TELLER WINDOW (The Public Getter)
    // This allows Main.java to READ the name, but not CHANGE it.
    public String getName() {
        return name;
    }

    // 4. THE BEHAVIORS (Still public, so Main can ask for the math)
    public double calculateGross() {
        if (hoursWorked > 40) {
            return (40 * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 1.5));
        }
        return hourlyRate * hoursWorked;
    }

    public double calculateNet() {
        return calculateGross() * 0.85; 
    }
}