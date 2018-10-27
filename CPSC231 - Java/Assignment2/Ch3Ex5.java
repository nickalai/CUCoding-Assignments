/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Calculates the amount of interest and size of debt after each month
*/
public class Ch3Ex5
{
	public static void main(String[]args)
	{
		double stereoCost = 1000;
		double totalInterest = 0;
		int months = 0;
		while(stereoCost > 0)
		{
			totalInterest = totalInterest + (stereoCost*0.015);
			stereoCost = stereoCost - (50-(stereoCost*0.015));
			months++;
		}
		System.out.printf("Over " + months + " months, your stereo system was paid off. You paid $%.2f in interest.\n", totalInterest);
	}
}