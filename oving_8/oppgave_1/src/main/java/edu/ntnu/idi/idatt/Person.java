package edu.ntnu.idi.idatt;

public class Person {
  private final String firstName;
  private final String lastName;
  private final int birthYear;

  /**
   * Constructor for the Person class
   *
   * @param firstName the first name of the person
   * @param lastName the last name of the person
   * @param birthYear the birth year of the person
   */
  public Person(String firstName, String lastName, int birthYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthYear = birthYear;
  }

  /**
   * @return firstName the first name of the person
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the last name of the person
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return the birth year of the person
   */
  public int getBirthYear() {
    return birthYear;
  }
}