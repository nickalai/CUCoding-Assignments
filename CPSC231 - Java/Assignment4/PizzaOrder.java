/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: 4

Extends the class pizza, adds up total number of pizzas for the order and gives total cost.
*/
public class PizzaOrder
{
	private int numPizzas;
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	
	public PizzaOrder()
	{
		this.numPizzas = 0;
		this.pizza1 = null;
		this.pizza2 = null;
		this.pizza3 = null;
	}
	
	//copy constructor
	public PizzaOrder(int numPizzas, Pizza pizza1, Pizza pizza2, Pizza pizza3)
	{
		setNumPizzas(numPizzas);
		setPizza1(pizza1);
		setPizza2(pizza2);
		setPizza3(pizza3);
	}
	
	//setters
	public void setNumPizzas(int numPizzas)
	{
		if(numPizzas < 1)
			this.numPizzas = 1;
		else if(numPizzas > 3)
			this.numPizzas = 3;
		else
			this.numPizzas = numPizzas;
	}
	
	public void setPizza1(Pizza pizza1)
	{
		if(numPizzas >= 1)
			this.pizza1 = pizza1;
		else
			this.pizza1 = null;
	}
	
	public void setPizza2(Pizza pizza2)
	{
		if(numPizzas >= 2)
			this.pizza2 = pizza2;
		else
			this.pizza2 = null;
	}
	
	public void setPizza3(Pizza pizza3)
	{
		if(numPizzas >= 3)
			this.pizza3 = pizza3;
		else
			this.pizza3 = null;
	}
	
	//calculates the total of all pizza prices combined
	public double calcTotal()
	{
		double total = 0.0;
		
		if(pizza1 != null)
			total += pizza1.calcCost();
		if(pizza2 != null)
			total += pizza2.calcCost();
		if(pizza3 != null)
			total += pizza3.calcCost();
		
		return total;
	}
}