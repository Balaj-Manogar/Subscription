package org.baali.decorator;

public class MilkTea implements Beverage
{
	
	String description = "Milk Tea";
	int cost = 6;
	
	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public int cost()
	{
		// TODO Auto-generated method stub
		return cost;
	}

}
