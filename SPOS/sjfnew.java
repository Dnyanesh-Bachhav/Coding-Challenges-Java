import java.util.*;
import java.io.*;

public class sjfnew
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER NO OF PROCESSES:-");
        int n=sc.nextInt();

        int at[]=new int[n];
        int bt[]=new int[n];
        int pid[]=new int[n];
        int ct[]=new int[n];
        int tt[]=new int[n];
        int wt[]=new int[n];
        int f[]=new int[n]; //flag to check if completed or not
        int st=0,tot=0;  //to keep track of current time and total processes for which calculation is done
        int tmp;
        float avgtt=0,avgwt=0;

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the arrival time for Process no " + (i+1) + " : ");
            at[i] = sc.nextInt();

            System.out.print("Enter the burst time for Process no " + (i+1) + " : ");
            bt[i] = sc.nextInt();

            pid[i]=i+1;
        }

        boolean a = true;
        while(tot!=n)  //loop until total no of process AND no of completed process becomes same
        {
            int c=n;
            int min=999;
            
            for (int i=0; i<n; i++)
            {
                /*
                * If i'th process arrival time <= system time and its flag=0 and burst<min
                * That process will be executed first
                */
                if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
                {   
                    min=bt[i];
                    c=i;
                }
            }
                /* If c==n means c value can not updated because no process arrival time< system time so we increase the system time 
                 * 
                 * i.e. no procces is arrived till current time therefore increment system time
                */
            if (c==n)
                st++;
            else
            {
                ct[c]=st+bt[c]; //completion time of p= current time + burst time of p
                st+=bt[c];      //increment current time by burst time of p (complete the process p)
                tt[c]=ct[c]-at[c];  
                wt[c]=tt[c]-bt[c];
                f[c]=1;         //mark process p as completed
                tot++;

                avgtt+=tt[c];
                avgwt+=wt[c];
            }
        }
       
        System.out.println("\nPriority Scheduling Algorithm : ");
        System.out.format("%20s%20s%20s%20s%20s%20s\n", "ProcessId", "ArrivalTime", "BurstTime","FinishTime", "WaitingTime", "TurnAroundTime");
        for (int i = 0; i < n; i++) 
        {
            System.out.format("%20s%20d%20d%20d%20d%20d\n", pid[i], at[i], bt[i], ct[i], wt[i],tt[i]);
        }

        System.out.format("\n%100s%20f\n", "Average Turnaround", (avgtt/n));
        System.out.format("\n%100s%20f\n", "Average Waiting", (avgwt/n));
     }
}
