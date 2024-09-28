import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int q = in.nextInt();
        int min = Integer.MAX_VALUE;
        int k = -1;
        for(int i = 0;i < q;i++){
            int m = in.nextInt();
            int d = in.nextInt();
            k = m + d;
            min = Math.min( k ,min);

        }
        System.out.println(min);
    }
}