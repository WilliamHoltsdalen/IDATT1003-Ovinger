package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    int tellerA = 10, nevnerA = 10, tellerB = 2, nevnerB = 10;

    // Lage brøkobjekter
    Brøk brøkObjA = new Brøk(tellerA, nevnerA);
    Brøk brøkObjB = new Brøk(tellerB, nevnerB);

    // Skrive ut brøkene
    System.out.printf("\nBrøk A er %d/%d", brøkObjA.getTeller(), brøkObjA.getNevner());
    System.out.printf("\nBrøk B er %d/%d\n", brøkObjB.getTeller(), brøkObjB.getNevner());

    // Summere, og skrive ut resultat
    brøkObjA.summere(brøkObjB);
    System.out.printf("\nBrøk A + B er: %d/%d\n", brøkObjA.getTeller(), brøkObjA.getNevner());
    // Subtrahere, og skrive ut resultat
    brøkObjA = new Brøk(tellerA, nevnerA);
    brøkObjA.subtrahere(brøkObjB);
    System.out.printf("\nBrøk A - B er: %d/%d\n", brøkObjA.getTeller(), brøkObjA.getNevner());
    // Multiplisere, og skrive ut resultat
    brøkObjA = new Brøk(tellerA, nevnerA);
    brøkObjA.multiplisere(brøkObjB);
    System.out.printf("\nBrøk A * B er: %d/%d\n", brøkObjA.getTeller(), brøkObjA.getNevner());
    // Dividere, og skrive ut resultat
    brøkObjA = new Brøk(tellerA, nevnerA);
    brøkObjA.dividere(brøkObjB);
    System.out.printf("\nBrøk A / B er: %d/%d\n", brøkObjA.getTeller(), brøkObjA.getNevner());
  }
}