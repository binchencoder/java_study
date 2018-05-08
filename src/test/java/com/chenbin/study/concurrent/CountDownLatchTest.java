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
    CompletableFuture completableFuture = new CompletableFuture<>();
    options.stream().forEach(op -> {
      completableFuture.supplyAsync(() -> {
        try {
          switch (op) {
            case "1":
              Thread.sleep(1000L);
              System.out.println("Get 1");
              break;
            case "2":
//              throwException();
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
          System.err.println("Occur exception");
          completableFuture.completeExceptionally(ex);
        } finally {
          latch.countDown();
        }

        completableFuture.complete(op);
        return null;
      });
    });

    try {
      completableFuture.get();
    } catch (Exception e) {
      throw new RuntimeException("");
    }

    /*completableFuture.get();
    boolean exceptionally = completableFuture.exceptionally(ex -> {
      System.err.println("exceptionally");
      throw new CompletionException("CompleteFuture exceptionally", (Throwable) ex);
    }).isCompletedExceptionally();

    System.err.println("CompletableFuture exceptionally is: " + exceptionally);
    if (exceptionally) {
      throw new RuntimeException("");
    }*/

    /*
    options.stream().forEach(op -> {
      CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
        try {
          switch (op) {
            case "1":
              Thread.sleep(1000L);
              System.out.println("Get 1");
              break;
            case "2":
              throwException();
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
          System.err.println("Occur exception");
          throw new RuntimeException();
        } finally {
          latch.countDown();
        }
      });

      boolean exceptionally = completableFuture.exceptionally(ex -> {
        System.err.println("exceptionally");
        throw new RuntimeException();
      }).isCompletedExceptionally();

      System.err.println(exceptionally);
      if (exceptionally) {
        throw new RuntimeException();
      }
    });*/

    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Cost time:" + (System.currentTimeMillis() - start));
    System.out.println("Over");
  }

  private void throwException() {
    throw new RuntimeException("Occur exception");
  }
}
