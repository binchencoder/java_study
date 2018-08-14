package com.chenbin.study.sample;

import com.google.common.base.CharMatcher;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
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
    List<Long> addItems = Lists.newArrayList(1L, 3L, 4L, 5L);
    List<Long> removeItems = Lists.newArrayList(1L, 5L, 4L, 2L);
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

  @Test
  public void testRemoveIf() {
    List<Long> lst = Lists.newArrayList(0L, 1L, 122L);
    lst.removeIf(l -> l.equals(0L));

    List<Long> empty = java.util.Collections.emptyList();
    empty.removeIf(l -> l.equals(0L));

    System.out.println(lst);
    System.out.println(empty);
  }

  @Test
  public void testSubList() {
    List<Long> lst = Lists.newArrayList(1L, 3L, 4L, 5L, 9L, 0L);
    System.out.println(lst.subList(2, lst.size()));
  }

  @Test
  public void test() {
    System.out.print(NumberUtils.toLong(CharMatcher.DIGIT.retainFrom("WorkFrame." + 111L)));
  }

  @Test
  public void test1() {
    List<Long> test = Lists.newArrayList(1L, 2L);
    System.out.println(System.identityHashCode(test));

    test = Lists.newArrayList(2L, 3L);
    System.out.println(System.identityHashCode(test));
  }
}
