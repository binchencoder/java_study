package com.binchencoder.study.cglib;

/**
 * Created by chenbin on 20-7-30.
 */
public class TestCglib {

  public static void main(String[] args) {
    BookFacadeCglib cglib = new BookFacadeCglib();
    BookFacadeImpl bookCglib = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
    bookCglib.addBook();
  }
}
