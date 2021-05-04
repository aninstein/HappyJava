package leetcode;

import java.util.Arrays;

/*
* 题目： 种花问题
* 题目链接：https://leetcode-cn.com/problems/can-place-flowers/
* */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 0) {
            return false;
        } else if (flowerbed.length == 1) {
            if (n == 1) {
                return flowerbed[0] == 0;
            }
            return false;
        }
        int count=0;
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }
        flowerbed = arrayAppend(flowerbed, 0);
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i] == 1){
                continue;
            }
            if (flowerbed[i-1]==0 && flowerbed[i+1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }

    /**
     * 官方题解： leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode-solution-sojr/
     */
    public static boolean canPlaceFlowersLeetcode(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1,0,0};
        int n = 2;
        boolean res = canPlaceFlowers(flowerbed, n);
        System.out.println(res);
    }

}
