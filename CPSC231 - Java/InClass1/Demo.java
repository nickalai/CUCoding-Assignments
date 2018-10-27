/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: In-Class Assignment #1

Initializes an array of integers of size 5 and calls the 3 methods, then prints the results.
*/

public class Demo
{
	public static void main(String[]args)
	{
		int x = 5;
		int y = 7;
		int[] arrayFunctions = {2,3,5,10,15};
		Arithmetic functions = new Arithmetic();
		
		
		System.out.println(functions.Sum(x,y));
		System.out.println(functions.ArraySum(arrayFunctions));
		System.out.println(functions.ArrayAvg(arrayFunctions));
	}
}