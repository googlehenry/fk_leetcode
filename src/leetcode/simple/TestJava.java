package leetcode.simple;

import java.util.TreeSet;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().lengthOfLastWord("ab    "));
    }

    /**
     * 58. 最后一个单词的长度
     * 简单
     * 519
     * 相关企业
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "Hello World"
     * 输出：5
     * 解释：最后一个单词是“World”，长度为5。
     * 示例 2：
     *
     * 输入：s = "   fly me   to   the moon  "
     * 输出：4
     * 解释：最后一个单词是“moon”，长度为4。
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        Integer len = s.length();

        Integer a = len - 1, b = len - 1;

        while(true){
            if(b>=0 && s.charAt(b)==' '){
                b--;
                a=b;
            }else{
                if(a>=0 && s.charAt(a)!=' '){
                    a--;
                }else{
                    break;
                }
            }
        }

        return b-a;
    }
}
