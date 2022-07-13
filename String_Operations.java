import java.io.*;
import java.util.*;

public class String_Operations {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String[] charArray = {",",".","[","]","{","}","(",")","?"};
        String str1 = "He is a very very good boy, isn't he?";
        String str2[] = str1.split(" ");
        String str3[] = new String[str1.length()];
        String A=sc.next();
        String B=sc.next();
        String str = (A.compareTo(B) > 0)?"Yes":"No";
        /* Enter your code here. Print output to STDOUT. */
        System.out.println((A+B).length());
        System.out.println(str);
        System.out.println(A.substring(0,1).toUpperCase()+ A.substring(1).toLowerCase()+" "+B.substring(0,1).toUpperCase()+ B.substring(1).toLowerCase());
        for(String s: str2)
        {
            if(s.contains("'"))
            {
               str3 = s.split("'");
               for(String s1: str3)
               {
                System.out.println(s1);
               }
            }
            else{
            for(String ch:charArray)
            {
                if(s.contains(ch))
                {
                   s = s.replace(ch,"");
                }
            }
                System.out.println(s);
            }
        }
    }
}