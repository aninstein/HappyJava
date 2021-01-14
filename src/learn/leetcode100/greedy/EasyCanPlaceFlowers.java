package learn.leetcode100.greedy;

public class EasyCanPlaceFlowers {

    /*
    * 题目：种花问题
    * 题目链接：https://leetcode-cn.com/problems/can-place-flowers/
    *
    * 贪心策略：
    * */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int dataLen = flowerbed.length;
        for (int i = 0; i < dataLen; i += 2) {
            if (flowerbed[i] != 0) {
                continue;
            }
            if (i == dataLen - 1 || flowerbed[i+1] == 0) {
                n--;
                continue;
            }
            i++;
        }
        return n <= 0;
    }

    public static void main(String[] args) {

    }

}
