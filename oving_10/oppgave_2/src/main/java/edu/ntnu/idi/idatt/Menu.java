package edu.ntnu.idi.idatt;

import java.util.Map;

/**
 * Represents a restaurant menu.
 * <p>
 * A menu consists of a name, a list of dishes, and a price total. The total price of the menu is
 * calculated based on the price of the dishes in the menu. The name of the menu cannot be null or
 * blank. The list of dishes cannot be null, but can be empty. The price total is calculated as the
 * sum of the prices of the dishes in the menu. The price total cannot be negative. The menu has
 * methods to add and remove dishes from the menu. If a dish is added to or removed from the menu,
 * the total price of the menu is updated. The menu has accessor methods to get the name, dishes
 * and total price of the menu.
 */
public class Menu {
  private final String name;
  private final Map<String, Dish> dishes;
  private double totalPrice;

  /**
   * Constructs a menu with a name and a list of dishes.
   *
   * @param name the name of the menu
   * @param dishes the list of dishes in the menu
   * @throws IllegalArgumentException if the name is null or blank
   */
  public Menu(String name, Map<String, Dish> dishes) {
    this.name = name;
    this.totalPrice = 0;
    this.dishes = dishes;
  }

  /**
   * @return the name of the menu
   */
  public String getName() {
    return name;
  }

  /**
   * @return the dishes in the menu
   */
  public Map<String, Dish> getDishes() {
    return dishes;
  }

  /**
   * @return the total price of the menu
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  /**
   * Adds a dish to the menu.
   * <p>
   * The total price of the menu is updated when a dish is added. If the dish already exists in the
   * menu, an {@code IllegalArgumentException} is thrown. The dish is added to the menu with the
   * dish name as the key.
   *
   * @param dish the dish to add
   * @throws IllegalArgumentException if the dish already exists in the menu
   */
  public void addDish(Dish dish) {
    if (dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish already exists in the menu");
    }
    dishes.put(dish.getName(), dish);
    totalPrice += dish.getPrice();
  }

  /**
   * Removes a dish from the menu.
   * <p>
   * The total price of the menu is updated when a dish is removed. If the dish does not exist in @
   * the menu, an {@code IllegalArgumentException} is thrown. The dish is removed from the menu
   * using the dish name as the key.
   *
   * @param dishName the name of the dish to remove
   * @throws IllegalArgumentException if the dish does not exist in the menu
   */
  public void removeDish(String dishName) {
    if (!dishes.containsKey(dishName)) {
      throw new IllegalArgumentException("Dish does not exist in the menu");
    }
    totalPrice -= dishes.get(dishName).getPrice();
    dishes.remove(dishName);
  }
}
