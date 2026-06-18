package com;

public class communicatiopn {
    public static void main(String[] args) throws InterruptedException {
        box b1 = new box();
        Thread t1 = new Thread(() -> {
            for (int i = 1;i<10;i++){
                try {
                    Thread.sleep(1000);
                    b1.producer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1;i<10;i++){
                try {
                    Thread.sleep(1500);
                    b1.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
class box{
    Integer item = null;
    boolean flag = false;

    synchronized void producer(int a) throws InterruptedException {
        while (flag){
            wait();
        }
        item = a;
        flag = true;
        System.out.println("Producer produced .." + item);
        notify();
    }
    synchronized void consumer() throws InterruptedException {
        while (!flag){
            wait();
        }
        System.out.println("Consumer consumed .." + item);
        item = null;
        flag = false;
        notify();
    }
}
