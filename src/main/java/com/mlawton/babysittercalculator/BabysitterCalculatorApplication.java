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
		String bedTimeInput = input.nextLine();
		if("N/A".equals(bedTimeInput)) {
			bedTimeInput = endTimeInput;
		}

		Shift shift = new Shift(startTimeInput, bedTimeInput, endTimeInput);

		double playTimeCharge = shift.getDayShiftDuration() * 12.00;
		double sleepTimeCharge = shift.getSleepShiftDuration() * 8.00;
		double afterMidnightCharge = shift.getLateShiftDuration() * 16.00;
		double totalCharge = playTimeCharge + sleepTimeCharge + afterMidnightCharge;

		System.out.println("Play Time (" + shift.getDayShiftDuration() + " hours at $12/hr): $" + playTimeCharge);
		System.out.println("Sleep Time (" + shift.getSleepShiftDuration() + " hours at $8/hr): $" + sleepTimeCharge);
		System.out.println("After Midnight (" + shift.getLateShiftDuration() +" hours at 16/hr): $" + afterMidnightCharge);
		System.out.println("Total Charge: $" + totalCharge);
	}

}
