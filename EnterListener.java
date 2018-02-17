/*
*Application Name: EnterListener.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.awt.event.*;
public class EnterListener extends KeyAdapter{
	ChatClient client;
	ChatFrame gui;
	/**
	Put appropriate comments here
	*/
	public EnterListener (ChatClient client, ChatFrame gui) {
		this.client = client;
		this.gui = gui;
	}
	/**
	Put appropriate comments here
	*/
	public void keyPressed (KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			client.sendTextToChat (gui.input.getText());
			gui.input.setText("");
		}
	}
}
