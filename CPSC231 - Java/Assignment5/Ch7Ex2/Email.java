/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Extends the Document class. Includes the sender, recipient and title variables. Stores the email in the inherited variable text.
*/

public class Email extends Document
{
	private String sender;
	private String recipient;
	private String title;
	
	public Email()
	{
		this.sender = "";
		this.recipient = "";
		this.title = "";
	}
	
	public Email(String text, String sender, String recipient, String title)
	{
		super(text);
		this.sender = sender;
		this.recipient = recipient;
		this.title = title;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	public void setSender(String sender)
	{
		this.sender = sender;
	}
	
	public String getRecipient()
	{
		return recipient;
	}
	
	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String gettext()
	{
		return super.toString();
	}
	
	public String toString()
	{
		return "From: " + sender + "\nTo: " + recipient + "\nSubject: " + title + "\n\n" + super.toString();
	}
}
	