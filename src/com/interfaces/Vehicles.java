package com.interfaces;

public interface Vehicles 
{
	void parkVehicle(String vehicleRegisterNumber, String vehicleColour);
	void createParkinglot(String lotSize);
	void removeCarFromSlot(String slot);
	void status();
	void getRegistrationNumbersFromColor(String vehicleColour);
	void getSlotNumbersFromColor(String vehicleColour);
	void getSlotNumberFromRegNo(String vehicleRegisterNumber);
}