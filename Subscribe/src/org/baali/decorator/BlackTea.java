package org.baali.decorator;

public class BlackTea implements Beverage
{
	
	String description = "Black Tea";
	int cost = 4;
	
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
