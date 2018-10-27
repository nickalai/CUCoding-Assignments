/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Tests methods in Doctor
*/

import java.util.GregorianCalendar;

public class DoctorDriver
{
	public static void main(String[]args)
	{
		Doctor d1 = new Doctor("Nick Lai", new GregorianCalendar(2017, 10, 2), 75000, "Pediatrician", 85);
		Doctor d2 = new Doctor("Peter Lai", new GregorianCalendar(1980, 5, 13), 100000, "General Practitioner", 50);
		
		System.out.println("---");
		System.out.println(d1.toString());
		System.out.println("---");
		System.out.println(d2.toString());
		System.out.println("---");
	}
}