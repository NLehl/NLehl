import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/**
 *
 * Die GUI-Klasse zur Simulation des Compilers.
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version 03 Parser - Grundversion 2015-08-10
 */

public class CompilerGui extends JFrame {
  // Anfang Attribute
  Compiler compiler = new Compiler();
  
  private JLabel jLabel1 = new JLabel();

  
  private JTextField jtfTokenliste = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JButton jbScanner = new JButton();
  private JLabel jlScanner = new JLabel();
  private JMenuBar jmbMainmenu = new JMenuBar();
  private JMenu jmuDatei = new JMenu("Datei");
  private JMenuItem JMenuItem1 = new JMenuItem("Neu");
  private JMenuItem JMenuItem2 = new JMenuItem("÷ffnen");
  private JMenuItem JMenuItem3 = new JMenuItem("Speichern");
  private JMenuItem JMenuItem5 = new JMenuItem("Schlieﬂen");
  private JFileChooser jfcoOeffnen = new JFileChooser();
  private JLabel jlScannerText = new JLabel();
  private JFileChooser jfcsSpeichern = new JFileChooser();
  private JButton jbParser = new JButton();
  private JLabel jlParser = new JLabel();
  private JLabel jlParserText = new JLabel();
  private JTextArea jtaQuelltext = new JTextArea("");
  private JScrollPane jtaQuelltextScrollPane = new JScrollPane(jtaQuelltext);
  private JTextArea jtaSymboltabelle = new JTextArea("");
  private JScrollPane jtaSymboltabelleScrollPane = new JScrollPane(jtaSymboltabelle);
  private JButton jbInterpreter = new JButton();
  private JPanel jPanelAusgabe = new JPanel(null, true);
  private JLabel jLabel4 = new JLabel();
  // Ende Attribute

