package org.baali.subscribe;

import java.util.HashMap;
import java.util.HashSet;

public interface Publisher
{
	public Subscriber subscribe(Subscriber s);
	public Subscriber unSubscribe(Subscriber s);
	public PublisherEnum publish(String story, String type);
	
	public PublisherEnum addTopic(String name, String key);
	public PublisherEnum removeTopic(String key);
}
