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
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()%2!=0){
            return false;
        }else{
            for(int i=0;i<s.length();i++){
                if(stack.isEmpty()){
                    stack.add(s.charAt(i));
                }else{
                    if(validLeft(s.charAt(i))){
                        stack.add(s.charAt(i));
                    }else{
                        //compare if correctly closing
                        if(!validPair(stack.pop(), s.charAt(i))){
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    private boolean validPair(char a,char b){
        boolean valid = false;
        switch (a){
            case '(': valid=b==')';break;
            case '{': valid=b=='}';break;
            case '[': valid=b==']';break;
        }
        return valid;
    }
    private boolean validLeft(char a){
        return a=='('||a=='{'||a=='[';
    }

}
