/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks for an integer input from the user. Returns the amount of change returned to the user.
*/
import java.util.Scanner;

public class Ch2Ex7
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the price of the item(from 25 cents to a dollar, in 5-cent increments): ");
		int price = keyboard.nextInt();
		int quarters = (100 - price)/25;
		int dimes = ((100 - price)%25)/10;
		int nickels = (((100 - price)%25)%10)/5;
		
		System.out.println("Your change is " + quarters + " quarter(s), " + dimes + " dime(s), and " + nickels + " nickel(s).");
	}
}