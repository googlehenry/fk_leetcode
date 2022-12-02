package leetcode.simple;

import com.sun.source.tree.Tree;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().frequencySort("raaeaedere"));
    }

    /**
     * 451. 根据字符出现频率排序
     * 中等
     * 445
     * 相关企业
     * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
     *
     * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "tree"
     * 输出: "eert"
     * 解释: 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * 示例 2:
     *
     * 输入: s = "cccaaa"
     * 输出: "cccaaa"
     * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
     * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
     */
    public String frequencySort(String s) {
        if(s==null || s.length()==1) return s;

        char[] arrs = s.toCharArray();
        Arrays.sort(arrs);

        PriorityQueue<Map.Entry<Integer,Character>> freqChars = new PriorityQueue<>(s.length(), new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> o1, Map.Entry<Integer, Character> o2) {
                return o2.getKey()-o1.getKey();
            }
        });

        int L = 0;
        int R = 1;
        while(R<arrs.length){
            if(arrs[L]==arrs[R]){
                R++;
            }else{
                freqChars.add(Map.entry(R-L,arrs[L]));
                L = R;
                R++;
            }
        }
        freqChars.add(Map.entry(R-L,arrs[L]));

        StringBuilder stringBuilder = new StringBuilder();
        while(!freqChars.isEmpty()){
            Map.Entry<Integer,Character> entry = freqChars.poll();
            for(int i=0;i<entry.getKey();i++){
                stringBuilder.append(entry.getValue());
            }
        }

        return stringBuilder.toString();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
