package com.binchencoder.study.channels.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by chenbin on 20-11-5.
 */
public class WebClient {

  public static void main(String[] args) {
    try {
      SocketChannel socketChannel = SocketChannel.open();
      socketChannel.connect(new InetSocketAddress("localhost", 8000));

      ByteBuffer writeBuff = ByteBuffer.allocate(32);
      ByteBuffer readBuff = ByteBuffer.allocate(32);
      writeBuff.put("hello".getBytes());
      writeBuff.flip();

      for (; ; ) {
        writeBuff.rewind();
        socketChannel.write(writeBuff);
        readBuff.clear();
        socketChannel.read(readBuff);
        System.out.println("readBuff: " + new String(readBuff.array()));
      }
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }
}
