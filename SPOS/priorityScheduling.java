import java.util.*;


public class priorityScheduling
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENETER NO OF PROCESSES:-");
        int n=sc.nextInt();

        int at[]=new int[n];
        int bt[]=new int[n];
        int p[]=new int [n];
        int pid[]=new int[n];
        int ct[]=new int[n];
        int tt[]=new int[n];
        int wt[]=new int[n];
        int tmp;
        float avgtt=0,avgwt=0;

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the arrival time for Process no " + (i+1) + " : ");
            at[i] = sc.nextInt();

            System.out.print("Enter the burst time for Process no " + (i+1) + " : ");
            bt[i] = sc.nextInt();

            System.out.print("Enter the priority time for Process no " + (i+1) + " : ");
            p[i] = sc.nextInt();
            pid[i]=i+1;
        }

        //sorting according to arrival

        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n-i-1;j++)
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

                    tmp=p[j];
                    p[j]=p[j+1];
                    p[j+1]=tmp;

                }

                //sorting by priority if arrival is same
                if(at[j]==at[j+1])
                {
                    if(p[j]>p[j+1])
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

                        tmp=p[j];
                        p[j]=p[j+1];
                        p[j+1]=tmp;
                    }
                }

            }
        }

        //calculation of completion, waiting , turnaround time

        ct[0]=at[0]+bt[0];
        tt[0]=ct[0]-at[0];
        wt[0]=tt[0]-bt[0];

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
                
        System.out.println("\nPriority Scheduling Algorithm : ");
        System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId", "ArrivalTime", "BurstTime", "Priority", "FinishTime", "WaitingTime", "TurnAroundTime");
        for (int i = 0; i < n; i++) 
        {
            System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", pid[i], at[i], bt[i], p[i], ct[i], wt[i],tt[i]);
        }

        System.out.format("\n%100s%20f\n", "Average Turnaround", (avgtt/n));
        System.out.format("\n%100s%20f\n", "Average Waiting", (avgwt/n));
     }
}
