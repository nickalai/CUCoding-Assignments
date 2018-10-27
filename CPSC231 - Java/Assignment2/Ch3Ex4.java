/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Takes user input of a price, years and percent and outputs the cost of the item after inflation
*/
import java.util.Scanner;
public class Ch3Ex4
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the cost of the item: ");
		double cost = keyboard.nextDouble();
		System.out.println("Enter how many years from now the item will be purhcased: ");
		int years = keyboard.nextInt();
		System.out.println("Enter the rate of inflation(without the percentage symbol): ");
		double percent = keyboard.nextDouble();
		percent = percent / 100;
		double addedCost = 0;
		
		for(int i = 0; i < years; ++i)
		{
			cost = (cost * percent) + cost;
		}
		System.out.printf("The cost after " + years + " years of inflation is: $%.2f \n", cost);
		
	}
}