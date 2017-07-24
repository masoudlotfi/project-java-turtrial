import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Listener extends Thread {
	private ServerSocket serverSocket;

	public Listener(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run() {
		while (true) {
			Socket server= null;
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				server = serverSocket.accept();

				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());

				String incomeString = in.readUTF();
				if (incomeString.toLowerCase().compareTo("quit") == 0) {
					server.close();
					break;
				}

				
				long number = Long.parseLong(incomeString);

				System.out.println("income= " + number);
				long result = Fibonacci.calc(number);
				System.out.println("result= " + number);
				out.writeLong(result);

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
			} catch (IOException e) {
				e.printStackTrace();
				try {
					server.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
	}
}