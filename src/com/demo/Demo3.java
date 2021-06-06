package com.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Demo3 {
    private static volatile int count;//记录用户访问次数

    public static  void request() throws InterruptedException {
        //模拟请求耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
//        count++;
        int expectedValue;
        while(!compareAndSwap(expectedValue = getCount(),expectedValue + 1)){}
    }

    public static synchronized boolean compareAndSwap(int expectedValue,int newValue) {
        if (getCount() == expectedValue) {
            count = newValue;
            return true;
        }
        return false;
    }
    
    

    public static void main(String[] args) throws InterruptedException {
        //开始时间
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        //CountDownLatch类就是要保证完成100个用户请求之后再执行后续的代码
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //模拟用户行为，访问10次网站
                    try{
                        for (int j = 0; j < 10; j++)
                            request();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            thread.start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"耗时:"+(endTime-startTime)+",count="+count);
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Demo3.count = count;
    }
}
