package com.binchencoder.study.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  @Test
  public void splitString() {
    String str = "aaa,444,11,566,1232,666";

    List<String> lst = new ArrayList<>();
    int idx;
    while ((idx = str.indexOf(",")) > -1) {
      lst.add(str.substring(0, idx));
      str = str.substring(idx + 1);
    }

    System.out.println(lst.toString());
  }

  @Test
  public void reverseString() {
    char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};

    int len = s.length;
    char[] copyData = Arrays.copyOf(s, len);

    int i = 0;
    for (int n = len - 1; n >= 0; n--) {
      s[i] = copyData[n];
      i++;
    }
    System.out.println(s);
  }
}
