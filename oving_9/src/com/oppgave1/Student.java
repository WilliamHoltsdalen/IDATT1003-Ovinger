package com.oppgave1;

/**
 * Class for representing a student.
 * <p>
 * Has a name, and count of completed assignments. The amount of completed assignments
 * initializes to 0 at object creation. The class has a method to increase the count of
 * completed assignments.
 */
public class Student {

  private final String name; // Name of the student
  private int nrOfAssignments = 0; // Amount of completed and approved assignments

  /**
   * Constructor for Student class.
   * <p>
   * Initializes the student object with a name. The name cannot equal null or an empty string.
   *
   * @param name The name of the student.
   * @throws IllegalArgumentException If the name equals null or an empty string.
   */
  public Student(String name) throws IllegalArgumentException {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or blank");
    }
    this.name = name;
  }

  /**
   * @return The name of the student.
   */
  public String getName() {
    return name;
  }

  /**
   * @return The amount of completed assignments.
   */
  public int getNrOfAssignments() {
    return nrOfAssignments;
  }

  /**
   * Increases the amount of completed assignments by 1.
   */
  public void incNrOfAssignments(int increase) {
    nrOfAssignments += increase;
  }

  /**
   * @return A string representation of the student. Including {@code name} and
   *         {@code nrOfAssignments}.
   */
  @Override
  public String toString() {
    return "Name: " + name + ", Completed assignments: " + nrOfAssignments + "\n";
  }
}