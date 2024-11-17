package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    // Testdatasett
    int timer = 0;
    int minutter = 10;
    int sekunder = 35;

    System.out.println(timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder tilsvarer:");
    // Kaller omregningsmetoden, samt skriver ut resultat
    System.out.println(omregning(timer, minutter, sekunder) + " sekunder.");
  }

  // Metode for omregning
  static int omregning(int t, int m, int s) {
    return (((t * 60) + m) * 60) + s;
  }
}