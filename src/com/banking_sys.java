package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class bank {
   public static String name = "Swarnadeep rooj" ;
   private long acc_no;
   private int balance = 0;
   private final Lock lock = new ReentrantLock(true);
   public void deposit(int x){
       System.out.println(Thread.currentThread().getName() + " is trying to deposit ");
       try{
           if (lock.tryLock(2000, TimeUnit.MILLISECONDS))
               if (x<=0){
                   System.out.println("INVALID");
               }
               else {
                   try {
                       System.out.println(Thread.currentThread().getName() + " proceeding to deposit ");
                       Thread.sleep(1000);
                       balance += x;
                       System.out.println("you have balance : " + balance);
                   } catch (Exception e) {
                       Thread.currentThread().interrupt();
                   } finally {
                       lock.unlock();
                   }
               }
           else {
               System.out.println(Thread.currentThread().getName() + " could not accurire lock ");
           }
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }
   }
   public void withdraw(double y){
       if (y<=balance && y>0){
           balance -= y;
           System.out.print("current balance is : " + balance + "\n");
       }else System.out.println(" Insufficient balance !");
   }

    public double getBalance() {
        if (balance == (long) balance) {
            System.out.print("Amount you have : " + (long) balance);
        } else {
            System.out.print("Amount you have : " + balance);
        }
        return balance;
    }
}
public class banking_sys {
    public static void main(String[] args) throws InterruptedException {
        test t1 = new test();
        Thread l1 = new Thread(t1,"KHUSI");
        Thread l2 = new Thread(t1,"DEEP");
        l1.start();
        l2.start();
    }
}
