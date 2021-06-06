import base.Utils;

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] data = {-10000, 2, 7, 1, -9, 100, 5400, -471, -1, 0, 0, 21, 3};
        int[] ret = fastSort(data);
        for (int i : ret) {
            System.out.print(i + " ");
        }


    }

    /**
     * 冒泡排序
     * @param data
     * @return
     */
    public static int[] bubbleSort(int[] data){

        if(data == null || data.length == 0){
            return data;
        }

        int dataLen = data.length;
        for (int i = 0; i < dataLen; i++) {
            for (int j = i+1; j < dataLen; j++) {
                if(data[i] > data[j]){
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
        return data;
    }

    /**
     * 选择排序
     * @param data
     * @return
     */
    public static int[] selectSort(int[] data){
        if(data == null || data.length == 0){
            return data;
        }

        int dataLen = data.length;
        for (int i = 0; i < dataLen; i++) {
            int tmp = i;
            for (int j = i+1; j < dataLen; j++) {
                if (data[tmp] > data[j]) {
                   tmp = j;
                }
            }
            if (tmp != i) {
                int t = data[i];
                data[i] = data[tmp];
                data[tmp] = t;
            }
        }
        return data;
    }

    /**
     * 插入排序
     * @param data
     * @return
     */
    public static int[] insertSort(int[] data) {
        if(data == null || data.length == 0){
            return data;
        }

        int dataLen = data.length;
        for (int i = 1; i < dataLen; i++) {
            int tmp = data[i];
            if (data[i] < data[i-1]) {
                for (int j = i; j > 0; j--) {  // 从后往前数j
                    if (data[j-1] > tmp) {  // 如果还是继续大于的话就进行
                        data[j] = data[j-1];  // 当前个等于前一个，意味着左移一位
                    } else {
                        data[j] = tmp;
                        break;
                    }
                }
            }
        }
        return data;
    }

    /*
    * 希尔排序
    * 初始步长为队列一半，除以二的递减
    * */
    public static int[] shellSort(int[] data) {
        if(data == null || data.length == 0){
            return data;
        }

        int dataLen = data.length;
        int step = (int)((dataLen-1) / 2);
        while (step >= 1){
            for (int i = step; i < dataLen; i++) {
                int tmp = data[i];
                int j = i - step;
                while (j >= 0 && data[j] > tmp) {
                    data[j+step] = data[j];
                    j -= step;
                }
                data[j+step] = tmp;
            }
            step = (int)(step / 2);
        }

        return data;
    }

    /**
     * 归并排序
     * @param data
     * @return
     */
    public static int[] mergeSort(int[] data) {
        int len = data.length;
        if (len < 2) {
            return data;
        }
        int[] temp = new int[len];
        return doMergeSort(data, temp,0, len);
    }

    private static int[] doMergeSort(int[] data, int[] temp, int left, int right) {
        if (left == right) {
            return data;
        }
        int mid = Utils.midNumber(left, right);
        doMergeSort(data, temp, left, mid);
        doMergeSort(data, temp, mid + 1, right);
        return doMerge(data, temp, left, mid, right);
    }

    private static int[] doMerge(int[] data, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = 0;
        while (i < mid && j < right) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                i++;
            } else {
                temp[k] = data[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            temp[k++] = data[i++];
        }

        while (j < right) {
            temp[k++] = data[j++];
        }

        return temp;
    }

    /**
     * 快速排序
     * @param data
     * @return
     */
    public static int[] fastSort(int[] data) {
        int len = data.length;
        if (len < 2) {
            return data;
        }
        doFastSort(data, 0, len - 1);
        return data;
    }

    private static void doFastSort(int [] data, int left, int right) {
        if (left < right) {
            int pos = position(data, left, right);
            doFastSort(data, left, pos - 1);  // pos会被当做主元
            doFastSort(data, pos + 1, right);
        }
    }

    private static int position(int[] data, int left, int right) {
        int index = data[right];  // 使用最后一个当做主元
        int i = left - 1;  // left即上一个，若left为0，则此时i为-1
        for (int j = left; j < right; j++) {
            if (index > data[j]) {
                i++;
                Utils.swapArray(data, i, j);
            }
        }
        Utils.swapArray(data, i + 1, right);
        return i + 1;
    }

}
