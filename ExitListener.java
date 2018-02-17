/*
*Application Name: ExitListener.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.awt.event.*;
public class ExitListener extends WindowAdapter{
	ChatClient client;
	public ExitListener (ChatClient client) {
		this.client = client;
	}
	/**
	 Put appropriate comments here
	 */
	public void windowClosing (WindowEvent e) {
		client.disconnect ();
		System.exit(0);
	}
}