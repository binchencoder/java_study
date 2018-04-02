package com.chenbin.study.concurrent;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/**
 * Created by chenbin on 2018/3/31.
 */
public class CountDownLatchTest {

  @Test
  public void testAsyncExecFailedOfCountDown() {
    List<String> options = Lists.newArrayList("1", "2", "3");
    CountDownLatch latch = new CountDownLatch(options.size());

    options.stream().forEach(op -> {
      CompletableFuture.runAsync(() -> {
        try {
          switch (op) {
            case "1":
              Thread.sleep(1000L);
              System.out.println("Get 1");
              break;
            case "2":
              Thread.sleep(2000L);
              System.out.println("Get 2");
              break;
            case "3":
              Thread.sleep(3000L);
              System.out.println("Get 3");
              break;
            default:
              break;
          }
        } catch (Exception ex) {
        } finally {
          latch.countDown();
        }
      });
    });

    // 因为没有执行latch.await(), 所以异步执行失败

    System.out.println("Over");
  }

  @Test
  public void testAsyncExecSuccedOfCountDown() {
    List<String> options = Lists.newArrayList("1", "2", "3");
    long start = System.currentTimeMillis();

    CountDownLatch latch = new CountDownLatch(options.size());

    options.stream().forEach(op -> CompletableFuture.runAsync(() -> {
      try {
        switch (op) {
          case "1":
            Thread.sleep(1000L);
            System.out.println("Get 1");
            break;
          case "2":
            Thread.sleep(2000L);
            System.out.println("Get 2");
            break;
          case "3":
            Thread.sleep(3000L);
            System.out.println("Get 3");
            break;
          default:
            break;
        }
      } catch (Exception ex) {
      } finally {
        latch.countDown();
      }
    }));

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Cost time:" + (System.currentTimeMillis() - start));
    System.out.println("Over");
  }
}
