

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] data = {-10000, 2, 7, 1, -9, 100, 5400, -471, -1, 0, 0, 21, 3};
        int[] ret = shellSort(data);
        for (int i : ret) {
            System.out.print(i + " ");
        }


    }

    private static int[] bubbleSort(int[] data){

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

    private static int[] selectSort(int[] data){
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

    private static int[] insertSort(int[] data) {
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
    private static int[] shellSort(int[] data) {
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

}
