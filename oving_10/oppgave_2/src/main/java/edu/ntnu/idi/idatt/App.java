package edu.ntnu.idi.idatt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The main class of the application.
 * <p>
 * Contains the main menu and methods for handling user input.
 * The main menu allows the user to register dishes and menus, print all menus, find a dish by name,
 * find dishes by type, find menus by max price, and exit the application.
 * The application also contains example data to demonstrate the functionality.
 */
public class App {

  /**
   * The main method of the application.
   * <p>
   * The main method initializes a {@code Scanner} object and a {@code MenuRegister} object.
   * It then adds example data to the menu register and enters the main menu loop.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MenuRegister menuRegister = new MenuRegister();

    addExampleData(menuRegister);

    System.out.println("Welcome to the menu register!");
    while (true) {
      boolean loop = mainMenu(sc, menuRegister);

      if (!loop) {
        break;
      }
    }
  }

  /**
   * The main menu of the application.
   * <p>
   * The main menu allows the user to register dishes and menus, print all menus, find a dish by
   * name, find dishes by type, find menus by max price, and exit the application.
   * @param sc the scanner object used to read user input.
   * @param menuRegister the menu register object used to store dishes and menus.
   * @return {@code true} if the user wants to continue using the application, {@code false} if the
   * user wants to exit.
   */
  public static boolean mainMenu(Scanner sc, MenuRegister menuRegister) {
    System.out.println("\nMain menu:");
    System.out.println("1. Register a new dish");
    System.out.println("2. Register a new menu");
    System.out.println("3. Print all menus");
    System.out.println("4. Find dish by name");
    System.out.println("5. Find dishes by type");
    System.out.println("6. Find menus by max price");
    System.out.println("7. Exit");
    System.out.print("Choose alternative: ");

    int choice = 0;

    try {
      choice = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid choice");
      return true;
    }

    switch (choice) {
      case 1:
        registerDish(sc, menuRegister);
        break;
      case 2:
        registerMenu(sc, menuRegister);
        break;
      case 3:
        printMenus(menuRegister);
        break;
      case 4:
        printDish(menuRegister);
        break;
      case 5:
        printDishesByType(menuRegister);
        break;
      case 6:
        printMenusByMaxPrice(sc, menuRegister);
        break;
      case 7:
        return false;
      default:
        System.out.println("Invalid choice");
    }
    return true;
  }

