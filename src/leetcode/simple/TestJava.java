package leetcode.simple;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 53. 最大子数组和
     * 中等
     * 5.5K
     * 相关企业
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     * @param nums
     * @return
     * 动态规划，子问题最大值，然后再从所有最大值中选取最大值。简化。
     */
    public int maxSubArray(int[] nums) {

        int max = nums[0];

        int preSum = nums[0];

        for(int i=1; i<nums.length;i++){
            preSum = Math.max(nums[i],preSum+nums[i]);
            max = Math.max(max, preSum);
        }

        return max;
    }


}
