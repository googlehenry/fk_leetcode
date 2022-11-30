package leetcode.simple;

import java.lang.reflect.Array;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    /**
     11. 盛最多水的容器
     中等
     3.9K
     相关企业
     给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

     返回容器可以储存的最大水量。

     说明：你不能倾斜容器。



     示例 1：



     输入：[1,8,6,2,5,4,8,3,7]
     输出：49
     解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     示例 2：

     输入：height = [1,1]
     输出：1

     //双指针计算面积：如果左边小，则左边加一才能获得更大的面积。右边小，则右移才能获得更大的面积。
     */
    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int area = (right-left)*Math.min(height[left],height[right]);
            if(area>maxArea){
                maxArea = area;
            }
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;

    }

}
