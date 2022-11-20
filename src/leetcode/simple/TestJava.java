package leetcode.simple;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        ListNode nodeA = new ListNode(1, new ListNode(2,new ListNode(4,null)));
        ListNode nodeB = new ListNode(1, new ListNode(3,new ListNode(4,null)));
        ListNode rs = new TestJava().mergeTwoLists(nodeA,nodeB);
        System.out.println(rs);
    }

    /**
     * 21. 合并两个有序链表
     * 简单
     * 2.8K
     * 相关企业
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * @param list1
     * @param node2
     * @return
     *
     * 递归，两个，比较当前节点大小，根据结果递归设置节点的下一跳为自己的下一跳或者另一个。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list2.next,list1);
            return list2;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
