/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Leetcode: 7
*/

class Reverse_Number{
    public static int reverse(int x) {
        if(x==(int)x)
        {
        boolean isPositive = true;
        String num = " ";
        if(x<0)
        {
            isPositive = false;
            x = Math.abs(x);
        }
        while(x>0)
        {
            num = num + x%10;
            x = x/10;
        }
        num = num.trim();
        try{
        x = Integer.parseInt(num);    
        }
            catch(Exception e)
            {
                return 0;
            }
        
        if(!isPositive)
        {
            return -x;
        }
        else{
            return x;
        }
        }
        else{
            return 0;
        }
    }
    
    public static void main(String args[])
    {
        System.out.println(reverse(210));
    }
}