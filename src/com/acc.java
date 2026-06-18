package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class acc {
    public int balance = 200;
    private final Lock l1 = new ReentrantLock(true);
    public void withdraw(int amt){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw : " + "RS." + amt);
        try {
            if (l1.tryLock(1000, TimeUnit.MILLISECONDS)){
                if (amt<= balance){
                    try{
                        System.out.println(Thread.currentThread().getName() + " processing to withdraw ");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        balance -= amt;
                        System.out.println(Thread.currentThread().getName() + " completed withdraw " + "& Remaning balance : " + balance);
                    }
                    catch (Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally { l1.unlock() ;}
                }
                else {
                    System.out.println(Thread.currentThread().getName() + ": Insufficient balance");
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " : server busy");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}

class persons{
    public static void main(String[] args) {
        acc a1 = new acc();
        Runnable task = ()-> a1.withdraw(101);
        Thread t1 = new Thread(task,"sanjay");
        Thread t2 = new Thread(task,"archana");
        t1.start();
        t2.start();
    }
}
