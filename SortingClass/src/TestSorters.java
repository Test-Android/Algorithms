import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;
import java.io.*;
import java.util.concurrent.*;

public class TestSorters 
{

	public static void main(String[] args) 
	{
		ArrayList<Item> items = new ArrayList<Item>();
		for(int k = 0; k < 110; k++)
			items.add(new Item(createWord(3), ((int)(Math.random() * 300) +1)));
		Scanner in = new Scanner(System.in);
		int total = 0;
		System.out.println(total);
		Boolean cont = true;
		while(cont)
		{
			System.out.print("Enter a number: ");
			Large l = new Large(in.nextLine());
			System.out.print("Enter a second number: ");
			l.sub(new Large(in.nextLine()));
			l.getAmount("L =");
			System.out.println(Large.isLarger(l, new Large("40")));
//			System.out.print("Continue? ");
//			String asw = in.nextLine();
//			if(!asw.equals("yes"))
//				cont = false;
		} 
		ArrayList<Integer> store = new ArrayList<Integer>();
		System.out.println("Type -999 to Stop");
		while(cont)
		{
			System.out.print("Number? ");
			int temp = in.nextInt();
			if(temp != -999)
				store.add(temp);
			else
				cont = false;
		}
		mode(store);
		
	}
	public static void mode(ArrayList<Integer> i)
	{
		int[] temp = convertInt(i);
		int[] times = new int[i.size()];
		for(int k = 0; k < i.size(); k++)
		{
			for(int j = 0; j < i.size(); j++)
			{
				if(temp[j] == i.get(k))
					times[k]++;
			}
		}
		int most = 0;
		for(int k = 0; k < i.size(); k++)
		{
			if(times[k] > most)
				most = k;
		}
		System.out.println(i.get(most));
	}
	public static void getFirstLetter(ArrayList<Item> i, int size)
	{
		String letterList = "";
		int count = 0;
		for(int k = 0; k < size; k++)
		{
			letterList = letterList + i.get(k).getName() + " ";
			count++;
			if(count == 10)
			{
				System.out.println(letterList);
				letterList = "";
				count = 0;
			}
		}				
	}
	public static void getNumList(ArrayList<Item> i)
	{
		String letterList = "";
		int count = 0;
		for(int k = 0; k< i.size(); k++)
		{
			letterList = letterList + i.get(k).getAmmount() + " ";
			count++;
			if(count == 10)
			{
				System.out.println(letterList);
				letterList = "";
				count = 0;
			}
		}				
	}
	public static void fib(Large l, Large i, int counter)
	{
		if(counter >= 0)
		{
			counter--;
			Large last = i;
			Large cur = l;
			cur.add(last);
			Large fib = cur; 
			fib.getSize();
			fib(fib, cur, counter);
		}
		
	}
	public static String createWord(int letters)
	{
		String randWord = "";
		int randNum;
		for(int k = 0; k < letters; k++)
		{
			randNum = (int)(Math.random() * 26)+97;
			randWord = randWord + ((char)randNum);
		}
		return randWord;
	}
	public static int[] convertInt(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	
}