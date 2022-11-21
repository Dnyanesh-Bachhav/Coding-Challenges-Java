
import java.util.concurrent.Semaphore;
import java.util.Scanner;

public class Readerwriter {
 static Semaphore mutex = new Semaphore(1); //mutex = 1
 static Semaphore wrt = new Semaphore(1); //wrt = 1
 static int readCount = 0;
 static String message = "Hello";
 static Scanner SC = new Scanner(System.in);
 static class Reader implements Runnable { //Reader Thread
 public void run() {
 try {
 //Acquire Section
 mutex.acquire(); 
 readCount++;
 if (readCount == 1) {
 wrt.acquire();
 }
 mutex.release();
 //Reading section
 System.out.println("Thread "+Thread.currentThread().getName() + 
" is reading: " + message);
 Thread.sleep(1500);
 System.out.println("Thread "+Thread.currentThread().getName() + 
" has finished reading");
 //Releasing section
 mutex.acquire();
 readCount--;
 if(readCount == 0) {
 wrt.release();
 }
 mutex.release();
 } catch (InterruptedException e) {
 System.out.println(e.getMessage());
 }
 }
 }
 static class Writer implements Runnable { //Writer Thread
 public void run() {
 try {
 wrt.acquire();
 message = "Akhilesh";
 System.out.println("Thread "+Thread.currentThread().getName() + 
" is writing: " + message);
 
 
 
 
 Thread.sleep(1500);
 System.out.println("Thread "+Thread.currentThread().getName() + 
" has finished writing");
 wrt.release();
 } catch (InterruptedException e) {
 System.out.println(e.getMessage());
 }
 }
 }
//Main Program
 public static void main(String[] args) throws Exception {
 Reader read = new Reader();
 Writer write = new Writer();
 Thread r1 = new Thread(read);
 r1.setName("Rohan");
 Thread r2 = new Thread(read);
 r2.setName("Rohit");
 Thread r3 = new Thread(read);
 r3.setName("Pratham");
 Thread w1 = new Thread(write);
 w1.setName("Ram");
 Thread w2 = new Thread(write);
 w2.setName("Prutvi");
 Thread w3 = new Thread(write);
 w3.setName("Raj");
 w1.start();
 r1.start();
 w2.start();
 r2.start();
 w3.start();
 r3.start();
 
 }
}
