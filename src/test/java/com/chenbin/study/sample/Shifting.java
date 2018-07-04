package com.chenbin.study.sample;

import org.junit.Test;

/**
 * 移位运算测试
 */
public class Shifting {

  @Test
  public void leftShifting() {
    int num = 10;
    // 原始数二进制
    printInfo(num);

    // 左移1位
    num = num << 1;
    printInfo(num);

    // 右移1位
    num = num >> 1;
    printInfo(num);

    num = num >>> 1;
    printInfo(num);
  }


  /**
   * 输出一个int的二进制数
   */
  private static void printInfo(int num) {
    System.out.println("Print origin num:" + num);
    System.out.println("ToBinaryString:" + Integer.toBinaryString(num));
  }

}
