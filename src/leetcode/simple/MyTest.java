package leetcode.simple;

import com.sun.source.tree.Tree;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

    /**
     215. 数组中的第K个最大元素
     中等
     2K
     相关企业
     给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

     请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

     你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。



     示例 1:

     输入: [3,2,1,5,6,4], k = 2
     输出: 5
     示例 2:

     输入: [3,2,3,1,2,4,5,5,6], k = 4
     输出: 4
     //建立一个定长数组。应该去建立一个大顶堆，但要固定长度。
     */
    public int findKthLargest(int[] nums, int k) {
        int[] resultK = new int[k];
        for(int i = 0;i<k;i++){
            resultK[i] = Integer.MIN_VALUE;
        }

        for(int i=0;i<nums.length;i++){
            int findIdx = resultK.length;
           for(int j=resultK.length-1;j>=0;j--){
               if(nums[i]>resultK[j]){
                  findIdx = j;
               }
           }

           for(int j = resultK.length-1; j>findIdx;j--){
               resultK[j] = resultK[j-1];
           }
           if(findIdx<resultK.length) {
               resultK[findIdx] = nums[i];
           }
        }
        return resultK[resultK.length-1];
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
