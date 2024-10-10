import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // 注意 while 处理多个 case
        int T = in.nextInt();
        Long[] ret = new Long[T];
        for(int i = 0;i < T;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            ret[i] = fun(a,b);
        }
        in.hasNextLine();
        for(int i = 0;i < T;i++){
            System.out.println(ret[i]);
        }
    }
    public static Long fun(Integer a,Integer b){
        if( a == b || (a == 0 && b == 0)){
            return 0L;
        }
        //1.判断a,b 的正负，并分情况讨论
        //全负的情况
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        Long ret = -1L;
        //全负
        if( a < 0 && b < 0){
            //min - max * 2^x
            int cur = 0;
            while((min - max * Math.pow(2,cur)) > 0 ){
                 ret = Long.valueOf((int)(min - max * Math.pow(2,cur)));
                cur ++;
            }
        }else if (a > 0 && b > 0){
            //一正一负、全正
            //max - min * 2^x
            int cur = 0;
            while((max - min * Math.pow(2,cur)) >= 0 ){
                 ret = Long.valueOf((int)(max - min * Math.pow(2,cur)));
                cur ++;
            }
        }else{
            ret = Long.valueOf(Math.abs(a - b));
        }
        return ret;
    }


}
