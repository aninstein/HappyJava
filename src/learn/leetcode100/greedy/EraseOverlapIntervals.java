package learn.leetcode100.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    /*
    * 题目：无重叠区间
    * 题目链接：https://leetcode-cn.com/problems/non-overlapping-intervals/
    * */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Comparator<Integer> sortByLast = (Integer[] s1, Integer[] s2) -> (s1[1] > s2[1]);
        Arrays.sort(intervals, (int i1, int i2) -> (i1[1] > i2[1]));

        return 1;
    }

    public static void main(String[] args) {

    }

}
