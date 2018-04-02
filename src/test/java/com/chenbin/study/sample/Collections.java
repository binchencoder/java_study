package com.chenbin.study.sample;

import java.util.List;
import org.junit.Test;
import org.testng.collections.Lists;

/**
 * Created by chenbin on 18-3-30.
 */
public class Collections {

  /**
   * 取交集
   */
  @Test
  public void testRetainAll() {
    List<Long> addItems = Lists.newArrayList(1L, 3L);
    List<Long> removeItems = Lists.newArrayList(1L, 2L);
    addItems.retainAll(removeItems);

    System.out.println(addItems);
  }

  /**
   * RemoveAll specified collection
   */
  @Test
  public void testRemoveAll() {
    List<Long> addItems = Lists.newArrayList(1L, 3L);
    List<Long> removeItems = Lists.newArrayList(1L, 2L);
    removeItems.removeAll(addItems);

    System.out.println(removeItems);
  }
}
