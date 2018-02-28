import java.io.*;
import java.net.*;

public class  ClientS{

    public static Socket sock;
    public static BufferedReader read1, receive2;
    public static String in = "", out = "";
    public static PrintWriter print;

	public static void main(String args[]) {
		try {
			sock = new Socket("127.0.0.1", 4040);
			read1 = new BufferedReader(new InputStreamReader(System.in));
			receive2 = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			print = new PrintWriter(sock.getOutputStream(), true);
			while (true) {
				System.out.print("Enter your chat: ");
				in = read1.readLine();
				print.println(in);
				print.flush();
				out = receive2.readLine();
				if (out!= null) {
					System.out.println("Server: " + out);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}