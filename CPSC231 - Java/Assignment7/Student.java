/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 7

Stores information about students
*/

public class Student
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int phoneNum;
	private boolean hasItem;
	private int itemNum;

	//default constructor
	public Student()
	{
		id = 0;
		firstName = "";
		lastName = "";
		email = "";
		phoneNum = 0;
		hasItem = false;
		itemNum = -1;
	}
	
	public Student(int sID)
	{
		id = sID;
		firstName = "";
		lastName = "";
		email = "";
		phoneNum = 0;
		hasItem = false;
		itemNum = -1;
	}
	
	public Student(int sID, String sFirstName, String sLastName, String sEmail, int sPhoneNum, boolean sHasItem, int sItemNum)
	{
		id = sID;
		firstName = sFirstName;
		lastName = sLastName;
		email = sEmail;
		phoneNum = sPhoneNum;
		hasItem = sHasItem;
		itemNum = sItemNum;
	}
	
	//gets all information
	public Student(Student s)
	{
		this(s.getID(),s.getFirstName(),s.getLastName(),s.getEmail(),s.getPhoneNum(), s.getHasItem(), s.getItemNum());
	}
	
	//getters and setters
	public int getID()
	{
		return id;
	}
	
	public void setID(int sID)
	{
		id = sID;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String sFirstName)
	{
		firstName = sFirstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String sLastName)
	{
		lastName = sLastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String sEmail)
	{
		email = sEmail;
	}
	
	public int getPhoneNum()
	{
		return phoneNum;
	}
	
	public void setPhoneNum(int sPhoneNum)
	{
		phoneNum = sPhoneNum;
	}
	
	public boolean getHasItem()
	{
		return hasItem;
	}
	
	public void setHasItem(boolean sHasItem)
	{
		hasItem = sHasItem;
	}
	
	public int getItemNum()
	{
		return itemNum;
	}
	
	public void setItemNum(int sItemNum)
	{
		itemNum = sItemNum;
	}
	
	//equals method and toString
	public boolean equals(Student s)
	{
		return ((id == s.getID()) && (firstName.equals(s.getFirstName())) && (lastName.equals(s.getLastName())) && (email.equals(s.getEmail())) && (phoneNum == s.getPhoneNum()) && (hasItem == s.getHasItem()));
	}
	
	public String toString()
	{
		return "Student's ID: " + id + " Name: " + firstName + " " + lastName + "  E-mail: " + email + " Phone Number: " + phoneNum + " Registered: " + hasItem;
	}
}