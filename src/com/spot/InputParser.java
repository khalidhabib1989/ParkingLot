package com.spot;

public class InputParser
{
	private ParkingSpot parkingSpot = null;
	
	public void parselineInput(ParkingSpot parkingSpot, String line)
	{
		
		
		String lineElement[] = line.split(" ");
		if(lineElement[0].equalsIgnoreCase("create_parking_lot"))
		{
			parkingSpot.createParkinglot(lineElement[1]);
		}
		else if (lineElement[0].equalsIgnoreCase("park")) 
		{
			parkingSpot.parkVehicle(lineElement[1], lineElement[2]);
		}
		else if(lineElement[0].equalsIgnoreCase("leave"))
		{
			parkingSpot.removeCarFromSlot(lineElement[1]);
		}
		else if(lineElement[0].equalsIgnoreCase("status"))
		{
			parkingSpot.status();
		}
		else if(lineElement[0].equalsIgnoreCase("registration_numbers_for_cars_with_colour"))
		{
			parkingSpot.getRegistrationNumbersFromColor(lineElement[1]);
		}
		else if(lineElement[0].equalsIgnoreCase("slot_numbers_for_cars_with_colour"))
		{
			parkingSpot.getSlotNumbersFromColor(lineElement[1]);
		}
		else if(lineElement[0].equalsIgnoreCase("slot_number_for_registration_number"))
		{
			parkingSpot.getSlotNumberFromRegNo(lineElement[1]);
		}
	}
}