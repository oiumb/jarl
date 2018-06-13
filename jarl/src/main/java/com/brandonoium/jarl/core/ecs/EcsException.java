package com.brandonoium.jarl.core.ecs;

@SuppressWarnings("serial")
public class EcsException extends Exception
{
	public EcsException()
	{
		super();
	}
	
	public EcsException(String errString)
	{
		super(errString);
	}
}
