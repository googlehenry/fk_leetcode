package leetcode.simple;

import java.lang.reflect.Array;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    /**
     * 16. 最接近的三数之和
     * 中等
     * 1.3K
     * 相关企业
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * <p>
     * 返回这三个数的和。
     * <p>
     * 假定每组输入只存在恰好一个解。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     *
     * 排序+双指针。三数字和>target，则左移；反之右移。
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closeTotal = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while(L<R){
                int total = nums[L] + nums[R] + nums[i];
                int diff = total - target;
                if(diff==0){
                    return target;
                }else if(diff>0){
                    R--;
                }else{
                    L++;
                }
                if(Math.abs(diff)<minDiff){
                    minDiff = Math.abs(diff);
                    closeTotal = total;
                }
            }

        }

        return closeTotal;
    }

}
