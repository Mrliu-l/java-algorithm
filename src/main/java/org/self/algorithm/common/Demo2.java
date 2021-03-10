package org.self.algorithm.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程输出ABCABC...
 * 备注：使用ReentrantLock  的  condition
 */
public class Demo2 {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    private volatile String flag = "A";

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.process();
    }

    private void process() {
        new Thread(new TaskA()).start();
        new Thread(new TaskB()).start();
        new Thread(new TaskC()).start();
    }

    private class TaskA implements Runnable {
        @Override
        public void run() {
            while (true){
                lock.lock();
                if(flag.equals("A")){
                    System.out.println(flag);
                    flag = "B";
                    conditionB.signal();
                }else{
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    private class TaskB implements Runnable {
        @Override
        public void run() {
            while (true){
                lock.lock();
                if(flag.equals("B")){
                    System.out.println(flag);
                    flag = "C";
                    conditionC.signal();
                }else{
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    private class TaskC implements Runnable {
        @Override
        public void run() {
            while (true){
                lock.lock();
                if(flag.equals("C")){
                    System.out.println(flag);
                    flag = "A";
                    conditionA.signal();
                }else{
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
