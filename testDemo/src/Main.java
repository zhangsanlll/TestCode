import java.util.Arrays;

public class Main {
    public static int[] twosum (int[] nums, int target) {
        // write code here
        int left = 0,right = 1;
        int n = nums.length - 1;
        //Arrays.sort(nums);
        int[] ret = new int[2];
        while(left <= n && right <= n ){
            if(left == right){
                right++;
            }
            int sum = nums[left] + nums[right];
            if(sum < target){
                right++;
            }else if( sum > target){
                left++;
            }else{
                ret[0] = left;
                ret[1] = right;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int[] ret = twosum(array,9);
        for(int x: ret){
            System.out.println(x);
        }
    }
}
