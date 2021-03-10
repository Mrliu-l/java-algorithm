package org.self.algorithm.common;

/**
 * 多线程分别输出ABCABC...
 * 备注：使用synchronize
 */
public class Demo1 {
    private volatile String flag = "A";

    private static final Object lock = new Object();//在此场景下，普通变量也可以

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.process();
    }

    private void process(){
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
        new Thread(new Task3()).start();
    }

    public class Task1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (flag.equals("A")) {
                        System.out.println(flag);
                        flag = "B";
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public class Task2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (flag.equals("B")) {
                        System.out.println(flag);
                        flag = "C";
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public class Task3 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (flag.equals("C")) {
                        System.out.println(flag);
                        flag = "A";
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}