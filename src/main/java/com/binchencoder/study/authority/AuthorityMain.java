package com.binchencoder.study.authority;

import static com.binchencoder.study.authority.Authority.*;

/**
 * Created by chenbin on 20-8-4.
 */
public class AuthorityMain {

  public static void main(String[] args) {
    //测试一：设置某个对象拥有8种权限
    Authority auto = new Authority();

    auto.setAuto((1 << 10) - 1);

    look(auto);

    // 测试二 在所有权限都有的基础上，删除 增删改查权限
    auto.delAuto(ALLOW_INSERT | ALLOW_DELETE | ALLOW_UPDATE | ALLOW_SELECT);

    look(auto);

    // 测试三  在测试二基础上增加 删除权限
//    auto.addAuto(ALLOW_DELETE);
//    auto.addAuto(ALLOW_COPY);

//    look(auto);
  }

  public static void look(Authority auto) {
    System.out.println("ALLOW_INSERT   有权限：" + auto.isAllow(ALLOW_INSERT));
    System.out.println("ALLOW_DELETE   有权限：" + auto.isAllow(ALLOW_DELETE));
    System.out.println("ALLOW_UPDATE   有权限：" + auto.isAllow(ALLOW_UPDATE));
    System.out.println("ALLOW_SELECT   有权限：" + auto.isAllow(ALLOW_SELECT));
    System.out.println("ALLOW_READ     有权限：" + auto.isAllow(ALLOW_READ));
    System.out.println("ALLOW_WRITE    有权限：" + auto.isAllow(ALLOW_WRITE));
    System.out.println("ALLOW_COPY     有权限：" + auto.isAllow(ALLOW_COPY));
    System.out.println("ALLOW_READONLY 有权限：" + auto.isAllow(ALLOW_READONLY));
    System.out.println("ALLOW_TEMP8    有权限：" + auto.isAllow(ALLOW_TEMP8));
    System.out.println("ALLOW_TEMP9    有权限：" + auto.isAllow(ALLOW_TEMP9));
    System.out.println("Authority state:" + auto.getState());
    System.out.println("=====================================================");
  }

}
