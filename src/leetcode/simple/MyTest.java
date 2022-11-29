package leetcode.simple;

import java.util.*;

public class MyTest {

    public static void main(String[] args) {
        System.out.println(new MyTest().multiply("123","456"));
    }

    /**
     * 43. 字符串相乘
     * 中等
     * 1.1K
     * 相关企业
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        //123
        //456
        //----
        //..8...1
        //.0+1...0

        if(num1.equals("0")||num2.equals("0"))return "0";

        //123*456=123*6+123*500+123*400
        int i = num1.length()-1;

        StringBuilder prevValue = new StringBuilder();
        while(i>=0){
            int n = num1.charAt(i)-'0';
            StringBuilder stepValue = new StringBuilder();
            for(int k=num1.length()-1;k>i;k--){
                stepValue.append('0');
            }
            int carry = 0;
            int total = 0;
            for(int j=num2.length()-1;j>=0;j--){
                int m = num2.charAt(j)-'0';
                total = m*n+carry;
                carry = total / 10;
                total = total % 10;

                stepValue.append(total);
            }
            if(carry>0){
                stepValue.append(carry);
            }

            //add with prev step
            prevValue = addUp(prevValue,stepValue.reverse());

            i--;
        }


        return prevValue.toString();
    }

    private StringBuilder addUp(StringBuilder prevSum,StringBuilder stepValue){
        if(prevSum.isEmpty())return stepValue;

        String a = prevSum.toString();
        String b = stepValue.toString();

        int i = a.length()-1,j=b.length()-1;
        int sum = 0;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i>=0||j>=0){
            sum +=carry;
            if(i>=0){
                sum+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum+=b.charAt(j)-'0';
                j--;
            }
            carry = sum/10;
            sum = sum%10;

            result.append(sum);

            sum = 0;
        }
        if(carry>0){
            result.append(carry);
        }
        return result.reverse();
    }
}
