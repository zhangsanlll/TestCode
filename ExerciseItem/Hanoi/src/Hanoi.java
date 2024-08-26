import java.util.Arrays;

/*//汉诺塔代码编写
public class Hanoi {

    //使用递归调用
    *//*
    * 需要三个容器，即A，B，C分别用来存放盘子
    * 最开始，所有盘子都在A中，需要通过另外两个容器是的所有盘子都存放到C中并且从小到大依次存放，小的必须放在大的上面
    * *//*




    *//*
        n:一共有几个盘子
        A，B，C:存放容器
        * *//*
    public static void hanoi(int n,char A,char B,char C){
        if(n == 1){
            System.out.println(A+"->"+C);
        }else{
            //从A绕过C到B
            hanoi(n-1,A,C,B);
            System.out.println(A+"->"+C);
            //从B绕过A再到C
            hanoi(n-1,B,A,C);
        }
    }

    public static void main(String[] args) {
        hanoi(2,'A','B','C');
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(array));
    }
}*/

/*
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}
public class Hanoi {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test=null;
        test.hello();
    }
}
*/
/*
public class Hanoi{

    private int count;

    public static void main(String[] args) {

        Hanoi test=new Hanoi(88);

        System.out.println(test.count);

    }

    Hanoi(int a) {

        count=a;

    }

}*/

public class Hanoi {
    public static void main(String[] args) {
        String str = "hello world bit";
        String[] split = str.split(" ",2
        );
        for(String s:split){
            System.out.println(s);
        }
        System.out.println(3 * 0.1 );
    }
}
