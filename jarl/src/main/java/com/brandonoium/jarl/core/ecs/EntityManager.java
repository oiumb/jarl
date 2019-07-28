package com.brandonoium.jarl.core.ecs;

public class EntityManager
{
	private int nextEntityId;
	
	public EntityManager()
	{
		nextEntityId = 0;
	}
	
	public EntityManager(int startIndex)
	{
		nextEntityId = startIndex;
	}
	
	
	public EcsEntity getNextEntityID()
	{
		return new EcsEntity(nextEntityId++);
	}
}
