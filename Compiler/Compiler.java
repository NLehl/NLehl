/**
 * Klasse für den gesmten Compiler. Dieser umfasst die Tokenliste, die
 * Symboltabelle und den Scanner. Später wird noch der Parser hinzukommen.
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
    * Getter-Methode für den Scanner
    */
    public Scanner gibScanner() {
      return scanner;
    }
    
   /**
    * Getter-Methode für die Tokenliste
    */
    public Tokenliste gibTokenliste() {
      return tokenliste;
    }

   /**
    * Getter-Methode für die Symboltabelle
    */
    public Symboltabelle gibSymboltabelle() {
      return symboltabelle;
    }

   /**
    * Getter-Methode für den Parser
    */
    public Parser gibParser() {
      return parser;
    }
    
    
   /**
    * Getter-Methode für den Coder
    */
//    public Interpreter gibInterpreter() {
//      return interpreter;
//    }


 }