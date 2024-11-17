package edu.ntnu.idi.idatt;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      Matrise matA;
      Matrise matB;
      double[][] resultatMatrise = null;
      // Skrive ut meny for brukeren, og få brukerens valg
      switch (menyValg(sc)) {
        case 1 -> {
          matA = new Matrise("A");
          matB = new Matrise("B");
          resultatMatrise = matA.addere(matB);
        }
        case 2 -> {
          matA = new Matrise("A");
          matB = new Matrise("B");
          resultatMatrise = matA.multiplisere(matB);
        }
        case 3 -> {
          matA = new Matrise("A");
          resultatMatrise = matA.transponering();
        }
        case 4 -> {
          System.out.println("Avslutter programmet.");
          System.exit(0);
        }
      }
      // Skrive ut resultatmatrisen
      if (resultatMatrise != null){
        System.out.println("\nResultatmatrisen er:");
        for (double[] resultatMatrise1 : resultatMatrise) {
          for (int j = 0; j < resultatMatrise[0].length; j++) {
            double element = resultatMatrise1[j];
            if (element % 1 != 0) {
              System.out.printf("%.2f ", element); // Skrive ut desimaltall
            } else {
              System.out.printf("%d ", (int) element); // Skrive ut heltall
            }
          }
          System.out.println(""); // Ny linje for hver rad i resultatmatrisen
        }
      } else {
        System.out.println("\nMatriseoperasjonen er ikke mulig.");
      }
    }
  }
  /**
   * Metode for å la bruker velge matriseoperasjon.
   *
   * Sjekker om input er et heltall innenfor ønsket intervall og returnerer valgt verdi.
   */
  public static int menyValg(Scanner scanner) {
    int input = 0;
    System.out.println("\nVelg matriseoperasjon ved å skrive tilhørende tallverdi");
    System.out.printf("1. Addisjon%n2. Multiplikasjon%n3. Transponering%n4. Avslutt");
    do {
      System.out.print("\nDitt valg: ");
      String rawInput = scanner.nextLine();
      try {
        input = Integer.parseInt(rawInput);
        if (input <= 0 || input > 4) {
          throw new NumberFormatException();
        }
      } catch (NumberFormatException e) {
        System.out.println("\nUgyldig inndata, prøv igjen.");
      }
    } while (input <= 0 || input > 4);
    return input;
  }
}