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
     */
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        StringBuilder bitsResult = new StringBuilder();
        int borrow = 0;
        while( i >= 0 || j >= 0){
            int sumBit = 0;
            Integer aBit = 0;
            if(i>=0){
                aBit = a.charAt(i) - '0';
            }
            Integer bBit = 0;
            if(j>=0){
                bBit = b.charAt(j) - '0';
            }

            sumBit = aBit + bBit + borrow;

            if(sumBit>=2){
                borrow = 1;
            }else{
                borrow = 0;
            }
            sumBit = sumBit % 2;

            bitsResult.append(sumBit);

            j--;
            i--;
        }
        if(borrow>0) {
            bitsResult.append(borrow);
        }

        return bitsResult.reverse().toString();

    }
}
