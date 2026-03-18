public class Contractor extends Developer {

    // The Constructor
    public Contractor(String name, double hourlyRate, int hoursWorked) {
        // "super" passes the data up to the Developer parent
        super(name, hourlyRate, hoursWorked);
    }

    // --- OVERRIDING THE MATH ---
    @Override
    public double calculateGross() {
        // Contractors do NOT get overtime! Just straight rate * hours.
        // Because we made these "protected" in Developer, Contractor can see them!
        return hourlyRate * hoursWorked; 
    }
}
