/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Prints out a name in pig latin
*/
public class Ch1Ex3
{
	public static void main(String[]args)
	{
		String first = "nick";
		String last = "lai";
		String pigLatinName = first.substring(1,2).toUpperCase() + first.substring(2,4) + first.substring(0,1) + "ay" + " " + last.substring(1,2).toUpperCase() + last.substring(2,3) + last.substring(0,1) + "ay"; 
		
		System.out.println("Your name in pig latin is: " + pigLatinName);
	}
}