package edu.ntnu.idi.idatt;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for the property register. The class contains a map of properties and methods to add,
 * remove, get and calculate the average area of the properties in the register. The class also
 * contains a method to get a property from the register, based on its identifier.
 */
public class PropertyRegister {
  private final Map<String, Property> properties = new HashMap<>();

  /**
   * Returns the property with the given property identifier. The identifier is a combination of the
   * municipality number, lot number and section number of the property, in the format
   * municipalityNumber-lotNumber/sectionNumber. The method throws an IllegalArgumentException if
   * the property with the given identifier does not exist.
   *
   * @param propertyIdentifier the property identifier of the property to get.
   * @return the property with the given property identifier.
   * @throws IllegalArgumentException if the property with the given identifier does not exist.
   */
  public Property getProperty(String propertyIdentifier) throws IllegalArgumentException {
    if (!properties.containsKey(propertyIdentifier)) {
      throw new IllegalArgumentException("Property with identifier " + propertyIdentifier
          + " does not exist");
    }
    return properties.get(propertyIdentifier);
  }

  /**
   * Returns a map of all the properties in the property register.
   *
   * @return a map of all the properties in the property register.
   * @throws IllegalArgumentException if the property register is empty.
   */
  public Map<String, Property> getAllProperties() throws IllegalArgumentException {
    if (properties.isEmpty()) {
      throw new IllegalArgumentException("No properties in the register");
    }
    return properties;
  }

  /**
   * Returns the amount of properties in the property register. The method throws an
   * IllegalArgumentException if the property register is empty.
   *
   * @return the amount of properties in the property register.
   * @throws IllegalArgumentException if the property register is empty.
   */
  public int getAmountOfProperties() throws IllegalArgumentException {
    if (properties.isEmpty()) {
      throw new IllegalArgumentException("The property register is empty");
    }
    return properties.size();
  }

  /**
   * Adds the given property to the property register. The method throws an IllegalArgumentException
   * if a property with the same property identifier already exists in the register.
   *
   * @param property the property to add to the property register.
   * @throws IllegalArgumentException if a property with the same property identifier already
   *                                  exists.
   */
  public void addProperty(Property property) throws IllegalArgumentException {
    if (properties.containsKey(property.getPropertyIdentifier())) {
      throw new IllegalArgumentException("Property with identifier "
          + property.getPropertyIdentifier() + " already exists");
    }
    properties.put(property.getPropertyIdentifier(), property);
  }

  /**
   * Removes the property with the given property identifier from the property register. The method
   * throws an IllegalArgumentException if the property with the given identifier does not exist.
   *
   * @param propertyIdentifier the property identifier of the property to remove.
   * @throws IllegalArgumentException if the property with the given identifier does not exist.
   */
  public void removeProperty(String propertyIdentifier) throws IllegalArgumentException {
    if (!properties.containsKey(propertyIdentifier)) {
      throw new IllegalArgumentException("Property with identifier " + propertyIdentifier
          + " does not exist");
    }
    properties.remove(propertyIdentifier);
  }

  /**
   * Returns the average area of all the properties in the property register.
   *
   * @return the average area of the properties in the property register.
   */
  public double averageArea() {
    double sum = 0;
    for (Property property : properties.values()) {
      sum += property.getArea();
    }
    return sum / properties.size();
  }
}
