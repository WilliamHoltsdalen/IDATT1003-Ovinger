package com.oppgave1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AssignmentOverview overview = new AssignmentOverview();
    mainMenu(sc, overview);
  }

  /**
   * Main menu for the program.
   * <p>
   * The user can choose between the following options:
   * <ul>
   * <li>Find number of registered students.</li>
   * <li>Register a new student.</li>
   * <li>Find number of completed assignments for a student.</li>
   * <li>Increase number of completed assignments for a student.</li>
   * <li>Exit.</li>
   * </ul>
   * <p>
   * Prompts the user to enter a number to choose an option. When inputting an invalid option,
   * the user gets an error message and can try again.
   *
   * @param sc Object of Scanner class for reading user input.
   * @param overview Object of AssignmentOverview class for managing students and assignments.
   */
  public static void mainMenu(Scanner sc, AssignmentOverview overview) {

    while (true) {
      System.out.println("\n\nEnter a number to choose an option:");
      System.out.println("1. Find number of registered students.");
      System.out.println("2. Register a new student.");
      System.out.println("3. Find number of completed assignments for a student.");
      System.out.println("4. Increase number of completed assignments for a student.");
      System.out.println("5. Print name and completed assignments for all registered students.");
      System.out.println("6. Exit.");

      int choice;

      try {
        choice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("""
                           -------------------------------------
                           Invalid input, please enter a number.
                           -------------------------------------
                           """);
        continue;
      }
      boolean loop = true;
      switch (choice) {
        case 1:
          System.out.println("\nNumber of registered students: " + overview.getNrOfStudents());
          break;
        case 2:
          System.out.println("\n\nEnter the name of the student you want to register:");
          try {
            overview.addStudent(new Student(sc.nextLine().trim()));
          } catch (IllegalArgumentException e) {
            System.out.println("""
                           -----------------------------
                           Name cannot be null or blank.
                           -----------------------------
                           """);
            break;
          }
          System.out.println("\nStudent has been registered.");
          break;
        case 3:
          System.out.println("\n\nEnter the name of the student you want to find the number of completed assignments for:");
          String name = sc.nextLine().trim();
          try {
            System.out.println("\nNumber of completed assignments for " + name + ": " +
                               overview.getNrOfAssignments(name));
          } catch (IllegalArgumentException e) {
            System.out.println("""
                           --------------------------
                           The student was not found.
                           --------------------------
                           """);
          }
          break;
        case 4:
          System.out.println("\n\nEnter the name of the student you want to increase the number of completed assignments for:");
          String studentName = sc.nextLine();
          try {
            System.out.println("\nEnter the number of assignments you want to increase by:");
            int increase = Integer.parseInt(sc.nextLine());
            overview.incNrOfAssignments(studentName, increase);
            System.out.println("\nNumber of completed assignments for " + studentName + " has been increased.");
          } catch (IllegalArgumentException e) {
            System.out.println("""
                           --------------
                           Invalid input.
                           --------------
                           """);
          }
          break;
        case 5:
          System.out.println(overview.toString());
          break;
        case 6:
          loop = false;
          break;
        default:
          System.out.println("""
                           -----------------------------------------------------
                           Invalid input, please enter a number between 1 and 5.
                           -----------------------------------------------------
                           """);
          break;
      }
      if (!loop) {
        return;
      }
    }
  }
}