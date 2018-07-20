package com.brandonoium.jarl.core.ecs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashMapComponentStorage implements ComponentStorage
{
	// All components are stored in here. For now.
	// This storage container is something that should be continuously looked at and
	// profiled as development continues.
	HashMap<Class<?>, HashMap<Integer, ? extends Component>> masterComponentStorage;
	
	
	public HashMapComponentStorage()
	{
		masterComponentStorage = new HashMap<Class<?>, HashMap<Integer, ? extends Component>>();
	}
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#getComponent(int, java.lang.Class)
	 */
	public <T extends Component> T getComponent(int entity, Class<T> componentType)
						throws EcsException
	{
		HashMap<Integer, ? extends Component> store = masterComponentStorage
				.get(componentType);
		
		if(store == null)
			throw new EcsException("No components of type " + componentType + " exist!");
		
		T component = componentType.cast(store.get(entity));
		
		if(component == null)
			throw new EcsException("Entity " + entity + " does not have associated "
									+ componentType + " component!");
		
		return component;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#getComponentsOfType(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> List<T> getComponentsOfType(Class<T> componentType)
	{
		HashMap<Integer, ? extends Component> store = masterComponentStorage
				.get(componentType);
		
		if(store == null)
			return new LinkedList<T>();
		else
			return new ArrayList<T>((java.util.Collection<T>) store.values());
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#getEntitiesWithComponent(java.lang.Class)
	 */
	public <T extends Component> Set<Integer> getEntitiesWithComponent(Class<T> componentType)
	{
		HashMap<Integer, ? extends Component> store = masterComponentStorage
				.get(componentType);
		
		if(store == null)
			return new HashSet<Integer>();
		else
			return store.keySet();
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#addComponent(int, T)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> void addComponent(int entity, T component)
	{
		HashMap<Integer, ? extends Component> store = masterComponentStorage
				.get(component.getClass());
		
		if(store == null)
		{
			store = new HashMap<Integer, T>();
			masterComponentStorage.put(component.getClass(), store);
		}
		
		((HashMap<Integer, T>)store).put(entity, component);
	}
}
