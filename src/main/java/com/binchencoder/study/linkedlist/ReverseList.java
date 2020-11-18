package com.binchencoder.study.linkedlist;

/**
 * Created by chenbin on 20-11-18.
 */
public class ReverseList {

  /**
   * @param head 原始链表头节点
   * @return 逆序后链表头节点
   */
  Node reverseList(Node head) {
    if (head.getNext() == null || head.getNext().getNext() == null) {
      return head;
    }

    Node p = head.getNext();
    Node q = head.getNext().getNext();

    Node t = null;
    while (null != q) {
      t = q.getNext();
      q.setNext(p);
      p = q;
      q = t;
    }

    // 设置链表尾
    head.getNext().setNext(null);
    // 设置链表头
    head.setNext(p);
    return head;
  }
}
