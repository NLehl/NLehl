/**
 * Klasse f�r den gesmten Compiler. Dieser umfasst die Tokenliste, die
 * Symboltabelle und den Scanner. Sp�ter wird noch der Parser hinzukommen.
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */


 public class Compiler {
   // Datenfelder
   Tokenliste tokenliste;
   Symboltabelle symboltabelle;
   Scanner scanner;
   Parser parser;
   //Interpreter interpreter;
   
   // Konstruktoren
   public Compiler() {
     symboltabelle = new Symboltabelle();
     tokenliste = new Tokenliste(symboltabelle);
     scanner = new Scanner(tokenliste, symboltabelle);
     parser = new Parser(tokenliste);
     //interpreter = new Interpreter(tokenliste, symboltabelle);
   }
   
   // Methoden
   /**
    * Getter-Methode f�r den Scanner
    */
    public Scanner gibScanner() {
      return scanner;
    }
    
   /**
    * Getter-Methode f�r die Tokenliste
    */
    public Tokenliste gibTokenliste() {
      return tokenliste;
    }

   /**
    * Getter-Methode f�r die Symboltabelle
    */
    public Symboltabelle gibSymboltabelle() {
      return symboltabelle;
    }

   /**
    * Getter-Methode f�r den Parser
    */
    public Parser gibParser() {
      return parser;
    }
    
    
   /**
    * Getter-Methode f�r den Coder
    */
//    public Interpreter gibInterpreter() {
//      return interpreter;
//    }


 }