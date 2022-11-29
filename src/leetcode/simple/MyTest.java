package leetcode.simple;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 3. 无重复字符的最长子串
     * 中等
     * 8.5K
     * 相关企业
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int maxLength = 1;
        String maxString = String.valueOf(s.charAt(0));
        while(i<s.length()&&j<s.length()){
            boolean isQUalified = true;
            for(int i1 = i;i1<j;i1++){
                if(s.charAt(j)==s.charAt(i1)){
                    isQUalified = false;
                }
            }

            if(isQUalified){
                if(maxLength<j-i+1) {
                    maxLength = j - i + 1;
                    maxString = s.substring(i,j+1);
                }
                j++;
            }else{
                i++;
            }

        }

        System.out.println(maxString);

        return maxLength;
    }


}
