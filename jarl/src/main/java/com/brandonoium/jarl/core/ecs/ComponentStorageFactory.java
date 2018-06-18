package com.brandonoium.jarl.core.ecs;

public class ComponentStorageFactory
{
	public ComponentStorage makeComponentStorage()
	{
		return new HashMapComponentStorage();
	}
}
