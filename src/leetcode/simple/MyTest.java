package leetcode.simple;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().trap(new int[]{4,2,0,3,2,5}));
    }

    /**
     * 42. 接雨水
     * 困难
     * 4K
     * 相关企业
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * @param height
     * @return
     * 求每一个列能收集的水，min(maxLeft,maxRight)-height(i)
     */
    public int trap(int[] height) {
        /**
         *  s[i] = min(h[i-n..],h[i+n...])-h[i]
         */

        int sum = 0;
        for(int i = 0;i<height.length;i++){
            int cur = height[i];
            int L = i-1;
            int R = i+1;
            int maxL = 0;
            int maxR = 0;
            while(L>=0){
                if(height[L]>maxL){
                    maxL = height[L];
                }
                L--;
            }
            while(R<height.length){
                if(height[R]>maxR){
                    maxR = height[R];
                }
                R++;
            }

            int area = Math.max(0,Math.min(maxL,maxR)-cur);
            sum += area;
        }

        return sum;
    }

}
