package com.binchencoder.study.authority;

/**
 * Created by chenbin on 20-8-4.
 *
 * @see <a href="https://blog.csdn.net/csdnbeyoung/article/details/88389233">
 * https://blog.csdn.net/csdnbeyoung/article/details/88389233 </a>
 */
public class Authority {

  //新增权限
  public static final int ALLOW_INSERT = 1 << 0;
  //删除权限
  public static final int ALLOW_DELETE = 1 << 1;
  //修改权限
  public static final int ALLOW_UPDATE = 1 << 2;
  //查看权限
  public static final int ALLOW_SELECT = 1 << 3;
  //可读权限
  public static final int ALLOW_READ = 1 << 4;
  //可写权限
  public static final int ALLOW_WRITE = 1 << 5;
  //复制权限
  public static final int ALLOW_COPY = 1 << 6;
  //只读权限
  public static final int ALLOW_READONLY = 1 << 7;

  public static final int ALLOW_TEMP8 = 1 << 8;

  public static final int ALLOW_TEMP9 = 1 << 9;

  //用来保存当前存在的权限，即用这一个字段，保存8种权限状态
  private int state;

  //设置权限，1个或多个
  public void setAuto(int auto) {
    state = auto;
  }

  //用来增加一个权限，一个或多个
  public void addAuto(int auto) {
    state = state | auto;
  }

  //用来删除一个权限
  public void delAuto(int auto) {
    state = state & ~auto;
  }

  //用来查看是否有某种权限
  public boolean isAllow(int auto) {
    return ((state & auto) == auto);
  }

  //用来查看是否没有某种权限
  public boolean isNotAllow(int auto) {
    return ((state & auto) == 0);
  }

  public int getState() {
    return state;
  }
}
