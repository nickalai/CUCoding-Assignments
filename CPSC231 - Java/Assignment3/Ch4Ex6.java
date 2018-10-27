/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 

Methods for calculating grades based on 3 quiz inputs, a midterm input and a final input
*/
import java.util.Scanner;

public class Ch4Ex6
{	
	private double q1;
	private double q2;
	private double q3;
	private double midterm;
	private double finalExam;
	String grade;
	double overallNumeric;
	
	//calculates grades based on weight
	public void studentRecord()
	{
		double quizTotal = ((q1 + q2 + q3) / 30) * 0.25;
		double midtermTotal = (midterm / 100) * 0.35;
		double finalTotal = (finalExam/100) * 0.4;
		overallNumeric = (quizTotal + midtermTotal + finalTotal) * 100;
	}
	
	//takes in the total % grade, outputs a letter grade
	public void overallGrade()
	{
		if(overallNumeric >= 90)
		{
			grade = "A";
		}
		if(overallNumeric < 90 && overallNumeric >= 80)
		{
			grade = "B";
		}
		if(overallNumeric < 80 && overallNumeric >= 70)
		{
			grade = "C";
		}
		if(overallNumeric < 70 && overallNumeric >= 60)
		{
			grade = "D";
		}
		if(overallNumeric < 60)
		{
			grade = "F";
		}
	}
	
	//method for reading in inputs from user
	public void readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your first quiz grade(10 points possible): ");
		q1 = keyboard.nextInt();
		if(q1 < 0 || q1 > 10)
		{
			System.out.println("Error. Not a valid score.");
			System.exit(0);
		}
		System.out.println("Enter your second quiz grade(10 points possible): ");
		q2 = keyboard.nextInt();
		if(q2 < 0 || q2 > 10)
		{
			System.out.println("Error. Not a valid score.");
			System.exit(0);
		}
		System.out.println("Enter your third quiz grade(10 points possible): ");
		q3 = keyboard.nextInt();
		if(q3 < 0 || q3 > 10)
		{
			System.out.println("Error. Not a valid score.");
			System.exit(0);
		}
		System.out.println("Enter your midterm grade(100 points possible): ");
		midterm = keyboard.nextInt();
		if(midterm < 0 || midterm > 100)
		{
			System.out.println("Error. Not a valid score.");
			System.exit(0);
		}
		System.out.println("Enter your final exam grade(100 points possible): ");
		finalExam = keyboard.nextInt();
		if(finalExam < 0 || finalExam > 100)
		{
			System.out.println("Error. Not a valid score.");
			System.exit(0);
		}
	}	
	
	//prints out grade percent and letter grade
	public void outputStudentRecord()
	{
		System.out.println("Overall Grade: " + grade);
		System.out.println("Overall Percentage: " + overallNumeric + "%");
	}
	
	//returns the rest of the information
	public String toString()
	{
		return("Quiz 1 Grade: " + q1 + "\nQuiz 2 Grade: " + q2 + "\nQuiz 3 Grade: " + q3 + "\nMidterm Grade: " + midterm + "\nFinal Exam Grade: " + finalExam);		
	}
	
	public boolean equals(Ch4Ex6 other)
	{
		return overallNumeric == other.overallNumeric;
	}
}