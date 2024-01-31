package multithreading;

public class Volatile {

    private static volatile boolean flag=false;
    public static void main(String[] args){

        Thread th1=new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread1 is toggling the flag");
                flag=!flag;

                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    e.getMessage();
                }
            }
        });

        Thread th2=new Thread(()-> {
            while (!flag) {
                System.out.println("Thread2 is waiting for flag to be set to true");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }

            }
            System.out.println("Thread 2 working");
        });

        th1.start();
        th2.start();







    }
}
