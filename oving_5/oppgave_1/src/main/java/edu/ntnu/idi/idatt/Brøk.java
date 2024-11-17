package edu.ntnu.idi.idatt;

// Klasse for brøkobjekter
class Brøk {
  private int teller, nevner;

  // Konstruktør med både teller og nevner som argument
  Brøk(int teller, int nevner) throws IllegalArgumentException {
    if (nevner != 0) {
      this.teller = teller;
      this.nevner = nevner;
    } else{
      throw new IllegalArgumentException("Nevneren må være noe annet enn 0");
    }
  }

  // Konstruktør med kun teller som argument
  Brøk(int kTeller) {
    this.teller = kTeller;
    this.nevner = 1;
  }

  // Metode som returnerer brøk-objektets teller
  public int getTeller() {
    return teller;
  }

  // Metode som returnerer brøk-objektets nevner
  public int getNevner() {
    return nevner;
  }

  // Metode for å summere brøken med en annen
  public void summere(Brøk brøk2) {
    // Få samme nevner, og legge sammen tellere.
    teller = (teller*brøk2.getNevner() + brøk2.getTeller()*nevner);
    nevner *= brøk2.getNevner();
    forkorte();
  }

  // Metode for å subtrahere en annen brøk fra brøken
  public void subtrahere(Brøk brøk2) {
    // Få samme nevner, og subtrahere teller2 fra teller1.
    teller = (teller*brøk2.getNevner() - brøk2.getTeller()*nevner);
    nevner *= brøk2.getNevner();
    forkorte();
  }

  // Metode for å multiplisere brøken med en annen
  public void multiplisere(Brøk brøk2) {
    // Multiplisere tellere og nevnere
    teller *= brøk2.getTeller();
    nevner *= brøk2.getNevner();
    forkorte();

  }

  // Metode for å dividere brøken med en annen
  public void dividere(Brøk brøk2) {
    // Multiplisere teller1 med nevner2, og nevner2 med teller1
    teller *= brøk2.getNevner();
    nevner *= brøk2.getTeller();
    forkorte();
  }

  // Metode for å forkorte teller og nevner i en brøk.
  private void forkorte() {
    int sff = størsteFellesFaktor(teller, nevner);
    this.teller /= sff;
    this.nevner /= sff;
    // Bytte fortegn til teller og nevner hvis nevner er negativ
    if (this.nevner < 0) {
      this.teller *= -1;
      this.nevner *= -1;
    }
  }

  // Rekursiv metode som returnerer SFF for to tall
  // https://en.wikipedia.org/wiki/Euclidean_algorithm#Implementations
  private int størsteFellesFaktor(int t, int n) {
    if (t != 0) {
      return størsteFellesFaktor(n % t, t);
    } else {
      return n;
    }
  }
}
