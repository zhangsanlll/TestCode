
public class ThreadTest {

    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

    public static void main3(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(3 * 1000);
        System.out.println(System.currentTimeMillis());
    }

    public static void main2(String[] args) {
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
