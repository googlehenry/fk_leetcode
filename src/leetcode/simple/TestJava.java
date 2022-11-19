package leetcode.simple;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().isValid("{[]}()[]"));
    }

    /**
     * 20. 有效的括号
     * 简单
     * 3.6K
     * 相关企业
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * @param s
     * @return
     * 改进版，进去的顺序固定，那么关闭的顺序也决定了。减少判断。
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '(': stack.add(')');break;
                case '{': stack.add('}');break;
                case '[': stack.add(']');break;
                default:{
                    if(stack.isEmpty()||stack.pop()!=s.charAt(i)){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
