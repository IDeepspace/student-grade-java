package com.tw;

import java.util.Scanner;
import java.util.List;

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
        addStudentMonitor();
        addStudentGradle();
        start();
        break;
      case CREATE_GRADE_LIST:
        createGradleList();
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

//  陈鑫, 1405110115, math: 100, chinese: 100, english: 100, coding: 100
//  二狗, 1405110086, math: 80, chinese: 70, english: 80, coding: 88
//  点点, 1405110111, math: 70, chinese: 60, english: 80, coding: 90
  private void addStudentMonitor(){
    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
  }

  //调用保存成绩函数，添加学生成绩
  private void addStudentGradle() {

    Scanner s = new Scanner(System.in);
    String input = s.nextLine();

    Student studentGradleArr = transformInputStringToStudentGradleArr(input);

    if (studentGradleArr != null) {
      saveStudentToDB(studentGradleArr);
    } else {
      System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
      addStudentGradle();
    }
  }

  //在班级中保存该学生的成绩函数
  private void saveStudentToDB(Student student) {
    klass.addStudent(student);
    System.out.println("学生" + student.getName() + "的成绩被添加");
  }

  //把输入的格式转换为学生成绩对象
  private Student transformInputStringToStudentGradleArr(String input) {

    String[] studentGradleArr = input.split(",");

    if (studentGradleArr.length != 6) {

      return null;

    } else {
      String id = studentGradleArr[1];
      String name = studentGradleArr[0];
      Double math = Double.parseDouble(studentGradleArr[2].split(":")[1]);
      Double chinese = Double.parseDouble(studentGradleArr[3].split(":")[1]);
      Double english = Double.parseDouble(studentGradleArr[4].split(":")[1]);
      Double coding = Double.parseDouble(studentGradleArr[5].split(":")[1]);

      return new Student(id, name, math, chinese, english, coding);
    }
  }

  //创建成绩单
  private void createGradleList(){
    if(klass.getStudents().size() == 0) {
      System.out.println("生成成绩单失败，请先添加成绩！");
    }else {
      StringBuilder str = new StringBuilder("成绩单\n"
          + "姓名|数学|语文|英语|编程|平均分|总分\n"
          + "========================\n");
      List<com.tw.Student> students = klass.getStudents();

      for(Student student : students) {
        str.append(student.setGradeSheet());
      }

      str.append(String.format("全班总分平均数：%s\n全班总分中位数：%s", klass.getAverageOfAllClass(), klass.getMedianOfAllClass()));

      System.out.println(str.toString());
    }
  }

  private void exit(){
    System.out.println("已退出，欢迎下次使用！");
  }

}
