package org.baali.subscribe;

public enum PublisherEnum
{
	TopicAdded("Topic Added"),
	TopicRemoved("Topic Removed"),
	TopicInProgress("Topic is going to add"),
	TopicAlreadyAdded("This topic already added"), 
	TopicRemoveFailed("Removing topic failed"), 
	PublishInProgress("Publishing Progress"),
	PublishSuccess("Published Successfully"),
	PublishFailed("Publishing failed"), PublishedPartially("Published Partially");
	
	String description;
	
	private PublisherEnum(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}
	
	
}
