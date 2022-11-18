package leetcode.simple;

import java.util.TreeSet;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().longestCommonPrefix(new String[]{"cir","car","c"}));
    }
    public String longestCommonPrefix(String[] strs) {
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
