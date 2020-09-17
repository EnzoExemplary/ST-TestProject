package display;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import objects.Square;
import objects.enumeration.Direction;
import objects.enumeration.DirectionFacing;

@SuppressWarnings("serial")
public class PatternPanel extends JPanel
{
	private Collection<Square> squares;
	private final int GRID_ROWS = 121;
	private final int GRID_COLUMNS = 121;
	private final int TOTAL_GRIDS = GRID_ROWS*GRID_COLUMNS;
	private AppFrame appFrame;
	private int X;
	private int Y;
	
	private DirectionFacing facing;
	
	public PatternPanel(AppFrame appFrame)
	{
		setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		squares = new ArrayList<Square>();
		this.appFrame = appFrame;
		facing = DirectionFacing.UP;
		resetXY();
		
		populateGrids();
	}
	
	public void drawLine()
	{
		appFrame.setEnabledStartButton(false);
		for(int i = 1; i <= GRID_ROWS; i++)
		{
			setGridColor(Color.GREEN, i, 20);
		}
		appFrame.setEnabledStartButton(true);
	}
	
	public boolean updateGrid()
	{
		try {
			Thread.sleep(1);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
		for(Square square : squares)
		{
			if(square.getPosX() == X && square.getPosY() == Y)
			{
				square.iterateColor();
				setXY(square.getDirection());
			}
		}
		
		if(X == -1 || Y == -1 || X == GRID_ROWS || Y == GRID_COLUMNS)
		{
			return false;
		}else{
			return true;
		}
	}
	
	public void setGridColor(Color color, int posX, int posY)
	{
		try {
			Thread.sleep(100);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
		int x = posX - 1;
		int y = posY - 1;
		for(Square square : squares)
		{
			if(square.getPosX() == x && square.getPosY() == y)
			{
				square.setSquareColor(color);
				square.repaint();
				square.revalidate();
			}
		}
		repaint();
		revalidate();
	}
	
	public void resetXY()
	{
		X = GRID_ROWS/2 + 1;
		Y = GRID_ROWS/2 + 1;
	}
	
	private void populateGrids()
	{
		int posX = 0;
		int posY = 0;
		
		for(int i = 0; i < TOTAL_GRIDS; i++)
		{
			Square square = new Square(posX, posY);
			add(square);
			squares.add(square);
			repaint();
			revalidate();
			
			if(posX < GRID_ROWS-1)
			{
				posX++;
			}else{
				posX = 0;
				posY++;
			}
		}
	}
	
	private void setXY(Direction direction)
	{
		if(facing.equals(DirectionFacing.UP))
		{
			if(direction.equals(Direction.LEFT))
			{
				X += -1;
				facing = DirectionFacing.LEFT;
			}else if(direction.equals(Direction.RIGHT)){
				X += 1;
				facing = DirectionFacing.RIGHT;
			}else{
				Y += 1;
				facing = DirectionFacing.UP;
			}
		}else if(facing.equals(DirectionFacing.LEFT)){
			if(direction.equals(Direction.LEFT))
			{
				Y += -1;
				facing = DirectionFacing.DOWN;
			}else if(direction.equals(Direction.RIGHT)){
				Y += 1;
				facing = DirectionFacing.UP;
			}else{
				X += -1;
				facing = DirectionFacing.LEFT;
			}
		}else if(facing.equals(DirectionFacing.RIGHT)){
			if(direction.equals(Direction.LEFT))
			{
				Y += 1;
				facing = DirectionFacing.UP;
			}else if(direction.equals(Direction.RIGHT)){
				Y += -1;
				facing = DirectionFacing.DOWN;
			}else{
				X += 1;
				facing = DirectionFacing.RIGHT;
			}
		}else{
			if(direction.equals(Direction.LEFT))
			{
				X += 1;
				facing = DirectionFacing.RIGHT;
			}else if(direction.equals(Direction.RIGHT)){
				X += -1;
				facing = DirectionFacing.LEFT;
			}else{
				Y += -1;
			}
		}
	}
}
