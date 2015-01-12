package org.baali.decorator;

public class Elaichi extends Condiments
{
	String description = "Elaichi";
	int cost = 3;
	Beverage beverage;
	public Elaichi(Beverage b)
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
