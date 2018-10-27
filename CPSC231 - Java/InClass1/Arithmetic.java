/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: In-Class Assignment #1

3 Methods, Sum of 2 integers, sum of an array, and average of an array.
*/
public class Arithmetic
{
	public int Sum(int x,int y)
	{
		return x + y;
	}
	
	public int ArraySum(int[] arrayAddition)
	{
		int sum = 0;
		for(int i = 0; i < arrayAddition.length; i++)
		{
			sum += arrayAddition[i];
		}
		return sum;
	}
	
	public double ArrayAvg(int[] arrayAverage)
	{
		double sum = 0;
		for(int i = 0; i < arrayAverage.length; i++)
		{
			sum += arrayAverage[i];
		}
		double mean = sum / (double)(arrayAverage.length);
		return mean;
	}
}