/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/

// Leetcode Challenge-35


class Search_Insert_Position{
    public static int Search_Insert(int[] nums,int target){
        boolean isPresent = false;
        int index=0;
        // If element is present...
        for(int i=0;i<nums.length;i++)
        {
            if(target == nums[i])
            {
                index = i;
                isPresent = true;   
            }
        }
        if(isPresent)
        {
         return index;

        }
        // If element is not present...
        else{
            for(int i=0;i<nums.length;i++)
            {
                if(target < nums[i])
                {
                    index = i;
                    break;  
                }
            }
            if(target>nums[nums.length-1])
            {
                return nums.length;
            }
            return index;
        }
    }
    public static void main(String args[])
    {
        int arr[] = {10,20,30,40,50};
        System.out.println(Search_Insert(arr,54));
        System.out.println("Hello World..!!!");
    }
}