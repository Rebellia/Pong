import java.awt.*; //To use the Graphics class

public class Rectangle
{
	//instance variables
	private int x, y, width, height;
	
	//constructor
	public Rectangle(int x1, int y1, int width, int height)
	{
		x = x1;
		y = y1;
		this.width = width;
		this.height = height;
	}//end of constructor
	
	public void draw (Graphics page)
	{
		page.fillRect(x, y, width, height);
	}
}//end of class