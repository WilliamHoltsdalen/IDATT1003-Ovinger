package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // Starte scanner
    Scanner sc = new Scanner(System.in);
    int input;
    String rawInput;

    while (true) {
      // Få tall fra bruker
      System.out.println("Skriv inn et tall ('stopp' for å stoppe):");
      rawInput = sc.nextLine();

      try {   // Sjekker om bruker skrev inn tall
        input = Integer.parseInt(rawInput);
      } catch (NumberFormatException e) {
        if ("stopp".equals(rawInput)) {
          sc.close();
          return; // Stoppe programmet hvis bruker skriver inn "stopp"
        } else {
          System.out.println("\nVennligst skriv inn en tallverdi. (Kun ett heltall!)\n");
          continue;
        }
      }

      // Skrive ut resultat (kaller sjekkPrimtall metoden)
      System.out.printf("%d er", input);
      if (!sjekkPrimtall(input)) {
        System.out.printf(" ikke");
      }
      System.out.printf(" et primtall.%n\n");
    }
  }
  // Metode for å sjekke om tall fra bruker er et primtall
  public static boolean sjekkPrimtall(int tall) {
    if (!(tall == 0 || tall == 1)) {  // Sjekke at tallet ikke er 0 eller 1
      for (int i = 2; i <= tall / 2; i++) {
        if (tall % i == 0) {
          return false; // Returner false hvis det ikke er primtall
        }
      }
    }
    else {
      return false; // Returner false hvis tallet er 0 eller 1
    }
    return true; // Returner true hvis primtall
  }
}
