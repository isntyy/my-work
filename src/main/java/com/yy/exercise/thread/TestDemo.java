package com.yy.exercise.thread;

/**
 * @author wyy
 * @desc
 * @since 2021-06-26 17:27
 */
public class TestDemo {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new CalTor("1",1000L));
        Thread t2 = new Thread(new CalTor("2",2000L));
        Thread t3 = new Thread(new CalTor("3",3000L));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();

        System.out.printf("====采集开始：%s, 采集结束：%s==== \n", start,end);

    }
}
class CalTor implements Runnable {

    private String name;
    private long time;

    public CalTor(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("机器："+name+"采集完成，耗时: "+ time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}