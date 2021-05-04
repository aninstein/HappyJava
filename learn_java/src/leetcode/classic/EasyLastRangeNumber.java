package leetcode.offer100.classic;

public class EasyLastRangeNumber {

    /**
     * 约瑟夫环问题
     * 题目：剑指 Offer 62. 圆圈中最后剩下的数字
     * 题目链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
     *
     * 约瑟夫环问题一般用的就是数学里面的迭代法
     *
     *
     *
     * @param n 圈一共有n个
     * @param m 每隔m个移除一个数字
     * @return 剩余的最后一个数字
     */
    public static int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

    public static void main(String[] args) {

    }

}
