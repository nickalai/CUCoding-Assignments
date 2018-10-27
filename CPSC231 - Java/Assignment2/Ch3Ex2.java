/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Simulates 10,000 games of craps. Prints out odds of winning
*/
import java.lang.Math;

public class Ch3Ex2
{
	public static void main(String[]args)
	{
		int gameCount = 0; //keeps track of how many games have occured
		int die1 = (int)(1 + (Math.random() * 6)); //randomly rolls a number between 1 and 6 inclusive
		int die2 = (int)(1 + (Math.random() * 6));
		int thePoint = 0; //keeps track of "the point"
		int win = 0; //keeps track of the amount of wins
		int loss = 0; //keeps track of the amount of losses
		
		while(gameCount < 10000) //code continues to loop until 10000 games have been played
		{
			int total = die1 + die2; //adds together the dice
			if(total == 7 || total == 11) //route code takes for a winning come out roll
			{
				total = 0;
				die1 = (int)(1 + (Math.random() * 6));
				die2 = (int)(1 + (Math.random() * 6));
				win++; //adds 1 to the win count
				gameCount++; //adds 1 to the game count
				continue;
			}
			else if(total == 2 || total == 3 || total == 12)
			{
				total = 0;
				die1 = (int)(1 + (Math.random() * 6));
				die2 = (int)(1 + (Math.random() * 6));
				loss++; //adds one to the loss count
				gameCount++;
				continue;
			}
			else
			{
				thePoint = total; //sets "the point" to what the roll was
				total = 0; //resets total
				while((total != thePoint) && (total != 7)) //keeps rerolling until either a 7 or "the point" is rolled
				{
					die1 = (int)(1 + (Math.random() * 6));
					die2 = (int)(1 + (Math.random() * 6));
					total = die1 + die2;
				}
				if(total == thePoint) //a win 
				{
					total = 0;
					die1 = (int)(1 + (Math.random() * 6));
					die2 = (int)(1 + (Math.random() * 6));
					win++;
					gameCount++;
					continue;
				}
				else if(total == 7)//a loss
				{
					total = 0;
					die1 = (int)(1 + (Math.random() * 6));
					die2 = (int)(1 + (Math.random() * 6));
					loss++;
					gameCount++;
					continue;					
				}
			}
		}
		double probability = ((double)win / ((double)win + (double)loss)) * 100; //calculates percent chance of winning
		System.out.println("Total Wins: " + win);
		System.out.println("Total Losses: " + loss);
		System.out.printf("Probability of Winning: %.2f%% \n", probability);
	}
}