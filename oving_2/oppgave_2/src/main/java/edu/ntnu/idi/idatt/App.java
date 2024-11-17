package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    // Starte "scanner"
    Scanner scanner = new Scanner(System.in);

    // Få info fra bruker
    System.out.println("\n\nSkriv inn pris for kjøttdeig A");
    double prisA = scanner.nextDouble();
    System.out.println("\n\nSkriv inn vekt for kjøttdeig A (i gram)");
    double vektA = scanner.nextDouble();

    System.out.println("\n\nSkriv inn pris for kjøttdeig B");
    double prisB = scanner.nextDouble();
    System.out.println("\n\nSkriv inn vekt for kjøttdeig B (i gram)");
    double vektB = scanner.nextDouble();

    // Regne ut kiloprisene
    double kPrisA = prisA/(vektA/1000);
    double kPrisB = prisB/(vektB/1000);

    // Skrive ut resultater
    System.out.println("Kilopris for kjøttdeig A er " + kPrisA + " kr, og kilopris for kjøttdeig B er " + kPrisB + " kr.");
    if (kPrisA < kPrisB) {
      System.out.println("Kjøttdeig A er billigst.");
    } else  if (kPrisA > kPrisB) {
      System.out.println("Kjøttdeig B er billigst.");
    } else {
      System.out.println("De er like dyre.");
    }
    // Lukke scanneren
    scanner.close();

  }
}