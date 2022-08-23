import javax.swing.JOptionPane;
public class TCPIPConnection extends Connection {

  public TCPIPConnection(String pServerIP, int pServerPort)   {
    super(pServerIP, pServerPort);
  }

  public void servernachrichtAusgeben() {
    JOptionPane.showMessageDialog(null,"Server sendet:\n" 
 +receive());
  }
}
