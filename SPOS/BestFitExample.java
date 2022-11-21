import java.util.*;
class BestFitExample
{
	void insert(int blockAvailableSize[],int bSize)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Process Size  ");
		int processSize=sc.nextInt();
		int diff=0;
		int minDiff=999;
		int index=0;
		for(int i=0;i<bSize;i++)
		{
			if(blockAvailableSize[i]>=processSize)
				diff=blockAvailableSize[i]-processSize;

			if(minDiff>diff)
			{
				minDiff=diff;
				index=i;
			}
		}
		blockAvailableSize[index]=blockAvailableSize[index]-processSize;

		System.out.println("Process Allocated in Memory Segment "+(index+1));

		System.out.println("After Inserting Process ");

		System.out.println("Block Number\t\tBlock Size");
		for(int i=0;i<bSize;i++)
		{
			System.out.println(""+(i+1)+"\t\t  "+blockAvailableSize[i]);
		}
	}


	public static void main(String[] args)
	{
		BestFitExample obj=new BestFitExample();
		Scanner sc=new Scanner(System.in);
		int ch;

		System.out.println("Enter the Number of Memory Segment ");
		int n=sc.nextInt();
		int blockAvailableSize[]=new int[n];

		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Size of First Block Available  ");
			blockAvailableSize[i]=sc.nextInt();
		}
		int bSize=blockAvailableSize.length;
		do
		{
			System.out.println("------BEST FIT------\n1. Insert\n2. Exit");
			System.out.println("Enter the choice  ");
			ch=sc.nextInt();

			switch(ch)
			{
				case 1:obj.insert(blockAvailableSize,bSize);break;
				case 2:break;
			}
		}
		while(ch!=2);
	}
}
