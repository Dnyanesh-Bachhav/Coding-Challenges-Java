import java.util.*;

public class pglru 
{
        int q[]=new int[3];
        ArrayList<Integer> lru=new ArrayList<Integer>();
        int front,rear,pf,pc;
        int removeindex;

        public pglru()
        {
            front=rear=-1;
            pf=pc=0;
        }

        public void insert()
        {
            Scanner sc=new Scanner(System.in);
            int no;
            System.out.println("\nENter no;-");
            no=sc.nextInt();

            int j;

            for(j=0;j<lru.size();j++)
            {
                if(lru.get(j)==no)
                {
                    lru.remove(j);
                    lru.add(no);
                    break;
                }

            }

            if(j==lru.size())
            {
                lru.add(no);
            }

            System.out.println("\nLRU ARRAY:-");
            for(int i=0;i<lru.size();i++)
            {
                System.out.print(lru.get(i)+" ");
            }
            System.out.println();


            if(front==-1||rear==-1)
            {
                    front=rear=0;
                    q[rear]=no;
                    System.out.print("\nPage miss");
                    pc++;   
            }
            else
            if(rear!=2)
            {
                int c=0;

                for(int i=0;i<rear;i++)
                {
                    if(q[i]==no)
                        c++;
                    
                }

                if(c<1)
                {
                    rear++;
                    q[rear]=no;
                    System.out.print("\nPage miss");
                    pc++;
                }
                else{
                    System.out.print("\nPage hit");
                    pc++;
                    pf++;
                }

            }
            else
            if(rear==2)
            {
                int c=0;
                for(int i=0;i<rear+1;i++)
                {
                    if(q[i]==no)
                        c++;

                }

                if(c<1)
                {

                    for(int i=0;i<q.length;i++)
                    {
                        if(lru.get(0)==q[i])
                        {
                            removeindex=i;
                            break;

                        }

                    }

                    q[removeindex]=no;
                    lru.remove(0);
                    pc++;
                    front++;
                    System.out.print("\nPage miss");
                }
                else
                {
                    System.out.print("\nPage hit");
                    pc++;
                    pf++;
                }
            }

            System.out.println("\nQueue Elements\n");
            for(int i=0;i<=rear;i++)
            {
               System.out.println("|"+q[i]+"|\n");
            }

            if(front==3)
                front=0;

        }


        public void PageFault()
        {
            System.out.println("\nTotal Number of Page count :- "+pc);
            System.out.println("\nTotal Number of Page Fault :- "+pf);
        }

        public static void main(String []args)
        {
                int ch;
                Scanner sc=new Scanner(System.in);
                pglru obj =new pglru();
                do{
                    System.out.println("\n------------MENU------------\n1.Insert a Page\n2.Total Number of Page Fault\n3.Exit\n");
    
                    ch=sc.nextInt();
    
    
                     switch(ch)
                    {
                        case 1:obj.insert();break;
                        case 2:obj.PageFault();break;
                        case 3:break;
                        default:System.out.println("Invalid Choice ");
                    }
                }while(ch!=3);
    
        }

}
