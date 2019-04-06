package com.entity;

public class VehicleEntity 
{
	private String vehicleRegisterNumber;
	private String vehicleColour;
	
	public VehicleEntity(String vehicleRegisterNumber, String vehicleColour)
	{
		this.setVehicleRegisterNumber(vehicleRegisterNumber);
		this.setVehicleColour(vehicleColour);
	}

	public String getVehicleRegisterNumber() {
		return vehicleRegisterNumber;
	}

	public void setVehicleRegisterNumber(String vehicleRegisterNumber) {
		this.vehicleRegisterNumber = vehicleRegisterNumber;
	}

	public String getVehicleColour() {
		return vehicleColour;
	}

	public void setVehicleColour(String vehicleColour) {
		this.vehicleColour = vehicleColour;
	}
}