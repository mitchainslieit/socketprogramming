import java.io.*;
import java.net.*;

public class ServerS {

    public static Socket sock;
    public static BufferedReader read1, receive2;
    public static String in = "", out = "";
    public static PrintWriter print;

	public static void main(String args[]) {
		try {
			read1 = new BufferedReader(new InputStreamReader(System.in));
			ServerSocket newSocket = new ServerSocket(4040);
			System.out.println("Waiting for the Client ...");
			sock = newSocket.accept();
			System.out.println("A client has connected!");
			print = new PrintWriter(sock.getOutputStream(), true);
			while (true) {
				receive2 = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = receive2.readLine();
				if (out != null) {
					System.out.println("Client: " + out);
				}
				System.out.print("Enter your chat: ");
				in = read1.readLine();
				print.println(in);
				print.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}