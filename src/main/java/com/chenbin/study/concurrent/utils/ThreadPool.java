package com.chenbin.study.concurrent.utils;

import com.chenbin.study.concurrent.TaskExecutorService;

import java.util.concurrent.*;

/**
 * Created by chenbin on 2017/6/14.
 */
public class ThreadPool {

	public static ExecutorService getThreadPoolExecutor() {
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);
		return new TaskExecutorService(
				10,
				10,
				0L,
				TimeUnit.MILLISECONDS,
				workQueue);
	}
}
