package com.tw;

public class Student {

  private String id;
  private String name;
  private double math;
  private double english;
  private double chinese;
  private double coding;


  public Student(String id, String name, double math, double english, double chinese, double coding) {
    this.id = id;
    this.name = name;
    this.math = math;
    this.english = english;
    this.chinese = chinese;
    this.coding = coding;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setMath(double math) {
    this.math = math;
  }

  public double getMath() {
    return math;
  }

  public void setEnglish(double english) {
    this.english = english;
  }

  public double getEnglish() {
    return english;
  }

  public void setChinese(double chinese) {
    this.chinese = chinese;
  }

  public double getChinese() {
    return chinese;
  }

  public void setCoding(double coding) {
    this.coding = coding;
  }

  public double getCoding() {
    return coding;
  }

  double getSum() {
    double sum = math + chinese + english + coding;
    return sum;
  }

  private double getAverage() {
    double average = getSum() / 4;
    return average;
  }

  public String setGradeSheet() {
    return String.format("%s|%s|%s|%s|%s|%s|%s\n", name, math, chinese, english, coding, getAverage(), getSum());
  }
}
