/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Given code in the textbook. Allows for information to be stored on an employee's name and hire date.
*/

import java.util.GregorianCalendar;

public class Employee
{
	private String name;
	private GregorianCalendar hireDate;
	
	public Employee()
	{
		name = "No name";
		hireDate = new GregorianCalendar(1000, 1, 1);
	}
	
	public Employee(String theName, GregorianCalendar theDate)
	{
		if(theName == null || theDate == null)
		{
			System.out.println("Fatal Error in creating employee.");
			System.exit(0);
		}
		name = theName;
		hireDate = (GregorianCalendar)theDate.clone();
	}
	
	public Employee(Employee originalObject)
	{
		name = originalObject.name;
		hireDate = (GregorianCalendar)originalObject.hireDate.clone();
	}
	
	public String getName()
	{
		return name;
	}
	
	public GregorianCalendar getHireDate()
	{
		return (GregorianCalendar)hireDate.clone();
	}
	
	public void setName(String newName)
	{
		if(newName == null)
		{
			System.out.println("Fatal Error in setting employee name.");
			System.exit(0);
		}
		else
		{
			name = newName;
		}
	}
	
	public void setHireDate(GregorianCalendar newDate)
	{
		if(newDate == null)
		{
			System.out.println("Fatal Error in setting employee hire date.");
			System.exit(0);
		}
		else
		{
			hireDate = (GregorianCalendar)newDate.clone();
		}
	}
	
	public String toString()
	{
		return ("Name: " + name); //+ "\nDate Hired: " + hireDate.toString());
	}
	
	public boolean equals(Employee otherEmployee)
	{
		return (name.equals(otherEmployee.name) && hireDate.equals(otherEmployee.hireDate));
	}
}