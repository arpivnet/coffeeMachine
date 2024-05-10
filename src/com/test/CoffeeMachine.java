package com.test;

import java.util.Scanner;

public class CoffeeMachine
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int cupsNeeded;
		int coffeeBeansAvailable;
		int milkAvailable;
		int waterAvailable;

		// Prompt user to input the available resources
		System.out.println("Write how many ml of water the coffee machine has:");
		waterAvailable = scan.nextInt();
		System.out.println("Write how many ml of milk the coffee machine has:");
		milkAvailable = scan.nextInt();
		System.out.println("Write how many grams of coffee beans the coffee machine has:");
		coffeeBeansAvailable = scan.nextInt();

		// Prompt user to input the number of cups needed
		System.out.println("Write how many cups of coffee you will need:");
		cupsNeeded = scan.nextInt();

		// Calculate the resources needed for the specified number of cups
		int waterNeeded = cupsNeeded * 200;
		int milkNeeded = cupsNeeded * 50;
		int coffeeBeansNeeded = cupsNeeded * 15;

		// Calculate the maximum number of cups that can be made with the available
		// resources
		int maxCupsWater = waterAvailable / 200;
		int maxCupsMilk = milkAvailable / 50;
		int maxCupsBeans = coffeeBeansAvailable / 15;
		int maxCups = Math.min(Math.min(maxCupsWater, maxCupsMilk), maxCupsBeans);

		// Check if the coffee machine has enough supplies to make the specified amount
		// of coffee
		if (maxCups >= cupsNeeded)
		{
			if (maxCups == cupsNeeded)
			{
				System.out.println("Yes, I can make that amount of coffee");
			} else
			{
				System.out.println(
						"Yes, I can make that amount of coffee (and even " + (maxCups - cupsNeeded) + " more than that)"
				);
			}
		} else
		{
			System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
		}
	}
}
