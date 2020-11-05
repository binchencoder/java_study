package com.binchencoder.study.channels;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by chenbin on 20-11-5.
 */
public class FileChannelTxt {

  public static void main(String[] args) throws IOException {
    // 1. 创建RandomAccessFile(随机访问文件) 对象
    RandomAccessFile raf = new RandomAccessFile("/home/chenbin/桌面/niodata.txt", "rw");
    // 通过RandomAccessFile对象的getChannel()方法获取FileChannel
    FileChannel inChannel = raf.getChannel();
    // 2. 创建一个读数据缓冲区
    ByteBuffer buf = ByteBuffer.allocate(48);
    // 3. 从通道中读取数据
    int bytesRead = inChannel.read(buf);
    // 创建一个写数据缓冲对象
    ByteBuffer buf2 = ByteBuffer.allocate(48);
    // 写入数据
    buf2.put("filechannel test".getBytes());
    buf2.flip();
    inChannel.write(buf);
    while (bytesRead != -1) {
      System.out.println("Read " + bytesRead);
      // Buffer有两种模式，写模式和读模式。在写模式下调用flip()之后，Buffer从写模式变成读模式。
      buf.flip();
      // 如果还有未读内容
      while (buf.hasRemaining()) {
        System.out.print((char) buf.get());
      }
      // 清空缓冲区
      buf.clear();
      bytesRead = inChannel.read(buf);
    }
    // 关闭RandomAccessFile(随机访问文件)对象
    raf.close();
  }
}