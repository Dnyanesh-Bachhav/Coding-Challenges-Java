public class Best_Fit{
    public static void main(String args[])
    {
        System.out.println("Hello World...!!!");
        int processArray[] = {10,5,20,80,90};
        int availableMemory[] = { 7,5, 81, 100, 70 };
        int allocatedArray[] = new int[availableMemory.length];
        int occupied[] = new int[processArray.length];
        for(int i=0;i<availableMemory.length;i++)
        {
            allocatedArray[i] = -1;
        }
        for(int j=0;j<allocatedArray.length;j++)
        {
            occupied[j] = 0;
        }
        for(int i=0;i<processArray.length;i++)
        {
            for(int j=0;j<availableMemory.length;j++)
            {
                if(occupied[j]==0 && availableMemory[j] >= processArray[i])
                {
                    allocatedArray[i] = j;
                    occupied[j] = 1;
                    break;
                }
            }
        }
        for(int i=0;i<processArray.length;i++)
        {
            try{
            System.out.println("Process: " +processArray[i]+" Allocated: "+occupied[i]+" Memory: "+ allocatedArray[i] );
            }
            catch(Exception e)
            {
            System.out.println("Process: " +processArray[i]+" Allocated: "+occupied[i]+" Memory: Not allocated");

            }
        }
    }
}
