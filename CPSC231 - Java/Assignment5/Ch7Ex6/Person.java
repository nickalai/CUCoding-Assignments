/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

The given person class for the assignment. Contains a name.
*/

public class Person
{
	private String name;
	
	public Person()
	{
		name = "";
	}
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public Person(Person theObject)
	{
		name = theObject.name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean equals(Object other)
	{
		return name.equals(((Person)other).name);
	}
}