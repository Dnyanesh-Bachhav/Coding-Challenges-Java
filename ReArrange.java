/*
 GeeksForGeeks:
 Arranging the array
 You are given an array of size N. Rearrange the given array in-place such that all the
 negative numbers occur before positive numbers.(Maintain the order of all -ve and +ve numbers 
 as given in the original array).
 */
import java.util.*;
class ReArrange{
    public static void main(String args[])
    {
        System.out.println("Hello World...!!!");
        Scanner sc = new Scanner(System.in);
        Long arr[] = new Long[5];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextLong();
        }
        ArrayList<Long> li = new ArrayList<>();
        ArrayList<Long> li1 = new ArrayList<>();
        for(long i:arr)
        {
            if(i<0)
            {
                li.add(i);
            }
            else{
                li1.add(i);
            }
        }
        System.out.println(li.addAll(li1));
        System.out.println(li);
        for(int i=0;i<li.size();i++)
        {
            arr[i] = li.get(i);
        }
        for(long i:arr)
        System.out.println(i);

    }
}