  /**
   * Registers a new dish.
   * <p>
   * The method prompts the user to enter the name, type, price, and recipe of the dish.
   * The dish is then added to the menu register.
   * @param sc the scanner object used to read user input.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void registerDish(Scanner sc, MenuRegister menuRegister) {
    try {
      System.out.print("Enter the name of the dish: ");
      String name = sc.nextLine();
      System.out.print("Enter the type of the dish: ");
      String type = sc.nextLine();
      System.out.print("Enter the price of the dish: ");
      double price = Double.parseDouble(sc.nextLine());
      System.out.print("Enter the recipe of the dish: ");
      String recipe = sc.nextLine();
      Dish dish = new Dish(name, type, price, recipe);
      menuRegister.addDish(dish);
    } catch (NumberFormatException e) {
      System.out.println("Invalid price");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Registers a new menu.
   * <p>
   * The method prompts the user to enter the name of the menu and the number of dishes the menu
   * should include. The user is then prompted to enter the name of each dish. The menu is then
   * added to the menu register.
   * @param sc the scanner object used to read user input.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void registerMenu(Scanner sc, MenuRegister menuRegister) {
    try {
      System.out.print("Enter the name of the menu: ");
      String name = sc.nextLine();
      System.out.print("Enter the number of dishes you want the menu to include: ");
      int numDishes = Integer.parseInt(sc.nextLine());
      Map<String, Dish> dishes = new HashMap<>();

      for (int i = 0; i < numDishes; i++) {
        System.out.print("Enter name of dish number " + (i + 1) + ": ");
        String dishName = sc.nextLine();
        dishes.put(dishName, menuRegister.getDish(dishName));
      }

      Menu menu = new Menu(name, new HashMap<>());
      for (Map.Entry<String, Dish> entry : dishes.entrySet()) {
        menu.addDish(entry.getValue());
      }
      menuRegister.addMenu(menu);
    } catch (NumberFormatException e) {
      System.out.println("Invalid number");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Prints all menus in the menu register.
   * <p>
   * The method prints all menus in the menu register, including the name of the menu, the dishes
   * in the menu, the type of each dish, the price of each dish, and the total price of the menu.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void printMenus(MenuRegister menuRegister) {
    for (Map.Entry<String, Menu> entry : menuRegister.getMenus().entrySet()) {
      System.out.println("\n------------------");
      System.out.println(entry.getKey() + ":");
      List<String> typeOrder = Arrays.asList("Forrett", "Hovedrett", "Dessert");
      for (String type : typeOrder) {
        for (Map.Entry<String, Dish> dishEntry : entry.getValue().getDishes().entrySet()) {
          if (dishEntry.getValue().getType().equals(type)) {
            System.out.println(dishEntry.getValue().getType() + ": "
                               + dishEntry.getKey() + " - "
                               + dishEntry.getValue().getPrice() + " NOK");
          }
        }
      }
      System.out.println("\nTotal price: " + entry.getValue().getTotalPrice() + " NOK");
      System.out.println("------------------");
    }
  }

  /**
   * Prints a dish by name.
   * <p>
   * The method prompts the user to enter the name of the dish. The method then prints the name,
   * type, price, and recipe of the dish.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void printDish(MenuRegister menuRegister) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the name of the dish: ");
    String dishName = sc.nextLine();
    try {
      Dish dish = menuRegister.getDish(dishName);
      System.out.println("Name: " + dish.getName());
      System.out.println("Type: " + dish.getType());
      System.out.println("Price: " + dish.getPrice() + " NOK");
      System.out.println("Recipe: " + dish.getRecipe());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Prints dishes by type.
   * <p>
   * The method prompts the user to enter the type of the dishes they'd like to find. The method
   * then prints the name and price of all dishes with the specified type.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void printDishesByType(MenuRegister menuRegister) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the type of the dishes you'd like to find: ");
    String type = sc.nextLine();
    for (Map.Entry<String, Dish> entry : menuRegister.getDishes().entrySet()) {
      if (entry.getValue().getType().equals(type)) {
        System.out.println(entry.getKey() + " - " + entry.getValue().getPrice() + " NOK");
      }
    }
  }

  /**
   * Prints menus with a total price less than or equal to the specified max price.
   * <p>
   * The method prompts the user to enter the max price of the menus they'd like to find. The method
   * then prints the name and total price of all menus with a total price less than or equal to the
   * specified max price.
   * @param sc the scanner object used to read user input.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void printMenusByMaxPrice(Scanner sc, MenuRegister menuRegister) {
    System.out.print("Enter the max price of the menus you'd like to find: ");
    try {
      double maxPrice = Double.parseDouble(sc.nextLine());
      for (Map.Entry<String, Menu> entry : menuRegister.getMenus().entrySet()) {
        if (entry.getValue().getTotalPrice() <= maxPrice) {
          System.out.println(entry.getKey() + " - " + entry.getValue().getTotalPrice());
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid price");
    }
  }

  /**
   * Adds example data to the menu register.
   * <p>
   * The method adds example dishes and menus to the menu register.
   * @param menuRegister the menu register object used to store dishes and menus.
   */
  public static void addExampleData(MenuRegister menuRegister) {
    Dish dish1 = new Dish("Biff Stroganoff", "Hovedrett", 170,
        "Stek kjøtt, tilsett fløte og sopp. Server med ris.");
    Dish dish2 = new Dish("Pasta Bolognese", "Hovedrett", 125,
        "Kok pasta, stek kjøttdeig, tilsett tomatsaus. Bland sammen.");
    Dish dish3 = new Dish("Pasta Pesto", "Hovedrett", 100,
        "Kok pasta, plasser i en bolle, tilsett pesto.");
    Dish dish4 = new Dish("Salat", "Forrett", 50,
        "Bland salat, tomat, agurk og paprika i en bolle. Server med dressing.");
    Dish dish5 = new Dish("Iskrem", "Dessert", 30,
        "Lag to kuler med iskrem, og plasser i en skål.");
    Dish dish6 = new Dish("Fruktsalat", "Dessert", 40,
        "Kutt opp frukt og bær, og bland sammen i en bolle.");
    Dish dish7 = new Dish("Sjokoladekake", "Dessert", 60,
        "Bland sammen ingrediensene, og stek i ovnen.");
    Dish dish8 = new Dish("Brødskive", "Forrett", 20,
        "Legg pålegg på brødskive.");

    menuRegister.addDish(dish1);
    menuRegister.addDish(dish2);
    menuRegister.addDish(dish3);
    menuRegister.addDish(dish4);
    menuRegister.addDish(dish5);
    menuRegister.addDish(dish6);
    menuRegister.addDish(dish7);
    menuRegister.addDish(dish8);

    Menu menu1 = new Menu("Barnemeny", new HashMap<>());
    menu1.addDish(dish8);
    menu1.addDish(dish2);
    menu1.addDish(dish4);
    menu1.addDish(dish5);
    menuRegister.addMenu(menu1);

    Menu menu2 = new Menu("Standard meny", new HashMap<>());
    menu2.addDish(dish4);
    menu2.addDish(dish3);
    menu2.addDish(dish5);
    menuRegister.addMenu(menu2);

    Menu menu3 = new Menu("Dagens meny", new HashMap<>());
    menu3.addDish(dish8);
    menu3.addDish(dish2);
    menu3.addDish(dish7);
    menuRegister.addMenu(menu3);
  }

}