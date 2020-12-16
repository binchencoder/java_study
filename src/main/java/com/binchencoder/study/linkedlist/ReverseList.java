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

    // 当前节点从头节点开始遍历
    Node curr = head;
    // 前一个指针节点
    Node prev = null;

    // 临时节点, 暂存当前节点的下一个节点, 用于后移
    Node temp;
    // 每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
    while (null != curr) {
      temp = curr.getNext();
      curr.setNext(prev); // 将当前节点指向它前面的节点

      prev = curr; // 前指针后移
      curr = temp; // 当前指针后移
    }

    return prev;
  }

  Node reverseList1(Node head) {
    Node pre = null;
    Node curr = head;
    Node next;
    while (null != curr) {
      next = curr.getNext();
      curr.setNext(pre);
      pre = curr;
      curr = next;
    }

    return pre;
  }

  Node reverseList2(Node head) {
    if (null == head || null == head.getNext()) {
      return head;
    }

    Node node = reverseList2(head.getNext());
    head.getNext().setNext(head);
    head.setNext(null);
    return node;
  }
}
