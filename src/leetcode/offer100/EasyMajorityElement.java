package leetcode.offer100;
import leetcode.offer100.base.utils;

public class EasyMajorityElement {

    /**
     * 题目：剑指 Offer 39. 数组中出现次数超过一半的数字
     * 题目链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
     * 1. hash表统计
     * 2. 排序后用二分查找，左闭右闭的方式进行搜索
     * 3. 投票假设法
     *
     * 第三种效率最高：
     * （1）两个推论：
     * - 推论一： 若记 众数 的票数为 +1+1+1 ，非众数 的票数为 −1-1−1 ，则一定有所有数字的 票数和 >0> 0>0 。
     * - 推论二： 若数组的前 aaa 个数字的 票数和 =0= 0=0 ，则 数组剩余 (n−a)(n-a)(n−a) 个数字的 票数和一定仍 >0>0>0 ，即后 (n−a)(n-a)(n−a) 个数字的 众数仍为 xxx 。
     *
     * （2）一次假设：
     * 根据以上推论，假设数组首个元素 n1n_1n1​ 为众数，遍历并统计票数。当发生 票数和 =0= 0=0 时，剩余数组的众数一定不变 ，这是由于：
     *
     *     当 n1=xn_1 = xn1​=x ： 抵消的所有数字，有一半是众数 xxx 。
     *     当 n1≠xn_1 \neq xn1​​=x ： 抵消的所有数字，少于或等于一半是众数 xxx 。
     *
     * 利用此特性，每轮假设发生 票数和 =0= 0=0 都可以 缩小剩余数组区间 。当遍历完成时，最后一轮假设的数字即为众数
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] data = {3,2,3};
        int res = majorityElement(data);
        System.out.println(res);
    }

}
