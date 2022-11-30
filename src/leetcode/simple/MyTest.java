package leetcode.simple;

import java.lang.reflect.Array;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().intToRoman(1994));
    }

    /**
     12. 整数转罗马数字
     中等
     1K
     相关企业
     罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给你一个整数，将其转为罗马数字。



     示例 1:

     输入: num = 3
     输出: "III"
     示例 2:

     输入: num = 4
     输出: "IV"
     示例 3:

     输入: num = 9
     输出: "IX"
     示例 4:

     输入: num = 58
     输出: "LVIII"
     解释: L = 50, V = 5, III = 3.
     示例 5:

     输入: num = 1994
     输出: "MCMXCIV"
     解释: M = 1000, CM = 900, XC = 90, IV = 4.

     //从1000-1开始相除，整数部分是几个罗马单位，剩下部分为低位；再循环。
     */
    public String intToRoman(int num) {
        TreeMap<Integer,String> romes = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        romes.put(1000,"M");
        romes.put(500,"D");
        romes.put(100,"C");
        romes.put(50,"L");
        romes.put(10,"X");
        romes.put(5,"V");
        romes.put(1,"I");
        romes.put(4,"IV");
        romes.put(9,"IX");
        romes.put(40,"XL");
        romes.put(90,"XC");
        romes.put(400,"CD");
        romes.put(900,"CM");

        int n = num;

        StringBuilder stringBuilder = new StringBuilder();
        for(int element:romes.keySet()){
            //2333 /1000=2 ... 333
            for(int i=0;i< n/element;i++){
                stringBuilder.append(romes.get(element));
            }
            n = n % element;
        }


        return stringBuilder.toString();

    }

}
