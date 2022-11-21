import java.io.*;
import java.util.*;
public class SJF1{
    public static void main(String args[])
    {
        System.out.println("Hello World...!!!");
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int at[] = new int[n];
        int bt[] = new int[n];
        int tot[] = new int[n];
        int wt[] = new int[n];
        int ct[] = new int[n];
        int pid[] = new int[n];
        int st = 0;

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter arrival time of process: ");
            at[i] = sc.nextInt();
            System.out.println("Enter burst time of process: ");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
    }
}