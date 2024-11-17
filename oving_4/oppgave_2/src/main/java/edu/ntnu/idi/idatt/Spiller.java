package edu.ntnu.idi.idatt;

import java.util.Random;

class Spiller{
  // Objektvariabler
  private final String navn;
  private int sumPoeng;
  Random terning = new Random();

  // Konstruktør
  Spiller(String navn) {
    this.navn = navn;
  }

  // Metode for å få objektets navn
  public String getName() {
    return navn;
  }

  // Metode for å få nåværende poengsum
  public int getSumPoeng() {
    return sumPoeng;
  }

  // Metode for å kaste terning og justere poengsum
  public void kastTerningen() {
    int terningKast = terning.nextInt(6) + 1;
    if (terningKast == 1) {
      sumPoeng = 0;
    } else {
      if (sumPoeng < 100) {
        sumPoeng = sumPoeng + terningKast;
      } else {
        sumPoeng = sumPoeng - terningKast;
      }
    }
  }

  // Metode for å sjekke om spiller er ferdig (har vunnet)
  public boolean erFerdig() {
    return sumPoeng == 100;
  }
}