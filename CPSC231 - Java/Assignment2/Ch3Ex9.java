/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Takes user input to calculate the total grade after a certain amount of assignments and scores received on them.
*/

import java.util.Scanner;

public class Ch3Ex9
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		int count = 0;
		int score = 0;
		int totalPoints = 0;
		System.out.println("Enter the amount of classroom exercises: ");
		int N = keyboard.nextInt();
		for(int i = 0; i < N; i++)
		{
			count = count + 1;
			System.out.println("Score received for exercise " + count + ":");
			int scoreInput = keyboard.nextInt();
			System.out.println("Total points possible for exercise " + count + ":");
			int totalPointsInput = keyboard.nextInt();
			score = scoreInput + score;
			totalPoints = totalPointsInput + totalPoints;
		}
		double percentage = (double)(score)/ (double)(totalPoints) * 100;
		System.out.printf("Your total is " + score + " out of " + totalPoints + ", or %.2f%% \n", percentage);
	}
	
}