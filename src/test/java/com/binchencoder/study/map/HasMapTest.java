package com.binchencoder.study.map;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Created by chenbin on 20-8-14.
 */
public class HasMapTest {

  @Test
  public void testPut() {
    Map<String, String> map = new HashMap<>(2);
    map.put("1", "1");
  }
}
