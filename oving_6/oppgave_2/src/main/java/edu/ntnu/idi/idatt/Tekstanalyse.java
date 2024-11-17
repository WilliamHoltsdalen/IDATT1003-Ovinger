package edu.ntnu.idi.idatt;

class Tekstanalyse {
  // Objektvariabel for klassen
  int[] antallTegn = new int[30];
  // Konstruktør for Tekstanalyse klassen
  Tekstanalyse(String kTekst) {
    for (int i = 0; i < kTekst.length(); i++) {
      int ascii = kTekst.toLowerCase().charAt(i) - 97;
      if (ascii >=0 && ascii <26) {
        antallTegn[ascii] ++;
      } else {
        switch (ascii) {
          case 133 -> antallTegn[26] ++;
          case 151 -> antallTegn[27] ++;
          case 132 -> antallTegn[28] ++;
          default -> antallTegn[29] ++;
        }
      }
    }
  }
  // Metode som returnerer antall forskjellige bokstaver
  public int forskjellige() {
    int totaltAntall = 0;
    for (int i = 0; i < 29; i++) {
      if (antallTegn[i] != 0) {
        totaltAntall ++;
      }
    }
    return totaltAntall;
  }
  // Metode som returnerer totalt antall bokstaver
  public int antallBokstaver() {
    int totaltAntall = 0;
    for (int i = 0; i < 29; i++) {
      totaltAntall += antallTegn[i];
    }
    return totaltAntall;
  }
  // Metode som returnerer prosentandel av teksten som ikke er bokstaver
  public double ikkeBokstaverProsent() {
    return ((double) antallTegn[29] / (antallBokstaver()+antallTegn[29])) * 100.0;
  }
  // Metode som returnerer antall forekomster av bokstav som er parameter til metoden
  public int forekomster(String bokstav) {
    int ascii = switch (bokstav) {
      case "æ" -> bokstav.toLowerCase().charAt(0) - 204;
      case "ø" -> bokstav.toLowerCase().charAt(0) - 221;
      case "å" -> bokstav.toLowerCase().charAt(0) - 201;
      default -> bokstav.toLowerCase().charAt(0) - 97;
    };
    return antallTegn[ascii];
  }
  // Metode som returnerer en String med bokstaven(e) som forekommer flest ganger i teksten
  public String flestForekomster() {
    int flestIndex = 0;
    String bokstaver = "";

    for (int i = 0; i < 29; i++) {
      if (antallTegn[i] > antallTegn[flestIndex]) { // Sjekke om bokstav har flest forekomster (hittil i for-løkken)
        flestIndex = i;
        if (i < 26) {
          bokstaver = Character.toString((char) (i + 97));
        } else {
          bokstaver = switch (i) {
            case 26 -> Character.toString((char) (i + 204));
            case 27 -> Character.toString((char) (i + 221));
            case 28 -> Character.toString((char) (i + 201));
            default -> null;
          };
        }
      } else if (antallTegn[i] != 0 && antallTegn[i] == antallTegn[flestIndex]) { // Sjekke om bokstav har like mange forekomster
        if (i < 26) {
          bokstaver += Character.toString((char) (i + 97));
        } else {
          bokstaver = bokstaver + switch (i) {
            case 26 -> Character.toString((char) (i + 204));
            case 27 -> Character.toString((char) (i + 221));
            case 28 -> Character.toString((char) (i + 201));
            default -> null;
          };
        }
      }
    }
    return bokstaver;
  }
}