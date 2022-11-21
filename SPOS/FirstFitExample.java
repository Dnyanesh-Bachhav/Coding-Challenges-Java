import java.util.*;

class FirstFitExample
{
	void firstFit(int blockAvailableSize[],int bSize,int processSize[],int pSize)
	{
		int allocatedBlock[]=new int[pSize];
		int occupied[]=new int[bSize];

		for(int i=0;i<allocatedBlock.length;i++)
		{
			allocatedBlock[i]=-1;
		}

		for(int i=0;i<occupied.length;i++)
		{
			occupied[i]=0;
		}


		for(int i=0;i<pSize;i++)
		{
			for(int j=0;j<bSize;j++)
			{
				if(!(occupied[j]>0) && blockAvailableSize[j]>=processSize[i])
				{
					allocatedBlock[i]=j;
					occupied[j]=1;
					break;
				}
			}
		}

		System.out.println("Process Number\t\tProcess Size\t\tBlock Number Allocated");
		for(int i=0;i<pSize;i++)
		{
			if(allocatedBlock[i]!=-1)
				System.out.println(""+(i+1)+"\t\t\t "+processSize[i]+"\t\t\t "+(allocatedBlock[i]+1));
			else
				System.out.println(""+(i+1)+"\t\t\t "+processSize[i]+"\t\t\t Not Allocated");
		}

	}

	public static void main(String []args)
	{
		FirstFitExample obj=new FirstFitExample();


		int blockAvailableSize[]={100,50,30,120,35};
		int processSize[]={20,60,70,40};

		int bSize=blockAvailableSize.length;
		int pSize=processSize.length;

		obj.firstFit(blockAvailableSize,bSize,processSize,pSize);

	}
}

