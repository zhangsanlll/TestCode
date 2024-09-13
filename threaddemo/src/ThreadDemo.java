

class  MyThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1= new MyThread();
        Thread t2= new MyThread();
        Thread t3= new MyThread();
        t1.start();
        t2.start();
        t3.start();
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
