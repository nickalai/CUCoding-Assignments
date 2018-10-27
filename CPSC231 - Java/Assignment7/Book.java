/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 7

Stores information about books
*/

public class Book
{
	//things a book has
	private String title;
	private String author;
	private int numPages;
	private int isbn;
	private boolean checkedOut;
	private int barcode;

	//default constructor
	public Book()
	{
		title = "";
		author = "";
		numPages  = 0;
		isbn = 0;
		checkedOut = false;
		barcode = 0;
		
	}
	
	public Book(String bTitle, String bAuthor, int bNumPages, int bISBN, boolean bCheckedOut, int bBarcode)
	{
		title = bTitle;
		author = bAuthor;
		numPages  = bNumPages;
		isbn = bISBN;
		checkedOut = bCheckedOut;
		barcode = bBarcode;
	}
	
	//gets all information
	public Book(Book b)
	{
		this(b.getTitle(), b.getAuthor(), b.getNumPages(), b.getISBN(), b.getCheckedOut(), b.getBarcode());
	}
	
	//getters and setters
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String bTitle)
	{
		title = bTitle;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String bAuthor)
	{
		author = bAuthor;
	}
	
	public int getNumPages()
	{
		return numPages;
	}
	
	public void setNumPages(int bNumPages)
	{
		numPages = bNumPages;
	}
	
	public int getISBN()
	{
		return isbn;
	}
	
	public void setISBN(int bISBN)
	{
		isbn = bISBN;
	}
	
	public boolean getCheckedOut()
	{
		return checkedOut;
	}
	
	public void setCheckedOut(boolean bCheckedOut)
	{
		checkedOut = bCheckedOut;
	}
	
	public int getBarcode()
	{
		return barcode;
	}
	
	public void setBarcode(int bBarcode)
	{
		barcode = bBarcode;
	}
	
	//equals method and toString
	public boolean equals(Book b)
	{
		return ((title.equals(b.getTitle())) && (author.equals(b.getAuthor())) && (numPages == b.getNumPages()) && (isbn == b.getISBN()));
	}
	
	public String toString()
	{
		return "Title: " + title + " Author: " + author + "  Pages: " + numPages + " ISBN: " + isbn;
	}
}