/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Stores textual content for a document and returns it via toString
*/

public class Document
{
	private String text;
	
	public Document()
	{
		this.text = "";
	}
	
	public Document(String text)
	{
		setText(text);
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public String toString()
	{
		return text;
	}
}