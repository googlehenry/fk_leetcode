package leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {
        new MyTest().letterCombinations("23").forEach((it)->System.out.println(it));
    }
    String[] arrs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();

    /**
     * 回溯，暴力递归，动态层数的循环。电话号码盘。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        StringBuilder stringBuilder = new StringBuilder();

        if(digits.length()==0){
            return res;
        }
        processOneText(digits,0,stringBuilder);

        return res;
    }

    private void processOneText(String digits,int idx, StringBuilder stringBuilder) {

        if(idx==digits.length()){
            res.add(stringBuilder.toString());
            return ;
        }
        String text = arrs[digits.charAt(idx)-'0'];
        for(int i=0;i<text.length();i++){
            stringBuilder.append(text.charAt(i));
            processOneText(digits,idx+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }


}
