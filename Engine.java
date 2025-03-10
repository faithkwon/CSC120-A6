public class Engine implements EngineRequirements {

    // Attributes needed for engine
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor
     * @param f Takes in the fuel type
     * @param current Takes in the current fuel level 
     * @param max Takes in the max fuel level 
     */
    public Engine(FuelType f, double current, double max) {
        this.f = f;
        this.currentFuelLevel = current;
        this.maxFuelLevel = max;
    }

    /**
     * Sets the current fuel level to the max fuel level
     */
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }

    /**
     * Getter method for fuel type
     * @return FuelType
     */
    public FuelType getFuelType() {
        return f;
    }
    
    /**
     * Getter method for max fuel
     * @return maxFuel
     */
    public double getMaxFuel() {
        return maxFuelLevel;
    }
    
    /**
     * Getter method for current fuel
     * @return currentFuel
     */
    public double getCurrentFuel() {
        return currentFuelLevel;
    }

    /**
     * Go method subtracts one from the fuel level
     * @return true/false depending on if the train can go
     */
    public Boolean go() {
        if (currentFuelLevel > 1) {
            currentFuelLevel -= 1;
            return true;
        }

        return false;        
    }

    /**
     * Main method to test class
     * @param args
     */
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 10.0);

        System.out.println(myEngine.getFuelType());
        System.out.println(myEngine.getMaxFuel());
        System.out.println(myEngine.getCurrentFuel());
        myEngine.refuel();
        System.out.println(myEngine.getCurrentFuel());

        while (myEngine.go()) {
            System.out.println("Choo choo! " + myEngine.getCurrentFuel());
        }
        System.out.println("Out of fuel.");
    }
}