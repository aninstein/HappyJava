package learn.leetcode100.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MidFindMinArrowShots {

    /*
    * 题目：用最少数量的箭引爆气球
    * 题目链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
    *
    * 此题与435题：https://leetcode-cn.com/problems/non-overlapping-intervals/非常像
    * 但是不一样的是，435求的是不同区间，本题求的是有共同重叠的区间，两者在解题手法上，区别在于：
    * 求共同区间：我们尽可能的把数据凑在一个位置，因此我们对区间的开始位进行排序
    * 求不重叠区间：我们尽可能的把数据分离开来，所以我们对区间的结束位置进行排序
    *
    * 贪心策略：每一次射箭的位置是射在：起始位最小的堆区间里面，最小的结束位
    * */
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // lambda对数据进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
