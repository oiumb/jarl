package com.brandonoium.jarl.core.ecs;

/**
 * The Component interface has no methods, but "implementing" it ensures that only
 * objects intended to be Components can be treated like Components.
 * <p>
 * A Component SHOULD be a raw collection of related data with NO behavior/methods.
 * Behavior belongs in Subsystems.
 *
 */
public abstract class Component
{
	
}
