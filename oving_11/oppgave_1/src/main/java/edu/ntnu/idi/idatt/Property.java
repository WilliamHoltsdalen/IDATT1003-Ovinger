package edu.ntnu.idi.idatt;

/**
 * Class for the property object. The class contains information about a property, such as the
 * municipality number, municipality name, lot number, section number, name, area and owner name.
 * The class contains a constructor that initializes the property object with the given parameters.
 * The class also contains a method to get the property identifier, which is a combination of the
 * municipality number, lot number and section number.
 */
public class Property {
  private final int municipalityNumber;
  private final String municipalityName;
  private int lotNumber;
  private int sectionNumber;
  private final String name;
  private double area;
  private final String ownerName;

  /**
   * Constructor that initializes the property object with the given parameters. The constructor
   * throws an IllegalArgumentException if any of the parameters are invalid.
   *
   * @param municipalityNumber the municipality number of the property. Must be between 101 & 5054.
   * @param municipalityName the municipality name of the property.
   * @param lotNumber the lot number of the property. The lot number must be a positive number.
   * @param sectionNumber the section number of the property. Must be a positive number.
   * @param name the name of the property.
   * @param area the area of the property. The area must be a positive number.
   * @param ownerName the owner name of the property.
   * @throws IllegalArgumentException if any of the parameters are invalid.
   */
  public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
      String name, double area, String ownerName) throws IllegalArgumentException {
    if (municipalityNumber < 101 || municipalityNumber > 5054) {
      throw new IllegalArgumentException("Municipality number must be between 101 and 5054");
    }
    if (municipalityName == null || municipalityName.isBlank()) {
      throw new IllegalArgumentException("Municipality name can not be null or empty");
    }
    if (lotNumber <= 0) {
      throw new IllegalArgumentException("Lot number must be a positive number");
    }
    if (sectionNumber <= 0) {
      throw new IllegalArgumentException("Section number must be a positive number");
    }
    if (name == null) {
      throw new IllegalArgumentException("Name can not be null");
    }
    if (area <= 0) {
      throw new IllegalArgumentException("Area must be a positive number");
    }
    if (ownerName == null || ownerName.isBlank()) {
      throw new IllegalArgumentException("Owner name can not be null or empty");
    }

    this.municipalityNumber = municipalityNumber;
    this.municipalityName = municipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.ownerName = ownerName;
  }

  /**
   * @return the municipality number of the property.
   */
  public int getMunicipalityNumber() {
    return municipalityNumber;
  }

  /**
   * @return the municipality name of the property.
   */
  public String getMunicipalityName() {
    return municipalityName;
  }

  /**
   * @return the lot number of the property.
   */
  public int getLotNumber() {
    return lotNumber;
  }

  /**
   * @return the section number of the property.
   */
  public int getSectionNumber() {
    return sectionNumber;
  }

  /**
   * @return the name of the property.
   */
  public String getName() {
    return name;
  }

  /**
   * @return the area of the property.
   */
  public double getArea() {
    return area;
  }

  /**
   * @return the owner name of the property.
   */
  public String getOwnerName() {
    return ownerName;
  }

  /**
   * @return the property identifier of the property.
   */
  public String getPropertyIdentifier() {
    return String.format("%d-%d/%d", getMunicipalityNumber(), getLotNumber(), getSectionNumber());
  }

  /**
   * Sets the lot number of the property. The method throws an IllegalArgumentException if the lot
   * number is not a positive number or if the lot number is the same as the current lot number.
   *
   * @param lotNumber the lot number of the property.
   * @throws IllegalArgumentException if the lot number is not a positive number or if the lot
   *                                  number is the same as the current lot number.
   */
  public void setLotNumber(int lotNumber) {
    if (lotNumber <= 0) {
      throw new IllegalArgumentException("Lot number must be a positive number");
    }
    if (lotNumber == this.lotNumber) {
      throw new IllegalArgumentException("Lot number is the same as the current lot number");
    }
    this.lotNumber = lotNumber;
  }

  /**
   * Sets the section number of the property. The method throws an IllegalArgumentException if the
   * section number is not a positive number or if the section number is the same as the current
   * section number.
   *
   * @param sectionNumber the section number of the property.
   * @throws IllegalArgumentException if the section number is not a positive number or if the
   *                                  section number is the same as the current section number.
   */
  public void setSectionNumber(int sectionNumber) {
    if (sectionNumber <= 0) {
      throw new IllegalArgumentException("Section number must be a positive number");
    }
    if (sectionNumber == this.sectionNumber) {
      throw new IllegalArgumentException(
          "Section number is the same as the current section number");
    }
    this.sectionNumber = sectionNumber;
  }

  /**
   * Sets the area of the property. The method throws an IllegalArgumentException if the area is not
   * a positive number or if the area is the same as the current area.
   *
   * @param area the area of the property.
   * @throws IllegalArgumentException if the area is not a positive number or if the area is the
   *                                  same as the current area.
   */
  public void setArea(double area) {
    if (area <= 0) {
      throw new IllegalArgumentException("Area must be a positive number");
    }
    if (area == this.area) {
      throw new IllegalArgumentException("Area is the same as the current area");
    }
    this.area = area;
  }

  /**
   * Returns a string representation of the property object. The string representation contains
   * information about the property, such as the municipality number, lot number, section number,
   * name, area and owner name.
   *
   * @return a string representation of the property object.
   */
  @Override
  public String toString() {
    return "Property info: " + '\n'
        + "Identifier: " + getPropertyIdentifier() + '\n'
        + "Municipality name: " + getMunicipalityName() + '\n'
        + "Name: " + getName() + '\n'
        + "Area: " + getArea() + "m2" + '\n'
        + "Owner: " + getOwnerName();
  }
}
