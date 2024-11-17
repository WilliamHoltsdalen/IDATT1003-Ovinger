package edu.ntnu.idi.idatt;

import java.util.Scanner;

/**
 * Application class for the property register program.
 * The main class contains the main method that initializes the scanner and property register, and
 * starts the text user interface.
 */
public class App {
  /**
   * Main method that initializes the scanner and property register, and starts the text user
   * interface.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    PropertyRegister propertyRegister = new PropertyRegister();
    TextUserInterface textUserInterface = new TextUserInterface(scanner, propertyRegister);

    textUserInterface.init(); // Initialize the property register with some example properties
    textUserInterface.start(); // Start the text user interface
  }
}