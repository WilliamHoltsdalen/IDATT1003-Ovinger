package edu.ntnu.idi.idatt;

import java.util.Scanner; // Importere Scanner class for å få input fra bruker

class App {
  public static void main(String[] args) {
    try (Scanner myObj = new Scanner(System.in) // Starte "scanner"
    ) {
      System.out.println("Skriv inn antall sekunder: "); // Spørre bruker
      int input = myObj.nextInt(); // Lese input til 'input' variabel
      int timer, minutter, sekunder; // Lage variabler for timer, min og sek

      // Regne ut antall timer, min og sek
      minutter = (int) input/60;
      sekunder = input - (minutter*60);
      timer = (int) minutter/60;
      minutter = minutter - (timer*60);

      // Skrive ut resultat
      System.out.println("\n" + input + " sekunder tilsvarer:");
      System.out.println(timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder.\n");
    }
  }
}