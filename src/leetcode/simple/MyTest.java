package leetcode.simple;

import java.lang.reflect.Array;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    /**
     * 18. 四数之和
     * 中等
     * 1.4K
     * 相关企业
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     *
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     * @param nums
     * @param target
     * @return
     *
     * 仍然是排序+双指针降低一维
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> groups = new ArrayList<>();
        Arrays.sort(nums);
        for(int a=0;a<nums.length-1;a++){
            for(int b=a+1;b<nums.length-1;b++){
                int L = b+1;//保证下标各不相等
                int R = nums.length -1;
                while(L<R && L<nums.length -1){

                    //long防止int相加溢出
                    long sum = (long)nums[a]+nums[b]+nums[L]+nums[R];
                    if(sum==target){
                        //add to result
                        groups.add(Arrays.asList(nums[a],nums[b],nums[L],nums[R]));
                        L++;
                        R--;
                    }else if(sum>target){
                        R--;
                    }else{
                        L++;
                    }
                }
            }
        }

        return groups.stream().distinct().toList();
    }

}
