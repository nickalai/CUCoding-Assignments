/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Extends the class Document. Sets a path name for the email
*/

public class File extends Document
{
	private String pathname;
	
	public File(String textMsg, String pathname)
	{
		super(textMsg);
		this.pathname = pathname;
	}
	
	public String getPathname()
	{
		return pathname;
	}
	
	public void setPathname(String pathname)
	{
		this.pathname = pathname;
	}
	
	public String getText()
	{
		return super.toString();
	}
	
	public String toString()
	{
		return pathname + ": " + super.toString();
	}
}