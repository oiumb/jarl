package com.brandonoium.jarl.conio;

import com.brandonoium.jarl.core.ServiceProvider;

/**
 * AsciiOutputProvider provides a standardized abstraction over any library that may provide console-like ASCII output. 
 * @author boium
 *
 */
public interface AsciiOutputProvider extends ServiceProvider
{
	public void initAsciiOutput(int width, int height);
	
	public int getConsoleWidth();
	public int getConsoleHeight();
	
	public void putCursorAt(int x, int y);
	
	public void printChar(char c);
}
