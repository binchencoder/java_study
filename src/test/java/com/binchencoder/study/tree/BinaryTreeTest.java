package com.binchencoder.study.tree;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by chenbin on 20-12-1.
 */
public class BinaryTreeTest {

  @Test
  public void find() throws Exception {
  }

  @Test
  public void insert() throws Exception {
    BinaryTree btree = new BinaryTree();
    btree.insert(7); // Insert root node
    btree.insert(2);
    btree.insert(3);
    btree.insert(4);
    btree.insert(5);
    btree.insert(8);


    Node node = btree.find(6);
    assertNull(node);
  }

  @Test
  public void delete() throws Exception {
  }

}