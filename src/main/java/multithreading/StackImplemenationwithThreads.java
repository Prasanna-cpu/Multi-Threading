package multithreading;

public class StackImplemenationwithThreads {
    int[] array;
    int top;

    final Object lock;

    public StackImplemenationwithThreads(int capacity){
        top=-1;
        array=new int[capacity];
        lock=new Object();
    }

    public boolean CheckEmpty(){
        return top<0;
    }

    public boolean CheckOverflow(){
        return top>=array.length-1;
    }

    public synchronized boolean push(int element) throws InterruptedException{

            if(CheckOverflow()){
                return false;
            }

            ++top;

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }

            array[top]=element;
            return true;

    }

    public synchronized int Pop() throws InterruptedException {



            if (CheckEmpty()){
                return Integer.MIN_VALUE;
            }

            int popped_element=array[top];
            array[top]=Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }

            --top;
            return popped_element;



    }


}
