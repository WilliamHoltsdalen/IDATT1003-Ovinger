package com.oppgave1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the Student class
 */
class StudentTest {

  // Positive tests
  @Test
  void testStudentGetName() {
    Student student = new Student("Test");
    assertEquals("Test", student.getName());
  }

  @Test
  void testStudentIncNrOfAssignments() {
    Student student = new Student("Test");

    assertEquals(0, student.getNrOfAssignments());
    student.incNrOfAssignments(1);
    assertEquals(1, student.getNrOfAssignments());
    student.incNrOfAssignments(2);
    assertEquals(3, student.getNrOfAssignments());
  }

  // Negative tests
  @Test
  void testStudentInvalidName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Student(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Student("");
    });
  }
}