package com.binchencoder.study.synchronize;

public class WaitThread implements Runnable {

  private Service service;

  public WaitThread(Service service) {
    this.service = service;
  }

  @Override
  public void run() {
    service.mWait();
  }
}
