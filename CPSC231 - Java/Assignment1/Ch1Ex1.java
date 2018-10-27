/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Prints out the total number of calories burned for specific actions.
*/
public class Ch1Ex1
{
	public static void main(String[]args)
	{
		double runningBurned = 0.0175 * 10 * (150 / 2.2) * 30;
		double bballBurned = 0.0175 * 8 * (150 / 2.2) * 30;
		double sleepingBurned = 0.0175 * 1 * (150 / 2.2) * 360;
		double total = runningBurned + bballBurned + sleepingBurned;
		
		System.out.println("The total amount of calories burned is: " + total + " calories.");
	}
}