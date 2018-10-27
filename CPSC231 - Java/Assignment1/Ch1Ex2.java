/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Prints out the total number of candy bars and gumballs you can get with a certain amount of coupons.
*/
public class Ch1Ex2
{
	public static void main(String[]args)
	{
		int couponTotal = 57;
		int candyBar = couponTotal / 10;
		int gumball = (couponTotal % 10) / 3;
		
		System.out.println("You may redeem " + couponTotal + " for " + candyBar + " candy bars and " + gumball + " gumballs.");
	}
}