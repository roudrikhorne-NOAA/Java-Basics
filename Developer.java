public class Developer {
    // 1. ATTRIBUTES (What a developer HAS)
    public String name;
    public double hourlyRate;
    public int hoursWorked;

    // 2. THE CONSTRUCTOR (The "Assembly Line" instructions)
    // This runs when we say "new Developer(...)"
    public Developer(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // 3. THE BEHAVIORS (What a developer can CALCULATE for themselves)
    public double calculateGross() {
        if (hoursWorked > 40) {
            return (40 * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 1.5));
        }
        return hourlyRate * hoursWorked;
    }

    public double calculateNet() {
        return calculateGross() * 0.85; // Subtracts 15% automatically
    }
}