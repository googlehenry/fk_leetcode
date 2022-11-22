package leetcode.simple;

import java.time.Year;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().longestPalindrome("babad"));
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
     * 中心扩展法
     */
    public String longestPalindrome(String s) {
        String maxString = String.valueOf(s.charAt(0));

        for(int cur=0;cur<s.length();cur++){
            boolean expanded = false;
            for(int prev=cur,next=cur;prev>=0 && next<s.length();){
                if(!expanded && (prev-1)>=0 && s.charAt(cur)==s.charAt(prev-1)){
                    prev--;
                    if(next+1-prev>maxString.length()){
                        maxString = s.substring(prev,next+1);
                    }
                }else if(!expanded && (next+1)<s.length() && s.charAt(cur)==s.charAt(next+1)){
                    next++;
                    if(next+1-prev>maxString.length()){
                        maxString = s.substring(prev,next+1);
                    }
                }else if((prev-1)>=0 && (next+1)<s.length() && s.charAt(prev-1)==s.charAt(next+1)){
                    prev--;
                    next++;
                    if(next+1-prev>maxString.length()){
                        maxString = s.substring(prev,next+1);
                    }
                    expanded = true;
                }else{
                    break;
                }

            }
        }
        return maxString;
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
