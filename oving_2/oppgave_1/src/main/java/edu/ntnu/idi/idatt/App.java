package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in) // Starte "scanner"
    ) {
      // Få årstall fra brukeren
      System.out.println("\n\nSkriv inn et årstall:");
      int input = scanner.nextInt();

      // Sjekke om delelig med 400 ELLER delelig med 4 men ikke med 100)
      if (input % 400 == 0 || (input % 100 != 0 && input % 4 == 0)) {
        System.out.println(input + " er et skuddår!");
      } else {
        System.out.println(input + " er ikke et skuddår."); // Hvis ikke skuddår, skrives dette ut
      }
      // Lukke scanneren
      scanner.close();
    }
  }
}