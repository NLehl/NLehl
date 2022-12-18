/**
 * Klasse für ein einzelnes Token. Gespeichert wird hier lediglich der Tokentyp
 * und die zugehörige Zeichenkette. Sinnvollerweise könnten hier Informationen
 * über den Typ z. B. eines Bezeichners oder Speicherinformationen abgelegt werden
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */

 public class Token {
   // Datenfelder
   
   private String zeichenkette;
   private int symbol;
   private Object speicher;
   private int typ;
   
   public static final int leer =         0;
   public static final int konstruktion = 1;
   public static final int zeichne =      2;
   public static final int punkt =        3;
   public static final int ende =         4;
   public static final int doppelpunkt =  5;
   public static final int semikolon =    6;
   public static final int klammerauf =   7;
   public static final int klammerzu  =   8;
   public static final int punktop =      9;
   public static final int strichop =     10;
   public static final int name =         11;
   public static final int zahl =         12;
   

   
   // Konstruktoren
   public Token() {
     symbol = leer;
     zeichenkette = "";
     speicher = null;
     typ = leer;
   }
   
   public Token(int pSymbol, String pZeichenkette) {
     this.symbol = pSymbol;
     this.zeichenkette = pZeichenkette;
   }
   
   //Methoden

   /**
    * Methode zum setzen der Speicherinformationen
    * @param speicher die Adresse, an der das Objekt liegt
    * @param typ der Typ des Objekts
    */
   public void setzeSpeicherinformationen(Object pSpeicher, int pTyp) {
     speicher = pSpeicher;
     typ = pTyp;
   } 
    
   /**
    * Methode, welche das Symbol als int zurückgibt
    * @return das entsprechende Symbol als int
    */
   public int gibSymbol() {
     return symbol;
   }
   
   /**
    * Methode, welche die entsprechende Zeichenkette zurückgibt
    * @return die entsprechende Zeichenkette
    */
   public String gibZeichenkette() {
     return zeichenkette;
   }
   
   /**
    * Methode, welche das evtl. vorhandene Objekt zurückgibt
    * @return das entsprechende Objekt
    */
   public Object gibSpeicher() {
     return speicher;
   }
   
   /**
    * Methode, welche die evtl. vorhandene Typinformation zurückgibt
    * @return die entsprechende Typinformation
    */
   public int gibTyp() {
     return typ;
   }
   
   /**
    * Methode zur Rückgabe eines Tokens als String
    * @return Token als String
    */
   public String toString() {
     String s = "";
     switch (symbol) {
       case leer: s = "leer"; break;
       case konstruktion: s = "konstruktion"; break;
       case name: s = "name"; break;
       case doppelpunkt: s = "doppelpunkt"; break;
       case semikolon: s = "semikolon"; break;
       case ende: s = "ende"; break;
       case klammerauf: s = "klammerauf"; break;
       case klammerzu: s = "klammerzu"; break;
       case punkt: s = "punkt"; break;
       case punktop: s = "punktop"; break;
       case strichop: s = "strichop"; break;
       case zahl: s = "zahl"; break;
       case zeichne: s = "zeichne"; break;
       default: s = "";
     }
     
     s = s + "                             ".substring(0,15-s.length())+zeichenkette;
     return s;
   }
 }