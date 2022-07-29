import java.math.BigDecimal;
import java.util.*;
class Main{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        List<BigDecimal> li = new ArrayList<>();
        
        String s1[] = s;

        //Write your code here
        for(int i=0;i<n;i++)
        {
            BigDecimal num = new BigDecimal(s[i].toString());
            li.add(num);
          //  System.out.println("Num: "+num);
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<i;j++)
        //     {
        //         if(arr[i].compareTo(arr[j]))
        //         {
        //         temp = arr[i];
        //         arr[i] = arr[j];
        //         arr[j] = temp;
        //         }
        //     }
        // }
        Collections.sort(li, Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            
            System.out.println("Num: "+li.get(i).toString());
        }
        //Output
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s1[j].equals(li.get(i).toString()))
                {
                    s[i] = s1[j];
                }
                else{
                    s[i] = "Hi";
                }
            }
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}