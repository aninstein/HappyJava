package learn.leetcode100.doublepointer;

public class EasyMergeArray {

    /**
     * 题目：合并两个有序数组
     * 题目链接：https://leetcode-cn.com/problems/merge-sorted-array/
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--]: nums2[n--];
        }
        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(a++);
        System.out.println(++a);
    }

}
