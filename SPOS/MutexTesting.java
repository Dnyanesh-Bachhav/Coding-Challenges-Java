import java.util.concurrent.*;
public class MutexTesting
{
	static Semaphore s=new Semaphore(1);
	static class MyThread extends Thread
	{
		String n="";
		MyThread(String name)
		{
			n=name;
		}

		public void run()
		{
			try
			{
				System.out.println(n+" acquiring lock....");
				s.acquire();
				System.out.println(n+" got the permit...");
				System.out.println(n+" Available :"+s.availablePermits());

				try
				{
					for(int i=1;i<=5;i++)
					{
						System.out.println(n+" is performing "+i+" operation ");
						System.out.println("Total Available Semaphore now : "+s.availablePermits());
						//Thread.sleep(1000);
					}
				}

				finally
				{
					System.out.println(n+" Releasing Lock...");
					s.release();
					System.out.println(n+" Available Semaphore now :"+s.availablePermits());
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}


		}
	}





	public static void main(String []args)
	{
		System.out.println("Available :"+s.availablePermits());
		MyThread t1=new MyThread("A");
		t1.start();


		MyThread t2=new MyThread("B");
		t2.start();

		MyThread t3=new MyThread("C");
		t3.start();

		MyThread t4=new MyThread("D");
		t4.start();


		MyThread t5=new MyThread("E");
		t5.start();




	}
}

