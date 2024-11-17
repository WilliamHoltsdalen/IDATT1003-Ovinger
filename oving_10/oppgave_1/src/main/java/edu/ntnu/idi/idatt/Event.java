package edu.ntnu.idi.idatt;

/**
 * Represents an event.
 * <p>
 * An event has an ID, name, location, organizer, type and date.
 * The date field represents a date and time as a 12 digit long value, where the first 8 digits represent the date in the
 * format YYYYMMDD, and the last 4 digits represent the time in the format HHMM.
 * <p>
 * The class provides a constructor for creating an event object, and accessor methods for
 * retrieving the ID, name, location, organizer, type, date and time, and date only.
 * The class also provides a {@code toString} method for returning a string representation of the
 * event.
 */
public class Event {
  private final int id;
  private final String name;
  private final String location;
  private final String organizer;
  private final String type;
  private final long date;

  /**
   * Creates a new event.
   *
   * @param id the ID of the event. Must be a positive integer.
   * @param name the name of the event. Must not equal {@code null} or an empty string.
   * @param location the location of the event. Must not equal {@code null} or an empty string.
   * @param organizer the organizer of the event. Must not equal {@code null} or an empty string.
   * @param type the event type. Must not equal {@code null} or an empty string.
   * @param date the date and time of the event. Must be a positive long value.
   * @throws IllegalArgumentException if any parameters violate the constraints specified.
   */
  public Event(int id, String name, String location, String organizer, String type, long date)
      throws IllegalArgumentException{
    if (name == null || location == null || organizer == null || type == null) {
      throw new IllegalArgumentException("One or more arguments are null");
    }
    if (name.isBlank() || location.isBlank() || organizer.isBlank() || type.isBlank()) {
      throw new IllegalArgumentException("One or more arguments are empty");
    }
    if (id <= 0) {
      throw new IllegalArgumentException("ID cannot be a negative number");
    }
    if (date <= 0) {
      throw new IllegalArgumentException("Date cannot be a negative number");
    }

    this.id = id;
    this.name = name;
    this.location = location;
    this.organizer = organizer;
    this.type = type;
    this.date = date;
  }

  /**
   * @return the ID of the event.
   */
  public int getId() {
    return id;
  }

  /**
   * @return the name of the event.
   */
  public String getName() {
    return name;
  }

  /**
   * @return the location of the event.
   */
  public String getLocation() {
    return location;
  }

  /**
   * @return the organizer of the event.
   */
  public String getOrganizer() {
    return organizer;
  }

  /**
   * @return the event type.
   */
  public String getType() {
    return type;
  }

  /**
   * @return the date and time of the event.
   */
  public long getDateAndTime() {
    return date;
  }

  /**
   * @return the date of the event.
   */
  public long getDateOnly() {
    return date / 10000;
  }

  /**
   * @return a string representation of the event.
   */
  @Override
  public String toString() {
    return "ID: " + id + ", Name: " + name + ", Location: " + location
           + ", Organizer: " + organizer + ", Type: " + type + ", Date: " + date;
  }
}
