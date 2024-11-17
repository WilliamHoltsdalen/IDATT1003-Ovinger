package edu.ntnu.idi.idatt;

public class App {
  public static void main(String[] args) {
    // Oppretter et objekt av klassen Tekstbehandling, med eksempeltekst
    String eksempeltekst = "Dette er en tekst, som brukes til følgende: teste klassen, som er en tekstbehandler, som behandler tekst.";
    Tekstbehandling tb = new Tekstbehandling(eksempeltekst);

    // Skriver ut informasjon om teksten
    System.out.printf("%nTeksten: \"%s\"", tb.getTekst());
    System.out.printf("%nTeksten i store bokstaver: %s", tb.getTekstAllCaps().getTekst());
    System.out.printf("%nAntall ord: %d", tb.antallOrd());
    System.out.printf("%nGjennomsnittlig ordlengde: %.3f", tb.avgOrdLengde());
    System.out.printf("%nGjennomsnittlig antall ord per periode: %.3f", tb.avgAntallOrdPeriode());
    System.out.printf("%nByttet ut ordet 'tekst' med 'string': %s", tb.bytteOrd("tekst", "string").getTekst());
  }
}