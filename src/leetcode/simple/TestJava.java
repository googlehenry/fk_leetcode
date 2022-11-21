package leetcode.simple;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {

        try{
            throw new Error("testing");
        }catch (Throwable t){
            t.printStackTrace();
        }
        System.out.println(new TestJava().bfs(new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,new TreeNode(5, new TreeNode(7),new TreeNode(8)),new TreeNode(6)))));
    }

    /**
     * BFS
     */
    public boolean bfs(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        ArrayList<TreeNode> rsNodes = new ArrayList<>();
        while(!nodes.isEmpty()){
            TreeNode head = nodes.poll();
            rsNodes.add(head);
            if(head.left!=null){
                nodes.add(head.left);
            }
            if(head.right!=null){
                nodes.add(head.right);
            }
        }

        return rsNodes.isEmpty();

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
