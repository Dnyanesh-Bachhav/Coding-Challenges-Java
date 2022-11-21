import java.util.Scanner;

public class rr
{

    public static void main(String args[])
    {
        int i,n,sq=0,count=0,temp,qt;
        float avgtt=0,avgwt=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER NO OF PROS:-");
        n=sc.nextInt();

        int bt[]=new int[n];
        int tt[]=new int[n];
        int rbt[]=new int[n];
        int wt[]=new int[n];

        for(i=0;i<n;i++)
        {
            System.out.print("ENTER THE BT OF P NO"+ (i+1));
            bt[i]=rbt[i]=sc.nextInt();
        }

        System.out.print("Enter time quantum:-");
        qt=sc.nextInt();

        while(n!=count)
        {
            
            for(i=0,count=0;i<n;i++)
            {
                temp=qt;
                if(rbt[i]==0)
                {
                    count++;
                    continue;
                }

                if(rbt[i]>qt)
                {
                    rbt[i]=rbt[i]-qt;
                }
                else
                if(rbt[i]>=0)
                {
                    temp=rbt[i];
                    rbt[i]=0;
                }

                sq=sq+temp;
                tt[i]=sq;
            }
        }

        
        System.out.print("--------------------------------------------------------------------------------");  
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");  
        System.out.print("--------------------------------------------------------------------------------");
        for(i=0;i<n;i++)
        {
            wt[i]=tt[i]-bt[i];
            avgwt=avgwt+wt[i];
            avgtt=avgtt+tt[i];
            System.out.print("\n "+(i+1)+"\t "+bt[i]+"\t\t "+tt[i]+"\t\t "+wt[i]+"\n"); 
        }  
        avgwt=avgwt/n;  
        avgtt=avgtt/n;  
        System.out.println("\nAverage waiting Time = "+avgwt+"\n");  
        System.out.println("Average turnaround time = "+avgtt);

    }
}