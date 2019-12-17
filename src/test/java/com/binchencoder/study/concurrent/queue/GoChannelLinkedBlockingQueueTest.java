package com.binchencoder.study.concurrent.queue;

public class GoChannelLinkedBlockingQueueTest {

  public static void main(String[] args) throws InterruptedException {
    GoChannelLinkedBlockingQueue<Integer> goChannel = new GoChannelLinkedBlockingQueue(10);

    new Thread(() -> {
      Integer i;
      try {
        while (null != (i = goChannel.take())) {
          System.out.println("num=" + i);

          Thread.sleep(2000);
        }
        System.out.println("end");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("goChannel take return null");
      }
    }).start();

    for (int i = 0; i < 5; i++) {
//      if (i == 3) {
//        System.out.println("Close ch");
//        goChannel.close(0);
//      }

      goChannel.offer(i);
      System.out.println("goChannel.offer(" + i + ")");
    }
  }
}