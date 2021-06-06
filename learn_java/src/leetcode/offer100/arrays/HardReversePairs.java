package leetcode.offer100.arrays;


import base.Utils;

/**
 * 题目：剑指 Offer 51. 数组中的逆序对
 * 题目连接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * 方法1：归并排序
 * 方法2：离散化树状数组
 * 官方题解：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
 *
 */
public class HardReversePairs {

    /**
     * 1. 使用归并排序解题
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        int[] temp = new int[len];
        return countReversePairs(nums, temp, 0, len - 1);
    }

    private static int countReversePairs(int[] nums, int[] temp, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = Utils.midNumber(left, right);
        int leftPairs = countReversePairs(nums, temp, left, mid);
        int rightPairs = countReversePairs(nums, temp, mid + 1, right);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = countAndMerge(nums, temp, left, mid, right);
        return leftPairs + crossPairs + rightPairs;
    }

    private static int countAndMerge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

}



