package leetcode.simple;

import java.util.Arrays;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new MyTest().reverseWords("a"));
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

        s = s.trim();
        if(s.length()==1) return s;

        int L = 0;
        int R = s.length() - 1;

        StringBuilder stringBuilder = new StringBuilder();
        while (L>=0&&L<R) {

            while (R > 0 && !isValid(s.charAt(R))) {
                R--;
            }

            L = R;
            while(L>=0 && isValid(s.charAt(L))){
                L--;
            }

            if(L>=-1&&L<R){
                stringBuilder.append(s.substring(L>=0&&isValid(s.charAt(L))?L : L+1,isValid(s.charAt(R))?R+1:R)).append(" ");
                R = L>=0&&isValid(s.charAt(L))?L-1:L;
                L = R-1;
            }
        }
        return stringBuilder.toString().trim();
    }

    private boolean isValid(Character c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
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