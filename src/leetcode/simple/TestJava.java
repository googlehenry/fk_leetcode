package leetcode.simple;

import java.util.TreeSet;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().longestCommonPrefix(new String[]{"cir","car","c"}));
    }

    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 “”。
    //示例 1：
    //输入：strs = [“flower”,“flow”,“flight”]
    //输出：“fl”
    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        //假设首先理解了字典序概念以后，把数组进行排序，这时候只需要看第一个字符串和最后一个字符串的公共前缀了，相当于夹逼
        TreeSet<String> set = new TreeSet<>();
        for(String str:strs){
            set.add(str);
        }
        String sortedFirst = set.first();
        String sortedLast = set.last();

        String common = sortedFirst;

        while(!sortedLast.startsWith(common)){
            common = common.substring(0,common.length()-1);
        }

        return common;
    }
}
