package apsaraclouder.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ApsaraClouderThread {

    public static void main(String[] args) {

    }

    /**
     * SimpleDateFormat是线程不安全的类
     * 一般不要定义为static变量
     * 如果定义为static，必须加锁，或者使用DateUtils工具类
     * 如果是JDK8的应用，可以使用Instant代替Date，LocalDateTime代替Calendar
     */
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };




}
