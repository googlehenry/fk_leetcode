package leetcode.simple;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().convert("ABC",2));
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
     * 利用字符串优化，给每一个位上的char找行，append排布
     */
    public String convert(String s, int numRows) {
        String[] rows = new String[numRows];

        if(numRows==1) return s;

        int row = 0;
        boolean asc = false;
        for(int i=0;i<s.length();i++){
            //find row, append
            if(row==0||row==numRows-1){
                asc = !asc;
            }
            rows[row]= rows[row]==null?""+s.charAt(i):rows[row]+s.charAt(i);
            row+=asc?1:-1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<rows.length;i++){
            stringBuilder.append(rows[i]==null?"":rows[i]);
        }
        return  stringBuilder.toString();
    }

}
