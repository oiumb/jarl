package com.brandonoium.jarl;
import java.util.LinkedList;

import com.brandonoium.jarl.core.ecs.Subsystem;

public class SubsystemManager
{
	private LinkedList<Subsystem> subsystemList;
	
	public SubsystemManager()
	{
		
	}
	
	public void executeSubSystems()
	{
		for(Subsystem s : subsystemList)
		{
			s.update();
		}
	}
	
	
	public void replaceSubsystemList(LinkedList<Subsystem> newList)
	{
		subsystemList = newList;
	}
}
