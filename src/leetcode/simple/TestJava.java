package leetcode.simple;

import java.time.Year;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().longestPalindrome("aabbbc"));
    }

    /**
     * 5. 最长回文子串
     * 中等
     * 5.9K
     * 相关企业
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * @param s
     * @return
     * 动态规划：长度为1的回文串，长度为2的回文串，长度为N的回文串=长度为(N-1)的回文串&&两边的值是否相等。
     */
    public String longestPalindrome(String s) {
        int strLen = s.length();
        String string = String.valueOf(s.charAt(0));
        boolean[][] rs = new boolean[strLen][strLen];
        for(int i=0;i<strLen;i++){
            rs[i][i] = true;
            if(i+1<strLen) {
                rs[i][i + 1] = s.charAt(i)==s.charAt(i+1);
                if(rs[i][i+1] && 2>string.length()){
                    string = s.substring(i,i+1+1);
                }
            }
        }

        for(int len=3; len<=strLen;len++){
            for(int i=0;i<strLen;i++){
                int j = i+len-1;
                if(j<strLen){
                    rs[i][j] = rs[i+1][j-1] && s.charAt(i)==s.charAt(j);
                    if(rs[i][j] && (j+1-i)>string.length()){
                        string = s.substring(i,j+1);
                    }
                }
            }
        }


        return string;
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
