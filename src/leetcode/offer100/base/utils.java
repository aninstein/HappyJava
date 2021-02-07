package leetcode.offer100.base;

public class utils {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swapArray(int[] data, int a, int b) {
        try {
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        } catch (Exception e) {
            System.out.println("error a: " + a);
            System.out.println("error b: " + b);
            System.out.println(e.getMessage());
        }
    }
}
