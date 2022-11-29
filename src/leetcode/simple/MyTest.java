package leetcode.simple;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * 困难
     * 6.1K
     * 相关企业
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     * 忽略复杂度：合并数组再找中位数，复杂度(M+N)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //归并
        int[] merge = new int[nums1.length+nums2.length];

        int earlyEndIdx = merge.length/2+1;//odd and even
        int i = 0;
        int j = 0;
        int m = 0;
        while(i<nums1.length || j<nums2.length){
            if(i<nums1.length&&j<nums2.length){
                if(nums1[i]<=nums2[j]){
                    merge[m++] = nums1[i++];
                }else{
                    merge[m++] = nums2[j++];
                }
            }else if(i<nums1.length){
                merge[m++] = nums1[i++];
            }else if(j<nums2.length){
                merge[m++] = nums2[j++];
            }

            //(m+n)/2,how to make it logn?
            if(m>earlyEndIdx){
                break;
            }
        }

        if(merge.length%2==0){
            return (merge[merge.length/2-1]+merge[merge.length/2])/2.0;
        }else{
            return merge[merge.length/2];
        }
    }

}
