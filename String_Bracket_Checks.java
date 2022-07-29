import java.util.*;
/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
public static void checkStr()
    {
        Scanner sc = new Scanner(System.in);
        String str = "";
        StringBuilder str1 =new StringBuilder("");
        String openingChars = "([{";
        String closingChars = ")]}";
        // String strOpen = "";
        // String strClose = "";
        StringBuilder strOpen=new StringBuilder("");
        StringBuilder strClose=new StringBuilder("");
        int count = 0;
        while (sc.hasNext()) {
                str1 = str1 +  (sc.next()+"");
            //Complete the code
        }
        str = (String)str1;
        for (int i = 0; i < str.length(); i++) {
            if(openingChars.contains(str.charAt(i)))
            {
                strOpen = "" + str.charAt(i);
            }
            //Complete the code
        }
        for (int i = 0; i < str.length(); i++) {
            if(closingChars.contains(str.charAt(i)))
            {
                strClose = "" + str.charAt(i);
            }
            //Complete the code
        }
        char openArray[] = strOpen.toCharArray();
        char closeArray[] = strClose.toCharArray();
        if(openArray.length != closeArray.length)
        {
            System.out.println(Boolean.FALSE);
        }
        else{
            for(int i=0;i<openArray.length;i++)
            {
                if(openArray[i]=='(')
                {
                    if(closeArray[i]==')')
                    {
                        count++;
                    }
                }
                if(openArray[i]=='[')
                {
                    if(closeArray[i]==']')
                    {
                        count++;
                    }
                }
                if(openArray[i]=='{')
                {
                    if(closeArray[i]=='}')
                    {
                        count++;
                    }
                }
            }
            
        }
        if(count == openArray.length)
        {
            System.out.println(Boolean.TRUE);
        }
            

    }
	public static void main(String []args)
	{
		checkStr();
	}
}
