package com.test;

enum Days
{
	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), FRIDAY("Friday"), SATURDAY("Saturday"),
	SUNDAY("Sunday");

	private String dayName;

	Days(String name)
	{

		dayName = name;
	}

	public String getDayName()
	{
		return dayName;
	}
}

public class Main
{

	public static void main(String[] args)
	{

	}
}
