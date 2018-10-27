/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks the user to input their name. Returns their name in pig latin.
*/
import java.util.Scanner;

public class Ch2Ex2
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter your first name: ");
		String first = keyboard.nextLine();
		System.out.println("Enter your last name: ");
		String last = keyboard.nextLine();
		
		first = first.toLowerCase();
		last = last.toLowerCase();
		
		String pigLatinName = first.substring(1,2).toUpperCase() + first.substring(2,4) + first.substring(0,1) + "ay" + " " + last.substring(1,2).toUpperCase() + last.substring(2,3) + last.substring(0,1) + "ay";
		
		System.out.println("Your name in piglatin is: " + pigLatinName);
	}
}