package leetcode.simple;

import java.util.ArrayList;
import java.util.Stack;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));
    }

    /**
     * 2. 两数相加
     * 中等
     * 8.9K
     * 相关企业
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer carry = 0;

        ListNode rs = new ListNode();
        doAdd(l1,l2, carry, rs);


        return rs.next;
    }

    private void doAdd(ListNode l1, ListNode l2, Integer carry, ListNode rs){
        int sumBit = carry;

        if(l1==null&&l2==null && carry==0){
            return;
        }
        if(l1!=null){
            sumBit+=l1.val;
        }
        if(l2!=null){
            sumBit+=l2.val;
        }
        carry = sumBit/10;
        rs.next = new ListNode(sumBit%10);
        doAdd(l1==null?null:l1.next,l2==null?null:l2.next,carry,rs.next);
    }


    public static class ListNode {
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
