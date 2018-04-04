package com.tw;

import java.util.Scanner;

public class BuildMainMenuString {

  public int enter() {

    int selectiveType;

    while (true) {
      System.out.println("1. 添加学生\n"
          + "2. 生成成绩单\n"
          + "3. 退出\n"
          + "请输入你的选择（1～3）：");
      try {
        Scanner s = new Scanner(System.in);
        selectiveType = s.nextInt();
        break;
      }catch (Exception e) {
        System.out.println("输入错误，请重新输入！");
      }
    }

    return selectiveType;
  }

}
