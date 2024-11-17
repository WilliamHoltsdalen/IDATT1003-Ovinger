package edu.ntnu.idi.idatt;

import java.util.Random;

// Klasse kalt MinRandom
class MinRandom {
  // java.util.Random klasse som objektvariabel
  Random random = new java.util.Random();

  MinRandom() {}

  // Metode for å gi et tilfeldig heltall i opgitt intervall
  public int nesteHeltall(int nedre, int ovre) {
    int randInt = random.nextInt((ovre - nedre) +1) + nedre;
    return randInt;
  }

  // Metode for å gi et tilfeldig desimaltall i oppgitt intervall
  public double nesteDesimaltall(double nedre, double ovre) {
    double randDouble = nedre;
    do {
      if ((int) ovre != 0) { // Hvis øvre grense er større enn 1
        randDouble = random.nextDouble() + nesteHeltall((int) nedre, (int) ovre); // Får tilfeldige desimaler + tilfeldig heltall
      } else {
        randDouble = random.nextDouble(); // Får tilfeldige desimaler
      }
    } while ((randDouble <= nedre) || (randDouble - (int) randDouble) >= (ovre - (int) ovre) );
    return randDouble;
  }
}