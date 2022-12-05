package leetcode.simple;

import java.util.Arrays;

public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        new MyTest().middleNode(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5,new ListNode(6, null)))))));
    }

    /**
     * 876. 链表的中间结点
     * 简单
     * 748
     * 相关企业
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        //快慢指针
        if(head==null||head.next==null) return head;

        ListNode slow = head, fast = head.next;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        return fast==null?slow:slow.next;
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