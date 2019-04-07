package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.spot.InputParser;
import com.spot.ParkingSpot;

public class ParkingLot
{
	private static boolean argFlag = false;
	private String parameter[];
	private String absoluteFilePath;
	private ParkingSpot parkingSpot = null;
	private InputParser inputParser = null; 
	
	public ParkingLot(String[] args)
	{
		this.parameter = args;
	}
	public ParkingLot()
	{
		
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
			parkingLot.readFromCommand();
		}
		
		
		System.out.println("main() method Finished ");		
	}
	
	public void readFromCommand()
	{
		inputParser = new InputParser();
		parkingSpot = new ParkingSpot();
		for (;;) {
            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String inputString = bufferRead.readLine();
                if (inputString.equalsIgnoreCase("exit")) {
                    break;
                } else if ((inputString == null) || (inputString.isEmpty())) {
                    // Do nothing
                } else {
                	inputParser.parselineInput(parkingSpot,inputString.trim());
                }
            } catch(IOException e) {
                System.out.println("Oops! Error in reading the input from console.");
                e.printStackTrace();
            }
        }
	}

	public void extractFile()
	{
		File file = new File(absoluteFilePath);
		parkingSpot = new ParkingSpot();
		inputParser = new InputParser();
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
						inputParser.parselineInput(parkingSpot, line);
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