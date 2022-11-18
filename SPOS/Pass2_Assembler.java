import java.io.*;
import java.util.*;

class tables {
    static int count = 0;
    HashMap<String, Integer> AD,RG,IS,CC,DL;
    ArrayList<String> symbol_table,literal_table,constant_table;
    
    HashMap<Integer,Integer> ST;
    HashMap<Integer,Integer> LT;
    FileReader fr1;
    FileReader fr2;
    BufferedReader br;
    BufferedReader br1;
    String line;

    // Data Structure initialization
    tables() throws Exception{
        AD = new HashMap<>();
		CC = new HashMap<>();
		IS = new HashMap<>();
		RG = new HashMap<>();
		DL = new HashMap<String, Integer>();
		symbol_table = new ArrayList<>();
		literal_table = new ArrayList<>();
		constant_table = new ArrayList<>();
        ST = new HashMap<>();
        LT = new HashMap<>();
        fr1 = new FileReader("./Symbol_Table.txt");
        fr2 = new FileReader("./Literal_Table.txt");
        br = new BufferedReader(fr1);
        br1 = new BufferedReader(fr2);

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
            // Symbol Table
            int symbol_count = 0;
        while((line = br.readLine())!=null)
        {
            // System.out.println(line);
            String arr[] = line.split("\\s");
            
                if(!arr[0].isEmpty() && !arr[0+1].isEmpty())
                {
                    ST.put( symbol_count, Integer.valueOf(arr[0+1]));
                }
            symbol_count++;
            // System.out.println(ST);
            
        }
        // Literal Table
        int literal_count = 0;
        while((line = br1.readLine())!=null)
        {
            // System.out.println(line);
            String arr[] = line.split("\\s");
            
                if(!arr[0].isEmpty() && !arr[0+1].isEmpty())
                {
                    LT.put( literal_count, Integer.valueOf(arr[0+1]));
                }
                literal_count++;
            // System.out.println(LT);
        }
		
    }
    public int checkString(String str,int value,int count,boolean isRegisterPresent, boolean isDSDCPresent)
    {
        
        // System.out.println(str+ "  " + value);
        if(str.trim().equals("AD"))
        {

            if(count == 1)
            {
                System.out.print("-- -- --");
            }
            else{
            System.out.print(value+" ");
            }
        }
        else if(isDSDCPresent)
        {
            System.out.print("--");
            return 0;
        }
        else if(str.trim().equals("IS"))
        {
            System.out.print(value+" ");
        }
        else if(DL.containsKey(str))
        {
            System.out.print("("+ "DL" +","+ DL.get(str)+") ");
        }
        else if(CC.containsKey(str))
        {
            System.out.print("("+ "CC" +","+ CC.get(str)+") ");
        }
        else if(str.trim().contains("RG"))
        {
            
            System.out.print(value+" ");
        }
        else if(str.trim().contains("S"))
        {
            System.out.print(ST.get(value)+" ");
        }
        else if(str.trim().contains("L"))
        {
            System.out.print(LT.get(value)+" |");
        }
        else if(!isRegisterPresent)
        {
            // System.out.print(" 00 ");
        }
        return 0;
        
        // else{
        //     try{
                
        //             int a = Integer.parseInt(str);
        //             System.out.print("("+ "C" +","+ a +") ");
        //     }
        //     catch(Exception e)
        //     {
        //         if(!str.isEmpty())
        //         {
        //             if(str.matches("[a-zA-Z0-9]*"))
        //             {
        //                 if(index > 0)
        //                 {
        //                     // Symbol Table
        //                     System.out.print("("+ "S" +","+ str +") ");
        //                     symbol_table.add(count,str);
                            
        //                 }
        //             }
        //             else{
        //                 // constants
        //                 System.out.print("("+ "C" +","+ str +") ");
        //             }
        //         }
        //     }
        // }
    }
    public void display(){
        // AD.entrySet().forEach(entry->{
        //     System.out.println(entry.getKey()+" "+entry.getValue());
        //     });
        for (int i=0;i<symbol_table.size();i++)
        {
            System.out.println(symbol_table.get((Integer)i));
            
        }
    }
    public void display_symbolTable(){
        System.out.println("Symbol Table: ");
        for (int i=0;i<symbol_table.size();i++)
        {
            System.out.println(i+" "+ symbol_table.get((Integer)i));
            
        }
    }
    public void display_constantTable(){
        
        System.out.println("Literal Table: ");
        System.out.println(literal_table.size());
        // for (int i=0;i<literal_table.size();i++)
        // {
        //     System.out.println(i+" "+ literal_table.get((Integer)i));
            
        // }
    }
}

public class Pass2_Assembler{
    public static void main(String args[]) throws Exception
    {
        System.out.println("Hello World...!!!");
        tables t1 = new tables();


        
        FileReader fr3 = new FileReader("./Input.txt");
        BufferedReader br2 = new BufferedReader(fr3);    
        String line;
        int count = 0;
        boolean isRegisterPresent = false;
        boolean isDSDCPresent = false;
        
        // Input
        while((line = br2.readLine())!=null)
        {
            line = line.replace("(","");
            line = line.replace(")","");
            count++;
            // System.out.println(line);
            if(line.contains("RG"))
            {
                isRegisterPresent = true;
            }
            if(line.contains("DL"))
            {
                isDSDCPresent = true;
            }
            String arr[] = line.split("\\s");
            for(int i=0;i<arr.length;i++)
            {
                if(!arr[i].isEmpty())
                {
                    String arr1[] = arr[i].split(",");
                    // System.out.println(arr1[0]+"____"+arr1[1]);
                    t1.checkString(arr1[0], Integer.valueOf(arr1[1]),count,isRegisterPresent,isDSDCPresent);
                    // LT.put( arr[0], Integer.valueOf(arr[0+1]));
                }

            isRegisterPresent = false;
            isDSDCPresent = false;
            }
            System.out.println();
                
            // System.out.println(LT);
        }
        // t1.checkString();


    }
}
