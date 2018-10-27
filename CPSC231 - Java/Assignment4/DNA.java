/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 4

Takes input of a DNA strand (consisting of capital letters A, C, G, or T) and returns the complement strand and the reverse of the complement strand.
*/
import java.util.*;

public class DNA
{
	private String dnaStrand;
	private String complementStrand;
	private String revStrand;
	private boolean isDNAStrand;
	
	public DNA()
	{
		this.dnaStrand = "";
		this.complementStrand = "";
		this.revStrand = "";
		this.isDNAStrand = true;
	}
	
	//copy constructor
	public DNA(String dnaStrand, String complementStrand, String revStrand)
	{
		this.dnaStrand = dnaStrand;
		this.complementStrand = complementStrand;
		this.revStrand = revStrand;
		this.isDNAStrand = isDNAStrand;
	}
	
	//getters and setters
	public String getDNAStrand()
	{
		return dnaStrand;
	}
	
	public void setDNAStrand(String dnaStrand)
	{
		this.dnaStrand = dnaStrand;
	}
	
	public String getComplementStrand()
	{
		return complementStrand;
	}
	
	public void setComplementStrand(String complementStrand)
	{
		this.complementStrand = complementStrand;
	}
	
	public String getRevStrand()
	{
		return revStrand;
	}
	
	public void setRevStrand(String revStrand)
	{
		this.revStrand = revStrand;
	}
	
	//takes in the DNA strand and creates a new string and iterates through it. For specific letters, the complement is put in its place in the complement string.
	public String complement(String dnaStrand)
	{
		for(int i = 0;i < dnaStrand.length(); i++)
		{
			if(dnaStrand.charAt(i) == 'T')
			{
				complementStrand = complementStrand + "A";
			}
			if(dnaStrand.charAt(i) == 'A')
			{
				complementStrand = complementStrand + "T";
			}
			if(dnaStrand.charAt(i) == 'C')
			{
				complementStrand = complementStrand + "G";
			}
			if(dnaStrand.charAt(i) == 'G')
			{
				complementStrand = complementStrand + "C";
			}   
			
			else if(dnaStrand.charAt(i) != 'T' && dnaStrand.charAt(i) != 'A' && dnaStrand.charAt(i) != 'C' && dnaStrand.charAt(i) != 'G')
			{
				isDNAStrand = false;
				return ("Error. Not a valid strand of DNA.");
				//break;
			}
			
		}
		return "Complement Strand: " + complementStrand;
	}
	
	//takes in the complement strand and reverses the string.
	public String reverseComplement()
	{
		if(isDNAStrand = true)
		{
			for (int i = complementStrand.length()-1; i>=0; i--) 
			{
				revStrand = revStrand + complementStrand.charAt(i);
			}
			return "Reverse Strand: " + revStrand;
		}
		
		else
		{
			return ("Error. Not a valid strand of DNA.");
		}
	}
	
	public String toString()
	{
		return new String(dnaStrand);
	}
}
	