/**
 * Klasse für den Parser des Compilers. Die Grammatik lautet dabei wie unten
 * angegeben.
 */

// Die zugrunde liegende Grammatik: ...................................................................................
//
//  KONSTRUKTION    ::= konstruktion name doppelpunkt ZEICHNE ende
//  ZEICHNE         ::= zeichne PUNKT
//  PUNKT           ::= punkt klammerauf AUSDRUCK semikolon AUSDRUCK klammerzu
//  AUSDRUCK        ::= TERM | TERM strichoperator AUSDRUCK
//  TERM            ::= FAKTOR | FAKTOR punktoperator TERM
//  FAKTOR          ::= zahl | klammerauf AUSDRUCK klammerzu

public class Parser {
  // Datenfelder
  private Tokenliste tokenliste;
  private Token aktuellesToken;

  // Konstruktoren
  public Parser(Tokenliste pListe) {
    this.tokenliste = pListe;
  }
  
  // Methoden
 /**
  * Methode zum scannen eines Quelltextes
  * @param quelltext - String
  * @return Fehlernummer als int
  */
  public int parse() {
    int fehlerNr = 0;
    tokenliste.zumAnfang();
    aktuellesToken = tokenliste.naechstesToken();
    if (aktuellesToken.gibSymbol() == Token.leer) {
      return 1;
    } else {
      return konstruktion();
    }
  }
  
  public int konstruktion() {
    if (aktuellesToken.gibSymbol() != Token.konstruktion) return 2;
    aktuellesToken = tokenliste.naechstesToken();
    if (aktuellesToken.gibSymbol() != Token.name) return 3;
    aktuellesToken = tokenliste.naechstesToken();
    if (aktuellesToken.gibSymbol()  != Token.doppelpunkt) return 4;
    aktuellesToken = tokenliste.naechstesToken();
    int fehlerNr = zeichne();
    if (fehlerNr != 0) return fehlerNr; 
    if (aktuellesToken.gibSymbol() != Token.ende) return 5;
    aktuellesToken = tokenliste.naechstesToken();
    if (aktuellesToken.gibSymbol() != Token.leer) return 13;
    return 0;
  }

  public int zeichne() {
    if (aktuellesToken.gibSymbol() != Token.zeichne) return 14;
    aktuellesToken = tokenliste.naechstesToken();    
    return punkt();
  }
  
  public int punkt() {  
    return 0;
  }
  
  public int ausdruck() {
    return 0;
  }

  public int term() {
    return 0;
  }

  public int faktor() {
    return 0;
  }

  
  public String fehlermeldung(int fehlerNr) {
    switch (fehlerNr) {
      case 0: return "Parsing erfolgreich!";
      case 1: return "Unerwartetes Dateiende!";
      case 2: return "'Konstruktion' erwartet!";
      case 3: return "Bezeichner erwartet!";
      case 4: return "Doppelpunkt : erwartet!";
      case 5: return "'Ende' erwartet!";
      case 6: return "Semikolon ; erwartet!";
      case 7: return "Klammerauf ( erwartet!";
      case 8: return "Klammerzu ) erwartet!";
      case 11: return "'Punkt' erwartet!";
      case 12: return "Zahl erwartet!";
      case 13: return "Dateiende erwartet!";
      case 14: return "'Zeichne' erwartet!"
      default: return "";
    }
  }
}
