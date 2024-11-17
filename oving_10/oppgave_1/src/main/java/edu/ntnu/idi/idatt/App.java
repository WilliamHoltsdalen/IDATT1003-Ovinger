package edu.ntnu.idi.idatt;

import java.util.Scanner;

/**
 * The main class of the program, representing a tourist office event organizer. Contains the main
 * method and the main menu of the program.
 * <p>
 * The application's main menu is a text-based user interface that allows the user to interact
 * with the program. The user can add events, remove events, and view events by location, type,
 * and date. The user can also view events in a specified date interval. The user can exit the
 * program at any time.
 * <p>
 * The main method creates an instance of the {@code EventRegister} class and adds example events
 * to the event register. The main method then enters a loop that displays the main menu of the
 * program. The loop continues until the user chooses to exit the program.
 */
public class App {

  /**
   * The application's main method.
   * <p>
   * The main method creates an instance of the {@code EventRegister} class and adds example events
   * to the event register. The main method then enters a loop that displays the main menu of the
   * program. The loop continues until the user chooses to exit the program.
   *
   * @param args the command line arguments.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    EventRegister eventRegister = new EventRegister();

    addExampleEvents(eventRegister);

    while (true) {
      int status = mainMenu(sc, eventRegister);

      if (status == 1) {
        break;
      }
    }
  }

  /**
   * Adds example events to the event register.
   *
   * @param eventRegister the event register to add the events to.
   */
  public static void addExampleEvents(EventRegister eventRegister) {
    eventRegister.addEvent(new Event(eventRegister.getEventCount() + 1, "Mattesirkus", "Gløshaugen, Realfagsbygget", "NTNU", "Sirkus", 202411301800L));

    eventRegister.addEvent(new Event(eventRegister.getEventCount() + 1 , "Julebord", "Gløshaugen, Kjemibygget", "NTNU", "Fest", 202412231800L));

    eventRegister.addEvent(new Event(eventRegister.getEventCount() + 1, "Fotballkamp", "Fotballbane", "NTNUI", "Sport", 202409211200L));
  }

  /**
   * Displays the main menu of the program and handles user input.
   * <p>
   * The main menu allows the user to add events, remove events, and view events by location, type
   * and date. The user can also view events in a specified date interval. The user can exit the
   * program at any time.
   *
   * @param sc the scanner object to read user input.
   * @param eventRegister the event register to interact with.
   * @return 1 if the user chooses to exit the program, 0 otherwise.
   */
  public static int mainMenu(Scanner sc, EventRegister eventRegister) {
    System.out.println("\n\nChoose an option:\n");
    System.out.println("1. Add event");
    System.out.println("2. Remove event");
    System.out.println("3. Show all events by location");
    System.out.println("4. Show all events by type");
    System.out.println("5. Show all events by date");
    System.out.println("6. Show events by date");
    System.out.println("7. Show events by location");
    System.out.println("8. Show events in interval");
    System.out.println("9. Exit");
    int choice = 0;
    try {
      choice = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid choice");
    }
    switch (choice) {
      case 1:
        addEvent(sc, eventRegister);
        break;
      case 2:
        removeEvent(sc, eventRegister);
        break;
      case 3:
        showAllEventsByLocation(eventRegister);
        break;
      case 4:
        showAllEventsByType(eventRegister);
        break;
      case 5:
        showAllEventsByDate(eventRegister);
        break;
      case 6:
        showEventsByDate(sc, eventRegister);
        break;
      case 7:
        showEventsByLocation(sc, eventRegister);
        break;
      case 8:
        showEventsInInterval(sc, eventRegister);
        break;
      case 9:
        return 1;
      default:
        System.out.println("Invalid choice");
        break;
    }
    return 0;
  }

