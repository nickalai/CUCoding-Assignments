/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Creates 2 doctors and 2 patients. Prints out a record including a patient's name, their physician's name, and the visit fee. Then, returns the cost of both patient's visits combined.
*/

import java.util.GregorianCalendar;

public class PersonDriver
{
	public static void main(String[]args)
	{
		Doctor d1 = new Doctor("Nick Lai", new GregorianCalendar(2017, 10, 2), 75000, "Physician", 85);
		Doctor d2 = new Doctor("Peter Lai", new GregorianCalendar(1980, 5, 13), 175000, "Physician", 50);
		
		Patient p1 = new Patient("Weber Cheng", d1);
		Patient p2 = new Patient("Jeff Newmaker", d2);
		
		Billing b1 = new Billing(p1, d1, d1.getVisitFee());
		Billing b2 = new Billing(p2, d2, d2.getVisitFee());
		
		System.out.println("---");
		System.out.println("Record #1: ");
		System.out.println(b1);
		System.out.println("---");
		System.out.println("Record #2: ");
		System.out.println(b2);
		System.out.println("---");
		System.out.println("Total due from both patients: $" + (b1.getAmount() + b2.getAmount()));
	}
}