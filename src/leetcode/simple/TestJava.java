package leetcode.simple;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().isPathCrossing("NESWW"));
    }

    /**
     * 1496. 判断路径是否相交
     * 简单
     * 41
     * 相关企业
     * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
     *
     * 你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
     *
     * 如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，请返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：path = "NES"
     * 输出：false
     * 解释：该路径没有在任何位置相交。
     * 示例 2：
     *
     *
     *
     * 输入：path = "NESWW"
     * 输出：true
     * 解释：该路径经过原点两次。
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
        Map<Integer,ArrayList<Integer>> pointsMap = new HashMap<>();

        int x=0,y=0;

        ArrayList<Integer> init = new ArrayList<>();
        init.add(y);
        pointsMap.put(0, init);

        for(int i=0;i<path.length();i++){
            Character action = path.charAt(i);
            switch (action){
                case 'N' -> y++;
                case 'S' -> y--;
                case 'E' -> x++;
                default -> x--;
            }

            if(pointsMap.containsKey(x)){
                ArrayList<Integer> ys = pointsMap.get(x)==null?new ArrayList<>():pointsMap.get(x);
                if(ys.contains(y)){
                    return true;
                }else{
                    ys.add(y);
                    pointsMap.put(x, ys);
                }
            }else{
                ArrayList<Integer> ys = new ArrayList<>();
                ys.add(y);
                pointsMap.put(x, ys);
            }
        }
        return false;
    }

}
