package com.spot;

import java.util.HashMap;

public class ParkingSpot 
{
	private int lot = 0;
	private HashMap<String, String> map = null;
	public void createParkinglot(String lotSize)
	{
		lot = Integer.parseInt(lotSize);
		System.out.println("Created a parking lot of slot "+lot);
	}
	
	public void parkVehicle(String vehicleRegisterNumber, String vehicleColour)
	{
		map = new HashMap<String, String>(lot);
		map.put(vehicleRegisterNumber, vehicleColour);
		System.out.println(map.toString());
	}
	
	public void removeCarFromSlot(String slot)
	{
		
	}
}
