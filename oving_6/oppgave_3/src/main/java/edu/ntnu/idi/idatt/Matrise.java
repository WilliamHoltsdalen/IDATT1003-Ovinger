package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.Scanner;

final class Matrise {
  // Instansvariabler
  final double[][] matrise;
  private final int rader, kolonner;

  /**
   * Konstruktør for å lage en matrise.
   *
   * Tar inn navn på matrisen som parameter, og lager matrisen ved å kalle på metoden lagMatrise.
   *
   * @param name Navnet på matrisen som skal lages
   */
  Matrise(String name) {
    this.matrise = lagMatrise(name);
    this.rader = matrise.length;
    this.kolonner = matrise[0].length;
  }

  // Metode som returnerer matrisen, i form av et 2D array.
  public double[][] getMatrise() {
    return matrise;
  }

  /**
   * Metode for å lage matriser
   *
   * Får input fra bruker ved å tolke hver linje som en rad i en matrise. Elementene i raden
   * skilles med mellomrom, og slutten av matrisen markeres ved tom linje. Da vil "forrige" linje
   * være den siste i matrisen.
   *
   * @param navn Navnet på matrisen som skal lages
   *
   * @return 2D array som representerer matrisen
   */
  public static double[][] lagMatrise(String navn) {
    Scanner sc = new Scanner(System.in);
    String rawInput;
    int rowNumber = 1;
    boolean keepChecking = true;
    ArrayList<double[]> rowList = new ArrayList<>();

    System.out.println("\nSkriv inn hvert element i hver rad, separert med mellomrom");
    System.out.printf("Matrise %s%n", navn);
    do {
      System.out.printf("Rad %d: ", rowNumber); rawInput = sc.nextLine();
      if (rowNumber == 1 && rawInput.equals("")) { // Hvis brukeren ikke skriver noe
        System.out.println("Ugyldig inndata, sjekk format og prøv igjen.");
      } else if (!rawInput.equals("")) {
        try {
          String[] elements = rawInput.split(" "); // Splitter input ved mellomrom
          double[] row = new double[elements.length]; // Lager en rad
          if (!rowList.isEmpty() && elements.length != rowList.getLast().length) { // Hvis antall elementer i raden ikke stemmer
            throw new NumberFormatException();
          }
          for (int i = 0; i < elements.length; i++) {
            row[i] = Double.parseDouble(elements[i]);
          }
          rowList.add(row); // Legger til rad i listen
          rowNumber++; // Øk radnummer
        } catch (NumberFormatException e) {
          System.out.println("Ugyldig inndata, sjekk format og prøv igjen.");
        }
      } else keepChecking = false; // Hvis brukeren skriver ingenting
    } while (keepChecking); // Så lenge brukeren

    // Lage to dimensjonelt array som skal returneres
    double[][] array = new double[rowList.size()][rowList.get(0).length];
    for (int i = 0; i < rowList.size(); i++) {
      System.arraycopy(rowList.get(i), 0, array[i], 0, rowList.get(0).length);
    }
    return array;
  }

  /**
   * Metode for å addere en matrise til denne matrisen
   *
   * Sjekker om matrisene har samme antall rader og kolonnner. Hvis ikke er operasjonen
   * umulig og metoden returnerer null.
   * Hvis mulig returneres den nye matrisen som et 2D array
   *
   * @param matB Matrisen som skal adderes til denne matrisen
   *
   * @return 2D array som representerer den nye matrisen
   */
  public double[][] addere(Matrise matB) {
    double[][] nyMatrise = new double[rader][kolonner];
    int raderB = matB.getMatrise().length;
    int kolonnerB = matB.getMatrise()[0].length;
    try {
      if (this.rader == raderB && this.kolonner == kolonnerB) {
        for (int i = 0; i < rader; i++) {
          for (int j = 0; j < kolonner; j++) {
            nyMatrise[i][j] = matrise[i][j] + matB.getMatrise()[i][j];
          }
        }
        return nyMatrise;
      } else throw new Exception();
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Metode for å multiplisere denne matrisen med en annen.
   *
   * Sjekker om matrisemultiplikasjonen er mulig ved å sjekke om antall rader i matrise A er
   * likt antall kolonner i matrise B. Returnerer null hvis multiplikasjonen ikke er mulig.
   * Utfører så matrisemultiplikasjonen og returnerer resultatmatrisen i form av et 2D array.
   *
   * @param matB Matrisen som skal multipliseres med denne matrisen
   *
   * @return 2D array som representerer resultatmatrisen, eller null hvis multiplikasjonen ikke er mulig
   */
  public double[][] multiplisere(Matrise matB) {
    double[][] matriseB = matB.getMatrise();
    int raderB = matriseB.length;
    int kolonnerB = matriseB[0].length;
    try {
      if (this.kolonner == raderB) {
        double[][] nyMatrise = new double[rader][kolonnerB]; // Ny matrise
        for (int radA = 0; radA < rader; radA++) { // Går gjennom hver rad i matrise A
          for (int kolB = 0; kolB < kolonnerB; kolB++) { // Går gjennom hver kolonne i matrise B
            int element = 0;
            for (int kolA = 0; kolA < kolonner; kolA++) {  // Går gjennom hver kolonne i matrise A
              element += matrise[radA][kolA] * matriseB[kolA][kolB]; // Multipliserer og legger til
            }
            nyMatrise[radA][kolB] = element; // Setter inn i ny matrise
          }
        }
        return nyMatrise;
      } else throw new Exception();
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Metode for å transponere matrisen
   *
   * Transponerer matrisen ved å gjøre matrisens første rad til å være første kolonne,
   * andre rad til å være andre kolonne osv. Returnerer transponert matrise i form av
   * et 2D array
   *
   * @return 2D array som representerer transponert matrise
   */
  public double[][] transponering() {
    int nyMatRader = kolonner;
    int nyMatKolonner = rader;
    double[][] nyMatrise = new double[nyMatRader][nyMatKolonner]; // Ny matrise
    for (int rad = 0; rad < nyMatRader; rad++) { // Går gjennom hver rad
      for (int kol = 0; kol < nyMatKolonner; kol++) { // Går gjennom hver kolonne
        nyMatrise[rad][kol] = matrise[kol][rad]; // Flytter elementer
      }
    }
    return nyMatrise; // Returnerer transponert matrise
  }
}
