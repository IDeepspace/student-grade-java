package com.tw;

public class Operator {

  private static final int ADD_STUDENT_GRADLE = 1;
  private static final int CREATE_GRADE_LIST = 2;
  private static final int EXIT = 3;

  private Klass klass;

  public Operator(Klass klass) {
    this.klass = klass;
  }

  public void start() {
    int selectiveType = new BuildMainMenuString().enter();
    operator(selectiveType);
  }

  private void operator(int selectiveType){
    switch (selectiveType) {
      case ADD_STUDENT_GRADLE:
        new com.tw.AddStudentGrade(klass).addStudentGrade();
        start();
        break;
      case CREATE_GRADE_LIST:
        new com.tw.CreateGradeList(klass).createGradeList();
        start();
        break;
      case EXIT:
        exit();
        break;
      default:
        System.out.println("输入错误，请重新输入");
        start();
        break;
    }
  }




  private void exit(){
    System.out.println("已退出，欢迎下次使用！");
  }

}
