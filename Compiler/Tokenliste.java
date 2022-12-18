/**
 * Klasse für eine Tokenliste, welche die Lineare Liste des Zentralabiturs nutzt.
 * In der Liste werden lediglich die Indizes der Tokens gespeichert. Über die
 * Symboltabelle können dann alle Informaitonen des Tokens ausgelesen werden.
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */

 public class Tokenliste {
   // Datenfelder
   private List<Integer> liste;
   private Symboltabelle symboltabelle;
   
   // Konstruktoren
   public Tokenliste(Symboltabelle pTabelle) {
     liste = new List<Integer>();
     this.symboltabelle = pTabelle;
   }
   
   // Methoden

   /**
    * Methode zum Einfügen eines neuen Tokenindex in die Tokenliste
    * @param index - der Index der Symboltabelle, zu dem das einzufügende Token gehört
    */
   public void symbolAnfuegen(int pSymbolindex) {
     liste.append(new Integer(pSymbolindex));
   }
   
   /**
    * Methode zum navigieren an den Anfang der Tokenliste
    */
   public void zumAnfang() {
     liste.toFirst();
   }
   
   /**
    * Methode zum Prüfen, ob die Tokenliste bis zum Ende durchlaufen wurde
    * @return wahr, wenn die Liste komplett durchlaufen wurde
    */
   public boolean istAmEnde() {
     return !liste.hasAccess();
   }
   
   /**
    * Methode zum Prüfen, ob die Tokenliste leer ist
    * @return wahr, wenn die Tokenliste leer ist.
    */
   public boolean istLeer() {
     return liste.isEmpty();
   }
   
   
   /**
    * Methode, welche das nächste zu verarbeitende Token aus der Tokenliste zurückgibt
    * und dann in der Tokenliste ein Symbol weiterläuft
    * @return das nächste Symbol als int
    */
   public Token naechstesToken() {
     if (liste.hasAccess()) {
       Integer tokenIndex = liste.getContent();
       liste.next();
       return symboltabelle.tokenVonIndex(tokenIndex);
     } else {
       return new Token(Token.leer,"");
     }
   }
   
   /**
    * Methode zur Rückgabe der Symboltabelle als String
    * @return Tokenliste als String
    */
   public String toString() {
     String s = "";
     for (liste.toFirst(); liste.hasAccess(); liste.next()) {
       s = s + liste.getContent()+"->";
     }
     return s+"null";
   }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 