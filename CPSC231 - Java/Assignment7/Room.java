/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 7

Stores information about rooms
*/

public class Room
{
	//things a room has
	private int roomNumber;
	private int capacity;
	private boolean hasPC;
	private boolean checkedOut;
	private int barcode;

	//default constructor
	public Room()
	{
		roomNumber = 0;
		capacity= 0;
		hasPC = false;
		checkedOut = false;
		barcode = 0;
	}
	
	public Room(int rRoomNumber, int rCapacity, boolean rHasPC, boolean rCheckedOut, int rBarcode)
	{
		roomNumber = rRoomNumber;
		capacity = rCapacity;
		hasPC = rHasPC;
		checkedOut = rCheckedOut;
		barcode = rBarcode;
	}
	
	//gets all information 
	public Room(Room r)
	{
		this(r.getRoomNumber(), r.getCapacity(), r.getHasPC(), r.getCheckedOut(), r.getBarcode());
	}
	
	//getters and setters
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public void setRoomNumber(int rRoomNumber)
	{
		roomNumber = rRoomNumber;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	public void setCapasity(int rCapacity)
	{
		capacity = rCapacity;
	}
	
	public boolean getHasPC()
	{
		return hasPC;
	}
	
	public void setAllowsComp(boolean rHasPC)
	{
		hasPC = rHasPC;
	}
	
	public boolean getCheckedOut()
	{
		return checkedOut;
	}
	
	public void setCheckedOut(boolean rCheckedOut)
	{
		checkedOut = rCheckedOut;
	}
	
	public int getBarcode()
	{
		return barcode;
	}
	
	public void setBarcode(int rBarcode)
	{
		barcode = rBarcode;
	}
	
	//equals method and toString
	public boolean equals(Room r)
	{
		return ((roomNumber == r.getRoomNumber()) && (capacity== r.getCapacity()) && (hasPC == r.getHasPC()));
	}
	
	public String toString()
	{
		return "Room Number: " + roomNumber + " Capacity: " + capacity+ "  Has a Computer: " + hasPC;
	}
}