package leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new MyTest().lengthOfLongestSubstring("tmmzuxt"));
    }


    /**最长不重复子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        String max = "";
        Map<Character,Integer> idxMap = new HashMap<>();
        for (int i = 0, j = 0; i < s.length()&&j<s.length(); j++) {
            Integer prevIdx = idxMap.get(s.charAt(j));
            if(prevIdx!=null){
                i = Math.max(i,prevIdx+1);
            }
            if(max.length()<j-i+1){
                max = s.substring(i,j+1);
            }
            idxMap.put(s.charAt(j),j);
        }
        return max.length();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}