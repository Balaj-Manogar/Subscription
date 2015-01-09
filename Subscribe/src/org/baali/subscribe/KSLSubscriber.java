package org.baali.subscribe;

public class KSLSubscriber implements Subscriber
{
	private String topicType;
	private String name;

	public KSLSubscriber(String type, String name)
	{
		this.topicType = type;
		this.name = name;
	}

	@Override
	public boolean update(String story)
	{
		boolean status = false;
		Display display = new ConsoleDisplay(story);
		display.show();
		status = true;
		return status;
	}

	@Override
	public String getTopicType()
	{
		// TODO Auto-generated method stub
		return this.topicType;
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return this.name;
	}

}
