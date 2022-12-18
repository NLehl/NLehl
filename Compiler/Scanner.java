/**
 * Klasse für den Scanner des Compilers. Der Scannerautomat arbeitet nach
 * dem unten angegebenen Prinzip.
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */

//                +--+
//                |  | a..z, A..Z, 0..9,ä,ö,ü,Ä,Ö.Ü
//                |  V
//               +----+  a..z, A..Z.ä,ö,ü.Ä,Ö,Ü
//               | S4 |<----+                                 /
//               +----+     |      +----------------------------------------------+
//                          |     /                                               |
//         +----+   0..9   +----+                                                 |
//    +--> | S3 | <------- | S0 |    ()*;:%=     +----+        alles       *      |
//    |    +----+      +-- +----+ -------------> | S1 |       +--+        +--+    |
//    |     |  A 0..9  |    |  A \               +----+       |  |        |  |    |
//0..9|     |  |       |    |  |  \      /                    |  V        |  V    |
//    |     +--+       |    +--+   +-----------> +----+   *  +----+   *  +----+   |
//    +--- +----+ <----+     #10                 | S5 | ---> + S6 | ---> | S7 | --+
//         | S2 |   +,-      #13                 +----+      +----+ <--- +----+
//         +----+            #32                                    alles
//

 public class Scanner {
   // Datenfelder
   private Symboltabelle symboltabelle;
   private Tokenliste tokenliste;

   // Konstruktoren
   public Scanner(Tokenliste pListe, Symboltabelle pTabelle) {
     this.symboltabelle = pTabelle;
     this.tokenliste = pListe;
   }
   
   // Methoden
   /**
    * Methode zum scannen eines Quelltextes
    * @param quelltext - String
    * @return Fehlernummer als int
    */
   public int scan(String pQuelltext) {

     ZeichenLeser zeichenLeser = new ZeichenLeser(pQuelltext);
     int fehlerNr = 0;

     do {
       int zustand = 0;
       boolean endzustand = false;
       String zeichenkette = "";

       do {
          char zeichen = zeichenLeser.gibZeichen();
          zeichenkette = zeichenkette + zeichen;
          switch (zustand) {
            case 0: if (zeichen == ' ' || zeichen == (char)9 || zeichen == '\n' ) {
                      zustand = 0;
                      zeichenkette = "";
                    } else if (zeichen == '(' || zeichen == ')' || zeichen == ':' ||
                               zeichen == '*' || zeichen == ';' || zeichen == '%' || zeichen == '=' ) {
                      zustand = 1;
                    } else if (zeichen == '/') {
                      zustand = 5;
                    } else if (zeichen == '+' || zeichen == '-' ) {
                      zustand = 2;
                    } else if (zeichen >= '0' && zeichen <= '9') {
                      zustand = 3;
                    } else if ( (zeichen >= 'a' && zeichen <= 'z') || (zeichen >= 'A' && zeichen <= 'Z') ||
                                 zeichen == 'ä' || zeichen == 'Ä' ||
                                 zeichen == 'ö' || zeichen == 'Ö' ||
                                 zeichen == 'ü' || zeichen == 'Ü' ) {
                      zustand = 4;
                    } else {
                      fehlerNr = 1;
                    }
                    break;
            case 1: endzustand = true;
            case 2: if (zeichen >= '0' && zeichen <= '9') {
                      zustand = 3;
                    } else {
                      endzustand = true;
                    }
                    break;
            case 3: if (!(zeichen >= '0' && zeichen <= '9')) {
                      endzustand = true;
                    }
                    break;
            case 4: if (!( (zeichen >= '0' && zeichen <= '9') || (zeichen >= 'a' && zeichen <= 'z') || (zeichen >= 'A' && zeichen <= 'Z') ||
                            zeichen == 'ä' || zeichen == 'Ä' ||
                            zeichen == 'ö' || zeichen == 'Ö' ||
                            zeichen == 'ü' || zeichen == 'Ü' )) {
                      endzustand = true;
                    }
                    break;
            case 5: if (zeichen == '*') {
                      zustand = 6;
                    } else {
                      endzustand = true;
                    }
                    break;
            case 6: if (zeichen == '*') {
                      zustand = 7;
                    }
                    break;
            case 7: if (zeichen == '*') {
                      zustand = 7;
                    } else if (zeichen == '/') {
                      zeichenkette = "";
                      zustand = 0;
                    } else {
                      zustand = 6;
                    }
                    break;

          }
       } while ( (fehlerNr == 0) && (endzustand == false) && (zeichenLeser.endeErreicht() == false) );

       if (endzustand == true) {
         zeichenkette = zeichenkette.substring(0,zeichenkette.length()-1);
         zeichenLeser.zeichenWiederholen();
       }
       
       if (zeichenkette.length() > 0) {
         if (fehlerNr > 0) {
           zeichenkette = "??"; // dann Fehlertoken eintragen
         }
         int symbolIndex = symboltabelle.zeichenketteSuchenUndErweitern(zeichenkette);
         tokenliste.symbolAnfuegen(symbolIndex);
       }
     } while ( (fehlerNr == 0) && (zeichenLeser.endeErreicht() == false) );

     return fehlerNr;
   }
   
   
   
   /**
    * Methode zur Rückgabe einer Fehlermeldung
    * @param fehlerNr - int
    * @return Fehlermeldung als String
    */
   public String fehlermeldung(int fehlerNr) {
     switch (fehlerNr) {
       case 0: return "Alles OK";
       case 1: return "Syntaxfehler! Zeichen unbekannt!";
       case 2: return "zuviele Bezeichner verwendet, Symboltabelle platzt aus allen Nähten...";
       default: return "";
     }
   }
 }