package leetcode.classic;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：剑指 Offer 38. 字符串的排列
 * 题目链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 *
 */
public class MidPermutation {

    public static String[] permutation(String s) {

        if (s == null || s.equals("")) {
            return new String[0];
        }
        String[] charArray = s.split("");
        List<String> result = new LinkedList<>();
        dfs(charArray, result, 0);
        return result.toArray(new String[0]);
    }


    public static void dfs(String[] charArray, List<String> result, int index) {
        if (index == charArray.length - 1) {
            String addStr = String.join("", charArray);
            result.add(addStr);
            return;
        }

        HashSet<String> charSet = new HashSet<>();

        // 这个i得从index开始，不然的话数据每一次都是从头来一次
        for (int i =index; i < charArray.length; i++) {
            if (charSet.contains(charArray[i])) {  // 剪枝，主要是对付类似输入：abb，这里面有bb这个重复的字符的
                continue;
            }
            charSet.add(charArray[i]);
            swapArray(charArray, index, i);
            dfs(charArray, result, index + 1);
            swapArray(charArray, index, i);
        }
    }

    private static void swapArray(String[] charArray, int x, int y) {
        String temp = charArray[x];
        charArray[x] = charArray[y];
        charArray[y] = temp;
    }

    public static void main(String[] args) {
        String[] res = permutation("abc");
        for (String i: res) {
            System.out.println(i);
        }
    }

}
