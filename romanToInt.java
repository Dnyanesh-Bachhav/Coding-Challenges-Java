import java.util.*;
class romanToInt{
    public static int romanChValue(char ch)
    {
        int val = 0;
        switch(ch)
        {
            case 'I';
            val = 1;
            break;
            case 'V';
            val = 5;
            break;
            case 'X';
            val = 10;
            break;
            case 'L';
            val = 50;
            break;
            case 'C';
            val = 100;
            break;
            case 'D';
            val = 500;
            break;
            case 'M';
            val = 1000;
            break;
        }
        return val;
    }
    public static int romanToIntConvert(String roman){
        char chArr[] = roman.toCharArray();
        char romanChArr[] = {'M','D','C','L','X','V','I'};
        for(char ele: romanChArr)
        {
            romanCh.add(ele);
            System.out.println(ele);
        }
        for(char ch: chArr)
        {
            System.out.println(ch);
        }

        return 0;
    }
    
    public static void main(String args[])
    {
        System.out.println(romanToIntConvert("IV"));
    }
}