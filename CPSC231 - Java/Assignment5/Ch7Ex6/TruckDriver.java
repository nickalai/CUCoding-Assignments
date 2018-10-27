/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 5

Tests all methods from Person, Vehicle and Truck. 
*/

public class TruckDriver
{
	public static void main(String[]args)
	{
		Person owner1 = new Person("Nick Lai");
		Person owner2 = new Person("Nick Lahaye");
		
		Vehicle car = new Vehicle("Toyota", 8, owner1);
		
		Truck truck = new Truck();
		truck.setManufacturer("Chevy");
		truck.setCylinders(100);
		truck.setOwner(owner2);
		truck.setLoad(75.2);
		truck.setCapacity(1000);
		
		System.out.println("---");
		System.out.println("Vehicle 1: ");
		System.out.println(car.toString());
		System.out.println("---");
		System.out.println("Vehicle 2: ");
		System.out.println(truck.toString());
		System.out.println("---");
	}
}