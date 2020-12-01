package com.binchencoder.study.tree;

/**
 * Created by chenbin on 20-12-1.
 */
public interface Tree {

  // 查找节点
  public Node find(int key);

  // 插入新节点
  public boolean insert(int data);

  // 删除节点
  public boolean delete(int key);
}
