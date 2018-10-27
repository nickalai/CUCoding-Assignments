/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 2

Asks the user to input their gender, their mother's height (in.) and their father's height (in.) and prints out their estimated height.
*/
import java.util.Scanner;

public class Ch3Ex3
{
	public static void main(String[]args)
	{
		Scanner keyboard = new Scanner(System.in);
		int hMale = 0;
		int hFemale = 0;
		boolean isFunctional = true;
		while(isFunctional == true) //continues the code until isFunctional is changed to false
		{
			System.out.println("Enter your gender(M/F)(Enter 'Quit' to exit the program): ");
			String gender = keyboard.nextLine();
			
			gender = gender.toUpperCase();
			if(gender.equals("QUIT")) //changes isFunctional to false if user inputs "Quit"
			{
				isFunctional = false;
				break;
			}
			System.out.println("Enter the height of your mother in inches: ");
			int motherHeight = keyboard.nextInt();
			
			System.out.println("Enter the height of your father in inches: ");
			int fatherHeight = keyboard.nextInt();
			keyboard.nextLine(); //clears up the inputs
			
			if(gender.equals("M")) //route code takes if user inputs Male
			{
				hMale = ((motherHeight * 13/12) + fatherHeight) / 2;
				int hMaleFt = hMale / 12; //converts from inches to ft
				int hMaleIn = hMale % 12;
				System.out.println("Your estimated height is: " + hMaleFt + " ft " + hMaleIn + " in.");
			}
			else if(gender.equals("F")) //route code takes if user inputs Female
			{
				hFemale = ((fatherHeight * 12/13) + motherHeight) / 2;
				int hFemFt = hFemale / 12; //converts from inches to ft.
				int hFemIn = hFemale % 12;
				System.out.println("Your estimated height is: " + hFemFt + " ft " + hFemIn + " in.");
			}
		}
	}
}