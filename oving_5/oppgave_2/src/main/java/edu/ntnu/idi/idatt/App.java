package edu.ntnu.idi.idatt;

// Klientprogram
public class App {
  public static void main(String[] args) throws Exception {
    // Lager objektet "tilfeldig" av klassen MinRandom
    MinRandom tilfeldig = new MinRandom();

    // Få tilfeldig heltall og desimaltall
    int heltall = tilfeldig.nesteHeltall(3, 50);
    double desimaltall = tilfeldig.nesteDesimaltall(1.2, 3.7);

    // Skrive ut resultat
    System.out.printf("\nTilfeldig heltall: %d\nTilfeldig desimaltall: %.3f\n", heltall, desimaltall);
  }
}