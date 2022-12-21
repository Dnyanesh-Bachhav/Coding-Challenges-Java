import java.util.*;
class Longest_Substring{
    public static void main(String args[])
    {
        System.out.println("Hi");
        String str1[] = {"geeksforgeeks","geeks","geek","geezer"};
        int max = 0;
        int min  = Integer.MAX_VALUE;
        String minStr="", maxStr="";
        for(String str: str1)
        {
            if(str.length()<min)
            {
                min = str.length();
                minStr = str;
            } 
            if(str.length()>max)
            {
                max = str.length();
                maxStr = str;
            }
        }
        System.out.println( maxStr + " " + minStr );
        int count = 0,max1 = 0;
        String newStr = "";
        for(int i=0;i<minStr.length();i++)
        {
            for(int j=i;j<minStr.length();j++)
            {
                String str12 = minStr.substring(i,j+1);
                if(maxStr.contains(str12))
                {
                    count = str12.length();
                    if(count>=max1)
                    {
                        max1 = count;
                        newStr = str12;
                    }
                }
            }
        }
        System.out.println("New String: "+newStr);
    }
}