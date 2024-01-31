package multithreading;
import java.util.LinkedList;

class SharedBuffer{
    private final LinkedList<Integer> buffer=new LinkedList<>();
    private final int capaciy;

    public SharedBuffer(int capaciy){
        this.capaciy=capaciy;
    }

    public void produce() throws InterruptedException{
        int item=1;

        synchronized (this){
            while(buffer.size()==capaciy){
                System.out.println("Buffer is full , let consumer consume");
                wait();
            }

            System.out.println("Producer produced:"+item);
            buffer.add(item);
            notify();
        }
    }

    public void consume() throws InterruptedException{
        int item=1;
        synchronized (this){
            while(buffer.isEmpty()){
                System.out.println("Buffer is empty , let producer produce");
                wait();
            }
            int removed_item=buffer.remove();
            System.out.println("Consumer consumed:"+removed_item);
            notify();
        }

    }
}


class Producer extends Thread{
    private final SharedBuffer sb;
    public Producer(SharedBuffer sb){
        this.sb=sb;}

    @Override
    public void run(){
        try{
            for (int i=0;i<5;i++){
                sb.produce();
                Thread.sleep(1000);
            }

        }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
}

class Consumer extends Thread{
    private final SharedBuffer sb;

    public Consumer(SharedBuffer sb){
        this.sb=sb;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<5;i++){
                sb.consume();
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer=new SharedBuffer(5);

        Producer producer=new Producer(sharedBuffer);
        Consumer consumer=new Consumer(sharedBuffer);

        producer.start();
        consumer.start();
    }
}
