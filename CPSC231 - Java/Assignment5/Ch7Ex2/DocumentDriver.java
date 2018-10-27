/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Tests several objects of type Email and File. Checks if certain keywords are contained in the content of an email. 
*/


public class DocumentDriver
{
	public static boolean ContainsKeyword(Document docObject, String keyword)
	{
		if(docObject.toString().indexOf(keyword, 0) >= 0)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[]args)
	{
		String sample1 = "Tacocat is tacocat spelled backwards.";
		String sample2 = "Sometimes I like to rub myself in vaseline and pretend that I'm a snail.";
		Document email1 = new Email(sample1, "Lai", "Lahaye", "Backwards Word");
		Document email2 = new Email(sample2, "Nick", "Peter", "Weird Things");
		
		Document file1 = new File(sample1, "palindrome.txt");
		Document file2 = new File(sample2, "weirdo.txt");
		
		System.out.println("---");
		System.out.println(email1.toString());
		System.out.println("---");
		System.out.println(email2.toString());
		System.out.println("---");
		System.out.println(file1.toString());
		System.out.println(file2.toString());
		
		String testWord = "vaseline";
		
		if(ContainsKeyword(email1, testWord))
		{
			System.out.println("Email 1 contains the word " + testWord);
		}
		
		else
		{
			System.out.println("Email 1 does not contain the word " + testWord);
		}
		
		if(ContainsKeyword(email2, testWord))
		{
			System.out.println("Email 2 contains the word " + testWord);
		}
		
		else
		{
			System.out.println("Email 2 does not contain the word " + testWord);
		}
		
		if(ContainsKeyword(file1, testWord))
		{
			System.out.println("File 1 contains the word " + testWord);
		}
		
		else
		{
			System.out.println("File 1 does not contain the word " + testWord);
		}
		
		if(ContainsKeyword(file2, testWord))
		{
			System.out.println("File 2 contains the word " + testWord);
		}
		
		else
		{
			System.out.println("File 2 does not contain the word " + testWord);
		}
	}
}