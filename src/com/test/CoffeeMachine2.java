package com.test;

import java.util.Scanner;

public class CoffeeMachine2
{
	static Scanner scan = new Scanner(System.in);
	static int water = 400;
	static int milk = 540;
	static int beans = 120;
	static int disCups = 9;
	static int money = 550;

	// Constants for coffee parameters
	static final int ESPRESSO_WATER = 250;
	static final int ESPRESSO_BEANS = 16;
	static final int ESPRESSO_COST = 4;

	static final int LATTE_WATER = 350;
	static final int LATTE_MILK = 75;
	static final int LATTE_BEANS = 20;
	static final int LATTE_COST = 7;

	static final int CAPPUCCINO_WATER = 200;
	static final int CAPPUCCINO_MILK = 100;
	static final int CAPPUCCINO_BEANS = 12;
	static final int CAPPUCCINO_COST = 6;

	public static void main(String[] args)
	{
		printMachineState();

		System.out.println("Write action (buy, fill, take):");
		String action = scan.nextLine().trim().toLowerCase();

		switch (action) {
		case "buy":
			choice();
			break;
		case "fill":
			fill();
			break;
		case "take":
			take();
			break;
		default:
			System.out.println("Invalid action. Please enter 'buy', 'fill', or 'take'.");
		}

		scan.close();
	}

	private static void printMachineState()
	{
		System.out.println("The coffee machine has:");
		System.out.println(water + " ml of water");
		System.out.println(milk + " ml of milk");
		System.out.println(beans + " g of coffee beans");
		System.out.println(disCups + " disposable cups");
		System.out.println("$" + money + " of money");
	}

	private static void take()
	{
		System.out.println("I gave you $" + money);
		money = 0;
		printMachineState();
	}

	private static void fill()
	{
		System.out.println("Write how many ml of water you want to add:");
		water += scan.nextInt();
		System.out.println("Write how many ml of milk you want to add:");
		milk += scan.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add:");
		beans += scan.nextInt();
		System.out.println("Write how many disposable cups you want to add:");
		disCups += scan.nextInt();
		printMachineState();
	}

	private static void choice()
	{
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			makeCoffee(ESPRESSO_WATER, 0, ESPRESSO_BEANS, ESPRESSO_COST); // No milk for espresso
			break;
		case 2:
			makeCoffee(LATTE_WATER, LATTE_MILK, LATTE_BEANS, LATTE_COST);
			break;
		case 3:
			makeCoffee(CAPPUCCINO_WATER, CAPPUCCINO_MILK, CAPPUCCINO_BEANS, CAPPUCCINO_COST);
			break;
		default:
			System.out.println("Invalid choice. Please select a number from 1 to 3.");
		}
	}

	private static void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost)
	{
		if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded && disCups >= 1)
		{
			System.out.println("I have enough resources, making you a coffee!");
			water -= waterNeeded;
			milk -= milkNeeded;
			beans -= beansNeeded;
			disCups--;
			money += cost;
		} else
		{
			System.out.println("Sorry, not enough resources!");
		}
		printMachineState();
	}
}
