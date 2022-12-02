package leetcode.simple;

import com.sun.source.tree.Tree;

import java.awt.geom.Area;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.jar.JarEntry;

public class MyTest {

    public static void main(String[] args) {
        ListNode sorted = new MyTest().sortList(new ListNode(1,new ListNode(6,new ListNode(2,new ListNode(9, new ListNode(5,new ListNode(2)))))));
        System.out.println(sorted);
    }

    /**
     * 148. 排序链表
     * 中等
     * 1.8K
     * 相关企业
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //拆两半用归并
        if(head==null || head.next==null)return head;

        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNext = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        ListNode rootDummy = new ListNode();
        ListNode temp = rootDummy;
        //merge
        while(left!=null || right!=null){
            if(left==null){
                temp.next = right;
                right = right.next;
            }else if(right==null){
                temp.next = left;
                left = left.next;
            }else{
                if(left.val< right.val){
                    temp.next = left;
                    left = left.next;
                }else{
                    temp.next = right;
                    right = right.next;
                }
            }
            temp = temp.next;
        }

        return rootDummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
