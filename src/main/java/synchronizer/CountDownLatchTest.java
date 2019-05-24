package synchronizer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        Random rand = new Random();
                        int n = rand.nextInt(1000);
                        Thread.sleep(n);
                        System.out.println(n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        endGate.countDown();
                    }
                }
            }.start();
        }

        long startTime = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long endTime = System.currentTimeMillis();

        System.out.println("elapsed time should be equal or greater than anyone above: " + (endTime - startTime));

    }
}
