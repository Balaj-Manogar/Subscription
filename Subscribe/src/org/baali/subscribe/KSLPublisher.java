package org.baali.subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSLPublisher implements Publisher
{
	private ArrayList<HashMap<String, ArrayList<Subscriber>>> subscribers;
	private Map<String, String> topics = new HashMap();

	public KSLPublisher()
	{
		subscribers = new ArrayList<>();
	}

	@Override
	public Subscriber unSubscribe(Subscriber s)
	{
		Subscriber subscriber = null;
		String key = s.getTopicType();
		Display display;
		if (topics.containsKey(s.getTopicType()))
		{
			for (HashMap<String, ArrayList<Subscriber>> sub : subscribers)
			{
				if (sub.containsKey(key))
				{
					sub.get(key).remove(s);
					subscriber = s;
					display = new ConsoleDisplay(s.getName() + 
							", You Successfully unsubscribed");
					display.show();
					break;
				}
			}
		}
		else
		{
			display = new ConsoleDisplay("No topics found to unsubscribe");
			display.show();
		}
		return subscriber;
	}

	@Override
	public Subscriber subscribe(Subscriber s)
	{
		Subscriber newSubscriber = null;
		String key = s.getTopicType();
		Display display;
		if (topics.containsKey(s.getTopicType()))
		{
			for (HashMap<String, ArrayList<Subscriber>> sub : subscribers)
			{
				
				if (sub.containsKey(key) && !(sub.get(key).contains(s)))
				{
					sub.get(key).add(s);
					newSubscriber = s;
					display = new ConsoleDisplay(s.getName() + 
							", Thank you for your Subscription");
					display.show();
					break;
				}
				else if(sub.containsKey(key) && (sub.get(key).contains(s)))
				{
					display = new ConsoleDisplay("Already Subscribed");
					display.show();
				}
			}
		}
		else
		{
			display = new ConsoleDisplay("No topics found to subscribe");
			display.show();
		}
		return newSubscriber;
	}

	@Override
	public PublisherEnum publish(String story, String type)
	{
		// TODO Auto-generated method stub
		PublisherEnum status = PublisherEnum.PublishInProgress;
		for (HashMap<String, ArrayList<Subscriber>> s : subscribers)
		{
			if (s.containsKey(type))
			{
				List subs = s.get(type);
				notify(subs, story);
			}
		}

		return status;
	}

	PublisherEnum notify(List<Subscriber> subscribers, String story)
	{
		// TODO Auto-generated method stub
		PublisherEnum status = PublisherEnum.PublishInProgress;
		for (Subscriber s : subscribers)
		{
			boolean updateStatus = s.update(story);
			if (updateStatus)
			{
				status = PublisherEnum.PublishSuccess;
			}
			else
			{
				status = PublisherEnum.PublishFailed;
			}
		}

		return status;
	}

	@Override
	public PublisherEnum addTopic(String name, String key)
	{
		PublisherEnum status = PublisherEnum.TopicInProgress;
		if (!topics.containsKey(key))
		{
			topics.put(key, name);
			HashMap<String, ArrayList<Subscriber>> newTopic = new HashMap<>();
			newTopic.put(key, new ArrayList<Subscriber>());
			subscribers.add(newTopic);
			status = PublisherEnum.TopicAdded;
		}
		else
		{
			status = PublisherEnum.TopicAlreadyAdded;
		}
		return status;
	}

	@Override
	public PublisherEnum removeTopic(String key)
	{
		PublisherEnum status = PublisherEnum.TopicInProgress;
		if (topics.containsKey(key))
		{
			topics.remove(key);
			for (HashMap<String, ArrayList<Subscriber>> sub : subscribers)
			{
				if (sub.containsKey(key))
				{
					subscribers.remove(sub);
					status = PublisherEnum.TopicRemoved;
					break;
				}
			}
			
		}
		else
		{
			status = PublisherEnum.TopicRemoveFailed;
		}
		return status;
	}

}
