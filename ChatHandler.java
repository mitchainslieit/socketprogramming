/*
*Application Name: ChatHandler.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.net.*;
import java.io.*;
import java.util.*;
public class ChatHandler extends Thread{
	public Socket socket; //Complete the declaration statement
	DataInputStream in;
	DataOutputStream out;
	String name;
	protected static Vector handlers = new Vector();
	 /**
	 Put appropriate comments here
	 */
	public ChatHandler (String name, Socket socket) throws IOException {
		this.name = name;
		this.socket = socket;
		in = new DataInputStream (new BufferedInputStream (socket.getInputStream()));
		out = new DataOutputStream (new BufferedOutputStream (socket.getOutputStream()));
	}
	 /**
	 Put appropriate comments here
	 */
	public void run () {
		try{
			broadcast (name + " entered");
			handlers.addElement (this);
			while (true) {
				String message = in.readUTF();
				broadcast (name + "> " + message);
			}
		} catch (IOException e) {
			System.out.println ("-- Connection to user lost.");
		}
		finally {
			handlers.removeElement (this);
			broadcast (name + " left");
			try{
				socket.close();
			}
			catch (IOException e) {
				System.out.println ("-- Socket to user already closed?");
			}
		}
	}
	 /**
	 Put appropriate comments here
	 */
	protected static void broadcast (String message){
		synchronized (handlers){
			Enumeration e = handlers.elements();
			while (e.hasMoreElements()) {
				ChatHandler handler = (ChatHandler) e.nextElement();
				try {
					handler.out.writeUTF (message);
					handler.out.flush();
				}
				catch (IOException ex) {
					handler.stop();
				}
			}
		}
	}
}