

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] data = {1, 2, 7, 1, -9, 100, 5400, -471, -1, 0, 0, 21, 3};
        int[] ret = bubbleSort(data);
        for (int i : ret) {
            System.out.print(i + " ");
        }


    }

    private static int[] bubbleSort(int[] data){

        if(data == null || data.length == 0){
            return data;
        }

        int dataLen = data.length;
        boolean flag = true;
        for (int i = 0; i < dataLen; i++) {
            for (int j = i+1; j < dataLen; j++) {
                if(data[i] > data[j]){
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                    flag = false;
                }
            }
            if(flag) break;
        }
        return data;
    }

}
