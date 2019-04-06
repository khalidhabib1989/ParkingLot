package com.interfaces;

public interface Vehicles 
{
	public void parkVehicle(String vehicleRegisterNumber, String vehicleColour);
	public void createParkinglot(String lotSize);
	public void removeCarFromSlot(String slot);
	public void status();
	public void getRegistrationNumbersFromColor(String vehicleColour);
	public void getSlotNumbersFromColor(String vehicleColour);
	public void getSlotNumberFromRegNo(String vehicleRegisterNumber);
}