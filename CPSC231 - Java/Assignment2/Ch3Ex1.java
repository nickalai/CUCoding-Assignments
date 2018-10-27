/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Takes the a number input and a guess at the square root, outputs the actual square root.
*/
import java.util.Scanner;

public class Ch3Ex1
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		double n = keyboard.nextDouble();
		
		System.out.println("Guess the square root of the number: ");
		double guess = keyboard.nextDouble();
		
		double r = n / guess;
		double previousGuess = 0;
		previousGuess = guess;
		guess = (guess + r) / 2;

		while(guess / previousGuess < 0.99)
		{
			r = n / guess;
			previousGuess = guess;
			guess = (guess + r) / 2;
		}
		System.out.printf("The square root of the number you input is: %.2f \n", guess);
	}
}