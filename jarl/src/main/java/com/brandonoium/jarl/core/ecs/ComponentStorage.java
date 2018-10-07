package com.brandonoium.jarl.core.ecs;


import java.util.List;
import java.util.Set;


public interface ComponentStorage
{

	/**
	 * 
	 * @param entity
	 * @param componentType
	 * @return
	 * @throws EcsException
	 */
	<T extends Component> T getComponent(int entity, Class<T> componentType)
			throws EcsException;

	<T extends Component> List<T> getComponentsOfType(Class<T> componentType);

	<T extends Component> Set<Integer> getEntitiesWithComponent(Class<T> componentType);

	<T extends Component> void addComponent(int entity, T component);
	
	<T extends Component> void removeComponent(int entity, Class<T> componentType)
			throws EcsException;
	
	void removeAllComponentsFromEntity(int entity);

}