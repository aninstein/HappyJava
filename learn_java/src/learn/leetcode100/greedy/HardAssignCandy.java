package learn.leetcode100.greedy;

public class HardAssignCandy {

    public static int assignCandy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int dataLen = ratings.length;
        int[] candys = new int[dataLen];
        for (int i = 0; i < dataLen; i++) {
            candys[i] = 1;
        }

        for (int i = 1; i < dataLen; i++) {
            if (ratings[i] > ratings[i-1]) {
                candys[i] += candys[i-1];
            }
        }

        int sum = candys[dataLen-1];
        for (int i = dataLen-1; i > 0; i--) {
            if (ratings[i] < ratings[i-1]) {
                candys[i-1] = Math.max(candys[i-1], candys[i] + 1);  // 如果已经比前一个大了，这时候就不需要加了
            }
            sum += candys[i-1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] data = {1, 0, 2};
        int res = assignCandy(data);
        System.out.println(res);
    }

}
