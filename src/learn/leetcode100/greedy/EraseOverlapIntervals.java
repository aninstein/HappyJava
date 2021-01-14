package learn.leetcode100.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    /*
    * 题目：无重叠区间
    * 题目链接：https://leetcode-cn.com/problems/non-overlapping-intervals/
    *
    * 题解：
    * 在选择要保留区间时，区间的结尾十分重要：
    * 选择的区间结尾越小，余留给其它区间的空间就越大，就越能保留更多的区间。
    *
    * 因此，我们采取的贪心策略为：优先保留结尾小且不相交的区间。
    *
    * 具体实现方法为，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选择的区间不重叠的区间。
    * 我们这里使用Lambda，进行自定义排序。
    *
    * 在样例中，排序后的数组为[[1,2],[1,3],[2,4]]。
    * 按照我们的贪心策略，首先初始化为区间[1,2]；由于[1,3]与[1,2]相交，我们跳过该区间；
    * 由于[2,4]与[1,2]不相交，我们将其保留。
    * 因此最终保留的区间为[[1,2],[2,4]]。
    * */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // lambda表达式，按照那结尾排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int dataLen = intervals.length;
        int removeNumber = 0;
        int prev = intervals[0][1];  // 第一个区间的结尾，当下一个区间的开头小于这个结尾的时候就表示有重叠
        for (int i = 1; i < dataLen; i++) {
            if (intervals[i][0] < prev) {
                removeNumber++;
            } else {
                prev = intervals[i][1];
            }
        }
        return removeNumber;
    }

    public static void main(String[] args) {
        int[][] data = {{1,2}, {2,3}, {3,4}, {1,3}};
        int res = eraseOverlapIntervals(data);
        System.out.println(res);
    }

}
