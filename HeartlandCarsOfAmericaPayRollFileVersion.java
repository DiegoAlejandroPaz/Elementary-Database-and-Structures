package java2;
import java.util.*;
import java.io.*;

/**
  Modified program for Heartland Cars of America
 */

		public class HeartlandCarsOfAmericaPayRollFileVersion {
		public static void main(String [] args) throws
		FileNotFoundException, IOException
	{
		// Create reference variable of all three employee types
			
		FullTimeEmployee fullTimeEmployee;
		PartTimeEmployee partTimeEmployee;
		SalesEmployee salesEmployee;
		
		//Declare variables to input
		char inputEmployeeType;
		String inputFirstName;
		String inputLastName;
		double inputBaseSalary;
		double inputPayPerHour;
		int inputSalesVolume;
		int inputHoursWorked;
		
		double tFBaseSalary = 0;
		double tFTHrs = 0;
		double tPTPayPerHour = 0;
		double tPTHours = 0;
		double tSBaseSalary = 0;
		double tSVolume = 0;
		
		int fTimeCounter = 0;
		int pTimeCounter = 0;
		int sCounter = 0;
		
		
		
		
		// Get two input values .
		Scanner scannedInfo = new Scanner (new File("C:\\Users\\Diego Paz\\Documents\\JAVA2DP\\employee.txt "));
		PrintWriter outFile = new PrintWriter(new FileWriter("C:\\Users\\Diego Paz\\Documents\\JAVA2DP\\payroll.txt "));
		
		while (scannedInfo.hasNext()) {
			
			inputEmployeeType = scannedInfo.next().charAt(0);
			
			switch (inputEmployeeType)
			{
			case 'F' :
			case 'f' :
				//get necessary values as input

				inputFirstName = scannedInfo.next() ;
				inputLastName = scannedInfo.next() ;
				inputBaseSalary = scannedInfo.nextDouble();
				inputHoursWorked = scannedInfo.nextInt();
				
				//create an object and initialize data members
				fullTimeEmployee = new FullTimeEmployee();
				fullTimeEmployee.setFirstName(inputFirstName);
				fullTimeEmployee.setLastName(inputLastName);
				fullTimeEmployee.setBaseSalary(inputBaseSalary);
				fullTimeEmployee.setHoursWorked(inputHoursWorked);
				
				//invoke the printPayStub method
				outFile.print (fullTimeEmployee.createPayStub());
				
				tFBaseSalary = tFBaseSalary + fullTimeEmployee.getBaseSalary();
				tFTHrs = tFTHrs + fullTimeEmployee.getHoursWorked();
				fTimeCounter++;
				
				break;
				
			case 'P' :
			case 'p' :
				
				//get necessary values as input

				inputFirstName = scannedInfo.next() ;
				inputLastName = scannedInfo.next () ;
				inputPayPerHour = scannedInfo.nextDouble();
				inputHoursWorked = scannedInfo.nextInt();
				// create an object and initialize data members
				partTimeEmployee = new PartTimeEmployee();
				partTimeEmployee.setFirstName(inputFirstName);
				partTimeEmployee.setLastName(inputLastName);
				partTimeEmployee.setPayPerHour(inputPayPerHour);
				partTimeEmployee.setHoursWorked(inputHoursWorked);
				
				//invoke the printPayStub method
				outFile.print(partTimeEmployee.createPayStub());
				
				tPTPayPerHour = tPTPayPerHour + partTimeEmployee.getPayPerHour();
				tPTHours = tPTHours + partTimeEmployee.getHoursWorked();
				pTimeCounter++;
				
				break;
			case 'S' :
			case 's' :
				
				//get necessary values as input

				inputFirstName = scannedInfo.next() ;
				inputLastName = scannedInfo.next () ;
				inputBaseSalary =  scannedInfo.nextDouble();
				inputSalesVolume = scannedInfo.nextInt();
				//create an object and initialize data members
				salesEmployee = new SalesEmployee();
				salesEmployee.setFirstName(inputFirstName);
				salesEmployee.setLastName(inputLastName);
				salesEmployee.setBaseSalary(inputBaseSalary);
				salesEmployee.setSalesVolume(inputSalesVolume);
				//invoke the printPayStub method
				outFile.print(salesEmployee.createPayStub());
				
				tSBaseSalary = tSBaseSalary + salesEmployee.getBaseSalary();
				tSVolume = tSVolume + salesEmployee.getSalesVolume();
				sCounter++;
				
				break;
				} //End of switch
			
			} // End of while
		outFile.close();
		
		System.out.println("Average full-time employee base salary  $ = " + tFBaseSalary/fTimeCounter + ", hours worked = " + tFTHrs/fTimeCounter );
		System.out.println("Average part-time employee pay per hour $ = " + tPTPayPerHour/pTimeCounter + ", hours worked = " + tPTHours/pTimeCounter );
		System.out.println("Average sales employee base salary $ = " + tSBaseSalary/sCounter + ", sales volume = " + tSVolume/sCounter);

		} // End of main
	}  //End of class