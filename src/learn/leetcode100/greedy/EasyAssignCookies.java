package learn.leetcode100.greedy;


import java.util.Arrays;

/**
 * 题目：分发饼干
 * 题目链接：https://leetcode-cn.com/problems/assign-cookies/
 * 贪心策略：就是给最饿的小孩最小能够满足他的饼干
 */
public class EasyAssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int res = findContentChildren(g, s);
        System.out.println(res);
    }
}
