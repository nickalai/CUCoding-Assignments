
public class PizzaOrder
{
	public static final int MAX_ORDER = 3;

	private Pizza[] pizzas;
	private int numPizzas;


	public PizzaOrder()
	{
		this.pizzas = new Pizza[PizzaOrder.MAX_ORDER];
	}

	public PizzaOrder(Pizzas[] p)
	{
		this.pizzas = new Pizza[PizzaOrder.MAX_ORDER];
		this.setPizzas(p);
	}


	public PizzaOrder(PizzaOrder p)
	{
		this.setPizzas(p.pizzas);
	}
	
	//Should give no null values to me
	public void setPizzas(Pizzas[] p) throws IllegalArgumentException
	{
		if(p == null || p.length > PizzaOrder.MAX_ORDER)
		{
			throw new IllegalArgumentException("ERROR: Invalid Pizza array given to PizzaOrder class");
		}
		this.numPizzas = p.length;
		for(int i = 0; i < p.length; ++i)	
		{
			this.pizzas[i] = new Pizza(p[i]);
		}
		for(int i = p.length; i < PizzaOrder.MAXLENGTH; ++i)
                {
                        this.pizzas[i] = null;
                }
	}

	public void setPizza(Pizza p, int n) throws IllegalArgumentException
	{
		if(p == null || n > PizzaOrder.MAX_ORDER || n < 0)
		{
			throw new IllegalArgumentException("ERROR: Invalid Pizza array given to PizzaOrder class"); 
		}
		if(n >= this.numPizzas && this.numPizzas < PizzaOrder.MAX_ORDER)
		{
			this.pizzas[this.numPizzas++] = new Pizza(p);	
		}
		else
		{
			this.pizzas[n] = new Pizza(p);
		}		
	
	}

	public int getNumPizzas()
	{
		return this.numPizzas;
	}

	public Pizza getPizza(int n)
	{
		if(n < 0 || n > PizzaOrder.MAX_ORDER)
		{
                
                	throw new IllegalArgumentException("ERROR: Invalid Pizza array given to PizzaOrder class"); 
		}
	
		if(n < this.numPizzas)
			return new Pizza(this.pizzas[n])
		
		return null;
	}


	public Pizza[] getPizzas()
	{
		Pizza[] p = new Pizza[this.numPizzas];
		for(int i = 0; i < this.numPizzas; ++ i)
		{
			p[i] = new Pizza(this.pizzas[i])
		}
		return p;
	}	

	public void removePizza(int n)
	{
		if(n > 0 && n < this.numPizzas)
		{
			this.pizzas[n] = null;
		
			for(int i = n; i < this.numPizzas; ++ i)
			{
				this.pizzas[i] = this.pizzas[i+1]; //Shift them down
			}
			this.numPizzas--;
		}
	}

	public void deleteOrder()
	{
		for(int i =0; i < this.numPizzas; ++ i)
		{
			this.pizzas[i] = null;		
		}
		this.numPizzas = 0;
	}


	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		
		if(this.getClass() != o.getClass())
			return false;

		PizzaOrder p = (PizzaOrder)o;

		boolean ret = true;

		if(this.numPizzas != p.numPizzas)
			return false;

		for(int i = 0; i < this.numPizzas)
		{
			ret = ret && this.pizzas[i].equals(p.pizzas[i]);
		}

		return ret;

	}
	


}



