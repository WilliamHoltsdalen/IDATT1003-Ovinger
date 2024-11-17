package edu.ntnu.idi.idatt;

// Klasse, kalt Valuta
class Valuta {
  final String navn;
  final double faktor;

  // Konstruktør
  Valuta(String navn, double faktor) {
    this.navn = navn;
    this.faktor = faktor;
  }

  // Metode for omregning til nroske kroner
  public double tilNorsk(double tall) {
    return tall * faktor;
  }

  // Metode for omregning fra norske kroner
  public double fraNorsk(double tall) {
    return tall / faktor;
  }
}