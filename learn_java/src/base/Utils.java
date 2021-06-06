package base;

public class Utils {

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

    public static int midNumber(int left, int right) {
        // (left + right) / 2 会溢出
        // 推演：
        // 1) (right - left) / 2 = right/2 - left/2
        // 2) left + right/2 - left/2 = right/2 + left/2 = (left + right) / 2
        return left + (right - left) / 2;
    }
}
