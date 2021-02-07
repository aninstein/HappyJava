package leetcode.classic;

public class EasyMaxSubArray {

    /**
     * 题目：剑指 Offer 42. 连续子数组的最大和
     * 题目链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/

     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;

    }

    public static void main(String[] args) {

    }

}
