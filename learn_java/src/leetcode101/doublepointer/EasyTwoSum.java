package leetcode101.doublepointer;

public class EasyTwoSum {

    /**
     * 题目：两数之和
     * 题目链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     *
     * 双指针法，使用两个指针，一个从后面，一个从前面
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int left = 0, right = numbers.length - 1;
        int offset = 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            }

            if (sum < target) {
                left += offset;
            } else {
                right -= offset;
            }
            offset++;
        }
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {

    }

}
