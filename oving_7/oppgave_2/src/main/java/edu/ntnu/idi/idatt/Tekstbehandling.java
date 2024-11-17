package edu.ntnu.idi.idatt;

import java.util.*;

public class Tekstbehandling {
  // Instansvariabel som lagrer tekststrengen som skal behandles
  private final String tekst;

  /*
   * Konstruktør som tar imot en tekststreng og lagrer denne i instansvariabelen tekst
   *
   * @param tekst tekststrengen som skal behandles
   */
  public Tekstbehandling(String tekst) {
    this.tekst = tekst;
  }

  /*
   * Metode som returnerer tekststrengen
   *
   * @return tekst
   */
  public String getTekst() {
    return tekst;
  }

  /*
   * Metode som returnerer tekststrengen i store bokstaver
   *
   * @return tekst i store bokstaver
   */
  public Tekstbehandling getTekstAllCaps() {
    return new Tekstbehandling(tekst.toUpperCase());
  }

  /*
   * Metode som returnerer antall ord i tekststrengen
   *
   * @return antall ord
   */
  public int antallOrd() {
    return tekst.split(" ").length;
  }

  /*
   * Metode som returnerer gjennomsnittlig ordlengde i teksten
   *
   * @return gjennomsnittlig ordlengde
   */
  public double avgOrdLengde() {
    String[] ord = tekst.replaceAll("[.,!?:]", "").split(" ");
    double sum = 0;

    for (String o : ord) {
      sum += o.length();
    }

    return sum / ord.length;
  }

  /*
   * Metode som returnerer gjennomsnittlig antall ord per periode i tekststrengen
   * Periode defineres som en tekststreng som avsluttes med et punktum, spørsmålstegn, utropstegn eller kolon
   *
   * @return gjennomsnittlig antall ord per periode
   */
  public double avgAntallOrdPeriode() {
    String skilletegn = ".!?:";
    List<String> perioder = new ArrayList<>();
    perioder.add(tekst);

    for (int i = 0; i < skilletegn.length(); i++) {
      List<String> nyePerioder = new ArrayList<>();
      for (String s : perioder) {
        nyePerioder.addAll(Arrays.asList(s.split("\n" + Character.toString(skilletegn.charAt(i)))));
      }
      perioder = nyePerioder;
    }

    double sum = 0.0;

    for (String p : perioder) {
      if (p.startsWith(" ")) {
        p = p.substring(1);
      }
      sum += p.split(" ").length;
    }
    return (sum / perioder.size());
  }

  /*
   * Metode som bytter ut et ord med et annet ord i tekststrengen
   *
   * @param ord1 ordet som skal byttes ut
   * @param ord2 ordet som skal settes inn
   * @return tekststrengen med ord1 byttet ut med ord2
   */
  public Tekstbehandling bytteOrd(String ord1, String ord2) {
    String skilletegn = " .,!?:";
    String nyTekst = tekst;
    for (String s : skilletegn.split("")) {
      nyTekst = nyTekst.replace(" "+ord1+s, " "+ord2+s);
    }
    return new Tekstbehandling(nyTekst);
  }
}
