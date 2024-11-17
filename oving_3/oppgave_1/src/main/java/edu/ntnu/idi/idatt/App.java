package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // Starte scanner
    Scanner sc = new Scanner(System.in);
    int startTall, sluttTall;
    do {
      // Få start- og slutt-tall fra bruker
      System.out.println("Skriv inn start-tall:");
      startTall = sc.nextInt();
      System.out.println("Skriv inn slutt-tall:");
      sluttTall = sc.nextInt();
    } while (!(startTall < sluttTall));

    // Skrive ut gangetabellene
    for (int i = startTall; i<sluttTall+1; i++) {
      System.out.println("\nHer er gangetabellen fra 1-10 for " + i);
      for (int j = 1; j<11; j++) {
        System.out.println(i + "x" + j + " = " + i*j);
      }
    }
    // Lukke scanneren
    sc.close();
  }
}