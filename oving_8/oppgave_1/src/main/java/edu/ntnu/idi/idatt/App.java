package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Employee employee = createEmployee(sc); // Create an employee object

    while (true) {
      showMainMenu(); // Show the main menu
      int mainMenuChoice;
      try {
        mainMenuChoice = Integer.parseInt(sc.nextLine());
      }catch (NumberFormatException e) {
        System.out.println(invalidInputMessage());
        continue;
      }

      switch (mainMenuChoice) {
        case 1:
          System.out.println("\nInformation about the employee " + employee.getFirstName() + " " + employee.getLastName() + ":");
          System.out.println(employee.toString()); // Print information about the employee
          break;
        case 2:
          changeEmployeeInformation(employee, sc); // Change information about the employee
          break;
        case 3:
          checkEmployedFor(employee, sc); // Check if the employee has been employed for a certain amount of years
          break;
        case 4:
          System.exit(0); // Exit the program
          break;
        default:
          System.out.println(invalidChoiceMessage(mainMenuChoice)); // Print an error message if the choice is invalid
          break;
      }
    }
  }

  /**
   * Method for creating an Employee object
   *
   * @param sc
   * @return Employee object with the information given by the user
   */
  public static Employee createEmployee(Scanner sc) {
    while (true) {
      try{
        System.out.println("Enter first name: ");
        String firstName = sc.nextLine().trim();
        System.out.println("Enter last name: ");
        String lastName = sc.nextLine().trim();
        System.out.println("Enter birth year: ");
        int birthYear = Integer.parseInt(sc.nextLine());

        Person person = new Person(firstName, lastName, birthYear);

        System.out.println("Enter the employee number: ");
        int employeeNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the year the employee was hired: ");
        int hiredYear = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the monthly salary of the employee: ");
        double monthlySalary = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the tax percentage of the employee: ");
        double taxPercentage = Double.parseDouble(sc.nextLine());

        return new Employee(person, employeeNumber, hiredYear, monthlySalary, taxPercentage);
      } catch (NumberFormatException e) {
        System.out.println(invalidInputMessage());
      }
    }
  }

  /**
   * Method for showing the main menu
   */
  public static void showMainMenu() {
    System.out.println("\nWhat would you like to do next?");
    System.out.println("1. Print information about the employee");
    System.out.println("2. Change information about the employee");
    System.out.println("3. Check if the employee has been employed for certain amount of years");
    System.out.println("4. Exit the program");
  }

  /**
   * Method for changing the employee's information
   *
   * @param employee the employee to change information about
   * @param sc the scanner object
   */
  public static void changeEmployeeInformation(Employee employee, Scanner sc) {
    while (true) {
      System.out.println("\nWhat would you like to change?");
      System.out.println("1. Monthly salary");
      System.out.println("2. Tax percentage");
      System.out.println("3. Nothing, go back to the main menu");
      try {
        int change = Integer.parseInt(sc.nextLine());
        if (change == 1) {
          System.out.println("\nEnter the new monthly salary: ");
          double newMonthlySalary = Double.parseDouble(sc.nextLine());
          employee.setMonthlySalary(newMonthlySalary);
          System.out.println("\nThe new monthly salary is: " + employee.getMonthlySalary());
        } else if (change == 2) {
          System.out.println("\nEnter the new tax percentage: ");
          double newTaxPercentage = Double.parseDouble(sc.nextLine());
          employee.setTaxPercentage(newTaxPercentage);
          System.out.println("\nThe new tax percentage is: " + employee.getTaxPercentage());
        } else if (change == 3) {
          System.out.println("\nGoing back to the main menu.");
        } else {
          System.out.println(invalidChoiceMessage(change));
          continue;
        }
        return;
      } catch(NumberFormatException e) {
        System.out.println(invalidInputMessage());
      }
    }
  }

  /**
   * Method for checking if the employee has been employed for a certain amount of years
   *
   * @param employee the employee to check
   * @param sc the scanner object
   */
  public static void checkEmployedFor(Employee employee, Scanner sc) {
    while (true) {
      try {
        System.out.println("\nEnter the amount of years you want to check if the employee has been employed for: ");
        int years = Integer.parseInt(sc.nextLine());
        if (employee.hasBeenEmployedFor(years)) {
          System.out.println("Yes, the employee has been employed for " + years + " years.");
        } else {
          System.out.println("No, the employee has not been employed for " + years + " years.");
        }
        return;
      } catch (NumberFormatException e) {
        System.out.println(invalidInputMessage());
      }
    }
  }

  /**
   * Method that gives an error message to be printed when the input is invalid
   *
   * @return the invalid input message
   */
  public static String invalidInputMessage() {
    return "\n-------------\nInvalid input\n-------------";
  }

  /**
   * Method that gives an error message to be printed when the choice is invalid
   *
   * @param choice the invalid choice
   * @return the invalid choice message
   */
  public static String invalidChoiceMessage(int choice) {
    return "\n-----------------------\n" + choice + " is not a valid option\n-----------------------";
  }
}