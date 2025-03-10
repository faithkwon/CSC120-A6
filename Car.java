import java.util.ArrayList;

public class Car implements CarRequirements {
    
    // Attributes needed for car
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    /**
     * Constructor
     * @param max Maximum capacity for the car
     */
    public Car(int max) {
        this.maxCapacity = max;
        this.passengers = new ArrayList<>(max);
    }

    /**
     * Getter method for car capacity
     * @return car capacity
     */
    public int getCapacity() {
        return maxCapacity;
    }
    
    /**
     * Calculates the number of seats remaining
     * @return # of seats remaining
     */
    public int seatsRemaining() {
        return maxCapacity - passengers.size();
    }
    
    /**
     * Adds a passenger to the car (if possible)
     * @param p a passenger to add
     * @return true/false depending on if a passenger can be added
     */
    public Boolean addPassenger(Passenger p) {
        if (passengers.size() < maxCapacity) {
            passengers.add(p);
            return true;
        }
        
        System.out.println("Car is at max capacity.");
        return false;
    }

    /**
     * Removes a passenger from the car
     * @param p a passenger to remove
     * @return true/false depending on if a passenger can be removed
     */
    public Boolean removePassenger(Passenger p) {
        if (!passengers.isEmpty()) {
            passengers.remove(p);
            return true;
        }

        System.out.println("Car is empty.");
        return false;
    }
    
    /**
     * Prints a list of all of the passengers in the car
     * Prints a msg if the car is empty or full
     */
    public void printManifest() {
        if (!passengers.isEmpty()) {
            for (int i = 0; i < passengers.size(); i++) {
                System.out.print(passengers.get(i).getName() + " ");
            }

            if (passengers.size() == maxCapacity) {
                System.out.println("-- Car is full.");
            }

            System.out.println();
        } else {
            System.out.println("Car is empty.");
        }
    }

    /**
     * Main method to test class
     * @param args
     */
    public static void main(String[] args) {
        Car newCar = new Car(2);
        Passenger person1 = new Passenger("1");
        Passenger person2 = new Passenger("2");
        Passenger person3 = new Passenger("3");

        System.out.println("Car can hold " + newCar.getCapacity() + " passengers.");
        System.out.println("There are currently " + newCar.seatsRemaining() + " seats left.");

        newCar.addPassenger(person1);
        System.out.println("There are currently " + newCar.seatsRemaining() + " seats left.");
        newCar.addPassenger(person2);
        System.out.println("There are currently " + newCar.seatsRemaining() + " seats left.");
        newCar.addPassenger(person3); // checking if the error msg returns properly

        newCar.printManifest();

        newCar.removePassenger(person1);
        System.out.println("There are currently " + newCar.seatsRemaining() + " seats left.");
        newCar.removePassenger(person2);
        System.out.println("There are currently " + newCar.seatsRemaining() + " seats left.");
        
        newCar.printManifest();
    }
}