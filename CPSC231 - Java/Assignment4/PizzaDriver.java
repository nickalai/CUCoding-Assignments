/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 4

Initializes pizza, inputs a pizza size and the amount of toppings. Also prints out total price for pizzas ordered.
*/
public class PizzaDriver
{
	public static void main(String[]args)
	{
		//creates new instances of Pizza
		Pizza empty = new Pizza();
		Pizza pizza1 = new Pizza("large", 1, 0, 1);
		Pizza pizza2 = new Pizza("medium", 2, 2, 0);
		
		//creates a new instance of PizzaOrder
		PizzaOrder order = new PizzaOrder();
		order.setNumPizzas(2);
		order.setPizza1(pizza1);
		order.setPizza2(pizza2);
		//calculates the total of the order
		double total = order.calcTotal();
		
		//prints out the results
		System.out.println(pizza1.toString());
		System.out.println(pizza2.toString());
		System.out.println("Total cost of pizzas: $" + total);
	}
}