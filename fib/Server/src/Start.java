import java.io.IOException;

public class Start {

	public static void main(String[] args) {
		try {
			Thread t = new Listener(5083);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
