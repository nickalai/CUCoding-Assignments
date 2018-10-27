/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 7

Stores information about periodicals
*/

public class Periodical
{
	//Things a periodical has
	private String name;
	private int releaseDate;
	private boolean checkedOut;
	private int barcode;

	//default constructor
	public Periodical()
	{
		name = "";
		releaseDate = 0;
		checkedOut = false;
		barcode = 0;
	}
	
	public Periodical(String pName, int pReleaseDate, boolean pCheckedOut, int pBarcode)
	{
		name = pName;
		releaseDate = pReleaseDate;
		checkedOut = pCheckedOut;
		barcode = pBarcode;
	}
	
	//gets all information
	public Periodical(Periodical p)
	{
		this(p.getName(), p.getReleaseDate(), p.getCheckedOut(), p.getBarcode());
	}
	
	//getters and setters
	public String getName()
	{
		return name;
	}
	
	public void setName(String pName)
	{
		name = pName;
	}
	
	public int getReleaseDate()
	{
		return releaseDate;
	}
	
	public void setReleaseDate(int pReleaseDate)
	{
		releaseDate = pReleaseDate;
	}
	
	public boolean getCheckedOut()
	{
		return checkedOut;
	}
	
	public void setCheckedOut(boolean pCheckedOut)
	{
		checkedOut = pCheckedOut;
	}
	
	public int getBarcode()
	{
		return barcode;
	}
	
	public void setBarcode(int pBarcode)
	{
		barcode = pBarcode;
	}
	
	//equals method and toString
	public boolean equals(Periodical p)
	{
		return ((name.equals(p.getName())) && (releaseDate == p.getReleaseDate()));
	}
	
	public String toString()
	{
		return "Name: " + name + " Release: " + releaseDate;
	}
}