import java.util.*;
import java.io.*;
public class Page_Replacement_LRU{
    static ArrayList<Integer> li = new ArrayList<>();
    static ArrayList<Integer> lru = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int ph=0,pf=0;
    int front,rear,removeItem;
    Page_Replacement_LRU(){
        front = -1;
        rear = -1;
    }
    public void display(){
        System.out.println(li);
        System.out.println(lru);
    }
    public void insert(int item){
        if(!lru.contains(item) && lru.size()<3)
        {
            // System.out.println("Page Miss...");
            lru.add(item);
        }
        else if(lru.size()==3)
        {
            if(!lru.contains(item))
            {
            lru.remove(0);
            removeItem = lru.get(0);
            lru.add(item);
            }
    
        }
        else{
            // System.out.println("Page HIT");
        }
        System.out.println("LRU Array: "+lru);
        if(!li.contains(item) && li.size()<3)
        {
            // System.out.println("Page MISS");
            li.add(item);
            pf++;
        }
        else if(li.size()==3)
        {
            if(!li.contains(item))
            {
            front++;
            System.out.println(li.contains(removeItem)+" "+li.indexOf(removeItem));
            li.set(li.indexOf(removeItem)-1,item);
            // System.out.println("Page MISS");
            pf++;
            }
            else{
            // System.out.println("Page HIT");
            }
        }
        else{
            // System.out.println("Page HIT");
        }
        if(front==3)
        {
            front = 0;
        }
        System.out.println("Array: "+li);
        // System.out.println(item);
    }
    public static void main(String args[])
    {
        Page_Replacement_LRU obj1 = new Page_Replacement_LRU();
        int MAX_PROCESSES = 3;
        System.out.println("Enter a no of processes: ");
        int num = sc.nextInt();
        for(int i=0;i<num;i++)
        {
           obj1.insert(sc.nextInt());
        }
        obj1.display();

        // System.out.println("Hello World...!!!");
    }
}