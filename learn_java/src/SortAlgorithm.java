import base.Utils;

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] data = {-10000, 2, 7, 1, -9, 100, 5400, -471, -1, 0, 0, 21, 3};
        int[] ret = mergeSort(data);
        for (int i : ret) {
            System.out.print(i + " ");
        }


    }

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
        int mid = Utils.minNumber(left, right);
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


}
