package com.tw;

public class AddStudentGrade {

  private com.tw.Klass klass;

  public AddStudentGrade(com.tw.Klass klass) {
    this.klass = klass;
  }
  //调用保存成绩函数，添加学生成绩
  public void addStudentGrade() {
    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    java.util.Scanner s = new java.util.Scanner(System.in);
    String input = s.nextLine();

    Student studentGradleArr = transformInputStringToStudentGradleArr(input);

    if (studentGradleArr != null) {
      saveStudentToDB(studentGradleArr);
    } else {
      System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
      addStudentGrade();
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

}
