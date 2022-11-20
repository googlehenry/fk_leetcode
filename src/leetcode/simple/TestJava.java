package leetcode.simple;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        ListNode nodeA = new ListNode(1, new ListNode(2,new ListNode(4,null)));
        ListNode nodeB = new ListNode(1, new ListNode(3,new ListNode(4,null)));
        System.out.println(new TestJava().mergeTwoLists(nodeA,nodeB));
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
     * 双链表合并一种解法是实质上是把一个链表的数据插入到另一个链表。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode node2) {
        ListNode toBeInsertedNode = list1;

        ListNode newRootList = node2;

        while(toBeInsertedNode!=null){



            //insert into newRootList

            ListNode findThePointNode = newRootList;
            ListNode findThePrevNode = null;

            while(findThePointNode != null &&  findThePointNode.val<=toBeInsertedNode.val ){
                findThePrevNode = findThePointNode;
                findThePointNode = findThePointNode.next;
            }

            if(findThePrevNode==null){
                //new head
                newRootList = new ListNode(toBeInsertedNode.val, findThePointNode);
            }else{
                //append
                findThePrevNode.next = new ListNode(toBeInsertedNode.val, findThePointNode);
            }



            toBeInsertedNode = toBeInsertedNode.next;
        }


        return newRootList;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
