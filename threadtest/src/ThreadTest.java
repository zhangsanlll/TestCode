
public class ThreadTest {

    //此处定义⼀个int 类型的变量

    private static int count = 0;



    public static void main7(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //对count变量进⾏⾃增5w次
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        Thread t2 = new Thread(() -> {
            //对count变量进⾏⾃增5w次
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });
        t1.start();
        t2.start();
        //如果没有这俩join,肯定不⾏的.线程还没⾃增完,就开始打印了.很可能打印出来的cou
        t1.join();
        t2.join();
        //预期结果应该是10w
        System.out.println("count: " + count);
    }



       public static void main6(String[] args) {
        final Object object = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("hehe");
                }
            }
        }, "t2");
        t2.start();
    }

    public static void main5(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000_0000; i++) {
            }
        }, "李四 ");
                System.out.println(t.getName() + ": " + t.getState());;
        t.start();
        while (t.isAlive()) {
            System.out.println(t.getName() + ": " + t.getState());;
        }
        System.out.println(t.getName() + ": " + t.getState());;
    }

    public static void main2(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

    public static void main3(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(3 * 1000);
        System.out.println(System.currentTimeMillis());
    }

    public static void main4(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }

    public static void main1(String[] args) throws InterruptedException {
        Runnable target = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": 我还在⼯作！ ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": 我结束了！ ");
        };
            Thread thread1 = new Thread(target, " 李四 ");
            Thread thread2 = new Thread(target, " 王五 ");
            System.out.println(" 先让李四开始⼯作 ");
            thread1.start();
            //thread1.join();
            System.out.println(" 李四⼯作结束了，让王五开始⼯作 ");
            thread2.start();
            //thread2.join();
            System.out.println(" 王五⼯作结束了 ");
    }
}

class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }


}