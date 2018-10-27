/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks for multiple inputs from the user. Prints out a receipt for items listed.
*/
import java.util.Scanner;

public class Ch2Ex10
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input name of item 1: ");
		String name = keyboard.nextLine();
		System.out.println("Input the quantity of item 1: ");
		int quantity1 = keyboard.nextInt();
		System.out.println("Input the price of item 1: ");
		double price1 = keyboard.nextDouble();
		keyboard.nextLine();//consumes leftover new line
		
		System.out.println("Input name of item 2");
		String secondName = keyboard.nextLine();
		System.out.println("Input the quantity of item 2: ");
		int quantity2 = keyboard.nextInt();
		System.out.println("Input the price of item 2: ");
		double price2 = keyboard.nextDouble();
		keyboard.nextLine();//consumes leftover new line
		
		System.out.println("Input name of item 3: ");
		String thirdName = keyboard.nextLine();
		System.out.println("Input the quantity of item 3: ");
		int quantity3 = keyboard.nextInt();
		System.out.println("Input the price of item 3: ");
		double price3 = keyboard.nextDouble();
		keyboard.nextLine();//consumes leftover new line
		
		double total1 = price1 * quantity1;
		double total2 = price2 * quantity2;
		double total3 = price3 * quantity3;
		double subtotal = total1 + total2 + total3;
		double tax = (total1 + total2 + total3) * 0.0625;
		double overallPrice = subtotal + tax;
		
		System.out.println("Your bill:");
		System.out.println("Item:                   Quantity      Price       Total     ");
		System.out.printf("%-30s %d %10.2f %11.2f %n", name, quantity1, price1, total1);
		System.out.printf("%-30s %d %10.2f %11.2f %n", secondName, quantity2, price2, total2);
		System.out.printf("%-30s %d %10.2f %11.2f %n", thirdName, quantity3, price3, total3);
		System.out.println("");
		System.out.printf("Subtotal%47.2f %n", subtotal);
		System.out.printf("6.25%% sales tax%40.2f %n", tax);
		System.out.printf("Total%50.2f%n", overallPrice);
	}
} 
		
		