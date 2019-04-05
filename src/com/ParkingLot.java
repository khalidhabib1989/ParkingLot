package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.interfaces.Vehicles;
import com.spot.ParkingSpot;

public class ParkingLot implements Vehicles
{
	private static boolean argFlag = false;
	private String parameter[];
	private String absoluteFilePath;
	private ParkingSpot parkingSpot = null;;
	
	public ParkingLot(String[] args)
	{
		this.parameter = args;
	}
	public static void main(String[] args) 
	{
		System.out.println("main() method Started");
		ParkingLot parkingLot = new ParkingLot(args);
		parkingLot.validateTaskParameters();
		if(argFlag)
		{
			parkingLot.extractFile();
		}
		else
		{
			System.out.println("No args passed");
		}
		
		
		System.out.println("main() method Finished ");		
	}

	public void extractFile()
	{
		File file = new File(absoluteFilePath);
		parkingSpot = new ParkingSpot();
		try
		{
			if(!file.isFile())
				throw new FileNotFoundException("invalid file" + absoluteFilePath + "passed");
			else
			{
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferReaded = new BufferedReader(fileReader);
				
					String line = bufferReaded.readLine();
					while (line != null) 
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
						
						line = bufferReaded.readLine();
					}
			}
		}
		catch (FileNotFoundException e) 
		{
			
		}
		catch (IOException e) 
		{
			
		}
	}
	
	public String vehicleRegisterNumber() 
	{
		return null;
	}

	public String vehicleColour() 
	{
		return null;
	}

	public void validateTaskParameters() 
	{
		System.out.println("validateTaskParameters() method Started");
		if(parameter != null && parameter.length == 1)
		{
			absoluteFilePath = parameter[0];
			System.out.println(absoluteFilePath);
			argFlag = true;
		}		
		System.out.println("validateTaskParameters() method Finished ");
	}
}