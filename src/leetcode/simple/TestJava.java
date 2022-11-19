package leetcode.simple;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestJava {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TestJava().equalFrequency("bac"));
    }

    /**
     * 2423. 删除字符使频率相同
     * 简单
     * 15
     * 相关企业
     * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
     *
     * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
     *
     * 注意：
     *
     * 字母 x 的 频率 是这个字母在字符串中出现的次数。
     * 你 必须 恰好删除一个字母，不能一个字母都不删除。
     *
     *
     * 示例 1：
     *
     * 输入：word = "abcc"
     * 输出：true
     * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
     * 示例 2：
     *
     * 输入：word = "aazz"
     * 输出：false
     * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
     *
     *
     * 暴力破解，那就删除一个字母，把剩下的统计一下看看是不是一样的。
     */
    public boolean equalFrequency(String word) {
        Map<Character,Integer> counter = new HashMap<>();
        for(int i=0;i<word.length();i++){
            counter.put(word.charAt(i), counter.get(word.charAt(i))==null?1:counter.get(word.charAt(i))+1);
        }

        List<Integer> freqList = new ArrayList<Integer>(counter.values()).stream().sorted().toList();
        //[1,1,1,2,3]

        if(freqList.get(0)==1){
            //后面必须一致,return true
            if(freqList.size()>1) {
                Integer keep = freqList.get(1);
                boolean match = true;
                for (int i = 1; i < freqList.size(); i++) {
                    if(freqList.get(i)!=keep){
                        match= false;
                        break;
                    }
                }

                if(!match) {
                    match = true;
                    Integer keep2 = freqList.get(freqList.size() - 1) - 1;
                    if (freqList.size() > 1) {
                        for (int i = freqList.size() - 2; i >= 0; i--) {
                            if (freqList.get(i) != keep2) {
                                match= false;
                                break;
                            }
                        }
                    }
                }

                return match;
            }
            return true;
        }else {
            Integer keep = freqList.get(freqList.size()-1)-1;
            if(freqList.size()>1) {
                for (int i = freqList.size() - 2; i >= 0; i--) {
                    if (freqList.get(i) != keep) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

}
