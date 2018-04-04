package com.tw;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Klass {

  private List<Student> students = new ArrayList<>();

  public List<Student> getStudents() {
    return students;
  }

  public void addStudent(Student student){
    if(students != null) {
      students.add(student);
    }
  }

  //班级总分
  private double getSumOfAllClass(){
    double sumOfAllClass = 0;
    for (Student student : students) {
      sumOfAllClass += student.getSum();
    }
    return sumOfAllClass;
  }

  //总分平均分
  public double getAverageOfAllClass() {
    double averageOfAllClass = getSumOfAllClass() / students.size();
    return averageOfAllClass;
  }

  //总分List
  public List getMedianListOfAllClass() {
    List<Double> studentGradeSumList = new ArrayList<>();
    for(Student student: students) {
      studentGradeSumList.add(student.getSum());
    }

    Collections.sort(studentGradeSumList);

    return studentGradeSumList;
  }

  //中分中位数
  public Double getMedianOfAllClass() {
    double median;

    int length = getMedianListOfAllClass().size();

    if(length % 2 == 0) {
      median = (Double.parseDouble(getMedianListOfAllClass().get(length / 2).toString()) + Double.parseDouble(getMedianListOfAllClass().get((length / 2 - 1)).toString()))/2;
    }else {
      median = Double.parseDouble(getMedianListOfAllClass().get((length / 2)).toString());
    }

    return median;
  }

}
