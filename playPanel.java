//This class is where the game is actually paid

import javax.swing.*; //to use JComponents
import java.awt.*; //to use Color and Graphics
import java.awt.event.*; //to use event listeners


public class playPanel extends JPanel
{
	//instance variables
	private Timer timer;
	//RECTANGLES
	final int width, length, x1, x2; //length and width of rectangles
	private int y1, y2; //starting y-coordinates for rect1 and rect2

	//BALL
	final int ballDiameter;
	private int stepX, stepY; //increment by which the ball moves
	private int circX, circY; //starting x and y coordinates of ball
	
	
	//constructor
	public playPanel()
	{
		//RECTANGLES -- FIXED VARIABLES
		width = 25;
		length = 100;
		x1 = 50;
		x2 = 400;
		
		//Adjustable coordinates
		y1 =50; //starting coordinate for rect1
		y2 = 50; //starting coordinate for rect2
		
		
		
		//BALL
		ballDiameter = 25;
		circX = 100;
		circY = 50;
		stepX = 10;
		stepY = 1;
		
		
		timer = new Timer(50, new BallListener());
		addKeyListener(new RectListener());
		this.setFocusable(true); //Focusable components can use keyListener
		timer.start();
		
	}//end of constructor
	
	//paintComponent
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		setBackground(Color.black);
		
		page.setColor(Color.red);
		
		//Rectangle 1
		Rectangle rect1 = new Rectangle(x1, y1, width, length);
		rect1.draw(page);
		
		//Rectangle 2
		Rectangle rect2 = new Rectangle (x2, y2, width, length);
		rect2.draw(page);
		
		page.drawLine(250, 0, 250, 300);
		
		
		//Ball
		page.setColor(Color.yellow);
		page.fillOval(circX, circY, ballDiameter, ballDiameter);
	}//end of paintComponent
	
	//KeyListener class
	private class RectListener implements KeyListener
	{
		public void keyPressed (KeyEvent event)
		{
			switch(event.getKeyCode())
			{
				case KeyEvent.VK_UP:
					y2 -= 20; //moves up
					break;
				case KeyEvent.VK_DOWN:
					y2 += 20; //moves down
					break;
				case KeyEvent.VK_W:
					y1 -= 20;
					break;
				case KeyEvent.VK_S:
					y1 += 20;
					break;
			}//end of switch
			repaint(); //calls paintComponent indirectly
		}
		
		public void keyReleased(KeyEvent event) {}
		public void keyTyped (KeyEvent event) {}
	}//end of KeyListener class
	
	//ballListener class
	private class BallListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			circX += 10; //moves ball left
			circY += 1; //moves ball down
			
			if (circY <= 0) //if hits top border
			{
				stepY = stepY * -1;
			}
			
			//if ball hits height of rect1
			if (  (y1 <= circY) || (  (circY + ballDiameter) <= (y1 + length)  )  )
			{
				if ((x1 + width) <= circX) //if hits the width of the rect1
				{
					stepX = stepX * -1;
				}
			}
			
			//if ball hits height of rect2
			if (   (y2 <= circY) || (  (circY + ballDiameter)  <= (y2 + length)   )   )
			{
				if (  (circX + ballDiameter) >= x2  )
				{
					stepX = stepX * -1;
				}
			}
			repaint();
			
		} //end of actionPerformed method
	}//end of BallListener class
	
}//end of playPanel class