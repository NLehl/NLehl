/**
 * Klasse für den Zeichenleser, der Zeichen für Zeichen den Quelltext lesen kann.
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */

public class ZeichenLeser {
  // Datenfelder
  private String zeichenkette;
  private int position;
  
  // Konstruktoren
  public ZeichenLeser(String zeichenkette) {
    this.zeichenkette = zeichenkette;
    position = 0;
  }
  
  // Methoden

  /**
   * Methode, um an den Anfang des Quelltextes zu wandern.
   */
  public void zumAnfang() {
    position = 0;
  }
  
  /**
   * Methode, um ein zuviel gelesenes Zeichen nochmals lesen zu lassen.
   */
  public void zeichenWiederholen() {
    position--;
  }
  
  /**
   * Methode zur Rückgabe eines Zeichens
   * @return Zeichen als char
   */
  public char gibZeichen() {
    int pos = position;
    position++;
    return zeichenkette.charAt(pos);
  }
  
  /**
   * Methode zur Feststellung, ob das Ende des Quelltextes bereits erreicht ist.
   * @return wahr, falls das Ende des Quelltextes erreicht ist.
   */
  public boolean endeErreicht() {
    return (position >= zeichenkette.length());
  }
}