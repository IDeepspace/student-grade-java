package com.tw;


import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KlassTest {
  @Test
  public void testAddStudent() {
    Student student1 = mock(Student.class);
    Klass klass = new Klass();
    klass.addStudent(student1);

    assertTrue(klass.getStudents().contains(student1));
  }

  @Test
  public void testGetSumOfAllClass() {
    Student student1 = mock(Student.class);
    Student student2 = mock(Student.class);
    Student student3 = mock(Student.class);

    when(student1.getSum()).thenReturn(400.0);
    when(student2.getSum()).thenReturn(318.0);
    when(student3.getSum()).thenReturn(300.0);

    Klass klass = new Klass();
    klass.addStudent(student1);
    klass.addStudent(student2);
    klass.addStudent(student3);
    Double expected = 1018.0;
    assertEquals(expected,klass.getSumOfAllClass(),0.001);

  }

  @Test
  public void testGetMedianOfAllClass() {
    Student student1 = mock(Student.class);
    Student student2 = mock(Student.class);
    Student student3 = mock(Student.class);

    when(student1.getSum()).thenReturn(400.0);
    when(student2.getSum()).thenReturn(318.0);
    when(student3.getSum()).thenReturn(300.0);

    Klass klass = new Klass();
    klass.addStudent(student1);
    klass.addStudent(student2);
    klass.addStudent(student3);
    Double expected = 318.0;
    assertEquals(expected,klass.getMedianOfAllClass(),0.001);
  }

}
