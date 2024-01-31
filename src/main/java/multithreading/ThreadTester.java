package multithreading;
public class ThreadTester {
    public static synchronized void main(String[] args) {
//        Thread thread1=new Thread1("First Thread");
//        Thread thread2= new Thread2("Second Thread");
//        Thread3 thread3=new Thread3();
//        Thread t3=new Thread(thread3,"Third Thread");
//
//        Thread t4=new Thread(()->{
//            for(int i=10;i<=100;i+=10){
//                System.out.println(Thread.currentThread()+","+i);
//            }
//        },"Fourth Thread");
//
//
//
//        //thread1.setDaemon(true);
//        thread1.start();
//        //thread2.setDaemon(true);
//        thread2.start();
//        t3.start();
//        t4.start();
        StackImplemenationwithThreads stack=new StackImplemenationwithThreads(5);
        new Thread(()->{
            int counter=0;
            while(++counter<10){
                try {
                    System.out.println("Pushing:"+stack.push(100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Push Thread").start();

        new Thread(()->{
            int counter=0;
            while(++counter<10){
                try {
                    System.out.println("Popped:"+stack.Pop());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Pop Thread").start();
        System.out.println("Main Exiting");
    }
}
