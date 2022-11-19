package leetcode.simple;

import java.util.Stack;
import java.util.TreeSet;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().addBinary("1111","1111"));
    }

    /**
     * 67. 二进制求和
     * 简单
     * 919
     * 相关企业
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     *
     *
     *
     * 示例 1：
     *
     * 输入:a = "11", b = "1"
     * 输出："100"
     * 示例 2：
     *
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     * @param a
     * @param b
     * @return
     * 核心思想就是：a+b+进位,然后根据sum确定这一位和新进位的值。
     */
    public String addBinary(String a, String b) {
        StringBuilder bitsResult = new StringBuilder();
        int borrow = 0;

        for(int i=a.length()-1, j=b.length()-1; i>=0||j>=0; i--,j--){
            int sum = borrow;
            sum += i>=0?a.charAt(i)-'0':0;
            sum += j>=0?b.charAt(j)-'0':0;

            bitsResult.append(sum % 2);
            borrow = sum /2;
        }

        bitsResult.append(borrow==0?"":borrow);


        return bitsResult.reverse().toString();

    }
}
