public class Main {
    public static float find_median (float[] array1, float[] array2) {
        // write code here
        int len1 = array1.length;
        int len2 = array2.length;
        int  n = len1 + len2;
        float[] ret = new float[n];
        int cur1 = 0,cur2 = 0 ,i = 0;
        while(cur1 < len1 && cur2 < len2){
            if(array1[cur1] < array2[cur2]) {
                ret[i] = array1[cur1++];
            }else if(array1[cur1] > array2[cur2]){
                ret[i] = array2[cur2++];
            }
            i++;
        }
        if(cur1 > len1 && cur2 < len2){
            //说明第二个数组还没有合并到新数组中
            ret[i++] = array1[cur1++];
        }
        if(cur2 > len2 && cur1 < len1){
            //说明第二个数组还没有合并到新数组中
            ret[i++] = array2[cur2++];
        }
        return ret[n/2];
    }

    public static int bitwiseComplement (int n) {
        // write code here
        //一直除2直到除数为0
        StringBuffer str = new StringBuffer();
        while(n != 0){
            int tmp = n % 2;
            //tmp = ~tmp;
            str.append((tmp));
            n = n / 2;
        }
        str.reverse();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '1'){
                str.setCharAt(i,'0');
            }else{
                str.setCharAt(i,'1');
            }
        }
        int sum = 0;

        for(int i = str.length() - 1;i > 0 ;i--){

            sum += (str.charAt(i) - '0') * Math.pow(2,str.length() - 1 -i);
        }

        return sum;
    }

    public static void main(String[] args) {
        /*float[] a1 = new float[]{1.00000f, 3.00000f, 7.00000f};
        float[] a2 = new float[]{2.0000f, 5.00000f, 10.00000f};
        float ret = find_median(a1,a2);
        System.out.println(ret);
        StringBuffer str = new StringBuffer();*/
        bitwiseComplement(5);

    }
}
