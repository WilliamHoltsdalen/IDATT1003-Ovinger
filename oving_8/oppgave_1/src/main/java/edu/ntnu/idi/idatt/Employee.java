package edu.ntnu.idi.idatt;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee {
  private final Person personalia;
  private final int employeeNumber;
  private final int yearOfHire;
  private double monthlySalary;
  private double taxPercentage;

  public Employee(Person personalia, int employeeNumber, int yearOfHire, double monthlySalary, double taxPercentage) {
    this.personalia = personalia;
    this.employeeNumber = employeeNumber;
    this.yearOfHire = yearOfHire;
    this.monthlySalary = monthlySalary;
    this.taxPercentage = taxPercentage;
  }

  /**
   * @return the first name of the employee
   */
  public String getFirstName() {
    return personalia.getFirstName();
  }

  /**
   * @return the last name of the employee
   */
  public String getLastName() {
    return personalia.getLastName();
  }

  /**
   * @return employeeNumber the employee number is a unique identifier for each employee
   */
  public int getEmployeeNumber() {
    return employeeNumber;
  }

  /**
   * @return yearOfHire the year the employee was hired
   */
  public int getYearOfHire() {
    return yearOfHire;
  }

  /**
   * @return monthlySalary the employee's monthly salary
   */
  public double getMonthlySalary() {
    return monthlySalary;
  }

  /**
   * @return taxPercentage the employee's tax percentage as a decimal number
   */
  public double getTaxPercentage() {
    return taxPercentage;
  }

  /**
   * Set the employee's monthly salary
   *
   * @param monthlySalary the employee's new monthly salary
   */
  public void setMonthlySalary(double monthlySalary) {
    this.monthlySalary = monthlySalary;
  }

  /**
   * Set the employee's tax percentage
   *
   * @param taxPercentage the employee's new tax percentage as a decimal number
   */
  public void setTaxPercentage(double taxPercentage) {
    this.taxPercentage = taxPercentage;
  }

  /**
   * Calculate the employee's monthly tax
   *
   * @return the employee's monthly tax
   */
  public double calculateMonthlyTax() {
    return monthlySalary * taxPercentage/100;
  }

  /**
   * Calculate the employee's gross annual salary
   *
   * @return the employee's gross annual salary
   */
  public double calculateGrossAnnualSalary() {
    return monthlySalary * 12;
  }

  /**
   * Calculate the employee's annual tax
   *
   * The salary for June is not taxed, and the salary for December is taxed at half the rate
   *
   * @return the employee's annual tax amount
   */
  public double calculateAnnualTax() {
    return monthlySalary * (10 * taxPercentage/100 + taxPercentage/100 / 2);
  }

  /**
   * Get employee's formatted name
   *
   * @return the name of the employee in the format "lastName, firstName"
   */
  public String formattedName() {
    return personalia.getLastName() + ", " + personalia.getFirstName();

  }

  /**
   * Calculate the age of the employee
   *
   * @return the age of the employee according to the gregorian calendar
   */
  public int calculateAge() {
    return new GregorianCalendar().get(Calendar.YEAR) - personalia.getBirthYear();
  }

  /**
   * Get the number of years the employee has been employed
   *
   * @return the number of years the employee has been employed according to the gregorian calendar
   */
  public int calculateYearsEmployed() {
    return new GregorianCalendar().get(Calendar.YEAR) - yearOfHire;
  }

  /**
   * Find out if the employee has been employed for more than a certain number of years
   *
   * @param years the number of years to check if the employee has been employed for
   * @return true if the employee has been employed for more than the specified number of years, false otherwise
   */
  public boolean hasBeenEmployedFor(int years) {
    return calculateYearsEmployed() > years;
  }

  /**
   * @return a string representation of the employee
   */
  @Override
  public String toString() {
    return "Formatted name: " + formattedName() + "\n" +
        "Employee number: " + employeeNumber + "\n" +
        "Year of hire: " + yearOfHire + "\n" +
        "Years employed: " + calculateYearsEmployed() + "\n" +
        "Tax percentage: " + taxPercentage + "%\n" +
        "Monthly salary: " + monthlySalary + " kr\n" +
        "Tax monthly: " + calculateMonthlyTax() + " kr\n" +
        "Gross annual salary: " + calculateGrossAnnualSalary() + " kr\n" +
        "Tax annually: " + calculateAnnualTax() + " kr\n" +
        "Age: " + calculateAge() + "\n";
  }
}