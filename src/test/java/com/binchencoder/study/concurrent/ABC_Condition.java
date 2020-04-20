package com.binchencoder.study.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenbin on 20-4-20.
 */
public class ABC_Condition {

  private static Lock lock = new ReentrantLock();

  private static Condition A = lock.newCondition();
  private static Condition B = lock.newCondition();
  private static Condition C = lock.newCondition();

  private static int count = 0;

  static class ThreadA extends Thread {

    @Override
    public void run() {
      try {
        lock.lock();
        for (int i = 0; i < 10; i++) {
          while (count % 3 != 0) {
            A.await();
          }
          System.out.print("A");
          count++;
          B.signal();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  static class ThreadB extends Thread {

    @Override
    public void run() {
      try {
        lock.lock();
        for (int i = 0; i < 10; i++) {
          while (count % 3 != 1) {
            B.await();
          }
          System.out.print("B");
          count++;
          C.signal();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  static class ThreadC extends Thread {

    @Override
    public void run() {
      try {
        lock.lock();
        for (int i = 0; i < 10; i++) {
          while (count % 3 != 2) {
            C.await();
          }
          System.out.print("C");
          count++;
          A.signal();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) {
    new ThreadA().start();
    new ThreadB().start();
    new ThreadC().start();
  }
}
