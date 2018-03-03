/**
 * Description: This program allows both server and client to chat simultaneously using sockets.
 * @author GALATCHA, Mitch Ainslie V.
 * @author SALAZAR, Jerome Francis N.
 * @version 1.0, February 28, 2018
 */

import java.io.*;
import java.net.*;

public class  ClientS{

    public static Socket sock;
    public static BufferedReader read, receive2;
    public static String in = "", out = "";
    public static PrintWriter print;

	public static void main(String args[]) {
		try {
			sock = new Socket("127.0.0.1", 4040);
			read = new BufferedReader(new InputStreamReader(System.in));
			receive2 = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			print = new PrintWriter(sock.getOutputStream(), true);
			in = "Hello Server!";
			print.println(in);
			print.flush();
			System.out.println("Waiting for Server's reply...");
			while (true) {
				out = receive2.readLine();
				if (out!= null) {
					System.out.println("Server: " + out);
				}
				System.out.print("Enter your chat: ");
				in = read.readLine();
				print.println(in);
				print.flush();
				System.out.println("Waiting for Server's reply...");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}