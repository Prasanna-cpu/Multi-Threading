package multithreading;

public class Thread2 extends Thread {

    public Thread2(String threadName){
        super(threadName);
    }
    @Override
     public void run(){
        System.out.println("Thread2 starting");
        for (int i = 2; i <20 ; i+=4) {
            System.out.println(i+" in "+Thread.currentThread());
        }
    }
}
