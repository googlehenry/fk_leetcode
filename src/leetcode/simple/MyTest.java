package leetcode.simple;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(new MyTest().findCircleNum(isConnected));
    }

    /**
     * 547. 省份数量
     * 中等
     * 898
     * 相关企业
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     *
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     *
     * 返回矩阵中 省份 的数量。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     *
     *
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        //init
        int[] roots = new int[isConnected.length];
        init(roots);

        //union
        for(int i=0;i<isConnected.length;i++){
            int[] row = isConnected[i];
            for(int j=0;j<row.length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    union(i,j,roots);
                }
            }
        }

        for(int i=0;i<roots.length;i++){
            roots[i] = find(roots[i],roots);
        }

        return (int)Arrays.stream(roots).distinct().count();

    }

    private void init(int[] roots){
        for(int i=0; i<roots.length; i++){
            roots[i] = i;
        }
    }

    private int find(int x,int[] roots){
        if(roots[x]==x){
            return x;
        }else{
            roots[x] = find(roots[x], roots);
            return roots[x];
        }
    }

    private void union(int x, int y, int[] roots){
        int xx = find(x,roots);
        int yy = find(y,roots);
        roots[xx] = yy;
    }


}
