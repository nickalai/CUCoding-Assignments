/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 4

Stores information about a pizza and returns the cost via toString.
*/
public class Pizza
{
	private String pizzaSize;
	private int cheeseToppings;
	private int pepperoniToppings;
	private int hamToppings;
	
	
	public Pizza()
	{
		this.pizzaSize = "";
		this.cheeseToppings = 0;
		this.pepperoniToppings = 0;
		this.hamToppings = 0;
	}
	
	//copy constructor
	public Pizza(String pizzaSize, int cheeseToppings, int pepperoniToppings, int hamToppings)
	{
		this.pizzaSize = pizzaSize;
		this.cheeseToppings = cheeseToppings;
		this.pepperoniToppings = pepperoniToppings;
		this.hamToppings = hamToppings;
	}
	
	//getters and setters for variables
	public String getPizzaSize()
	{
		return pizzaSize;
	}
	
	public void setPizzaSize(String pizzaSize)
	{
		this.pizzaSize = pizzaSize;
	}
	
	public int getCheeseToppings()
	{
		return cheeseToppings;
	}
	
	public void setCheeseToppings(int cheeseToppings)
	{
		this.cheeseToppings = cheeseToppings;
	}
	
	public int getPepperoniToppings()
	{
		return pepperoniToppings;
	}
	
	public void setPepperoniToppings(int pepperoniToppings)
	{
		this.pepperoniToppings = pepperoniToppings;
	}
	
	public int getHamToppings()
	{
		return hamToppings;
	}
	
	public void setHamToppings(int hamToppings)
	{
		this.hamToppings = hamToppings;
	}
	
	//method takes in the size of the pizza (either small, medium or large) and outputs the price including the amount of toppings.
	public double calcCost()
	{
		if(pizzaSize.equalsIgnoreCase("small"))
		{
			return 10 + (cheeseToppings + pepperoniToppings + hamToppings) * 2;
		}
		else if(pizzaSize.equalsIgnoreCase("medium"))
		{
			return 12 + (cheeseToppings + pepperoniToppings + hamToppings) * 2;
		}
		else if(pizzaSize.equalsIgnoreCase("large"))
		{
			return 14 + (cheeseToppings + pepperoniToppings + hamToppings) * 2;
		}
		else
		{
			return 0.0;
		}
	}
	
	//toString to output the information.
	public String toString()
	{
		return("Pizza size: " + pizzaSize + "\n Cheese toppings: " + cheeseToppings + "\n Pepperoni toppings: " + pepperoniToppings + "\n Ham toppings: " + hamToppings + "\n Pizza cost: $" + calcCost() + "\n");
	}
}
		