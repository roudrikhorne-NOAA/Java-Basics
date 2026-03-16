// "extends Developer" means Manager inherits everything from Developer!
public class Manager extends Developer {
    
    private double weeklyBonus;

    // The Constructor
    public Manager(String name, double rate, int hours, double bonus) {
        // "super" calls the Developer constructor to set name, rate, and hours
        super(name, rate, hours); 
        this.weeklyBonus = bonus;
    }

    // --- OVERRIDING THE MATH ---
    // We are redefining calculateNet specifically for Managers
    @Override
    public double calculateNet() {
        // Managers get their standard Net Pay PLUS their bonus
        // We use super.calculateNet() to get the original 15% tax math
        return super.calculateNet() + weeklyBonus;
    }
}