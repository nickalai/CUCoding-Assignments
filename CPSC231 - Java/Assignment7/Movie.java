/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 7

Stores information about movies
*/

public class Movie
{
	//things that a movie has
	private String title;
	private int year;
	private int runtime;
	private boolean checkedOut;
	private int barcode;

	//default constructor
	public Movie()
	{
		title = "";
		year = 0;
		runtime  = 0;
		checkedOut = false;
		barcode = 0;
	}
	
	public Movie(String mTitle, int mYear, int mRuntime, boolean mCheckedOut, int mBarcode)
	{
		title = mTitle;
		year = mYear;
		runtime = mRuntime;
		checkedOut = mCheckedOut;
		barcode = mBarcode;
	}
	
	//gets all information
	public Movie(Movie m)
	{
		this(m.getTitle(), m.getYear(), m.getRuntime(), m.getCheckedOut(), m.getBarcode());
	}
	
	//getters and setters
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String mTitle)
	{
		title = mTitle;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int mYear)
	{
		year = mYear;
	}
	
	public int getRuntime()
	{
		return runtime;
	}
	
	public void setRuntime(int mRuntime)
	{
		runtime = mRuntime;
	}
	
	public boolean getCheckedOut()
	{
		return checkedOut;
	}
	
	public void setCheckedOut(boolean mCheckedOut)
	{
		checkedOut = mCheckedOut;
	}
	
	public int getBarcode()
	{
		return barcode;
	}
	
	public void setBarcode(int mBarcode)
	{
		barcode = mBarcode;
	}
	
	//equals methods and toString
	public boolean equals(Movie m)
	{
		return ((title.equals(m.getTitle()) && (year == m.getYear()) && (runtime == m.getRuntime())));
	}
	
	public String toString()
	{
		return "Title: " + title + " Year: " + year + "  Runtime: " + runtime;
	}
}