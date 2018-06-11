/**
 * 
 */
package com.brandonoium.jarl.core.ecs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author boium
 *
 */
public class TestEcsDataCache
{

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link com.brandonoium.jarl.core.ecs.EcsDataCache#getInstance()}.
	 */
	@Test
	public void testGetInstance()
	{
		EcsDataCache cache = null;
		assertNull(cache);
		
		cache = EcsDataCache.getInstance();
		assertNotNull(cache);
	}

	/**
	 * Test method for {@link com.brandonoium.jarl.core.ecs.EcsDataCache#isInstanced()}.
	 */
	@Test
	public void testIsInstanced()
	{
		EcsDataCache.getInstance();
		assertTrue(EcsDataCache.isInstanced());
	}

}
