public class Passenger implements PassengerRequirements{
    
    // Attributes needed for passenger
    private String name;

    /**
     * Constructor
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Getter method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds the passenger to a car
     * @param c which car to add said passenger to
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this)) {
            System.out.println(getName() + " has boarded the car.");
        } else {
            System.out.println("Car full; passenger unable to board.");
        }
    }

    /**
     * Removes the passenger from a car
     * @param c which car to remove said passenger from
     */
    public void getOffCar(Car c) {
        if (c.removePassenger(this)) {
            System.out.println(getName() + " has left the car.");
        } else {
            System.out.println("Passenger not on board.");
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
        System.out.println("Car has " + newCar.seatsRemaining() + " seats left.");
        person1.boardCar(newCar);
        System.out.println("Car has " + newCar.seatsRemaining() + " seats left.");
        person2.boardCar(newCar);
        person3.boardCar(newCar);

        newCar.printManifest();

        person2.getOffCar(newCar);
        person3.getOffCar(newCar);
        person1.getOffCar(newCar);

        newCar.printManifest();
    }
}
