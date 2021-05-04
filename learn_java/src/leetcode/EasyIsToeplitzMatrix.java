package leetcode;

public class EasyIsToeplitzMatrix {

    /**
     * 题目：托普利茨矩阵
     * 题目链接：https://leetcode-cn.com/problems/toeplitz-matrix/
     * @param matrix
     * @return
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row_len = matrix.length;
        int col_len = matrix[0].length;
        for (int i = 0; i < row_len; i++) {
            int row = i, col = 0;
            int index = matrix[row++][col++];
            while (row < row_len && col < col_len) {
                if (index != matrix[row++][col++]) {
                    return false;
                }
            }
        }

        for (int i = 1; i < col_len; i++) {
            int row = 0, col = i;
            int index = matrix[row++][col++];
            while (row < row_len && col < col_len) {
                if (index != matrix[row++][col++]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
