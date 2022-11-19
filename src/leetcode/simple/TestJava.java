package leetcode.simple;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().isIsomorphic("foo","bar"));
    }

    /**
     * 205. 同构字符串
     * 简单
     * 540
     * 相关企业
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     *
     *
     * 示例 1:
     *
     * 输入：s = "egg", t = "add"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "foo", t = "bar"
     * 输出：false
     * 示例 3：
     *
     * 输入：s = "paper", t = "title"
     * 输出：true
     * @param s
     * @param t
     * @return
     * 双向一对一
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Character> mapB2A = new HashMap<>();
        for(int i=0;i<s.length();i++){

            Character a = s.charAt(i);
            Character b = t.charAt(i);

            if(!mapB2A.containsKey(b)){
                if(mapB2A.containsValue(a)){
                    return false;
                }else {
                    mapB2A.put(b, a);
                }
            }else{
                Character lastMapping = mapB2A.get(b);
                if(lastMapping!=a){
                    return false;
                }
            }
        }
        return true;
    }

}
