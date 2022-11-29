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
     * 双指针+Map因为区间无重复,但是注意map可能有之前的数据，所以需要动态计算maxlen
     */
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        Map<Character,Integer> windowMap = new HashMap<>();
        int len = 0;
        while(i<s.length()&&j<s.length()){
            if(windowMap.containsKey(s.charAt(j))){
                i = Math.max(i,windowMap.get(s.charAt(j)) + 1);
                len=Math.max(len,j-i+1);
                windowMap.put(s.charAt(j),j);
                j++;
            }else{
                windowMap.put(s.charAt(j),j);
                len=Math.max(len,j-i+1);
                j++;
            }

        }

        System.out.println(windowMap);

        return len;
    }


}
