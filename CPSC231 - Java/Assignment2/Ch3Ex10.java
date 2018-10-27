/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

The game of Pig vs. the computer.
*/
import java.lang.Math;
import java.util.Scanner;

public class Ch3Ex10
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		//shows which player's turn it is
		int turn = 0;
		//holds scores for the player and the CPU
		int score1 = 0;
		int total1 = 0;
		int score2 = 0;
		int total2 = 0;
		//acts as the 6-sided die
		int points = 0;

		//limits the program to only continue if the total scores are below 100
		while(total1 < 100 && total2 < 100)
		{
			//starts if it is the player's turn
			if(turn == 0 && score1 < 100)
			{
				points = (int)(1 + (Math.random() * 6));
				//ends turn if player rolls a 1
			}
			if(points == 1)
			{
				System.out.println("You rolled a 1. Your turn is over. Your current total score is:" + total1);
				score1 = 0;
				//changes it to the CPU's turn
				turn = 1;
			}
			//prompts user to roll again or end turn if anything other than 1 is rolled.
			while (points > 1 && score1 < 100)
			{
				System.out.println("You rolled a " + points);
				score1 = score1 + points;
				System.out.println("Your current score is: " + score1);
				System.out.println("Would you like to roll again (r) or hold (h)?: ");
				String choice = keyboard.nextLine();
			
				if(choice.equals("r") && total1 < 100)
				{
					points = (int)(1 + (Math.random() * 6));
					continue;
				}
				else if(choice.equals("h"))
				{
					total1 = total1 + score1;
					System.out.println("You ended your turn. Your current total score is: " + total1);
					score1 = 0;
					turn = 1;
					break;
				}
			}
		
			//starts if it is the CPU's turn    
			if(turn == 1 && total1 < 100)
			{
				points = (int)(1 + (Math.random() * 6));
				//ends the CPU's turn if it rolled a 1
				if (points == 1)
				{
					System.out.println("CPU rolled a 1. CPU's turn is over. CPU's current score is:" + total2);
					//sets it to the player's turn
					turn = 0;
				}
				//continuously rolls for the CPU until it rolls a 1 or hits 20 points, then the CPU holds
				while (points > 1 || score2 < 20)
				{
					score2 = score2 + points;
					System.out.println("CPU rolled a " + points);
					if (score2 >= 20)
					{
						total2 = total2 + score2;
						System.out.println("CPU's ended their turn. CPU's current score is:" + total2);
						score2 = 0;
						turn = 0;
						break;
					}
					else if (points == 1)
					{
						System.out.println("CPU rolled a 1. CPU's turn is over. CPU's current score is:" + total2);
						//sets it to the player's turn
						turn = 0;
					}
					points = (int)(1 + (Math.random() * 6));
					System.out.println("CPU's current score is:" + score2);
				}
			}
		}
	
		//triggers when the score cap is met            
		if (total1 >= 100 || score1 >= 100)
			System.out.println("Player wins! Overall score: " + total1 + " to " + total2);
    
		else if(total2 >= 100 || score2 >= 100)
			System.out.println("CPU wins! Overall score: " + total2 + " to " + total1);
	}
}

        
	