package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class representing an event register.
 * <p>
 * The event register contains a {@code list} of event objects. The class provides methods for adding
 * and removing event objects, retrieving event objects by name, location, date, and type, and retrieving
 * all event objects in the event register. The class also provides methods for retrieving event objects
 * in a specified date interval.
 */
public class EventRegister {
  private final List<Event> events = new ArrayList<>();
  private int eventCount = 0;

  /**
   * Adds an event to the event register.
   *
   * @param event the event to add.
   * @throws IllegalArgumentException if the specified event equal {@code null}.
   */
  public void addEvent(Event event) throws IllegalArgumentException {
    if (event == null) {
      throw new IllegalArgumentException("Event cannot be null");
    }
    events.add(event);
    eventCount ++;
    events.sort(Comparator.comparingLong(Event::getDateAndTime));
  }

  /**
   * Removes an event from the event register.
   *
   * @param event the event to remove.
   * @throws IllegalArgumentException if the specified event equals {@code null}.
   */
  public void removeEvent(Event event) throws IllegalArgumentException {
    if (event == null) {
      throw new IllegalArgumentException("Event cannot be null");
    }
    events.remove(event);
    events.sort(Comparator.comparingLong(Event::getDateAndTime));
  }
  public int getEventCount() {
    return eventCount;
  }

  /**
   * Returns the event with the specified name.
   *
   * @param name the name of the event.
   * @return the event with the specified name.
   * @throws IllegalArgumentException if an event with the specified name does not exist in the
   *         register.
   */
  public Event getEventByName(String name) throws IllegalArgumentException {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    return events.stream().filter(event -> event.getName().equals(name))
                                  .findFirst().orElse(null);
  }

  /**
   * @return a list of all events in the event register, sorted by location.
   */
  public List<Event> getALlEventsByLocation() {
    return events.stream().sorted(Comparator.comparing(Event::getLocation)).toList();
  }

  /**
   * @return a list of all events in the event register, sorted by type.
   */
  public List<Event> getAllEventsByType() {
    return events.stream().sorted(Comparator.comparing(Event::getType)).toList();
  }

  /**
   * @return a list of all events in the event register, sorted by date.
   */
  public List<Event> getAllEventsByDate() {
    return events;
  }

  /**
   * Returns a list of all events in the event register with the specified date.
   *
   * @param date the date to compare the date of the events to. Date must equal an 8-digit number
   *             with the format YYYYMMDD.
   * @return a list of all events in the event register with the specified date.
   * @throws IllegalArgumentException if the date does not equal an 8-digit number.
   */
  public List<Event> getEventsByDate(int date) throws IllegalArgumentException {
    if (date > 99999999 || date < 10000000) {
      throw new IllegalArgumentException("Date must be an 8-digit number (YYYYMMDD)");
    }
    return events.stream().filter(event -> event.getDateOnly() == date).toList();
  }

  /**
   * Returns a list of all events in the event register with the specified location.
   *
   * @param location the location to compare the location of the events to. Location must not equal
   *                 {@code null} or an empty string.
   * @return a list of all events in the event register with the specified location.
   * @throws IllegalArgumentException if the location equals {@code null} or an empty string.
   */
  public List<Event> getEventsByLocation(String location) throws IllegalArgumentException {
    if (location == null || location.isBlank()) {
      throw new IllegalArgumentException("Location cannot be null or empty");
    }
    return events.stream().filter(event -> event.getLocation().equals(location)).toList();
  }

  /**
   * Returns a list of all events in the event register with a date and time within the specified
   * interval. The interval includes the start date and end date.
   *
   * @param startDate the start date of the interval. Date must equal an 8-digit number with the
   *                  format YYYYMMDD.
   * @param endDate the end date of the interval. Date must equal an 8-digit number with the format
   *                YYYYMMDD.
   * @return a list of all events in the event register with a date and time within the specified
   *         interval.
   * @throws IllegalArgumentException if the start date or end date does not equal an 8-digit number.
   */
  public List<Event> getEventsInInterval(int startDate, int endDate)
      throws IllegalArgumentException {
    if (startDate > 99999999 || startDate < 10000000 || endDate > 99999999 || endDate < 10000000) {
      throw new IllegalArgumentException("Date must be a 8-digit number (YYYYMMDD)");
    }
    return events.stream().filter(event -> event.getDateOnly() >= startDate
                                  && event.getDateOnly() <= endDate).toList();
  }
}
