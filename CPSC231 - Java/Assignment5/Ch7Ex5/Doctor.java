/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Extends the SalariedEmployee class. Allows for a listing of a SalariedEmployee's specialty as a doctor(string) and how much their visit fee is(double)
*/
import java.util.GregorianCalendar;

public class Doctor extends SalariedEmployee
{
	private String specialty;
	private double visitFee;
	
	public Doctor()
	{
		specialty = "";
		visitFee = 0;
	}
	
	public Doctor(String theName, GregorianCalendar theDate, double salary, String specialty, double visitFee)
	{
		super(theName, theDate, salary);
		this.specialty = specialty;
		this.visitFee = visitFee;
	}
	
	public Doctor(Doctor other)
	{
		specialty = other.specialty;
		visitFee = other.visitFee;
	}
	
	public String getSpecialty()
	{
		return specialty;
	}
	
	public void setSpecialty(String specialty)
	{
		this.specialty = specialty;
	}
	
	public double getVisitFee()
	{
		return visitFee;
	}
	
	public void setVisitFee(double visitFee)
	{
		this.visitFee = visitFee;
	}
	
	public String toString()
	{
		return super.toString() + "\nDoctor Specialty: " + specialty + "\nVisit Fee: $" + visitFee;
	}
	
	public boolean equals(Doctor other)
	{
		return super.equals(other) && specialty.equals(other.specialty) && visitFee == other.visitFee;
	}
}
	
	
	