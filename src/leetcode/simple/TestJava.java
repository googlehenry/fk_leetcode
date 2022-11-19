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
     * 双指针收尾按位比较，不等则不是，相等就像中间移动直到指针相遇。
     * 优化一步比较，不用set判断valid.
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i=0,j=s.length()-1;i<=j;){
            //prepare chars
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);


            if(!validChar(leftChar)){
                i++;
            }else if(!validChar(rightChar)){
                j--;
            }else if(validChar(leftChar)&&validChar(rightChar)&&leftChar!=rightChar){
                return false;
            }else{
                i++;
                j--;
            }
        }

        return true;
    }

    private boolean validChar(char c){
        return (c>='a' && c<='z')||(c>='0' && c<='9');
    }
}
