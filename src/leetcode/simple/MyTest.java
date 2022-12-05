package leetcode.simple;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new MyTest().reverseWords("the sky is blue"));
    }

    /**
     * 151. 反转字符串中的单词
     * 中等
     * 706
     * 相关企业
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     *
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     *
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     *
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     *
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：反转后的字符串中不能存在前导空格和尾随空格。
     * 示例 3：
     *
     * 输入：s = "a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
     * 双指针
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = " "+ s;
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int left = n-1,right=n;left>=0;left--){
            if(s.charAt(left)==' '){
                if(left+1<right){
                    stringBuilder.append(s.substring(left+1,right)).append(" ");
                }
                right = left;
            }
        }

        return stringBuilder.toString().trim();
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