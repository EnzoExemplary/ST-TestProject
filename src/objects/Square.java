package objects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import objects.enumeration.Direction;
import utilities.Util;

public class Square extends JLabel
{
	private Color color;
	private int posX;
	private int posY;
	private int colorNum;
	
	public Square(int posX, int posY)
	{		
		this.posX = posX;
		this.posY = posY;
		colorNum = 0;
		color = Util.getColor(colorNum);
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(color);

		if(getWidth() != 0 || getHeight() != 0)
		{
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY; 
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Direction getDirection()
	{
		return Util.getDirection(color);
	}
	
	public void iterateColor()
	{
		colorNum++;
		color = Util.getColor(colorNum);
		repaint();
	}
	
	public void setSquareColor(Color color)
	{
		if(color != null)
		{
			this.color = color;
		}
	}
}
