
/**
 * Created by Jetts on 3/28/2015.
 */
import java.util.ArrayList;

public class Sorty
{
    public static void sortString(ArrayList<String> s, int size)
    {/*
        String[] sort = new String[size];
        for(int k = 0; k < size; k++)
        {
            sort[k] = s.get(k);
        }*/
    	int shortestString = 0;
        long start = System.nanoTime();
        for (int k = 0; k < size - 1; k++)
        {
            shortestString = k;

            for (int j=k+1 ; k< size; k++)
            {
                if (s.get(shortestString).trim().compareTo(s.get(j).trim()) < 0)
                {
                	shortestString = k;
                }
            }
            if (shortestString != k)
            {
            	String temp = s.get(k);
                s.add(k,s.get(shortestString));
                s.add(shortestString, temp);
            }
        }

        long stop = System.nanoTime();
        System.out.println((stop - start));

/*        s.clear();
        for(int k = 0; k < size; k++)
        {
            s.add(sort[k]);
        }*/
    }
    public static int compare(String one, String two)
    {
    	int smallArray = 0;
    	if(one.length() < two.length() || one.length() == two.length())
	    	smallArray = one.length();
    	else
    		smallArray = two.length();
    	if(!one.equals(two))
    	{
    		for (int k = 0; k < smallArray; k++)
    		{
    			if(one.charAt(k) < two.charAt(k))
    				return -1;
    			else if(two.charAt(k) < one.charAt(k))
    				return 0;
    		}
    	}
    	return 0;
    			
    	
    }
    public static ArrayList<Integer> quickSort(int[] sort, int start, int end)
    {
        long beginning = System.nanoTime();
        if(end - start >= 1)
        {
            int p = sort[start];
            int q = sort[end];
            if(p > q)
            {
                int temp = p;
                p = q;
                q = temp;
            }
            int l = start + 1;
            int g = end -1;
            int k = l;
            while(k <= g)
            {
                if(sort[k]< p)
                {
                    swap(sort, k, l);
                    l++;
                }
                else if(sort[k]>=q)
                {
                    while(sort[g] > q && k <g)
                        g--;

                    swap(sort, k, g);
                    g--;
                    if(sort[k]<p)
                    {
                        swap(sort, k, l);
                        l++;
                    }
                }
                k++;
            }
            l--;
            g++;
            swap(sort,start,l);
            swap(sort,end,g);
            quickSort(sort,start, l -1);
            quickSort(sort,l+1,g-1);
            quickSort(sort,g+1,end);
        }

        long ending = System.nanoTime();
        System.out.println(beginning - ending);
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int a = 0; a < end; a++)
        {
            s.add(sort[a]);
        }
        return s;
    }
    public static void swap(int array[], int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static ArrayList<Integer> selectionSort(int[] sort, int start, int end)
    {
        for (int k = sort.length - 1; k >= 1; k--)
        {
            int  currentMax = sort[0];
            int currentMaxIndex = 0;

            for (int j = 1; j <= k; j++)
            {
                if (currentMax < sort[j])
                {
                    currentMax = sort[j];
                    currentMaxIndex = j;
                }
            }
            if (currentMaxIndex != k)
            {
                sort[currentMaxIndex] = sort[k];
                sort[k] = currentMax;
            }
        }

        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int k = 0; k < end; k++)
        {
            s.add(sort[k]);
        }
        return s;
    }
    public static void printall(ArrayList<String> s)
    {
        int wordCount = 0;
        String combined = "";
        for(int k = 0; k < s.size(); k++)
        {
            combined = combined + " "+ s.get(k);
            wordCount++;
            if(wordCount == 10)
            {
                System.out.println(combined);
                combined = "";
                wordCount = 0;
            }
        }
        System.out.println();
    }

    public static void printall(ArrayList<Integer> s, int a)
    {
        String combined = "";
        int wordCount = 0;
        for(int k = 0; k < s.size(); k++)
        {
            combined = combined + " "+ s.get(k);
            wordCount++;
            if(wordCount == 10)
            {
                System.out.println(combined);
                combined = "";
                wordCount = 0;
            }
        }
        System.out.println();
    }
    private static int N;
    public static void sort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
        System.out.println("Done");
        for(int k =0; k < 10; k++)
        	System.out.println(arr[k]);
    }     
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }  
		


}
