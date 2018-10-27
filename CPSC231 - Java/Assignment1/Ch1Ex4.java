/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Shows how much diet soda your dieting friend can drink before dying.
*/
public class Ch1Ex4
{
	public static void main(String[]args)
	{
		double sweetener = 0.01; //in grams, amount to kill a mouse
		double mouseWeight = 0.05; //weight of mouse in pounds
		double startWeight = 200; //weight of dieter in pounds
		double dietWeight =  150;//weight of dieter in pounds
		double constant = 0.001; //1/10th of 1% artificial sweetener in a soda
		
		double totalSweetener = (dietWeight * sweetener)/mouseWeight; //shows total intake of sweetener possible in a human when basing calculations off of a mouse
		double totalSoda = totalSweetener / constant; //converts the amount of sweetener into the amount of sodas with said amount of sweetener
		
		System.out.println("Your friend can drink " + totalSoda + " sodas before dying.");
	}
}