package com.binchencoder.study.tree;

/**
 * Created by chenbin on 20-12-1.
 */
public class BinaryTree implements Tree {

  private Node root; // 树根节点

  @Override
  public Node find(int key) {
    Node current = root;
    while (current != null) {
      if (current.getData() > key) {
        current = current.getLeftChild();
      } else if (current.getData() < key) {
        current = current.getRightChild();
      } else {
        return current;
      }
    }

    return null; // 遍历完整个树没找到，返回null
  }

  @Override
  public boolean insert(int data) {
    Node p = new Node(data);
    if (root == null) {
      root = p;
      return true;
    } else {
      Node current = root;
      Node parent = null;
      while (current != null) {
        parent = current;
        if (current.getData() > data) { // 当前值比插入值大，搜索左子节点
          current = current.getLeftChild();
          if (current == null) { // 左子节点为空，直接将新值插入到该节点
            parent.setLeftChild(p);
            return true;
          }
        } else {
          current = current.getRightChild();
          if (current == null) { // 右子节点为空，直接将新值插入到该节点
            parent.setRightChild(p);
            return true;
          }
        }
      }
    }

    return false;
  }

  @Override
  public boolean delete(int key) {
    return false;
  }

  // 中序遍历
  public void infixOrder(Node current) {
    if (null != current) {
      infixOrder(current.getLeftChild());
      System.out.println(current.getData() + "");
      infixOrder(current.getRightChild());
    }
  }
}
