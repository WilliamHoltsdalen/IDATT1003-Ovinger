package com.oppgave1;

import java.util.ArrayList;

/**
 * Class for managing students and assignments.
 * <p>
 * Has the fields:
 * <ul>
 * <li> {@code students} All the student objects.
 * <li> {@code nrOfStudents} The amount of registered students.
 * </ul>
 * <p>
 * The class provides the following methods:
 * <ul>
 * <li> {@code getNrOfStudents} Get the amount of registered students.
 * <li> {@code getNrOfAssignments} Get the amount of completed assignments for a student.
 * <li> {@code addStudent} Add a student to the list of students.
 * <li> {@code incNrOfAssignments} Increase the amount of completed assignments for a student.
 * <li> {@code toString} Get a string with name and count of completed assignments for each
 *      registered student.
 * </ul>
 */
public class AssignmentOverview {
  private final ArrayList<Student> students; // List of students.
  private int nrOfStudents = 0; // Amount of registered students.

  /**
   * Constructor for the AssignmentOverview class.
   * <p>
   * Initializes the list of students.
   */
  public AssignmentOverview() {
    this.students = new ArrayList<>();
  }

  /**
   * @return The amount of registered students.
   */
  public int getNrOfStudents() {
    return nrOfStudents;
  }

  /**
   * Gets the amount of completed assignments for a student.
   *
   * @param name The name of the student.
   * @return The amount completed assignments for the student with the given name.
   * @throws IllegalArgumentException If no student with the given name exists.
   */
  public int getNrOfAssignments(String name) throws IllegalArgumentException {
    for (Student student : students) {
      if (student.getName().equalsIgnoreCase(name)) {
        return student.getNrOfAssignments();
      }
    }
    // If name does not exist in students list
    throw new IllegalArgumentException("Student not found");
  }

  /**
   * Adds a student to the list of students.
   *
   * @param student The Student object to register.
   */
  public void addStudent(Student student) {
    students.add(student);
    nrOfStudents++;
  }

  /**
   * Increases the amount of completed assignments for a student by 1.
   *
   * @param name The name of the student.
   * @throws IllegalArgumentException If no student with the given name exists.
   */
  public void incNrOfAssignments(String name, int increase) throws IllegalArgumentException {
    if (increase <= 0) {
      throw new IllegalArgumentException("Increase must be a positive number");
    }
    for (Student student : students) {
      if (student.getName().equalsIgnoreCase(name)) {
        student.incNrOfAssignments(increase);
        return;
      }
    }
    throw new IllegalArgumentException("Student not found");
  }

  /**
   * @return A string with name and count of completed assignments for each registered student.
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("\n");
    for (Student student : students) {
      str.append(student.toString());
    }
    return str.toString();
  }
}