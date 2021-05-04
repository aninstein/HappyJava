package leetcode.offer100;

public class EasyPrintNumbers {

    public static int[] printNumbers(int n) {
        int maxNumber = (int)Math.pow(10, n);
        int[] retData = new int[maxNumber-1];
        for (int i = 1; i < maxNumber; i++) {
            retData[i-1] = i;
        }
        return retData;
    }

    public static void main(String[] args) {

    }

}
