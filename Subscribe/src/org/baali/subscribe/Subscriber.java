package org.baali.subscribe;

public interface Subscriber
{
	public boolean update(String story);
	public String getTopicType();
	public String getName();
}
