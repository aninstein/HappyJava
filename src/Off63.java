import java.util.ArrayList;

public class Off63 {
    public static int maxProfit(int[] prices) {
        int start=0;
        int maxn = 0;
        if(prices.length==0){
            return 0;
        }
        ArrayList<Integer> stack=new ArrayList<>();
        stack.add(prices[0]);
        for(int i=1;i<prices.length;i++){
            if(prices[i]<stack.get(stack.size()-1)){
                stack.remove(stack.size()-1);
                continue;
            }
            stack.add(prices[i]);
            int z=stack.size()-1;
            maxn=Math.max(maxn, stack.get(z)-stack.get(0));
        }
        return maxn;
    }
//    public int[] constructArr(int[] a) {
//        return 0;
//    }
    public static void main(String[] args) {
//        int[] prices={7,1,5,3,6,4};
//        System.out.println(Off63.maxProfit(prices));
    }
}
