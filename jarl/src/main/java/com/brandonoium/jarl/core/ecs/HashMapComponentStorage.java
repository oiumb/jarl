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
	HashMap<Class<?>, HashMap<EcsEntity, ? extends Component>> masterComponentStorage;
	
	
	public HashMapComponentStorage()
	{
		masterComponentStorage = new HashMap<Class<?>, HashMap<EcsEntity, ? extends Component>>();
	}
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#getComponent(int, java.lang.Class)
	 */
	public <T extends Component> T getComponent(EcsEntity entity, Class<T> componentType)
						throws EcsException
	{
		HashMap<EcsEntity, ? extends Component> store = masterComponentStorage
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
		HashMap<EcsEntity, ? extends Component> store = masterComponentStorage
				.get(componentType);
		
		if(store == null)
			return new LinkedList<T>();
		else
			return new ArrayList<T>((java.util.Collection<T>) store.values());
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#getEntitiesWithComponent(java.lang.Class)
	 */
	public <T extends Component> Set<EcsEntity> getEntitiesWithComponent(Class<T> componentType)
	{
		HashMap<EcsEntity, ? extends Component> store = masterComponentStorage
				.get(componentType);
		
		if(store == null)
			return new HashSet<EcsEntity>();
		else
			return store.keySet();
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.brandonoium.jarl.core.ecs.ComponentStorage#addComponent(int, T)
	 */
	@SuppressWarnings("unchecked")
	public <T extends Component> void addComponent(EcsEntity entity, T component)
	{
		HashMap<EcsEntity, ? extends Component> store = masterComponentStorage
				.get(component.getClass());
		
		if(store == null)
		{
			store = new HashMap<EcsEntity, T>();
			masterComponentStorage.put(component.getClass(), store);
		}
		
		((HashMap<EcsEntity, T>)store).put(entity, component);
	}


	@Override
	public <T extends Component> void removeComponent(EcsEntity entity, Class<T> componentType) throws EcsException
	{
		HashMap<EcsEntity, ? extends Component> store = masterComponentStorage
				.get(componentType);
		
		if(store == null)
			throw new EcsException("No components of type " + componentType + " exist!");
		
		store.remove(entity);
	}


	@Override
	public void removeAllComponentsFromEntity(EcsEntity entity)
	{
		for(HashMap<EcsEntity, ? extends Component> map : masterComponentStorage.values())
		{
			if(map.containsKey(entity))
			{
				map.remove(entity);
			}
		}
	}
}
