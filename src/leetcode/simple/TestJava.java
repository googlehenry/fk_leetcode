package leetcode.simple;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().isSymmetric(new TreeNode(2)));
    }

    /**
     * 101. 对称二叉树
     * 简单
     * 2.2K
     * 相关企业
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * @param root
     * @return
     * 那就是左右2棵树比较。
     */
    public boolean isSymmetric(TreeNode root) {
        return compareNodes(root.left,root.right);
    }

    private boolean compareNodes(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }else if(left==null || right==null){
            return false;
        }else if(left.val!=right.val){
            return false;
        }else{
            return compareNodes(left.left,right.right) && compareNodes(left.right,right.left);
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
