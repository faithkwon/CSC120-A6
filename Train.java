import java.util.ArrayList;

public class Train implements TrainRequirements{
    
    // Attributes needed for train
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor
     * @param fuelType type of fuel
     * @param fuelCapacity max fuel capacity
     * @param nCars # of cars in train
     * @param passengerCapacity max capacity of one car in the train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>(nCars);

        for (int i = 0; i < nCars; i++) {
            Car newCar = new Car(passengerCapacity);
            this.cars.add(newCar);
        }
    }
    
    /**
     * Getter method for engine 
     * @return engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Getter method for specific car in the train
     * @return specific car in train
     * @param i index of specific car
     */
    public Car getCar(int i) {
        return cars.get(i);
    }

    /**
     * Total max capacity of train
     * @return max capacity of train
     */
    public int getMaxCapacity() {
        int maxCapacity = 0;

        for (int i = 0; i < cars.size(); i++) {
            maxCapacity += cars.get(i).getCapacity();
        }

        return maxCapacity;
    }
    
    /**
     * How many seats are remaining in the train
     * @return seats remaining in train
     */
    public int seatsRemaining() {
        int seats = 0;

        for (int i = 0; i < cars.size(); i++) {
            seats += cars.get(i).seatsRemaining();
        }

        return seats;
    }
    
    /**
     * Calls the printManifest() function from Car for specific cars in the train
     */
    public void printManifest() {
        if (!cars.isEmpty()) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).printManifest();
            }
        } else {
            System.out.println("This train is empty.");
        }
    }

    /**
     * Main method to test class
     * @param args
     */
    public static void main(String[] args) {
        Train newTrain = new Train(FuelType.ELECTRIC, 10.0, 5, 5);
        Passenger person1 = new Passenger("1");
        Passenger person2 = new Passenger("2");

        newTrain.getCar(1).addPassenger(person1);
        newTrain.getCar(1).addPassenger(person2);
        newTrain.printManifest();

        System.out.println("This train has " + newTrain.getMaxCapacity() + " total seats. There are " + newTrain.seatsRemaining() + " seats remaining.");
        
    }
}
