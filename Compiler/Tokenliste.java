/**
 * Klasse f�r eine Tokenliste, welche die Lineare Liste des Zentralabiturs nutzt.
 * In der Liste werden lediglich die Indizes der Tokens gespeichert. �ber die
 * Symboltabelle k�nnen dann alle Informaitonen des Tokens ausgelesen werden.
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
    * Methode zum Einf�gen eines neuen Tokenindex in die Tokenliste
    * @param index - der Index der Symboltabelle, zu dem das einzuf�gende Token geh�rt
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
    * Methode zum Pr�fen, ob die Tokenliste bis zum Ende durchlaufen wurde
    * @return wahr, wenn die Liste komplett durchlaufen wurde
    */
   public boolean istAmEnde() {
     return !liste.hasAccess();
   }
   
   /**
    * Methode zum Pr�fen, ob die Tokenliste leer ist
    * @return wahr, wenn die Tokenliste leer ist.
    */
   public boolean istLeer() {
     return liste.isEmpty();
   }
   
   
   /**
    * Methode, welche das n�chste zu verarbeitende Token aus der Tokenliste zur�ckgibt
    * und dann in der Tokenliste ein Symbol weiterl�uft
    * @return das n�chste Symbol als int
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
    * Methode zur R�ckgabe der Symboltabelle als String
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 