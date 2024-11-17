package edu.ntnu.idi.idatt;

import java.util.Scanner;

/**
 * Class for the text user interface of the property register.
 * The class contains a menu with options to add, remove, find properties, get all properties and
  * calculate the average area of the properties in the register.
 */
public class TextUserInterface {
  private final Scanner scanner;
  private final PropertyRegister propertyRegister;

  /**
   * Constructor for the TextUserInterface class. Initializes the scanner and propertyRegister.
   * The constructor utilizes the scanner to read input from the user, and the propertyRegister to
   * store the properties. The constructor throws an IllegalArgumentException if the scanner or
   * propertyRegister equals null.
   *
   * @param scanner Scanner object to read input from the user.
   * @param propertyRegister PropertyRegister object to store properties.
   * @throws IllegalArgumentException if scanner or propertyRegister is null.
   */
  public TextUserInterface(Scanner scanner, PropertyRegister propertyRegister)
      throws IllegalArgumentException {
    if (scanner == null) {
      throw new IllegalArgumentException("Scanner can not be null");
    }
    if (propertyRegister == null) {
      throw new IllegalArgumentException("Property register can not be null");
    }

    this.scanner = scanner;
    this.propertyRegister = propertyRegister;
  }

  /**
   * Initializes the property register used by the TextUserInterface with some example properties.
   */
  public void init() {
    Property property1 = new Property(1445, "Gloppen", 77,
        631, "", 1017.6, "Jens Olsen");
    Property property2 = new Property(1445, "Gloppen", 77,
        131, "Syningom", 661.3, "Nicolay Madsen");
    Property property3 = new Property(1445, "Gloppen", 75,
        19, "Fugletun", 650.6, "Evilyn Jensen");
    Property property4 = new Property(1445, "Gloppen", 74,
        188, "", 1457.2, "Karl Ove Bråten");
    Property property5 = new Property(1445, "Gloppen", 69,
        47, "Høiberg", 1339.4, "Elsa Indregård");

    propertyRegister.addProperty(property1);
    propertyRegister.addProperty(property2);
    propertyRegister.addProperty(property3);
    propertyRegister.addProperty(property4);
    propertyRegister.addProperty(property5);
  }

  /**
   * Starts the text user interface. The method contains a while loop that runs until the user
   * chooses to exit the program. The method prompts the user with a menu and reads the user’s
   * choice. The method then performs the action chosen by the user.
   */
  public void start() {

    while (true) {
      int choice = promptMenu(scanner);
      if (choice < 1 || choice > 6) {
        System.out.println("Invalid option");
        continue;
      }
      if (choice == 6) {
        return;
      }
      performAction(scanner, propertyRegister, choice);
    }
  }

  /**
   * Prompts the user with a menu and reads the user's choice. The method returns the user’s choice
   * as an integer. The method throws an IllegalArgumentException if the user's input is not a
   * number.
   *
   * @param scanner Scanner object to read input from the user.
   * @return the user’s choice as an integer.
   * @throws IllegalArgumentException if the user's input is not a number.
   */
  public static int promptMenu(Scanner scanner) throws IllegalArgumentException {
    System.out.println("\n\n------ Menu ------");
    System.out.println("1. Add property");
    System.out.println("2. Remove property");
    System.out.println("3. Find property");
    System.out.println("4. Find average area");
    System.out.println("5. List all properties");
    System.out.println("6. Exit");
    System.out.print("Choose an option: ");

    try {
      return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  /**
   * Performs the action chosen by the user. The method takes a scanner, a propertyRegister and an
   * integer as input. The integer represents the user’s choice. The method throws an
   * IllegalArgumentException if the user’s choice is not a valid option. The method performs the
   * action chosen by the user. The method throws an IllegalArgumentException if the user’s input is
   * invalid.
   *
   * @param scanner Scanner object to read input from the user.
   * @param propertyRegister PropertyRegister object to store properties.
   * @param choice the user’s choice as an integer.
   * @throws IllegalArgumentException if the user’s choice is not a valid option.
   */
  public static void performAction(Scanner scanner, PropertyRegister propertyRegister, int choice)
      throws IllegalArgumentException {
    switch (choice) {
      case 1:
        try {
          System.out.print("\nEnter info about the property to add\n");
          System.out.print("\nMunicipality number: ");
          final int municipalityNumber = Integer.parseInt(scanner.nextLine());

          System.out.print("Municipality name: ");
          final String municipalityName = scanner.nextLine();

          System.out.print("Lot number: ");
          final int lotNumber = Integer.parseInt(scanner.nextLine());

          System.out.print("Section number: ");
          final int sectionNumber = Integer.parseInt(scanner.nextLine());

          System.out.print("Area: ");
          final double area = Double.parseDouble(scanner.nextLine());

          System.out.print("Property name: ");
          final String name = scanner.nextLine();

          System.out.print("Owner name: ");
          final String ownerName = scanner.nextLine();

          propertyRegister.addProperty(new Property(municipalityNumber, municipalityName, lotNumber,
              sectionNumber, name, area, ownerName));
        } catch (IllegalArgumentException e) {
          System.out.println("Illegal argument: " + e.getMessage());
        }
        break;

      case 2:
        try {
          System.out.print("\nEnter info about the property to remove\n");
          System.out.print("Municipality number: ");
          int municipalityNumber = Integer.parseInt(scanner.nextLine());
          System.out.print("Lot number: ");
          int lotNumber = Integer.parseInt(scanner.nextLine());
          System.out.print("Section number: ");
          int sectionNumber = Integer.parseInt(scanner.nextLine());
          propertyRegister.removeProperty(
              municipalityNumber + "-" + lotNumber + "/" + sectionNumber);
          System.out.println("\nProperty removed");
        } catch (NumberFormatException e) {
          System.out.println("Invalid input");
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
        break;
      case 3:
        try {
          System.out.print("\nEnter info to find property\n");
          System.out.print("Municipality number: ");
          int municipalityNumber = Integer.parseInt(scanner.nextLine());
          System.out.print("Lot number: ");
          int lotNumber = Integer.parseInt(scanner.nextLine());
          System.out.print("Section number: ");
          int sectionNumber = Integer.parseInt(scanner.nextLine());


          System.out.println("\n" + propertyRegister.getProperty(municipalityNumber + "-"
              + lotNumber + "/" + sectionNumber).toString());

        } catch (NumberFormatException e) {
          System.out.println("Invalid input");
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
        break;
      case 4:
        System.out.println("Average area: " + propertyRegister.averageArea() + " m²");
        break;
      case 5:
        System.out.println("All registered properties:");
        try {
          propertyRegister.getAllProperties().forEach((k, v) ->
              System.out.println("\n" + v.toString()));
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
        break;
      case 6:
        return;
      default:
        break;
    }

  }
}
