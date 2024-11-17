package edu.ntnu.idi.idatt;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents a register of dishes and menus.
 * <p>
 * Contains a map of dishes and a map of menus. The dishes are stored in a map where the
 * key is the name of the dish and the value is the dish object. The menus are stored in a map where
 * the key is the name of the menu and the value is the menu object. The register has methods to add
 * and remove dishes and menus, and to retrieve dishes and menus from the register. If a dish or
 * menu is added to the register, it cannot be null and it cannot already exist in the register. If
 * a dish or menu is removed from the register, it must exist in the register. If a dish or menu is
 * retrieved from the register, it must exist in the register. The register also has accessor
 * methods to get the dishes and menus in the register.
 */
public class MenuRegister {
  private final Map<String, Dish> dishes = new HashMap<>();
  private final Map<String, Menu> menus = new HashMap<>();

  /**
   * @return a map of all dishes in the register.
   */
  public Map<String, Menu> getMenus() {
    return menus;
  }

  /**
   * @return a map of all menus in the register.
   */
  public Map<String, Dish> getDishes() {
    return dishes;
  }

  /**
   * Returns the dish with the specified name.
   *
   * @param dishName the name of the dish.
   * @return the dish with the specified name.
    * @throws IllegalArgumentException if the name is null or blank, or if the dish does not exist.
    */
  public Dish getDish(String dishName) {
    if (dishName == null || dishName.isBlank()) {
      throw new IllegalArgumentException("Name cannot equal null or an empty string");
    }
    if (!dishes.containsKey(dishName)) {
      throw new IllegalArgumentException("Dish does not exist in the register");
    }
    return dishes.get(dishName);
  }

  /**
   * Returns the menu with the specified name.
   *
   * @param menuName the name of the menu.
   * @return the menu with the specified name.
    * @throws IllegalArgumentException if the name is null or blank, or if the menu does not exist.
    */
  public Menu getMenu(String menuName) {
    if (menuName == null || menuName.isBlank()) {
      throw new IllegalArgumentException("Name cannot equal null or an empty string");
    }
    if (!menus.containsKey(menuName)) {
      throw new IllegalArgumentException("Menu does not exist in the register");
    }
    return menus.get(menuName);
  }

  /**
   * Adds a dish to the register.
   * <p>
   * If the dish already exists in the register, the method will throw an
   * {@code IllegalArgumentException}.
   *
   * @param dish the dish to add.
   * @throws IllegalArgumentException if the dish is null or if the dish already exists in the
   *         register.
   */
  public void addDish(Dish dish) {
    if (dish == null) {
      throw new IllegalArgumentException("Dish cannot be null");
    }
    if (dishes.containsKey(dish.getName())) {
      throw new IllegalArgumentException("Dish already exists in the register");
    }
    dishes.put(dish.getName(), dish);
  }

  /**
   * Adds a menu to the register.
   * <p>
   * If the menu already exists in the register, the method will throw an
   * {@code IllegalArgumentException}.
   *
   * @param menu the menu to add.
   * @throws IllegalArgumentException if the specified menu equals null or already exists in the
   *         register.
   */
  public void addMenu(Menu menu) {
    if (menu == null) {
      throw new IllegalArgumentException("Menu cannot be null");
    }
    if (menus.containsKey(menu.getName())) {
      throw new IllegalArgumentException("Menu already exists in the register");
    }
    menus.put(menu.getName(), menu);
  }

  /**
   * Removes a dish from the register.
   * <p>
   * If the dish does not exist in the register, the method will throw an
   * {@code IllegalArgumentException}.
   *
   * @param dishName the name of the dish to remove.
   * @throws IllegalArgumentException if the name is null or blank, or if the dish does not exist in
   *         the register.
   */
  public void removeDish(String dishName) {
    if (dishName == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    if (!dishes.containsKey(dishName)) {
      throw new IllegalArgumentException("Dish does not exist in the register");
    }
    dishes.remove(dishName);
  }

  /**
   * Removes a menu from the register.
   * <p>
   * If the menu does not exist in the register, the method will throw an
   * {@code IllegalArgumentException}.
   *
   * @param menuName the name of the menu to remove.
   * @throws IllegalArgumentException if the name is null or blank, or if the menu does not exist in
   *         the register.
   */
  public void removeMenu(String menuName) {
    if (menuName == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    if (!menus.containsKey(menuName)) {
      throw new IllegalArgumentException("Menu does not exist in the register");
    }
    menus.remove(menuName);
  }
}
