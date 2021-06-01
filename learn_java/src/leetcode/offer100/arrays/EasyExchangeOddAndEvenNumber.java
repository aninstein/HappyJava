package leetcode.offer100.arrays;

import leetcode.offer100.base.Utils;

public class EasyExchangeOddAndEvenNumber {

    /**
     * 题目：剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     * 题目链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
     * 分类：双指针，数组
     *
     * 数组思路（效率低）
     * 解法1：用空间换时间做法，就是新建一个数组，copy一份，先计算出奇数的个数，也就是能够知道第一个偶数应该放在数组的哪一个位置，然后再遍历一次，依次放到对应的位置即可。
     * 解法2：第二种做法，时间复杂度为O(n^2),类似冒泡，将找到的奇数不断往前面冒泡，直到前面排好奇数的位置。
     *
     * 双指针思路
     * 解法1：
     * 定义头指针 left ，尾指针 right .
     * left 一直往右移，直到它指向的值为偶数
     * right 一直往左移， 直到它指向的值为奇数
     * 交换 nums[left] 和 nums[right] .
     * 重复上述操作，直到 left==right
     *
     * 解法2：
     * 定义快慢双指针 fast 和 low ，fast 在前， low 在后 .
     * fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
     * fast 向前移动，当它搜索到奇数时，将它和 nums[low] 交换，此时 low 向前移动一个位置 .
     * 重复上述操作，直到 fast 指向数组末尾 .
     *
     *
     * @param nums
     * @return
     */
    public static int[] exchangeByArray(int[] nums) {
        // 使用数组排序的方式进行排序，效率较低
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int indexOfOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                for (int j = i; j > indexOfOdd; j--) {
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
                indexOfOdd++;
            }
        }
        return nums;
    }

    public static int[] exchangeByFastLowPoint(int[] nums) {
        // 使用快慢指针，从上面的数组排序的方法当中，发现其实并不需要冒泡，可以从左到右的遍历的话，直接进行调换奇数和偶数
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int fast = 0, low = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 != 0) {
                Utils.swapArray(nums, fast, low);
                low++;
            }
            fast++;
        }
        return nums;
    }

    public static int[] exchangeByRightLeftPoint(int[] nums) {
        // 使用左右指针
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            Utils.swapArray(nums, right, left);
        }
        return nums;
    }


    public static void main(String[] args) {

    }

}
