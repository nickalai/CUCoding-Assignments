/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Asks for a string input from the user. Prints out the string first in all upper case, then all lower case.
*/
import java.util.Scanner;

public class Ch2Ex8
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String line = keyboard.nextLine();
		
		System.out.println(line.toUpperCase());
		System.out.println(line.toLowerCase());
	}
}