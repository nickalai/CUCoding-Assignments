/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Uses the Fibonacci sequence to calculate asexual reproduction at a rate of one offspring per time period
*/
import java.util.Scanner;

public class Ch3Ex6
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		String isFunctional = "yes";
		while(isFunctional.equals("yes"))
		{
			System.out.println("Input the initial size of the green crud population(in pounds): ");
			int initialSize = keyboard.nextInt();
			
			System.out.println("Input the number of days: ");
			int days = keyboard.nextInt();
			
			int periods = days / 5;
			int fibA = initialSize;
			int fibB = fibA;
			int fibTemp;
			for(int i = 1; i <= periods; i++)
			{
				fibTemp = fibA + fibB;
				fibA = fibB;
				fibB = fibTemp;
			}
			
			System.out.println("After " + days + " days, the green crud population will grow to " + fibA + " pounds.");
			System.out.println("Would you like to simulate the population again?('yes' or 'no'): ");
			
			isFunctional = keyboard.next();
			if(isFunctional.equals("yes"))
			{
				continue;
			}
			
			else
			{
				System.out.println("Progam will now end.");
				break;
			}
		}
	}
}
		
