package leetcode.classic;

public class MidLengthOfLIS {

    /**
     * 最长递增子序列问题
     * 题目链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * @param nums
     * @return
     */
    public static int lengthOfLISByDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static int lengthOfLISByGreedy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] d = new int[nums.length + 2];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];  // ++len是先返回len+1，再执行len+1；len++是先返回len，再执行len+1
                continue;
            }
            searchTwo(nums, d, len, i);
        }
        return len;
    }

    public static void searchTwo(int[] nums, int[] d, int len, int i) {
        // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
        int l = 1, r = len, pos = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (d[mid] < nums[i]) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        d[pos + 1] = nums[i];
    }

    public static void main(String[] args) {
        int[] data = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISByDP(data));
        System.out.println(lengthOfLISByGreedy(data));
        // 最长递增子序列是 [2,3,7,101]，因此长度为 4
    }

}
