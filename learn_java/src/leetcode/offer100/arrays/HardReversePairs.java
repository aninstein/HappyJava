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

        int mid = Utils.minNumber(0, len);
        mergeSort(nums, 0, mid);
        return 0;
    }

    public static void mergeSort(int[] nums, int left, int right) {

    }

    public static void main(String[] args) {

    }
}
