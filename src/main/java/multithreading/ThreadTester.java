package multithreading;
public class ThreadTester {
    synchronized public static void main(String[] args) {
        Thread thread1=new Thread1("First Thread");
        Thread thread2= new Thread2("Second Thread");
        //thread1.setDaemon(true);
        thread1.start();
        //thread2.setDaemon(true);
        thread2.start();
        System.out.println("Main Exiting");
    }
}
