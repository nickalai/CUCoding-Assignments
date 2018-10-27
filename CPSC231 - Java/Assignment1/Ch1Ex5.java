/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 1

Replaces the first instance of the word "hate" with "love" in a string.
*/
public class Ch1Ex5
{
	public static void main(String[]args)
	{
		String message = "I hate everything that exists.";
		String replace = "love";
		String result = message.replaceFirst("hate", replace);
		
		System.out.println(result);
	}
}