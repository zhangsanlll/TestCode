import java.util.Scanner;

//滑动窗口相关算法题
public class Solution209 {
    //1、力扣209 长度最小的子数组
    public  static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        //这里min不能是-1，因为后面要求最小值，-1会干扰结果
        int min = Integer.MAX_VALUE;
        while (right < nums.length && left < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                // 满足结果，更新最小值
                int len = right - left + 1;
                min = Math.min(len, min);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Solution209 s1 = new Solution209();
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        int nums[] = {1,1,1,1,1,1};
        int ret = s1.minSubArrayLen(target,nums);
        System.out.println(ret);
    }

}

