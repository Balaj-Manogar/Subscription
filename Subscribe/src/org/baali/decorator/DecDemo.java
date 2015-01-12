package org.baali.decorator;

import org.baali.subscribe.ConsoleDisplay;
import org.baali.subscribe.Display;

public class DecDemo
{

	public static void main(String[] args)
	{
		Beverage gingerElaichiTea = new Ginger(new Elaichi(new MilkTea()) );
		Beverage blackTea = new BlackTea();
		
		int cost = gingerElaichiTea.cost();
		
		Display display = new ConsoleDisplay("Description: " + gingerElaichiTea.getDescription() );
		display.show();
		
		display.setMessage("Cost: " + String.valueOf(cost));
		display.show();
		
		display.setMessage("Description: " + blackTea.getDescription());
		display.show();

		cost = blackTea.cost();
		display.setMessage("Cost: " + String.valueOf(cost));
		display.show();
	}

}
