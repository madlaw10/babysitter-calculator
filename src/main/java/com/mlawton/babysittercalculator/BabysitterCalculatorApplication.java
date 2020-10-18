package com.mlawton.babysittercalculator;

import java.util.Scanner;

public class BabysitterCalculatorApplication {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please follow directions carefully as inputs are case and format sensitive.");
		System.out.println("Enter the time you arrived below (ex 5:00 PM)");
		String startTimeInput = input.nextLine();
		System.out.println("Enter the time you left below (ex 4:00 AM)");
		String endTimeInput = input.nextLine();
		System.out.println("If applicable, enter the bedtime below (ex 11:00 PM). If child did not go to bed, enter N/A");
		String bedtimeInput = input.nextLine();
		if("N/A".equals(bedtimeInput)) {
			String adjustedBedTime = endTimeInput;
		}
		System.out.println("Start Time: " + startTimeInput + ", End Time: " + endTimeInput + ", Bedtime: " + bedtimeInput);

//				System.out.println("Invoice for MM/DD/YYYY START-END");
//				System.out.println("Playtime (__ hours at $12/hr):      $__");
//				System.out.println("Bedtime (__ hours at $8/hr):        $__");
//				System.out.println("After Midnight (__ hours at 16/hr): $__");
//				System.out.println("Total Charge:                       $__");
	}

}
