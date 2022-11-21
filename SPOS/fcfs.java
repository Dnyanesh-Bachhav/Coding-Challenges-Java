import java.util.*;
import java.io.*;

public class fcfs 
{
    public static void main(String args[]) 
    {
        System.out.println("\n================\nENTER NO OF PROCESSES:-");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int tt[]=new int[n];
        int wt[]=new int[n];
        int tmp;
        float avgwt=0,avgtt=0;

        for(int i=0;i<n;i++)
        {
            System.out.println("enter process " + (i+1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("enter process " + (i+1) + " burst time: ");
            bt[i] = sc.nextInt();
            pid[i]=i+1;
        }


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-(i+1);j++)
            {   
                if(at[j]>at[j+1])
                {
                    tmp=at[j];
                    at[j]=at[j+1];
                    at[j+1]=tmp;
                    
                    tmp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=tmp;
                    
                    tmp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=tmp;
                }
            }
        }
        

        for(int i=0;i<n;i++)
        {
            if(i==0 )
            {
                ct[i]=at[i]+bt[i];
            }
            else
            {
                if(at[i]>ct[i-1])
                {
                    ct[i]=at[i]+bt[i];  
                }
                else
                {
                     ct[i]=ct[i-1]+bt[i];
                }
            }

            tt[i]=ct[i]-at[i];
            wt[i]=tt[i]-bt[i];
            avgtt+=tt[i];
            avgwt+=wt[i];


        }
       System.out.println("\npid  arrival  brust  complete turn waiting");
       for(int  i = 0 ; i< n;  i++)
        {
        System.out.println(pid[i] + "  \t " + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tt[i] + "\t"  + wt[i] ) ;
        }
        sc.close();
        System.out.println("\naverage waiting time: "+ (avgwt/n));     // printing average waiting time.
        System.out.println("average turnaround time:"+(avgtt/n));    // printing average turnaround time.
     }


}
