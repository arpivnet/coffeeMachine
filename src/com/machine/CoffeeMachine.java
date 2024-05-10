package com.machine;

import java.util.Scanner;

public class CoffeeMachine
{
	static Scanner scan = new Scanner(System.in);
	static int water = 400;
	static int milk = 540;
	static int beans = 120;
	static int disCups = 9;
	static int money = 550;

	public static void main(String[] args)
	{
		selectOne();
	}

	static void selectOne()
	{
		System.out.println("Write action (buy, fill, take, remaining, exit):");
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
		case "remaining":
			remaining();
			break;
		case "exit":
			exit();
			break;
		default:
			System.out.println("Invalid action. Please enter 'buy', 'fill', 'take', 'remaining', or 'exit'.");
			selectOne(); // Prompt again for a valid action
		}
	}

	private static void exit()
	{
		scan.close();
		System.out.println("Exiting...");
		System.exit(0);
	}

	private static void remaining()
	{
		System.out.println("The coffee machine has:");
		System.out.println(water + " ml of water");
		System.out.println(milk + " ml of milk");
		System.out.println(beans + " g of coffee beans");
		System.out.println(disCups + " disposable cups");
		System.out.println("$" + money + " of money");
		selectOne(); // Prompt again for the next action
	}

	private static void take()
	{
		System.out.println("I gave you $" + money);
		money = 0;
		selectOne(); // Prompt again for the next action
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
		scan.nextLine(); // Consume newline
		selectOne(); // Prompt again for the next action
	}

	private static void choice()
	{
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
		String choice = scan.nextLine().trim().toLowerCase();

		switch (choice) {
		case "1":
			makeCoffee(250, 0, 16, 4); // Espresso
			break;
		case "2":
			makeCoffee(350, 75, 20, 7); // Latte
			break;
		case "3":
			makeCoffee(200, 100, 12, 6); // Cappuccino
			break;
		case "back": // Back
			selectOne(); // Return to the main menu
			break;
		default:
			System.out.println(
					"Invalid choice. Please select a number from 1 to 3 or 'back' to return to the previous menu."
			);
			choice(); // Prompt again for a valid choice
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
			if (water < waterNeeded)
			{
				System.out.println("Sorry, not enough water!");
			} else if (milk < milkNeeded)
			{
				System.out.println("Sorry, not enough milk!");
			} else if (beans < beansNeeded)
			{
				System.out.println("Sorry, not enough beans!");
			} else if (disCups < 1)
			{
				System.out.println("Sorry, not enough cups!");
			}

		}
		selectOne(); // Prompt again for the next action
	}
}
