package com.demo;


public class DeadLockSample extends Thread {
    private String first;
    private String second;
    public DeadLockSample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public  void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


//    public static void main(String[] args) throws InterruptedException {
//
//        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
//        Runnable dlCheck = new Runnable() {
//
//            @Override
//            public void run() {
//                long[] threadIds = mbean.findDeadlockedThreads();
//                if (threadIds != null) {
//                    ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
//                    System.out.println("Detected deadlock threads:");
//                    for (ThreadInfo threadInfo : threadInfos) {
//                        System.out.println(threadInfo.getThreadName());
//                    }
//                }
//            }
//        };
//
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        // 稍等5秒，然后每10秒进行一次死锁扫描
//        scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);
//// 死锁样例代码…
//    }
}
