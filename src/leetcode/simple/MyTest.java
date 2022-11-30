package leetcode.simple;

import java.lang.reflect.Array;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().isPalindrome(1234321));
    }

    /**
     * 9. 回文数
     * 简单
     * 2.3K
     * 相关企业
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     *
     *
     * 示例 1：
     *
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     *
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     *
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * @param x
     * @return
     * 字符串解决+数字反序
     */
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int old = x;
        int temp = 0;
        while(x!=0){
            temp = temp*10 + x%10;
            x = x/10;
        }
        return temp == old;
    }

}
