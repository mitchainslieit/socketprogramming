/*
*Application Name: ChatServer.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.net.*;
import java.io.*;
import java.util.*;
public class ChatServer{
	public ChatServer (int port) throws IOException {
			ServerSocket server = new ServerSocket (port); // Complete this statement
			System.out.println ("Waiting for clients...");
			while (true) {
			Socket client = server.accept();
			DataInputStream in = new DataInputStream (client.getInputStream());
			String name = in.readUTF();
			System.out.println ("New client " + name + "from " + client.getInetAddress());
			ChatHandler c = new ChatHandler(name, client);
			c. start();
		}
	}

	public static void main (String args[]) throws IOException{
		new ChatServer (1234);
	}
}
