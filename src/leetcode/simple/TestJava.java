package leetcode.simple;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.*;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().wordPattern("abba", "dog cat cat dog"));
    }

    /**
     * 290. 单词规律
     * 简单
     * 519
     * 相关企业
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     *
     *
     *
     * 示例1:
     *
     * 输入: pattern = "abba", s = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", s = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     *
     * 输入: pattern = "aaaa", s = "dog cat cat dog"
     * 输出: false
     * @param pattern
     * @param s
     * @return
     * 双指针：s中以单词为单位,pattern中以char为单位。
     */
    public boolean wordPattern(String pattern, String s) {
        s = s.trim();

        Map<Character,String> mappings = new HashMap<>();

        for(int i=0,j=0,k=0; j<s.length() || k<pattern.length();){

            if(s.charAt(j)==' '|| j==s.length()-1){
                String word = s.substring(i, j==s.length()-1?s.length():j);
                Character c = pattern.charAt(k);

                if (mappings.containsKey(c)) {
                    if(!mappings.get(c).equals(word)){
                        return  false;
                    }
                }else{
                    if(mappings.containsValue(word)){
                        return false;
                    }
                }
                mappings.put(c, word);


                if(j==s.length()-1){
                    //word is done
                    if(k<pattern.length()-1){
                        return false;
                    }
                }
                if(k==pattern.length()-1){
                    //pattern is done
                    if(j<s.length()-1){
                        return false;
                    }
                }

                k++;
                i = j+1;
            }

            j++;
        }

        return true;

    }

}
