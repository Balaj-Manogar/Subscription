package org.baali.subscribe;

public class ConsoleDisplay implements Display
{

	private String message;
	public ConsoleDisplay(String description)
	{
		this.message = description;
	}
	@Override
	public void show()
	{
		System.out.println(this.message);

	}
	@Override
	public void setMessage(String msg)
	{
		this.message = msg;
		
	}

}
