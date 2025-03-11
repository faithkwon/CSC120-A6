import org.junit.Test;
import static org.junit.Assert.*;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine newEngine  = new Engine(FuelType.ELECTRIC, 10.0, 10.0);

        assertTrue(FuelType.ELECTRIC.equals(newEngine.getFuelType()) && 10.0 == newEngine.getCurrentFuel() && 10.0 == newEngine.getMaxFuel());
    }

    @Test
    public void testEngineGo() {
        Engine newEngine = new Engine(FuelType.ELECTRIC, 10.0, 10.0);

        newEngine.go();

        assertTrue(9.0 == newEngine.getCurrentFuel());
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car newCar = new Car(10);
        Passenger newPassenger = new Passenger("Faith");        

        assetTrue(newCar.addPassenger(newPassenger) && newCar.seatsRemaining() == 9);
    }

    @Test
    public void testCarRemovePassenger() {
        fail();
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        fail();
    }

    @Test
    public void testPassengerBoardCarFull() {
        fail();
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        fail();
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
