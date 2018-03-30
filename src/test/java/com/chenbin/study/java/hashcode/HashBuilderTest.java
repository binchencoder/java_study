package com.chenbin.study.java.hashcode;

import org.junit.Test;

/**
 * Created by chenbin on 18-2-7.
 */
public class HashBuilderTest {

  @Test
  public void testHashCode() {
    Long start = System.currentTimeMillis();
    Person person = new Person();
    person.setName("Chen bin");
    person.setAge(27);
    person.setSex(Sex.MALE);

    System.out.println(person.hashCode());
    System.out.println("Cost time:" + (System.currentTimeMillis() - start));
  }

}
