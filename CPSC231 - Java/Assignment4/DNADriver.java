/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 

Allows for up to 3 inputs in the command line, outputs complement and the reverse of the complement
*/
public class DNADriver
{
	public static void main(String[] args)
	{
		//creates 3 instances of DNA
		DNA strand1 = new DNA();
		DNA strand2 = new DNA();
		DNA strand3 = new DNA();
		
		//prints out information based on the first command line input
		System.out.println(strand1.complement(args[0]));
		System.out.println(strand1.reverseComplement());
		System.out.println();
		
		//prints out information based on the second command line input
		System.out.println(strand2.complement(args[1]));
		System.out.println(strand2.reverseComplement());
		System.out.println();
		
		//prints out information based on the third command line input
		System.out.println(strand3.complement(args[2]));
		System.out.println(strand3.reverseComplement());
		System.out.println();
	}
}