  /**
   * Adds an event to the event register.
   * <p>
   * The method prompts the user to enter the event name, location, organizer, type and date.
   * The event is then added to the event register.
   *
   * @param sc the scanner object to read user input.
   * @param eventRegister the event register to add the event to.
   */
  public static void addEvent(Scanner sc, EventRegister eventRegister) {
    final String name;
    final String location;
    final String organizer;
    final String type;
    final long date;

    System.out.println("Enter event name: ");
    name = sc.nextLine();
    System.out.println("Enter event location: ");
    location = sc.nextLine();
    System.out.println("Enter event organizer: ");
    organizer = sc.nextLine();
    System.out.println("Enter event type: ");
    type = sc.nextLine();
    System.out.println("Enter event date and time (YYYYMMDDhhmm): ");
    try {
      date = Long.parseLong(sc.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("""
                         ----------------------
                         Invalid date and time.
                         ----------------------
                         """);
      return;
    }
    try {
      Event event = new Event(1, name, location, organizer, type, date);
      eventRegister.addEvent(event);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Removes an event from the event register.
   * <p>
   * The method prompts the user to enter the event name. The event is then removed from the event
   * register, if it exists.
   *
   * @param sc the scanner object to read user input.
   * @param eventRegister the event register to remove the event from.
   */
  public static void removeEvent(Scanner sc, EventRegister eventRegister) {
    System.out.println("Enter event name: ");
    String name = sc.nextLine();
    try {
      eventRegister.removeEvent(eventRegister.getEventByName(name));
    } catch (IllegalArgumentException e) {
      System.out.println("Event not found");
    }
  }

  /**
   * Displays all events in the event register, sorted by location.
   *
   * @param eventRegister the event register to display events from.
   */
  public static void showAllEventsByLocation(EventRegister eventRegister) {
    eventRegister.getALlEventsByLocation().forEach(event -> System.out.println(event.toString()));
  }

  /**
   * Displays all events in the event register, sorted by type.
   *
   * @param eventRegister the event register to display events from.
   */
  public static void showAllEventsByType(@org.jetbrains.annotations.NotNull EventRegister eventRegister) {
    eventRegister.getAllEventsByType().forEach(event -> System.out.println(event.toString()));
  }

  /**
   * Displays all events in the event register, sorted by date.
   *
   * @param eventRegister the event register to display events from.
   */
  public static void showAllEventsByDate(EventRegister eventRegister) {
    eventRegister.getAllEventsByDate().forEach(event -> System.out.println(event.toString()));
  }

  /**
   * Displays events by date.
   * <p>
   * The method prompts the user to enter a date (YYYYMMDD). The method then displays all events
   * that occur on the specified date. Time of day is not considered.
   *
   * @param sc the scanner object to read user input.
   * @param eventRegister the event register to display events from.
   */
  public static void showEventsByDate(Scanner sc, EventRegister eventRegister) {
    System.out.println("Enter date (YYYYMMDD): ");
    try {
      int date = Integer.parseInt(sc.nextLine());
      eventRegister.getEventsByDate(date).forEach(event -> System.out.println(event.toString()));
    } catch (NumberFormatException e) {
      System.out.println("""
                         -------------
                         Invalid date.
                         -------------
                         """);
    }
  }

  /**
   * Displays events by location.
   * <p>
   * The method prompts the user to enter a location. The method then displays all events that
   * occur at the specified location.
   *
   * @param sc the scanner object to read user input.
   * @param eventRegister the event register to display events from.
   */
  public static void showEventsByLocation(Scanner sc, EventRegister eventRegister) {
    System.out.println("Enter location: ");
    String location = sc.nextLine();
    eventRegister.getEventsByLocation(location).forEach(event -> System.out.println(event.toString()));
  }

  /**
   * Displays events in a specified date interval.
   * <p>
   * The method prompts the user to enter a start date, and an end date (YYYYMMDD). The method then
   * displays all events that occur within the specified date interval. Events that occur on the
   * start and end date are included. Time of day is not considered.
   *
   * @param sc the scanner object to read user input.
   * @param eventRegister the event register to display events from.
   */
  public static void showEventsInInterval(Scanner sc, EventRegister eventRegister) {
    try {
      System.out.println("Enter start date (YYYYMMDD): ");
      int startDate = Integer.parseInt(sc.nextLine());
      System.out.println("Enter end date (YYYYMMDD): ");
      int endDate = Integer.parseInt(sc.nextLine());
      eventRegister.getEventsInInterval(startDate, endDate)
          .forEach(event -> System.out.println(event.toString()));
    } catch (NumberFormatException e) {
      System.out.println("""
                         -------------
                         Invalid date.
                         -------------
                         """);
    }
  }
}