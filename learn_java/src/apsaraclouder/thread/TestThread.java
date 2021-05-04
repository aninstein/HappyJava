package apsaraclouder.thread;

public class TestThread {

    public static void main(String args[]) {
        System.out.println("实现 Runnable");
        RunnableDemo R1 = new RunnableDemo( "RunnableDemo-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "RunnableDemo-2");
        R2.start();

        System.out.println("继承 Thread");
        ThreadDemo T1 = new ThreadDemo( "ThreadDemo-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "ThreadDemo-2");
        T2.start();
    }
}

/**
 * 创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类。
 * 为了实现 Runnable，一个类只需要执行一个方法调用 run()，声明如下：
 * public void run()
 * 你可以重写该方法，重要的是理解的 run() 可以调用其他方法，使用其他类，并声明变量，就像主线程一样。
 * 在创建一个实现 Runnable 接口的类之后，你也可以在类中实例化一个线程对象，比如再使用Thread类。
 */
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("RunnableDemo Creating " +  threadName );
    }

    public void run() {
        System.out.println("RunnableDemo Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("RunnableDemo Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("RunnableDemo Thread " +  threadName + " interrupted.");
        }
        System.out.println("RunnableDemo Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("RunnableDemo Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

/**
 *  通过继承Thread来创建线程
 * 创建一个线程的第二种方法是创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
 * 继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行。
 * 该方法尽管被列为一种多线程实现方式，但是本质上也是实现了 Runnable 接口的一个实例。
 */
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("ThreadDemo Creating " +  threadName );
    }

    public void run() {
        System.out.println("ThreadDemo Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("ThreadDemo Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("ThreadDemo Thread " +  threadName + " interrupted.");
        }
        System.out.println("ThreadDemo Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("ThreadDemo Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

