import java.util.*;
import java.io.*;

class tables{
    static int count = 0;
    HashMap<String, Integer> AD,RG,IS,CC,DL;
    ArrayList<Integer> lables;
    ArrayList<String> literal_table;

    // Data Structure initialization
    tables(){
        AD = new HashMap<>();
		CC = new HashMap<>();
		IS = new HashMap<>();
		RG = new HashMap<>();
		DL = new HashMap<String, Integer>();
		literal_table = new ArrayList<String>();
        lables = new ArrayList<>();
		// Declarative Statements
		DL.put("DC", 01);
		DL.put("DS", 02);
		// Imperative Statements
		IS.put("STOP",0);
		IS.put("ADD",1);
		IS.put("SUB",2);
		IS.put("MULT",3);
		IS.put("MOVER",4);
		IS.put("MOVEM",5);
		IS.put("COMP",6);
		IS.put("BC",7);
		IS.put("DIV",8);
		IS.put("READ",9);
		IS.put("PRINT",10);
		// Conditional Statements
		CC.put("LT",1);
		CC.put("LE",2);
		CC.put("EQ",3);
		CC.put("GT",4);
		CC.put("GE",5);
		CC.put("ANY",6);
		// Assembler Directives
		AD.put("START",1);
		AD.put("END",2);
		AD.put("ORIGIN",3);
		AD.put("EQU",4);
		AD.put("LTORG",5);
		// Registers
		RG.put("AREG",1);
		RG.put("BREG",2);
		RG.put("CREG",3);
		RG.put("DREG",4);
    }
    void checkString(String str,int index,int address)
    {
        if(AD.containsKey(str))
        {
        }
        else if(IS.containsKey(str))
        {
        }
        else if(DL.containsKey(str))
        {
        }
        else if(CC.containsKey(str))
        {
        }
        else if(RG.containsKey(str))
        {
        }
        else{
            if(str.contains("='"))
            {
                literal_table.add(str);
                lables.add(address);
            }       
        }
    }
}


public class Literal_Table_Pass1_Assembler{
    public static void main(String args[]) throws Exception
    {
        System.out.println("*** PASS 1 Assembler Literal Table ***");
        tables t1 = new tables();
        int START_ADDRESS = 500;
        ArrayList<String> literals = new ArrayList<>();
        FileReader fr = new FileReader("./Program.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        boolean is_LTORG_Present = false;
        boolean is_END_Present = false;
        int count = 0;
        
        while((line = br.readLine())!=null)
        {
            String arr[] = line.split("\\s");
            if(!line.contains("START"))
            {
                START_ADDRESS++;
            }
            for(int i=0;i<arr.length;i++)
            {
                if(line.contains("LTORG"))
                {
                is_LTORG_Present = true;
                }
                if( line.contains("END"))
                {
                is_END_Present = true;
                }
                if(is_LTORG_Present)
                {
                    for(int j=0;j<literals.size();j++)
                    {
                        System.out.println(count +"  "+ literals.get(j) +"   "+ START_ADDRESS++);    
                        count++;
                    }
                    literals.clear();
                    is_LTORG_Present = false;
                }
                if(is_END_Present)
                {
                    for(int j=0;j<literals.size();j++)
                    {
                        
                        System.out.println(count +"  "+ literals.get(j) +"   "+ START_ADDRESS++);
                        count++;
                    }
                    literals.clear();
                }
                
                if(arr[i].trim() !=null)
                {
                    arr[i] = arr[i].trim();
                    if(arr[i].isEmpty()==false)
                    {
                        t1.checkString(arr[i],i,START_ADDRESS);
                        if(arr[i].contains("='"))
                        {
                            // System.out.println(arr[i]);
                            literals.add(arr[i]);
                        }
                    }
                }
            }
        }
    }
}