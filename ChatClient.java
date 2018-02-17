/*
*Application Name: ChatClient.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class ChatClient{
	public ChatFrame gui;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	/**
	 Put appropriate comments here
	*/
	public ChatClient (String name, String server, int port) {
		// Create GUI and handle events:
		// After input, sendTextToChat is called,
		// when closing the window, disconnect is called.
		gui = new ChatFrame ("Client - " + name);
		gui.input.addKeyListener (new EnterListener (this, gui));
		gui.addWindowListener (new ExitListener(this));
		// Create a socket, register and listen to the server
		try{
			socket = new Socket(server, port); // Complete this statement
			in = new DataInputStream (socket.getInputStream());
			out = new DataOutputStream (socket.getOutputStream());
			out.writeUTF(name);
			out.flush();
			while (true){
				gui.output.append ("\n" + in.readUTF());
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 Put appropriate comments here
	*/
	protected void sendTextToChat (String str){
		try{
			out.writeUTF(str);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 Put appropriate comments here
	*/
	protected void disconnect() {
		try{
			socket.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 Put appropriate comments here
	*/
	public static void main (String args[]) {
		System.out.println ("Enter user name: ");
		String name = ConsoleIn.readlnWord();
		ChatClient c = new ChatClient (name, "127.0.0.1", 9090);
	}
}