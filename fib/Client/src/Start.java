
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Start {
	public static void main(String[] args) {
		String inputStr = "";
		long inputLong = 0;

		while (true) {

			try {
				Socket client = new Socket("localhost", 5083);

				OutputStream outToServer = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				inputStr = JOptionPane.showInputDialog("Enter number for calculating its Fibonacci or 'q' for exit:");
				if (inputStr.toLowerCase().equals("q")) {
					out.writeUTF("quit");
					break;
				}
				if (inputStr.matches("\\d*")) {

					out.writeUTF(inputStr);

					InputStream inFromServer = client.getInputStream();
					DataInputStream in = new DataInputStream(inFromServer);
					long result = in.readLong();

					JOptionPane.showMessageDialog(null, "Result = " + result);
				} else {
					JOptionPane.showMessageDialog(null, "incorrect input");
				}
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
