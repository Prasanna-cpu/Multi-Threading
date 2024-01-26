package multithreading;

public class Thread1 extends Thread {

    public Thread1(String threadName) {
        super(threadName);
    }

    
    @Override
    public void run(){
        System.out.println("Thraed1 starting");
        for (int i = 0; i <5 ; i++) {
            System.out.println(i+" in "+Thread.currentThread());
        }
    }



}
