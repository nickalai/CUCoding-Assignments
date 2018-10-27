/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks the user for 3 inputs. Returns the total cost of a commute.
*/
import java.util.Scanner;

public class Ch2Ex4
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please input the legnth of the commute in miles: ");
		double commute = keyboard.nextDouble();
		System.out.println("Please input your fuel consumption in miles per gallon: ");
		double fuelConsumption = keyboard.nextDouble();
		System.out.println("Please input the current cost of gas: ");
		double cost = keyboard.nextDouble();
		
		double total = (commute / fuelConsumption) * cost;
		
		System.out.println("The total cost of the commute will be: " + total);
	}
}
		