package leetcode.offer100.lcarrays;


/**
 * 题目：剑指 Offer 42. 连续子数组的最大和
 * 题目链接：https://leetcode-cn.com/problems/maximum-subarray/solution/
 *
 * 1. 暴力解法
 * 2. 动态规划
 * 3. 分治法，这个分治方法类似于「线段树求解最长公共上升子序列问题」的 pushUp 操作（太难了这里不写了），具体看题解：https://leetcode-cn.com/problems/maximum-subarray/solution/
 *
 */
public class EasyMaxSubArraySum {

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public static int maxSubArrayViolence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int tempSum = 0;
            for (int j = i; j < len; j++) {
                tempSum += nums[j];
                if (tempSum > res) {
                    res = tempSum;
                }
            }
        }
        return res;
    }

    /**
     * 动态规划
     * dp[i]数组表示以i结尾的子数组最大和
     *
     * 我们要求的结果是res = max(dp[0...len])
     * 对于i-1状态能不能够转移到i状态，取决于nums[i]加入的情况是不是比nums[i]本身大
     * 即因为dp[i-1]已经是第i-1结尾的子数组最大和，对于nums[i]来说，只有：
     * 1. 自成一段
     * 2. 与dp[i-1]一起构成一段
     * 则有：
     * dp[i] = max(nums[i], dp[i-1] + nums[i])
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        int res = nums[0];  // 第一个数据
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

}
