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

     //暴力计算面积：= (下标2-下标1)*Min(Heigh1,Height2)
     */
    public int maxArea(int[] height) {

        int maxArea = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                //calculate area and compare
                int w = j-i;
                int h = Math.min(height[i],height[j]);
                int area = w*h;
                if(area>maxArea){
                    maxArea = area;
                }
            }
        }

        return maxArea;

    }

}
