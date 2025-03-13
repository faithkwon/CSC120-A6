import org.junit.Test;
import static org.junit.Assert.*;

public class TrainTest {

    // Engine Tests
    
    // Testing that the Engine constructor properly initializes Engine attributes
    @Test
    public void testEngineConstructor() {
        Engine e  = new Engine(FuelType.ELECTRIC, 10.0, 10.0);
        
        boolean toCheck = (FuelType.ELECTRIC.equals(e.getFuelType()) && 10.0 == e.getCurrentFuel() && 10.0 == e.getMaxFuel());

        assertTrue(toCheck);
    }

    // Testing that the go() method in the Engine class works properly
    @Test
    public void testEngineGo() {
        Engine e = new Engine(FuelType.ELECTRIC, 10.0, 10.0);
        
        e.go(); // decreases the current fuel level by 1.0
        
        assertTrue(9.0 == e.getCurrentFuel()); 
    }

    // Car Tests

    // Testing that the addPassenger() method in the Car class works properly
    @Test
    public void testCarAddPassenger() {
        Car c = new Car(10);
        Passenger p = new Passenger("Faith");        

        boolean toCheck = (c.addPassenger(p)) && (c.seatsRemaining() == 9); // possible to add passengers AND decreases # of seats remaining by 1

        assertTrue(toCheck); 
    }

    // Testing that the removePassenger() method in the Car class works properly
    @Test
    public void testCarRemovePassenger() {
        Car c = new Car(10);
        Passenger p = new Passenger("Faith");    
        c.addPassenger(p);

        assertTrue(c.seatsRemaining() == c.getCapacity() - 1);

        c.removePassenger(p);    

        assertTrue(c.seatsRemaining() == c.getCapacity());  // properly decreases the amount of passengers
        assertTrue(c.removePassenger(p) == false); // can't remove another passenger once there are no passengers left
    }

    // Passenger Tests

    // Testing that the boardCar() method in the Passenger class works properly
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p = new Passenger("Faith");
        Car c = new Car(10);
        p.boardCar(c);

        assertTrue(c.seatsRemaining() == 9); // Passenger successfully boarded car -- seats remaining decreased by 1
    }

    // Testing that a passenger can't board a car if the car is full
    @Test
    public void testPassengerBoardCarFull() {
        Passenger p = new Passenger("Faith");
        Car c = new Car(1);
        p.boardCar(c);

        assertTrue(c.seatsRemaining() == 0);

        p.boardCar(c); // checking that seatsRemaining() can't return a negative #

        assertTrue(c.seatsRemaining() == 0);
    }

    // Train Tests
    
    // Testing that the Train constructor properly intializes Train attributes
    @Test
    public void testTrainConstructor() {
        int numCars = 10;
        int individualMax = 5;
        Train t = new Train(FuelType.ELECTRIC, 10.0, numCars, individualMax);

        assertEquals(FuelType.ELECTRIC, t.getEngine().getFuelType());
        assertEquals(t.getMaxCapacity() / numCars,  individualMax); 
    }

    // Testing that adding a passenger to a car in the train reduces total seatsRemaining in the train
    @Test
    public void testTrainPassengerCount() {
        int numCars = 10;
        int individiualMax = 5;
        Passenger p = new Passenger("Faith");
        Train t = new Train(FuelType.ELECTRIC, 10.0, numCars, individiualMax);
        
        t.getCar(1).addPassenger(p);

        assertEquals(t.seatsRemaining(), t.getMaxCapacity() - 1);
    }

    // Testing that the getCar() method in the Train class works and returns the expected Car
    @Test
    public void testTrainGetCar() {
        Train t = new Train(FuelType.ELECTRIC, 10.0, 2, 5);
        Passenger p = new Passenger("Faith");

        t.getCar(1).addPassenger(p);

        boolean toCheck = (t.getCar(1).seatsRemaining() == 4 && t.seatsRemaining() == 2 * 5 - 1);

        assertTrue(toCheck);
    }

    // Testing that the printManifest() method in the Train class properly interates through and prints out the train's cars
    @Test
    public void testTrainPrintManifest() {
        Train t = new Train(FuelType.ELECTRIC, 10.0, 2, 5);
        Passenger p = new Passenger("Faith");

        t.printManifest();

        // unsure how to test with a void method
    }
}
