package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    // Lage valuta-objekter
    Valuta euro = new Valuta("Euro", 11.7);
    Valuta dollar = new Valuta("Dollar", 10.46);
    Valuta sek = new Valuta("SEK", 1.03);
    Valuta valgtValutaObj;

    // Kjør programmet helt til brukeren stopper det
    while (true) {
      System.out.println("\nVelg valuta: (skriv inn tilhørende tallverdi)");
      System.out.printf("1: %s\n2: %s\n3: %s\n4: avslutt\n", "Euro", "Dollar", "SEK");
      System.out.printf("\nDitt valg: ");
      valgtValutaObj = switch((int)getInput(sc)) {
        case 1 ->  euro;
        case 2 -> dollar;
        case 3 -> sek;
        case 4 -> null;
        default -> throw new IllegalArgumentException("Verdien er ikke et gydlig valg.");
      };
      if (valgtValutaObj == null) return; // Avslutt programmet hvis bruker skriver inn "4"
      // Få beløp
      System.out.printf("\nSkriv inn beløp: ");
      double belop = getInput(sc);
      // Velge regneoperasjon (fraNorsk eller tilNorsk)
      System.out.printf("\nVelg ønsket regneoperasjon: (skriv tilhørende tallverdi)");
      System.out.printf("\n1: Fra %s til NOK\n2. Fra NOK til %s\n", valgtValutaObj.navn, valgtValutaObj.navn);
      System.out.printf("\nDitt valg: ");
      // Skrive ut resultater
      switch ((int) getInput(sc)) {
        case 1 -> System.out.printf("\n%.2f %s er %.2f NOK\n", belop, valgtValutaObj.navn, valgtValutaObj.tilNorsk(belop));
        case 2 -> System.out.printf("\n%.2f NOK er %.2f %s\n", belop, valgtValutaObj.fraNorsk(belop), valgtValutaObj.navn);
        default -> throw new IllegalArgumentException("Verdien er ikke 1 eller 2.");
      }
    }
  }

  // Metode for å få input fra bruker
  public static double getInput(Scanner scanner) {
    double input = 0;
    do { // Do-while løkke som gjentar helt til bruker har skrevet godkjent input
      String rawInput = scanner.nextLine();
      try {
        input = Float.parseFloat(rawInput);
      } catch (NumberFormatException e) {
        System.out.println("\nVennligst skriv inn en gydlig tallverdi.\n");
      }
    } while (input == 0);
    return input;
  }
}