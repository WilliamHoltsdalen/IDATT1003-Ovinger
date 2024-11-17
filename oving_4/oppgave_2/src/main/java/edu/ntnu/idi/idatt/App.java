package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    System.out.println("Velkommen til terningspillet '100'!");
    Spiller spillerA = new Spiller("A"); // Lage spillerobjekt for spiller A
    Spiller spillerB = new Spiller("B"); // Lage spillerobjekt for spiller B

    int runde = 0; // Initialisere runde-teller
    // Simulere spillet
    do {
      runde++; // Øke rundetall med 1 for hver runde
      // Kaste terning for begge spillere
      spillerA.kastTerningen();
      spillerB.kastTerningen();
      System.out.printf("\n\nRunde %d:", runde);
      System.out.printf("\nPoengsum spiller A: %d", spillerA.getSumPoeng());
      System.out.printf("\nPoengsum spiller B: %d", spillerB.getSumPoeng());
    } while (!(spillerA.erFerdig() || spillerB.erFerdig()));

    if (spillerA.erFerdig() && !spillerB.erFerdig()) { // Sjekke om A har vunnet
      System.out.printf("\n\nSpiller %s vant, etter %d runder!\n", spillerA.getName(), runde);
    } else  if (!spillerA.erFerdig() && spillerB.erFerdig()){ // Sjekke om B har vunnet
      System.out.printf("\n\nSpiller %s vant, etter %d runder!\n", spillerB.getName(), runde);
    } else { // Ellers, uavgjort
      System.out.printf("\n\nDet ble uavgjort, etter %d runder!\n", runde);
    }
  }
}