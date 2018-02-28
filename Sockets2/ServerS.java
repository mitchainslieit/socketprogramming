/**
 * Description: This program allows both server and client to chat simultaneously using sockets.
 * @author GALATCHA, Mitch Ainslie V.
 * @author SALAZAR, Jerome Francis N.
 * @version 1.0, February 28, 2018
 */

import java.io.*;
import java.net.*;

public class ServerS {

    public static Socket sock;
    public static BufferedReader read, receive2;
    public static String in = "", out = "";
    public static PrintWriter print;

	public static void main(String args[]) {
		try {
			read = new BufferedReader(new InputStreamReader(System.in));
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
				in = read.readLine();
				print.println(in);
				print.flush();
				System.out.println("Waiting for reply...");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}