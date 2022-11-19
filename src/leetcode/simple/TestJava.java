package leetcode.simple;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(new TestJava().binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null))));
    }

    /**
     * 257. 二叉树的所有路径
     * 简单
     * 848
     * 相关企业
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     * 示例 2：
     *
     * 输入：root = [1]
     * 输出：["1"]
     * @param root
     * @return
     *
     * DFS 深度优先算法
     */
    public List<String> binaryTreePaths(TreeNode root) {
        return processNode(root, new ArrayList<>(),new ArrayList<>());
    }

    public ArrayList<String> processNode(TreeNode node, ArrayList<Integer> holder, ArrayList<String> paths){
        holder.add(node.val);

        if(node.left==null && node.right==null){
            //reached end.
            StringBuilder stringBuilder = new StringBuilder();
            for(Integer point:holder){
                stringBuilder.append("->").append(point);
            }
            paths.add(stringBuilder.substring(2));
        }else{
            if(node.left!=null){
                processNode(node.left, holder, paths);
            }
            if(node.right!=null){
                processNode(node.right, holder, paths);
            }

        }

        holder.remove(holder.size()-1);

        return paths;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
