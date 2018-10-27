/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Code given within the textbook. Extends the Employee class. Adds salary to the information stored on an employee instance. Has a method to show monthly salary based on annual salary.
*/

import java.util.GregorianCalendar;

public class SalariedEmployee extends Employee
{
	//annual
	private double salary;
	
	public SalariedEmployee()
	{
		super();
		salary = 0;
	}
	
	public SalariedEmployee(String theName, GregorianCalendar theDate, double theSalary)
	{
		super(theName, theDate);
		if(theSalary >= 0)
		{
			salary = theSalary;
		}
		else
		{
			System.out.println("Fatal Error: Negative Salary.");
			System.exit(0);
		}
	}
	
	public SalariedEmployee(SalariedEmployee originalObject)
	{
		super(originalObject);
		salary = originalObject.salary;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	//returns pay for the next month
	public double getPay()
	{
		return salary/12;
	}
	
	public void setSalary(double newSalary)
	{
		if(newSalary >= 0)
		{
			salary = newSalary;
		}
		else
		{
			System.out.println("Fatal Error: Negative salary.");
			System.exit(0);
		}
	}
	
	public String toString()
	{
		return (super.toString() + "\nAnnual Salary: $" + salary + " per year.\nMonthly Salary: $" + getPay() + " per month.");
	}
	
	public boolean equals(SalariedEmployee other)
	{
		return (getName().equals(other.getName()) && getHireDate().equals(other.getHireDate()) && salary == other.salary);
	}
}