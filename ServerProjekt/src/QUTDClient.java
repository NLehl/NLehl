import javax.swing.JOptionPane;

public class QUTDClient extends Client{
	public QUTDClient(String serverIP) {
		super(serverIP, 17);
	}

	@Override
	public void processMessage(String message) {s
		JOptionPane.showMessageDialog(null, "Server sendet:\n"
															+message);
		
	}
	/*public static void main(String[] args) {
		QUTDClient client = new QUTDClient("djxmmx.net");
	}*/
}
