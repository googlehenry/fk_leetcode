package leetcode.simple;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        ListNode rs = new MyTest().swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null)))));
        System.out.println(rs);
    }

    /**
     * 24. 两两交换链表中的节点
     * 中等
     * 1.6K
     * 相关企业
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     * @param head
     * @return
     * 链表很关键的是当前节点值，看看处理单位是一个元素一组还是2个。
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode newHead = head.next.next;
        ListNode a = head;
        ListNode b = head.next;


        a.next = swapPairs(newHead);
        b.next = a;

        return b;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
