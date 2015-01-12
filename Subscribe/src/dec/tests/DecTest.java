package dec.tests;

import org.baali.decorator.Beverage;
import org.baali.decorator.BlackTea;
import org.baali.decorator.Elaichi;
import org.baali.decorator.Ginger;
import org.baali.decorator.MilkTea;
import static org.junit.Assert.*;
import org.junit.Test;



public class DecTest
{
	
	@Test
	public void testGingerElaichiTeaCost()
	{
		Beverage gingerElaichiTea = new Ginger(new Elaichi(new MilkTea()) );
		Beverage blackTea = new BlackTea();
		
		int cost = gingerElaichiTea.cost();
		assertEquals(10, cost);
	}
}
