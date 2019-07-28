package com.brandonoium.jarl;

import java.util.LinkedList;

import com.brandonoium.jarl.conio.AsciiOutputSubsystem;
import com.brandonoium.jarl.conio.LanternaServiceProvider;
import com.brandonoium.jarl.core.ecs.ComponentStorage;
import com.brandonoium.jarl.core.ecs.ComponentStorageFactory;
import com.brandonoium.jarl.core.ecs.EntityManager;
import com.brandonoium.jarl.core.ecs.Subsystem;

public class JarlApp
{
	public SubsystemManager systemsManager;
	public ComponentStorage components;
	public EntityManager entities;
	
	private LanternaServiceProvider lanterna;
	
	private LinkedList<Subsystem> systemsList;
	
	public JarlApp()
	{
		systemsManager = new SubsystemManager();
		
		initServiceProviders();
		
		initECS();
		
		initSubsystems();
	}
	
	private void initServiceProviders()
	{
		lanterna = new LanternaServiceProvider();
		lanterna.initServiceProvider();
		lanterna.initAsciiOutput(80, 30);
	}
	
	private void initECS()
	{
		ComponentStorageFactory csFactory = new ComponentStorageFactory();
		
		components = csFactory.makeComponentStorage();
		
		entities = new EntityManager();
	}
	
	private void initSubsystems()
	{
		systemsList = new LinkedList<Subsystem>();
		
		systemsList.add(new AsciiOutputSubsystem(lanterna, components));
		
		
		systemsManager.replaceSubsystemList(systemsList);
	}
}
