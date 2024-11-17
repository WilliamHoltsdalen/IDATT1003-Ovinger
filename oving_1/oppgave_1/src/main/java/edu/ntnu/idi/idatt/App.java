package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    // "Testdatasett"
    double tommer = 10;

    // Kalle omregningsmetoden, samt skrive ut setning med resultatet
    System.out.println(tommer + " tommer er " + tommerToCm(tommer) + " cm");
  }

  // Metode for å regne om tommer til cm
  static double tommerToCm(double tommer) {
    return tommer * 2.54;
  }
}