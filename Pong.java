import javax.swing.*; //to use JComponents
import java.awt.*;
import java.awt.event.*;

public class Pong
{
	public static void main(String[] args)
	{
		JFrame pongFrame = new JFrame();
		playPanel game = new playPanel();
		
		pongFrame.add(game);
		pongFrame.setSize(500, 300);
		pongFrame.setResizable(false);
		pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pongFrame.setVisible(true);
	}//end of main method
	
}//end of class