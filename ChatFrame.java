/*
*Application Name: ChatFrame.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.awt.*;
public class ChatFrame extends Frame{
	protected TextArea output;
	protected TextField input;
	/**
	Put appropriate comments here
	*/
	public ChatFrame (String title){
		super (title);
		setLayout (new BorderLayout());
		add ("Center", output = new TextArea());
		output.setEditable (false);
		add ("South", input = new TextField());
		pack();
		show();
		input.requestFocus();
	}
	/**
	Put appropriate comments here
	*/
	public static void main(String args[]) {
		new ChatFrame("Chat");
	}
}
