/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks the uesr for 3 inputs. Returns the yearly depreciation value.
*/
import java.util.Scanner;

public class Ch2Ex5
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input the purchase price of the item: ");
		double P = keyboard.nextDouble();
		System.out.println("Input the salvage vaule of the item: ");
		double S = keyboard.nextDouble();
		System.out.println("Input the number of years the item was used: ");
		double Y = keyboard.nextDouble();
		
		double depreciationValue = (P - S) / Y;
		
		System.out.println("The yearly depreciation value for your item is: " + depreciationValue);
		
	}
}