  public CompilerGui(String title) {
    // Frame-Initialisierung
    super (title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int frameWidth = 1000; 
    int frameHeight = 500;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(24, 16, 60, 20);
    jLabel1.setText("Quelltext:");
    jLabel1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel1);
    
    jtfTokenliste.setBounds(40, 360, 913, 24);
    jtfTokenliste.setText("");
    jtfTokenliste.setFont(new Font("Courier New", Font.PLAIN, 13));
    cp.add(jtfTokenliste);
    jLabel2.setBounds(336, 16, 90, 20);
    jLabel2.setText("Symboltabelle:");
    jLabel2.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel2);
    jLabel3.setBounds(40, 336, 67, 20);
    jLabel3.setText("Tokenliste:");
    jLabel3.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel3);
    jbScanner.setBounds(40, 392, 83, 25);
    jbScanner.setText("scannen");
    jbScanner.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    jbScanner_ActionPerformed(evt);
    }
    });
    cp.add(jbScanner);
    jlScanner.setBounds(136, 384, 31, 37);
    jlScanner.setText("---");
    jlScanner.setFont(new Font("Dialog", Font.PLAIN, 27));
    jlScanner.setForeground(Color.RED);
    cp.add(jlScanner);
    
    setJMenuBar(jmbMainmenu);
    jmbMainmenu.add(jmuDatei);
    jmuDatei.add(JMenuItem1);
    JMenuItem1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    JMenuItem1_ActionPerformed(evt);
    }
    });
    
    jmuDatei.add(JMenuItem2);
    JMenuItem2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    JMenuItem2_ActionPerformed(evt);
    }
    });
    
    jmuDatei.add(JMenuItem3);
    JMenuItem3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    JMenuItem3_ActionPerformed(evt);
    }
    });
    
    jmuDatei.addSeparator();
    jmuDatei.add(JMenuItem5);
    JMenuItem5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    JMenuItem5_ActionPerformed(evt);
    }
    });
    
    jlScannerText.setBounds(40, 424, 272, 20);
    jlScannerText.setText("-------------------------------------");
    jlScannerText.setFont(new Font("Dialog", Font.PLAIN, 13));
    jlScannerText.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jlScannerText);
    jbParser.setBounds(336, 392, 83, 25);
    jbParser.setText("parsen");
    jbParser.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    jbParser_ActionPerformed(evt);
    }
    });
    jbParser.setEnabled(false);
    cp.add(jbParser);
    jlParser.setBounds(432, 384, 31, 37);
    jlParser.setText("---");
    jlParser.setFont(new Font("Dialog", Font.PLAIN, 27));
    jlParser.setForeground(Color.RED);
    cp.add(jlParser);
    jlParserText.setBounds(336, 424, 280, 20);
    jlParserText.setText("-------------------------------------");
    jlParserText.setFont(new Font("Dialog", Font.PLAIN, 13));
    jlParserText.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jlParserText);
    jbParser.setFont(new Font("Dialog", Font.PLAIN, 13));
    jbScanner.setFont(new Font("Dialog", Font.PLAIN, 13));
    jtaQuelltextScrollPane.setBounds(24, 40, 300, 300);
    jtaQuelltext.setFont(new Font("Courier New", Font.BOLD, 12));
    jtaQuelltext.setText("Konstruktion test:\n  /* Beispiel */\n  Zeichne Punkt(100;100)\nEnde");
    cp.add(jtaQuelltextScrollPane);
    jtaSymboltabelleScrollPane.setBounds(336, 40, 300, 300);
    jtaSymboltabelle.setFont(new Font("Courier New", Font.BOLD, 12));
    cp.add(jtaSymboltabelleScrollPane);
    jbInterpreter.setBounds(648, 392, 155, 25);
    jbInterpreter.setText("interpretieren");
    jbInterpreter.setMargin(new Insets(2, 2, 2, 2));
    jbInterpreter.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    jbInterpreter_ActionPerformed(evt);
    }
    });
    jbInterpreter.setFont(new Font("Dialog", Font.PLAIN, 13));
    jbInterpreter.setEnabled(false);
    cp.add(jbInterpreter);
    jPanelAusgabe.setBounds(652, 40, 300, 300);
    jPanelAusgabe.setOpaque(false);
    cp.add(jPanelAusgabe);
    jLabel4.setBounds(656, 16, 110, 20);
    jLabel4.setText("Interpretation:");
    jLabel4.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel4);
    // Ende Komponenten
    
    setResizable(false);
    setVisible(true);
    update();
  }

  // Anfang Methoden

  /**
   * Methode zur Anzeige der Symboltabelle und Tokenliste
   */
  public void update() {
    jtfTokenliste.setText(""+compiler.gibTokenliste());
    jtaSymboltabelle.setText(""+compiler.gibSymboltabelle());
  }

  /**
   * Methode zum Scannen des Quelltextes
   */
  public void jbScanner_ActionPerformed(ActionEvent evt) {
    // Scannen
    compiler = new Compiler();
    int fehlerNr = compiler.gibScanner().scan(jtaQuelltext.getText());
    jlScanner.setText(""+fehlerNr);
    jlScannerText.setText(compiler.gibScanner().fehlermeldung(fehlerNr));
    if (fehlerNr == 0) {
      jbParser.setEnabled(true);
    }
    update();
  }

  /**
   * Methode zum Anfertigen eines neuen Quelltextes
   */
  public void JMenuItem1_ActionPerformed(ActionEvent evt) {
    // Datei|Neu
    jtaQuelltext.setText("Konstruktion test;\n  Kreis( Punkt(20;40) ; 10);\nEnde");
  }

  /**
   * Methode zum ÷ffnen eines Quelltextes
   */
  public void JMenuItem2_ActionPerformed(ActionEvent evt) {
    // Datei|÷ffnen
    String dateiname = jfcoOeffnenOpenFilename();
    if (dateiname != null) {
      jtaQuelltext.setText("");
      try {
        File datei = new File(dateiname);
        FileReader reader = new FileReader(datei);
        BufferedReader puffer = new BufferedReader(reader);
        String s = puffer.readLine();
        while (s != null) {
          jtaQuelltext.append(s+"\n");
          s = puffer.readLine();
        }
        reader.close();
      } catch (FileNotFoundException e) {
        System.out.println("Datei nicht vorhanden");
      } catch (IOException e) {
        System.err.println(e.toString());
      }
    }
  }

  /**
   * Methode zum Speichern eines Quelltextes
   */
  public void JMenuItem3_ActionPerformed(ActionEvent evt) {
    // Datei|Speichern
    String dateiname = jfcsSpeichernSaveFilename();
    if (dateiname != null) {
      
      try {
        File datei = new File(dateiname);
        FileWriter writer = new FileWriter(datei);
        writer.write(jtaQuelltext.getText());
        writer.close();
      } catch (FileNotFoundException e) {
        System.out.println("Datei nicht vorhanden");
      } catch (IOException e) {
        System.err.println(e.toString());
      }
    }
    
  }

  /**
   * Methode zum Verlassen des Programms
   */
  public void JMenuItem5_ActionPerformed(ActionEvent evt) {
    // Datei|Beenden
    System.exit(0);
  }

  /**
   * Methode zum Ausw‰hlen eines Filenamens zum ÷ffnen
   */
  public String jfcoOeffnenOpenFilename() {
    jfcoOeffnen.setDialogTitle("÷ffne Datei");
    jfcoOeffnen.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Verzeichnis auf aktuelles Projektverzeichnis setzen
    if (jfcoOeffnen.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      return jfcoOeffnen.getSelectedFile().getPath();
    } else {
      return null;
    }
  }

  /**
   * Methode zum Ausw‰hlen eines Filenamens zum Speichern
   */
  public String jfcsSpeichernSaveFilename() {
    jfcsSpeichern.setDialogTitle("Speichere Datei");
    jfcsSpeichern.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Verzeichnis auf aktuelles Projektverzeichnis setzen
    if (jfcsSpeichern.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
      return jfcsSpeichern.getSelectedFile().getPath();
    } else {
      return null;
    }
  }


  /**
   * Methode zum Parsen eines zuvor gescannten Quelltextes
   */
  public void jbParser_ActionPerformed(ActionEvent evt) {
    // Parsen
    int fehlerNr = compiler.gibParser().parse();
    jlParser.setText(""+fehlerNr);
    jlParserText.setText(compiler.gibParser().fehlermeldung(fehlerNr));
    if (fehlerNr == 0) {
      jbInterpreter.setEnabled(true);
    }
    update();
    
  }

  public void jbInterpreter_ActionPerformed(ActionEvent evt) {
    // Codieren
    //    jPanelAusgabe.getGraphics().drawImage(compiler.gibInterpreter().interpretieren(),0,0,null);
  }

  // Ende Methoden

  public static void main(String[] args) {
    new CompilerGui("CompilerGui");
  }
}
