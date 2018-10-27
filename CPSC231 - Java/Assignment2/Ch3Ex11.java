/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Randomly picks 3 numbers 1-30. No repeat picks.
*/
public class Ch3Ex11
{
	public static void main(String[]args)
	{
		int firstPick = 0;
		int secondPick = 0;
		int thirdPick = 0;
		int currentPick = 0;
		for(int i = 0; i < 3; i++)
		{
			currentPick = (int)(1 + Math.floor(Math.random() * 30));
			firstPick = currentPick;
			while(currentPick == firstPick)
				currentPick = (int)(1 + Math.floor(Math.random() * 30));
			secondPick = currentPick;
			while((currentPick == firstPick) || (currentPick == secondPick))
				currentPick = (int)(1 + Math.floor(Math.random() * 30));
			thirdPick = currentPick;
		}
		System.out.println("The three finalists that will receive a prize are: " + firstPick + ", " + secondPick + ", and " + thirdPick +". Congratz!");
	}
}