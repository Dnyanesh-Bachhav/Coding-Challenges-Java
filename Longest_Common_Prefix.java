class Longest_Common_Prefix{
        public static void main(String args[]){
        System.out.println("Hello World...!!!");
        String str1[] = {"geeksforgeeks","geeks","geek","geezer"};
        int max = 0;
        int min  = Integer.MAX_VALUE;
        String minStr="", maxStr="";
        for(String str: str1)
        {
            if(str.length()<min)
            {
                min = str.length();
                minStr = str;
            }
        }
        System.out.println( minStr );
        int count = 0,max1 = 0;
        String newStr = "";
        // for(int i=0;i<minStr.length();i++)
        // {
        //         String str12 = minStr.substring(0,i+1);
        //         if(str1[i].contains(str12))
        //         {
        //             if( minStr.contains(str12))
        //             {
        //                 count = str12.length();
        //                 if(count>=max1)
        //                 {
        //                     max1 = count;
        //                     newStr = str12;
        //                 }
        //             }
        //         }
        // }
        System.out.println(minStr.indexOf("ge"));
        System.out.println("New String: "+newStr);  
        for(int i = 0 ;i < str1.length; i++) {

            while(str1[i].indexOf(minStr) != 0) {

                minStr = minStr.substring(0, minStr.length() - 1);
                System.out.println("Loop: "+minStr+" "+i);
            }

        }
    }
}