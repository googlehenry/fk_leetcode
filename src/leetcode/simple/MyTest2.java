package leetcode.simple;

import java.util.List;

public class MyTest2 {

    public static void main(String[] args) throws InterruptedException {
        new MyTest2().reverseBetween(new ListNode(3,new ListNode(4,null)),1,2);
    }

    /**
     * 92. 反转链表 II
     * 中等
     * 1.5K
     * 相关企业
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 示例 2：
     *
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null || head.next==null) return head;
        if(left>=right)return head;

        ListNode prev = null;
        ListNode mid = null;
        ListNode tail = null;
        int counter = 0;
        while(counter<right){
            if(counter<left) {
                if(mid!=null) {
                    prev =  prev == null ? head : prev.next;
                }
                mid = mid == null ? head : mid.next;
            }
            if(counter<=right){
                tail = tail==null?head:tail.next;
            }
            counter++;
        }

        if(prev!=null) {
            prev.next = null;
        }else{
            head = null;
        }
        ListNode remaining = tail.next;
        tail.next = null;


        //reverse mid

        ListNode tempHead = mid;
        ListNode second = mid.next;
        tempHead.next = null;

        while(second!=null){
            ListNode temp = second.next;
            second.next = tempHead;
            tempHead = second;

            second = temp;
        }

        if(prev!=null) {
            prev.next = tempHead;
            mid.next = remaining;
            return head;
        }else{
            mid.next = remaining;
            return tempHead;
        }
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