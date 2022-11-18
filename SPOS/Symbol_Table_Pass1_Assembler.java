import java.util.*;
import java.io.*;
public class Symbol_Table_Pass1_Assembler{
    public static void main(String args[]) throws Exception
    {
        System.out.println("*** PASS 1 Assembler Symbol Table ***");
        tables t1 = new tables();
        FileReader fr = new FileReader("./Program.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        
        while((line = br.readLine())!=null)
        {
            String arr[] = line.split("\\s");
            System.out.print(arr.length);
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i].trim() !=null)
                {
                arr[i] = arr[i].trim();
                if(arr[i].isEmpty()==false)
                System.out.println(arr[i]);
                }
            }
        }
        System.out.println("Hello World...!!!");
    }
}
class tables{
    static int count = 0;
    HashMap<String, Integer> AD,RG,IS,CC,DL;
    ArrayList<String> symbol_table,literal_table,constant_table;
    // Data Structure initialization
    tables(){
        AD = new HashMap<>();
		CC = new HashMap<>();
		IS = new HashMap<>();
		RG = new HashMap<>();
		DL = new HashMap<String, Integer>();
		symbol_table = new ArrayList<>();
		constant_table = new ArrayList<>();
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
}