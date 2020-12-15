package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*
* 题目：单词匹配
* 题目链接：https://leetcode-cn.com/problems/word-pattern/
* 输入："abba"
*      "dog dowg dowg dog"
*
* 输出：false
* */
public class WordPatten {

    public static void main(String[] args) {
        String p = "abc";
        String s = "dog dowg dog";
        boolean res = wordPattern(p, s);
        System.out.println(res);
    }

    public static boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] stringArray = s.split(" ");
        if (stringArray.length != charArray.length) {
            return false;
        }
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> stringMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            Character patternChar = (Character) charArray[i];
            String stringWord = stringArray[i];
            if (patternMap.containsKey(patternChar)){
                if (!patternMap.get(patternChar).equals(stringWord)) {
                    return false;
                }
            } else {
                patternMap.put(patternChar, stringWord);
            }

            if (stringMap.containsKey(stringWord)){
                if (!stringMap.get(stringWord).equals(patternChar)) {
                    return false;
                }
            } else {
                stringMap.put(stringWord, patternChar);
            }
        }
        return true;
    }

}
