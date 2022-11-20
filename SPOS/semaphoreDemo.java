import java.util.concurrent.*;
class task implements Runnable {
    Semaphore sm = new Semaphore(2);
    public void run(){
        try{
        System.out.println("Available Permits: "+ sm.availablePermits());
        sm.acquire();
        System.out.println("Thread..."+ Thread.currentThread().getName());
        for(int i=0;i<5;i++)
        {
            System.out.println("Running thread: "+ Thread.currentThread().getName());
            Thread.sleep(2000);
        }
        sm.release();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
public class semaphoreDemo
{
    public static void main(String args[])
    {
        System.out.println("Hello World...!!!");
        task task1 = new task();
        Thread t1 = new Thread(task1);
        t1.setName("T1");
        t1.start();
        Thread t2 = new Thread(task1);
        t2.setName("T2");
        t2.start();
        Thread t3 = new Thread(task1);
        t3.setName("T3");
        t3.start();
        Thread t4 = new Thread(task1);
        t4.setName("T4");
        t4.start();
        Thread t5 = new Thread(task1);
        t5.setName("T5");
        t5.start();
    }
}