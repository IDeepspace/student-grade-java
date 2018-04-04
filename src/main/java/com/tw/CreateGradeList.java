package com.tw;

public class CreateGradeList {

  private com.tw.Klass klass;

  public CreateGradeList(com.tw.Klass klass) {
    this.klass = klass;
  }

  //创建成绩单
  public void createGradeList(){
    if(klass.getStudents().size() == 0) {
      System.out.println("生成成绩单失败，请先添加成绩！");
    }else {
      StringBuilder str = new StringBuilder("成绩单\n"
          + "姓名|数学|语文|英语|编程|平均分|总分\n"
          + "========================\n");
      java.util.List<Student> students = klass.getStudents();

      for(Student student : students) {
        str.append(student.setGradeSheet());
      }

      str.append(String.format("全班总分平均数：%s\n全班总分中位数：%s", klass.getAverageOfAllClass(), klass.getMedianOfAllClass()));

      System.out.println(str.toString());
    }
  }
}
