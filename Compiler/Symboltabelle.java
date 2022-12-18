/**
 * Klasse für eine Symboltabelle zur Speicherung der festen und variablen
 * Symbole während des Scann-Prozesses
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */

 public class Symboltabelle {
   // Datenfelder
   private Token[] tokens;
   private int anzahl;
   
   private static int MAX = 100;
   
   // Konstruktoren
   public Symboltabelle() {
     tokens = new Token[MAX];
     tokens[0] = new Token(Token.leer,"");
     tokens[1] = new Token(Token.konstruktion,"Konstruktion");
     tokens[2] = new Token(Token.zeichne,"Zeichne");
     tokens[3] = new Token(Token.punkt,"Punkt");
     tokens[4] = new Token(Token.ende,"Ende");
     tokens[5] = new Token(Token.doppelpunkt,":");
     tokens[6] = new Token(Token.semikolon,";");
     tokens[7] = new Token(Token.klammerauf,"(");
     tokens[8] = new Token(Token.klammerzu,")");
     tokens[9] = new Token(Token.punktop,"*");
     tokens[10] = new Token(Token.punktop,"/");
     tokens[11] = new Token(Token.strichop,"+");
     tokens[12] = new Token(Token.strichop,"-");
     tokens[13] = new Token(Token.punktop,"%");

     anzahl = 14;
   }

   // Methoden

   /**
    * Methode sucht einen String in der Symboltabelle. Falls der String nicht
    * gefunden wird, so wird die Symboltabelle um diesen String ergänzt.
    * Der String wäre dann nämlich ein Bezeichner oder eine Zahl.
    * @param zeichenkette - Die zu suchende Zeichenkette
    * @return der zueghörige Index aus der Symboltabelle
    */
   public int zeichenketteSuchenUndErweitern(String pZeichenkette) {
     for (int i = 0; i < anzahl; i++) {
       if (tokens[i].gibZeichenkette().equals(pZeichenkette)) {
         return i;
       }
     }
     // Zeichenkette wurde nicht gefunden, also Symboltabelle erweitern.
     if (pZeichenkette.charAt(0) >= '0' && pZeichenkette.charAt(0) <= '9') {
       tokens[anzahl] = new Token(Token.zahl,pZeichenkette);
     } else {
       tokens[anzahl] = new Token(Token.name,pZeichenkette);
     }
     anzahl++;
     return anzahl-1;
   }
   

   /**
    * Methode liefert zu einem Index das Token-Objekt mit seinen Speicherinformationen
    * @praram index - Index des zurückzugebenden Symbols
    * @return das zum Index zugehörige Symbol als int
    */
    public Token tokenVonIndex(int pIndex) {
      return tokens[pIndex];
    }

    /**
     * Methode zur Ausgabe der Symboltabelle als String
     * @return Symboltabelle als String
     */
    public String toString() {
      String s = "";
      for (int i = 0; i < anzahl; i++) {
        if (tokens[i].gibSymbol() != Token.leer) {
          String nr = ""+i+".";
          s = s + i + "." + "         ".substring(0,6-nr.length()) + tokens[i]+"\n";
        }
      }
      return s;
    }


 }