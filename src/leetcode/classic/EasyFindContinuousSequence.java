package leetcode.classic;

import java.util.ArrayList;
import java.util.List;

public class EasyFindContinuousSequence {

    /**
     * 题目：剑指 Offer 57 - II. 和为s的连续正数序列
     * 题目链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/submissions/
     *
     * 方法一：枚举 + 暴力
     *
     * 枚举每个正整数为起点，判断以它为起点的序列和 sum\textit{sum}sum 是否等于 target\textit{target}target 即可
     * 由于题目要求序列长度至少大于 222，所以枚举的上界为 [target/2]。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int sum = 0, limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int i = 1; i <= limit; ++i) {
            for (int j = i;; ++j) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    public static void main(String[] args) {

    }

}
