package com.brandonoium.jarl;

import com.brandonoium.jarl.conio.AsciiDrawableComponent;
import com.brandonoium.jarl.core.ecs.WorldPositionComponent;

/**
 * Hello world!
 *
 */
public class App
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		JarlApp app = new JarlApp();
		
		// Add one entity.
		WorldPositionComponent pos = new WorldPositionComponent();
		pos.x = 5;
		pos.y = 5;
		
		app.components.addComponent(0, pos);
		
		AsciiDrawableComponent ascii = new AsciiDrawableComponent();
		ascii.asciiChar = '5';
		
		app.components.addComponent(0, ascii);
		
		// Add another entity.
		pos = new WorldPositionComponent();
		pos.x = 7;
		pos.y = 18;
		
		app.components.addComponent(1, pos);
		
		ascii = new AsciiDrawableComponent();
		ascii.asciiChar = '|';
		
		app.components.addComponent(1, ascii);
		
		
		app.systemsManager.executeSubSystems();
		
		app.components.removeAllComponentsFromEntity(0);
	}
}
