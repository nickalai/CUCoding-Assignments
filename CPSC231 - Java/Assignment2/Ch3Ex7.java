/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Finds the sums for n=1 through 10 for an input x
*/
import java.util.Scanner;
import java.lang.Math;

public class Ch3Ex7
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String isFunctional = "yes";
		while(isFunctional.equals("yes"))
		{
			System.out.println("Enter an integer: ");
			double x = keyboard.nextDouble();
			
			double n1 = 1;
			double n2 = n1 * 2;
			double n3 = n2 * 3;
			double n4 = n3 * 4;
			double n5 = n4 * 5;
			double n6 = n5 * 6;
			double n7 = n6 * 7;
			double n8 = n7 * 8;
			double n9 = n8 * 9;
			double n10 = n9 * 10;
			
			double sum1 = 1 + x;
			double sum2 = sum1 + (Math.pow(x, 2) / n2);
			double sum3 = sum2 + (Math.pow(x, 3) / n3);
			double sum4 = sum3 + (Math.pow(x, 4) / n4);
			double sum5 = sum4 + (Math.pow(x, 5) / n5);
			double sum6 = sum5 + (Math.pow(x, 6) / n6);
			double sum7 = sum6 + (Math.pow(x, 7) / n7);
			double sum8 = sum7 + (Math.pow(x, 8) / n8);
			double sum9 = sum8 + (Math.pow(x, 9) / n9);
			double sum10 = sum9 + (Math.pow(x, 10) / n10);
			
			System.out.println("Your sums for n = 1 through 10 are: ");
			System.out.println(sum1 + ", " + sum2 + ", " + sum3 + ", " + sum4 + ", " + sum5 + ", " + sum6 + ", " + sum7 + ", " + sum8 + ", " +sum9 + ", and " + sum10);
			
			System.out.println("Would you like to continue?('yes' or 'no'): ");
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