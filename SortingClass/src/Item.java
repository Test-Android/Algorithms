import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.*;

//version 1.12.19.1
public class Item 
{
	String itemName;
	int amountOfItem;
	int warnLow;
	boolean isSelected = false;
	boolean isWhite = false;
	
	public Item(String name, int ammount, int low)
	{
		itemName = name;
		amountOfItem = ammount;
		warnLow = low;
	}
   
   public Item(String name, int ammount)
	{
		itemName = name;
		amountOfItem = ammount;
		warnLow = 0;
	}
   
   public Item(String name)
	{
		itemName = name;
		amountOfItem = 0;
		warnLow = 0;
	}
	
	public Item()
	{
		itemName = "";
		amountOfItem = 0;
		warnLow = 0;
   }
	
	public String getName()
	{
		return itemName;
	}
	
	public int getAmmount()
	{
		return amountOfItem;
	}
	
	public void setName(String name)
	{
		itemName = name;
	}
	
	public void setAmmount(int newAmmount)
	{
		amountOfItem = newAmmount;
	}
   
   public int getLow()
	{
		return warnLow;
	}
	
	public void setLow(int low)
	{
		warnLow = low;
	}
	public boolean getSelected()
	{
		return isSelected;
	}
	public void setSelected(boolean stuff)
	{
		isSelected = stuff;
	}
	public boolean getWhite()
	{
		return isWhite;
	}
	public void setWhite(boolean stuff)
	{
		isWhite = stuff;
	}

	

	
   
}
