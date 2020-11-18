package com.binchencoder.study.linkedlist;

import org.junit.Test;

/**
 * Created by chenbin on 20-11-18.
 */
public class ReverseListTest {

  @Test
  public void reverseList() throws Exception {
    Node head = new Node();
    head.setData(-1);
    head.setNext(null);

    Node p;
    p = head;

    for (int i = 1; i <= 10; i++) {
      Node q = new Node();
      q.setData(i);
      q.setNext(null);
      p.setNext(q);
      p = q;
    }

    printList(head);

    ReverseList reverseList = new ReverseList();
    reverseList.reverseList(head);

    printList(head);
  }

  public void printList(Node node) {
    StringBuffer printStr = new StringBuffer(node.getData() + "");
    while (null != node.getNext()) {
      printStr.append(" => ").append(node.getNext().getData());
      node = node.getNext();
    }

    System.out.println(printStr);
  }
}