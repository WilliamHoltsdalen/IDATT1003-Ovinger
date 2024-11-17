package edu.ntnu.idi.idatt;

/**
 * A class representing a dish.
 * <p>
 * A dish has a name, type, price and a recipe.
 * The name, type and recipe cannot be null or blank.
 * The price cannot be negative.
 */
public class Dish {
  private final String name;
  private final String type;
  private final double price;
  private final String recipe;

  /**
   * Constructs a dish with a name, type, price and recipe.
   *
   * @param name the name of the dish
   * @param type the type of the dish
   * @param price the price of the dish
   * @param recipe the recipe of the dish
   * @throws IllegalArgumentException if name, type or recipe is null or blank, or if price is
 *           negative
   */
  public Dish(String name, String type, double price, String recipe) throws IllegalArgumentException {
    if (name == null || type == null || recipe == null) {
      throw new IllegalArgumentException("Name, type and description cannot be null");
    }
    if (name.isBlank() || type.isBlank() || recipe.isBlank()) {
      throw new IllegalArgumentException("Name, type and description cannot be blank");
    }
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }

    this.name = name;
    this.type = type;
    this.price = price;
    this.recipe = recipe;
  }

  /**
   * @return the name of the dish
   */
  public String getName() {
    return name;
  }

  /**
   * @return the type of the dish
   */
  public String getType() {
    return type;
  }

  /**
   * @return the price of the dish
   */
  public double getPrice() {
    return price;
  }

  /**
   * @return the recipe of the dish
   */
  public String getRecipe() {
    return recipe;
  }
}
