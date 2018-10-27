/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Contains a Patient, a Doctor object, and an amount due(double).
*/
public class Billing
{
	private Patient patient;
	private Doctor physician;
	private double amount;
	
	public Billing()
	{
		patient = new Patient();
		physician = new Doctor();
		amount = 0;
	}
	
	public Billing(Patient patient, Doctor physician, double amount)
	{
		this.patient = patient;
		this.physician = physician;
		this.amount = amount;
	}
	
	public Patient getPatient()
	{
		return patient;
	}
	
	public void setPatient(Patient patient)
	{
		this.patient = patient;
	}
	
	public Doctor getPhysician()
	{
		return physician;
	}
	
	public void setPhysician(Doctor physician)
	{
		this.physician = physician;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public String toString()
	{
		return "Patient: " + patient.toString() + "\nVisit Fee: $" + amount;
	}
	
	public boolean isEqual(Billing other)
	{
		return patient.equals(other.patient) && physician.equals(other.physician) && amount == other.amount;
	}
}
	