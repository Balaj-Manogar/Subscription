package org.baali.decorator;

public class Ginger extends Condiments
{
	String description = "Ginger";
	int cost = 1;
	Beverage beverage;
	public Ginger(Beverage b)
	{
		this.beverage = b;
	}
	
	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", " + this.description;
	}


	@Override
	public int cost()
	{
		// TODO Auto-generated method stub
		return beverage.cost() + this.cost;
	}

}
