import java.util.ArrayList;

public class Large
{
	ArrayList<Integer> num;
	public Large(String s)
	{
		num = new ArrayList<Integer>();
		int spot = s.length() - 1;
		while(num.size() < s.length())
		{
			num.add(convertInt(s,spot));
			spot--;
		}				
	}
	public void add(Large l)
	{
		if(l.getSize() > num.size())
		{
			while(num.size() < l.getSize())
			{
				num.add(new Integer(0));
			}
			
			for(int k = 0; k < l.getSize(); k ++)
			{
//				System.out.println("k " + k + " l amount " + l.getSize());
//				System.out.println("k " + k + " num amount " + num.size());
//				System.out.println(num.size());
				int temp = num.get(k) + l.getDigit(k);
				if(Integer.toString(temp).length() == 2)
				{
					String str = Integer.toString(temp);
					if(k + 2 > num.size())
					{
						num.add(new Integer(0));
					}
					int temp2 = convertInt(str, 0) + num.get(k + 1);
					num.set(k + 1, temp2);
					num.set(k, convertInt(str, 1));	
				}
				else
					num.set(k, temp);
			}
			
		}
		else if(l.getSize() == num.size() || l.getSize() < num.size())
		{
			for(int k = 0; k < l.getSize(); k++)
			{
				int temp = num.get(k) + l.getDigit(k);
				if(Integer.toString(temp).length() == 2)
				{
					String str = Integer.toString(temp);
					if(k + 2 > num.size())
					{
						num.add(new Integer(0));
					}
					int temp2 = convertInt(str, 0) + num.get(k + 1);
					num.set(k + 1, temp2);
					num.set(k, convertInt(str, 1));	
				}
				else
					num.set(k, temp);
			}
		}
		
	}
	private void add(ArrayList<Integer> n)
	{
		if(n.size() > num.size())
		{
			while(num.size() < n.size())
			{
				num.add(new Integer(0));
			}
			
			for(int k = 0; k < n.size(); k ++)
			{
				System.out.println("k " + k + " l amount " + n.size());
				System.out.println("k " + k + " num amount " + num.size());
				System.out.println(num.size());
				int temp = num.get(k) + n.get(k);
				if(Integer.toString(temp).length() == 2)
				{
					String str = Integer.toString(temp);
					if(k + 2 > num.size())
					{
						num.add(new Integer(0));
					}
					int temp2 = convertInt(str, 0) + num.get(k + 1);
					num.set(k + 1, temp2);
					num.set(k, convertInt(str, 1));	
				}
				else
					num.set(k, temp);
			}
			
		}
		else if(num.size() == n.size() || num.size() > n.size())
		{
			for(int k = 0; k < n.size(); k++)
			{
				int temp = num.get(k) + n.get(k);
				System.out.println("Temp = " + temp);
				if(Integer.toString(temp).length() == 2)
				{
					String str = Integer.toString(temp);
					if(k + 2 > num.size())
					{
						num.add(new Integer(0));
					}
					int temp2 = convertInt(str, 0) + num.get(k + 1);
					num.set(k + 1, temp2);
					num.set(k, convertInt(str, 1));	
				}
				else
					num.set(k, temp);
			}
		}
	}
	public void sub(Large l)
	{
		if(isLarger(num,l) == 2)
		{
			num.clear();
			num.add(0);
		}
		else
		{
			if(num.size() > l.getSize())
			{
//				System.out.println("a.size > b.size");
				while(l.getSize() < num.size())
					l.addZero();
			}
			else if(num.size() < l.getSize())
			{
//				System.out.println("a.size < b.size");
				while(num.size() < l.getSize())
					num.add(new Integer(0));
			}
			if(isLarger(num,l) != 0)
			{
//				System.out.println("a < b");
	/*			for(int k = 0; k < num.size(); k++)
				{
					print(num.get(k));
				} */
				for(int k = 0; k < l.getSize(); k++)
				{
					int a = num.get(k);
					int b = l.getDigit(k);
					num.set(k, b);
					l.setDigit(k, a);
				}
	/*			for(int k = 0; k < num.size(); k++)
				{
					print(num.get(k));
				}*/
			}
			if(num.size() == l.getSize())
			{
				for(int k = 0; k < l.getSize(); k++)
				{
//					print("Before: " + l.getDigit(k));
					l.setDigit(k, 9-l.getDigit(k));
//					print("After: " + l.getDigit(k));
				}
				
				for(int k = 0; k < l.getSize(); k++)
				{
					int temp;
					if(k == 0)
						temp = num.get(k) + l.getDigit(k) +1;
					else
						temp = num.get(k) + l.getDigit(k);
					
//					print("Temp: " + temp);
					if(Integer.toString(temp).length() == 2)
					{
						String str = Integer.toString(temp);
//						print("Str: " + str);
						if(k + 2 > num.size())
						{
							num.add(new Integer(0));
						}
						int temp2 = convertInt(str, 0) + num.get(k + 1);
//						print("Temp2: " + temp2);
						num.set(k + 1, temp2);
//						print("Num k + 1: " + num.get(k + 1));
						num.set(k, convertInt(str, 1));	
//						print("Num k: " + num.get(k));
					}
					else
						num.set(k, temp);
				}
				num.remove(num.size() - 1);
				removeZeros(num);
			}	
		}
		
	}
	public void mult(Large l)
	{
		if(num.size() < l.getSize())
		{
//			System.out.println("a.size < b.size");
			for(int k = 0; k < l.getSize(); k++)
			{
				int a = num.get(k);
				int b = l.getDigit(k);
				num.set(k, b);
				l.setDigit(k, a);
			}
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int k = num.size() - 1; k >= 0;k--)
			temp.add(num.get(k));
		
		for(int k = 0; isLarger(l,k); k++)
		{
			add(temp);
		}
			
	}
	private ArrayList<Integer> scootDown(ArrayList<Integer> n)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(new Integer(0));
		for(int k = 0; k < n.size(); k++)
			temp.add(n.get(k));
		return temp;
	}
	private void removeZeros(ArrayList<Integer> n)
	{
		int count = num.size() - 1;
		while(num.get(count) == 0)
		{
			num.remove(count);
			count--;
		}
	}
	public void setAmount(Large l)
	{
		num.clear();
		for(int k = 0; k < l.getSize(); k++)
			num.add(l.getDigit(k));
	}
	public void getAmount()
	{
		String number = "";
		for(int k = num.size() - 1;k >= 0 ; k--)
		{
			number = number + (num.get(k).toString());
		}
		System.out.println(number);
	}
	public void getAmount(String prefix)
	{
		String number = prefix + " ";
		for(int k = num.size() - 1;k >= 0 ; k--)
		{
			number = number + (num.get(k).toString());
		}
		System.out.println(number);
	}
	private void addZero()
	{
		num.add(new Integer(0));
	}
	public int getSize()
	{
		return num.size();
	}
	private int getDigit(int k)
	{
		return num.get(k);
	}
	private void setDigit(int spot, int k)
	{
		num.set(spot, k);
	}
	public static Boolean isLarger(Large one, Large two)
	{
		if(one.getSize() < two.getSize())
			return false;
		else if(one.getSize() > two.getSize())
			return true;
		else
		{
			for(int k = one.getSize() - 1; k >= 0; k--)
			{
				if(one.getDigit(k) < two.getDigit(k))
					return false;
				else
					return true;
			}
			return false;
		}
	}
	public static Boolean isLarger(Large one, int k)
	{
		String str = Integer.toString(k);
		if(one.getSize() < str.length())
			return false;
		else if(one.getSize() > str.length())
			return true;
		else
		{
			for(int a = one.getSize() - 1; k >= 0; k--)
			{
				if(one.getDigit(a) < Integer.parseInt(Character.toString(str.charAt(a))))
					return false;
				else
					return true;
			}
			return false;
		}
	}
	public static int isLarger(ArrayList<Integer> one, Large two)
	{
		if(one.size() < two.getSize())
			return -1;
		else if(one.size() > two.getSize())
			return 0;
		else
		{
			for(int k = one.size() - 1; k >= 0; k--)
			{
				if(one.get(k) < two.getDigit(k))
					return -1;
				else
					return 0;
			}
			return 2;
		}
			
	}
	public int convertInt(String s, int i)
	{
		int k = Integer.parseInt(Character.toString(s.charAt(i)));
		return k;
	}
	public void print(Object o)
	{
		System.out.println(o);
	}
}
	
	