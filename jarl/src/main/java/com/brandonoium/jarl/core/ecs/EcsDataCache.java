package com.brandonoium.jarl.core.ecs;


public class EcsDataCache
{
	private static EcsDataCache instance = null;

	private EcsDataCache()
	{
	}

	public static EcsDataCache getInstance()
	{
		if (instance == null)
			instance = new EcsDataCache();

		return instance;
	}

	public static boolean isInstanced()
	{
		return (instance != null);
	}
}
