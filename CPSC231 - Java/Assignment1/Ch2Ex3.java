/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks the user for two integer inputs. Returns the sum, difference and product of the two inputs.
*/
import java.util.Scanner;

public class Ch2Ex3
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the first integer: ");
		int firstInt = keyboard.nextInt();
		System.out.println("Enter the second integer: ");
		int secondInt = keyboard.nextInt();
		
		int sum = firstInt + secondInt;
		int difference = firstInt - secondInt;
		int product = firstInt * secondInt;
		
		System.out.println("The sum of the two integers is: " + sum);
		System.out.println("The difference of the two integers is: " + difference);
		System.out.println("The product of the two integers is: " + product);
	}
}