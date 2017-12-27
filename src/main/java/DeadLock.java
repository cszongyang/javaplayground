/**
 * Created by zongyangli on 12/26/17.
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
 * Deadlock occurs when multiple threads need the same locks but obtain them in different order.
 * A Java multithreaded program may suffer from the deadlock condition because the synchronized keyword
 * causes the executing thread to block while waiting for the lock, or monitor, associated with the specified object.
 */
public class DeadLock {

    Object obj1 = new Object();
    Object obj2 = new Object();

    Thread thread1 = new Thread("test thread 1") {
        public void run() {
            while (true) {
                synchronized (obj1) {
                    synchronized (obj2) {
                        System.out.println("excuting thread 1");
                    }
                }
            }
        }
    };

    Thread thread2 = new Thread("test thread 2") {
        public void run() {
            while (true) {
                synchronized (obj2) {
                    synchronized (obj1) {
                        System.out.println("excuting thread 2");
                    }
                }
            }
        }
    };

    public static void main(String a[]){
        DeadLock dl = new DeadLock();
        dl.thread1.start();
        dl.thread2.start();
    }
}
