package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      final String alfabet = "abcdefghijklmnopqrstuvwxyzæøå";

      while (true) {
        System.out.println("\n\nSkriv inn en tekst for å analysere den:");
        String input = sc.nextLine(); // Få tekst fra bruker
        Tekstanalyse analyse = new Tekstanalyse(input); // Lage analyse-objekt fra Tekstanalyse klassen
        // Skrive ut resultater
        System.out.printf("\nAntall forskjellige bokstaver: %d", analyse.forskjellige()); // Skrive ut antall forskjellige bokstaver
        System.out.printf("\nTotalt antall bokstaver: %d", analyse.antallBokstaver()); // Skrive ut totalt antall bokstaver
        System.out.printf("\nProsent ikke bokstaver: %.2f", analyse.ikkeBokstaverProsent()); // Skrive ut prosent som ikke er bokstaver
        System.out.printf("\nForekomster av hver bokstav:\n"); // Skrive ut forekomster av hver bokstav)
        for (int i = 0; i < 29; i++) {
          System.out.printf("%s: %d, ", alfabet.charAt(i), analyse.forekomster(Character.toString(alfabet.charAt(i))));
        }
        System.out.printf("\nFlest forekomster: %s\n", analyse.flestForekomster()); // Skrive ut bokstav(ene) med flest forekomster
      }
    }
  }
}