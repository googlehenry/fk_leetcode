package leetcode.simple;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().convert("AB",1));
    }

    /**
     * 6. Z 字形变换
     * 中等
     * 1.9K
     * 相关企业
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     * @param s
     * @param numRows
     * @return
     *
     * 利用二位表暴力排布
     */
    public String convert(String s, int numRows) {
        Character[][] arrs = new Character[numRows][s.length()];
        int row = 0;
        int col = 0;
        int step = 1;
        int idx = 0;
        while(idx<s.length()){
            arrs[row][col] = s.charAt(idx);

            if(numRows==1){
                step = 0;
                col++;
            }
            else if(row==numRows-1){
                step = -1;
                col++;
            }else if(row==0){
                step = 1;
                col++;
            }
            row += step;
            idx++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                if(arrs[i][j]!=null) stringBuilder.append(arrs[i][j]);
            }
        }

        return stringBuilder.toString();

    }

}
