package leetcode.offer100.lcstring;

import java.util.*;

/**
 * 题目：剑指 Offer 58 - I. 翻转单词顺序
 * 题目链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 */
public class EasyReverseWords {

    public static String reverseWords(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        s = s.trim();
        String[] strArray = s.split(" ");
        // List<String> strList = Arrays.asList(strArray);
        // Collections.reverse(strList);
        // String[] newStrArray = strList.toArray(new String[0]);  // 这里不能直接就转成字符串数组了，他这个测试用例比较骚
        List<String> strList = new ArrayList<>();
        for (int i = strArray.length - 1; i >= 0 ; i--) {
            String newStr = strArray[i];
            if (newStr.equals("")) {
                continue;
            }
            strList.add(newStr);
        }

        return String.join(" ", strList);
    }

    /**
     * 翻转单词，不使用split方法，纯粹的使用字符判断
     * @param s
     * @return
     */
    public static String reverseWordsNoSplit(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        s = s.trim();
        int sLen = s.length();
        StringBuilder oneStr = new StringBuilder();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                String newStr = oneStr.toString();
                if (!newStr.equals("")) {
                    strList.add(newStr);
                    oneStr = new StringBuilder("");
                }
                continue;
            }
            oneStr.append(ch);
            if (i == sLen - 1) {
                String newStr = oneStr.toString();
                if (!newStr.equals("")) {
                    strList.add(newStr);
                }
            }
        }
        StringBuilder retStr = new StringBuilder();
        for (int i = strList.size() - 1; i >= 0; i--) {
            retStr.append(strList.get(i));
            if (i != 0) {
                retStr.append(" ");
            }
        }
        return retStr.toString();
    }

    public static void main(String[] args) {
        String test = "a good   example";
        System.out.println(reverseWordsNoSplit(test));

    }

}
