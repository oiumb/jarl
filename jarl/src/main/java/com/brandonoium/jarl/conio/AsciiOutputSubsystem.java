package com.brandonoium.jarl.conio;

import java.util.Set;

import com.brandonoium.jarl.core.ecs.ComponentStorage;
import com.brandonoium.jarl.core.ecs.EcsEntity;
import com.brandonoium.jarl.core.ecs.EcsException;
import com.brandonoium.jarl.core.ecs.Subsystem;
import com.brandonoium.jarl.core.ecs.WorldPositionComponent;


/**
 * 
 * @author Brandon
 */
public class AsciiOutputSubsystem implements Subsystem
{
	private AsciiOutputProvider consoleOut;
	private ComponentStorage storage;
	
	
	// TODO: Remove these.
	private int windowXPosition = 0, windowYPosition = 0;
	private int windowWidth, windowHeight;
	
	
	public AsciiOutputSubsystem(AsciiOutputProvider provider, ComponentStorage componentLib)
	{
		consoleOut = provider;
		storage = componentLib;
	}
	
	public void update()
	{
		windowWidth = consoleOut.getConsoleWidth();
		windowHeight = consoleOut.getConsoleHeight();
		
		Set<EcsEntity> drawableEntities = storage.getEntitiesWithComponent(AsciiDrawableComponent.class);
		
		if(drawableEntities.isEmpty())
			return;
		
		for(EcsEntity entity : drawableEntities)
		{
			WorldPositionComponent entityPosition;
			AsciiDrawableComponent entityDrawable;
			
			try
			{
				entityPosition = storage.getComponent(entity, WorldPositionComponent.class);
				entityDrawable = storage.getComponent(entity, AsciiDrawableComponent.class);
			} catch(EcsException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
			if(entityPosition.x >= windowXPosition && entityPosition.x < windowXPosition + windowWidth)
			{
				if(entityPosition.y >= windowYPosition && entityPosition.y < windowYPosition + windowHeight)
				{
					consoleOut.putCursorAt(entityPosition.x - windowXPosition, entityPosition.y - windowYPosition);
					consoleOut.printChar(entityDrawable.asciiChar);
				}
			}
		}
	}
}
