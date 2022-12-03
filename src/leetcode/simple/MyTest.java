package leetcode.simple;

import com.sun.source.tree.Tree;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }

    /**
     * 56. 合并区间
     * 中等
     * 1.7K
     * 相关企业
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int i = 0;
        int j = 1;
        while(i<intervals.length && j<intervals.length){
            if(intervals[i]!=null) {
                if (intervals[j] != null) {
                    int[] arrA = intervals[i];
                    int[] arrB = intervals[j];
                        //based on A
                    if (arrB[0] <= arrA[1]) {
                        intervals[i][0] = arrA[0];
                        intervals[i][1] = Math.max(arrB[1], arrA[1]);
                        intervals[j] = null;
                        j++;
                    }else{
                        i++;
                        j=i+1;
                    }
                }else{
                    j++;
                }
            }else{
                i++;
                j=i+1;
            }
        }
        int counter = 0;
        for (int x = 0; x < intervals.length; x++) {
            if(intervals[x]!=null){
                counter++;
            }
        }
        int[][] result = new int[counter][2];

        int c = 0;
        for (int x = 0; x < intervals.length; x++) {
            if(intervals[x]!=null) {
                result[c++] = intervals[x];
            }
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
