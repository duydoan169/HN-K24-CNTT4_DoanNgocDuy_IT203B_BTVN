package bai06;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector implements Runnable {
    @Override
    public void run() {
        System.out.println("Đang quét deadlock...");

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.findDeadlockedThreads();

        if (ids == null) {
            System.out.println("Không phát hiện deadlock.");
        } else {
            System.out.println("Phát hiện deadlock");
        }
    }
}