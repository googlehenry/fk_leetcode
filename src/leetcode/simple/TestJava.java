package leetcode.simple;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().isPalindrome("aba"));
    }

    /**
     *125. 验证回文串
     * 简单
     * 593
     * 相关企业
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出：true
     * 解释："amanaplanacanalpanama" 是回文串。
     * 示例 2：
     *
     * 输入：s = "race a car"
     * 输出：false
     * 解释："raceacar" 不是回文串。
     * 示例 3：
     *
     * 输入：s = " "
     * 输出：true
     * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
     * 由于空字符串正着反着读都一样，所以是回文串。
     * @param s
     * @return
     * 使用工具
     */
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        Set<Character> chars = new HashSet<>();
        char[] charstr = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        for(int i=0;i<charstr.length;i++){
            chars.add(charstr[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<s.length();i++){
            stringBuilder.append(chars.contains(s.charAt(i))?s.charAt(i):"");
        }

        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
