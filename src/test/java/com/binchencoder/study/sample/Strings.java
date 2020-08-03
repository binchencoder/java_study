package com.binchencoder.study.sample;

import org.junit.Test;

/**
 * Created by chenbin on 20-7-30.
 */
public class Strings {

  @Test
  public void test1() {
    String a = new String("ABC");
    String b = "ABC";

    System.out.println(a == b);
  }

  @Test
  public void test2() {
    String a = new String("A");
    String b = new String("A");
    System.out.println(a == b);
  }

}
