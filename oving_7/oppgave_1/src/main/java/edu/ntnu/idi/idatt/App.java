package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    NyString tekst = new NyString("Dette er en tekst for å teste klassen");

    System.out.println("\nForkortet tekst: " + tekst.forkorte().getTekst());
    System.out.println("Tekst uten bokstaven e: " + tekst.fjerneTegn("e").getTekst());
  }
}