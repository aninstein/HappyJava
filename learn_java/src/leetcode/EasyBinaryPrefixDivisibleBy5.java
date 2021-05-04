package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EasyBinaryPrefixDivisibleBy5 {

    /*
    * 题目：可被 5 整除的二进制前缀
    * 题目链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
    * 这里面不能够使用强制转换法
    * 对于Integer.parseInt方法只能够处理低于32位进制的二进制字符串
    * 而即使是Long.parseLong也只能够处理64位的字符串
    *
    * 这个地方只能用数学推倒法：
    * （1）设N[i]为数组A[i]的二进制数，则有：
    * 当i=0，N[0] = A[0]
    * 当i>0，N[i] = N[i-1] * 2 + A[i]  // 这里面的A[i]即个位数
    *
    * 原则上，我们只需要计算N[i] % 5是否为0即可，但这个N[i]可能很长，会导致溢出
    *
    * （2）解决溢出问题，我们应该只需要保留N[i] % 5的余数即可
    * 设M[i]为N[i] % 5的余数，则有：
    * 当i=0的时候，M[0] = N[0] % 5 = A[0] % 5 = A[0]  // 即因为A[0]一定是小于5的
    * 当i>0的时候，
    * M[i] = N[i] % 5
    * M[i] = (N[i-1] * 2 + A[i]) % 5
    * M[i] = (N[i-1] * 2) % 5 + A[i] % 5
    * 即，只需要不断记录前一个值的除以5的余数结果即可
    * */
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] data = {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
        List<Boolean> res = prefixesDivBy5(data);
        StringBuilder resStr = new StringBuilder();
        for (boolean val: res) {
            resStr.append(val);
            resStr.append(", ");
        }
        System.out.println(resStr.toString());
    }

}
