package leetcode;

public class EasyFlipAndInvertImage {

    /**
     * 832. 翻转图像
     * https://leetcode-cn.com/problems/flipping-an-image/submissions/
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }

}
