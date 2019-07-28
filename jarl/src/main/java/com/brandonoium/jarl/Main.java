package com.brandonoium.jarl;

import com.brandonoium.jarl.conio.AsciiDrawableComponent;
import com.brandonoium.jarl.core.ecs.EcsEntity;
import com.brandonoium.jarl.core.ecs.WorldPositionComponent;

/**
 * Hello world!
 *
 */
public class Main
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		JarlApp app = new JarlApp();
		
		// Add one entity.
		EcsEntity aFive = app.entities.getNextEntityID();
		
		WorldPositionComponent pos = new WorldPositionComponent();
		pos.x = 5;
		pos.y = 5;
		
		app.components.addComponent(aFive, pos);
		
		AsciiDrawableComponent ascii = new AsciiDrawableComponent();
		ascii.asciiChar = '5';
		
		app.components.addComponent(aFive, ascii);
		
		// Add another entity.
		EcsEntity aPipe = app.entities.getNextEntityID();
		pos = new WorldPositionComponent();
		pos.x = 7;
		pos.y = 18;
		
		app.components.addComponent(aPipe, pos);
		
		ascii = new AsciiDrawableComponent();
		ascii.asciiChar = '|';
		
		app.components.addComponent(aPipe, ascii);
		
		
		app.systemsManager.executeSubSystems();
		
		app.components.removeAllComponentsFromEntity(aFive);
		app.components.removeAllComponentsFromEntity(aPipe);
	}
}
