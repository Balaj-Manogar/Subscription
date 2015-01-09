package org.baali.subscribe;

public class Topic
{
	private Publisher publisher;
	
	
	public Topic(Publisher publisher)
	{
		this.publisher = publisher;
	}

	public PublisherEnum add(String description, String key)
	{
		PublisherEnum status = PublisherEnum.TopicInProgress;
		Display display = new ConsoleDisplay(status.getDescription());
		display.show();
		status = publisher.addTopic(description, key);
		
		display.setMessage(status.getDescription());
		display.show();
		
		return status;
	}
	
	public PublisherEnum remove(String key)
	{
		PublisherEnum status = PublisherEnum.TopicInProgress;
		Display display = new ConsoleDisplay(status.getDescription());
		display.show();
		status = publisher.removeTopic(key);
		
		display.setMessage(status.getDescription());
		display.show();
		
		return status;
	}

}
