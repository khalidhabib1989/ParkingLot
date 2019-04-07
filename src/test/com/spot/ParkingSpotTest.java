package test.com.spot;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.spot.ParkingSpot;

public class ParkingSpotTest 
{
	ParkingSpot parkingSpot = new ParkingSpot();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
	
	@After
    public void cleanUpStreams() {
        System.setOut(null);
    }
	
	@Test
	public void testCreateParkinglot() throws Exception 
	{
		parkingSpot.createParkinglot("6");
		assertEquals(6, parkingSpot.MAX_LOT_SIZE);
        assertEquals(6, parkingSpot.availableSlotList.size());
        assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
	}

	@Test
	public void testParkVehicle() 
	{
		parkingSpot.parkVehicle("KA-01-HH-1234", "White");
		parkingSpot.parkVehicle("KA-01-HH-9999", "White");
        //assertEquals("Sorry,parkinglotisnotcreated\n" +
        //        "\n" +
        //        "Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingSpot.createParkinglot("6");
        parkingSpot.parkVehicle("KA-01-HH-1234", "White");
        parkingSpot.parkVehicle("KA-01-HH-9999", "White");
        assertEquals(4, parkingSpot.availableSlotList.size());
	}

	@Test
	public void testRemoveCarFromSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRegistrationNumbersFromColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSlotNumbersFromColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSlotNumberFromRegNo() {
		fail("Not yet implemented");
	}

}
