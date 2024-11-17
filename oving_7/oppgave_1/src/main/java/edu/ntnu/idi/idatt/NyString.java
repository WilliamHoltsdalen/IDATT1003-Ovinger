package edu.ntnu.idi.idatt;

public final class NyString {
  // Deklarerer en privat objektvariabel som lagrer teksten
  private final String tekst;

  /**
   * Konstruktør som tar imot en tekst og lagrer den i objektet
   *
   * @param tekst Tekst som skal lagres i objektet
   */
  public NyString(String tekst) {
    this.tekst = tekst;
  }

  /**
   * Metode som returnerer teksten som er lagret i objektet
   *
   * @return teksten som er lagret i objektet
   */
  public String getTekst() {
    return tekst;
  }

  /**
   * Metode som forkorter teksten
   *
   * @return en ny tekst som er forkortet
   */
  public NyString forkorte() {
    String[] ord = tekst.split(" ");

    for (int i = 0; i < ord.length; i++) {
      ord[i] = ord[i].substring(0, 1).toUpperCase();
    }

    String forkortetTekst = String.join("", ord);

    return new NyString(forkortetTekst);
  }

  /**
   * Metode som fjerner tegn fra teksten
   *
   * @param tegn Tegn som skal fjernes fra teksten, hvis flere tegn skal fjernes, skriv dem etter hverandre
   * @return en ny tekst uten tegnene som ble spesifisert
   */
  public NyString fjerneTegn(String tegn) {

    String nyTekst = tekst;

    for (int i = 0; i < tegn.length(); i++) {
      nyTekst = nyTekst.replace(Character.toString(tegn.charAt(i)), "");
    }
    nyTekst = nyTekst.replace("  ", " ");

    return new NyString(nyTekst);
  }
}
