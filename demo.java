class demo{
    public static long product(int nums[],int n){
        int mult = 1;
        for(int i=0;i<nums.length;i++){
            if(i!=n){
                mult *= (long)nums[i];
            }
        }
        return mult;
        
    }
    public static void main(String args[]){
        System.out.println("Hello World...!!!");
        int nums[] = {10,3,5,6,2};
        long num2[] = new long[ 5 ];
        long total = 1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(j!=i){
                    total *= (long)nums[j];
                }
            }
            num2[i] = total;
            // num2[i] = product(nums,i);
            total = 1;
        }
        for(long i:num2)
        {
            System.out.println(i);
        }
    }
}