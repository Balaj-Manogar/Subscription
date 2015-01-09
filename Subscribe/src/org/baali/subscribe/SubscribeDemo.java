package org.baali.subscribe;

public class SubscribeDemo
{
	public static void main(String[] args)
	{
		Publisher publisher = new KSLPublisher();
		Topic topic = new Topic(publisher);
		topic.add("The Hindu", "TH");
		topic.add("BUsinessLine", "BL");
		topic.add("Tamil", "IN");
		
		Subscriber a = new KSLSubscriber(TopicType.TheHindu, "a");
		Subscriber b = new KSLSubscriber(TopicType.BusinessLine, "b");
		Subscriber c = new KSLSubscriber(TopicType.TamilHindhu, "c");
		Subscriber d = new KSLSubscriber(TopicType.TheHindu, "d");
		
		
		publisher.subscribe(a);
		publisher.subscribe(c);
		publisher.subscribe(b);
		publisher.subscribe(d);
		
		
		publisher.publish("The Hindu Story 1", TopicType.TheHindu);
		publisher.publish("The Hindu Story 2", TopicType.TheHindu);
		publisher.publish("The BL Story 1", TopicType.BusinessLine);
		publisher.publish("The Tamil Story 1", TopicType.TamilHindhu);
		
		
		publisher.unSubscribe(d);
		
		publisher.publish("The Hindu Story 4", TopicType.TheHindu);
		
		
	}
}
