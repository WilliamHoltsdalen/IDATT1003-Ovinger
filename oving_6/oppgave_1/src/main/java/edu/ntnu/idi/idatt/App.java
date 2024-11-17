package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    java.util.Random random = new java.util.Random(); // Lager objekt "random" av klassen Random
    int[] antall = new int[10]; // Lager liste
    int tall, runde = 0, totRunder = 1000; // Initialiserer variabler
    do {
      tall = random.nextInt(10); // Får tilfeldig tall fra obj random
      antall[tall] ++; // Øker tilhørende tabellverdi med 1
      runde++; // Øker rundeteller med 1
    } while (runde<totRunder); // Bestemmer hvor mange runder
    for (int i = 0; i < 10; i++) { // Skriver ut resultater for hver tabellverdi
      System.out.printf("Antall %d: %d %s\n", i, antall[i], "*".repeat((int) Math.rint(antall[i]/(totRunder/100.0))));
    }
  }
}