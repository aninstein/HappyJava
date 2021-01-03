package apsaraclouder.controll;

public class ApsaraClouderControll {

    public static void main(String[] args) {

    }

    /**
     * switch一定要配置default，而且一定要判断输入参数
     * @param s
     */
    public static void switchString(String s){
        if (s == null) {
            return;
        }
        switch (s) {
            case "sth":
                System.out.println("sss");
                break;
            case "ppp":
                System.out.println("ppp");
                break;
            default:
                System.out.println("default");
        }
    }

}
