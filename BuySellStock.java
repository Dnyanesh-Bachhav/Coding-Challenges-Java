/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
    public static int maxProfit(int[] prices) {
        int min = prices[0],max=0;
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> diffArr = new ArrayList<>();
        for(int i:prices)
        {
            li.add(i);
        }
        // System.out.println(li);
        // for(int i=0;i<prices.length;i++)
        // {
        //     if(i!=(prices.length-1))
        //     {
        //         if(prices[i]>max && prices[i]>0)
        //         {
        //             max = prices[i];
        //         }
        //     }
            
        // }
        // System.out.println("Max: "+max);
        // System.out.println("Index: "+li.indexOf(max));
        // for(int i=li.indexOf(min);i<prices.length;i++)
        // {
            
        //         if(prices[i]>min)
        //         {
        //             diffArr.add(prices[i]-min);
        //         }
            
        // }
        // for(int ele:diffArr)
        // {
        //     if(ele>max)
        //     {
        //         max=ele;
        //     }
        // }
        // System.out.println("Difference array: "+diffArr);
        // System.out.println("Max difference: "+max);
        for(int i=1;i<prices.length;i++)  // present
        {
            if(prices[i]>max)
            {
                max=prices[i];
            }
        }
        for(int ele:prices)
        {
            if(ele<min)
            {
                min=ele;
            }
        }
        diffArr.add(min);
        diffArr.add(max);
        if(diffArr.indexOf(min)<diffArr.indexOf(max))
        {
            System.out.println("In if"+(max-min)+"     "+diffArr.indexOf(min)+" "+diffArr.indexOf(max));
            return max-min;
        }
        diffArr.clear();
        max = 0;
        System.out.println("Min: "+min+" "+"max: "+max);
        for(int i=0;i<prices.length;i++)  // present
        {
            for(int j=i+1;j<prices.length;j++) // future
            {
                System.out.println(prices[i]+" "+prices[j]);
                if(prices[j]>prices[i])
                {
                    diffArr.add(prices[j]-prices[i]);
                }
            }
        }
        for(int ele:diffArr)
        {
            if(ele>max)
            {
                max=ele;
            }
        }
        System.out.println(diffArr);
        return max;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
	}
}