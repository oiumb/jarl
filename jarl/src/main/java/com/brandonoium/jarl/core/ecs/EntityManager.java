package com.brandonoium.jarl.core.ecs;

public class EntityManager
{
	private int nextEntity;
	
	public EntityManager()
	{
		nextEntity = 0;
	}
	
	public EntityManager(int startIndex)
	{
		nextEntity = startIndex;
	}
	
	
	public int getNextEntityID()
	{
		return nextEntity++;
	}
}
