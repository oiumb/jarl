package com.brandonoium.jarl.conio;

import java.io.IOException;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.*;


/**
 * Exposes services provided by the Lanterna library.
 * @author boium
 *
 */
public class LanternaServiceProvider implements AsciiOutputProvider
{
	
	// AsciiOutputProvider Terminal
	Terminal term;
	
	@Override
	public void initServiceProvider()
	{	
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void disbandServiceProvider()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void initAsciiOutput(int width, int height)
	{
		DefaultTerminalFactory factory = new DefaultTerminalFactory();
		
		factory.setInitialTerminalSize(new TerminalSize(width, height));
		
		try
		{
			term = factory.createTerminal();
			term.setCursorVisible(false);
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public int getConsoleWidth()
	{
		try
		{
			return term.getTerminalSize().getColumns();
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int getConsoleHeight()
	{
		try
		{
			return term.getTerminalSize().getRows();
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public void putCursorAt(int x, int y)
	{
		try
		{
			term.setCursorPosition(x, y);
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void printChar(char c)
	{
		try
		{
			term.putCharacter(c);
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void flush()
	{
		try
		{
			term.flush();
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void clear()
	{
		try
		{
			term.clearScreen();
		} catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
