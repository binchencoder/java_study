package com.chenbin.study.java.concurrent;import java.util.Random;import java.util.concurrent.Callable;import java.util.concurrent.CompletionService;import java.util.concurrent.ExecutionException;import java.util.concurrent.ExecutorCompletionService;import java.util.concurrent.ExecutorService;import java.util.concurrent.Executors;public class TestCompletionService {  public static void main(String[] args) {    try {      completionServiceCount();    } catch (InterruptedException e) {      e.printStackTrace();    } catch (ExecutionException e) {      e.printStackTrace();    }  }  /**   * 使用completionService收集callable结果   */  public static void completionServiceCount() throws InterruptedException, ExecutionException {    ExecutorService executorService = Executors.newCachedThreadPool();    CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(        executorService);    int threadNum = 5;    for (int i = 0; i < threadNum; i++) {      completionService.submit(getTask(i));    }    Long start = System.currentTimeMillis();    int firstResult = completionService.take().get();    System.out.println("CompletionService first result: " + firstResult + ", Cost time: " + (        System.currentTimeMillis() - start));    int secondResult = completionService.take().get();    System.out.println("CompletionService second result: " + secondResult + ", Cost time: " + (        System.currentTimeMillis() - start));//    int sum = 0;//    int temp = 0;//    for (int i = 0; i < threadNum; i++) {//      temp = completionService.take().get();//      sum += temp;//      System.out.print(temp + "\t");//    }//    System.out.println("CompletionService all is : " + sum);    executorService.shutdown();  }  public static Callable<Integer> getTask(final int no) {    final Random rand = new Random();    Callable<Integer> task = new Callable<Integer>() {      @Override      public Integer call() throws Exception {        int time = rand.nextInt(100) * 100;        Thread.sleep(time);        System.out.println("Thread: " + no + " time is: " + time);        return no;      }    };    return task;  }}