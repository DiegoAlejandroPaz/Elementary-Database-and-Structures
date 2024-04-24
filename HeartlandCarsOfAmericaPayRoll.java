package java2;

import java.util.Scanner;

public class HeartlandCarsOfAmericaPayRoll {

	public static void main(String[] args) {
		
// Create reference variable of all three employee types 
		FullTimeEmployee fullTimeEmployee;
		PartTimeEmployee partTimeEmployee;
		SalesEmployee salesEmployee;
		
		// Declare variables to input
		
		char inputEmployeeType;
		String inputFirstName;
		String inputLastName;
		double inputBaseSalary;
		double inputPayPerHour;
		int inputSalesVolume;
		int inputHoursWorked;
		
//Get two input values 
		Scanner scannedInfo = new Scanner(System.in);
		System.out.print("Enter Employee Type : ");
		System.out.flush();
		inputEmployeeType = scannedInfo.next() .charAt(0);
		System.out.println();
		
		switch (inputEmployeeType)
		
		{
		case 'F' :
		case 'f' :
			
			//get necessary values as input 
			System.out.print("Enter First Name, " +
							"Last Name, Base Salary, Hours : ");
			
			System.out.flush();
			inputFirstName = scannedInfo.next();
			inputLastName = scannedInfo.next();
			inputBaseSalary = scannedInfo.nextDouble ();
			inputHoursWorked = scannedInfo.nextInt();
			System.out.println();
			
			//create an object and initialize data members
			fullTimeEmployee = new FullTimeEmployee();
			fullTimeEmployee.setFirstName(inputFirstName);
			fullTimeEmployee.setLastName(inputLastName);
			fullTimeEmployee.setBaseSalary(inputBaseSalary);
			fullTimeEmployee.setHoursWorked(inputHoursWorked);
			
			//invoke the printPayStub method
			System.out.println(fullTimeEmployee.createPayStub());
			
			break;
			
		case 'P' :
		case 'p' :
			//get necessary values as input 
			System.out.print("Enter First Name, Last Name, "+ 	
								"Pay per hour, Hours : ");
			System.out.flush();
			inputFirstName = scannedInfo.next();
			inputLastName = scannedInfo.next();
			inputPayPerHour = scannedInfo.nextDouble();
			inputHoursWorked = scannedInfo.nextInt();
			System.out.println();
			
			//create an object and initialize data members
			partTimeEmployee = new PartTimeEmployee();
			partTimeEmployee.setFirstName (inputFirstName);
			partTimeEmployee.setLastName(inputLastName);
			partTimeEmployee.setPayPerHour(inputPayPerHour);
			partTimeEmployee.setHoursWorked(inputHoursWorked);
			
			//invoke the printPayStub method 
			System.out.print(partTimeEmployee.createPayStub());
			
			break;
			
		case 'S' :
		case 's' :
			//get necessary values as input
			System.out.print("Enter First Name, Last Name, " +
							" Base Salary, Sales Volume : ") ;
			System.out.flush();
			inputFirstName = scannedInfo.next();
			inputLastName = scannedInfo.next();
			inputBaseSalary = scannedInfo.nextDouble();
			inputSalesVolume = scannedInfo.nextInt();
			System.out.println();
			
			//create an object and initialize data members
			salesEmployee = new SalesEmployee();
			salesEmployee.setFirstName(inputFirstName);
			salesEmployee.setLastName(inputLastName);
			salesEmployee.setBaseSalary(inputBaseSalary);
			salesEmployee.setSalesVolume(inputSalesVolume);
			
			//invoke the printPayStub method
			System.out.println(salesEmployee.createPayStub());
			
			break;

		}
		scannedInfo.close();
	}

}
