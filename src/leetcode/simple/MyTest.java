package leetcode.simple;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        ListNode rs = new MyTest().reverseList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null)))));
        System.out.println(rs);
    }

    /**
        //链表逆序
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        //1->2->3->4
        //2->1->3->4
        ListNode tempHead = head;
        ListNode tobeSwaped = head.next;
        head.next = null;
        ListNode remainingHead = null;
        while(tobeSwaped!=null){
            //change this and second
            remainingHead = tobeSwaped.next;
            tobeSwaped.next = tempHead;
            tempHead = tobeSwaped;
            tobeSwaped = remainingHead;
        }

        return tempHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
