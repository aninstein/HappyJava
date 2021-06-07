package leetcode.offer100.lcarrays;

public class MidFindNumberIn2DArray {

    /**
     * 题目：剑指 Offer 04. 二维数组中的查找
     * 题目链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
     *
     * 思路
     *
     * 可以直接暴力遍历，但是这样的复杂度在最坏的情况是便利完所有的才能获取结果。如果这个数组规模是n×m，那么复杂度就是O(n×m)。
     * 但是我们换一种思路，我们选定左下角的10(num[2][0],i=2,j=0)作为起点，如果大于10,那么i+1,如果小于10，则j+1，则下一个查找的数字是11,我们知道32仍然比11大，则往右找到67，继而32比67小，我们应该往上找，找到了32。
     * 如果找28，则是最坏的结果，查找知道数组的右上角结束，这样一来，最坏的结果就是O（n+m）。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int startRow = 0, startCol = cols - 1;
        while (startRow < rows && startCol >= 0) {
            int num = matrix[startRow][startCol];
            if (num == target) {
                return true;
            } else if (num > target) {
                startCol--;
            } else {
                startRow++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
