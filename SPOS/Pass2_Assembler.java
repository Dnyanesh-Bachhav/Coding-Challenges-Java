import java.io.*;
import java.util.*;
public class Pass2_Assembler{
    public static void main(String args[]) throws Exception
    {
        System.out.println("Hello World...!!!");
        FileReader fr1 = new FileReader("./Symbol_Table.txt");
        FileReader fr2 = new FileReader("./Literal_Table.txt");

        BufferedReader br = new BufferedReader(fr1);
        BufferedReader br1 = new BufferedReader(fr2);
        String line=null,line1 = null;
        // Symbol Table
        while((line = br.readLine())!=null)
        {
            System.out.println(line);
        }
        // Literal Table
        while((line = br1.readLine())!=null)
        {
            System.out.println(line);
        }

    }
}
