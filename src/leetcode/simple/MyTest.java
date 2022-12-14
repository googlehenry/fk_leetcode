package leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new MyTest().longestPalindrome("abccccdd"));
    }


    /**
     * 409. 最长回文串
     * 简单
     * 489
     * 相关企业
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     *
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     *
     *
     *
     * 示例 1:
     *
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * 示例 2:
     *
     * 输入:s = "a"
     * 输入:1
     * 示例 3：
     *
     * 输入:s = "aaaaaccc"
     * 输入:7
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        char[] chars = new char[128];

        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)]++;
        }

        int countOfOdd = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]%2==1)countOfOdd++;
        }

        return s.length() - (countOfOdd>0?countOfOdd-1:0);
    }
}

class ListNode {
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