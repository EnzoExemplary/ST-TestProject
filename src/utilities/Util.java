package utilities;

import java.awt.Color;

import objects.enumeration.Direction;

public class Util 
{
	private static final Color PURPLE = new Color(102, 0, 153);
	private static final Color DARK_PURPLE = new Color (43, 0, 99);
	private static final Color LIME = new Color(219, 252, 3);
	private static final Color LIGHT_BLUE = new Color(187, 222, 240);
	private static final Color DARK_ORANGE = new Color(217, 112, 0);
	private static final Color BROWN = new Color(110, 58, 3);
	
	public static Color[] colorReference = {Color.WHITE, Color.BLACK, Color.RED, Color.GREEN, 
			Color.BLUE, Color.PINK, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.DARK_GRAY,
			PURPLE, DARK_PURPLE, LIME, LIGHT_BLUE, DARK_ORANGE, BROWN};

	public static Direction getDirection(Color color)
	{
		if(color.equals(BROWN) || color.equals(Color.RED) || color.equals(Color.CYAN) || color.equals(DARK_ORANGE))
		{
			return Direction.FORWARD;
		}else if(color.equals(Color.PINK) || color.equals(Color.ORANGE) || color.equals(Color.WHITE) || color.equals(Color.GREEN)
				|| color.equals(Color.MAGENTA) || color.equals(LIME) || color.equals(Color.YELLOW)){
			return Direction.RIGHT;
		}else{
			return Direction.LEFT;
		}
	}
	
	public static Color getColor(int i)
	{
		return colorReference[i % colorReference.length];
	}
}

