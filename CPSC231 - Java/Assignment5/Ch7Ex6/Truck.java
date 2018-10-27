/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Extends the class Vehicle. Stores information adding onto vehicle for a truck with a load capacity in tons and a towing capacity in pounds. 
*/

public class Truck extends Vehicle
{
	private double load;
	private int capacity;
	
	public Truck()
	{
		super();
		load = 0;
		capacity = 0;
	}
	
	public Truck(String m, int c, Person p, double load, int capacity)
	{
		super(m, c, p);
		this.load = load;
		this.capacity = capacity;
	}
	
	public Truck(Truck other)
	{
		super(other);
		load = other.load;
		capacity = other.capacity;
	}
	
	public double getLoad()
	{
		return load;
	}
	
	public void setLoad(double load)
	{
		this.load = load;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	public String toString()
	{
		return super.toString() + ", " + load + " ton load, " + capacity + " lbs towing capacity";
	}
	
	public boolean isEquals(Truck other)
	{
		return super.equals(other) && load == other.load && capacity == other.capacity;
	}
}