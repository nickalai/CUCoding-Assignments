/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Extends the class Person. Inherits a patient's name from Person, adds a primary physician from class Doctor.
*/

public class Patient extends Person
{
	private Doctor physician;
	
	public Patient()
	{
		super();
		physician = new Doctor();
	}
	
	public Patient(String name, Doctor doctor)
	{
		super(name);
		physician = doctor;
	}
	
	public void setDoctor(Doctor newDoctor)
	{
		physician = newDoctor;
	}
	
	public Doctor getPhysican()
	{
		return physician;
	}
	
	public String toString()
	{
		return super.toString() + "\nPhysician: " + physician.getName();
	}
	
	public boolean isEqual(Patient other)
	{
		return super.equals(other) && physician.equals(other.physician);
	}
}