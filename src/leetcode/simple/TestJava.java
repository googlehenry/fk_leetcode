package leetcode.simple;

import java.util.Stack;
import java.util.TreeSet;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().addBinary("1111","1111"));
    }

    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1;
        StringBuilder bitsResult = new StringBuilder();
        int borrow = 0;
        while( i >= 0 || j >= 0){
            int sumBit = 0;
            Integer aBit = 0;
            if(i>=0){
                aBit = a.charAt(i) - '0';
            }
            Integer bBit = 0;
            if(j>=0){
                bBit = b.charAt(j) - '0';
            }

            sumBit = aBit + bBit + borrow;

            if(sumBit>=2){
                borrow = 1;
            }else{
                borrow = 0;
            }
            sumBit = sumBit % 2;

            bitsResult.append(sumBit);

            j--;
            i--;
        }
        if(borrow>0) {
            bitsResult.append(borrow);
        }

        return bitsResult.reverse().toString();

    }
}
