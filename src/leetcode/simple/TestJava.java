package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().climbStairs(3));
    }

    /**
     * 70. 爬楼梯
     * 简单
     * 2.7K
     * 相关企业
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    Map<Integer,Integer> temp = new HashMap<>();
    public int climbStairs(int n) {

        if(n==0||n==1){
            return 1;
        }else{
            if(!temp.containsKey(n)){
                temp.put(n,climbStairs(n-1) + climbStairs(n-2));
            }
            return temp.get(n);
        }
    }


}
