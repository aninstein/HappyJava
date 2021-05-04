package leetcode.classic;

public class MidMaxSubSum {

    /**
     * 1. 集合
     *  - 需要遍历的内容
     *  这个数组
     *
     *
     * 2. 状态
     *  - dp数组中值得含义
     *  dp的值就是就是最大和
     *
     * 3. 确定状态转移方程
     *  - 当满足什么条件的时候，状态需要从j转移到i
     *  dp[i] = max(dp[])
     *
     * @param data
     * @return
     */
    public static int maxSubSum(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubSum(data));
    }

}
