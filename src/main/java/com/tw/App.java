package com.tw;

public class App {

  public static void main(String[] args) {
    Klass klass = new Klass();
    Operator run = new Operator(klass);
    run.start();
  }
}
