package leetcode.simple;

import com.sun.source.tree.Tree;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().topKFrequent(new int[]{1,1,1,2,2,3},2));
    }

    /**
     * 347. 前 K 个高频元素
     * 中等
     * 1.4K
     * 相关企业
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     *
     *
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);
        int L = 0;
        int R = 0;
        TreeMap<Integer,List<Integer>> freqToNumberMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        while(R<=nums.length){
            if(R!=nums.length && nums[L]==nums[R]){
                R++;
            }else{
                int freq = R-L; //aab
                List<Integer> arrs = freqToNumberMap.get(freq)==null?new ArrayList<>() : freqToNumberMap.get(freq);
                arrs.add(nums[L]);
                freqToNumberMap.put(freq,arrs);
                L = R;
                R++;
            }
        }

        int[] result = new int[k];

        Iterator<Map.Entry<Integer,List<Integer>>> iterator = freqToNumberMap.entrySet().iterator();
        int counter = 0;
        while(iterator.hasNext() && counter<k){
            List<Integer> arrs = iterator.next().getValue();
            for(int i=0;i<arrs.size();i++){
                result[counter++] = arrs.get(i);
                if(counter>=k)break;
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
