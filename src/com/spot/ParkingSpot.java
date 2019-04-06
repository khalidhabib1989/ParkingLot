package com.spot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.entity.VehicleEntity;
import com.interfaces.Vehicles;

public class ParkingSpot implements Vehicles
{
	private int MAX_SIZE = 0;
	// Available slots list
    ArrayList<Integer> availableSlotList;
    // Map of Slot, Car
    Map<String, VehicleEntity> map1;
    // Map of RegNo, Slot
    Map<String, String> map2;
    // Map of Color, List of RegNo
    Map<String, ArrayList<String>> map3;

	public void createParkinglot(String lotSize)
	{
		try {
            this.MAX_SIZE = Integer.parseInt(lotSize);
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        this.availableSlotList = new ArrayList<Integer>() {};
        for (int i=1; i<= this.MAX_SIZE; i++) {
            availableSlotList.add(i);
        }
        this.map1 = new HashMap<String, VehicleEntity>();
        this.map2 = new HashMap<String, String>();
        this.map3 = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + lotSize + " slots");
        System.out.println();
	}
	
	public void parkVehicle(String vehicleRegisterNumber, String vehicleColour)
	{
		if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            VehicleEntity vehicleEntity = new VehicleEntity(vehicleRegisterNumber, vehicleColour);
            this.map1.put(slot, vehicleEntity);
            this.map2.put(vehicleRegisterNumber, slot);
            if (this.map3.containsKey(vehicleColour)) {
                ArrayList<String> regNoList = this.map3.get(vehicleColour);
                this.map3.remove(vehicleColour);
                regNoList.add(vehicleRegisterNumber);
                this.map3.put(vehicleColour, regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(vehicleRegisterNumber);
                this.map3.put(vehicleColour, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
	}
	
	public void removeCarFromSlot(String slot)
	{
		if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
        	VehicleEntity carToLeave = this.map1.get(slot);
            if (carToLeave != null) {
                this.map1.remove(slot);
                this.map2.remove(carToLeave.getVehicleRegisterNumber());
                ArrayList<String> regNoList = this.map3.get(carToLeave.getVehicleColour());
                if (regNoList.contains(carToLeave.getVehicleRegisterNumber())) {
                    regNoList.remove(carToLeave.getVehicleRegisterNumber());
                }
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slot));
                System.out.println("Slot number " + slot + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slot + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
	}
	
	public void status() 
	{
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColor");
            VehicleEntity vehicleEntity;
            for (int i = 1; i <= this.MAX_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.map1.containsKey(key)) {
                	vehicleEntity = this.map1.get(key);
                    System.out.println(i + "\t" + vehicleEntity.getVehicleRegisterNumber() + "\t" + vehicleEntity.getVehicleColour());
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
	
	public void getRegistrationNumbersFromColor(String vehicleColour) 
	{
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map3.containsKey(vehicleColour)) {
            ArrayList<String> vehicleRegisterNumberList = this.map3.get(vehicleColour);
            System.out.println();
            for (int i=0; i < vehicleRegisterNumberList.size(); i++) {
                if (!(i==vehicleRegisterNumberList.size() - 1)){
                    System.out.print(vehicleRegisterNumberList.get(i) + ",");
                } else {
                    System.out.print(vehicleRegisterNumberList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
	
    public void getSlotNumbersFromColor(String vehicleColour) 
    {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map3.containsKey(vehicleColour)) {
            ArrayList<String> vehicleRegisterNumberList = this.map3.get(vehicleColour);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < vehicleRegisterNumberList.size(); i++) {
                slotList.add(Integer.valueOf(this.map2.get(vehicleRegisterNumberList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void getSlotNumberFromRegNo(String vehicleRegisterNumber) 
    {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map2.containsKey(vehicleRegisterNumber)) {
            System.out.println(this.map2.get(vehicleRegisterNumber));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
}