/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Vehicle class that stores information on a vehicle's manufacturer, cylinder count, and owner. 
*/

public class Vehicle
{
	private String manufacturer;
	private int cylinders;
	private Person owner;
	
	public Vehicle()
	{
		manufacturer = "none";
		cylinders = 1;
		owner = null;
	}
	
	public Vehicle(String manufacturer, int cylinders, Person theOwner)
	{
		this.manufacturer = manufacturer;
		this.cylinders = cylinders;
		owner = new Person(theOwner);
	}
	
	public Vehicle(Vehicle other)
	{
		manufacturer = other.manufacturer;
		cylinders = other.cylinders;
		owner = new Person(other.owner);
		
	}
	
	public String getManufacturer()
	{
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	
	public int getCylinders()
	{
		return cylinders;
	}
	
	public void setCylinders(int cylinders)
	{
		this.cylinders = cylinders;
	}
	
	public Person getOwner()
	{
		return owner;
	}
	
	public void setOwner(Person newOwner)
	{
		owner = new Person(newOwner);
	}
	
	public String toString()
	{
		return manufacturer + ", " + cylinders + " cylinders, owned by " + owner;
	}
	
	public boolean equals(Vehicle other)
	{
		return manufacturer.equals(other.manufacturer) && cylinders == other.cylinders;
	}
}
	